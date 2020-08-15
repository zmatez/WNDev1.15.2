package com.matez.wildnature.compatibility;

import com.matez.wildnature.entity.EntityRegistry;
import com.matez.wildnature.entity.type.animal.duck.AbstractDuckEntity;
import com.matez.wildnature.entity.type.animal.duck.DrakeEntity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.world.gen.Heightmap;

public class WNMobSpawning {
    public static void registerAll(){
        //EntitySpawnPlacementRegistry.register(EntityRegistry.DRAKE, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractDuckEntity::registerSpawning);
        //EntitySpawnPlacementRegistry.register(EntityRegistry.DUCK, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbstractDuckEntity::registerSpawning);
        //EntitySpawnPlacementRegistry.register(EntityRegistry.DRAKE, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.OCEAN_FLOOR, DrakeEntity::registerSpawning);
        //EntitySpawnPlacementRegistry.register(EntityRegistry.DUCK, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.OCEAN_FLOOR, AbstractDuckEntity::registerSpawning);
    }
}
