package com.matez.wildnature.world.generation.maps;

import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;

public class ClimateMap {
    public void apply(Cell cell, float dx, float dz){
        FastNoise noise = new FastNoise();
        noise.SetNoiseType(FastNoise.NoiseType.Simplex);
        noise.SetFrequency(0.0001F);

        cell.cellTemparature = (new Temperature(0.0005f).getValue(cell.terrainCellX, cell.terrainCellZ));
        cell.temparature = (new Temperature(0.0005f).getValue(dx, dz));
        cell.cellMoisture = (noise.GetSimplex(cell.terrainCellX, cell.terrainCellZ));
        cell.moisture = (noise.GetSimplex(dx, dz));
    }

    public static class Temperature {
        private final float frequency;

        public Temperature(float frequency) {
            this.frequency = frequency;
        }

        public float getValue(float x, float y) {
            y *= frequency;

            final float noise;
            noise = NoiseUtil.sin(y);

            return NoiseUtil.map(noise, -1, 1, 2);
        }

    }

}
