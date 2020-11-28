package com.matez.wildnature.world.generation.transformer.transformers;

import com.google.common.collect.ImmutableSet;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.biome.setup.grid.EdgeBiome;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import java.util.ArrayList;

public class EdgeTransformer extends BiomeTransformer {
    @Override
    protected BiomeGroup apply(BiomeGroup oldBiomeGroup, BiomeGroup northBiomeGroup, BiomeGroup southBiomeGroup, BiomeGroup eastBiomeGroup, BiomeGroup westBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        for (EdgeBiome edgeBiome : EdgeBiome.getEdgeBiomes()) {
            for (BiomeGroup matchingBiome : edgeBiome.getMatchingBiomes()) {
                if(northBiomeGroup == matchingBiome || southBiomeGroup == matchingBiome || eastBiomeGroup == matchingBiome || westBiomeGroup == matchingBiome){
                    if(oldBiomeGroup != matchingBiome){
                        return edgeBiome.getEdge();
                    }
                }
            }
        }

        return oldBiomeGroup;
    }
}
