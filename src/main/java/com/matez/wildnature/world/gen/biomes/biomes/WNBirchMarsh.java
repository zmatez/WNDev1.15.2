package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.oaklands.oaklands_shrub5;
import com.matez.wildnature.world.gen.structures.nature.woods.oaklands.oaklands_shrub6;
import com.matez.wildnature.world.gen.structures.nature.woods.oaklands.oaklands_shrub7;
import com.matez.wildnature.world.gen.structures.nature.woods.oaklands.oaklands_shrub8;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNBirchMarsh extends WNBiome {
    public WNBirchMarsh(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.15F)
                .scale(0.03F)
                .temperature(0.25F)
                .downfall(0.8F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));


        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addVillages(this, "village/plains/town_centers", 6);
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

        WNBiomeFeatures.addPlant(this, WNBlocks.CARNATION_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.CARNATION_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.GLADIOLUS_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.GLADIOLUS_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.GLADIOLUS_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.CARNATION_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);

        WNBiomeFeatures.addPlant(this, WNBlocks.GRASS_FLOWER.getDefaultState().with(FloweringBushBase.FLOWERING, true), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.WILD_WHEAT.getDefaultState().with(FloweringBushBase.FLOWERING, true), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.GRASS_WHEAT.getDefaultState().with(FloweringBushBase.FLOWERING, true), 4);

        WNBiomeFeatures.addTree(this, new spiky_birch_1(), 1);
        WNBiomeFeatures.addTree(this, new spiky_birch_2(), 1);
        WNBiomeFeatures.addTree(this, new spiky_birch_3(), 1);
        WNBiomeFeatures.addTree(this, new spiky_birch_4(), 1);
        WNBiomeFeatures.addTree(this, new pointy_birch1(), 1);
        WNBiomeFeatures.addTree(this, new pointy_birch2(), 1);
        WNBiomeFeatures.addTree(this, new pointy_birch3(), 1);
        WNBiomeFeatures.addTree(this, new pointy_birch4(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_shrub5(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_shrub6(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_shrub7(), 1);
        WNBiomeFeatures.addTree(this, new oaklands_shrub8(), 1);

        WNBiomeFeatures.addCattail(this, 40);

        WNBiomeFeatures.addBlob(this, Blocks.STONE.getDefaultState(), 2, true, false, 2);
        WNBiomeFeatures.addBlob(this, Blocks.WATER.getDefaultState(), 3, true, true, true, 3);


        plantRate = 2;
        treeRate = 5;

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
        return customColor(noise, -0.1D, 0xD0C182, 0xD09B7C);
    }


}