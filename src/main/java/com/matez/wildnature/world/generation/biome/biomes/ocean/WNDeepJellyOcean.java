package com.matez.wildnature.world.generation.biome.biomes.ocean;

import com.matez.wildnature.common.blocks.JellyBlock;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.structures.nature.woods.jelly.*;
import com.matez.wildnature.world.generation.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.generation.surface.configs.Noise3SurfaceBuilderConfig;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class WNDeepJellyOcean extends WNBiome {
    public WNDeepJellyOcean(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(WNSurfaceBuilders.NOISE3_SURFACE_BUILDER, new Noise3SurfaceBuilderConfig(WNSurfaceBuilders.ALGAE_CONFIG, SurfaceBuilder.SAND_CONFIG, SurfaceBuilder.GRAVEL_CONFIG))
                .precipitation(RainType.RAIN)
                .category(Category.OCEAN)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(-1.8f)
                .scale(0.05f)
                .temperature(0.5F)
                .downfall(0.5f)
                .waterColor(4566514)
                .waterFogColor(0x31184B)
                .logTypes(LogType.NONE)
                .parent(null));

        this.addStructure(Feature.OCEAN_MONUMENT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
        this.addStructure(Feature.SHIPWRECK.withConfiguration(new ShipwreckConfig(false)));
        this.addStructure(Feature.OCEAN_RUIN.withConfiguration(new OceanRuinConfig(OceanRuinStructure.Type.COLD, 0.3F, 0.9F)));

        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addDoubleFlowers(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addGrass(this);
        WNBiomeFeatures.addFreezeTopLayer(this);
        WNBiomeFeatures.addBuriedTreasures(this);
        WNBiomeFeatures.addOceanCarvers(this);
        WNBiomeFeatures.addTallSeagrassSparse(this);
        WNBiomeFeatures.addKelp(this);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        //WNBiomeFeatures.addJellies(this);
        WNBiomeFeatures.addJellyIslands(this);

        WNBiomeFeatures.addPlant(this, WNBlocks.CRAB_CORAL.getDefaultState(),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.GLOW_RIBBON.getDefaultState(),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.DEEP_SEA_NIGHT_SHADE.getDefaultState(),1);
        WNBiomeFeatures.addPlant(this, WNBlocks.GLOWING_SEA_BANANA.getDefaultState(),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.SHRIMP_TUBE.getDefaultState(),2);

        plantRate = 3;

        applyPlants();

        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.SQUID, 10, 1, 2));
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.COD, 15, 3, 6));
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.PUFFERFISH, 5, 1, 3));
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.TROPICAL_FISH, 25, 8, 8));
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.DOLPHIN, 2, 1, 2));
        this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.DROWNED, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));

    }

}