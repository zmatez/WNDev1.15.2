package com.matez.wildnature.world.generation.maps;

import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

public class ClimateMap {
    public void apply(Cell cell, float dx, float dz){
        FastNoise noise = new FastNoise();
        noise.SetNoiseType(FastNoise.NoiseType.Simplex);
        noise.SetFrequency(0.08F);

        cell.cellTemparature = (new Temparature(0.008f).getValue(cell.terrainCellX, cell.terrainCellZ));
        cell.temparature = (new Temparature(0.008f).getValue(dx, dz));
        cell.cellMoisture = (noise.GetSimplex(cell.terrainCellX, cell.terrainCellZ));
        cell.moisture = (noise.GetSimplex(dx, dz));
    }

}
