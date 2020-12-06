package com.matez.wildnature.world.generation.maps;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

import java.util.Random;

public class ClimateMap {
    private int xMove, zMove;
    private long seed;

    public ClimateMap(long seed){
        this.seed = seed;
        Random random = new Random(seed);
        xMove = Utilities.rint(-100_000,100_000,random);
        zMove = Utilities.rint(-100_000,100_000,random);
    }

    public void apply(Cell cell, float x, float z){
        float dx = xMove + x;
        float dz = zMove + z;
        FastNoise tempNoise = new FastNoise((int) seed);
        tempNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
        tempNoise.SetFrequency(0.0005F);

        FastNoise moistNoise = new FastNoise((int) seed);
        moistNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
        moistNoise.SetFrequency(0.0003F);

        cell.cellTemparature = Utilities.scaleBetween(tempNoise.GetSimplex((float)cell.terrainCellX/4,cell.terrainCellZ),1f,-1f,-0.8f,0.8f);
        cell.temparature = Utilities.scaleBetween(tempNoise.GetSimplex((float)dx/4,dz),1f,-1f,-0.8f,0.8f);
        cell.cellMoisture = Utilities.scaleBetween(moistNoise.GetSimplex(cell.terrainCellX, cell.terrainCellZ),1f,-1f,-0.6f,0.6f);
        cell.moisture = Utilities.scaleBetween(moistNoise.GetSimplex(dx, dz),1f,-1f,-0.6f,0.6f);
    }


}
