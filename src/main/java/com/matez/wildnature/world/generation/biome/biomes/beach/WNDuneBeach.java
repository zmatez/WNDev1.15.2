package com.matez.wildnature.world.generation.biome.biomes.beach;

import com.matez.wildnature.common.blocks.FloweringDesertBush;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.structures.nature.woods.dead.*;
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

public class WNDuneBeach extends WNBiome {
    public WNDuneBeach(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(WNSurfaceBuilders.CUSTOM_SURFACE_BUILDER, new CustomSurfaceBuilderConfig(new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.DESERT_CONFIG, 1), new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.SAND_CONFIG, 10)))
                .precipitation(RainType.RAIN)
                .category(Category.BEACH)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.2F)
                .scale(0.1F)
                .temperature(0.8F)
                .downfall(0.4F)
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
        WNBiomeFeatures.addGrass(this);
        WNBiomeFeatures.addFreezeTopLayer(this);
        WNBiomeFeatures.addShipwrecks(this);
        WNBiomeFeatures.addBuriedTreasures(this);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addGrass(this,5);

        WNBiomeFeatures.addPlant(this, WNBlocks.DEAD_SHORT_GRASS.getDefaultState(), 5);
        WNBiomeFeatures.addPlant(this, WNBlocks.RED_SAND_VERBENA.getDefaultState().with(FloweringDesertBush.FLOWERING,true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.SMALL_CACTI.getDefaultState(), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HOTTENTOT.getDefaultState().with(FloweringDesertBush.FLOWERING,true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.SEABEACH_SANDWORT.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.RED_ALGAE.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.ALGAE.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.SEA_ANEMONE.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.SHALLOW_WATER_GRASS.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.LILY_TONGUE.getDefaultState(), 1);

        WNBiomeFeatures.addTree(this, new dead1(), 12);
        WNBiomeFeatures.addTree(this, new dead2(), 12);
        WNBiomeFeatures.addTree(this, new dead3(), 12);
        WNBiomeFeatures.addTree(this, new dead4(), 12);
        WNBiomeFeatures.addTree(this, new dead5(), 12);
        WNBiomeFeatures.addTree(this, new dead6(), 12);

        treeRate = 0;
        treeExtra = 1;
        treeExtraChance = 0.7f;

        plantRate = 3;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.TURTLE, 5, 2, 5));
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
        return customColor(noise, -0.1D, 0xD5D687, 0xD6D479);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0xB3DE79, 0xB3DE79);
    }


}