package com.matez.wildnature.world.generation.structures.nature.woods.jelly;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.structures.nature.fallen.FallenSchemFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraftforge.common.IPlantable;

import java.util.Set;

public class jelly9 extends SchemFeature {
    @Override
    public boolean canGrowTree(IWorldGenerationReader world, BlockPos pos, IPlantable sapling) {
        return pos.getY() < 50 && world.hasBlockState(pos, state -> {
            return state.getBlock() == Blocks.SAND || state.getBlock() == WNBlocks.WHITE_SAND || state.getBlock() == WNBlocks.ALGAE_BLOCK || state.getBlock() == Blocks.GRAVEL;
        });
    }
    @Override
    public Set<BlockPos> setBlocks() {

        Block(0, 3, -3, LEAVES);
        Block(0, 4, -3, LEAVES);
        Block(-1, 5, -3, LEAVES);
        Block(0, 5, -3, LEAVES);
        Block(-1, 6, -3, LEAVES);
        Block(0, 6, -3, LEAVES);
        Block(1, 6, -3, LEAVES);
        Block(0, 7, -3, LEAVES);
        Block(2, 4, -2, LEAVES);
        Block(2, 5, -2, LEAVES);
        Block(-2, 6, -2, LEAVES);
        Block(-1, 6, -2, LEAVES);
        Block(1, 6, -2, LEAVES);
        Block(2, 6, -2, LEAVES);
        Block(-1, 7, -2, LEAVES);
        Block(0, 7, -2, LEAVES);
        Block(1, 7, -2, LEAVES);
        Block(-3, 4, -1, LEAVES);
        Block(-3, 5, -1, LEAVES);
        Block(3, 5, -1, LEAVES);
        Block(-3, 6, -1, LEAVES);
        Block(-2, 6, -1, LEAVES);
        Block(2, 6, -1, LEAVES);
        Block(3, 6, -1, LEAVES);
        Block(-2, 7, -1, LEAVES);
        Block(-1, 7, -1, LEAVES);
        Block(0, 7, -1, LEAVES);
        Block(1, 7, -1, LEAVES);
        Block(2, 7, -1, LEAVES);
        Block(-1, 8, -1, LEAVES);
        Block(0, 8, -1, LEAVES);
        Block(1, 8, -1, LEAVES);
        Block(7, 0, 0, "minecraft:oak_sign[rotation=12,waterlogged=false]");
        Block(0, 1, 0, LOG);
        Block(0, 2, 0, LOG);
        Block(0, 3, 0, LOG);
        Block(3, 3, 0, LEAVES);
        Block(0, 4, 0, LOG);
        Block(3, 4, 0, LEAVES);
        Block(0, 5, 0, LOG);
        Block(3, 5, 0, LEAVES);
        Block(-3, 6, 0, LEAVES);
        Block(0, 6, 0, LOG);
        Block(3, 6, 0, LEAVES);
        Block(-3, 7, 0, LEAVES);
        Block(-2, 7, 0, LEAVES);
        Block(-1, 7, 0, LEAVES);
        Block(0, 7, 0, LEAVES);
        Block(1, 7, 0, LEAVES);
        Block(2, 7, 0, LEAVES);
        Block(3, 7, 0, LEAVES);
        Block(-1, 8, 0, LEAVES);
        Block(0, 8, 0, LEAVES);
        Block(1, 8, 0, LEAVES);
        Block(-3, 5, 1, LEAVES);
        Block(-3, 6, 1, LEAVES);
        Block(-2, 6, 1, LEAVES);
        Block(2, 6, 1, LEAVES);
        Block(3, 6, 1, LEAVES);
        Block(-2, 7, 1, LEAVES);
        Block(-1, 7, 1, LEAVES);
        Block(0, 7, 1, LEAVES);
        Block(1, 7, 1, LEAVES);
        Block(2, 7, 1, LEAVES);
        Block(-1, 8, 1, LEAVES);
        Block(0, 8, 1, LEAVES);
        Block(1, 8, 1, LEAVES);
        Block(2, 4, 2, LEAVES);
        Block(2, 5, 2, LEAVES);
        Block(-2, 6, 2, LEAVES);
        Block(-1, 6, 2, LEAVES);
        Block(1, 6, 2, LEAVES);
        Block(2, 6, 2, LEAVES);
        Block(-1, 7, 2, LEAVES);
        Block(0, 7, 2, LEAVES);
        Block(1, 7, 2, LEAVES);
        Block(-1, 4, 3, LEAVES);
        Block(-1, 5, 3, LEAVES);
        Block(1, 5, 3, LEAVES);
        Block(-1, 6, 3, LEAVES);
        Block(0, 6, 3, LEAVES);
        Block(1, 6, 3, LEAVES);
        Block(0, 7, 3, LEAVES);

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
        return super.setBlocks();
    }
}