package com.matez.wildnature.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

public class CitrusLeavesBlock extends FruitableLeaves {
    public static IntegerProperty STAGE = IntegerProperty.create("stage", 0, 7);

    public CitrusLeavesBlock(Properties properties, Item.Properties builder, ResourceLocation regName, ArrayList<StageFruit> stageFruits) {
        super(properties, builder, regName, stageFruits,true);
    }

    @Override
    public int getMaxStages(){
        return 7;
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
