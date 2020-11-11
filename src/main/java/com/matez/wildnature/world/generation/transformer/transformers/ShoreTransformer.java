package com.matez.wildnature.world.generation.transformer.transformers;

import com.google.common.collect.ImmutableSet;
import com.matez.wildnature.world.generation.chunk.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import java.util.ArrayList;

public class ShoreTransformer extends BiomeTransformer {
    private ArrayList<Biome> OCEANS;
    public ShoreTransformer(){
        OCEANS = new ArrayList<>(ImmutableSet.of(Biomes.OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_WARM_OCEAN, Biomes.FROZEN_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.WARM_OCEAN));;
    }

    @Override
    protected Biome apply(Biome oldCenterBiome, Biome oldNorthBiome, Biome oldSouthBiome, Biome oldEastBiome, Biome oldWestBiome, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        boolean isShore = false;
        if(!OCEANS.contains(oldCenterBiome)){
            if(OCEANS.contains(oldNorthBiome) || OCEANS.contains(oldSouthBiome) || OCEANS.contains(oldEastBiome) || OCEANS.contains(oldWestBiome)){
                isShore = true;
            }
        }

        if(!isShore){
            return oldCenterBiome;
        }

        return Biomes.BEACH;
    }
}
