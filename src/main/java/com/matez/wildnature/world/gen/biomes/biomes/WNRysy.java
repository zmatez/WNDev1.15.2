package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.*;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.*;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;

public class WNRysy extends WNBiome {
    public WNRysy(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.SNOWY_MOUNTAIN_SURFACE_BUILDER, SurfaceRegistry.BROWN_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.EXTREME_HILLS)
                .topography(WNBiomeBuilder.Topography.HIGH_MOUNTAINS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(4F)
                .scale(2F)
                .temperature(-0.7F)
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
        WNBiomeFeatures.addDefaultFlowers(this);
        WNBiomeFeatures.addGrass(this, 18);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);

        BlockState pineLog = Main.getBlockByID("wildnature:pine_log").getDefaultState();
        BlockState pineLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"));
        BlockState firLog = Main.getBlockByID("wildnature:fir_log").getDefaultState();
        BlockState firLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("wildnature:fir_leaves"));
        BlockState spruceLog = Main.getBlockByID("minecraft:spruce_log").getDefaultState();
        BlockState spruceLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("minecraft:spruce_leaves"));
        BlockState birchLog = Main.getBlockByID("minecraft:birch_log").getDefaultState();
        BlockState birchLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("minecraft:birch_leaves"));
        int x = 0;
        while (x < 3) {
            BlockState LOG = null;
            BlockState LEAVES = null;
            if (x == 0) {
                LOG = pineLog;
                LEAVES = pineLeaves;
            } else if (x == 1) {
                LOG = firLog;
                LEAVES = firLeaves;
            } else if (x == 2) {
                LOG = spruceLog;
                LEAVES = spruceLeaves;
            }
            WNBiomeFeatures.addTree(this, new tree_taiga1().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga2().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga4().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga5().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga8().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga9().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga14().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga16().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga17().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga18().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_fir7().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_fir9().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_fir13().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_fir19().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_fir20().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            x++;
        }

        WNBiomeFeatures.addTree(this, new tree_birch1().setCustomLog(birchLog).setCustomLeaf(birchLeaves), 1);
        WNBiomeFeatures.addTree(this, new tree_birch2().setCustomLog(birchLog).setCustomLeaf(birchLeaves), 1);
        WNBiomeFeatures.addTree(this, new tree_birch7().setCustomLog(birchLog).setCustomLeaf(birchLeaves), 1);
        WNBiomeFeatures.addTree(this, new tree_birch10().setCustomLog(birchLog).setCustomLeaf(birchLeaves), 1);
        WNBiomeFeatures.addTree(this, new tree_birch11().setCustomLog(birchLog).setCustomLeaf(birchLeaves), 1);
        WNBiomeFeatures.addTree(this, new tree_birch12().setCustomLog(birchLog).setCustomLeaf(birchLeaves), 1);


        plantRate = 4;
        treeRate = 4;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
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