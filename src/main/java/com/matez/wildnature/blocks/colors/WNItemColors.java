package com.matez.wildnature.blocks.colors;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.items.dye.IDyeableItem;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILightReader;

public class WNItemColors {

    public ItemColors colors = Minecraft.getInstance().getItemColors();
    public BlockColors blockColors = Minecraft.getInstance().getBlockColors();
    public WNItemColors(){
        //foliage: 7842607 default: 4764952
        //grass: 9551193 default: -7423631
        colors.register((p_210235_1_, p_210235_2_) -> {
            BlockState blockstate = ((BlockItem)p_210235_1_.getItem()).getBlock().getDefaultState();
            return blockColors.getColor(blockstate, (ILightReader)null, (BlockPos)null, p_210235_2_);
        }, WNBlocks.BROWN_GRASS_BLOCK, WNBlocks.DESERT_GRASS_BLOCK, WNBlocks.DRIED_GRASS_BLOCK, WNBlocks.MOLD_GRASS_BLOCK, WNBlocks.TROPICAL_GRASS_BLOCK, WNBlocks.OVERGROWN_STONE,
                WNBlocks.ASPEN_LEAVES, WNBlocks.BAOBAB_LEAVES, WNBlocks.BEECH_LEAVES, WNBlocks.CEDAR_LEAVES, WNBlocks.HAZEL_LEAVES, WNBlocks.HORNBEAM_LEAVES, WNBlocks.MAHOGANY_LEAVES,
                WNBlocks.MANGROVE_LEAVES, WNBlocks.MAPLE_LEAVES, WNBlocks.POPLAR_LEAVES, WNBlocks.WILLOW_LEAVES, WNBlocks.SMALL_BUSH_LEAVES, WNBlocks.LARGE_BUSH_LEAVES, WNBlocks.DENSE_BUSH_LEAVES);
        colors.register((p_210239_0_, p_210239_1_) -> {
            return p_210239_1_ > 0 ? -1 : ((IDyeableItem)p_210239_0_.getItem()).getColor(p_210239_0_);
        }, WNItems.SILVER_SWORD, WNItems.SILVER_PICKAXE, WNItems.SILVER_AXE, WNItems.SILVER_SHOVEL, WNItems.SILVER_HOE, WNItems.SILVER_INGOT);
    }

}
