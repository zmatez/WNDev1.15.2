package com.matez.wildnature.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;

public class BlockBasicTable extends Block {

    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    public static final BooleanProperty LEFT_END = BooleanProperty.create("left_end");
    public static final BooleanProperty RIGHT_END = BooleanProperty.create("right_end");

    public BlockBasicTable(Properties properties)
    {
        super(properties);
        this.setDefaultState(
                this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(LEFT_END, true).with(RIGHT_END, true));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn)
    {
        Direction direction = state.get(FACING);
        switch(mirrorIn)
        {
            case LEFT_RIGHT:
                if(direction.getAxis() == Direction.Axis.Z)
                {

                }
                break;
            case FRONT_BACK:
                if(direction.getAxis() == Direction.Axis.X)
                {

                }
            default:
                break;
        }

        return super.mirror(state, mirrorIn);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, LEFT_END, RIGHT_END);
    }

}
