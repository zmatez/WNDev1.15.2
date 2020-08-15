package com.matez.wildnature.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class FlatBushBase extends BushBase{
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D);

    public FlatBushBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    public FlatBushBase(Properties properties, Item.Properties builder, ResourceLocation regName, boolean newProperties) {
        super(properties, builder, regName, newProperties);
    }

    public FlatBushBase(Properties properties, @Nullable Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
        super(properties, builder, drop, min, max, exp, regName);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
