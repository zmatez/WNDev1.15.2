package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

import static net.minecraft.state.properties.DoubleBlockHalf.UPPER;

public class BelladonnaBlock extends DoubleBushBase{
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 3);

    public BelladonnaBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return state.get(STAGE) != 3;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
        super.fillStateContainer(builder);

    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && !silkTouch && state.get(HALF)== DoubleBlockHalf.LOWER && this == WNBlocks.BELLADONNA && state.get(STAGE)==3){
            list.add(new ItemStack(WNItems.BELLADONNA_FRUIT, Utilities.rint(1,3)));
        }

        return list;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(this == WNBlocks.BELLADONNA && state.get(STAGE)==3){
            int i = Utilities.rint(0,2);
            worldIn.setBlockState(pos, state.with(STAGE, i));
            worldIn.notifyBlockUpdate(pos,state.with(STAGE, i),worldIn.getBlockState(pos),2);

            spawnAsEntity(worldIn,pos,new ItemStack(WNItems.BELLADONNA_FRUIT, Utilities.rint(1,3)));
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if(Utilities.chance(ConfigSettings.floweringChance) && worldIn.getBlockState(pos).get(STAGE)<3){
            worldIn.setBlockState(pos, state.with(STAGE, worldIn.getBlockState(pos).get(STAGE)+1));
            worldIn.notifyBlockUpdate(pos,state,worldIn.getBlockState(pos),2);
        }
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged( state,  worldIn,  pos,  blockIn,  fromPos,  isMoving);
        if(fromPos.getZ() == pos.getZ() && fromPos.getX() == pos.getX() && (fromPos.getY() == pos.getY() || fromPos.getY() == pos.getY()-1 || fromPos.getY() == pos.getY()+1)) {
            if (worldIn.getBlockState(fromPos).getBlock() instanceof BelladonnaBlock) {
                if (worldIn.getBlockState(pos.down()).getBlock() instanceof BelladonnaBlock) {
                    worldIn.setBlockState(pos, state.with(STAGE, worldIn.getBlockState(fromPos).get(STAGE)));
                } else if (worldIn.getBlockState(pos.up()).getBlock() instanceof BelladonnaBlock) {
                    worldIn.setBlockState(pos, state.with(STAGE, worldIn.getBlockState(fromPos).get(STAGE)));
                }
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn,pos,state,placer,stack);
        if(placer instanceof PlayerEntity && ((PlayerEntity)placer).isCreative()){
            worldIn.setBlockState(pos,state.with(STAGE,3),2);
            worldIn.notifyBlockUpdate(pos,state.with(STAGE, 3),worldIn.getBlockState(pos),2);

        }
    }

    public boolean canGrow(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_, boolean p_176473_4_) {
        return true;
    }

    public boolean canUseBonemeal(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_, BlockState p_180670_4_) {
        return true;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        if(Utilities.rint(0, CommonConfig.flowerBloomChance.get())==0){
            if(state.get(STAGE)!=3) {
                worldIn.setBlockState(pos, state.with(STAGE, worldIn.getBlockState(pos).get(STAGE)+1));
                worldIn.notifyBlockUpdate(pos,state.with(STAGE, worldIn.getBlockState(pos).get(STAGE)+1),worldIn.getBlockState(pos),2);
            }else{
                ItemStack stack = new ItemStack(this, 1);
                spawnAsEntity(worldIn,pos,stack);
            }
        }
    }
}
