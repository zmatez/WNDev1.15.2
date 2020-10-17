package com.matez.wildnature.registry.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.*;
import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;

public class BuildingRegistry {

    public Block[] rocks;

    /*
    CHANGES
    basalt_bricks_long <- basalt_long_bricks
    basalt_corner_slab_bricks <- basalt_bricks_corner_slab
    basalt_corner_slab_bricks_mossy <- basalt_bricks_mossy_corner_slab
    basalt_corner_slab_cobble_mossy <- basalt_mossy_cobble_corner_slab
    basalt_fence_cobble <- basalt_cobble_fence
    basalt_half_stairs_bricks <- basalt_bricks_half_stairs
    basalt_half_stairs_bricks_mossy <- basalt_bricks_mossy_half_stairs
    basalt_half_stairs_cobble_mossy <- basalt_mossy_cobble_half_stairs
    basalt_slab_bricks <-
    basalt_slab_bricks_long <-
    basalt_slab_bricks_small <-
    basalt_slab_cobble_mossy <-
    basalt_stairs <-
    basalt_stairs_bricks_cracked <-
    basalt_stairs_cobble <-
    basalt_stairs_polished <-
    basalt_trapdoor_cobble <- basalt_cobble_trapdoor
    basalt_vertical_slab_bricks_cracked <- basalt_bricks_cracked_vertical_slab
    basalt_vertical_slab_cobble <- basalt_bricks_
    basalt_vertical_slab_polished <-
    basalt_wall_bricks <-
    basalt_wall_cobble <-
    basalt_wall_polished <- basalt_polished_wall
    
    //again
    basalt_ancient_bricks -> basalt_bricks_ancient
    basalt_bricks_corner_slab -> basalt_corner_slab_bricks
    basalt_bricks_cracked_corner_slab -> basalt_corner_slab_bricks_cracked
    basalt_bricks_cracked_half_stairs -> basalt_half_stairs_bricks_cracked
    basalt_bricks_cracked_vertical_slab -> basalt_vertical_slab_bricks_cracked
    basalt_bricks_half_stairs -> basalt_half_stairs_bricks
    basalt_bricks_mossy_corner_slab -> basalt_corner_slab_bricks_mossy
    basalt_bricks_mossy_half_stairs -> basalt_half_stairs_bricks_mossy
    basalt_bricks_mossy_vertical_slab -> basalt_vertical_slab_bricks_mossy
    basalt_bricks_vertical_slab -> basalt_vertical_slab_bricks
    basalt_cobble_corner_slab -> basalt_corner_slab_cobble
    basalt_cobble_fence -> basalt_fence_cobble
    basalt_cobble_half_stairs -> basalt_half_stairs_cobble
    basalt_cobble_trapdoor -> basalt_trapdoor_cobble
    basalt_cobble_vertical_slab -> basalt_vertical_slab_cobble
    basalt_long_bricks -> basalt_bricks_long
    basalt_mossy_cobble_corner_slab -> basalt_corner_slab_cobble_mossy
    basalt_mossy_cobble_half_stairs -> basalt_half_stairs_cobble_mossy
    basalt_mossy_cobble_vertical_slab -> basalt_vertical_slab_cobble_mossy
    basalt_polished_corner_slab -> basalt_corner_slab_polished
    basalt_polished_half_stairs -> basalt_half_stairs_polished
    basalt_polished_slab -> basalt_slab_polished
    basalt_polished_stairs -> basalt_stairs_polished
    basalt_polished_vertical_slab -> basalt_vertical_slab_polished
    basalt_polished_wall -> basalt_wall_polished
    basalt_small_bricks -> basalt_bricks_small

    basalt_roof -> DELETED
    basalt_roof_slab ->  DELETED
    basalt_roof_stairs -> DELETED
    basalt_slab_bricks_chiseled -> DELETED	
    basalt_stairs_bricks_chiseled -> DELETED
    basalt_bricks_chiseled_corner_slab -> DELETED
    basalt_bricks_chiseled_half_stairs -> DELETED
    basalt_bricks_chiseled_vertical_slab -> DELETED


    REGEX
    ["1old*basalt_ancient_bricks","1new*basalt_bricks_ancient","2old*basalt_bricks_corner_slab","2new*basalt_corner_slab_bricks","3old*basalt_bricks_cracked_corner_slab","3new*basalt_corner_slab_bricks_cracked","4old*basalt_bricks_cracked_half_stairs","4new*basalt_half_stairs_bricks_cracked","5old*basalt_bricks_cracked_vertical_slab","5new*basalt_vertical_slab_bricks_cracked","6old*basalt_bricks_half_stairs","6new*basalt_half_stairs_bricks","7old*basalt_bricks_mossy_corner_slab","7new*basalt_corner_slab_bricks_mossy","8old*basalt_bricks_mossy_half_stairs","8new*basalt_half_stairs_bricks_mossy","9old*basalt_bricks_mossy_vertical_slab","9new*basalt_vertical_slab_bricks_mossy","10old*basalt_bricks_vertical_slab","10new*basalt_vertical_slab_bricks","11old*basalt_cobble_corner_slab","11new*basalt_corner_slab_cobble","12old*basalt_cobble_fence","12new*basalt_fence_cobble","13old*basalt_cobble_half_stairs","13new*basalt_half_stairs_cobble","14old*basalt_cobble_trapdoor","14new*basalt_trapdoor_cobble","15old*basalt_cobble_vertical_slab","15new*basalt_vertical_slab_cobble","16old*basalt_long_bricks","16new*basalt_bricks_long","17old*basalt_mossy_cobble_corner_slab","17new*basalt_corner_slab_cobble_mossy","18old*basalt_mossy_cobble_half_stairs","18new*basalt_half_stairs_cobble_mossy","19old*basalt_mossy_cobble_vertical_slab","19new*basalt_vertical_slab_cobble_mossy","20old*basalt_polished_corner_slab","20new*basalt_corner_slab_polished","21old*basalt_polished_half_stairs","21new*basalt_half_stairs_polished","22old*basalt_polished_slab","22new*basalt_slab_polished","23old*basalt_polished_stairs","23new*basalt_stairs_polished","24old*basalt_polished_vertical_slab","24new*basalt_vertical_slab_polished","25old*basalt_polished_wall","25new*basalt_wall_polished","26old*basalt_small_bricks","26new*basalt_bricks_small"]
    */

    public BuildingRegistry() {
        rocks = new Block[]{
                WNBlocks.SANDSTONE_BRICKS = new BlockBase(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(1.5F, 6.0F), new Item.Properties().group(Main.WILDNATURE_BUILDING_GROUP), Main.RegistryEvents.location("sandstone_bricks")),
                WNBlocks.SANDSTONE_ANCIENT_BRICKS = new BlockBase(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(0.8F), new Item.Properties().group(Main.WILDNATURE_BUILDING_GROUP), Main.RegistryEvents.location("sandstone_ancient_bricks"))
        };
    }

    public Block[] getBlocks() {
        return rocks;
    }
}
