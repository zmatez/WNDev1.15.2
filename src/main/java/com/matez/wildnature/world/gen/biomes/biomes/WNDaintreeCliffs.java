package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.citrus1;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.citrus2;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.citrus3;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.citrus4;
import com.matez.wildnature.world.gen.structures.nature.woods.ebony.ebony_shrub1;
import com.matez.wildnature.world.gen.structures.nature.woods.ebony.ebony_shrub2;
import com.matez.wildnature.world.gen.structures.nature.woods.eucalyptus.*;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle1;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle2;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle3;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle4;
import com.matez.wildnature.world.gen.structures.nature.woods.mahogany.*;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.oak1;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.oak2;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.oak3;
import com.matez.wildnature.world.gen.structures.nature.woods.palm.*;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import com.matez.wildnature.world.gen.surface.configs.CanyonSurfaceBuilderConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class WNDaintreeCliffs extends WNBiome {
    public WNDaintreeCliffs(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.GRAND_CANYON_SURFACE_BUILDER, new CanyonSurfaceBuilderConfig(SurfaceBuilder.PODZOL_DIRT_GRAVEL_CONFIG, SurfaceRegistry.OVERGROWN_CLIFFS_SURFACE_BUILDER))
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
        WNBiomeFeatures.addTree(this, new jungle1(), 10);
        WNBiomeFeatures.addTree(this, new jungle2(), 10);
        WNBiomeFeatures.addTree(this, new jungle3(), 10);
        WNBiomeFeatures.addTree(this, new jungle4(), 10);
        //TODO JungleTreeFeature
        //WNBiomeFeatures.addTree(this, new JungleTreeFeature(NoFeatureConfig::deserialize, true, 4, Blocks.JUNGLE_LOG.getDefaultState(), Blocks.JUNGLE_LEAVES.getDefaultState(), true), 15);
        WNBiomeFeatures.addTree(this, new shrub1().setCustomLog(Blocks.JUNGLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Blocks.JUNGLE_LEAVES)), 20);
        WNBiomeFeatures.addTree(this, new ebony_shrub1(), 1);
        WNBiomeFeatures.addTree(this, new ebony_shrub2(), 1);
        WNBiomeFeatures.addTree(this, new tree_palm1().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm2().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm3().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm4().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm5().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm6().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm7().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm8().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm9().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm10().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm11().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm12().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm13().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm14().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm15().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm16().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_palm17().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new mahogany1().setCustomLog(Main.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new mahogany2().setCustomLog(Main.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new mahogany3().setCustomLog(Main.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new mahogany4().setCustomLog(Main.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new mahoganyshrub1().setCustomLog(Main.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new mahoganyshrub2().setCustomLog(Main.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))), 1);
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
        WNBiomeFeatures.addTree(this, new citrus1().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.POMEGRANATE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new citrus2().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.POMEGRANATE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new citrus3().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.ORANGE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new citrus4().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.ORANGE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new citrus1().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PEACH_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new citrus4().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PEACH_LEAVES)), 1);

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