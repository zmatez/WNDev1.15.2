package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import com.matez.wildnature.world.gen.surface.configs.CanyonSurfaceBuilderConfig;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNCanyons extends WNBiome {
    public WNCanyons(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.CANYON_SURFACE_BUILDER, new CanyonSurfaceBuilderConfig(SurfaceBuilder.RED_SAND_WHITE_TERRACOTTA_GRAVEL_CONFIG, SurfaceBuilder.BADLANDS))
                .precipitation(RainType.RAIN)
                .category(Category.MESA)
                .topography(WNBiomeBuilder.Topography.HIGHLANDS)
                .climate(WNBiomeBuilder.Climate.DRY_SUBTROPICAL)
                .depth(2.1F)
                .scale(0.2F)
                .temperature(0.9F)
                .downfall(0.1F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));//-7052122241400916496 -346 101 943


        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.MESA);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addGrass(this, 3);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addCactus(this, 10);
        WNBiomeFeatures.addDeadBushes(this, 20);


        plantRate = 4;
        treeRate = 0;

        applyPlants();

        this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
    }


    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(BlockPos pos) {
        return 0xC6B653;
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos) {
        return 0x98B072;
    }
}