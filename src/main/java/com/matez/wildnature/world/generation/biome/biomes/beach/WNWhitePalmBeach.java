package com.matez.wildnature.world.generation.biome.biomes.beach;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.woods.palm.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public final class WNWhitePalmBeach extends WNBiome {
    public WNWhitePalmBeach(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(WN.getBlockByID("wildnature:sand_white").getDefaultState(), WN.getBlockByID("wildnature:sand_white").getDefaultState(), Blocks.COARSE_DIRT.getDefaultState()))
                .precipitation(RainType.RAIN)
                .category(Category.BEACH)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(0.15F)
                .scale(0.025F)
                .temperature(0.8F)
                .downfall(0.9F)
                .waterColor(4566514)
                .waterFogColor(267827)
                .logTypes(LogType.PALM)
                .parent(null));


        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addBuriedTreasures(this);
        WNBiomeFeatures.addShipwrecks(this);
        WNBiomeFeatures.addShipwrecks(this);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addDefaultFlowers(this);
        WNBiomeFeatures.addSparseGrass(this);

        WNBiomeFeatures.addTree(this, new tree_palm1().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm2().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm3().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm4().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm5().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm6().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm7().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm8().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm9().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm10().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm11().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm13().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm14().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm15().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm16().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);
        WNBiomeFeatures.addTree(this, new tree_palm17().setCustomLog(WNBlocks.PALM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),2);

        treeRate = 1;
        treeExtra = 2;
        treeExtraChance = 0.3f;

        applyPlants();
        applyTrees();

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addFreezeTopLayer(this);
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.TURTLE, 7, 2, 5));
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.TROPICAL_FISH, 5, 1, 5));
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.PUFFERFISH, 3, 1, 5));
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
}