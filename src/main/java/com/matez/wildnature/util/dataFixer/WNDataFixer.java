package com.matez.wildnature.util.dataFixer;

import com.matez.wildnature.util.event.DataFixEvent;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.util.lists.WNItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;

import java.util.LinkedHashMap;

public class WNDataFixer {
    private final LinkedHashMap<ResourceLocation, ResourceLocation> blockRemap = new LinkedHashMap<>();
    private final LinkedHashMap<ResourceLocation, ResourceLocation> itemRemap = new LinkedHashMap<>();

    public void registerDataFixer() {
        registerDataFixers();
        registerMappings();
    }

    private void registerDataFixers() {
        //MinecraftForge.EVENT_BUS.addListener(new DataFixEvent()::fixBlocks);
        //MinecraftForge.EVENT_BUS.addListener(new DataFixEvent()::fixItems);
    }

    private void registerMappings() {
        //BASALT
        registerBlockItemRemap("wildnature:basalt_ancient_bricks", WNBlocks.BASALT_BRICKS_ANCIENT);
        registerBlockItemRemap("wildnature:basalt_bricks_chiseled_corner_slab", WNBlocks.BASALT_CORNER_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:basalt_bricks_chiseled_half_stairs", WNBlocks.BASALT_HALF_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:basalt_bricks_chiseled_vertical_slab", WNBlocks.BASALT_VERTICAL_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:basalt_bricks_corner_slab", WNBlocks.BASALT_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:basalt_bricks_cracked_corner_slab", WNBlocks.BASALT_CORNER_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:basalt_bricks_cracked_half_stairs", WNBlocks.BASALT_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:basalt_bricks_cracked_vertical_slab", WNBlocks.BASALT_VERTICAL_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:basalt_bricks_half_stairs", WNBlocks.BASALT_HALF_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:basalt_bricks_mossy_corner_slab", WNBlocks.BASALT_CORNER_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:basalt_bricks_mossy_half_stairs", WNBlocks.BASALT_HALF_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:basalt_bricks_mossy_vertical_slab", WNBlocks.BASALT_VERTICAL_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:basalt_bricks_vertical_slab", WNBlocks.BASALT_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:basalt_cobble_corner_slab", WNBlocks.BASALT_CORNER_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:basalt_cobble_fence", WNBlocks.BASALT_FENCE_COBBLE);
        registerBlockItemRemap("wildnature:basalt_cobble_half_stairs", WNBlocks.BASALT_HALF_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:basalt_cobble_trapdoor", WNBlocks.BASALT_TRAPDOOR_COBBLE);
        registerBlockItemRemap("wildnature:basalt_cobble_vertical_slab", WNBlocks.BASALT_VERTICAL_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:basalt_firepit", WNBlocks.BASALT_FIRE_PIT);
        registerBlockItemRemap("wildnature:basalt_long_bricks", WNBlocks.BASALT_BRICKS_LONG);
        registerBlockItemRemap("wildnature:basalt_mossy_cobble_corner_slab", WNBlocks.BASALT_CORNER_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:basalt_mossy_cobble_half_stairs", WNBlocks.BASALT_HALF_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:basalt_mossy_cobble_vertical_slab", WNBlocks.BASALT_VERTICAL_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:basalt_polished_corner_slab", WNBlocks.BASALT_CORNER_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:basalt_polished_half_stairs", WNBlocks.BASALT_HALF_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:basalt_polished_slab", WNBlocks.BASALT_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:basalt_polished_stairs", WNBlocks.BASALT_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:basalt_polished_vertical_slab", WNBlocks.BASALT_VERTICAL_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:basalt_polished_wall", WNBlocks.BASALT_WALL_POLISHED);
        registerBlockItemRemap("wildnature:basalt_roof", WNBlocks.BASALT_BRICKS);//
        registerBlockItemRemap("wildnature:basalt_roof_slab", WNBlocks.BASALT_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:basalt_roof_stairs", WNBlocks.BASALT_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:basalt_slab_bricks_chiseled", WNBlocks.BASALT_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:basalt_small_bricks", WNBlocks.BASALT_BRICKS_SMALL);
        registerBlockItemRemap("wildnature:basalt_stairs_bricks_chiseled", WNBlocks.BASALT_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:basalt_stairs_bricks_cracked", WNBlocks.BASALT_STAIRS_BRICKS_CRACKED);

        //CONGLOMERATE
        registerBlockItemRemap("wildnature:conglomerate", Blocks.GRANITE);
        registerBlockItemRemap("wildnature:conglomerate_ancient_bricks", WNBlocks.GRANITE_BRICKS_ANCIENT);
        registerBlockItemRemap("wildnature:conglomerate_bricks", WNBlocks.GRANITE_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_bricks_chiseled", WNBlocks.GRANITE_BRICKS_CHISELED);
        registerBlockItemRemap("wildnature:conglomerate_bricks_chiseled_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:conglomerate_bricks_chiseled_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_bricks_chiseled_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_bricks_cracked", WNBlocks.GRANITE_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:conglomerate_bricks_cracked_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:conglomerate_bricks_cracked_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:conglomerate_bricks_cracked_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:conglomerate_bricks_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_bricks_mossy", WNBlocks.GRANITE_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:conglomerate_bricks_mossy_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:conglomerate_bricks_mossy_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:conglomerate_bricks_mossy_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:conglomerate_bricks_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_bricks_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_button", WNBlocks.GRANITE_BUTTON);
        registerBlockItemRemap("wildnature:conglomerate_cobble", WNBlocks.GRANITE_COBBLE);
        registerBlockItemRemap("wildnature:conglomerate_cobble_fence", WNBlocks.GRANITE_FENCE_COBBLE);
        registerBlockItemRemap("wildnature:conglomerate_cobble_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:conglomerate_cobble_mossy", WNBlocks.GRANITE_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:conglomerate_cobble_trapdoor", WNBlocks.GRANITE_TRAPDOOR_COBBLE);
        registerBlockItemRemap("wildnature:conglomerate_cobble_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:conglomerate_cobble_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:conglomerate_fence", WNBlocks.GRANITE_FENCE);
        registerBlockItemRemap("wildnature:conglomerate_firepit", WNBlocks.GRANITE_FIRE_PIT);
        registerBlockItemRemap("wildnature:conglomerate_half_stairs", WNBlocks.GRANITE_HALF_STAIRS);
        registerBlockItemRemap("wildnature:conglomerate_long_bricks", WNBlocks.GRANITE_BRICKS_LONG);
        registerBlockItemRemap("wildnature:conglomerate_mossy_cobble_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:conglomerate_mossy_cobble_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:conglomerate_mossy_cobble_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:conglomerate_pillar", WNBlocks.GRANITE_PILLAR);
        registerBlockItemRemap("wildnature:conglomerate_polished", Blocks.POLISHED_GRANITE);
        registerBlockItemRemap("wildnature:conglomerate_polished_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:conglomerate_polished_slab", Blocks.POLISHED_GRANITE_SLAB);
        registerBlockItemRemap("wildnature:conglomerate_polished_stairs", Blocks.POLISHED_GRANITE_STAIRS);
        registerBlockItemRemap("wildnature:conglomerate_polished_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:conglomerate_polished_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:conglomerate_polished_wall", WNBlocks.GRANITE_WALL_POLISHED);
        registerBlockItemRemap("wildnature:conglomerate_pressure_plate", WNBlocks.GRANITE_PRESSURE_PLATE);
        registerBlockItemRemap("wildnature:conglomerate_roof", WNBlocks.GRANITE_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_roof_slab", WNBlocks.GRANITE_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_roof_stairs", WNBlocks.GRANITE_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_slab", Blocks.GRANITE_SLAB);
        registerBlockItemRemap("wildnature:conglomerate_slab_bricks", WNBlocks.GRANITE_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_slab_bricks_chiseled", WNBlocks.GRANITE_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_slab_bricks_cracked", WNBlocks.GRANITE_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:conglomerate_slab_bricks_mossy", WNBlocks.GRANITE_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:conglomerate_slab_cobble", WNBlocks.GRANITE_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:conglomerate_slab_cobble_mossy", WNBlocks.GRANITE_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:conglomerate_small_bricks", WNBlocks.GRANITE_BRICKS_SMALL);
        registerBlockItemRemap("wildnature:conglomerate_stairs", Blocks.GRANITE_STAIRS);
        registerBlockItemRemap("wildnature:conglomerate_stairs_bricks", WNBlocks.GRANITE_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_stairs_bricks_chiseled", WNBlocks.GRANITE_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_stairs_bricks_cracked", WNBlocks.GRANITE_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:conglomerate_stairs_bricks_mossy", WNBlocks.GRANITE_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:conglomerate_stairs_cobble", WNBlocks.GRANITE_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:conglomerate_stairs_cobble_mossy", WNBlocks.GRANITE_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:conglomerate_trapdoor", WNBlocks.GRANITE_TRAPDOOR);
        registerBlockItemRemap("wildnature:conglomerate_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB);
        registerBlockItemRemap("wildnature:conglomerate_corner_slab", WNBlocks.GRANITE_CORNER_SLAB);
        registerBlockItemRemap("wildnature:conglomerate_wall", Blocks.GRANITE_WALL);
        registerBlockItemRemap("wildnature:conglomerate_wall_bricks", WNBlocks.GRANITE_WALL_BRICKS);
        registerBlockItemRemap("wildnature:conglomerate_wall_bricks_mossy", WNBlocks.GRANITE_WALL_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:conglomerate_wall_cobble", WNBlocks.GRANITE_WALL_COBBLE);
        registerBlockItemRemap("wildnature:conglomerate_wall_cobble_mossy", WNBlocks.GRANITE_WALL_COBBLE_MOSSY);

        //GNEISS
        registerBlockItemRemap("wildnature:gneiss_ancient_bricks", WNBlocks.GNEISS_BRICKS_ANCIENT);
        registerBlockItemRemap("wildnature:gneiss_bricks_chiseled_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:gneiss_bricks_chiseled_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:gneiss_bricks_chiseled_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:gneiss_bricks_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:gneiss_bricks_cracked_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:gneiss_bricks_cracked_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:gneiss_bricks_cracked_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:gneiss_bricks_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:gneiss_bricks_mossy_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:gneiss_bricks_mossy_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:gneiss_bricks_mossy_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:gneiss_bricks_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:gneiss_cobble_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:gneiss_cobble_fence", WNBlocks.GNEISS_FENCE_COBBLE);
        registerBlockItemRemap("wildnature:gneiss_cobble_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:gneiss_cobble_trapdoor", WNBlocks.GNEISS_TRAPDOOR_COBBLE);
        registerBlockItemRemap("wildnature:gneiss_cobble_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:gneiss_firepit", WNBlocks.GNEISS_FIRE_PIT);
        registerBlockItemRemap("wildnature:gneiss_long_bricks", WNBlocks.GNEISS_BRICKS_LONG);
        registerBlockItemRemap("wildnature:gneiss_mossy_cobble_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:gneiss_mossy_cobble_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:gneiss_mossy_cobble_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:gneiss_polished_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:gneiss_polished_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:gneiss_polished_slab", WNBlocks.GNEISS_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:gneiss_polished_stairs", WNBlocks.GNEISS_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:gneiss_polished_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:gneiss_polished_wall", WNBlocks.GNEISS_WALL_POLISHED);
        registerBlockItemRemap("wildnature:gneiss_roof", WNBlocks.GNEISS_BRICKS);//
        registerBlockItemRemap("wildnature:gneiss_roof_slab", WNBlocks.GNEISS_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:gneiss_roof_stairs", WNBlocks.GNEISS_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:gneiss_slab_bricks_chiseled", WNBlocks.GNEISS_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:gneiss_small_bricks", WNBlocks.GNEISS_BRICKS_SMALL);
        registerBlockItemRemap("wildnature:gneiss_stairs_bricks_chiseled", WNBlocks.GNEISS_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:gneiss_stairs_bricks_cracked", WNBlocks.GNEISS_STAIRS_BRICKS_CRACKED);

        //LIMESTONE
        registerBlockItemRemap("wildnature:limestone_ancient_bricks", WNBlocks.LIMESTONE_BRICKS_ANCIENT);
        registerBlockItemRemap("wildnature:limestone_bricks_chiseled_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:limestone_bricks_chiseled_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:limestone_bricks_chiseled_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:limestone_bricks_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:limestone_bricks_cracked_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:limestone_bricks_cracked_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:limestone_bricks_cracked_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:limestone_bricks_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:limestone_bricks_mossy_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:limestone_bricks_mossy_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:limestone_bricks_mossy_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:limestone_bricks_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:limestone_cobble_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:limestone_cobble_fence", WNBlocks.LIMESTONE_FENCE_COBBLE);
        registerBlockItemRemap("wildnature:limestone_cobble_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:limestone_cobble_trapdoor", WNBlocks.LIMESTONE_TRAPDOOR_COBBLE);
        registerBlockItemRemap("wildnature:limestone_cobble_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:limestone_firepit", WNBlocks.LIMESTONE_FIRE_PIT);
        registerBlockItemRemap("wildnature:limestone_long_bricks", WNBlocks.LIMESTONE_BRICKS_LONG);
        registerBlockItemRemap("wildnature:limestone_mossy_cobble_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:limestone_mossy_cobble_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:limestone_mossy_cobble_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:limestone_polished_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:limestone_polished_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:limestone_polished_slab", WNBlocks.LIMESTONE_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:limestone_polished_stairs", WNBlocks.LIMESTONE_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:limestone_polished_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:limestone_polished_wall", WNBlocks.LIMESTONE_WALL_POLISHED);
        registerBlockItemRemap("wildnature:limestone_roof", WNBlocks.LIMESTONE_BRICKS);//
        registerBlockItemRemap("wildnature:limestone_roof_slab", WNBlocks.LIMESTONE_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:limestone_roof_stairs", WNBlocks.LIMESTONE_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:limestone_slab_bricks_chiseled", WNBlocks.LIMESTONE_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:limestone_small_bricks", WNBlocks.LIMESTONE_BRICKS_SMALL);
        registerBlockItemRemap("wildnature:limestone_stairs_bricks_chiseled", WNBlocks.LIMESTONE_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:limestone_stairs_bricks_cracked", WNBlocks.LIMESTONE_STAIRS_BRICKS_CRACKED);

        //MARBLE
        registerBlockItemRemap("wildnature:marble_ancient_bricks", WNBlocks.MARBLE_ROUGH_BRICKS_ANCIENT);
        registerBlockItemRemap("wildnature:marble_bricks_chiseled_corner_slab", WNBlocks.MARBLE_ROUGH_CORNER_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:marble_bricks_chiseled_half_stairs", WNBlocks.MARBLE_ROUGH_HALF_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:marble_bricks_chiseled_vertical_slab", WNBlocks.MARBLE_ROUGH_VERTICAL_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:marble_bricks_corner_slab", WNBlocks.MARBLE_ROUGH_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:marble_bricks_cracked_corner_slab", WNBlocks.MARBLE_ROUGH_CORNER_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:marble_bricks_cracked_half_stairs", WNBlocks.MARBLE_ROUGH_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:marble_bricks_cracked_vertical_slab", WNBlocks.MARBLE_ROUGH_VERTICAL_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:marble_bricks_half_stairs", WNBlocks.MARBLE_ROUGH_HALF_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:marble_bricks_mossy_corner_slab", WNBlocks.MARBLE_ROUGH_CORNER_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:marble_bricks_mossy_half_stairs", WNBlocks.MARBLE_ROUGH_HALF_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:marble_bricks_mossy_vertical_slab", WNBlocks.MARBLE_ROUGH_VERTICAL_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:marble_bricks_vertical_slab", WNBlocks.MARBLE_ROUGH_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:marble_cobble_corner_slab", WNBlocks.MARBLE_CORNER_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:marble_cobble_fence", WNBlocks.MARBLE_FENCE_COBBLE);
        registerBlockItemRemap("wildnature:marble_cobble_half_stairs", WNBlocks.MARBLE_HALF_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:marble_cobble_trapdoor", WNBlocks.MARBLE_TRAPDOOR_COBBLE);
        registerBlockItemRemap("wildnature:marble_cobble_vertical_slab", WNBlocks.MARBLE_VERTICAL_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:marble_firepit", WNBlocks.MARBLE_ROUGH_FIRE_PIT);
        registerBlockItemRemap("wildnature:marble_long_bricks", WNBlocks.MARBLE_ROUGH_BRICKS_LONG);
        registerBlockItemRemap("wildnature:marble_mossy_cobble_corner_slab", WNBlocks.MARBLE_CORNER_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:marble_mossy_cobble_half_stairs", WNBlocks.MARBLE_HALF_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:marble_mossy_cobble_vertical_slab", WNBlocks.MARBLE_VERTICAL_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:marble_polished_corner_slab", WNBlocks.MARBLE_ROUGH_CORNER_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:marble_polished_half_stairs", WNBlocks.MARBLE_ROUGH_HALF_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:marble_polished_slab", WNBlocks.MARBLE_ROUGH_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:marble_polished_stairs", WNBlocks.MARBLE_ROUGH_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:marble_polished_vertical_slab", WNBlocks.MARBLE_ROUGH_VERTICAL_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:marble_polished_wall", WNBlocks.MARBLE_ROUGH_WALL_POLISHED);
        registerBlockItemRemap("wildnature:marble_roof", WNBlocks.MARBLE_ROUGH_BRICKS);//
        registerBlockItemRemap("wildnature:marble_roof_slab", WNBlocks.MARBLE_ROUGH_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:marble_roof_stairs", WNBlocks.MARBLE_ROUGH_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:marble_slab_bricks_chiseled", WNBlocks.MARBLE_ROUGH_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:marble_small_bricks", WNBlocks.MARBLE_ROUGH_BRICKS_SMALL);
        registerBlockItemRemap("wildnature:marble_stairs_bricks_chiseled", WNBlocks.MARBLE_ROUGH_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:marble_stairs_bricks_cracked", WNBlocks.MARBLE_ROUGH_STAIRS_BRICKS_CRACKED);

        //PEGMATITE
        registerBlockItemRemap("wildnature:pegmatite", WNBlocks.LIMESTONE);
        registerBlockItemRemap("wildnature:pegmatite_ancient_bricks", WNBlocks.LIMESTONE_BRICKS_ANCIENT);
        registerBlockItemRemap("wildnature:pegmatite_bricks", WNBlocks.LIMESTONE_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_bricks_chiseled", WNBlocks.LIMESTONE_BRICKS_CHISELED);
        registerBlockItemRemap("wildnature:pegmatite_bricks_chiseled_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:pegmatite_bricks_chiseled_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_bricks_chiseled_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_bricks_cracked", WNBlocks.LIMESTONE_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:pegmatite_bricks_cracked_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:pegmatite_bricks_cracked_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:pegmatite_bricks_cracked_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:pegmatite_bricks_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_bricks_mossy", WNBlocks.LIMESTONE_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:pegmatite_bricks_mossy_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:pegmatite_bricks_mossy_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:pegmatite_bricks_mossy_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:pegmatite_bricks_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_bricks_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_button", WNBlocks.LIMESTONE_BUTTON);
        registerBlockItemRemap("wildnature:pegmatite_cobble", WNBlocks.LIMESTONE_COBBLE);
        registerBlockItemRemap("wildnature:pegmatite_cobble_fence", WNBlocks.LIMESTONE_FENCE_COBBLE);
        registerBlockItemRemap("wildnature:pegmatite_cobble_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:pegmatite_cobble_mossy", WNBlocks.LIMESTONE_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:pegmatite_cobble_trapdoor", WNBlocks.LIMESTONE_TRAPDOOR_COBBLE);
        registerBlockItemRemap("wildnature:pegmatite_cobble_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:pegmatite_cobble_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:pegmatite_fence", WNBlocks.LIMESTONE_FENCE);
        registerBlockItemRemap("wildnature:pegmatite_firepit", WNBlocks.LIMESTONE_FIRE_PIT);
        registerBlockItemRemap("wildnature:pegmatite_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS);
        registerBlockItemRemap("wildnature:pegmatite_long_bricks", WNBlocks.LIMESTONE_BRICKS_LONG);
        registerBlockItemRemap("wildnature:pegmatite_mossy_cobble_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:pegmatite_mossy_cobble_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:pegmatite_mossy_cobble_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:pegmatite_pillar", WNBlocks.LIMESTONE_PILLAR);
        registerBlockItemRemap("wildnature:pegmatite_polished", WNBlocks.LIMESTONE_POLISHED);
        registerBlockItemRemap("wildnature:pegmatite_polished_half_stairs", WNBlocks.LIMESTONE_HALF_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:pegmatite_polished_slab", WNBlocks.LIMESTONE_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:pegmatite_polished_stairs", WNBlocks.LIMESTONE_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:pegmatite_polished_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:pegmatite_polished_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:pegmatite_polished_wall", WNBlocks.LIMESTONE_WALL_POLISHED);
        registerBlockItemRemap("wildnature:pegmatite_pressure_plate", WNBlocks.LIMESTONE_PRESSURE_PLATE);
        registerBlockItemRemap("wildnature:pegmatite_roof", WNBlocks.LIMESTONE_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_roof_slab", WNBlocks.LIMESTONE_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_roof_stairs", WNBlocks.LIMESTONE_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_slab", WNBlocks.LIMESTONE_SLAB);
        registerBlockItemRemap("wildnature:pegmatite_slab_bricks", WNBlocks.LIMESTONE_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_slab_bricks_chiseled", WNBlocks.LIMESTONE_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_slab_bricks_cracked", WNBlocks.LIMESTONE_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:pegmatite_slab_bricks_mossy", WNBlocks.LIMESTONE_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:pegmatite_slab_cobble", WNBlocks.LIMESTONE_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:pegmatite_slab_cobble_mossy", WNBlocks.LIMESTONE_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:pegmatite_small_bricks", WNBlocks.LIMESTONE_BRICKS_SMALL);
        registerBlockItemRemap("wildnature:pegmatite_stairs", WNBlocks.LIMESTONE_STAIRS);
        registerBlockItemRemap("wildnature:pegmatite_stairs_bricks", WNBlocks.LIMESTONE_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_stairs_bricks_chiseled", WNBlocks.LIMESTONE_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_stairs_bricks_cracked", WNBlocks.LIMESTONE_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:pegmatite_stairs_bricks_mossy", WNBlocks.LIMESTONE_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:pegmatite_stairs_cobble", WNBlocks.LIMESTONE_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:pegmatite_stairs_cobble_mossy", WNBlocks.LIMESTONE_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:pegmatite_trapdoor", WNBlocks.LIMESTONE_TRAPDOOR);
        registerBlockItemRemap("wildnature:pegmatite_vertical_slab", WNBlocks.LIMESTONE_VERTICAL_SLAB);
        registerBlockItemRemap("wildnature:pegmatite_corner_slab", WNBlocks.LIMESTONE_CORNER_SLAB);
        registerBlockItemRemap("wildnature:pegmatite_wall", WNBlocks.LIMESTONE_WALL);
        registerBlockItemRemap("wildnature:pegmatite_wall_bricks", WNBlocks.LIMESTONE_WALL_BRICKS);
        registerBlockItemRemap("wildnature:pegmatite_wall_bricks_mossy", WNBlocks.LIMESTONE_WALL_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:pegmatite_wall_cobble", WNBlocks.LIMESTONE_WALL_COBBLE);
        registerBlockItemRemap("wildnature:pegmatite_wall_cobble_mossy", WNBlocks.LIMESTONE_WALL_COBBLE_MOSSY);

        //SLATE
        registerBlockItemRemap("wildnature:slate", WNBlocks.GNEISS);
        registerBlockItemRemap("wildnature:slate_ancient_bricks", WNBlocks.GNEISS_BRICKS_ANCIENT);
        registerBlockItemRemap("wildnature:slate_bricks", WNBlocks.GNEISS_BRICKS);
        registerBlockItemRemap("wildnature:slate_bricks_chiseled", WNBlocks.GNEISS_BRICKS_CHISELED);
        registerBlockItemRemap("wildnature:slate_bricks_chiseled_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:slate_bricks_chiseled_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:slate_bricks_chiseled_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:slate_bricks_cracked", WNBlocks.GNEISS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:slate_bricks_cracked_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:slate_bricks_cracked_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:slate_bricks_cracked_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:slate_bricks_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:slate_bricks_mossy", WNBlocks.GNEISS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:slate_bricks_mossy_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:slate_bricks_mossy_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:slate_bricks_mossy_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:slate_bricks_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:slate_bricks_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:slate_button", WNBlocks.GNEISS_BUTTON);
        registerBlockItemRemap("wildnature:slate_cobble", WNBlocks.GNEISS_COBBLE);
        registerBlockItemRemap("wildnature:slate_cobble_fence", WNBlocks.GNEISS_FENCE_COBBLE);
        registerBlockItemRemap("wildnature:slate_cobble_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:slate_cobble_mossy", WNBlocks.GNEISS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:slate_cobble_trapdoor", WNBlocks.GNEISS_TRAPDOOR_COBBLE);
        registerBlockItemRemap("wildnature:slate_cobble_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:slate_cobble_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:slate_fence", WNBlocks.GNEISS_FENCE);
        registerBlockItemRemap("wildnature:slate_firepit", WNBlocks.GNEISS_FIRE_PIT);
        registerBlockItemRemap("wildnature:slate_half_stairs", WNBlocks.GNEISS_HALF_STAIRS);
        registerBlockItemRemap("wildnature:slate_long_bricks", WNBlocks.GNEISS_BRICKS_LONG);
        registerBlockItemRemap("wildnature:slate_mossy_cobble_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:slate_mossy_cobble_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:slate_mossy_cobble_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:slate_pillar", WNBlocks.GNEISS_PILLAR);
        registerBlockItemRemap("wildnature:slate_polished", WNBlocks.GNEISS_POLISHED);
        registerBlockItemRemap("wildnature:slate_polished_half_stairs", WNBlocks.GNEISS_HALF_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:slate_polished_slab", WNBlocks.GNEISS_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:slate_polished_stairs", WNBlocks.GNEISS_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:slate_polished_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:slate_polished_corner_slab", WNBlocks.GNEISS_CORNER_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:slate_polished_wall", WNBlocks.GNEISS_WALL_POLISHED);
        registerBlockItemRemap("wildnature:slate_pressure_plate", WNBlocks.GNEISS_PRESSURE_PLATE);
        registerBlockItemRemap("wildnature:slate_roof", WNBlocks.GNEISS_BRICKS);
        registerBlockItemRemap("wildnature:slate_roof_slab", WNBlocks.GNEISS_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:slate_roof_stairs", WNBlocks.GNEISS_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:slate_slab", WNBlocks.GNEISS_SLAB);
        registerBlockItemRemap("wildnature:slate_slab_bricks", WNBlocks.GNEISS_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:slate_slab_bricks_chiseled", WNBlocks.GNEISS_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:slate_slab_bricks_cracked", WNBlocks.GNEISS_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:slate_slab_bricks_mossy", WNBlocks.GNEISS_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:slate_slab_cobble", WNBlocks.GNEISS_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:slate_slab_cobble_mossy", WNBlocks.GNEISS_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:slate_small_bricks", WNBlocks.GNEISS_BRICKS_SMALL);
        registerBlockItemRemap("wildnature:slate_stairs", WNBlocks.GNEISS_STAIRS);
        registerBlockItemRemap("wildnature:slate_stairs_bricks", WNBlocks.GNEISS_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:slate_stairs_bricks_chiseled", WNBlocks.GNEISS_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:slate_stairs_bricks_cracked", WNBlocks.GNEISS_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:slate_stairs_bricks_mossy", WNBlocks.GNEISS_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:slate_stairs_cobble", WNBlocks.GNEISS_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:slate_stairs_cobble_mossy", WNBlocks.GNEISS_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:slate_trapdoor", WNBlocks.GNEISS_TRAPDOOR);
        registerBlockItemRemap("wildnature:slate_vertical_slab", WNBlocks.GNEISS_VERTICAL_SLAB);
        registerBlockItemRemap("wildnature:slate_corner_slab", WNBlocks.GNEISS_CORNER_SLAB);
        registerBlockItemRemap("wildnature:slate_wall", WNBlocks.GNEISS_WALL);
        registerBlockItemRemap("wildnature:slate_wall_bricks", WNBlocks.GNEISS_WALL_BRICKS);
        registerBlockItemRemap("wildnature:slate_wall_bricks_mossy", WNBlocks.GNEISS_WALL_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:slate_wall_cobble", WNBlocks.GNEISS_WALL_COBBLE);
        registerBlockItemRemap("wildnature:slate_wall_cobble_mossy", WNBlocks.GNEISS_WALL_COBBLE_MOSSY);
        //GRANITE
        registerBlockItemRemap("wildnature:granite_ancient_bricks", WNBlocks.GRANITE_BRICKS_ANCIENT);
        registerBlockItemRemap("wildnature:granite_bricks_chiseled_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:granite_bricks_chiseled_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:granite_bricks_chiseled_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:granite_bricks_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:granite_bricks_cracked_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:granite_bricks_cracked_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:granite_bricks_cracked_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:granite_bricks_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:granite_bricks_mossy_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:granite_bricks_mossy_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:granite_bricks_mossy_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:granite_bricks_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:granite_cobble_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:granite_cobble_fence", WNBlocks.GRANITE_FENCE_COBBLE);
        registerBlockItemRemap("wildnature:granite_cobble_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:granite_cobble_trapdoor", WNBlocks.GRANITE_TRAPDOOR_COBBLE);
        registerBlockItemRemap("wildnature:granite_cobble_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:granite_firepit", WNBlocks.GRANITE_FIRE_PIT);
        registerBlockItemRemap("wildnature:granite_long_bricks", WNBlocks.GRANITE_BRICKS_LONG);
        registerBlockItemRemap("wildnature:granite_mossy_cobble_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:granite_mossy_cobble_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:granite_mossy_cobble_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:granite_polished_corner_slab", WNBlocks.GRANITE_CORNER_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:granite_polished_half_stairs", WNBlocks.GRANITE_HALF_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:granite_polished_slab", Blocks.POLISHED_GRANITE_SLAB);
        registerBlockItemRemap("wildnature:granite_polished_stairs", Blocks.POLISHED_GRANITE_STAIRS);
        registerBlockItemRemap("wildnature:granite_polished_vertical_slab", WNBlocks.GRANITE_VERTICAL_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:granite_polished_wall", WNBlocks.GRANITE_WALL_POLISHED);
        registerBlockItemRemap("wildnature:granite_roof", WNBlocks.GRANITE_BRICKS);//
        registerBlockItemRemap("wildnature:granite_roof_slab", WNBlocks.GRANITE_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:granite_roof_stairs", WNBlocks.GRANITE_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:granite_slab_bricks_chiseled", WNBlocks.GRANITE_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:granite_small_bricks", WNBlocks.GRANITE_BRICKS_SMALL);
        registerBlockItemRemap("wildnature:granite_stairs_bricks_chiseled", WNBlocks.GRANITE_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:granite_stairs_bricks_cracked", WNBlocks.GRANITE_STAIRS_BRICKS_CRACKED);
        //DIORITE
        registerBlockItemRemap("wildnature:diorite_ancient_bricks", WNBlocks.DIORITE_BRICKS_ANCIENT);
        registerBlockItemRemap("wildnature:diorite_bricks_chiseled_corner_slab", WNBlocks.DIORITE_CORNER_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:diorite_bricks_chiseled_half_stairs", WNBlocks.DIORITE_HALF_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:diorite_bricks_chiseled_vertical_slab", WNBlocks.DIORITE_VERTICAL_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:diorite_bricks_corner_slab", WNBlocks.DIORITE_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:diorite_bricks_cracked_corner_slab", WNBlocks.DIORITE_CORNER_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:diorite_bricks_cracked_half_stairs", WNBlocks.DIORITE_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:diorite_bricks_cracked_vertical_slab", WNBlocks.DIORITE_VERTICAL_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:diorite_bricks_half_stairs", WNBlocks.DIORITE_HALF_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:diorite_bricks_mossy_corner_slab", WNBlocks.DIORITE_CORNER_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:diorite_bricks_mossy_half_stairs", WNBlocks.DIORITE_HALF_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:diorite_bricks_mossy_vertical_slab", WNBlocks.DIORITE_VERTICAL_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:diorite_bricks_vertical_slab", WNBlocks.DIORITE_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:diorite_cobble_corner_slab", WNBlocks.DIORITE_CORNER_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:diorite_cobble_fence", WNBlocks.DIORITE_FENCE_COBBLE);
        registerBlockItemRemap("wildnature:diorite_cobble_half_stairs", WNBlocks.DIORITE_HALF_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:diorite_cobble_trapdoor", WNBlocks.DIORITE_TRAPDOOR_COBBLE);
        registerBlockItemRemap("wildnature:diorite_cobble_vertical_slab", WNBlocks.DIORITE_VERTICAL_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:diorite_firepit", WNBlocks.DIORITE_FIRE_PIT);
        registerBlockItemRemap("wildnature:diorite_long_bricks", WNBlocks.DIORITE_BRICKS_LONG);
        registerBlockItemRemap("wildnature:diorite_mossy_cobble_corner_slab", WNBlocks.DIORITE_CORNER_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:diorite_mossy_cobble_half_stairs", WNBlocks.DIORITE_HALF_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:diorite_mossy_cobble_vertical_slab", WNBlocks.DIORITE_VERTICAL_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:diorite_polished_corner_slab", WNBlocks.DIORITE_CORNER_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:diorite_polished_half_stairs", WNBlocks.DIORITE_HALF_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:diorite_polished_slab", Blocks.POLISHED_DIORITE_SLAB);
        registerBlockItemRemap("wildnature:diorite_polished_stairs", Blocks.POLISHED_DIORITE_STAIRS);
        registerBlockItemRemap("wildnature:diorite_polished_vertical_slab", WNBlocks.DIORITE_VERTICAL_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:diorite_polished_wall", WNBlocks.DIORITE_WALL_POLISHED);
        registerBlockItemRemap("wildnature:diorite_roof", WNBlocks.DIORITE_BRICKS);//
        registerBlockItemRemap("wildnature:diorite_roof_slab", WNBlocks.DIORITE_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:diorite_roof_stairs", WNBlocks.DIORITE_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:diorite_slab_bricks_chiseled", WNBlocks.DIORITE_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:diorite_small_bricks", WNBlocks.DIORITE_BRICKS_SMALL);
        registerBlockItemRemap("wildnature:diorite_stairs_bricks_chiseled", WNBlocks.DIORITE_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:diorite_stairs_bricks_cracked", WNBlocks.DIORITE_STAIRS_BRICKS_CRACKED);
        //ANDESITE
        registerBlockItemRemap("wildnature:andesite_ancient_bricks", WNBlocks.ANDESITE_BRICKS_ANCIENT);
        registerBlockItemRemap("wildnature:andesite_bricks_chiseled_corner_slab", WNBlocks.ANDESITE_CORNER_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:andesite_bricks_chiseled_half_stairs", WNBlocks.ANDESITE_HALF_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:andesite_bricks_chiseled_vertical_slab", WNBlocks.ANDESITE_VERTICAL_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:andesite_bricks_corner_slab", WNBlocks.ANDESITE_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:andesite_bricks_cracked_corner_slab", WNBlocks.ANDESITE_CORNER_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:andesite_bricks_cracked_half_stairs", WNBlocks.ANDESITE_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:andesite_bricks_cracked_vertical_slab", WNBlocks.ANDESITE_VERTICAL_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:andesite_bricks_half_stairs", WNBlocks.ANDESITE_HALF_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:andesite_bricks_mossy_corner_slab", WNBlocks.ANDESITE_CORNER_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:andesite_bricks_mossy_half_stairs", WNBlocks.ANDESITE_HALF_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:andesite_bricks_mossy_vertical_slab", WNBlocks.ANDESITE_VERTICAL_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:andesite_bricks_vertical_slab", WNBlocks.ANDESITE_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:andesite_cobble_corner_slab", WNBlocks.ANDESITE_CORNER_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:andesite_cobble_fence", WNBlocks.ANDESITE_FENCE_COBBLE);
        registerBlockItemRemap("wildnature:andesite_cobble_half_stairs", WNBlocks.ANDESITE_HALF_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:andesite_cobble_trapdoor", WNBlocks.ANDESITE_TRAPDOOR_COBBLE);
        registerBlockItemRemap("wildnature:andesite_cobble_vertical_slab", WNBlocks.ANDESITE_VERTICAL_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:andesite_firepit", WNBlocks.ANDESITE_FIRE_PIT);
        registerBlockItemRemap("wildnature:andesite_long_bricks", WNBlocks.ANDESITE_BRICKS_LONG);
        registerBlockItemRemap("wildnature:andesite_mossy_cobble_corner_slab", WNBlocks.ANDESITE_CORNER_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:andesite_mossy_cobble_half_stairs", WNBlocks.ANDESITE_HALF_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:andesite_mossy_cobble_vertical_slab", WNBlocks.ANDESITE_VERTICAL_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:andesite_polished_corner_slab", WNBlocks.ANDESITE_CORNER_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:andesite_polished_half_stairs", WNBlocks.ANDESITE_HALF_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:andesite_polished_slab", Blocks.POLISHED_ANDESITE_SLAB);
        registerBlockItemRemap("wildnature:andesite_polished_stairs", Blocks.POLISHED_ANDESITE_STAIRS);
        registerBlockItemRemap("wildnature:andesite_polished_vertical_slab", WNBlocks.ANDESITE_VERTICAL_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:andesite_polished_wall", WNBlocks.ANDESITE_WALL_POLISHED);
        registerBlockItemRemap("wildnature:andesite_roof", WNBlocks.ANDESITE_BRICKS);//
        registerBlockItemRemap("wildnature:andesite_roof_slab", WNBlocks.ANDESITE_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:andesite_roof_stairs", WNBlocks.ANDESITE_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:andesite_slab_bricks_chiseled", WNBlocks.ANDESITE_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:andesite_small_bricks", WNBlocks.ANDESITE_BRICKS_SMALL);
        registerBlockItemRemap("wildnature:andesite_stairs_bricks_chiseled", WNBlocks.ANDESITE_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:andesite_stairs_bricks_cracked", WNBlocks.ANDESITE_STAIRS_BRICKS_CRACKED);
        //STONE
        /*registerBlockItemRemap("wildnature:stone_ancient_bricks", WNBlocks.STONE_BRICKS_ANCIENT);
        registerBlockItemRemap("wildnature:chiseled_stone_bricks_corner_slab", WNBlocks.STONE_CORNER_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:chiseled_stone_bricks_half_stairs", WNBlocks.STONE_HALF_STAIRS_BRICKS);//
        registerBlockItemRemap("wildnature:chiseled_stone_bricks_vertical_slab", WNBlocks.STONE_VERTICAL_SLAB_BRICKS);//
        registerBlockItemRemap("wildnature:stone_bricks_corner_slab", WNBlocks.STONE_CORNER_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:cracked_stone_bricks_corner_slab", WNBlocks.STONE_CORNER_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:cracked_stone_bricks_half_stairs", WNBlocks.STONE_HALF_STAIRS_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:cracked_stone_bricks_vertical_slab", WNBlocks.STONE_VERTICAL_SLAB_BRICKS_CRACKED);
        registerBlockItemRemap("wildnature:stone_bricks_half_stairs", WNBlocks.STONE_HALF_STAIRS_BRICKS);
        registerBlockItemRemap("wildnature:mossy_stone_bricks_corner_slab", WNBlocks.STONE_CORNER_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:mossy_stone_bricks_half_stairs", WNBlocks.STONE_HALF_STAIRS_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:mossy_stone_bricks_vertical_slab", WNBlocks.STONE_VERTICAL_SLAB_BRICKS_MOSSY);
        registerBlockItemRemap("wildnature:stone_bricks_vertical_slab", WNBlocks.STONE_VERTICAL_SLAB_BRICKS);
        registerBlockItemRemap("wildnature:cobblestone_corner_slab", WNBlocks.STONE_CORNER_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:cobblestone_fence", WNBlocks.STONE_FENCE_COBBLE);
        registerBlockItemRemap("wildnature:cobblestone_half_stairs", WNBlocks.STONE_HALF_STAIRS_COBBLE);
        registerBlockItemRemap("wildnature:cobblestone_trapdoor", WNBlocks.STONE_TRAPDOOR_COBBLE);
        registerBlockItemRemap("wildnature:stone_trapdoor", WNBlocks.STONE_TRAPDOOR);
        registerBlockItemRemap("wildnature:cobblestone_vertical_slab", WNBlocks.STONE_VERTICAL_SLAB_COBBLE);
        registerBlockItemRemap("wildnature:stone_firepit", WNBlocks.STONE_FIRE_PIT);
        registerBlockItemRemap("wildnature:stone_long_bricks", WNBlocks.STONE_BRICKS_LONG);
        registerBlockItemRemap("wildnature:mossy_cobblestone_corner_slab", WNBlocks.STONE_CORNER_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:mossy_cobblestone_half_stairs", WNBlocks.STONE_HALF_STAIRS_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:mossy_cobblestone_vertical_slab", WNBlocks.STONE_VERTICAL_SLAB_COBBLE_MOSSY);
        registerBlockItemRemap("wildnature:smooth_stone_corner_slab", WNBlocks.STONE_CORNER_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:smooth_stone_half_stairs", WNBlocks.STONE_HALF_STAIRS_POLISHED);
        registerBlockItemRemap("wildnature:smooth_stone_stairs", Blocks.STONE_STAIRS);
        registerBlockItemRemap("wildnature:smooth_stone_vertical_slab", WNBlocks.STONE_VERTICAL_SLAB_POLISHED);
        registerBlockItemRemap("wildnature:smooth_stone_wall", WNBlocks.STONE_WALL_POLISHED);
        registerBlockItemRemap("wildnature:stone_roof", Blocks.STONE_BRICKS);//
        registerBlockItemRemap("wildnature:stone_roof_slab", Blocks.STONE_BRICK_SLAB);//
        registerBlockItemRemap("wildnature:stone_roof_stairs", Blocks.STONE_BRICK_STAIRS);//
        registerBlockItemRemap("wildnature:stone_slab_bricks_chiseled", Blocks.STONE_BRICK_SLAB);//
        registerBlockItemRemap("wildnature:stone_small_bricks", WNBlocks.STONE_BRICKS_SMALL);
        registerBlockItemRemap("wildnature:stone_stairs_bricks_chiseled", Blocks.STONE_BRICK_STAIRS);*/

        //ORES
        registerItemRemap("wildnature:amethyst_ore", Item.getItemFromBlock(WNBlocks.AMETHYST_FORMATION));
        registerItemRemap("wildnature:sapphire_ore", Item.getItemFromBlock(WNBlocks.SAPPHIRE_FORMATION));
        registerItemRemap("wildnature:malachite_ore", Item.getItemFromBlock(WNBlocks.MALACHITE_FORMATION));
        registerItemRemap("wildnature:ruby_ore", Item.getItemFromBlock(WNBlocks.RUBY_FORMATION));
        registerBlockRemap("wildnature:amethyst_ore", Blocks.STONE);
        registerBlockRemap("wildnature:sapphire_ore", Blocks.STONE);
        registerBlockRemap("wildnature:malachite_ore", Blocks.STONE);
        registerBlockRemap("wildnature:ruby_ore", Blocks.STONE);

        //FURNITURE
        registerBlockItemRemap("wildnature:andirons", Blocks.IRON_BARS);
        registerBlockItemRemap("wildnature:anvil", Blocks.ANVIL);
        registerBlockItemRemap("wildnature:beams", WNBlocks.OAK_BEAM);
        registerBlockItemRemap("wildnature:chair", WNBlocks.OAK_CHAIR);
        registerBlockItemRemap("wildnature:dungeon_heart", Blocks.OBSIDIAN);
        registerBlockItemRemap("wildnature:bones_block", Blocks.BONE_BLOCK);
        registerBlockItemRemap("wildnature:halftable", WNBlocks.OAK_SQUARE_TABLE);
        registerBlockItemRemap("wildnature:slab_corner", WNBlocks.OAK_CORNER_SLAB);
        registerBlockItemRemap("wildnature:slab_vertical", WNBlocks.OAK_VERTICAL_SLAB);
        registerBlockItemRemap("wildnature:smalltable", WNBlocks.OAK_ROUND_TABLE);
        registerBlockItemRemap("wildnature:stickframe", Blocks.GLASS);
        registerBlockItemRemap("wildnature:stool", WNBlocks.OAK_STOOL);
        registerBlockItemRemap("wildnature:weaponsrack", Blocks.OAK_FENCE);

        //WEAPONS
        registerItemRemap("wildnature:amber_axe", WNItems.SAPPHIRE_AXE);
        registerItemRemap("wildnature:amber_hoe", WNItems.STEEL_HOE);
        registerItemRemap("wildnature:amber_pickaxe", WNItems.SAPPHIRE_PICKAXE);
        registerItemRemap("wildnature:amber_shard", WNItems.AMBER_INGOT);
        registerItemRemap("wildnature:amber_crystal", WNItems.AMBER_INGOT);
        registerItemRemap("wildnature:amber_shovel", WNItems.SAPPHIRE_SHOVEL);
        registerItemRemap("wildnature:amber_sword", WNItems.SAPPHIRE_SWORD);
        registerItemRemap("wildnature:amethyst_crystal", WNItems.AMETHYST_INGOT);
        registerItemRemap("wildnature:malachite_shard", WNItems.MALACHITE_RAW);
        registerItemRemap("wildnature:malachite_crystal", WNItems.MALACHITE_INGOT);
        registerItemRemap("wildnature:malachite_hoe", WNItems.STEEL_HOE);
        registerItemRemap("wildnature:ruby_shard", WNItems.RUBY_RAW);
        registerItemRemap("wildnature:ruby_crystal", WNItems.RUBY_INGOT);
        registerItemRemap("wildnature:ruby_hoe", WNItems.STEEL_HOE);
        registerItemRemap("wildnature:sapphire_shard", WNItems.SAPPHIRE_RAW);
        registerItemRemap("wildnature:sapphire_crystal", WNItems.SAPPHIRE_INGOT);
        registerItemRemap("wildnature:sapphire_hoe", WNItems.STEEL_HOE);
        registerItemRemap("wildnature:silver_hoe", WNItems.STEEL_HOE);
    }

    private void registerBlockRemap(String oldID, Block newBlock) {
        registerRemap(new ResourceLocation(oldID), newBlock.getRegistryName(), DataFixerType.BLOCK);
    }

    private void registerBlockRemap(ResourceLocation oldID, Block newBlock) {
        registerRemap(oldID, newBlock.getRegistryName(), DataFixerType.BLOCK);
    }

    private void registerBlockItemRemap(ResourceLocation oldID, Block newBlock) {
        registerRemap(oldID, newBlock.getRegistryName(), DataFixerType.ALL);
    }

    private void registerBlockItemRemap(String oldID, Block newBlock) {
        registerRemap(new ResourceLocation(oldID), newBlock.getRegistryName(), DataFixerType.ALL);
    }

    private void registerItemRemap(ResourceLocation oldID, Item newItem) {
        registerRemap(oldID, newItem.getRegistryName(), DataFixerType.ITEM);
    }

    private void registerItemRemap(String oldID, Item newItem) {
        registerRemap(new ResourceLocation(oldID), newItem.getRegistryName(), DataFixerType.ITEM);
    }

    private void registerRemap(ResourceLocation oldID, ResourceLocation newID, DataFixerType type) {
        if (type == DataFixerType.BLOCK || type == DataFixerType.ALL) {
            blockRemap.put(oldID, newID);
        }

        if (type == DataFixerType.ITEM || type == DataFixerType.ALL) {
            itemRemap.put(oldID, newID);
        }
    }

    public LinkedHashMap<ResourceLocation, ResourceLocation> getBlockRemap() {
        return blockRemap;
    }

    public LinkedHashMap<ResourceLocation, ResourceLocation> getItemRemap() {
        return itemRemap;
    }

    public enum DataFixerType {
        ALL,
        ITEM,
        BLOCK
    }
}
