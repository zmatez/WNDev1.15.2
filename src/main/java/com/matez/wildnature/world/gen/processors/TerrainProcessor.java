package com.matez.wildnature.world.gen.processors;

import net.minecraft.world.IWorld;

import java.util.Random;

public interface TerrainProcessor {
    void init(long seed);

    void process(IWorld world, Random rand, int chunkX, int chunkZ, int[] noise);
}
