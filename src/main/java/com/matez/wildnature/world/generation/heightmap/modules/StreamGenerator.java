package com.matez.wildnature.world.generation.heightmap.modules;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.noise.OpenSimplex2S;

import java.util.Random;

public class StreamGenerator {
    private int xMove, zMove;
    private final OpenSimplex2S pathNoise;
    private OpenSimplex2S.Values2D1 results = new OpenSimplex2S.Values2D1();
    private final float freq = 0.005f;
    private final float threshold = 0.005f;
    private final float noiseMultiplier = 50f;
    public StreamGenerator(long seed) {
        WN.LOGGER.info("Created StreamGenerator with seed " + seed + "/" + (int) seed);
        pathNoise = new OpenSimplex2S(seed);

        Random random = new Random(seed);
        xMove = Utilities.rint(-100_000,100_000,random);
        zMove = Utilities.rint(-100_000,100_000,random);
    }

    public void generate(Cell cell, int x, int z) {
        int dx = xMove + x;
        int dz = zMove + z;

        pathNoise.noise2(dx* freq, dz* freq, results);

        double slope = Math.sqrt(results.dx*results.dx + results.dy*results.dy);
        double estDistanceToZero = Math.abs(results.value / slope);
        double noise = 1;
        if (estDistanceToZero < threshold) {
            noise = -(estDistanceToZero*noiseMultiplier);
        }

        cell.streamRiverValue = (float) noise;
    }

    public static boolean isStream(Cell cell){
        return cell.streamRiverValue != 1;
    }



}
