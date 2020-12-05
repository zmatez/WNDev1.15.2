package com.matez.wildnature.world.generation.structures.nature.woods.jelly;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraftforge.common.IPlantable;

import java.util.Set;

public class jelly2 extends SchemFeature {
    @Override
    public boolean canGrowTree(IWorldGenerationReader world, BlockPos pos, IPlantable sapling) {
        return pos.getY() < 50 && world.hasBlockState(pos, state -> {
            return state.getBlock() == Blocks.SAND || state.getBlock() == WNBlocks.WHITE_SAND || state.getBlock() == WNBlocks.ALGAE_BLOCK || state.getBlock() == Blocks.GRAVEL;
        });
    }
    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 6, -4, LEAVES);
        Block(-3, 7, -4, LEAVES);
        Block(0, 7, -4, LEAVES);
        Block(-3, 8, -4, LEAVES);
        Block(0, 8, -4, LEAVES);
        Block(-3, 9, -4, LEAVES);
        Block(0, 9, -4, LEAVES);
        Block(2, 9, -4, LEAVES);
        Block(-3, 10, -4, LEAVES);
        Block(-2, 10, -4, LEAVES);
        Block(-1, 10, -4, LEAVES);
        Block(0, 10, -4, LEAVES);
        Block(1, 10, -4, LEAVES);
        Block(2, 10, -4, LEAVES);
        Block(3, 10, -4, LEAVES);
        Block(-3, 10, -3, LEAVES);
        Block(3, 10, -3, LEAVES);
        Block(-2, 11, -3, LEAVES);
        Block(-1, 11, -3, LEAVES);
        Block(0, 11, -3, LEAVES);
        Block(1, 11, -3, LEAVES);
        Block(2, 11, -3, LEAVES);
        Block(3, 6, -2, LEAVES);
        Block(3, 7, -2, LEAVES);
        Block(-3, 8, -2, LEAVES);
        Block(3, 8, -2, LEAVES);
        Block(-3, 9, -2, LEAVES);
        Block(3, 9, -2, LEAVES);
        Block(-3, 10, -2, LEAVES);
        Block(3, 10, -2, LEAVES);
        Block(-2, 11, -2, LEAVES);
        Block(2, 11, -2, LEAVES);
        Block(-1, 12, -2, LEAVES);
        Block(0, 12, -2, LEAVES);
        Block(1, 12, -2, LEAVES);
        Block(-3, 10, -1, LEAVES);
        Block(3, 10, -1, LEAVES);
        Block(-2, 11, -1, LEAVES);
        Block(2, 11, -1, LEAVES);
        Block(-1, 12, -1, LEAVES);
        Block(0, 12, -1, LEAVES);
        Block(1, 12, -1, LEAVES);
        Block(0, 1, 0, LOG);
        Block(0, 2, 0, LOG);
        Block(0, 3, 0, LOG);
        Block(0, 4, 0, LOG);
        Block(0, 5, 0, LOG);
        Block(0, 6, 0, LOG);
        Block(0, 7, 0, LOG);
        Block(0, 8, 0, LOG);
        Block(0, 9, 0, LOG);
        Block(-3, 10, 0, LEAVES);
        Block(0, 10, 0, LOG);
        Block(3, 10, 0, LEAVES);
        Block(-2, 11, 0, LEAVES);
        Block(0, 11, 0, LOG);
        Block(2, 11, 0, LEAVES);
        Block(-1, 12, 0, LEAVES);
        Block(0, 12, 0, LEAVES);
        Block(1, 12, 0, LEAVES);
        Block(-3, 5, 1, LEAVES);
        Block(-3, 6, 1, LEAVES);
        Block(-3, 7, 1, LEAVES);
        Block(-3, 8, 1, LEAVES);
        Block(3, 8, 1, LEAVES);
        Block(-3, 9, 1, LEAVES);
        Block(3, 9, 1, LEAVES);
        Block(-3, 10, 1, LEAVES);
        Block(3, 10, 1, LEAVES);
        Block(-2, 11, 1, LEAVES);
        Block(2, 11, 1, LEAVES);
        Block(-1, 12, 1, LEAVES);
        Block(0, 12, 1, LEAVES);
        Block(1, 12, 1, LEAVES);
        Block(-3, 10, 2, LEAVES);
        Block(3, 10, 2, LEAVES);
        Block(-2, 11, 2, LEAVES);
        Block(-1, 11, 2, LEAVES);
        Block(0, 11, 2, LEAVES);
        Block(1, 11, 2, LEAVES);
        Block(2, 11, 2, LEAVES);
        Block(2, 6, 3, LEAVES);
        Block(-2, 7, 3, LEAVES);
        Block(2, 7, 3, LEAVES);
        Block(-2, 8, 3, LEAVES);
        Block(2, 8, 3, LEAVES);
        Block(-2, 9, 3, LEAVES);
        Block(0, 9, 3, LEAVES);
        Block(2, 9, 3, LEAVES);
        Block(-3, 10, 3, LEAVES);
        Block(-2, 10, 3, LEAVES);
        Block(-1, 10, 3, LEAVES);
        Block(0, 10, 3, LEAVES);
        Block(1, 10, 3, LEAVES);
        Block(2, 10, 3, LEAVES);
        Block(3, 10, 3, LEAVES);

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}