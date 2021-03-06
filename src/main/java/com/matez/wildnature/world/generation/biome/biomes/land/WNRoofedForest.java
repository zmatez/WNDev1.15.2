package com.matez.wildnature.world.generation.biome.biomes.land;

import com.matez.wildnature.common.blocks.FloweringBushBase;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.woods.deco.forsythia1;
import com.matez.wildnature.world.generation.structures.nature.woods.greenwood.greenwood1;
import com.matez.wildnature.world.generation.structures.nature.woods.greenwood.greenwood2;
import com.matez.wildnature.world.generation.structures.nature.woods.greenwood.greenwood3;
import com.matez.wildnature.world.generation.structures.nature.woods.greenwood.greenwood4;
import com.matez.wildnature.world.generation.structures.nature.woods.oak.dark_high_oak_1;
import com.matez.wildnature.world.generation.structures.nature.woods.oak.dark_high_oak_2;
import com.matez.wildnature.world.generation.structures.nature.woods.oak.dark_high_oak_3;
import com.matez.wildnature.world.generation.structures.nature.woods.oak.dark_high_oak_4;
import com.matez.wildnature.world.generation.structures.nature.woods.oaklands.*;
import com.matez.wildnature.world.generation.structures.nature.woods.rowan.rowan4;
import com.matez.wildnature.world.generation.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.generation.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.generation.surface.builders.CustomSurfaceBuilder;
import com.matez.wildnature.world.generation.surface.configs.CustomSurfaceBuilderConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNRoofedForest extends WNBiome {
    public WNRoofedForest(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(WNSurfaceBuilders.CUSTOM_SURFACE_BUILDER, new CustomSurfaceBuilderConfig(new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG, 4), new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.PODZOL_DIRT_GRAVEL_CONFIG, 1)))
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.5F)
                .scale(0.3F)
                .temperature(0.4F)
                .downfall(0.8F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.DOUBLE_DARK_OAK,LogType.ROOFED,LogType.ROWAN,LogType.FORSYTHIA)
                .parent(null));

        WNBiomeFeatures.addWoodlandMansions(this);
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
        WNBiomeFeatures.addGrass(this, 10);
        WNBiomeFeatures.addGrass(this, 5, Blocks.FERN.getDefaultState());


        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addHugeMushrooms(this, 1);

        WNBiomeFeatures.addPlant(this, WNBlocks.HYACINTH_DARK_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HYACINTH_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.HYACINTH_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.MARIGOLD_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.VIBURNUM_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.VIBURNUM_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.GERANIUM_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);

        WNBiomeFeatures.addPlant(this, WNBlocks.YEW_BUSH.getDefaultState(), 5);
        WNBiomeFeatures.addPlant(this, WNBlocks.CLOVER.getDefaultState(), 5);
        WNBiomeFeatures.addPlant(this, WNBlocks.LEAF_PILE.getDefaultState(), 5);
        WNBiomeFeatures.addPlant(this, WNBlocks.GRASS_WHEAT.getDefaultState().with(FloweringBushBase.FLOWERING, true), 6);

        WNBiomeFeatures.addTree(this, new greenwood1(), 1);
        WNBiomeFeatures.addTree(this, new greenwood2(), 1);
        WNBiomeFeatures.addTree(this, new greenwood3(), 1);
        WNBiomeFeatures.addTree(this, new greenwood4(), 1);

        WNBiomeFeatures.addTree(this, new dark_high_oak_1(), 7);
        WNBiomeFeatures.addTree(this, new dark_high_oak_2(), 7);
        WNBiomeFeatures.addTree(this, new dark_high_oak_3(), 7);
        WNBiomeFeatures.addTree(this, new dark_high_oak_4(), 7);

        WNBiomeFeatures.addTree(this, new forsythia1(), 1);
        WNBiomeFeatures.addTree(this, new rowan4(), 1);


        WNBiomeFeatures.addTree(this, new oaklands_smallshrub1(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_smallshrub2(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_smallshrub3(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_shrub1(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_shrub2(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_shrub5(), 1);
        WNBiomeFeatures.addTree(this, new shrub1().setCustomLog(Blocks.DARK_OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Blocks.DARK_OAK_LEAVES)), 20);

        WNBiomeFeatures.addBlob(this, Blocks.PODZOL.getDefaultState(), 2, true, false, 3);

        plantRate = 3;
        treeRate = 35;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 2, 4, 4));
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
        return customColor(noise, -0.1D, 0x6AC855, 0x7DD05E);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0x53B33B, 0x5AB43E);
    }


}