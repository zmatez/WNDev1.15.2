package com.matez.wildnature.world.generation.processors;

import com.matez.wildnature.world.generation.biome.setup.WNGenSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;

import java.util.Random;

public class ThermalErosionTestProcessor implements TerrainProcessor {
    public int size = 16;
    private final float threshold = 0.6f;
    private final double amplitude = 0.8f;

    private BlockState DEFAULT_FLUID;
    private ChunkGenerator<WNGenSettings> generator;

    @Override
    public void init(ChunkGenerator<WNGenSettings> generator, long seed) {
        this.generator = generator;
        this.DEFAULT_FLUID = generator.getSettings().getDefaultFluid();
    }

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
    private void thermalStep(IChunk chunkIn, int x, int z, int[] noise) {
        int val = noise[x * size + z];
        int slopeX = -1, slopeZ = -1;
        float maxZDiff = -1;

        for (int k = 0; k < 8; k++) {
            int[] nextVals = next(x, z, k);
            int xn = nextVals[0];
            int zn = nextVals[1];
            if (xn < 0 || xn >= size || zn < 0 || zn >= size) {
                continue;
            }

            float zDiff = val - noise[xn * size + zn];
            if (zDiff > 0.0f && zDiff > maxZDiff) {
                maxZDiff = zDiff;
                slopeX = xn;
                slopeZ = zn;
            }
        }
        // Δy / Δx ≡ slope
        if (maxZDiff / (x - slopeX) > threshold) {
            applyAmplitude(chunkIn,slopeX,slopeZ,x,z,noise);
        }
        if (maxZDiff / (z - slopeZ) > threshold) {
            applyAmplitude(chunkIn,slopeX,slopeZ,x,z,noise);
        }
    }

    private int[] applyAmplitude(IChunk chunk, int fX, int fZ, int tX, int tZ, int[] noise) {
        //noise[fX * size + fZ] += amplitude;

        BlockPos pos = new BlockPos(tX, noise[tX * size + tZ], tZ);
        if (chunk.getBlockState(pos) != DEFAULT_FLUID) {
            chunk.setBlockState(pos, Blocks.AIR.getDefaultState(), false);
        }

        return noise;
    }

    @Override
    // O(256 * 8 * n) where n is the number of iterations
    public void process(IWorld world, IChunk chunk, Random rand, int chunkX, int chunkZ,int relativeX, int relativeZ, int[] noise) {
        int iterations = 1_000;
        for (int i = 0; i < iterations; i++) {
            thermalStep(chunk, relativeX, relativeZ, noise);
        }
    }
}