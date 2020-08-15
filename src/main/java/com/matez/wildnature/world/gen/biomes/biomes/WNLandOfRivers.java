package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir5;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.oak1;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.oak2;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.oak3;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga10;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga17;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga2;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga9;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import com.matez.wildnature.world.gen.surface.configs.CanyonSurfaceBuilderConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNLandOfRivers extends WNBiome {
    public WNLandOfRivers(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.RIVER_SURFACE_BUILDER, new CanyonSurfaceBuilderConfig(SurfaceRegistry.BROWN_PODZOL_GRAVEL, SurfaceBuilder.DEFAULT))
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.0F)
                .scale(0.02F)
                .temperature(0.6F)
                .downfall(0.8F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));


        WNBiomeFeatures.addVillages(this, "village/taiga/town_centers", 1);
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
        WNBiomeFeatures.addTaigaConifers(this);
        WNBiomeFeatures.addTaigaRocks(this);
        WNBiomeFeatures.addPlant(this, WNBlocks.YEW_BUSH.getDefaultState(), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.CLOVER.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.DEAD_LEAF_PILE.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);

        WNBiomeFeatures.addTree(this, new oak1(), 2);
        WNBiomeFeatures.addTree(this, new oak2(), 2);
        WNBiomeFeatures.addTree(this, new oak3(), 2);
        WNBiomeFeatures.addTree(this, new seasonal_birch1().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new seasonal_birch2().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new seasonal_birch3().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new seasonal_birch4().setCustomLeafOverride(SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new tree_taiga2().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Blocks.SPRUCE_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_taiga17().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WNBlocks.FIR_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new tree_taiga9().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Blocks.SPRUCE_LEAVES)), 3);
        WNBiomeFeatures.addTree(this, new tree_taiga10().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Blocks.SPRUCE_LEAVES)), 3);
        WNBiomeFeatures.addTree(this, new tree_fir5().setCustomLog(Blocks.SPRUCE_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Blocks.SPRUCE_LEAVES)), 2);


        plantRate = 1;
        treeRate = 11;

        applyPlants();
        applyTrees();


        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
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
        return customColor(noise, -0.1D, 13410673, 13419628);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 12766316, 10730594);
    }


}