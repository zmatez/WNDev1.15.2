package com.matez.wildnature.world.generation.transformer.transformers;

import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;

import java.util.Arrays;

public class MainBiomeTransformer extends BiomeTransformer {
    @Override
    protected BiomeGroup bgApply(TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        return getBiomeGroup(getBiomesByTemperatureAndMoisture(terrain,tempCategory,wetCategory), identity);
    }
}
