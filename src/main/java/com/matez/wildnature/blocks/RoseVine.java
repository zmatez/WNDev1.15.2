package com.matez.wildnature.blocks;

import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class RoseVine extends VineBase implements IGrowable {
    public static final BooleanProperty FLOWERING = BooleanProperty.create("flowering");
    public RoseVine(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(FLOWERING);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.randomTick(state,worldIn,pos,random);
        if(Utilities.chance(ConfigSettings.floweringChance) && state.getBlock() instanceof RoseVine){
            try {
                worldIn.setBlockState(pos, worldIn.getBlockState(pos).with(FLOWERING, true));
            }catch (Exception e){}
        }
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        if(Utilities.rint(0, CommonConfig.flowerBloomChance.get())==0){
            if(!state.get(FLOWERING)) {
                worldIn.setBlockState(pos, state.with(FLOWERING, true));
            }else{
                ItemStack stack = new ItemStack(this, 1);
                spawnAsEntity(worldIn,pos,stack);
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if(placer instanceof PlayerEntity && ((PlayerEntity)placer).isCreative()){
            worldIn.setBlockState(pos,state.with(FLOWERING,true));
        }
    }



}
