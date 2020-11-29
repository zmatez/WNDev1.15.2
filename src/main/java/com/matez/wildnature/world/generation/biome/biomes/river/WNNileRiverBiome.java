package com.matez.wildnature.world.generation.biome.biomes.river;

import com.matez.wildnature.common.blocks.config.ConfigSettings;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class WNNileRiverBiome extends WNBiome {
    public WNNileRiverBiome(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.RIVER)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(CommonConfig.riverDepth.get().floatValue() / 1.5f)
                .scale(0.03F)
                .temperature(1F)
                .downfall(0.5F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.RIVER_TREE)
                .parent(null));


        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addFreezeTopLayer(this);

        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addLakes(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addDoubleFlowers(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addDefaultFlowers(this);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addSeagrass(this,48);

        WNBiomeFeatures.addPlant(this, WNBlocks.RED_ALGAE.getDefaultState(), 6);
        WNBiomeFeatures.addPlant(this, WNBlocks.ALGAE.getDefaultState(), 4);

        applyPlants();
        plantRate = 4;

        WNBiomeFeatures.addWaterlilies(this, WNBlocks.DUCKWEED, 1);
        WNBiomeFeatures.addWaterlilies(this, WNBlocks.WATER_LILY_YELLOW, 1);

        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.SQUID, 2, 1, 4));
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.SALMON, 5, 1, 5));
        this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.DROWNED, 100, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));

    }
}
