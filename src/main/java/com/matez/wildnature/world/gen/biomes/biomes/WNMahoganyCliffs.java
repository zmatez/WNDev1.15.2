package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.CoffeeBush;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.citrus1;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.citrus2;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.citrus3;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.citrus4;
import com.matez.wildnature.world.gen.structures.nature.woods.mahogany.*;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNMahoganyCliffs extends WNBiome {
    public WNMahoganyCliffs(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceRegistry.OVERGROWN_STONE_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.JUNGLE)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(1F)
                .scale(1.2F)
                .temperature(0.7F)
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

        WNBiomeFeatures.addTree(this, new mahogany1().setCustomLog(Main.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new mahogany2().setCustomLog(Main.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new mahogany3().setCustomLog(Main.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new mahogany4().setCustomLog(Main.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new mahoganyshrub1().setCustomLog(Main.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new mahoganyshrub2().setCustomLog(Main.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))), 3);
        WNBiomeFeatures.addTree(this, new shrub1().setCustomLog(Main.getBlockByID("minecraft:mahogany_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))), 4);
        WNBiomeFeatures.addTree(this, new citrus1().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.POMEGRANATE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new citrus2().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.POMEGRANATE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new citrus3().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.ORANGE_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new citrus4().setCustomLog(WNBlocks.CITRUS_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.ORANGE_LEAVES)), 1);
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