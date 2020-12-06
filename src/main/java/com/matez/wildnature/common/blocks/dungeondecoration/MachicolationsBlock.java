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

public class MachicolationsBlock extends VerticalConnectingFacingBlock {

    public MachicolationsBlock(Block.Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(PART, VerticalConnected.SINGLE));
    }

    public boolean isConnectingBlock(BlockState state) {
        return state.getBlock() == this;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

       return Block.makeCuboidShape(1, 0, 1, 15, 16, 15);
    }

}
