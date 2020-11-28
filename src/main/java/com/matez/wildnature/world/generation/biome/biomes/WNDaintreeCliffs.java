package com.matez.wildnature.world.generation.biome.biomes;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.blocks.FloweringBushBase;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.woods.citrus.*;
import com.matez.wildnature.world.generation.structures.nature.woods.ebony.ebony_shrub1;
import com.matez.wildnature.world.generation.structures.nature.woods.ebony.ebony_shrub2;
import com.matez.wildnature.world.generation.structures.nature.woods.eucalyptus.*;
import com.matez.wildnature.world.generation.structures.nature.woods.jungle.*;
import com.matez.wildnature.world.generation.structures.nature.woods.mahogany.*;
import com.matez.wildnature.world.generation.structures.nature.woods.oak.oak1;
import com.matez.wildnature.world.generation.structures.nature.woods.oak.oak2;
import com.matez.wildnature.world.generation.structures.nature.woods.oak.oak3;
import com.matez.wildnature.world.generation.structures.nature.woods.palm.*;
import com.matez.wildnature.world.generation.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.generation.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.generation.surface.configs.CanyonSurfaceBuilderConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class WNDaintreeCliffs extends WNBiome {
    public WNDaintreeCliffs(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(WNSurfaceBuilders.GRAND_CANYON_SURFACE_BUILDER, new CanyonSurfaceBuilderConfig(SurfaceBuilder.PODZOL_DIRT_GRAVEL_CONFIG, WNSurfaceBuilders.OVERGROWN_CLIFFS_SURFACE_BUILDER))
                .precipitation(RainType.RAIN)
                .category(Category.JUNGLE)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(4.2F)
                .scale(0.42F)
                .temperature(0.90F)
                .downfall(0.8F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.OAK,LogType.JUNGLE_BIG,LogType.JUNGLE_MEDIUM,LogType.JUNGLE_SMALL,LogType.SMALL_EBONY,LogType.PALM,LogType.MAHOGANY,LogType.EUCALYPTUS,LogType.POMEGRANATE,LogType.PEACH,LogType.ORANGE)
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
        WNBiomeFeatures.addPlant(this, WNBlocks.CANA_BULB_ORANGE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.CANA_BULB_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.CANA_BULB_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.CANA_BULB_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);

        WNBiomeFeatures.addPlant(this, WNBlocks.LEAF_PILE.getDefaultState(), 3);

        WNBiomeFeatures.addPlant(this, Blocks.BLUE_ORCHID.getDefaultState(), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.ANTHURIUM_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.ANTHURIUM_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.ORCHIS_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);

        WNBiomeFeatures.addTree(this, new oak1(), 1);
        WNBiomeFeatures.addTree(this, new oak2(), 1);
        WNBiomeFeatures.addTree(this, new oak3(), 1);
        WNBiomeFeatures.addTree(this, new jungle_big1(), 6);
        WNBiomeFeatures.addTree(this, new jungle_big2(), 6);
        WNBiomeFeatures.addTree(this, new jungle_big3(), 6);
        WNBiomeFeatures.addTree(this, new jungle_medium1(), 4);
        WNBiomeFeatures.addTree(this, new jungle_medium2(), 4);
        WNBiomeFeatures.addTree(this, new jungle_small1(), 3);
        WNBiomeFeatures.addTree(this, new jungle_small2(), 3);
        WNBiomeFeatures.addTree(this, new jungle_small3(), 3);
        WNBiomeFeatures.addTree(this, new shrub1().setCustomLog(Blocks.JUNGLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Blocks.JUNGLE_LEAVES)), 20);
        WNBiomeFeatures.addTree(this, new ebony_shrub1(), 1);
        WNBiomeFeatures.addTree(this, new ebony_shrub2(), 1);
        WNBiomeFeatures.addTree(this, new tree_palm1().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm2().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm3().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm4().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm5().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm6().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm7().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm8().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm9().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm10().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm11().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm12().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm13().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm14().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm15().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm16().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm17().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new mahogany1().setCustomLog(WN.getBlockByID("wildnature:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:mahogany_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new mahogany2().setCustomLog(WN.getBlockByID("wildnature:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:mahogany_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new mahogany3().setCustomLog(WN.getBlockByID("wildnature:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:mahogany_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new mahogany4().setCustomLog(WN.getBlockByID("wildnature:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:mahogany_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new mahoganyshrub1().setCustomLog(WN.getBlockByID("wildnature:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:mahogany_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new mahoganyshrub2().setCustomLog(WN.getBlockByID("wildnature:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:mahogany_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new eucalyptus_1(), 1);
        WNBiomeFeatures.addTree(this, new eucalyptus_2(), 1);
        WNBiomeFeatures.addTree(this, new eucalyptus_3(), 1);
        WNBiomeFeatures.addTree(this, new eucalyptus_4(), 1);
        WNBiomeFeatures.addTree(this, new eucalyptus_5(), 1);
        WNBiomeFeatures.addTree(this, new eucalyptus_6(), 1);
        WNBiomeFeatures.addTree(this, new eucalyptus_7(), 1);
        WNBiomeFeatures.addTree(this, new eucalyptus_8(), 1);
        WNBiomeFeatures.addTree(this, new eucalyptus_9(), 1);
        WNBiomeFeatures.addTree(this, new eucalyptus_10(), 1);

        WNBiomeFeatures.addTree(this, new pomegranate1(), 1);
        WNBiomeFeatures.addTree(this, new pomegranate2(), 1);
        WNBiomeFeatures.addTree(this, new pomegranate3(), 1);
        WNBiomeFeatures.addTree(this, new orange1(), 1);
        WNBiomeFeatures.addTree(this, new orange2(), 1);
        WNBiomeFeatures.addTree(this, new orange3(), 1);
        WNBiomeFeatures.addTree(this, new peach1(), 1);
        WNBiomeFeatures.addTree(this, new peach2(), 1);
        WNBiomeFeatures.addTree(this, new peach3(), 1);


        WNBiomeFeatures.addBlob(this, Blocks.PODZOL.getDefaultState(), 2, true, false, 8);


        treeRate = 10;

        applyPlants();
        applyTrees();


        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PARROT, 40, 1, 2));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PANDA, 3, 1, 2));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 45, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.HUSK, 35, 1, 3));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));

    }
}