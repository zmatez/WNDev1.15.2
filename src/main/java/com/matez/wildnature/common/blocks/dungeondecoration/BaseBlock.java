package com.matez.wildnature.common.blocks.dungeondecoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;

public class BaseBlock extends Block {

    //Defining Blockstates
    public static final IntegerProperty LAYERS = BlockStateProperties.LAYERS_1_8;
    public static DirectionProperty FACING = DirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    //Defining Default BlockState
    public BaseBlock(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.UP).with(LAYERS, 1).with(WATERLOGGED, false));
    }

    //Defining shapes for every state
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        switch((Direction)state.get(FACING))
        {
            case NORTH: {
                switch (state.get(LAYERS)) {
                    case 1: {
                        return Block.makeCuboidShape(0, 0, 14, 16, 16, 16);
                    }
                    case 2: {
                        return Block.makeCuboidShape(0, 0, 12, 16, 16, 16);
                    }
                    case 3: {
                        return Block.makeCuboidShape(0, 0, 10, 16, 16, 16);
                    }
                    case 4: {
                        return Block.makeCuboidShape(0, 0, 8, 16, 16, 16);
                    }
                    case 5: {
                        return Block.makeCuboidShape(0, 0, 6, 16, 16, 16);
                    }
                    case 6: {
                        return Block.makeCuboidShape(0, 0, 4, 16, 16, 16);
                    }
                    case 7: {
                        return Block.makeCuboidShape(0, 0, 2, 16, 16, 16);
                    }
                    case 8:
                    default:
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                }
            }
            case SOUTH: {
                switch (state.get(LAYERS)) {
                    case 1: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 2);
                    }
                    case 2: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 4);
                    }
                    case 3: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 6);
                    }
                    case 4: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 8);
                    }
                    case 5: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 10);
                    }
                    case 6: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 12);
                    }
                    case 7: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 14);
                    }
                    case 8:
                    default:
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                }
            }
            case WEST: {
                switch (state.get(LAYERS)) {
                    case 1: {
                        return Block.makeCuboidShape(14, 0, 0, 16, 16, 16);
                    }
                    case 2: {
                        return Block.makeCuboidShape(12, 0, 0, 16, 16, 16);
                    }
                    case 3: {
                        return Block.makeCuboidShape(10, 0, 0, 16, 16, 16);
                    }
                    case 4: {
                        return Block.makeCuboidShape(8, 0, 0, 16, 16, 16);
                    }
                    case 5: {
                        return Block.makeCuboidShape(6, 0, 0, 16, 16, 16);
                    }
                    case 6: {
                        return Block.makeCuboidShape(4, 0, 0, 16, 16, 16);
                    }
                    case 7: {
                        return Block.makeCuboidShape(2, 0, 0, 16, 16, 16);
                    }
                    case 8:
                    default:
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                }
            }
            case EAST: {
                switch (state.get(LAYERS)) {
                    case 1: {
                        return Block.makeCuboidShape(0, 0, 0, 2, 16, 16);
                    }
                    case 2: {
                        return Block.makeCuboidShape(0, 0, 0, 4, 16, 16);
                    }
                    case 3: {
                        return Block.makeCuboidShape(0, 0, 0, 6, 16, 16);
                    }
                    case 4: {
                        return Block.makeCuboidShape(0, 0, 0, 8, 16, 16);
                    }
                    case 5: {
                        return Block.makeCuboidShape(0, 0, 0, 10, 16, 16);
                    }
                    case 6: {
                        return Block.makeCuboidShape(0, 0, 0, 12, 16, 16);
                    }
                    case 7: {
                        return Block.makeCuboidShape(0, 0, 0, 14, 16, 16);
                    }
                    case 8:
                    default:
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                }
            }
            case UP: {
                switch (state.get(LAYERS)) {
                    case 1: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 2, 16);
                    }
                    case 2: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 4, 16);
                    }
                    case 3: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 6, 16);
                    }
                    case 4: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 8, 16);
                    }
                    case 5: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 10, 16);
                    }
                    case 6: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 12, 16);
                    }
                    case 7: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 14, 16);
                    }
                    case 8:
                    default:
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                }
            }
            case DOWN: {
                switch (state.get(LAYERS)) {
                    case 1: {
                        return Block.makeCuboidShape(0, 14, 0, 16, 16, 16);
                    }
                    case 2: {
                        return Block.makeCuboidShape(0, 12, 0, 16, 16, 16);
                    }
                    case 3: {
                        return Block.makeCuboidShape(0, 10, 0, 16, 16, 16);
                    }
                    case 4: {
                        return Block.makeCuboidShape(0, 8, 0, 16, 16, 16);
                    }
                    case 5: {
                        return Block.makeCuboidShape(0, 6, 0, 16, 16, 16);
                    }
                    case 6: {
                        return Block.makeCuboidShape(0, 4, 0, 16, 16, 16);
                    }
                    case 7: {
                        return Block.makeCuboidShape(0, 2, 0, 16, 16, 16);
                    }
                    case 8:
                    default:
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                }
            }
            default:
                return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
        }
    }

    //Creating the option to add layers by clicking on it's current facing face.
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        int i = state.get(LAYERS);
        if (useContext.getItem().getItem() == this.asItem() && i < 8) {
            if (useContext.replacingClickedOnBlock()) {
                return useContext.getFace() == state.get(FACING);
            } else {
                return true;
            }
        } else {
            return i == 1;
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getPos());
        if (blockstate.getBlock() == this) {
            int i = blockstate.get(LAYERS);
            return blockstate.with(LAYERS, Math.min(8, i + 1));
        } else{
            BlockPos blockpos = context.getPos();
            IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
            return super.getDefaultState()
                    .with(FACING, context.getNearestLookingDirection().getOpposite())
                    .with(LAYERS, 1)
                    .with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
        }
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if ((Boolean)stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public IFluidState getFluidState(BlockState state)
    {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, LAYERS, WATERLOGGED);
    }

}
