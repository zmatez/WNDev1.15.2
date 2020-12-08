package com.matez.wildnature.client.gui;

import com.matez.wildnature.client.gui.container.*;
import com.matez.wildnature.common.tileentity.*;
import com.matez.wildnature.common.tileentity.item.ItemTileEntity;
import com.matez.wildnature.common.tileentity.present.PresentTileEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class initGuis {
    public static int tileEntityType = 12342;
    public static TileEntityType<ParticleGeneratorTileEntity> PARTICLE_GENERATOR_TILE;

    @ObjectHolder("wildnature:hydrothermal_vent")
    public static TileEntityType<HydrothermalVentTileEntity> HYDROTHERMAL_VENT_TILE_ENTITY;
    @ObjectHolder("wildnature:gravityshroom")
    public static TileEntityType<GravityShroomTileEntity> GRAVITY_SHROOM_TILE_ENTITY;
    @ObjectHolder("wildnature:cave_lily")
    public static TileEntityType<CaveLilyTileEntity> CAVE_LILY_TILE_ENTITY;
    @ObjectHolder("wildnature:item_tile_entity")
    public static TileEntityType<ItemTileEntity> ITEM_TILE_ENTITY;
    @ObjectHolder("wildnature:present_tile_entity")
    public static TileEntityType<PresentTileEntity> PRESENT_TILE_ENTITY;

    @ObjectHolder("wildnature:rs_piston1")
    public static TileEntityType<CustomPistonTileEntity> PISTON_TYPE;

    @ObjectHolder("wildnature:dungeon_commander")
    public static TileEntityType<DungeonCommanderTileEntity> DUNGEON_COMMANDER;

    @ObjectHolder("wildnature:pouch")
    public static ContainerType<PouchContainer> POUCH = null;
    @ObjectHolder("wildnature:backpack_small")
    public static ContainerType<BackpackSmallContainer> BACKPACK_SMALL = null;
    @ObjectHolder("wildnature:backpack_medium")
    public static ContainerType<BackpackMediumContainer> BACKPACK_MEDIUM = null;
    @ObjectHolder("wildnature:backpack_big")
    public static ContainerType<BackpackBigContainer> BACKPACK_BIG = null;



}
