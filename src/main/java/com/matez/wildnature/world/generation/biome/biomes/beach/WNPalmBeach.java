package com.matez.wildnature.world.generation.biome.biomes.beach;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.woods.palm.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class WNPalmBeach extends WNBiome {
    public WNPalmBeach(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.SAND_SAND_GRAVEL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.BEACH)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.15F)
                .scale(0.025F)
                .temperature(0.8F)
                .downfall(0.4F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.PALM)
                .parent(null));


        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
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

}