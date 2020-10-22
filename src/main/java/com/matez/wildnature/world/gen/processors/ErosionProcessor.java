package com.matez.wildnature.world.gen.processors;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.chunk.generation.WNSimplexChunkGenerator;
import com.matez.wildnature.world.gen.noise.OctaveNoiseSampler;
import com.matez.wildnature.world.gen.noise.OpenSimplexNoise;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;

import java.util.Random;

public class ErosionProcessor implements TerrainProcessor {
    private OctaveNoiseSampler sampler;
    protected final int size = 16;

    @Override
    public void init(long seed) {
        sampler = new OctaveNoiseSampler<>(OpenSimplexNoise.class, new Random(seed), 4, 128.0, 6.0, 8.0);
    }

    // Applies some Gaussian Blur to the heightMap
    private int[] gaussianBlur(int[] values) {
        int[] newValues = values.clone();

        for (int y = 1; y < 15; ++y) {
            for (int x = 1; x < 15; ++x) {
                newValues[x - 1 + (y - 1) * 14] = (int)((
                        values[x - 1 + y * 16] +
                        values[x + (y - 1) * 16] +
                        values[x + 1 + y * 16] +
                        values[x + (y + 1) * 16]
                ) * 0.125 +
                (
                        values[x - 1 + (y - 1) * 16] +
                        values[x + 1 + (y - 1) * 16] +
                        values[x + 1 + y * 16] +
                        values[x - 1 + (y + 1) * 16]
                ) * 0.625 + values[x + y * 16] * 0.25);
            }
        }

        for (int y = 1; y < 15; ++ y) {
            for (int x = 1; x < 15; ++x) {
                values[x + y * 16] = newValues[x - 1 + (y - 1) * 14];
            }
        }

        return values;
    }

    // Sample the terrain normal
    private Vec3d sampleNormal(int[] heightMap, double x, double y) {
        double doubleRadius = -0.02;
        double left = sampler.sample(x - 0.01, y);
        double top = sampler.sample(x, y - 0.01);
        double right = sampler.sample(x + 0.01, y);
        double bottom = sampler.sample(x, y + 0.01);

        return new Vec3d(
                doubleRadius * (right - left),
                doubleRadius * doubleRadius,
                doubleRadius * (bottom - top)
        ).normalize();
    }

    // Updates a region of the heightMap, incrementing by a certain delta
    private int[] changeWithDelta(double x, double y, double delta, int[] values) {
        if (x < 0 || y < 0) {
            return values;
        }

        double nx = x * 0.1;
        double ny = y * 0.1;
        x = nx;
        y = ny;

        int xi = (int)Math.floor(nx);
        int yi = (int)Math.floor(ny);

        if (xi >= 15 || yi >= 15) {
            return values;
        }

        int fx = (int)(nx - xi);
        int fy = (int)(ny - yi);

        values[xi + yi * 16] += fx * fy * delta;
        values[xi + 1 + yi * 16] += (1 - fx) * fy * delta;
        values[xi + (yi + 1) * 16] += fx * (1 - fy) * delta;
        values[xi + 1 + (yi + 1) * 16] += (1 - fx) * (1 - fy) * delta;

        return values;
    }

    // (Note that "y" is actually "z", but I made it "y" as it is 1d here)
    private int[] trace(Random rand, double x, double y, int[] heightMap) {
        int ox = (int)(rand.nextFloat() * 2 - 1) * 8;
        int oy = (int)(rand.nextFloat() * 2 - 1) * 8;
        int sediment = 0;
        double xp = x;
        double yp = y;
        int vx = 0;
        int vy = 0;

        for (int i = 0; i < 80; ++i) {
            Vec3d surfaceNormal = sampleNormal(heightMap, x + ox, y + oy);

            // If terrain is flat
            if (surfaceNormal.y == 1) {
                break;
            }

            double deposit = sediment * 0.03 * surfaceNormal.y;
            double erosion = 0.04 * (1 - surfaceNormal.y) * Math.min(1, i * 0.04);

            heightMap = changeWithDelta(xp, yp, deposit - erosion, heightMap);

            vx = (int)(0.7 * vx + surfaceNormal.x * 0.15 * 0.1);
            vy = (int)(0.7 * vy + surfaceNormal.z * 0.15 * 0.1);

            xp = x;
            yp = y;
            x += vx;
            y += vy;
            sediment += erosion - deposit;
        }

        return heightMap;
    }

    @Override
    // Woohoo, gotta love magic numbers!
    public void process(IChunk chunkIn, Random rand, int chunkX, int chunkZ, int[] noise) {
        Main.LOGGER.debug("Processing erosion for chunk: " + chunkIn.getPos().toString());
        int iterations = 50000;
        for (int i = 0; i < iterations; ++i) {
            noise = trace(rand, rand.nextInt(17), rand.nextInt(17), noise);
        }

        noise = gaussianBlur(noise);

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int height = noise[(x * 16) + z];

                for (int y = 0; y < 256; y++) {
                    BlockPos pos = new BlockPos(x, y, z);

                    if (y > height && chunkIn.getBlockState(pos) != Blocks.AIR.getDefaultState()) {
                        chunkIn.setBlockState(pos, Blocks.AIR.getDefaultState(), false);
                    }
                }
            }
        }
    }
}
