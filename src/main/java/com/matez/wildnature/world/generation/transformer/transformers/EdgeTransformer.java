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
    protected Biome apply(Biome oldBiome, BiomeGroup oldCenterBiomeGroup, BiomeGroup oldNorthBiomeGroup, BiomeGroup oldSouthBiomeGroup, BiomeGroup oldEastBiomeGroup, BiomeGroup oldWestBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        for (EdgeBiome edgeBiome : EdgeBiome.getEdgeBiomes()) {
            boolean matches = false;
            for (BiomeGroup matchingBiome : edgeBiome.getMatchingBiomes()) {
                if((oldNorthBiomeGroup.getName().equals(matchingBiome.getName()) && !oldNorthBiomeGroup.getName().isEmpty()) || (oldSouthBiomeGroup.getName().equals(matchingBiome.getName()) && !oldSouthBiomeGroup.getName().isEmpty()) || (oldEastBiomeGroup.getName().equals(matchingBiome.getName()) && !oldEastBiomeGroup.getName().isEmpty()) || (oldWestBiomeGroup.getName().equals(matchingBiome.getName()) && !oldWestBiomeGroup.getName().isEmpty())){
                    matches = true;
                    break;
                }
            }

            if(matches){
                return edgeBiome.getEdge();
            }
        }

        return oldBiome;
    }
}
