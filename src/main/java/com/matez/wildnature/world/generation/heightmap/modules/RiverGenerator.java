package com.matez.wildnature.world.generation.heightmap.modules;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.noise.domain.Warp;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

public class RiverGenerator {
    public FastNoise mainRiverNoise, smallRiverNoise;
    public FastNoise meanderNoise;
    public static float meanderThreshold = 0.2f, streamMeanderThreshold = 0.1f;
    public Warp meanderWarp;
    private int xMove, zMove;

    public RiverGenerator(long seed){
        WN.LOGGER.debug("Created RiverGenerator with seed " + seed + "/" + (int) seed);
        this.mainRiverNoise = new FastNoise((int) seed);
        this.mainRiverNoise.SetFractalType(FastNoise.FractalType.RigidMulti);
        this.mainRiverNoise.SetFrequency(0.0002F);
        this.mainRiverNoise.SetFractalOctaves(1);
        this.mainRiverNoise.SetFractalLacunarity(0);
        this.mainRiverNoise.SetFractalGain(0f);

        this.smallRiverNoise = new FastNoise((int) seed + 1);
        this.smallRiverNoise.SetFractalType(FastNoise.FractalType.RigidMulti);
        this.smallRiverNoise.SetFrequency(0.0005F);
        this.smallRiverNoise.SetFractalOctaves(1);
        this.smallRiverNoise.SetFractalLacunarity(0);
        this.smallRiverNoise.SetFractalGain(0f);

        this.meanderNoise = new FastNoise((int) seed);
        this.meanderNoise.SetFrequency(0.0005F);

        FastNoise warpX = new FastNoise((int) seed);
        warpX.SetNoiseType(FastNoise.NoiseType.Simplex);
        warpX.SetFrequency(0.01f);

        FastNoise warpZ = new FastNoise((int) seed);
        warpZ.SetNoiseType(FastNoise.NoiseType.Simplex);
        warpZ.SetFrequency(0.01f);

        this.meanderWarp = new Warp(warpX,warpZ,64);

        xMove = 0;
        zMove = 0;
    }

    public void generate(Cell cell, int x, int z){
        int dx = xMove + x;
        int dz = zMove + z;
        float meanders = meanderNoise.GetValue(dx,dz);
        float scaledMeanders = 0.07f;
        if(meanders > meanderThreshold){
            scaledMeanders = Utilities.scaleBetween(meanders,0.07f,0.35f,meanderThreshold,1);
        }

        float wx = dx+(meanderWarp.getOffsetX(dx,dz) * scaledMeanders);
        float wz = dz+(meanderWarp.getOffsetZ(dx,dz) * scaledMeanders);

        cell.mainRiverValue = mainRiverNoise.GetSimplexFractal(wx,wz);

        float scaledLandscapeMeanders = 0.05f;
        if(meanders > meanderThreshold){
            scaledLandscapeMeanders = Utilities.scaleBetween(meanders,0.05f,0.25f,meanderThreshold,1);
        }

        float wlx = dx+(meanderWarp.getOffsetX(dx,dz) * scaledLandscapeMeanders);
        float wlz = dz+(meanderWarp.getOffsetZ(dx,dz) * scaledLandscapeMeanders);

        cell.mainRiverLandscapeValue = mainRiverNoise.GetSimplexFractal(wlx,wlz);

        //smallRivers
        scaledMeanders = 0.15f;
        if(meanders > streamMeanderThreshold){
            scaledMeanders = Utilities.scaleBetween(meanders,0.15f,0.3f,streamMeanderThreshold,1);
        }

        float swx = dx+(meanderWarp.getOffsetX(dx,dz) * scaledMeanders);
        float swz = dz+(meanderWarp.getOffsetZ(dx,dz) * scaledMeanders);

        cell.smallRiverValue = smallRiverNoise.GetSimplexFractal(swx,swz);

        scaledLandscapeMeanders = 0.15f;
        if(meanders > streamMeanderThreshold){
            scaledLandscapeMeanders = Utilities.scaleBetween(meanders,0.15f,0.25f,streamMeanderThreshold,1);
        }

        float swlx = dx+(meanderWarp.getOffsetX(dx,dz) * scaledLandscapeMeanders);
        float swlz = dz+(meanderWarp.getOffsetZ(dx,dz) * scaledLandscapeMeanders);
        cell.smallRiverLandscapeValue = smallRiverNoise.GetSimplexFractal(swlx,swlz);
    }

    public static boolean isRiver(Cell cell){
        return cell.mainRiverValue  > scaleSize(0.9968f, cell.continentValue) || cell.smallRiverValue > scaleSize(0.9983f, cell.continentValue);
    }

    public static boolean isRiverValleySharp(Cell cell){
        return cell.mainRiverLandscapeValue  > scaleSize(0.983f, cell.continentValue) || cell.smallRiverLandscapeValue > scaleSize(0.9837f, cell.continentValue);
    }

    public static boolean isRiverValleySmooth(Cell cell){
        return cell.mainRiverLandscapeValue  > scaleSize(0.99f, cell.continentValue) || cell.smallRiverLandscapeValue > scaleSize(0.99f, cell.continentValue);
    }

    private static float scaleSize(float max, float continent){
        return Utilities.scaleBetween(continent,max - 0.0015f, max, 0.2f, ContinentGenerator.continentMaxValue);
    }
}
