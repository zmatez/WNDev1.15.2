package com.matez.wildnature.world.generation.transformer.transformers;

import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.terrain.Terrain;
import com.matez.wildnature.world.generation.terrain.TerrainProvider;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.Arrays;

public class ShoreTransformer extends BiomeTransformer {
    private final ArrayList<BiomeGroup> OCEANS;
    public ShoreTransformer(){
        OCEANS = new ArrayList<>();
        OCEANS.addAll(Arrays.asList(TerrainProvider.DEEP_OCEAN_TERRAIN.getBiomeGroups()));
        OCEANS.addAll(Arrays.asList(TerrainProvider.OCEAN_TERRAIN.getBiomeGroups()));
        OCEANS.addAll(Arrays.asList(TerrainProvider.SEA_TERRAIN.getBiomeGroups()));
    }
    // /tp 2920.54 69.00 1052.61   seed -8772514324235447009
    @Override
    protected BiomeGroup apply(BiomeGroup oldBiomeGroup, BiomeGroup northBiomeGroup, BiomeGroup southBiomeGroup, BiomeGroup eastBiomeGroup, BiomeGroup westBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        if(OCEANS.contains(northBiomeGroup) || OCEANS.contains(southBiomeGroup) || OCEANS.contains(eastBiomeGroup) || OCEANS.contains(westBiomeGroup)){
            if(!OCEANS.contains(oldBiomeGroup)) {
                if(tempCategory == TempCategory.ICY){
                    if(oldBiomeGroup.getBaseBiome().getCategory() == Biome.Category.EXTREME_HILLS){
                        return WNBiomes.COLD_STONE_SHORE;
                    }
                    return WNBiomes.ICY_BEACH;
                }else if(tempCategory == TempCategory.COLD){
                    if(oldBiomeGroup.getBaseBiome().getCategory() == Biome.Category.EXTREME_HILLS){
                        return WNBiomes.STONE_SHORE;
                    }
                    return WNBiomes.COLD_BEACH;
                }else if(tempCategory == TempCategory.TEMPERATE){
                    return WNBiomes.TEMPERATE_BEACH;
                }else if(tempCategory == TempCategory.WARM || tempCategory == TempCategory.HOT){
                    if(oldBiomeGroup.getBaseBiome().getCategory() == Biome.Category.JUNGLE){
                        return WNBiomes.TROPICAL_BEACH;
                    }
                    return WNBiomes.WARM_BEACH;
                }
            }
        }

        return oldBiomeGroup;
    }
}
