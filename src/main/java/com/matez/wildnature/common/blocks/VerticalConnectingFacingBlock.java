package com.matez.wildnature.common.blocks;

import com.matez.wildnature.common.blocks.properties.ModStateProperties;
import com.matez.wildnature.common.blocks.properties.VerticalConnected;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public abstract class VerticalConnectingFacingBlock extends Block implements IWaterLoggable{
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final EnumProperty<VerticalConnected> PART = ModStateProperties.VERTICAL_CONNECTED;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public VerticalConnectingFacingBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(PART, VerticalConnected.MIDDLE));
    }

    public boolean isConnectingBlock(BlockState state) {
        return state.getBlock() == this;
    }

    public boolean isValidFacing(BlockState currentState, BlockState validState) {

        if(isConnectingBlock(currentState)) {
            if (isConnectingBlock(validState) && currentState.get(FACING) == validState.get(FACING)) {
                return true;
            }
        }
        return false;
    }

    public VerticalConnected getPartProperty(IBlockReader worldIn, BlockPos blockpos) {

        BlockState state = worldIn.getBlockState(blockpos);
        BlockState stateUp = worldIn.getBlockState(blockpos.up());
        BlockState stateDown = worldIn.getBlockState(blockpos.down());

        boolean top = isConnectingBlock(stateDown) && isValidFacing(state, stateDown);
        boolean bot = isConnectingBlock(stateUp) && isValidFacing(state, stateUp);

        if(isValidFacing(state, state)) {
            if (top && bot) {
                    return VerticalConnected.MIDDLE;
            } else if (top) {
                return VerticalConnected.TOP;
            } else if (bot) {
                return VerticalConnected.BOTTOM;
            }
        }

        return VerticalConnected.SINGLE;

    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockPos blockpos = context.getPos();
        IFluidState fluidstate = context.getWorld().getFluidState(blockpos);
        BlockState blockstate = this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(WATERLOGGED, Boolean.valueOf(fluidstate.getFluid() == Fluids.WATER));
        return blockstate.with(PART, getPartProperty(context.getWorld(), blockpos));
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if ((Boolean)stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }
        return facing.getAxis().isVertical() ? stateIn.with(PART, getPartProperty(worldIn, currentPos)) : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public IFluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, PART, WATERLOGGED);
    }

}
