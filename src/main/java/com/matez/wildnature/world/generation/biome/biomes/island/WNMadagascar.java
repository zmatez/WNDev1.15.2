package com.matez.wildnature.world.generation.biome.biomes.island;

import com.matez.wildnature.common.blocks.DoubleBushBaseFlowering;
import com.matez.wildnature.common.blocks.FloweringBushBase;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.biome.features.LogType;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.biome.setup.WNBiomeBuilder;
import com.matez.wildnature.world.generation.biome.features.WNBiomeFeatures;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.woods.baobab.*;
import com.matez.wildnature.world.generation.structures.nature.woods.citrus.*;
import com.matez.wildnature.world.generation.structures.nature.woods.ebony.*;
import com.matez.wildnature.world.generation.structures.nature.woods.jungle.*;
import com.matez.wildnature.world.generation.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.generation.surface.WNSurfaceBuilders;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class WNMadagascar extends WNBiome {
    public WNMadagascar(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, WNSurfaceBuilders.TROPICAL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.JUNGLE)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(0.2F)
                .scale(0.1F)
                .temperature(0.95F)
                .downfall(0.9F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .logTypes(LogType.JUNGLE_SMALL, LogType.JUNGLE_MEDIUM, LogType.JUNGLE_BIG,LogType.BAOBAB,LogType.EBONY,LogType.BANANA,LogType.BIG_MANGO)
                .parent(null));


        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addJungleTemples(this);

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
        WNBiomeFeatures.addBambooJungleVegetation(this);
        WNBiomeFeatures.addJunglePlants(this);
        WNBiomeFeatures.addBlob(this, Blocks.PODZOL.getDefaultState(), 2, true, false, 5);

        WNBiomeFeatures.addPlant(this, Blocks.BLUE_ORCHID.getDefaultState(), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.ANTHURIUM_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.ANTHURIUM_RED.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.ANTHURIUM_PINK.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.ORCHIS_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 1);
        WNBiomeFeatures.addPlant(this, WNBlocks.PEACE_LILY.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.BIRD_OF_PARADISE.getDefaultState().with(DoubleBushBaseFlowering.FLOWERING, true), 3);

        WNBiomeFeatures.addTree(this, new jungle_big1(), 5);
        WNBiomeFeatures.addTree(this, new jungle_big2(), 5);
        WNBiomeFeatures.addTree(this, new jungle_big3(), 5);
        WNBiomeFeatures.addTree(this, new jungle_medium1(), 2);
        WNBiomeFeatures.addTree(this, new jungle_medium2(), 2);
        WNBiomeFeatures.addTree(this, new jungle_small1(), 1);
        WNBiomeFeatures.addTree(this, new jungle_small2(), 1);
        WNBiomeFeatures.addTree(this, new jungle_small3(), 1);
        WNBiomeFeatures.addTree(this, new shrub1().setCustomLog(Blocks.JUNGLE_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(Blocks.JUNGLE_LEAVES)), 15);
        WNBiomeFeatures.addTree(this, new baobab1(), 1);
        WNBiomeFeatures.addTree(this, new baobab2(), 1);
        WNBiomeFeatures.addTree(this, new baobab3(), 1);
        WNBiomeFeatures.addTree(this, new baobab4(), 1);
        WNBiomeFeatures.addTree(this, new baobab5(), 1);
        WNBiomeFeatures.addTree(this, new ebony1(), 1);
        WNBiomeFeatures.addTree(this, new ebony2(), 1);
        WNBiomeFeatures.addTree(this, new ebony3(), 1);
        WNBiomeFeatures.addTree(this, new ebony4(), 1);
        WNBiomeFeatures.addTree(this, new ebony_shrub1(), 1);
        WNBiomeFeatures.addTree(this, new ebony_shrub2(), 1);
        WNBiomeFeatures.addTree(this, new banana1(), 1);
        WNBiomeFeatures.addTree(this, new banana2(), 1);
        WNBiomeFeatures.addTree(this, new banana3(), 1);
        WNBiomeFeatures.addTree(this, new banana4(), 1);

        WNBiomeFeatures.addTree(this, new mango_big1(), 1);
        WNBiomeFeatures.addTree(this, new mango_big2(), 1);
        WNBiomeFeatures.addTree(this, new mango_big3(), 1);
        plantRate = 2;
        treeRate = 10;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PARROT, 40, 1, 2));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PANDA, 5, 1, 4));
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
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.OCELOT, 2, 1, 1));

    }


    @Override
    public int getSkyColor() {
        return 0x7EF8F3;
    }
}