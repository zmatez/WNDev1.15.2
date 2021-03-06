package com.matez.wildnature.world.generation.biome.biomes.land;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.blocks.FloweringBushBase;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.woods.another_spruce.tree_spruce_big1;
import com.matez.wildnature.world.generation.structures.nature.woods.another_spruce.tree_spruce_big2;
import com.matez.wildnature.world.generation.structures.nature.woods.another_spruce.tree_spruce_big3;
import com.matez.wildnature.world.generation.structures.nature.woods.another_spruce.tree_spruce_big4;
import com.matez.wildnature.world.generation.structures.nature.woods.beech.*;
import com.matez.wildnature.world.generation.structures.nature.woods.birch.tree_birch1;
import com.matez.wildnature.world.generation.structures.nature.woods.birch.tree_birch10;
import com.matez.wildnature.world.generation.structures.nature.woods.birch.tree_birch8;
import com.matez.wildnature.world.generation.structures.nature.woods.fir.tree_fir6;
import com.matez.wildnature.world.generation.structures.nature.woods.fir.tree_fir7;
import com.matez.wildnature.world.generation.structures.nature.woods.fir.tree_fir9;
import com.matez.wildnature.world.generation.structures.nature.woods.spruce.tree_taiga11;
import com.matez.wildnature.world.generation.surface.WNSurfaceBuilders;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNHighForestValley extends WNBiome {
    public WNHighForestValley(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(WNSurfaceBuilders.PODZOL_SURFACE_BUILDER, WNSurfaceBuilders.BROWN_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(0.2F)
                .scale(0.1F)
                .temperature(0.4F)
                .downfall(0.3F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.BEECH_THICK,LogType.PINE,LogType.POPLAR,LogType.FIR,LogType.BIRCH)
                .parent(null));


        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addVillages(this, "village/taiga/town_centers", 4);
        WNBiomeFeatures.addVillages(this, "village/plains/town_centers", 4);
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

        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.PERENNIAL_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.PERENNIAL_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.PERENNIAL_VIOLET.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.IRIS_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.IRIS_VIOLET.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.IRIS_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.PASQUE_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.PASQUE_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING, true), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.PASQUE_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.PASQUE_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);

        WNBiomeFeatures.addTree(this, new tree_spruce_big1().setCustomLog(WN.getBlockByID("wildnature:pine_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:pine_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new tree_spruce_big2().setCustomLog(WN.getBlockByID("wildnature:pine_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:pine_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new tree_spruce_big3().setCustomLog(WN.getBlockByID("wildnature:pine_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:pine_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new tree_spruce_big4().setCustomLog(WN.getBlockByID("wildnature:pine_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:pine_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new beech1(), 1);
        WNBiomeFeatures.addTree(this, new beech2(), 1);
        WNBiomeFeatures.addTree(this, new beech3(), 1);
        WNBiomeFeatures.addTree(this, new beech4(), 1);
        WNBiomeFeatures.addTree(this, new beech5(), 1);
        WNBiomeFeatures.addTree(this, new beech6(), 1);
        WNBiomeFeatures.addTree(this, new beech7(), 1);
        WNBiomeFeatures.addTree(this, new beech8(), 1);
        WNBiomeFeatures.addTree(this, new beech9(), 1);
        WNBiomeFeatures.addTree(this, new beech10(), 1);
        WNBiomeFeatures.addTree(this, new beech11(), 1);
        WNBiomeFeatures.addTree(this, new beech12(), 1);

        WNBiomeFeatures.addTree(this, new tree_birch10().setCustomLog(WN.getBlockByID("minecraft:oak_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("wildnature:poplar_leaves"))), 6);
        WNBiomeFeatures.addTree(this, new tree_birch1().setCustomLog(WN.getBlockByID("minecraft:oak_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("wildnature:poplar_leaves"))), 4);

        WNBiomeFeatures.addTree(this, new tree_fir6().setCustomLog(WN.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("wildnature:fir_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_fir7().setCustomLog(WN.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("wildnature:fir_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_fir9().setCustomLog(WN.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("wildnature:fir_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_taiga11().setCustomLog(WN.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("wildnature:fir_leaves"))), 1);

        WNBiomeFeatures.addTree(this, new tree_birch8().setCustomLog(WN.getBlockByID("minecraft:birch_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("minecraft:birch_leaves"))), 1);

        WNBiomeFeatures.addTaigaLargeFerns(this);
        WNBiomeFeatures.addTaigaRocks(this);
        WNBiomeFeatures.addBerryBushes(this);

        plantRate = 1;
        treeRate = 2;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 5, 4, 4));
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

    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0x81C46A, 0x95CF65);
    }


}