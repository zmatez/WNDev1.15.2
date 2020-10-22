package com.matez.wildnature.world.generation.processors;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.IChunk;

import java.util.Random;

public class ThermalErosionProcessor implements TerrainProcessor {
    private int size = 16;
    private final float threshold = 0.6f;

    @Override
    public void init(long seed) {}

    // Gets the k-th neighbour to (x, z)
    private int[] next(int x, int z, int k) {
        int[][] storedData = new int[9][2];
        int i = 0;

        for (int xo = -1; xo <= 1; xo++) {
            for (int zo = -1; zo <= 1; zo++) {
                storedData[i++] = new int[]{x + xo, z + zo};
            }
        }

        return storedData[k];
    }

    // A single thermal step in the erosion.
    // O(256 * 8)
    private void thermalStep(IChunk chunkIn, int[] noise) {
        for (int x = 0; x < size; ++x) {
            for (int z = 0; z < size; ++z) {
                int val = noise[x * size + z];
                int xs, zs;
                float ss = -1;
                float si = -1;

                for (int k = 0; k < 8; k++) {
                    int[] nextVals = next(x, z, k);
                    int xn = nextVals[0];
                    int zn = nextVals[1];
                    if (xn < 0 || xn >= size || zn < 0 || zn >= size) {
                        continue;
                    }

                    float zDiff = val - noise[xn * size + zn];
                    if (zDiff > 0.0f && zDiff > ss) {
                        ss = zDiff;
                        xs = xn;
                        zs = zn;
                        si = xs * 16 + zs;
                    }
                }

                if (ss / (size * noise[(int) si]) > threshold) {
                    BlockPos pos = new BlockPos(x, noise[x * size + z], z);
                    if (chunkIn.getBlockState(pos) != Blocks.WATER.getDefaultState()) {
                        chunkIn.setBlockState(pos, Blocks.AIR.getDefaultState(), false);
                    }
                }
            }
        }
    }

    @Override
    // O(256 * 8 * n) where n is the number of iterations
    public void process(IChunk chunkIn, Random rand, int chunkX, int chunkZ, int[] noise) {
        int iterations = 300;
        for (int i = 0; i < iterations; i++) {
            thermalStep(chunkIn, noise);
        }
    }
}
