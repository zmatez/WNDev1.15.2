package com.matez.wildnature.gui;

import com.matez.wildnature.blocks.HydrothermalVent;
import com.matez.wildnature.gui.container.PouchContainer;
import com.matez.wildnature.gui.screen.PouchScreen;
import com.matez.wildnature.gui.tileEntities.*;
import com.matez.wildnature.gui.container.CraftingManagerContainer;
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

    @ObjectHolder("wildnature:rs_piston1")
    public static TileEntityType<CustomPistonTileEntity> PISTON_TYPE;

    @ObjectHolder("wildnature:dungeon_commander")
    public static TileEntityType<DungeonCommanderTileEntity> DUNGEON_COMMANDER;

    @ObjectHolder("wildnature:pouch")
    public static ContainerType<PouchContainer> POUCH = null;

    public static ContainerType<CraftingManagerContainer> CRAFTING_MANAGER_CONTAINER;



}
