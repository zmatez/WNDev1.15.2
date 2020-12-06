package com.matez.wildnature.common.blocks.dungeondecoration;

import com.matez.wildnature.common.blocks.VerticalConnectingFacingBlock;
import com.matez.wildnature.common.blocks.properties.VerticalConnected;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class PillarFacingBlock extends VerticalConnectingFacingBlock {

    //Defining Default BlockState
    public PillarFacingBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(PART, VerticalConnected.SINGLE).with(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockPos blockpos = pos.offset(direction.getOpposite());
        BlockState blockstate = worldIn.getBlockState(blockpos);
        return blockstate.isSolidSide(worldIn, blockpos, direction);
    }

    public boolean isConnectingBlock(BlockState state) {
        return state.getBlock() == this;
    }

    //Defining shapes for every state
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        return Block.makeCuboidShape(3, 0, 3, 10, 16, 10);

    }

}