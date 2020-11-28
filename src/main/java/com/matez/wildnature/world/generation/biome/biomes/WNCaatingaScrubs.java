package com.matez.wildnature.world.generation.biome.biomes;

import com.matez.wildnature.common.blocks.FloweringBushBase;
import com.matez.wildnature.common.blocks.FloweringDesertBush;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.util.other.BlockWeighList;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.structures.nature.woods.acacia.*;
import com.matez.wildnature.world.generation.structures.nature.woods.baobab.*;
import com.matez.wildnature.world.generation.structures.nature.woods.dead.*;
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

public class WNCaatingaScrubs extends WNBiome {
    public WNCaatingaScrubs(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(WNSurfaceBuilders.CUSTOM_SURFACE_BUILDER, new CustomSurfaceBuilderConfig(new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.DESERT_CONFIG, 4), new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.SAND_CONFIG, 1)))
                .precipitation(RainType.NONE)
                .category(Category.SAVANNA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.3F)
                .scale(0.1F)
                .temperature(1F)
                .downfall(0.0F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.ACACIA,LogType.DEAD, LogType.BAOBAB)
                .parent(null));


        WNBiomeFeatures.removeAllDefaultFlowers(this);
        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addVillages(this, "village/savanna/town_centers", 2);
        WNBiomeFeatures.addPillagerOutposts(this);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addLakes(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addDefaultFlowers(this);
        WNBiomeFeatures.addGrass(this, 7);
        WNBiomeFeatures.addGrass(this, 4, WNBlocks.DEAD_SHORT_GRASS.getDefaultState());
        WNBiomeFeatures.addGrass(this, 4, Blocks.TALL_GRASS.getDefaultState(),true);
        WNBiomeFeatures.addCactus(this,12);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this, WNBlocks.SUCCULENTS.getDefaultState(), 5);
        WNBiomeFeatures.addPlant(this, WNBlocks.FESTUCA.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.CORDYLINE_AUSTRALIS.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.RED_SAND_VERBENA.getDefaultState().with(FloweringDesertBush.FLOWERING,true), 1);

        BlockWeighList l = new BlockWeighList();
        l.add(WNBlocks.PRICKLY_PEAR_CACTUS.getDefaultState(), 1);
        WNBiomeFeatures.addSinglePlantFeature(this, l, 5);

        WNBiomeFeatures.addTree(this, new acacia1(), 7);
        WNBiomeFeatures.addTree(this, new acacia2(), 7);
        WNBiomeFeatures.addTree(this, new acacia3(), 7);
        WNBiomeFeatures.addTree(this, new acacia4(), 7);
        WNBiomeFeatures.addTree(this, new acacia5(), 7);
        WNBiomeFeatures.addTree(this, new baobab1(), 1);
        WNBiomeFeatures.addTree(this, new baobab2(), 1);
        WNBiomeFeatures.addTree(this, new baobab3(), 1);
        WNBiomeFeatures.addTree(this, new baobab4(), 1);
        WNBiomeFeatures.addTree(this, new baobab5(), 1);
        WNBiomeFeatures.addTree(this, new dead1(), 12);
        WNBiomeFeatures.addTree(this, new dead2(), 12);
        WNBiomeFeatures.addTree(this, new dead3(), 12);
        WNBiomeFeatures.addTree(this, new dead4(), 12);
        WNBiomeFeatures.addTree(this, new dead5(), 12);
        WNBiomeFeatures.addTree(this, new dead6(), 12);


        plantRate = 2;
        treeRate = 6;

        WNBiomeFeatures.addBlob(this, Blocks.SAND.getDefaultState(), 2, true, true, 3);
        WNBiomeFeatures.addBlob(this, Blocks.STONE.getDefaultState(), 1, true, true, 1);

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.HORSE, 1, 2, 6));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.DONKEY, 1, 1, 1));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.HUSK, 95, 4, 4));
    }

    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0xD0D67B, 0xD6C495);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0xA0DE6B, 0xA0DE6B);
    }

}