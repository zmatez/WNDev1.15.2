package com.matez.wildnature.world.generation.processors;

import com.matez.wildnature.world.generation.biomes.setup.WNGenSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;

import java.util.Random;

public class ThermalErosionProcessor implements TerrainProcessor {
    // Size of the heightMap (N * N)
    private int size = 16;
    // Slope at which it erodes
    private final double threshold = 0.6f;
    // Amount of sediment displacement [0.05, 0.1]
    private final double amplitude = 0.8f;

    private ChunkGenerator<WNGenSettings> generator;
    private BlockState DEFAULT_FLUID;
    private static final int[] vertexData = new int[]{0, 1, 1, 1, 1, 0, 1, -1, 0, -1, -1, -1, -1, 0, -1, 1};

    @Override
    public void init(ChunkGenerator<WNGenSettings> generator, long seed) {
        this.generator = generator;
        this.DEFAULT_FLUID = generator.getSettings().getDefaultFluid();
    }

    private IChunk[] getNeighbours(IWorld world, int x, int z) {
        // Left, Up, Right, Down (diagonals in-between)
        return new IChunk[]{
                world.getChunk(x - 1, z),
                world.getChunk(x - 1, z + 1),
                world.getChunk(x, z + 1),
                world.getChunk(x + 1, z + 1),
                world.getChunk(x + 1, z),
                world.getChunk(x + 1, z - 1),
                world.getChunk(x, z - 1),
                world.getChunk(x - 1, z - 1),
        };
    }

    // Gets the k-th neighbour to (x, z)
    private int[] next(int x, int z, int k) {
        return new int[]{vertexData[2 * k] + x, vertexData[2 * k + 1] + z};
    }

    // Wraps a position to adjacent chunks
    private int[] wrapPosition(int x, int z, IChunk[] borders) {
        int k = -1;

        if (x < 0) {
            if (z < 0) {
                k = 7;
                z = size - 1;
            } else if (z >= size) {
                k = 1;
                z = 0;
            } else {
                k = 0;
            }
            x = size - 1;
        } else if (x >= size) {
            if (z < 0) {
                k = 5;
                z = size - 1;
            } else if (z >= size) {
                k = 3;
                z = 0;
            } else {
                k = 4;
            }
            x = 0;
        } else if (z < 0) {
            k = 6;
            z = size - 1;
        } else if (z >= size) {
            k = 2;
            z = 0;
        }

        return new int[]{k, x, z};
    }

    private int[] applyAmplitude(int fX, int fZ, int tX, int tZ, int k, IChunk[] borders, int[] noise) {
        noise[fX * size + fZ] += amplitude;

        if (k != -1) {
            //int tY = borders[k].getTopBlockY(Heightmap.Type.WORLD_SURFACE_WG, tX, tZ);
            int tY = noise[tX * 16 + tZ];
            BlockPos displacementPos = new BlockPos(tX, tY, tZ);
            // Erode the chunk border
            if (tY <= 63) {
                borders[k].setBlockState(displacementPos, DEFAULT_FLUID, false);
            } else {
                borders[k].setBlockState(displacementPos, Blocks.AIR.getDefaultState(), false);
            }
        } else {
            noise[tX * size + tZ] -= amplitude;
        }

        return noise;
    }

    // A single thermal step in the erosion.
    // O(256 * 8)
    private int[] thermalStep(IChunk chunkIn, IChunk[] borders, int[] noise) {
        for (int x = 0; x < size; ++x) {
            for (int z = 0; z < size; ++z) {
                int val = noise[x * size + z];
                int xSlope = -1, zSlope = -1;
                double maxZDiff = -1;
                int kthBorder = -1;

                for (int k = 0; k < 8; k++) {
                    int height = -1;

                    int[] nextVals = next(x, z, k);
                    int xn = nextVals[0];
                    int zn = nextVals[1];
                    if (xn < 0 || xn >= size || zn < 0 || zn >= size) {
                        int[] wrappedData = wrapPosition(xn, zn, borders);
                        kthBorder = wrappedData[0];
                        xn = wrappedData[1];
                        zn = wrappedData[2];
                        height = borders[kthBorder].getTopBlockY(Heightmap.Type.WORLD_SURFACE_WG, xn, zn);
                    }

                    // If we don't know the height, it is inside the current chunk, not an adjacent one
                    if (height == -1) {
                        height = noise[xn * size + zn];
                    }
                    double zDiff = val - height;

                    if (zDiff > 0.0f && zDiff > maxZDiff) {
                        maxZDiff = zDiff;
                        xSlope = xn;
                        zSlope = zn;
                    }
                }
                // Δy / Δx ≡ slope
                if (maxZDiff / (x - xSlope) > threshold) {
                    applyAmplitude(xSlope, zSlope, x, z, kthBorder, borders, noise);
                }
            }
        }

        // Pass it out of scope so it updates
        return noise;
    }

    @Override
    // O(256 * 8 * n) where n is the number of iterations
    public void process(IWorld world, Random rand, int chunkX, int chunkZ, int[] noise) {
        IChunk chunkIn = world.getChunk(chunkX, chunkZ);
        // Bordering chunks (to modify)
        IChunk[] borders = getNeighbours(world, chunkX, chunkZ);

        int iterations = 3000;
        for (int i = 0; i < iterations; i++) {
            thermalStep(chunkIn, borders, noise);
        }


        BlockPos.Mutable pos = new BlockPos.Mutable();
        for (int x = 0; x < size; x++) {
            for (int z = 0; z < size; z++) {
                for (int y = noise[x * 16 + z]; y < 256; y++) {
                    pos.setPos(x,y,z);

                    if (y <= 63) {
                        chunkIn.setBlockState(pos, DEFAULT_FLUID, false);
                    } else {
                        chunkIn.setBlockState(pos, Blocks.AIR.getDefaultState(), false);
                    }
                }
            }
        }
    }
}
