package com.matez.wildnature.world.generation.processors;

import com.matez.wildnature.world.generation.biome.setup.WNGenSettings;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;

import java.util.Random;

public interface TerrainProcessor {
    void init(ChunkGenerator<WNGenSettings> generator, long seed);

    // Takes in the noise, mutates it
    void process(IWorld world, IChunk chunk, Random rand, int chunkX, int chunkZ, int relativeX, int relativeZ, int[] noise);
}
