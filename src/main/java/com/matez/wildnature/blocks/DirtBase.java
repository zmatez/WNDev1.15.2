package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class DirtBase extends BlockBase implements IGrowable {
    public DirtBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    public DirtBase(Properties properties, Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
        super(properties, builder, drop, min, max, exp, regName);
    }

    @Override
    public boolean canGrow(IBlockReader iBlockReader, BlockPos blockPos, BlockState blockState, boolean b) {
        return iBlockReader.getBlockState(blockPos.up()).isAir();
    }

    @Override
    public boolean canUseBonemeal(World world, Random random, BlockPos blockPos, BlockState blockState) {
        return world.getBlockState(blockPos.up()).isAir();
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos blockPos, BlockState blockState) {
        if(Utilities.rint(0,6)==0){
            world.setBlockState(blockPos, Main.getBlockByID(this.getRegistryName().toString().replace("_dirt","_grass_block")).getDefaultState());
        }
    }

    @Override
    public boolean ticksRandomly(BlockState p_149653_1_) {
        return true;
    }
}
