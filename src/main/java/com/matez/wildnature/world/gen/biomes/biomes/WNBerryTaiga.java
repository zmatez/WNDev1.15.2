package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.beech.thick_beech1;
import com.matez.wildnature.world.gen.structures.nature.woods.beech.thick_beech2;
import com.matez.wildnature.world.gen.structures.nature.woods.beech.thick_beech3;
import com.matez.wildnature.world.gen.structures.nature.woods.beech.thick_beech4;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.thin_birch1;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.thin_birch2;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.thin_birch3;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.thin_birch4;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.thin_pine1;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.thin_pine2;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.thin_pine3;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.thin_pine4;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
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

public class WNBerryTaiga extends WNBiome {
    public WNBerryTaiga(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.CUSTOM_SURFACE_BUILDER, new CustomSurfaceBuilderConfig(new CustomSurfaceBuilder.BlockCfg(SurfaceRegistry.BROWN_CONFIG, 5), new CustomSurfaceBuilder.BlockCfg(SurfaceRegistry.BROWN_PODZOL_CONFIG, 1)))
                .precipitation(RainType.RAIN)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.2F)
                .scale(0.15F)
                .temperature(0.21F)
                .downfall(0.5F)
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
        WNBiomeFeatures.addGrass(this, 8);
        WNBiomeFeatures.addGrass(this, 5, Blocks.FERN.getDefaultState());
        WNBiomeFeatures.addGrass(this, 15, Blocks.LARGE_FERN.getDefaultState(), true);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addBerryBushes(this);
        WNBiomeFeatures.addBerryBushes(this);
        WNBiomeFeatures.addBerryBushes(this);
        WNBiomeFeatures.addTaigaRocks(this);

        WNBiomeFeatures.addPlant(this, WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATH_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.FORGET_ME_NOT_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.THUJA.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.THUJA_LARGE.getDefaultState(), 1);
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
        WNBiomeFeatures.addPlant(this, WNBlocks.BUSH_WILD_BLUEBERRY.getDefaultState(), 15);

        WNBiomeFeatures.addTree(this, new thin_pine1(), 7);
        WNBiomeFeatures.addTree(this, new thin_pine2(), 7);
        WNBiomeFeatures.addTree(this, new thin_pine3(), 7);
        WNBiomeFeatures.addTree(this, new thin_pine4(), 7);

        WNBiomeFeatures.addTree(this, new thin_birch1(), 1);
        WNBiomeFeatures.addTree(this, new thin_birch2(), 1);
        WNBiomeFeatures.addTree(this, new thin_birch3(), 1);
        WNBiomeFeatures.addTree(this, new thin_birch4(), 1);

        WNBiomeFeatures.addTree(this, new thick_beech2(), 1);
        WNBiomeFeatures.addTree(this, new thick_beech3(), 1);
        WNBiomeFeatures.addTree(this, new thick_beech4(), 1);

        WNBiomeFeatures.addTree(this, new thick_beech1(), 1);
        WNBiomeFeatures.addTree(this, new thick_beech2(), 1);
        WNBiomeFeatures.addTree(this, new thick_beech3(), 1);
        WNBiomeFeatures.addTree(this, new thick_beech4(), 1);


        WNBiomeFeatures.addTree(this, new shrub1().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)), 1);

        WNBiomeFeatures.addBlob(this, WNBlocks.BROWN_GRASS_BLOCK.getDefaultState(), 2, true, false, 3);

        plantRate = 4;
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