package com.matez.wildnature.world.generation.biome.biomes.land;

import com.matez.wildnature.common.blocks.config.ConfigSettings;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class WNTropicalLake extends WNBiome {
    public WNTropicalLake(String name) {
        super(name, (new WNBiomeBuilder()).surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG).precipitation(RainType.RAIN).category(Category.RIVER).depth(ConfigSettings.riverDepth).scale(0.1F).temperature(0.5F).downfall(0.5F).waterColor(ConfigSettings.riverWaterColor).waterFogColor(ConfigSettings.muddyWaterFogColor).logTypes(LogType.NONE).parent(null));
        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addStructures(this);
        DefaultBiomeFeatures.addLakes(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addSedimentDisks(this);
        DefaultBiomeFeatures.addScatteredOakTrees(this);
        DefaultBiomeFeatures.addDefaultFlowers(this);
        DefaultBiomeFeatures.addSparseGrass(this);
        DefaultBiomeFeatures.addMushrooms(this);
        DefaultBiomeFeatures.addReedsAndPumpkins(this);
        DefaultBiomeFeatures.addSprings(this);
        DefaultBiomeFeatures.addSeagrass(this);
        DefaultBiomeFeatures.addExtraKelp(this);
        WNBiomeFeatures.addWaterlilies(this, WNBlocks.DUCKWEED, 8);
        WNBiomeFeatures.addWaterlilies(this, WNBlocks.GREEN_WATERLILY, 4);
        WNBiomeFeatures.addWaterlilies(this, WNBlocks.LOTUS_LIGHT_PINK, 1);
        WNBiomeFeatures.addWaterlilies(this, WNBlocks.LOTUS_PINK, 1);
        WNBiomeFeatures.addWaterlilies(this, WNBlocks.LOTUS_WHITE, 1);
        WNBiomeFeatures.addWaterlilies(this, WNBlocks.WATER_HYACINTH, 1);
        WNBiomeFeatures.addSeagrass(this, 48);
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.SQUID, 2, 1, 4));
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.DOLPHIN, 1, 1, 1));
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.TROPICAL_FISH, 5, 1, 5));
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.PUFFERFISH, 3, 1, 5));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.DROWNED, 100, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));

    }
}
