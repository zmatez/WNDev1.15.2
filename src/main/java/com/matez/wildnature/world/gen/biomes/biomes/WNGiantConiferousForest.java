package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.*;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.*;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNGiantConiferousForest extends WNBiome {
    public WNGiantConiferousForest(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.CUSTOM_SURFACE_BUILDER, SurfaceRegistry.BROWN_PODZOL_GRAVEL)
                .precipitation(RainType.RAIN)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.HIGHLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(0.2F)
                .scale(0.3F)
                .temperature(0.3F)
                .downfall(0.4F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));


        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addVillages(this, "village/taiga/town_centers", 6);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addLakes(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addDoubleFlowers(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addDefaultFlowers(this);
        WNBiomeFeatures.addGrass(this, 18);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);

        BlockState pineLog = Main.getBlockByID("minecraft:spruce_log").getDefaultState();
        BlockState pineLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"));
        BlockState firLog = Main.getBlockByID("minecraft:spruce_log").getDefaultState();
        BlockState firLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("wildnature:fir_leaves"));
        BlockState spruceLog = Main.getBlockByID("minecraft:spruce_log").getDefaultState();
        BlockState spruceLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("minecraft:spruce_leaves"));


        int x = 0;
        while (x < 3) {
            BlockState LOG = null;
            BlockState LEAVES = null;
            if (x == 0) {
                LOG = pineLog;
                LEAVES = pineLeaves;
            } else if (x == 1) {
                LOG = firLog;
                LEAVES = firLeaves;
            } else if (x == 2) {
                LOG = spruceLog;
                LEAVES = spruceLeaves;
            }
            WNBiomeFeatures.addTree(this, new tree_taiga2().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga4().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga5().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga7().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga10().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga11().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga12().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga13().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga14().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_taiga15().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_fir18().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_fir6().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);
            WNBiomeFeatures.addTree(this, new tree_fir22().setCustomLog(LOG).setCustomLeaf(LEAVES), 1);

            WNBiomeFeatures.addTree(this, new tree_taiga25().setCustomLog(LOG).setCustomLeaf(LEAVES), 10);
            WNBiomeFeatures.addTree(this, new tree_taiga21().setCustomLog(LOG).setCustomLeaf(LEAVES), 7);
            WNBiomeFeatures.addTree(this, new tree_fir17().setCustomLog(LOG).setCustomLeaf(LEAVES), 10);
            WNBiomeFeatures.addTree(this, new tree_fir16().setCustomLog(LOG).setCustomLeaf(LEAVES), 7);
            WNBiomeFeatures.addTree(this, new tree_fir31().setCustomLog(LOG).setCustomLeaf(LEAVES), 7);
            WNBiomeFeatures.addTree(this, new tree_fir20().setCustomLog(LOG).setCustomLeaf(LEAVES), 7);
            WNBiomeFeatures.addTree(this, new tree_fir29().setCustomLog(LOG).setCustomLeaf(LEAVES), 5);
            x++;
        }

        plantRate = 1;
        treeRate = 4;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 5, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 5, 4, 4));
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
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0xC74400, 0xB36D0E);
    }

}