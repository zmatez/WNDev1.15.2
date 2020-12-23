package com.matez.wildnature.world.generation.structures.nature.woods.palm;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraftforge.common.IPlantable;

import java.util.Set;

public class tree_palm2 extends SchemFeature {
    public tree_palm2() {
        super();

    }

    @Override
    public boolean canGrowTree(IWorldGenerationReader world, BlockPos pos, IPlantable sapling) {
        return world.hasBlockState(pos, state -> {
            return state.getBlock() == Blocks.SAND || state.getBlock() == WNBlocks.WHITE_SAND;
        }) || super.canGrowTree(world, pos, sapling);
    }

    @Override
    public Set<BlockPos> setBlocks() {


        Block(-12, 12, 3, LEAVES);
        Block(-11, 9, 3, LEAVES);
        Block(-11, 10, 3, LEAVES);
        Block(-11, 11, 3, LEAVES);
        Block(-11, 12, 3, LEAVES);
        Block(-11, 12, 4, LEAVES);
        Block(-11, 13, 3, LEAVES);
        Block(-10, 12, 4, LEAVES);
        Block(-10, 12, 13, LEAVES);
        Block(-10, 13, 3, LEAVES);
        Block(-10, 13, 4, LEAVES);
        Block(-10, 13, 13, LEAVES);
        Block(-10, 14, 4, LEAVES);
        Block(-9, 9, 13, LEAVES);
        Block(-9, 10, 13, LEAVES);
        Block(-9, 11, 13, LEAVES);
        Block(-9, 12, 12, LEAVES);
        Block(-9, 12, 13, LEAVES);
        Block(-9, 13, 11, LEAVES);
        Block(-9, 13, 12, LEAVES);
        Block(-9, 13, 13, LEAVES);
        Block(-9, 14, 4, LEAVES);
        Block(-9, 14, 5, LEAVES);
        Block(-9, 14, 11, LEAVES);
        Block(-9, 14, 12, LEAVES);
        Block(-9, 15, 5, LEAVES);
        Block(-9, 15, 11, LEAVES);
        Block(-8, 14, 5, LEAVES);
        Block(-8, 14, 6, LEAVES);
        Block(-8, 14, 11, LEAVES);
        Block(-8, 15, 5, LEAVES);
        Block(-8, 15, 6, LEAVES);
        Block(-8, 15, 7, LEAVES);
        Block(-8, 15, 8, LEAVES);
        Block(-8, 15, 10, LEAVES);
        Block(-8, 15, 11, LEAVES);
        Block(-7, 14, 9, LEAVES);
        Block(-7, 15, 6, LEAVES);
        Block(-7, 15, 7, LEAVES);
        Block(-7, 15, 8, LEAVES);
        Block(-7, 15, 9, LEAVES);
        Block(-7, 15, 10, LEAVES);
        Block(-7, 16, 6, LEAVES);
        Block(-7, 16, 7, LEAVES);
        Block(-7, 16, 8, LEAVES);
        Block(-6, 13, 6, LEAVES);
        Block(-6, 13, 7, LEAVES);
        Block(-6, 14, 6, LEAVES);
        Block(-6, 14, 7, LOG);
        Block(-6, 14, 8, LOG);
        Block(-6, 14, 9, LEAVES);
        Block(-6, 15, 6, LEAVES);
        Block(-6, 15, 7, LEAVES);
        Block(-6, 15, 8, LOG);
        Block(-6, 15, 9, LEAVES);
        Block(-6, 15, 10, LEAVES);
        Block(-6, 15, 11, LEAVES);
        Block(-6, 16, 5, LEAVES);
        Block(-6, 16, 6, LEAVES);
        Block(-6, 16, 7, LEAVES);
        Block(-6, 16, 8, LEAVES);
        Block(-6, 16, 9, LEAVES);
        Block(-6, 16, 10, LEAVES);
        Block(-6, 17, 7, LEAVES);
        Block(-6, 17, 8, LEAVES);
        Block(-5, 12, 14, LEAVES);
        Block(-5, 13, 6, LOG);
        Block(-5, 13, 7, LOG);
        Block(-5, 14, 5, LEAVES);
        Block(-5, 14, 7, LOG);
        Block(-5, 14, 11, LEAVES);
        Block(-5, 15, 4, LEAVES);
        Block(-5, 15, 5, LEAVES);
        Block(-5, 15, 6, LEAVES);
        Block(-5, 15, 7, LOG);
        Block(-5, 15, 8, LEAVES);
        Block(-5, 15, 9, LEAVES);
        Block(-5, 15, 11, LEAVES);
        Block(-5, 15, 12, LEAVES);
        Block(-5, 16, 5, LEAVES);
        Block(-5, 16, 6, LEAVES);
        Block(-5, 16, 7, LEAVES);
        Block(-5, 16, 8, LEAVES);
        Block(-5, 16, 9, LEAVES);
        Block(-5, 16, 10, LEAVES);
        Block(-5, 17, 5, LEAVES);
        Block(-5, 17, 7, LEAVES);
        Block(-5, 17, 8, LEAVES);
        Block(-5, 17, 9, LEAVES);
        Block(-4, 9, 14, LEAVES);
        Block(-4, 10, 14, LEAVES);
        Block(-4, 11, 5, LOG);
        Block(-4, 11, 14, LEAVES);
        Block(-4, 12, 5, LOG);
        Block(-4, 12, 6, LOG);
        Block(-4, 12, 7, LEAVES);
        Block(-4, 12, 13, LEAVES);
        Block(-4, 12, 14, LEAVES);
        Block(-4, 13, 5, LOG);
        Block(-4, 13, 6, LOG);
        Block(-4, 13, 7, LEAVES);
        Block(-4, 13, 13, LEAVES);
        Block(-4, 14, 6, LOG);
        Block(-4, 14, 7, LEAVES);
        Block(-4, 14, 8, LEAVES);
        Block(-4, 14, 11, LEAVES);
        Block(-4, 14, 12, LEAVES);
        Block(-4, 14, 13, LEAVES);
        Block(-4, 15, 3, LEAVES);
        Block(-4, 15, 4, LEAVES);
        Block(-4, 15, 5, LEAVES);
        Block(-4, 15, 6, LEAVES);
        Block(-4, 15, 7, LEAVES);
        Block(-4, 15, 8, LEAVES);
        Block(-4, 15, 10, LEAVES);
        Block(-4, 15, 11, LEAVES);
        Block(-4, 15, 12, LEAVES);
        Block(-4, 16, 5, LEAVES);
        Block(-4, 16, 6, LEAVES);
        Block(-4, 16, 7, LEAVES);
        Block(-4, 16, 8, LEAVES);
        Block(-4, 16, 9, LEAVES);
        Block(-4, 16, 10, LEAVES);
        Block(-4, 17, 8, LEAVES);
        Block(-4, 17, 9, LEAVES);
        Block(-3, 10, 4, LOG);
        Block(-3, 11, -1, LEAVES);
        Block(-3, 11, 4, LOG);
        Block(-3, 11, 5, LOG);
        Block(-3, 12, -1, LEAVES);
        Block(-3, 12, 0, LEAVES);
        Block(-3, 12, 4, LOG);
        Block(-3, 12, 5, LOG);
        Block(-3, 13, 0, LEAVES);
        Block(-3, 13, 1, LEAVES);
        Block(-3, 13, 5, LOG);
        Block(-3, 14, 1, LEAVES);
        Block(-3, 14, 2, LEAVES);
        Block(-3, 14, 6, LEAVES);
        Block(-3, 15, 2, LEAVES);
        Block(-3, 15, 3, LEAVES);
        Block(-3, 15, 5, LEAVES);
        Block(-3, 15, 6, LEAVES);
        Block(-3, 15, 8, LEAVES);
        Block(-3, 15, 9, LEAVES);
        Block(-3, 16, 6, LEAVES);
        Block(-3, 16, 8, LEAVES);
        Block(-3, 16, 9, LEAVES);
        Block(-3, 17, 9, LEAVES);
        Block(-2, 1, 0, LOG);
        Block(-2, 8, 2, LOG);
        Block(-2, 9, 3, LOG);
        Block(-2, 10, 3, LOG);
        Block(-2, 10, 4, LOG);
        Block(-2, 11, 3, LOG);
        Block(-2, 11, 4, LOG);
        Block(-2, 15, 5, LEAVES);
        Block(-2, 15, 6, LEAVES);
        Block(-2, 15, 10, LEAVES);
        Block(-2, 16, 5, LEAVES);
        Block(-2, 16, 9, LEAVES);
        Block(-2, 16, 10, LEAVES);
        Block(-1, 1, -1, LOG);
        Block(-1, 1, 0, LOG);
        Block(-1, 1, 1, LOG);
        Block(-1, 2, 0, LOG);
        Block(-1, 2, 1, LOG);
        Block(-1, 4, 1, LOG);
        Block(-1, 5, 1, LOG);
        Block(-1, 6, 1, LOG);
        Block(-1, 6, 2, LOG);
        Block(-1, 7, 1, LOG);
        Block(-1, 7, 2, LOG);
        Block(-1, 8, 1, LOG);
        Block(-1, 8, 2, LOG);
        Block(-1, 9, 2, LOG);
        Block(-1, 9, 3, LOG);
        Block(-1, 13, 10, LEAVES);
        Block(-1, 13, 11, LEAVES);
        Block(-1, 14, 5, LEAVES);
        Block(-1, 14, 10, LEAVES);
        Block(-1, 14, 11, LEAVES);
        Block(-1, 15, 5, LEAVES);
        Block(-1, 15, 9, LEAVES);
        Block(-1, 15, 10, LEAVES);
        Block(-1, 16, 9, LEAVES);
        Block(-1, 16, 10, LEAVES);
        Block(0, 1, -1, LOG);
        Block(0, 1, 0, LOG);
        Block(0, 1, 1, LOG);
        Block(0, 1, 2, LOG);
        Block(0, 2, -1, LOG);
        Block(0, 2, 0, LOG);
        Block(0, 2, 1, LOG);
        Block(0, 3, 0, LOG);
        Block(0, 3, 1, LOG);
        Block(0, 4, 0, LOG);
        Block(0, 4, 1, LOG);
        Block(0, 5, 0, LOG);
        Block(0, 5, 1, LOG);
        Block(0, 6, 1, LOG);
        Block(0, 7, 1, LOG);
        Block(0, 12, 6, LEAVES);
        Block(0, 12, 10, LEAVES);
        Block(0, 12, 11, LEAVES);
        Block(0, 12, 12, LEAVES);
        Block(0, 13, 5, LEAVES);
        Block(0, 13, 6, LEAVES);
        Block(0, 13, 10, LEAVES);
        Block(0, 13, 11, LEAVES);
        Block(0, 14, 5, LEAVES);
        Block(0, 15, 5, LEAVES);
        Block(1, 1, 0, LOG);
        Block(1, 1, 1, LOG);
        Block(1, 2, -1, LOG);
        Block(1, 9, 12, LEAVES);
        Block(1, 10, 12, LEAVES);
        Block(1, 11, 11, LEAVES);
        Block(1, 11, 12, LEAVES);
        Block(1, 12, 5, LEAVES);
        Block(1, 12, 11, LEAVES);
        Block(1, 13, 5, LEAVES);
        Block(2, 1, -1, LOG);
        Block(2, 11, 5, LEAVES);
        Block(2, 12, 5, LEAVES);
        Block(3, 8, 4, LEAVES);
        Block(3, 9, 4, LEAVES);
        Block(3, 10, 4, LEAVES);
        Block(3, 10, 5, LEAVES);
        Block(3, 11, 4, LEAVES);
        Block(3, 11, 5, LEAVES);
        Block(3, 12, 5, LEAVES);

//   wildnature mod 2019/07/30 20:55:15
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
//
//     File generated automatically

        return super.setBlocks();
    }
}
