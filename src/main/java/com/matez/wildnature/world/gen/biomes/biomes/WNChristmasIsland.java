package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir18;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir20;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir21;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.*;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class WNChristmasIsland extends WNBiome {
    public WNChristmasIsland(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.CHRISTMAS_SURFACE_BUILDER, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG)
                .precipitation(RainType.SNOW)
                .category(Category.ICY)
                .topography(WNBiomeBuilder.Topography.HIGH_MOUNTAINS)
                .climate(WNBiomeBuilder.Climate.POLAR)
                .depth(0.2F)
                .scale(0.1F)
                .temperature(-0.25F)
                .downfall(0.9F)
                .waterColor(ConfigSettings.coldWaterColor)
                .waterFogColor(ConfigSettings.coldWaterFogColor)
                .parent(null));

        WNBiomeFeatures.addIgloos(this);
        WNBiomeFeatures.addIgloos(this);
        WNBiomeFeatures.addVillages(this, "village/snowy/town_centers", 6);
        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addLakes(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addDoubleFlowers(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addDefaultFlowers(this);
        WNBiomeFeatures.addGrass(this, 3);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addFreezeTopLayer(this);
        WNBiomeFeatures.addCandyCane(this, 2);

        WNBiomeFeatures.addPlant(this, WNBlocks.HEATH_WHITE.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.BLUEBELL.getDefaultState(), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.CLEMATIS_BLUE.getDefaultState(), 1);

        WNBiomeFeatures.addScatteredPlant(this, Blocks.JACK_O_LANTERN.getDefaultState(), 3);
        WNBiomeFeatures.addScatteredPlant(this, Blocks.PUMPKIN.getDefaultState(), 1);

        BlockState spruceLog = Main.getBlockByID("minecraft:spruce_log").getDefaultState();
        BlockState spruceLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("minecraft:spruce_leaves"));


        WNBiomeFeatures.addTree(this, new tree_fir18().setCustomLog(spruceLog).setCustomLeaf(spruceLeaves), 1);
        WNBiomeFeatures.addTree(this, new tree_fir20().setCustomLog(spruceLog).setCustomLeaf(spruceLeaves), 1);
        WNBiomeFeatures.addTree(this, new tree_fir21().setCustomLog(spruceLog).setCustomLeaf(spruceLeaves), 1);
        WNBiomeFeatures.addTree(this, new tree_taiga15().setCustomLog(spruceLog).setCustomLeaf(spruceLeaves), 4);
        WNBiomeFeatures.addTree(this, new tree_taiga14().setCustomLog(spruceLog).setCustomLeaf(spruceLeaves), 4);
        WNBiomeFeatures.addTree(this, new tree_taiga13().setCustomLog(spruceLog).setCustomLeaf(spruceLeaves), 4);
        WNBiomeFeatures.addTree(this, new tree_taiga12().setCustomLog(spruceLog).setCustomLeaf(spruceLeaves), 4);
        WNBiomeFeatures.addTree(this, new tree_taiga11().setCustomLog(spruceLog).setCustomLeaf(spruceLeaves), 4);


        applyTrees();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SNOW_GOLEM, 20, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));

    }


}