package com.matez.wildnature.world.generation.structures.nature.woods.jelly;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraftforge.common.IPlantable;

import java.util.Set;

public class jelly1 extends SchemFeature {

    @Override
    public boolean canGrowTree(IWorldGenerationReader world, BlockPos pos, IPlantable sapling) {
        return world.hasBlockState(pos, state -> {
            return state.getBlock() == Blocks.SAND || state.getBlock() == WNBlocks.WHITE_SAND;
        }) || super.canGrowTree(world, pos, sapling);
    }


    @Override
    public Set<BlockPos> setBlocks() {

        Block(-2, 3, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 4, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 5, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(1, 5, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(3, 5, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 6, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(1, 6, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(3, 6, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 7, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-3, 7, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 7, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-1, 7, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(0, 7, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(1, 7, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(2, 7, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(3, 7, -3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 6, -2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 7, -2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(3, 7, -2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-3, 8, -2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 8, -2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-1, 8, -2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(0, 8, -2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(1, 8, -2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(2, 8, -2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 7, -1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(3, 7, -1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-3, 8, -1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(2, 8, -1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 9, -1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-1, 9, -1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(0, 9, -1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(1, 9, -1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(0, 1, 0, "wildnature:jelly_blue_block[waterlogged=false]");
        Block(0, 2, 0, "wildnature:jelly_blue_block[waterlogged=false]");
        Block(0, 3, 0, "wildnature:jelly_blue_block[waterlogged=false]");
        Block(0, 4, 0, "wildnature:jelly_blue_block[waterlogged=false]");
        Block(0, 5, 0, "wildnature:jelly_blue_block[waterlogged=false]");
        Block(3, 5, 0, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(0, 6, 0, "wildnature:jelly_blue_block[waterlogged=false]");
        Block(3, 6, 0, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 7, 0, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(0, 7, 0, "wildnature:jelly_blue_block[waterlogged=false]");
        Block(3, 7, 0, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-3, 8, 0, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(0, 8, 0, "wildnature:jelly_blue_block[waterlogged=false]");
        Block(2, 8, 0, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 9, 0, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-1, 9, 0, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(0, 9, 0, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(1, 9, 0, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 3, 1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 4, 1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 5, 1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 6, 1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 7, 1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(3, 7, 1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-3, 8, 1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(2, 8, 1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 9, 1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-1, 9, 1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(0, 9, 1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(1, 9, 1, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 7, 2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(3, 7, 2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-3, 8, 2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(2, 8, 2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 9, 2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-1, 9, 2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(0, 9, 2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(1, 9, 2, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(3, 4, 3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(3, 5, 3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(3, 6, 3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 7, 3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(3, 7, 3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-3, 8, 3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 8, 3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-1, 8, 3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(0, 8, 3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(1, 8, 3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(2, 8, 3, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 3, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 4, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 4, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 5, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 5, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(1, 5, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 6, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 6, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(1, 6, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-4, 7, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-3, 7, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-2, 7, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(-1, 7, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(0, 7, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(1, 7, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(2, 7, 4, "wildnature:jelly_orange_block[waterlogged=false]");
        Block(3, 7, 4, "wildnature:jelly_orange_block[waterlogged=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}