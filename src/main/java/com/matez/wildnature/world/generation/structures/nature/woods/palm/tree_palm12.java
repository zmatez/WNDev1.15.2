package com.matez.wildnature.world.generation.structures.nature.woods.palm;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraftforge.common.IPlantable;

import java.util.Set;

@Deprecated
public class tree_palm12 extends SchemFeature {
    public tree_palm12() {
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


        Block(2, 6, 6, LEAVES);
        Block(3, 7, 6, LEAVES);
        Block(3, 10, 3, LEAVES);
        Block(4, 5, 9, LEAVES);
        Block(4, 6, 3, LEAVES);
        Block(4, 7, 4, LEAVES);
        Block(4, 8, 6, LEAVES);
        Block(4, 9, 4, LEAVES);
        Block(5, 6, 8, LEAVES);
        Block(5, 7, 7, LEAVES);
        Block(5, 8, 5, LEAVES);
        Block(5, 8, 6, LEAVES);
        Block(5, 9, 6, LEAVES);
        Block(5, 9, 7, LEAVES);
        Block(5, 10, 7, LEAVES);
        Block(5, 11, 8, LEAVES);
        Block(6, 1, 6, LOG);
        Block(6, 2, 6, LOG);
        Block(6, 3, 6, LOG);
        Block(6, 4, 6, LOG);
        Block(6, 5, 6, LOG);
        Block(6, 5, 7, LEAVES);
        Block(6, 6, 4, LEAVES);
        Block(6, 6, 5, LEAVES);
        Block(6, 6, 6, LOG);
        Block(6, 7, 4, LEAVES);
        Block(6, 7, 5, LEAVES);
        Block(6, 7, 6, LOG);
        Block(6, 7, 8, LEAVES);
        Block(6, 8, 5, LEAVES);
        Block(6, 8, 6, LEAVES);
        Block(6, 8, 7, LEAVES);
        Block(6, 9, 4, LEAVES);
        Block(6, 9, 5, LEAVES);
        Block(6, 9, 6, LEAVES);
        Block(6, 10, 4, LEAVES);
        Block(7, 5, 2, LEAVES);
        Block(7, 5, 9, LEAVES);
        Block(7, 6, 3, LEAVES);
        Block(7, 6, 6, LEAVES);
        Block(7, 6, 9, LEAVES);
        Block(7, 7, 5, LEAVES);
        Block(7, 7, 6, LEAVES);
        Block(7, 8, 6, LEAVES);
        Block(7, 9, 6, LEAVES);
        Block(7, 9, 7, LEAVES);
        Block(7, 11, 4, LEAVES);
        Block(8, 6, 5, LEAVES);
        Block(8, 7, 7, LEAVES);
        Block(8, 9, 6, LEAVES);
        Block(8, 10, 8, LEAVES);
        Block(8, 11, 8, LEAVES);
        Block(9, 5, 5, LEAVES);
        Block(9, 10, 6, LEAVES);
        Block(10, 11, 6, LEAVES);

//   wildnature mod 2019/07/30 20:55:14
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
//
//     File generated automatically

        return super.setBlocks();
    }
}
