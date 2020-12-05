package com.matez.wildnature.world.generation.transformer.transformers;

import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.biome.setup.grid.EdgeBiome;
import com.matez.wildnature.world.generation.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;

public class EdgeTransformer extends BiomeTransformer {
    @Override
    protected BiomeGroup apply(BiomeGroup oldBiomeGroup, BiomeGroup northBiomeGroup, BiomeGroup southBiomeGroup, BiomeGroup eastBiomeGroup, BiomeGroup westBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        for (EdgeBiome edgeBiome : EdgeBiome.getEdgeBiomes()) {
            for (BiomeGroup matchingBiome : edgeBiome.getMatchingBiomes()) {
                if(northBiomeGroup.getId() == matchingBiome.getId() || southBiomeGroup.getId() == matchingBiome.getId() || eastBiomeGroup.getId() == matchingBiome.getId() || westBiomeGroup.getId() == matchingBiome.getId()){
                    if(oldBiomeGroup.getId() != matchingBiome.getId()){
                        return edgeBiome.getEdge();
                    }
                }
            }
        }

        return oldBiomeGroup;
    }
}
