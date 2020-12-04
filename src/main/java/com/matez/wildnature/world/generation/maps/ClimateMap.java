package com.matez.wildnature.world.generation.maps;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

public class ClimateMap {
    public void apply(long seed, Cell cell, float dx, float dz){
        FastNoise tempNoise = new FastNoise((int) seed);
        tempNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
        tempNoise.SetFrequency(0.001F);

        FastNoise moistNoise = new FastNoise((int) seed);
        moistNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
        moistNoise.SetFrequency(0.0003F);

        cell.cellTemparature = Utilities.scaleBetween(tempNoise.GetSimplex(0,cell.terrainCellZ),1f,-1f,-0.6f,0.6f);
        cell.temparature = Utilities.scaleBetween(tempNoise.GetSimplex(0,dz),1f,-1f,-0.6f,0.6f);
        cell.cellMoisture = Utilities.scaleBetween(moistNoise.GetSimplex(cell.terrainCellX, cell.terrainCellZ),1f,-1f,-0.6f,0.6f);
        cell.moisture = Utilities.scaleBetween(moistNoise.GetSimplex(dx, dz),1f,-1f,-0.6f,0.6f);
    }


}
