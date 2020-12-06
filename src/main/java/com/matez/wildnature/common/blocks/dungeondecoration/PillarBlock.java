package com.matez.wildnature.common.blocks.dungeondecoration;

import com.matez.wildnature.common.blocks.VerticalConnectingBlock;
import com.matez.wildnature.common.blocks.properties.VerticalConnected;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class PillarBlock extends VerticalConnectingBlock {

    //Defining Default BlockState
    public PillarBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(PART, VerticalConnected.SINGLE).with(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return hasEnoughSolidSide(worldIn, pos.down(), Direction.UP);
    }

    public boolean isConnectingBlock(BlockState state) {
        return state.getBlock() == this;
    }

    //Defining shapes for every state
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        return Block.makeCuboidShape(2, 0, 2, 12, 16, 12);

    }

}