package com.matez.wildnature.world.generation.heightmap.modules;

import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

public class ContinentGenerator {
    protected final int continentScale;
    private final FastNoise noise;
    public ContinentGenerator(long seed){
        this.continentScale = 2048; //temp value until I make settings.
        this.noise = new FastNoise((int)seed);
        this.noise.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
        this.noise.SetFrequency(0.005f);
        this.noise.SetFractalOctaves(5);
        this.noise.SetFractalLacunarity(3);
        this.noise.SetFractalGain(0.5f);
        this.noise.SetFractalType(FastNoise.FractalType.FBM);
    }

    public float generateContinent(int dx, int dz){
        return (float)scaleBetween(noise.GetValue(dx,dz),0.0,0.5,-1,1);
    }

    private static double scaleBetween(double unscaledNum, double minAllowed, double maxAllowed, double min, double max) {
        return (maxAllowed - minAllowed) * (unscaledNum - min) / (max - min) + minAllowed;
    }
}
