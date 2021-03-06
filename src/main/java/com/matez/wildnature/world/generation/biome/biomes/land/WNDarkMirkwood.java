package com.matez.wildnature.world.generation.biome.biomes.land;

import com.matez.wildnature.common.blocks.FloweringBushBase;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.structures.nature.woods.spooky.*;
import com.matez.wildnature.world.generation.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.generation.surface.builders.CustomSurfaceBuilder;
import com.matez.wildnature.world.generation.surface.configs.CustomSurfaceBuilderConfig;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNDarkMirkwood extends WNBiome {
    public WNDarkMirkwood(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(WNSurfaceBuilders.CUSTOM_SURFACE_BUILDER, new CustomSurfaceBuilderConfig(new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG, 10), new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.PODZOL_DIRT_GRAVEL_CONFIG, 1)))
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.08F)
                .scale(0.1F)
                .temperature(0.2F)
                .downfall(0.15F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.SPOOKY)
                .parent(null));

        WNBiomeFeatures.addWoodlandMansions(this);
        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addSwampHuts(this);
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
        WNBiomeFeatures.addPlant(this, WNBlocks.RADISSIUM_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.RADISSIUM_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.RADISSIUM_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.YEW_BUSH.getDefaultState(), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.PASQUE_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.VIBURNUM_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.CLOVER.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.LEAF_PILE.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.SPIDERGRASS.getDefaultState().with(FloweringBushBase.FLOWERING, true), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.LAMPGRASS.getDefaultState().with(FloweringBushBase.FLOWERING, true), 6);


        WNBiomeFeatures.addTree(this, new spooky_big1(), 3);
        WNBiomeFeatures.addTree(this, new spooky_big2(), 3);
        WNBiomeFeatures.addTree(this, new spooky_big3(), 3);
        WNBiomeFeatures.addTree(this, new spooky_big4(), 3);
        WNBiomeFeatures.addTree(this, new spooky_big5(), 3);
        WNBiomeFeatures.addTree(this, new spooky_big6(), 3);
        WNBiomeFeatures.addTree(this, new spooky_big7(), 3);
        WNBiomeFeatures.addTree(this, new spooky_big8(), 3);

        WNBiomeFeatures.addTree(this, new spooky1(), 1);
        WNBiomeFeatures.addTree(this, new spooky2(), 1);
        WNBiomeFeatures.addTree(this, new spooky3(), 1);
        WNBiomeFeatures.addTree(this, new spooky4(), 1);
        WNBiomeFeatures.addTree(this, new spooky5(), 1);
        WNBiomeFeatures.addTree(this, new spooky6(), 1);
        WNBiomeFeatures.addTree(this, new spooky7(), 1);
        WNBiomeFeatures.addTree(this, new spooky8(), 1);
        WNBiomeFeatures.addTree(this, new spooky9(), 1);
        WNBiomeFeatures.addTree(this, new spooky10(), 1);
        WNBiomeFeatures.addTree(this, new spooky11(), 1);
        WNBiomeFeatures.addTree(this, new spooky12(), 1);
        WNBiomeFeatures.addTree(this, new spooky13(), 1);
        WNBiomeFeatures.addTree(this, new spooky14(), 3);
        WNBiomeFeatures.addTree(this, new spooky15(), 3);

        treeRate = 22;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 15, 8, 8));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 5, 4, 4));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 40, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 200, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CAVE_SPIDER, 200, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 65, 1, 2));

    }


    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0x406E28, 0x276B27);
    }


}