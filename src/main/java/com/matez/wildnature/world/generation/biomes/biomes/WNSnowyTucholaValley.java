package com.matez.wildnature.world.generation.biomes.biomes;

import com.matez.wildnature.init.Main;
import com.matez.wildnature.common.blocks.FloweringBushBase;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biomes.setup.LogType;
import com.matez.wildnature.world.generation.biomes.setup.WNBiome;
import com.matez.wildnature.world.generation.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.woods.another_spruce.*;
import com.matez.wildnature.world.generation.surface.SurfaceRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;

public class WNSnowyTucholaValley extends WNBiome {
    public WNSnowyTucholaValley(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.PODZOL_SURFACE_BUILDER, SurfaceRegistry.BROWN_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(0.2F)
                .scale(0.1F)
                .temperature(-0.5F)
                .downfall(0.3F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.LARCH)
                .parent(null));


        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addVillages(this, "village/taiga/town_centers", 6);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addLakes(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addDoubleFlowers(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addDefaultFlowers(this);
        WNBiomeFeatures.addGrass(this, 10);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addFreezeTopLayer(this);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.PERENNIAL_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.PERENNIAL_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.PERENNIAL_VIOLET.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.YEW_BUSH.getDefaultState(), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.GRASS_FERNSPROUT.getDefaultState(), 2);


        WNBiomeFeatures.addTree(this, new tree_spruce_m1().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_spruce_m2().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_spruce_m3().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_spruce_m4().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_spruce_m5().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_spruce_m6().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_spruce_m7().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_spruce_m8().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_spruce_m9().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 2);


        WNBiomeFeatures.addTaigaLargeFerns(this);
        WNBiomeFeatures.addTaigaRocks(this);
        WNBiomeFeatures.addBerryBushes(this);

        plantRate = 1;
        treeRate = 4;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 1, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 1, 4, 4));
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

    @Override
    public int getGrassColor(BlockPos pos) {
        return 0x559D4F;
    }
}