package com.matez.wildnature.world.generation.structures.utils;

import net.minecraft.block.BlockState;
import net.minecraft.command.arguments.BlockStateInput;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class BlockData {
    public final BlockPos blockPos;
    public final BlockStateInput blockState;
    public BlockData(BlockPos pos, BlockStateInput state){
        this.blockPos = pos;
        this.blockState = state;
    }

    public BlockStateInput getBlockStateInput() {
        return blockState;
    }

    public BlockState getBlockState() {
        return blockState.getState();
    }

    public BlockPos getBlockPos() {
        return blockPos;
    }
}
