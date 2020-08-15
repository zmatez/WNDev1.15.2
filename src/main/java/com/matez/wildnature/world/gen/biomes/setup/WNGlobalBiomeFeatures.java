package com.matez.wildnature.world.gen.biomes.setup;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.world.gen.feature.features.WNFruitFeature;
import com.matez.wildnature.world.gen.feature.features.WNVegeFeature;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.ArrayList;

import static net.minecraft.world.biome.DefaultBiomeFeatures.LAVA_SPRING_CONFIG;
import static net.minecraft.world.biome.DefaultBiomeFeatures.WATER_SPRING_CONFIG;

public class WNGlobalBiomeFeatures {

    public static void setup(){
        WNFruitFeature.init();
        WNVegeFeature.init();

        Registry.BIOME.forEach(biome -> {
            WNBiomeFeatures.addMushrooms(biome);
            WNBiomeFeatures.addDefaultFlowersForBiome(biome);
            if(CommonConfig.generateVines.get()){
                WNBiomeFeatures.addCaveVines(biome);
            }
            if(CommonConfig.generateCrystals.get()){
                WNBiomeFeatures.addCrystals(biome);
            }
            if(CommonConfig.generateStalagmites.get()){
                WNBiomeFeatures.addStalagmites(biome);
            }
            if(CommonConfig.generatePebbles.get()){
                WNBiomeFeatures.addPebbles(biome);
            }
            if(CommonConfig.generateCobweb.get()){
                WNBiomeFeatures.addCobweb(biome);
            }
            if(CommonConfig.generateRockFormations.get()){
                WNBiomeFeatures.addRockFormations(biome);
            }
            if(CommonConfig.generateFruitBushes.get()){
                WNBiomeFeatures.addFruits(biome);
            }
            if(CommonConfig.generateVegeCrops.get()){
                WNBiomeFeatures.addVeggies(biome);
            }
            if(CommonConfig.generatePoisonIves.get()){
                WNBiomeFeatures.addPoisonIves(biome);
            }
            if(CommonConfig.generateOres.get()){
                WNBiomeFeatures.addNewOres(biome);
            }
            if(CommonConfig.generateUndergroundPlants.get()){
                WNBiomeFeatures.addCavePlants(biome);
            }
            if(CommonConfig.generateRiverCanes.get()){
                WNBiomeFeatures.addRiverCane(biome);
                WNBiomeFeatures.addRiverPlants(biome);
            }
            if(CommonConfig.generateSmallCacti.get()){
                WNBiomeFeatures.addSmallCacti(biome);
            }
            if(CommonConfig.replaceDefaultTrees.get()){
                //replaceDefaultFeatures(biome);
            }
            if(CommonConfig.generateShells.get()){
                WNBiomeFeatures.addShells(biome);
            }
            if(CommonConfig.generateMoss.get()){
                WNBiomeFeatures.addMoss(biome);
            }
            if(CommonConfig.generateGlowingCaveOaks.get()){
                WNBiomeFeatures.addGlowingCaveOaks(biome);
            }
            if(CommonConfig.generateBigGlowshrooms.get()){
                WNBiomeFeatures.addGlowshrooms(biome);
            }
            if(CommonConfig.generateFallenTrees.get()){
                WNBiomeFeatures.addFallenTrees(biome);
            }

            //carvers
            if(CommonConfig.generateUndergroundRivers.get()){
                //biome.addCarver(GenerationStage.Carving.LIQUID,Biome.createCarver(new RiverCarver(null,256),new EmptyCarverConfig()));
            }



        });

        for (Biome biome : WNBiomeFeatures.lakeBiomes) {
            if(CommonConfig.waterLakeGeneration.get()) {
                Main.LOGGER.info("adding water for "+ biome.getRegistryName());
                biome.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.WATER.getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
            }
            if(CommonConfig.lavaLakeGeneration.get()) {
                Main.LOGGER.info("adding lava for "+ biome.getRegistryName());
                biome.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.LAVA.getDefaultState())).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));
            }
        }


        for (Biome biome : WNBiomeFeatures.springBiomes) {
            if(CommonConfig.waterSpringGeneration.get()) {
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(WATER_SPRING_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(50, 8, 8, 256))));
            }
            if(CommonConfig.lavaSpringGeneration.get()) {
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(LAVA_SPRING_CONFIG).withPlacement(Placement.COUNT_VERY_BIASED_RANGE.configure(new CountRangeConfig(20, 8, 16, 256))));
            }
        }
    }


}
