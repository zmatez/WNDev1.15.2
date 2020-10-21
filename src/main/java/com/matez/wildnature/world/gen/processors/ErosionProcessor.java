package com.matez.wildnature.world.gen.processors;

import com.matez.wildnature.world.gen.chunk.generation.WNSimplexChunkGenerator;
import com.matez.wildnature.world.gen.noise.OctaveNoiseSampler;
import com.matez.wildnature.world.gen.noise.OpenSimplexNoise;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

import java.util.Random;

public class ErosionProcessor implements TerrainProcessor {
    private OctaveNoiseSampler sampler;

    @Override
    public void init(long seed) {
        sampler = new OctaveNoiseSampler<>(OpenSimplexNoise.class, new Random(seed), 4, 128.0, 6.0, 8.0);
    }

    @Override
    // Woohoo, gotta love magic numbers!
    public void process(IWorld world, Random rand, int chunkX, int chunkZ, int[] noise) {
        BlockPos.Mutable posMutable = new BlockPos.Mutable();
        for (int x = 0; x < 16; x++) {
            posMutable.setX(chunkX * 16 + x);
            for (int z = 0; z < 16; z++) {
                posMutable.setZ(chunkZ * 16 + z);
                double sample = sampler.sample(chunkX * 16 + x, chunkZ * 16 + z) + 0.1;
                if (sample < 0.0 && noise[x * 16 + z] > 63) {
                    for (int y = 0; y < Math.abs(sample); y++) {
                        posMutable.setY(noise[x * 16 + z] - y);
                        world.setBlockState(posMutable.down(), Blocks.AIR.getDefaultState(), 2);
                    }

                    if (world.getBlockState(posMutable.down()) == Blocks.DIRT.getDefaultState()) {
                        world.setBlockState(posMutable.down(), Blocks.GRASS_BLOCK.getDefaultState(), 2);
                    }
                }
            }
        }
    }
}
