package com.matez.wildnature.world.generation.biome.biomes.river.edge;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.blocks.config.ConfigSettings;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.surface.WNSurfaceBuilders;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class WNIcelandRiver extends Biome {
    public WNIcelandRiver() {
        super((new Builder()).surfaceBuilder(WNSurfaceBuilders.CANYON_RIVER_SURFACE_BUILDER, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG).precipitation(RainType.RAIN).category(Category.RIVER).depth(ConfigSettings.riverDepth + ConfigSettings.riverDepth * 0.3f).scale(0F).temperature(-0.8F).downfall(0.3F).waterColor(ConfigSettings.riverWaterColor).waterFogColor(ConfigSettings.riverWaterFogColor).parent(null));
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
        DefaultBiomeFeatures.addFreezeTopLayer(this);
        WNBiomeFeatures.addSeagrass(this, 48);
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.SQUID, 2, 1, 4));
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.SALMON, 5, 4, 5));
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
        setRegistryName(WN.RegistryEvents.location("iceland_river"));
        //#0aa44f
    }
}
