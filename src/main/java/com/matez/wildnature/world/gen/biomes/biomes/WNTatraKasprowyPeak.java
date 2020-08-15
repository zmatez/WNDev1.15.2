package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.mini_pine.mini_bald_pine1;
import com.matez.wildnature.world.gen.structures.nature.woods.mini_pine.mini_bald_pine2;
import com.matez.wildnature.world.gen.structures.nature.woods.mini_pine.mini_pine1;
import com.matez.wildnature.world.gen.structures.nature.woods.mini_pine.mini_pine2;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNTatraKasprowyPeak extends WNBiome {
    public WNTatraKasprowyPeak(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.SNOWY_MOUNTAIN_SURFACE_BUILDER, SurfaceRegistry.BROWN_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.EXTREME_HILLS)
                .topography(WNBiomeBuilder.Topography.HIGH_MOUNTAINS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(3F)
                .scale(1.5F)
                .temperature(0.15F)
                .downfall(0.975F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));


        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addVillages(this, "village/taiga/town_centers", 2);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addLakes(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addDoubleFlowers(this);
        WNBiomeFeatures.addTatraStoneTypes(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addDefaultFlowers(this);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addPlant(this, WNBlocks.FIRE_WEED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 5);
        WNBiomeFeatures.addPlant(this, WNBlocks.CROCUS_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.CROCUS_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);

        WNBiomeFeatures.addGrass(this, 5, WNBlocks.SMALL_GRASS.getDefaultState());
        WNBiomeFeatures.addGrass(this, 2, WNBlocks.MEDIUM_GRASS.getDefaultState());
        WNBiomeFeatures.addGrass(this, 5, WNBlocks.MOSS.getDefaultState());
        WNBiomeFeatures.addBlobWithCountRangePlacement(this, WNBlocks.BROWN_PODZOL.getDefaultState(), 3, true, false, 2, 60, 90);
        WNBiomeFeatures.addBlobWithCountRangePlacement(this, WNBlocks.BROWN_PODZOL.getDefaultState(), 2, true, false, 2, 80, 120);
        WNBiomeFeatures.addBlobWithCountRangePlacement(this, WNBlocks.OVERGROWN_STONE.getDefaultState(), 3, true, false, 3, 120, 140);

        WNBiomeFeatures.addTree(this, new mini_bald_pine1(), 2);
        WNBiomeFeatures.addTree(this, new mini_bald_pine2(), 2);
        WNBiomeFeatures.addTree(this, new mini_pine1(), 1);
        WNBiomeFeatures.addTree(this, new mini_pine2(), 1);

        plantRate = 1;
        applyPlants();

        treeRate = 1;
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
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
        double noise = INFO_NOISE.noiseAt((double) pos.getX() * 0.0065D, (double) pos.getZ() * 0.0065D, false);
        return customColor(noise, -0.1D, 0x85C864, 0xBECF70);
    }


}