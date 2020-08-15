package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.DoubleBushBaseFlowering;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.palm.*;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNOasis extends WNBiome {
    public WNOasis(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.NORMAL_PODZOL_SURFACE_BUILDER, SurfaceRegistry.TROPICAL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.JUNGLE)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(0.03F)
                .scale(0.01F)
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
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this, Blocks.BLUE_ORCHID.getDefaultState(), 10);
        WNBiomeFeatures.addPlant(this, WNBlocks.CANA_BULB_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.PEACE_LILY.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.ORCHIS_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.BIRD_OF_PARADISE.getDefaultState().with(DoubleBushBaseFlowering.FLOWERING, true), 3);
        WNBiomeFeatures.addMelons(this, 3);

        WNBiomeFeatures.addTree(this, new tree_palm1().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm2().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm3().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm4().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm5().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm6().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm7().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm8().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm9().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm10().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm11().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm12().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm13().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm14().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm15().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm16().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_palm17().setCustomLog(Main.getBlockByID("wildnature:palm_log").getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))), 2);

        WNBiomeFeatures.addBambooJungleVegetation(this);

        plantRate = 2;
        treeRate = 2;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PARROT, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 10, 4, 4));
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