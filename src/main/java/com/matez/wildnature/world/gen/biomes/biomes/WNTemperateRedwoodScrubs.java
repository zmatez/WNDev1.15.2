package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.cedar.*;
import com.matez.wildnature.world.gen.structures.nature.woods.cherry.wild_cherry3;
import com.matez.wildnature.world.gen.structures.nature.woods.cherry.wild_cherry4;
import com.matez.wildnature.world.gen.structures.nature.woods.deco.forsythia3;
import com.matez.wildnature.world.gen.structures.nature.woods.deco.forsythia4;
import com.matez.wildnature.world.gen.structures.nature.woods.deco.forsythia5;
import com.matez.wildnature.world.gen.structures.nature.woods.deco.magnolia4;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.*;
import com.matez.wildnature.world.gen.structures.nature.woods.oaklands.*;
import com.matez.wildnature.world.gen.structures.nature.woods.orchard.pear1;
import com.matez.wildnature.world.gen.structures.nature.woods.orchard.pear3;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.structures.nature.woods.small_redwood.*;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga1;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import com.matez.wildnature.world.gen.surface.builders.CustomSurfaceBuilder;
import com.matez.wildnature.world.gen.surface.configs.CustomSurfaceBuilderConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNTemperateRedwoodScrubs extends WNBiome {
    public WNTemperateRedwoodScrubs(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.CUSTOM_SURFACE_BUILDER, new CustomSurfaceBuilderConfig(new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG, 4), new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.PODZOL_DIRT_GRAVEL_CONFIG, 1)))
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.15F)
                .scale(0.03F)
                .temperature(0.4F)
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

        WNBiomeFeatures.addPlant(this, WNBlocks.SCOTCHBROOM_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.CARNATION_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.CHRYSANTHEMUM_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.CHRYSANTHEMUM_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.YEW_BUSH.getDefaultState(), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.CLOVER.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.LEAF_PILE.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.GRASS_WHEAT.getDefaultState().with(FloweringBushBase.FLOWERING, true), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.VIBURNUM_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.IRIS_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);

        WNBiomeFeatures.addTree(this, new small_redwood1(), 2);
        WNBiomeFeatures.addTree(this, new small_redwood2(), 2);
        WNBiomeFeatures.addTree(this, new small_redwood3(), 2);
        WNBiomeFeatures.addTree(this, new small_redwood4(), 2);
        WNBiomeFeatures.addTree(this, new small_redwood5(), 2);
        WNBiomeFeatures.addTree(this, new small_redwood6(), 2);
        WNBiomeFeatures.addTree(this, new weeping_cedar_1(), 2);
        WNBiomeFeatures.addTree(this, new weeping_cedar_2(), 2);
        WNBiomeFeatures.addTree(this, new weeping_cedar_3(), 2);
        WNBiomeFeatures.addTree(this, new weeping_cedar_4(), 2);
        WNBiomeFeatures.addTree(this, new weeping_cedar_5(), 2);
        WNBiomeFeatures.addTree(this, new weeping_cedar_6(), 2);
        WNBiomeFeatures.addTree(this, new spiky_birch_1(), 2);
        WNBiomeFeatures.addTree(this, new spiky_birch_2(), 2);
        WNBiomeFeatures.addTree(this, new spiky_birch_3(), 2);
        WNBiomeFeatures.addTree(this, new spiky_birch_4(), 2);
        WNBiomeFeatures.addTree(this, new pointy_birch1(), 2);
        WNBiomeFeatures.addTree(this, new pointy_birch2(), 2);
        WNBiomeFeatures.addTree(this, new pointy_birch3(), 2);
        WNBiomeFeatures.addTree(this, new pointy_birch4(), 2);
        WNBiomeFeatures.addTree(this, new pointy_oak_1(), 2);
        WNBiomeFeatures.addTree(this, new pointy_oak_2(), 2);
        WNBiomeFeatures.addTree(this, new pointy_oak_3(), 2);
        WNBiomeFeatures.addTree(this, new pointy_oak_4(), 2);
        WNBiomeFeatures.addTreeVines(this, WNBlocks.ROSEVINE_RED.getDefaultState(), 1, 80);


        WNBiomeFeatures.addTree(this, new pear1(), 1);
        WNBiomeFeatures.addTree(this, new pear3(), 1);
        WNBiomeFeatures.addTree(this, new tree_oak5().setCustomLog(Main.getBlockByID("wildnature:plum_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:plum_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_oak5().setCustomLog(Main.getBlockByID("wildnature:plum_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:mirabelle_plum_leaves"))), 1);


        WNBiomeFeatures.addTree(this, new oaklands_smallshrub1(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_smallshrub2(), 2);
        WNBiomeFeatures.addTree(this, new oaklands_smallshrub3(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_shrub1(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_shrub2(), 2);
        WNBiomeFeatures.addTree(this, new oaklands_shrub5(), 1);
        WNBiomeFeatures.addTree(this, new shrub1(), 2);
        BlockState redwoodLog = Main.getBlockByID("wildnature:redwood_log").getDefaultState();
        BlockState redwoodLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("wildnature:redwood_leaves"));
        WNBiomeFeatures.addTree(this, new shrub1().setCustomLog(redwoodLog).setCustomLeaf(redwoodLeaves), 3);
        WNBiomeFeatures.addTree(this, new wild_cherry3(), 1);
        WNBiomeFeatures.addTree(this, new wild_cherry4(), 1);
        WNBiomeFeatures.addTree(this, new magnolia4(), 1);
        WNBiomeFeatures.addTree(this, new forsythia3(), 1);
        WNBiomeFeatures.addTree(this, new forsythia4(), 1);
        WNBiomeFeatures.addTree(this, new forsythia5(), 1);

        WNBiomeFeatures.addBlob(this, Blocks.PODZOL.getDefaultState(), 2, true, false, 3);

        plantRate = 2;
        treeRate = 10;

        applyPlants();
        applyTrees();

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
        return customColor(noise, -0.1D, 0x9DD644, 0x92CB5F);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0x8CC948, 0xA4D55C);
    }


}