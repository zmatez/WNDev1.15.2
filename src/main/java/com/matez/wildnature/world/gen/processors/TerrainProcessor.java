package com.matez.wildnature.world.gen.processors;

import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;

import java.util.Random;

public interface TerrainProcessor {
    void init(long seed);

    // Takes in the noise, mutates it
    void process(IChunk chunkIn, Random rand, int chunkX, int chunkZ, int[] noise);
}
