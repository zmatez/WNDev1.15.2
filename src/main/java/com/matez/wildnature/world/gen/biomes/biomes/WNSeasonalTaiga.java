package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.another_spruce.*;
import com.matez.wildnature.world.gen.structures.nature.woods.beech.*;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.boreal.*;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir31;
import com.matez.wildnature.world.gen.structures.nature.woods.larch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.MegaPineTree;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;

import static net.minecraft.world.gen.surfacebuilders.SurfaceBuilder.GIANT_TREE_TAIGA;
import static net.minecraft.world.gen.surfacebuilders.SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG;

public class WNSeasonalTaiga extends WNBiome {
    public WNSeasonalTaiga(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(GIANT_TREE_TAIGA, GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.2F)
                .scale(0.2F)
                .temperature(0.35F)
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
        WNBiomeFeatures.addTaigaGrassDeadBushesMushrooms(this);
        WNBiomeFeatures.addTaigaLargeFerns(this);
        WNBiomeFeatures.addTaigaRocks(this);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATH_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.CLEMATIS_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.BUTTERCUP_ORANGE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.LEAF_PILE.getDefaultState(), 3);


        WNBiomeFeatures.addTree(this, new seasonal_birch1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch4().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch4().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch4().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)), 12);
        WNBiomeFeatures.addTree(this, new seasonal_birch4().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)), 12);

        WNBiomeFeatures.addTree(this, new tree_spruce_m1().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_spruce_m2().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_spruce_m3().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_spruce_m4().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_spruce_m5().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_spruce_m6().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_spruce_m7().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_spruce_m8().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_spruce_m9().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_pine1().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_pine2().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_pine3().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_pine4().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_pine5().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_pine6().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_bpine1().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_bpine2().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_bpine3().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_bpine4().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_bpine5().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_bpine6().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 4);
        WNBiomeFeatures.addTree(this, new tree_larch1().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_larch2().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_larch3().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_larch4().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_larch5().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_larch6().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_larch7().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_larch8().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_larch9().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new leafy_beech_1().setCustomLog(null).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PURPLE_BEECH_LEAVES)), 3);
        WNBiomeFeatures.addTree(this, new leafy_beech_2().setCustomLog(null).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PURPLE_BEECH_LEAVES)), 3);
        WNBiomeFeatures.addTree(this, new leafy_beech_3().setCustomLog(null).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PURPLE_BEECH_LEAVES)), 3);

        WNBiomeFeatures.addTree(this, new tall_pine1(), 1);
        WNBiomeFeatures.addTree(this, new tall_pine2(), 1);
        WNBiomeFeatures.addTree(this, new tall_pine3(), 1);
        WNBiomeFeatures.addTree(this, new tall_pine4(), 1);

        WNBiomeFeatures.addTree(this, new thin_birch1(), 1);
        WNBiomeFeatures.addTree(this, new thin_birch2(), 1);
        WNBiomeFeatures.addTree(this, new thin_birch3(), 1);
        WNBiomeFeatures.addTree(this, new thin_birch4(), 1);

        WNBiomeFeatures.addTree(this, new spiky_birch_1(), 1);
        WNBiomeFeatures.addTree(this, new spiky_birch_2(), 1);
        WNBiomeFeatures.addTree(this, new spiky_birch_3(), 1);
        WNBiomeFeatures.addTree(this, new spiky_birch_4(), 1);
        WNBiomeFeatures.addTree(this, new pointy_birch1(), 1);
        WNBiomeFeatures.addTree(this, new pointy_birch2(), 1);
        WNBiomeFeatures.addTree(this, new pointy_birch3(), 1);
        WNBiomeFeatures.addTree(this, new pointy_birch4(), 1);
        WNBiomeFeatures.addTree(this, new weeping_beech_1(), 1);
        WNBiomeFeatures.addTree(this, new weeping_beech_2(), 1);
        WNBiomeFeatures.addTree(this, new weeping_beech_3(), 1);
        WNBiomeFeatures.addTree(this, new weeping_beech_4(), 1);

        //TODO MegaPineTree
        //WNBiomeFeatures.addTree(this, new MegaPineTree(NoFeatureConfig::deserialize, true, true), 12);
        //WNBiomeFeatures.addTree(this, new MegaPineTree(NoFeatureConfig::deserialize, true, true), 12);
        WNBiomeFeatures.addTree(this, new tree_fir31().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Main.getBlockByID("minecraft:spruce_leaves"))), 4);


        treeRate = 13;
        plantRate = 1;

        applyPlants();
        applyTrees();


        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 2, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 3, 4, 4));
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