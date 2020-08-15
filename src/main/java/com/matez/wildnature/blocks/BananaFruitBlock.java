package com.matez.wildnature.blocks;

import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BananaFruitBlock extends Block {
    public static IntegerProperty STAGE = IntegerProperty.create("stage", 0, 2);

    protected static final VoxelShape WEST_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_AABB = Block.makeCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
    protected static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);


    public BananaFruitBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean ticksRandomly(BlockState p_149653_1_) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldReader, BlockPos pos, ISelectionContext selection) {
        Direction d = state.get(BlockStateProperties.HORIZONTAL_FACING);
        if(d == Direction.NORTH){
            return NORTH_AABB;
        }else if(d == Direction.SOUTH){
            return SOUTH_AABB;
        }else if(d == Direction.EAST){
            return EAST_AABB;
        }else if(d == Direction.WEST){
            return WEST_AABB;
        }
        return NORTH_AABB;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING,STAGE);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldReader, BlockPos pos) {
        Direction d = state.get(BlockStateProperties.HORIZONTAL_FACING);
        if(d == Direction.NORTH){
            return worldReader.getBlockState(pos.offset(Direction.SOUTH)).isSolid() && worldReader.getBlockState(pos.offset(Direction.SOUTH)).isIn(BlockTags.LOGS);
        }else if(d == Direction.SOUTH){
            return worldReader.getBlockState(pos.offset(Direction.NORTH)).isSolid() && worldReader.getBlockState(pos.offset(Direction.NORTH)).isIn(BlockTags.LOGS);
        }else if(d == Direction.EAST){
            return worldReader.getBlockState(pos.offset(Direction.WEST)).isSolid() && worldReader.getBlockState(pos.offset(Direction.WEST)).isIn(BlockTags.LOGS);
        }else if(d == Direction.WEST){
            return worldReader.getBlockState(pos.offset(Direction.EAST)).isSolid() && worldReader.getBlockState(pos.offset(Direction.EAST)).isIn(BlockTags.LOGS);
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
    public BlockRenderType getRenderType(BlockState p_149645_1_) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random);

        if(Utilities.rint(0, CommonConfig.leafFruitChance.get())==0 && worldIn.getBlockState(pos).get(STAGE)<2){
            worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(STAGE,worldIn.getBlockState(pos).get(STAGE)+1),2);
        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> list = super.getDrops(state, builder);
        if (state.get(STAGE)==2) {
            list.add(new ItemStack(WNItems.BANANA, Utilities.rint(1,3)));
        }

        return list;
    }
}
