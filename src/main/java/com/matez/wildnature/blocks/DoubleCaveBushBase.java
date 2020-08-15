package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.BlockTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class DoubleCaveBushBase extends DoubleBushBase {
    private boolean reversed = false;
    public DoubleCaveBushBase(Properties properties, Item.Properties builder, ResourceLocation regName,boolean reversed) {
        super(properties, builder, regName);
        this.reversed=reversed;
    }

    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        DoubleBlockHalf doubleblockhalf = state.get(HALF);
        BlockPos blockpos = doubleblockhalf == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        if (blockstate.getBlock() == this && blockstate.get(HALF) != doubleblockhalf) {
            worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
            worldIn.playEvent(player, 2001, blockpos, Block.getStateId(blockstate));
            if (!worldIn.isRemote && !player.isCreative()) {
                spawnDrops(state, worldIn, pos, (TileEntity)null, player, player.getHeldItemMainhand());
                spawnDrops(blockstate, worldIn, blockpos, (TileEntity)null, player, player.getHeldItemMainhand());
            }
        }

        super.onBlockHarvested(worldIn, pos, state, player);
    }

    public boolean isValidPosition2(BlockState state, IWorldReader worldIn, BlockPos pos) {
        if(reversed){
            BlockPos blockpos = pos.up();
            return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
        }
        BlockPos blockpos = pos.down();
        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        if (state.get(HALF) != DoubleBlockHalf.UPPER) {
            return isValidPosition2(state, worldIn, pos);
        } else {
            BlockState blockstate = worldIn.getBlockState(pos.down());
            if(reversed){
                blockstate = worldIn.getBlockState(pos.up());
            }
            return blockstate.getBlock() == this && blockstate.get(HALF) == DoubleBlockHalf.LOWER;
        }
    }



    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return (BlockTags.getCollection().getOrCreate(new ResourceLocation("forge","stone")).contains(block) || block == Blocks.GRAVEL || block == Blocks.PACKED_ICE || block == this)&& ((IWorldReader)worldIn).getLightSubtracted(pos, 0) <= 10;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if(!reversed) {
            worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), 3);
        }else{
            worldIn.setBlockState(pos.down(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), 3);

        }

        //System.out.println("biome: " + BiomeColors.getGrassColor(worldIn, pos) + " foliage: " + GrassColors.get(0.5,0.5));


    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        if(reversed){
            return blockpos.getY() < context.getWorld().getDimension().getHeight() - 1 && context.getWorld().getBlockState(blockpos.down()).isReplaceable(context) ? this.getDefaultState() : null;
        }
        return blockpos.getY() < context.getWorld().getDimension().getHeight() - 1 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context) ? this.getDefaultState() : null;
    }


    public void placeAt(IWorld worldIn, BlockPos pos, int flags) {
        if(reversed){
            worldIn.setBlockState(pos, this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER), flags);
            worldIn.setBlockState(pos.down(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), flags);
        }else {
            worldIn.setBlockState(pos, this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER), flags);
            worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), flags);
        }
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        DoubleBlockHalf doubleblockhalf = stateIn.get(HALF);
        if(reversed){
            if (facing.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (facing == Direction.DOWN) || facingState.getBlock() == this && facingState.get(HALF) != doubleblockhalf) {
                return doubleblockhalf == DoubleBlockHalf.LOWER && facing == Direction.UP && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : revupdatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
            } else {
                return Blocks.AIR.getDefaultState();
            }
        }
        if (facing.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (facing == Direction.UP) || facingState.getBlock() == this && facingState.get(HALF) != doubleblockhalf) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        } else {
            return Blocks.AIR.getDefaultState();
        }
    }

    public BlockState revupdatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> l = new ArrayList<>();
        if(state.getBlock()== WNBlocks.ROOTS || state.getBlock()== WNBlocks.LARGE_ROOT){
            l.add(new ItemStack(Items.STICK, Utilities.rint(1,3)));
            return l;
        }
        if(state.getBlock()== WNBlocks.GLOW_SHROOM || state.getBlock()== WNBlocks.LARGE_GLOWSHROOM){
            l.add(new ItemStack(WNItems.GLOWSHROOM_DUST,Utilities.rint(0,2)));
            return l;
        }
        if(state.getBlock()== WNBlocks.ICE_SHROOM){
            l.add(new ItemStack(WNItems.ICESHROOM_DUST,Utilities.rint(0,1)));
            return l;
        }
        if(state.getBlock()== WNBlocks.STONE_GRASS || state.getBlock()== WNBlocks.ICE_GRASS|| state.getBlock()== WNBlocks.STALACTITE|| state.getBlock()== WNBlocks.STALAGMITE|| state.getBlock()== WNBlocks.LARGE_STALAGMITE|| state.getBlock()== WNBlocks.LARGE_STALACTITE|| state.getBlock()== WNBlocks.ICYCLE|| state.getBlock()== WNBlocks.LARGE_ICYCLE){
            if(Utilities.rint(0,7)==0){
                l.add(new ItemStack(Item.getItemFromBlock(state.getBlock()),1));
            }

            return l;
        }


        return super.getDrops(state, builder);
    }


}
