package com.matez.wildnature.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

public class JacarandaLeavesBlock extends FruitableLeaves {
    public static IntegerProperty STAGE = IntegerProperty.create("stage", 0, 1);

    public JacarandaLeavesBlock(Properties properties, Item.Properties builder, ResourceLocation regName, ArrayList<StageFruit> stageFruits) {
        super(properties, builder, regName, stageFruits,true);
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
