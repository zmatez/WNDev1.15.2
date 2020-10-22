package com.matez.wildnature.client.gui;

import com.matez.wildnature.client.gui.container.PouchContainer;
import com.matez.wildnature.client.gui.tileEntities.*;
import com.matez.wildnature.client.gui.container.CraftingManagerContainer;
import com.matez.wildnature.client.gui.tileEntities.item.ItemTileEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class initGuis {
    public static TileEntityType<ParticleGeneratorTileEntity> PARTICLE_GENERATOR_TILE;

    @ObjectHolder("wildnature:hydrothermal_vent")
    public static TileEntityType<HydrothermalVentTileEntity> HYDROTHERMAL_VENT_TILE_ENTITY;
    @ObjectHolder("wildnature:gravityshroom")
    public static TileEntityType<GravityShroomTileEntity> GRAVITY_SHROOM_TILE_ENTITY;
    @ObjectHolder("wildnature:cave_lily")
    public static TileEntityType<CaveLilyTileEntity> CAVE_LILY_TILE_ENTITY;

    @ObjectHolder("wildnature:item_tile_entity")
    public static TileEntityType<ItemTileEntity> ITEM_TILE_ENTITY;

    @ObjectHolder("wildnature:rs_piston1")
    public static TileEntityType<CustomPistonTileEntity> PISTON_TYPE;

    @ObjectHolder("wildnature:dungeon_commander")
    public static TileEntityType<DungeonCommanderTileEntity> DUNGEON_COMMANDER;

    @ObjectHolder("wildnature:pouch")
    public static ContainerType<PouchContainer> POUCH = null;

    public static ContainerType<CraftingManagerContainer> CRAFTING_MANAGER_CONTAINER;



}