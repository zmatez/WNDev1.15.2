package com.matez.wildnature.world.generation.biome.biomes.land;

import com.matez.wildnature.common.blocks.FloweringBushBase;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.woods.birch.thin_birch1;
import com.matez.wildnature.world.generation.structures.nature.woods.birch.thin_birch2;
import com.matez.wildnature.world.generation.structures.nature.woods.birch.thin_birch3;
import com.matez.wildnature.world.generation.structures.nature.woods.birch.thin_birch4;
import com.matez.wildnature.world.generation.structures.nature.woods.boreal.*;
import com.matez.wildnature.world.generation.structures.nature.woods.pine.*;
import com.matez.wildnature.world.generation.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.generation.structures.nature.woods.willow.small_willow1;
import com.matez.wildnature.world.generation.structures.nature.woods.willow.small_willow2;
import com.matez.wildnature.world.generation.structures.nature.woods.willow.small_willow3;
import com.matez.wildnature.world.generation.structures.nature.woods.willow.small_willow4;
import com.matez.wildnature.world.generation.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.generation.surface.builders.CustomSurfaceBuilder;
import com.matez.wildnature.world.generation.surface.configs.CustomSurfaceBuilderConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNMoor extends WNBiome {
    public WNMoor(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(WNSurfaceBuilders.CUSTOM_SURFACE_BUILDER, new CustomSurfaceBuilderConfig(new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_PODZOL_CONFIG, 5), new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_CONFIG, 1)))
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.15F)
                .scale(0.03F)
                .temperature(0.25F)
                .downfall(0.7F)
                .waterColor(0x1753BF)
                .waterFogColor(0x030A2A)
                .logTypes(LogType.PINE,LogType.BIRCH_THICK,LogType.WILLOW)
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
        WNBiomeFeatures.addGrass(this, 8);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this, WNBlocks.HEATH_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 7);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATH_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 7);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATH_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 7);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING, true), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 4);
        WNBiomeFeatures.addPlant(this, Blocks.FERN.getDefaultState(), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.FORGET_ME_NOT_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.THUJA.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.THUJA_LARGE.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.PERENNIAL_BLUE.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.PERENNIAL_VIOLET.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.CLOVER.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.LEAF_PILE.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.VIBURNUM_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.IRIS_VIOLET.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);

        WNBiomeFeatures.addTree(this, new tree_pine1().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_pine2().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_pine3().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_pine4().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_pine5().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_pine6().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_bpine1().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_bpine2().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_bpine3().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_bpine4().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_bpine5().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_bpine6().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);

        WNBiomeFeatures.addTree(this, new thin_birch1(), 5);
        WNBiomeFeatures.addTree(this, new thin_birch2(), 5);
        WNBiomeFeatures.addTree(this, new thin_birch3(), 5);
        WNBiomeFeatures.addTree(this, new thin_birch4(), 5);

        WNBiomeFeatures.addTree(this, new small_willow1(), 2);
        WNBiomeFeatures.addTree(this, new small_willow2(), 2);
        WNBiomeFeatures.addTree(this, new small_willow3(), 2);
        WNBiomeFeatures.addTree(this, new small_willow4(), 2);

        WNBiomeFeatures.addTree(this, new shrub1().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 2);

        WNBiomeFeatures.addBlob(this, WNBlocks.BROWN_GRASS_BLOCK.getDefaultState(), 2, true, false, 3);
        WNBiomeFeatures.addBlob(this, Blocks.COARSE_DIRT.getDefaultState(), 2, true, false, 1);

        plantRate = 10;
        treeRate = 0;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 2, 1, 3));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 1, 1, 3));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 10, 4, 4));
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
        return customColor(noise, -0.1D, 0xC4A28A, 0xC4B78E);
    }//8536 83 13546

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0xA0C18D, 0x9CC179);
    }


}