package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.LogType;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.oaklands.*;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.tall_pine1;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.tall_pine2;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.tall_pine3;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.tall_pine4;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan4;
import com.matez.wildnature.world.gen.structures.nature.woods.sequoia.*;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import com.matez.wildnature.world.gen.surface.builders.CustomSurfaceBuilder;
import com.matez.wildnature.world.gen.surface.configs.CustomSurfaceBuilderConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNAutumnalSequoiaRainforest extends WNBiome {
    public WNAutumnalSequoiaRainforest(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.CUSTOM_SURFACE_BUILDER, new CustomSurfaceBuilderConfig(new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG, 4), new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.PODZOL_DIRT_GRAVEL_CONFIG, 1)))
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.15F)
                .scale(0.03F)
                .temperature(0.23F)
                .downfall(1F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.METASEQUOIA_GREEN, LogType.ROWAN)
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
        WNBiomeFeatures.addGrass(this, 6);
        WNBiomeFeatures.addGrass(this, 10, Blocks.FERN.getDefaultState());
        WNBiomeFeatures.addGrass(this, 7, WNBlocks.MOSS.getDefaultState());
        WNBiomeFeatures.addGrass(this, 30, Blocks.LARGE_FERN.getDefaultState(), true);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this, WNBlocks.YEW_BUSH.getDefaultState(), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.CLOVER.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.LEAF_PILE.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.PASQUE_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.GRASS_FLOWER.getDefaultState().with(FloweringBushBase.FLOWERING, true), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEPATICA_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.PERENNIAL_VIOLET.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.PERENNIAL_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATH_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATH_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.THUJA.getDefaultState(), 1);

        WNBiomeFeatures.addTree(this, new sequoia1().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_GREEN_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia2().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_GREEN_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia3().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_GREEN_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia4().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_GREEN_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia5().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_GREEN_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia6().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_GREEN_LEAVES)), 1);

        WNBiomeFeatures.addTree(this, new sequoia1().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_BROWN_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia2().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_BROWN_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia3().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_BROWN_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia4().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_BROWN_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia5().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_BROWN_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia6().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_BROWN_LEAVES)), 1);

        WNBiomeFeatures.addTree(this, new sequoia1().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_YELLOW_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia2().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_YELLOW_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia3().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_YELLOW_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia4().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_YELLOW_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia5().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_YELLOW_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia6().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_YELLOW_LEAVES)), 1);

        WNBiomeFeatures.addTree(this, new sequoia1().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_ORANGE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia2().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_ORANGE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia3().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_ORANGE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia4().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_ORANGE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia5().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_ORANGE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia6().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_ORANGE_LEAVES)), 1);

        WNBiomeFeatures.addTree(this, new sequoia1().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_RED_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia2().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_RED_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia3().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_RED_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia4().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_RED_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia5().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_RED_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new sequoia6().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_RED_LEAVES)), 1);

        WNBiomeFeatures.addTree(this, new tall_pine1(), 2);
        WNBiomeFeatures.addTree(this, new tall_pine2(), 2);
        WNBiomeFeatures.addTree(this, new tall_pine3(), 2);
        WNBiomeFeatures.addTree(this, new tall_pine4(), 2);

        WNBiomeFeatures.addTree(this, new oaklands_oak1().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_YELLOW_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new oaklands_oak2().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_YELLOW_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new oaklands_oak3().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_RED_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new oaklands_oak4().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_RED_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new oaklands_oak5().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_GREEN_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new oaklands_oak6().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_GREEN_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new oaklands_oak7().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_ORANGE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new oaklands_oak8().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_ORANGE_LEAVES)), 1);


        WNBiomeFeatures.addTree(this, new rowan4(), 1);
        //WNBiomeFeatures.addTree(this, new wild_cherry2(), 1);

        WNBiomeFeatures.addTree(this, new oaklands_smallshrub1().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_ORANGE_LEAVES)), 3);
        WNBiomeFeatures.addTree(this, new oaklands_smallshrub2().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_BROWN_LEAVES)), 3);
        WNBiomeFeatures.addTree(this, new oaklands_smallshrub3().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_ORANGE_LEAVES)), 3);
        WNBiomeFeatures.addTree(this, new shrub1().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_RED_LEAVES)), 10);
        WNBiomeFeatures.addTree(this, new shrub1().setCustomLogAndLeaf(WNBlocks.REDWOOD_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.METASEQUOIA_BROWN_LEAVES)), 10);


        WNBiomeFeatures.addBlob(this, Blocks.PODZOL.getDefaultState(), 2, true, false, 3);

        plantRate = 2;
        treeRate = 14;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 5, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 2, 1, 3));
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
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.007D, (double) pos.getZ() * 0.007D, false);
        return customColor(noise, -0.1D, 0x7FE282, 0x90E287);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0x8CD660, 0x9DE549);
    }

    @Override
    public int getSkyColor() {
        return 0xCBF5FF;
    }
}