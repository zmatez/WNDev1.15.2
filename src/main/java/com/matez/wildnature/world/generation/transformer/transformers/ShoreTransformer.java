package com.matez.wildnature.world.generation.transformer.transformers;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.biome.setup.grid.BiomeGroup;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.transformer.BiomeTransformer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import java.util.ArrayList;

public class ShoreTransformer extends BiomeTransformer {
    private final ArrayList<BiomeGroup> OCEANS;

    public ShoreTransformer() {
        OCEANS = new ArrayList<>();
        OCEANS.add(WNBiomes.OCEAN);
        OCEANS.add(WNBiomes.COLD_OCEAN);
        OCEANS.add(WNBiomes.FROZEN_OCEAN);
        OCEANS.add(WNBiomes.LUKEWARM_OCEAN);
        OCEANS.add(WNBiomes.WARM_OCEAN);
        OCEANS.add(WNBiomes.DEEP_OCEAN);
        OCEANS.add(WNBiomes.DEEP_COLD_OCEAN);
        OCEANS.add(WNBiomes.DEEP_FROZEN_OCEAN);
        OCEANS.add(WNBiomes.DEEP_LUKEWARM_OCEAN);
        OCEANS.add(WNBiomes.DEEP_WARM_OCEAN);
    }

    // /tp 2920.54 69.00 1052.61   seed -8772514324235447009
    @Override
    protected BiomeGroup apply(BiomeGroup oldBiomeGroup, BiomeGroup northBiomeGroup, BiomeGroup southBiomeGroup, BiomeGroup eastBiomeGroup, BiomeGroup westBiomeGroup, TempCategory tempCategory, WetCategory wetCategory, Cell cell, MainBiomeTransformer.TerrainCategory category, float identity) {
        for (BiomeGroup ocean : OCEANS) {
            if (northBiomeGroup.getId() == ocean.getId() || southBiomeGroup.getId() == ocean.getId() || eastBiomeGroup.getId() == ocean.getId() || westBiomeGroup.getId() == ocean.getId()) {
                boolean isOceanCenter = true;
                for (BiomeGroup oc2 : OCEANS) {
                    if(oldBiomeGroup.getId() == oc2.getId()){
                        isOceanCenter = false;
                    }
                }
                if (isOceanCenter) {
                    if (oldBiomeGroup.getBaseBiome() == Biomes.MUSHROOM_FIELDS) {
                        return WNBiomes.MUSHROOM_FIELD_SHORE;
                    }
                    if (tempCategory == TempCategory.ICY) {
                        if (oldBiomeGroup.getBaseBiome().getCategory() == Biome.Category.EXTREME_HILLS) {
                            return WNBiomes.COLD_STONE_SHORE;
                        }
                        return WNBiomes.ICY_BEACH;
                    } else if (tempCategory == TempCategory.COLD) {
                        if (oldBiomeGroup.getBaseBiome().getCategory() == Biome.Category.EXTREME_HILLS) {
                            return WNBiomes.STONE_SHORE;
                        }
                        return WNBiomes.COLD_BEACH;
                    } else if (tempCategory == TempCategory.TEMPERATE) {
                        return WNBiomes.TEMPERATE_BEACH;
                    } else if (tempCategory == TempCategory.WARM || tempCategory == TempCategory.HOT) {
                        if (oldBiomeGroup.getBaseBiome().getCategory() == Biome.Category.JUNGLE) {
                            return WNBiomes.TROPICAL_BEACH;
                        }
                        return WNBiomes.WARM_BEACH;
                    }
                }
            }
        }

        return oldBiomeGroup;
    }
}
