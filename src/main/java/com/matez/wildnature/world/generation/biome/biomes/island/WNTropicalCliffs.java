package com.matez.wildnature.world.generation.biome.biomes.island;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.blocks.DoubleBushBaseFlowering;
import com.matez.wildnature.common.blocks.FloweringBushBase;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.woods.jungle.*;
import com.matez.wildnature.world.generation.structures.nature.woods.palm.*;
import com.matez.wildnature.world.generation.surface.WNSurfaceBuilders;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNTropicalCliffs extends WNBiome {
    public WNTropicalCliffs(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, WNSurfaceBuilders.OVERGROWN_STONE_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.JUNGLE)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(1.6F)
                .scale(0.15F)
                .temperature(0.7F)
                .downfall(0.8F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.PALM, LogType.JUNGLE_MEDIUM, LogType.JUNGLE_SMALL)
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
        WNBiomeFeatures.addMelons(this, 6);
        WNBiomeFeatures.addPlant(this, Blocks.BLUE_ORCHID.getDefaultState(), 5);
        WNBiomeFeatures.addPlant(this, WNBlocks.PEACE_LILY.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.ORCHIS_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.ORCHIS_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.CANA_BULB_ORANGE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.BIRD_OF_PARADISE.getDefaultState().with(DoubleBushBaseFlowering.FLOWERING, true), 3);

        WNBiomeFeatures.addTree(this, new tree_palm1().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm2().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm3().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm4().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm5().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm6().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm7().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm8().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm9().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm10().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm11().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm13().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm14().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm15().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm16().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm17().setCustomLog(WN.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WN.getBlockByID("wildnature:palm_leaves"))), 2);

        WNBiomeFeatures.addTree(this, new jungle_medium1(),2);
        WNBiomeFeatures.addTree(this, new jungle_medium2(),2);
        WNBiomeFeatures.addTree(this, new jungle_medium3(),2);
        WNBiomeFeatures.addTree(this, new jungle_small1(),1);
        WNBiomeFeatures.addTree(this, new jungle_small2(),1);
        WNBiomeFeatures.addTree(this, new jungle_small3(),1);


        plantRate = 2;
        treeRate = 4;

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
        return customColor(noise, -0.1D, 0x7FC132, 0x4DCD2D);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0x59C236, 0x87DD34);
    }

    @Override
    public int getSkyColor() {
        return 0x7EF8F3;
    }
}