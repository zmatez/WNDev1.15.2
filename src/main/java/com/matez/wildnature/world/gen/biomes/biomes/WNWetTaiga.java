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
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir13;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir22;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir23;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir25;
import com.matez.wildnature.world.gen.structures.nature.woods.larch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.*;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan3;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga11;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga12;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import com.matez.wildnature.world.gen.surface.builders.CustomSurfaceBuilder;
import com.matez.wildnature.world.gen.surface.configs.CustomSurfaceBuilderConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNWetTaiga extends WNBiome {
    public WNWetTaiga(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.CUSTOM_SURFACE_BUILDER, new CustomSurfaceBuilderConfig(new CustomSurfaceBuilder.BlockCfg(SurfaceRegistry.BROWN_PODZOL_CONFIG, 5), new CustomSurfaceBuilder.BlockCfg(SurfaceRegistry.BROWN_CONFIG, 1)))
                .precipitation(RainType.RAIN)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.2F)
                .scale(0.15F)
                .temperature(0.26F)
                .downfall(1F)
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
        WNBiomeFeatures.addGrass(this, 3);
        WNBiomeFeatures.addGrass(this, 15, Blocks.FERN.getDefaultState());
        WNBiomeFeatures.addGrass(this, 40, Blocks.LARGE_FERN.getDefaultState(), true);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addBerryBushes(this);
        WNBiomeFeatures.addWater(this);


        WNBiomeFeatures.addPlant(this, WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATH_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.FORGET_ME_NOT_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.THUJA.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.THUJA_LARGE.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.THUJA_LIMEGREEN.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.PERENNIAL_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.PRIMROSE_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.PRIMROSE_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.YEW_BUSH.getDefaultState(), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.CLOVER.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.LEAF_PILE.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.GRASS_WHEAT.getDefaultState().with(FloweringBushBase.FLOWERING, true), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.VIBURNUM_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.GRASS_FERNSPROUT.getDefaultState(), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.BUSH_WILD_BLUEBERRY.getDefaultState(), 1);

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
        WNBiomeFeatures.addTree(this, new tree_larch1().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch2().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch3().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch4().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch5().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch6().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch7().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch8().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch9().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_spruce_big1().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))), 5);
        WNBiomeFeatures.addTree(this, new tree_spruce_big2().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))), 5);
        WNBiomeFeatures.addTree(this, new tree_spruce_big3().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))), 5);
        WNBiomeFeatures.addTree(this, new tree_spruce_big4().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))), 5);
        WNBiomeFeatures.addTree(this, new tree_spruce_m1().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_spruce_m2().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_spruce_m3().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_spruce_m4().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_spruce_m5().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_spruce_m6().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_spruce_m7().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_spruce_m8().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_spruce_m9().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))), 1);

        WNBiomeFeatures.addTree(this, new tree_taiga11().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:spruce_leaves"))), 10);
        WNBiomeFeatures.addTree(this, new tree_taiga12().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:spruce_leaves"))), 10);

        WNBiomeFeatures.addTree(this, new thin_pine1(), 3);
        WNBiomeFeatures.addTree(this, new thin_pine2(), 3);
        WNBiomeFeatures.addTree(this, new thin_pine3(), 3);
        WNBiomeFeatures.addTree(this, new thin_pine4(), 3);

        WNBiomeFeatures.addTree(this, new tree_fir13().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:fir_leaves"))), 5);
        WNBiomeFeatures.addTree(this, new tree_fir25().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:fir_leaves"))), 5);
        WNBiomeFeatures.addTree(this, new tree_fir23().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:fir_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_fir22().setCustomLog(Main.getBlockByID("minecraft:spruce_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:fir_leaves"))), 5);

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

        WNBiomeFeatures.addTree(this, new leafy_beech_1(), 1);
        WNBiomeFeatures.addTree(this, new thick_beech2(), 1);
        WNBiomeFeatures.addTree(this, new thick_beech3(), 1);
        WNBiomeFeatures.addTree(this, new thick_beech4(), 1);

        WNBiomeFeatures.addTree(this, new thick_beech1(), 1);
        WNBiomeFeatures.addTree(this, new thick_beech2(), 1);
        WNBiomeFeatures.addTree(this, new thick_beech3(), 1);
        WNBiomeFeatures.addTree(this, new thick_beech4(), 1);

        WNBiomeFeatures.addTree(this, new leafy_beech_1().setCustomLog(null).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PURPLE_BEECH_LEAVES)), 1);

        WNBiomeFeatures.addTree(this, new rowan3(), 1);

        WNBiomeFeatures.addTree(this, new shrub1(), 2);
        WNBiomeFeatures.addTree(this, new shrub1().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);

        WNBiomeFeatures.addBlob(this, WNBlocks.BROWN_GRASS_BLOCK.getDefaultState(), 2, true, false, 3);

        plantRate = 2;
        treeRate = 14;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 2, 1, 3));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 2, 1, 3));
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
        return customColor(noise, -0.1D, 0x63C47D, 0x77C45B);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0x5DB259, 0x7FBC70);
    }


}