package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch1;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak10;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak11;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak8;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak9;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;

public class WNMapleForest extends WNBiome {
    public WNMapleForest(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.PODZOL_SURFACE_BUILDER, SurfaceRegistry.BROWN_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.15F)
                .scale(0.05F)
                .temperature(0.6F)
                .downfall(0.8F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));


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
        WNBiomeFeatures.addGrass(this);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.YEW_BUSH.getDefaultState(), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.LEAF_PILE.getDefaultState(), 3);

        WNBiomeFeatures.addTree(this, new tree_oak8().setCustomLog(Main.getBlockByID("wildnature:maple_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:maple_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_oak9().setCustomLog(Main.getBlockByID("wildnature:maple_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:maple_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_oak10().setCustomLog(Main.getBlockByID("wildnature:maple_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:maple_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_oak11().setCustomLog(Main.getBlockByID("wildnature:maple_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:maple_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new shrub1(), 30);
        //TODO BigTree
        //WNBiomeFeatures.addTree(this, new BigTree().setCustomLog(Main.getBlockByID("wildnature:maple_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:maple_leaves"))), 18);

        treeRate = 9;

        applyPlants();
        applyTrees();


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