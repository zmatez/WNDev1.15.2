package com.matez.wildnature.world.generation.biome.biomes.island;

import com.matez.wildnature.common.blocks.FloweringBushBase;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.woods.beech.beech1;
import com.matez.wildnature.world.generation.structures.nature.woods.beech.beech2;
import com.matez.wildnature.world.generation.structures.nature.woods.beech.beech3;
import com.matez.wildnature.world.generation.structures.nature.woods.beech.beech4;
import com.matez.wildnature.world.generation.structures.nature.woods.birch.*;
import com.matez.wildnature.world.generation.structures.nature.woods.oak.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNForestedIsland extends WNBiome {
    public WNForestedIsland(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_SAND_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.PLAINS)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(0.15F)
                .scale(0.05F)
                .temperature(0.35F)
                .downfall(0.65F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.SMALL_OAK, LogType.OAK, LogType.MIRABELLE_PLUM, LogType.PLUM, LogType.BIRCH, LogType.BEECH_THICK)
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
        WNBiomeFeatures.addGrass(this, 15);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this, Blocks.DANDELION.getDefaultState(), 2);
        WNBiomeFeatures.addPlant(this, Blocks.CORNFLOWER.getDefaultState(), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.CATNIP.getDefaultState().with(FloweringBushBase.FLOWERING, true), 3);

        WNBiomeFeatures.addTree(this, new pointy_oak_1(), 1);
        WNBiomeFeatures.addTree(this, new pointy_oak_2(), 1);
        WNBiomeFeatures.addTree(this, new pointy_oak_3(), 1);
        WNBiomeFeatures.addTree(this, new pointy_oak_4(), 1);
        WNBiomeFeatures.addTree(this, new pointy_oak_5(), 1);

        WNBiomeFeatures.addTree(this, new oak1(), 1);
        WNBiomeFeatures.addTree(this, new oak2(), 1);
        WNBiomeFeatures.addTree(this, new oak3(), 1);

        WNBiomeFeatures.addTree(this, new tree_oak5(), 3);
        WNBiomeFeatures.addTree(this, new tree_oak9(), 3);

        WNBiomeFeatures.addTree(this, new big_birch_1(), 1);
        WNBiomeFeatures.addTree(this, new big_birch_2(), 1);
        WNBiomeFeatures.addTree(this, new big_birch_3(), 1);
        WNBiomeFeatures.addTree(this, new big_birch_4(), 1);
        WNBiomeFeatures.addTree(this, new big_birch_5(), 1);
        WNBiomeFeatures.addTree(this, new big_birch_6(), 1);

        WNBiomeFeatures.addTree(this, new beech1(), 1);
        WNBiomeFeatures.addTree(this, new beech2(), 1);
        WNBiomeFeatures.addTree(this, new beech3(), 1);
        WNBiomeFeatures.addTree(this, new beech4(), 1);


        WNBiomeFeatures.addTree(this, new tree_oak22().setCustomLog( WNBlocks.PLUM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.PLUM_LEAVES)), 1);
        WNBiomeFeatures.addTree(this, new tree_oak5().setCustomLog( WNBlocks.PLUM_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.MIRABELLE_PLUM_LEAVES)), 1);

        plantRate = 2;
        treeRate = 6;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
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
        return customColor(noise, -0.1D, 0x8EC15E, 0x97C14D);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0x81C259, 0x76B84E);
    }
}