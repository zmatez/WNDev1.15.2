package com.matez.wildnature.world.generation.biome.biomes.land;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.blocks.FloweringBushBase;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.structures.nature.woods.beech.beech1;
import com.matez.wildnature.world.generation.structures.nature.woods.beech.beech2;
import com.matez.wildnature.world.generation.structures.nature.woods.beech.beech3;
import com.matez.wildnature.world.generation.structures.nature.woods.birch.tree_birch1;
import com.matez.wildnature.world.generation.structures.nature.woods.birch.tree_birch10;
import com.matez.wildnature.world.generation.structures.nature.woods.deco.forsythia4;
import com.matez.wildnature.world.generation.structures.nature.woods.deco.forsythia5;
import com.matez.wildnature.world.generation.structures.nature.woods.rowan.rowan3;
import com.matez.wildnature.world.generation.structures.nature.woods.shrubs.shrub1;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNPoplarForestHills extends WNBiome {
    public WNPoplarForestHills(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.6F)
                .scale(0.3F)
                .temperature(0.55F)
                .downfall(0.8F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.POPLAR, LogType.BEECH, LogType.FORSYTHIA, LogType.ROWAN)
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
        WNBiomeFeatures.addGrass(this);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.YEW_BUSH.getDefaultState(), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.PASQUE_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 3);

        WNBiomeFeatures.addTree(this, new tree_birch10().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WNBlocks.POPLAR_LEAVES)), 8);
        WNBiomeFeatures.addTree(this, new tree_birch1().setCustomLog(Blocks.OAK_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(WNBlocks.POPLAR_LEAVES)), 6);
        WNBiomeFeatures.addTree(this, new beech1(), 1);
        WNBiomeFeatures.addTree(this, new beech2(), 1);
        WNBiomeFeatures.addTree(this, new beech3(), 1);
        WNBiomeFeatures.addTree(this, new forsythia4(), 1);
        WNBiomeFeatures.addTree(this, new forsythia5(), 1);
        WNBiomeFeatures.addTree(this, new rowan3(), 1);
        WNBiomeFeatures.addTree(this, new shrub1(), 10);

        WNBiomeFeatures.addPlant(this, WNBlocks.HYDRANGEA_WHITE.getDefaultState(), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HOLLYHOCK_RED.getDefaultState(), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.CARNATION_RED.getDefaultState(), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.GLADIOLUS_ORANGE.getDefaultState(), 1);
        treeRate = 15;

        applyPlants();
        applyTrees();
        this.addSpawn(EntityClassification.CREATURE, new WNBiome.SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new WNBiome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new WNBiome.SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new WNBiome.SpawnListEntry(EntityType.WOLF, 3, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 2, 4, 4));
        this.addSpawn(EntityClassification.AMBIENT, new WNBiome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new WNBiome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new WNBiome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new WNBiome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new WNBiome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new WNBiome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new WNBiome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new WNBiome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new WNBiome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));

    }

    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0x8AC700, 0x7DB300);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D, false);
        return customColor(noise, -0.1D, 0x7DC400, 0x9CCD00);
    }
}
