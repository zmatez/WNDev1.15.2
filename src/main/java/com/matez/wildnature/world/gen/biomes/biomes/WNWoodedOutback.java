package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.nuytsia.*;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNWoodedOutback extends WNBiome {
    public WNWoodedOutback(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.OUTBACK_SURFACE_BUILDER, SurfaceRegistry.DESERT_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.15F)
                .scale(0.03F)
                .temperature(0.9F)
                .downfall(0.8F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));//-7052122241400916496 -346 101 943


        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addVillages(this, "village/savanna/town_centers", 6);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addGrass(this, 3);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.removeAllDefaultFlowers(this);
        WNBiomeFeatures.addCactus(this, 7);
        WNBiomeFeatures.addDeadBushes(this, 20);

        WNBiomeFeatures.addTree(this, new nuytsia1(), 1);
        WNBiomeFeatures.addTree(this, new nuytsia2(), 1);
        WNBiomeFeatures.addTree(this, new nuytsia3(), 1);
        WNBiomeFeatures.addTree(this, new nuytsia4(), 1);
        WNBiomeFeatures.addTree(this, new nuytsia5(), 1);
        WNBiomeFeatures.addTree(this, new nuytsia6(), 1);
        //TODO SavannaTreeFeature
        //WNBiomeFeatures.addTree(this, new SavannaTreeFeature(NoFeatureConfig::deserialize, false), 5);

        WNBiomeFeatures.addTree(this, new nuytsia_shrub1(), 1);
        WNBiomeFeatures.addTree(this, new nuytsia_shrub2(), 1);
        WNBiomeFeatures.addTree(this, new nuytsia_shrub3(), 1);
        WNBiomeFeatures.addTree(this, new nuytsia_shrub4(), 1);
        WNBiomeFeatures.addTree(this, new nuytsia_shrub5(), 1);
        WNBiomeFeatures.addTree(this, new nuytsia_shrub6(), 1);
        WNBiomeFeatures.addTree(this, new shrub1(), 5);

        plantRate = 4;
        treeRate = 8;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 1, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 2, 4, 4));
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
        return 0xC6B653;
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        return 0x8DB945;
    }
}