package com.matez.wildnature.common.blocks.dungeondecoration;

import com.matez.wildnature.common.blocks.VerticalConnectingFacingBlock;
import com.matez.wildnature.common.blocks.properties.VerticalConnected;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public  class ArrowSlitBlock extends VerticalConnectingFacingBlock {

    //Defining Default BlockState
    public ArrowSlitBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(PART, VerticalConnected.SINGLE).with(WATERLOGGED, Boolean.FALSE));
    }

    public boolean isConnectingBlock(BlockState state) {
        return state.getBlock() == this;
    }

    //Defining shapes for every state
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        switch ((Direction) state.get(FACING)) {
            default:
            case NORTH: {
                return Stream.of(
                        Block.makeCuboidShape(0, 0, 14, 6, 16, 16),
                        Block.makeCuboidShape(0, 0, 12, 5.1000000000000005, 16, 14),
                        Block.makeCuboidShape(0, 0, 10, 4.300000000000001, 16, 12),
                        Block.makeCuboidShape(0, 0, 8, 3.5, 16, 10),
                        Block.makeCuboidShape(0, 0, 6.7, 3, 16, 8),
                        Block.makeCuboidShape(12.5, 0, 8, 16, 16, 10),
                        Block.makeCuboidShape(11.7, 0, 10, 16, 16, 12),
                        Block.makeCuboidShape(10.899999999999999, 0, 12, 16, 16, 14),
                        Block.makeCuboidShape(10, 0, 14, 16, 16, 16),
                        Block.makeCuboidShape(13, 0, 6.7, 16, 16, 8)
                ).reduce((v1, v2) -> {
                    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
                }).get();
            }
            case SOUTH: {
                return Stream.of(
                        Block.makeCuboidShape(10, 0, 0, 16, 16, 2),
                        Block.makeCuboidShape(10.899999999999999, 0, 2, 16, 16, 4),
                        Block.makeCuboidShape(11.7, 0, 4, 16, 16, 6),
                        Block.makeCuboidShape(12.5, 0, 6, 16, 16, 8),
                        Block.makeCuboidShape(13, 0, 8, 16, 16, 9.3),
                        Block.makeCuboidShape(0, 0, 6, 3.5, 16, 8),
                        Block.makeCuboidShape(0, 0, 4, 4.300000000000001, 16, 6),
                        Block.makeCuboidShape(0, 0, 2, 5.100000000000001, 16, 4),
                        Block.makeCuboidShape(0, 0, 0, 6, 16, 2),
                        Block.makeCuboidShape(0, 0, 8, 3, 16, 9.3)
                ).reduce((v1, v2) -> {
                    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
                }).get();
            }
            case WEST: {
                return Stream.of(
                        Block.makeCuboidShape(14, 0, 10, 16, 16, 16),
                        Block.makeCuboidShape(12, 0, 10.899999999999999, 14, 16, 16),
                        Block.makeCuboidShape(10, 0, 11.7, 12, 16, 16),
                        Block.makeCuboidShape(8, 0, 12.5, 10, 16, 16),
                        Block.makeCuboidShape(6.699999999999999, 0, 13, 8, 16, 16),
                        Block.makeCuboidShape(8, 0, 0, 10, 16, 3.5),
                        Block.makeCuboidShape(10, 0, 0, 12, 16, 4.300000000000001),
                        Block.makeCuboidShape(12, 0, 0, 14, 16, 5.100000000000001),
                        Block.makeCuboidShape(14, 0, 0, 16, 16, 6),
                        Block.makeCuboidShape(6.699999999999999, 0, 0, 8, 16, 3)
                ).reduce((v1, v2) -> {
                    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
                }).get();
            }
            case EAST: {
                return Stream.of(
                        Block.makeCuboidShape(0, 0, 0, 2, 16, 6),
                        Block.makeCuboidShape(2, 0, 0, 4, 16, 5.1000000000000005),
                        Block.makeCuboidShape(4, 0, 0, 6, 16, 4.300000000000001),
                        Block.makeCuboidShape(6, 0, 0, 8, 16, 3.5),
                        Block.makeCuboidShape(8, 0, 0, 9.3, 16, 3),
                        Block.makeCuboidShape(6, 0, 12.5, 8, 16, 16),
                        Block.makeCuboidShape(4, 0, 11.7, 6, 16, 16),
                        Block.makeCuboidShape(2, 0, 10.899999999999999, 4, 16, 16),
                        Block.makeCuboidShape(0, 0, 10, 2, 16, 16),
                        Block.makeCuboidShape(8, 0, 13, 9.3, 16, 16)
                ).reduce((v1, v2) -> {
                    return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
                }).get();
            }
        }
    }


}