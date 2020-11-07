package com.matez.wildnature.world.generation.chunk.generation.noise;

import net.minecraft.world.biome.Biome;

import java.util.Random;

public interface NoiseProcessor {
    default boolean canProcess(Biome biome){
        return true;
    }

    default boolean smoothedOnBorders(){
        return true;
    }

    default int mixFactor(){
        return 1;
    }

    void init(long seed, Random random, int octaves);

    double processNoise(int x, int z, Biome biome, double height, double scale, boolean rawNoise);

    default double getProcessedNoise(int x, int z, Biome biome, double height, double scale, boolean rawNoise){
        return processNoise(x,z,biome,height,scale,rawNoise) * mixFactor();
    }
}
