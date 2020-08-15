package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.pointy_birch1;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.pointy_birch2;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.pointy_birch3;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.pointy_birch4;
import com.matez.wildnature.world.gen.structures.nature.woods.cedar.weeping_cedar_1;
import com.matez.wildnature.world.gen.structures.nature.woods.cedar.weeping_cedar_2;
import com.matez.wildnature.world.gen.structures.nature.woods.cedar.weeping_cedar_3;
import com.matez.wildnature.world.gen.structures.nature.woods.cedar.weeping_cedar_4;
import com.matez.wildnature.world.gen.structures.nature.woods.deco.forsythia3;
import com.matez.wildnature.world.gen.structures.nature.woods.deco.forsythia4;
import com.matez.wildnature.world.gen.structures.nature.woods.deco.forsythia5;
import com.matez.wildnature.world.gen.structures.nature.woods.deco.magnolia3;
import com.matez.wildnature.world.gen.structures.nature.woods.hazel.hazel1;
import com.matez.wildnature.world.gen.structures.nature.woods.hazel.hazel2;
import com.matez.wildnature.world.gen.structures.nature.woods.hazel.hazel3;
import com.matez.wildnature.world.gen.structures.nature.woods.hazel.hazel4;
import com.matez.wildnature.world.gen.structures.nature.woods.oaklands.*;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan1;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan2;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan3;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan4;
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

public class WNHornbeamValley extends WNBiome {
    public WNHornbeamValley(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.CUSTOM_SURFACE_BUILDER, new CustomSurfaceBuilderConfig(new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG, 4), new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.PODZOL_DIRT_GRAVEL_CONFIG, 1)))
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

        WNBiomeFeatures.addPlant(this, WNBlocks.HYACINTH_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HYACINTH_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.HYACINTH_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.HYACINTH_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.MARIGOLD_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.MARIGOLD_ORANGE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.YEW_BUSH.getDefaultState(), 5);
        WNBiomeFeatures.addPlant(this, WNBlocks.CLOVER.getDefaultState(), 5);
        WNBiomeFeatures.addPlant(this, WNBlocks.LEAF_PILE.getDefaultState(), 5);
        WNBiomeFeatures.addPlant(this, WNBlocks.GRASS_WHEAT.getDefaultState().with(FloweringBushBase.FLOWERING, true), 6);


        WNBiomeFeatures.addTree(this, new rowan1(), 1);
        WNBiomeFeatures.addTree(this, new rowan2(), 1);
        WNBiomeFeatures.addTree(this, new rowan3(), 1);
        WNBiomeFeatures.addTree(this, new rowan4(), 1);

        WNBiomeFeatures.addTree(this, new pointy_birch1(), 1);
        WNBiomeFeatures.addTree(this, new pointy_birch2(), 1);
        WNBiomeFeatures.addTree(this, new pointy_birch3(), 1);
        WNBiomeFeatures.addTree(this, new pointy_birch4(), 1);


        WNBiomeFeatures.addTree(this, new hazel1(), 4);
        WNBiomeFeatures.addTree(this, new hazel2(), 4);
        WNBiomeFeatures.addTree(this, new hazel3(), 4);
        WNBiomeFeatures.addTree(this, new hazel4(), 4);

        WNBiomeFeatures.addTree(this, new oaklands_smallshrub1(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_smallshrub2(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_smallshrub3(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_shrub1(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_shrub2(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_shrub5(), 1);
        WNBiomeFeatures.addTree(this, new shrub1(), 10);

        WNBiomeFeatures.addTree(this, new weeping_cedar_1(), 1);
        WNBiomeFeatures.addTree(this, new weeping_cedar_2(), 1);
        WNBiomeFeatures.addTree(this, new weeping_cedar_3(), 1);
        WNBiomeFeatures.addTree(this, new weeping_cedar_4(), 1);

        WNBiomeFeatures.addTree(this, new magnolia3(), 1);
        WNBiomeFeatures.addTree(this, new forsythia3(), 1);
        WNBiomeFeatures.addTree(this, new forsythia4(), 1);
        WNBiomeFeatures.addTree(this, new forsythia5(), 1);

        WNBiomeFeatures.addBlob(this, Blocks.PODZOL.getDefaultState(), 2, true, false, 3);

        plantRate = 2;
        treeRate = 2;

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
        return customColor(noise, -0.1D, 0x80D23D, 0x7ECB6E);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0x73BC49, 0x61B93D);
    }


}