package com.matez.wildnature.world.generation.biome.biomes;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.blocks.FloweringBushBase;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.structures.nature.woods.bialowieza.*;
import com.matez.wildnature.world.generation.structures.nature.woods.birch.tree_birch1;
import com.matez.wildnature.world.generation.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.generation.surface.WNSurfaceBuilders;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNSnowyBialowiezaForest extends WNBiome {
    public WNSnowyBialowiezaForest(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, WNSurfaceBuilders.BROWN_CONFIG)
                .precipitation(RainType.SNOW)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(0.15F)
                .scale(0.05F)
                .temperature(0.1F)
                .downfall(0.4F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.BIALOWIEZA)
                .parent(null));


        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addLakes(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addGrass(this);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addFreezeTopLayer(this);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);

        WNBiomeFeatures.addTree(this, new tree_bialowiezaTree1().setCustomLog(WN.getBlockByID("minecraft:dark_oak_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("minecraft:spruce_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_bialowiezaTree2().setCustomLog(WN.getBlockByID("minecraft:dark_oak_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("minecraft:spruce_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_bialowiezaTree3().setCustomLog(WN.getBlockByID("minecraft:dark_oak_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("minecraft:spruce_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_bialowiezaTree4().setCustomLog(WN.getBlockByID("minecraft:dark_oak_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("minecraft:spruce_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_bialowiezaTree5().setCustomLog(WN.getBlockByID("minecraft:dark_oak_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("minecraft:spruce_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new tree_bialowiezaTree6().setCustomLog(WN.getBlockByID("minecraft:dark_oak_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("minecraft:spruce_leaves"))), 1);
        WNBiomeFeatures.addTree(this, new shrub1().setCustomLog(WN.getBlockByID("minecraft:dark_oak_log").getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WN.getBlockByID("minecraft:spruce_leaves"))), 5);
        WNBiomeFeatures.addFreezeTopLayer(this);

        WNBiomeFeatures.addWater(this);

        treeRate = 9;

        applyPlants();
        applyTrees();


        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 5, 4, 4));
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
        return customColor(noise, -0.1D, 0x458547, 0x539855);
    }
}