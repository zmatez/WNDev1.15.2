package com.matez.wildnature.world.generation.heightmap.modules;

import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

public class ContinentGenerator {
    private final FastNoise noise;
    public static final float continentMinValue = 0;
    public static final float continentMaxValue = 1;
    public ContinentGenerator(long seed){
        this.noise = new FastNoise((int)seed);
        this.noise.SetNoiseType(FastNoise.NoiseType.Simplex);
        this.noise.SetFrequency(0.005f);
    }

    public float generateContinent(int dx, int dz){
        return (float)scaleBetween(noise.GetValue(dx,dz),continentMinValue,continentMaxValue,-1,1);
    }

    private static double scaleBetween(double unscaledNum, double minAllowed, double maxAllowed, double min, double max) {
        return (maxAllowed - minAllowed) * (unscaledNum - min) / (max - min) + minAllowed;
    }
}
