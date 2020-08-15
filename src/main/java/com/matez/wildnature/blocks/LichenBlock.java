package com.matez.wildnature.blocks;

import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nullable;

public class LichenBlock extends BlockBase implements IRenderLayer {

    protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
    protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);


    public LichenBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldReader, BlockPos pos, ISelectionContext selection) {
        Direction d = state.get(BlockStateProperties.HORIZONTAL_FACING);
        if(d == Direction.NORTH){
            return SOUTH_AABB;
        }else if(d == Direction.SOUTH){
            return NORTH_AABB;
        }else if(d == Direction.EAST){
            return WEST_AABB;
        }else if(d == Direction.WEST){
            return EAST_AABB;
        }
        return NORTH_AABB;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldReader, BlockPos pos) {
        Direction d = state.get(BlockStateProperties.HORIZONTAL_FACING);
        if(d == Direction.NORTH){
            return worldReader.getBlockState(pos.offset(Direction.SOUTH)).isSolid();
        }else if(d == Direction.SOUTH){
            return worldReader.getBlockState(pos.offset(Direction.NORTH)).isSolid();
        }else if(d == Direction.EAST){
            return worldReader.getBlockState(pos.offset(Direction.WEST)).isSolid();
        }else if(d == Direction.WEST){
            return worldReader.getBlockState(pos.offset(Direction.EAST)).isSolid();
        }
        return false;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getPos());

        for (Direction direction : context.getNearestLookingDirections()) {
            if(direction!=Direction.DOWN && direction!=Direction.UP) {
                if (isValidPosition(this.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, direction), context.getWorld(), context.getPos())) {
                    return this.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, direction);
                }
            }
        }
        return null;
    }

    @Override
    public boolean isTransparent(BlockState p_220074_1_) {
        return true;
    }
}
