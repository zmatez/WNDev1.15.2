package com.matez.wildnature.world.generation.chunk.generation.noise;

import java.util.Random;

public class NoiseProcessors {
    public static NoiseProcessor SCALE = new ScaleNoiseProcessor();
    public static NoiseProcessor MOUNTAIN_RANGE = new TestNoiseProcessor();

    public static void init(long seed, Random random, int octaves){
        SCALE.init(seed, random, octaves);
        MOUNTAIN_RANGE.init(seed, random, octaves);
    }
}
