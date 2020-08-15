package com.matez.wildnature.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class PebbleBase extends BlockBase {

    protected static final VoxelShape SHAPE = makeCuboidShape(2.0D, 0.0D, 0.0D, 14.0D, 2.0D, 14.0D);

    public PebbleBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockState state, Direction facing, BlockState state2, IWorld world, BlockPos pos1, BlockPos pos2, Hand hand) {
        if(world.getBlockState(pos1.down()).isSolid()){
            return state;
        }else{
            return Blocks.AIR.getDefaultState();
        }
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).isSolid();
    }

    @Override
    public BlockState updatePostPlacement(BlockState state, Direction p_196271_2_, BlockState state2, IWorld worldIn, BlockPos pos, BlockPos p_196271_6_) {
        return worldIn.getBlockState(pos.down()).isSolid() ? state : Blocks.AIR.getDefaultState();
    }
}
