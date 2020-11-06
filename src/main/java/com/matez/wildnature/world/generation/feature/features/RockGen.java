package com.matez.wildnature.world.generation.feature.features;

import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class RockGen {
    public static void setupRocks(){
        for(Biome biome: ForgeRegistries.BIOMES){
            WNBiomeFeatures.addNewStoneVariants(biome);
        }
    }
}
