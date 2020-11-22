package com.matez.wildnature.world.generation.transformer.transformers;

import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.heightmap.modules.RiverGenerator;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;

public class RiverValleyTransformer extends BiomeTransformer {

    public static BiomeGroup riverValleySharp = BiomeGroup.SingleBuilder.configure("river_valley_sharp", WNBiomes.RiverValleySharp);
    public static BiomeGroup riverValleySmooth = BiomeGroup.SingleBuilder.configure("river_valley_smooth", WNBiomes.RiverValleySmooth);

    @Override
    protected BiomeGroup bgApply(BiomeGroup oldBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        if(category != Terrain.Category.OCEAN && category != Terrain.Category.DEEP_OCEAN && category != Terrain.Category.SEA){
            if (RiverGenerator.isRiverValleySmooth(cell)) {
                return riverValleySmooth;
            }else if (RiverGenerator.isRiverValleySharp(cell)) {
                return riverValleySharp;
            }
        }
        return oldBiomeGroup;
    }
}
