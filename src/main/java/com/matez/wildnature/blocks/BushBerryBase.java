package com.matez.wildnature.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BushBerryBase extends FruitableLeaves {
    public static IntegerProperty STAGE = IntegerProperty.create("stage", 0, 1);

    public BushBerryBase(Properties properties, Item.Properties builder, ResourceLocation regName, StageFruit... stageFruits) {
        super(properties, builder, regName,new ArrayList<>(Arrays.asList(stageFruits)));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        worldIn.setBlockState(pos,state.with(PERSISTENT,true));
        super.randomTick(state.with(PERSISTENT,true), worldIn, pos, random);
    }

    @Override
    public int getMaxStages(){
        return 1;
    }

    @Override
    public IntegerProperty getStage() {
        return STAGE;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        leafContainer(builder);
        builder.add(STAGE);
    }
}
