package com.matez.wildnature.world.generation.heightmap.modules;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

import java.util.Random;

public class ContinentGenerator {
    private final FastNoise noise;
    public static final float continentMinValue = 0;
    public static final float continentMaxValue = 1;
    private int xMove, zMove;

    public ContinentGenerator(long seed){
        WN.LOGGER.debug("Created ContinentGenerator with seed " + seed + "/" + (int) seed);
        this.noise = new FastNoise((int)seed);
        this.noise.SetNoiseType(FastNoise.NoiseType.Simplex);
        this.noise.SetFrequency(0.0003f);
        Random random = new Random(seed);
        xMove = Utilities.rint(-100_000,100_000,random);
        zMove = Utilities.rint(-100_000,100_000,random);
        WN.LOGGER.debug("Continent move: " + xMove + " " + zMove);
    }

    public float generateContinent(int dx, int dz){
        return (float)scaleBetween(noise.GetNoise(xMove + dx,zMove + dz),continentMinValue,continentMaxValue,-0.8,0.8);
    }

    private static double scaleBetween(double unscaledNum, double minAllowed, double maxAllowed, double min, double max) {
        return (maxAllowed - minAllowed) * (unscaledNum - min) / (max - min) + minAllowed;
    }
}
