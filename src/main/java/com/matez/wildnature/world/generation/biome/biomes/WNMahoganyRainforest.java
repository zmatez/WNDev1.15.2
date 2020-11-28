package com.matez.wildnature.world.generation.biome.biomes;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.blocks.CoffeeBush;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.woods.citrus.*;
import com.matez.wildnature.world.generation.structures.nature.woods.mahogany.*;
import com.matez.wildnature.world.generation.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.generation.surface.WNSurfaceBuilders;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNMahoganyRainforest extends WNBiome {
    public WNMahoganyRainforest(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(WNSurfaceBuilders.NORMAL_PODZOL_SURFACE_BUILDER, WNSurfaceBuilders.TROPICAL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(0.2F)
                .scale(0.1F)
                .temperature(0.7F)
                .downfall(0.8F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.MAHOGANY,LogType.POMEGRANATE,LogType.ORANGE)
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
        WNBiomeFeatures.addGrass(this, 20);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addBambooJungleVegetation(this);

        WNBiomeFeatures.addPlant(this, Blocks.BLUE_ORCHID.getDefaultState(), 10);
        WNBiomeFeatures.addPlant(this, WNBlocks.ANTHURIUM_RED.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.ANTHURIUM_PINK.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.CANA_BULB_PINK.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.COFFEE_SAPLING.getDefaultState(), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.COFFEE_BUSH.getDefaultState().with(CoffeeBush.STAGE, 0), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.COFFEE_BUSH.getDefaultState().with(CoffeeBush.STAGE, 1), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.COFFEE_BUSH.getDefaultState().with(CoffeeBush.STAGE, 2), 1);

        WNBiomeFeatures.addTree(this, new mahogany1().setCustomLog(WN.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("minecraft:mahogany_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new mahogany2().setCustomLog(WN.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("minecraft:mahogany_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new mahogany3().setCustomLog(WN.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("minecraft:mahogany_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new mahogany4().setCustomLog(WN.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("minecraft:mahogany_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new mahoganyshrub1().setCustomLog(WN.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("minecraft:mahogany_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new mahoganyshrub2().setCustomLog(WN.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("minecraft:mahogany_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new shrub1().setCustomLog(WN.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("minecraft:mahogany_leaves"))), 4);

        WNBiomeFeatures.addTree(this, new pomegranate1(), 1);
        WNBiomeFeatures.addTree(this, new pomegranate2(), 1);
        WNBiomeFeatures.addTree(this, new pomegranate3(), 1);
        WNBiomeFeatures.addTree(this, new orange1(), 1);
        WNBiomeFeatures.addTree(this, new orange2(), 1);
        WNBiomeFeatures.addTree(this, new orange3(), 1);

        plantRate = 2;
        treeRate = 15;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PARROT, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 10, 4, 4));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 20, 8, 8));
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
        return customColor(noise, -0.1D, 0x89D036, 0x81D417);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0x72D624, 0x92DD29);
    }

    @Override
    public int getSkyColor() {
        return 0xB1EB7D;
    }
}