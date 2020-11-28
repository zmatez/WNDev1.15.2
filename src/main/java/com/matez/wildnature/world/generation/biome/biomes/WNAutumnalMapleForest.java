package com.matez.wildnature.world.generation.biome.biomes;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.blocks.FloweringBushBase;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.structures.nature.woods.birch.tree_birch1;
import com.matez.wildnature.world.generation.structures.nature.woods.oak.*;
import com.matez.wildnature.world.generation.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.generation.surface.WNSurfaceBuilders;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNAutumnalMapleForest extends WNBiome {
    public WNAutumnalMapleForest(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(WNSurfaceBuilders.PODZOL_SURFACE_BUILDER, WNSurfaceBuilders.BROWN_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.15F)
                .scale(0.05F)
                .temperature(0.5F)
                .downfall(0.8F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.MAPLE,LogType.MAPLE_BROWN,LogType.MAPLE_ORANGE,LogType.MAPLE_RED,LogType.MAPLE_YELLOW)
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

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.YEW_BUSH.getDefaultState(), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.LEAF_PILE.getDefaultState(), 3);


        addTree("wildnature:maple", "wildnature:maple");
        addTree("wildnature:maple", "wildnature:maple_red");
        addTree("wildnature:maple", "wildnature:maple_brown");
        addTree("wildnature:maple", "wildnature:maple_yellow");
        addTree("wildnature:maple", "wildnature:maple_orange");
        WNBiomeFeatures.addTree(this, new shrub1(), 15);

        treeRate = 8;

        applyPlants();
        applyTrees();


        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
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

    private void addTree(String idLog, String idLeaf) {
        WNBiomeFeatures.addTree(this, new tree_oak8().setCustomLog(WN.getBlockByID(idLog + "_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID(idLeaf + "_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_oak9().setCustomLog(WN.getBlockByID(idLog + "_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID(idLeaf + "_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_oak10().setCustomLog(WN.getBlockByID(idLog + "_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID(idLeaf + "_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_oak11().setCustomLog(WN.getBlockByID(idLog + "_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID(idLeaf + "_leaves"))), 2);
        WNBiomeFeatures.addTree(this, new tree_oak5().setCustomLog(WN.getBlockByID(idLog + "_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID(idLeaf + "_leaves"))), 3);

    }

    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D,false);
        return customColor(noise, -0.1D, 0xB5B952, 0xB98959);
    }


}