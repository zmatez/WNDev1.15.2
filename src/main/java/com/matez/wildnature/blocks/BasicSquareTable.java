package com.matez.wildnature.blocks;

import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.ArrayList;
import java.util.List;

public class BasicSquareTable extends HorizontalBase implements IRenderLayer {

    public BasicSquareTable(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    public BasicSquareTable(Properties properties, Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
        super(properties, builder, drop, min, max, exp, regName);
    }


    public VoxelShape result(List<VoxelShape> shapes){
        VoxelShape result = VoxelShapes.empty();
        int x=0;
        while(x<shapes.size()){
            result = VoxelShapes.combine(result,shapes.get(x), IBooleanFunction.OR);
            x++;
        }
        return result.simplify();
    }


    @Override
    public RenderType getRenderLayer() {
        return RenderType.getCutout();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        switch((Direction)state.get(FACING)) {
            case NORTH:
            case SOUTH:
            default:
            {
                List<VoxelShape> shapes = new ArrayList<>();
                shapes.add(makeCuboidShape(0, 13, 0, 16, 16, 16));
                shapes.add(makeCuboidShape(1, 0, 2, 4, 1, 14));
                shapes.add(makeCuboidShape(12, 0, 2, 15, 1, 14));
                shapes.add(makeCuboidShape(1.5, 1, 3, 3.5, 3, 13));
                shapes.add(makeCuboidShape(12.5, 1, 3, 14.5, 3, 13));
                shapes.add(makeCuboidShape(1.5, 11, 2, 3.5, 13, 14));
                shapes.add(makeCuboidShape(12.5, 11, 2, 14.5, 13, 14));
                shapes.add(makeCuboidShape(1.5, 3, 5, 3.5, 11, 11));
                shapes.add(makeCuboidShape(12.5, 3, 5, 14.5, 11, 11));
                shapes.add(makeCuboidShape(3.5, 2, 7, 12.5, 5, 9));
                return result(shapes);
            }
            case EAST:
            case WEST:
            {
                List<VoxelShape> shapes = new ArrayList<>();
                shapes.add(makeCuboidShape(0, 13, 0, 16, 16, 16));
                shapes.add(makeCuboidShape(2, 0, 1, 14, 1, 4));
                shapes.add(makeCuboidShape(2, 0, 12, 14, 1, 15));
                shapes.add(makeCuboidShape(3, 1, 1.5, 13, 3, 3.5));
                shapes.add(makeCuboidShape(3, 1, 12.5, 13, 3, 14.5));
                shapes.add(makeCuboidShape(2, 11, 1.5, 14, 13, 3.5));
                shapes.add(makeCuboidShape(2, 11, 12.5, 14, 13, 14.5));
                shapes.add(makeCuboidShape(5, 3, 1.5, 11, 11, 3.5));
                shapes.add(makeCuboidShape(5, 3, 12.5, 11, 11, 14.5));
                shapes.add(makeCuboidShape(7, 2, 3.5, 9, 5, 12.5));
                return result(shapes);
            }

        }


    }

}
