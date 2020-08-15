package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.beech.*;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir6;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir9;
import com.matez.wildnature.world.gen.structures.nature.woods.larch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.*;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan3;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan4;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga11;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga12;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNTatraLowerForest extends WNBiome {
    public WNTatraLowerForest(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.PODZOL_SURFACE_BUILDER, SurfaceRegistry.BROWN_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.EXTREME_HILLS)
                .topography(WNBiomeBuilder.Topography.HIGH_MOUNTAINS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(1.2F)
                .scale(0.5F)
                .temperature(0.3F)
                .downfall(0.9F)
                .waterColor(4159204)
                .waterFogColor(329011)
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
        WNBiomeFeatures.addGrass(this, 5, WNBlocks.MEDIUM_GRASS.getDefaultState());
        WNBiomeFeatures.addGrass(this, 15, Blocks.TALL_GRASS.getDefaultState(), true);
        WNBiomeFeatures.addGrass(this, 5, Blocks.FERN.getDefaultState());
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this, WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.PASQUE_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.CROCUS_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.PRIMROSE_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.FIRE_WEED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATH_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addBlob(this, WNBlocks.BROWN_PODZOL.getDefaultState(), 2, true, false, 3);
        WNBiomeFeatures.addBlob(this, WNBlocks.GRANITE_COBBLE_MOSSY.getDefaultState(), 3, false, true, 1);

        WNBiomeFeatures.addTree(this, new tree_fir9().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)), 8);
        WNBiomeFeatures.addTree(this, new tree_fir6().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)), 8);
        WNBiomeFeatures.addTree(this, new tree_taiga12().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Blocks.SPRUCE_LEAVES)), 7);
        WNBiomeFeatures.addTree(this, new tree_taiga11().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Blocks.SPRUCE_LEAVES)), 7);

        WNBiomeFeatures.addTree(this, new thin_pine1(), 2);
        WNBiomeFeatures.addTree(this, new thin_pine2(), 3);
        WNBiomeFeatures.addTree(this, new thin_pine3(), 2);
        WNBiomeFeatures.addTree(this, new thin_pine4(), 3);

        WNBiomeFeatures.addTree(this, new beech1(), 3);
        WNBiomeFeatures.addTree(this, new beech2(), 3);
        WNBiomeFeatures.addTree(this, new beech3(), 3);
        WNBiomeFeatures.addTree(this, new beech4(), 3);
        WNBiomeFeatures.addTree(this, new leafy_beech_1(), 3);
        WNBiomeFeatures.addTree(this, new leafy_beech_2(), 3);
        WNBiomeFeatures.addTree(this, new leafy_beech_3(), 3);

        WNBiomeFeatures.addTree(this, new tree_pine1().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new tree_pine2().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new tree_pine3().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new tree_pine4().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new tree_pine5().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new tree_pine6().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 1);

        WNBiomeFeatures.addTree(this, new tree_larch1().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch2().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch3().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch4().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch5().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch6().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch7().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch8().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_larch9().setCustomLog(Main.getBlockByID("wildnature:larch_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))), 1);

        WNBiomeFeatures.addTree(this, new rowan3(), 1);
        WNBiomeFeatures.addTree(this, new rowan4(), 1);
        plantRate = 4;
        treeRate = 16;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 3, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 5, 4, 4));
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
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0065D, (double) pos.getZ() * 0.0065D, false);
        return customColor(noise, -0.1D, 0x87C250, 0x72C248);
    }


}