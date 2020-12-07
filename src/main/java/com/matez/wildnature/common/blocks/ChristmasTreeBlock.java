package com.matez.wildnature.common.blocks;

import com.matez.wildnature.client.render.IRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class ChristmasTreeBlock extends HorizontalBase implements IRenderLayer {
    public ChristmasTreeBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties.lightValue(10), builder, regName);
    }

    public ChristmasTreeBlock(Properties properties, Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
        super(properties.lightValue(10), builder, drop, min, max, exp, regName);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return Stream.of(
                Block.makeCuboidShape(1.75, 6, 1.75, 14.25, 7, 14.25),
                Block.makeCuboidShape(2.75, 10, 2.75, 13.25, 11, 13.25),
                Block.makeCuboidShape(3.75, 14, 3.75, 12.25, 15, 12.25),
                Block.makeCuboidShape(4.75, 18, 4.75, 11.25, 19, 11.25),
                Block.makeCuboidShape(7.5, 1, 7.5, 8.5, 25, 8.5),
                Block.makeCuboidShape(5.75, 0, 5.5, 10.25, 1, 10.5),
                Block.makeCuboidShape(1, 2, 1, 15, 6, 15),
                Block.makeCuboidShape(2, 7, 2, 14, 10, 14),
                Block.makeCuboidShape(3, 11, 3, 13, 14, 13),
                Block.makeCuboidShape(4, 15, 4, 12, 18, 12),
                Block.makeCuboidShape(5, 19, 5, 11, 22, 11),
                Block.makeCuboidShape(8, 22, 6, 8, 25, 10),
                Block.makeCuboidShape(6, 22, 8, 10, 25, 8)
        ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    }
}
