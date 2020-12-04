package com.matez.wildnature.world.generation.transformer.transformers;

import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.heightmap.modules.RiverGenerator;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.world.biome.Biome;

public class RiverTransformer extends BiomeTransformer {

    @Override
    protected BiomeGroup bgApply(BiomeGroup oldBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, Terrain terrain, Terrain.Category category, float identity) {
        if(category != Terrain.Category.OCEAN && category != Terrain.Category.DEEP_OCEAN && category != Terrain.Category.SEA){
            if (RiverGenerator.isRiver(cell)) {
                if(tempCategory == TempCategory.WARM || tempCategory == TempCategory.HOT){
                    if(oldBiomeGroup.getBaseBiome().getCategory() == Biome.Category.JUNGLE){
                        return WNBiomes.AMAZON_RIVER;
                    }else if(oldBiomeGroup.getBaseBiome().getCategory() == Biome.Category.DESERT && (wetCategory == WetCategory.DRY || wetCategory == WetCategory.TEMPERATE)){
                        return WNBiomes.NILE_RIVER;
                    }
                }

                if(tempCategory == TempCategory.ICY){
                    return WNBiomes.FROZEN_RIVER;
                }

                return WNBiomes.RIVER;
            }
        }
        return oldBiomeGroup;
    }
}
