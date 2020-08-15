package com.matez.wildnature.blocks;

import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.ArrayList;
import java.util.List;

public class BasicStool extends HorizontalBase implements IRenderLayer {


    public BasicStool(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
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

        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(12, 0, 3, 13, 8, 5));
        shapes.add(makeCuboidShape(3, 0, 3, 4, 8, 5));
        shapes.add(makeCuboidShape(12, 0, 11, 13, 8, 13));
        shapes.add(makeCuboidShape(3, 0, 11, 4, 8, 13));
        shapes.add(makeCuboidShape(12, 6, 5, 13, 8, 11));
        shapes.add(makeCuboidShape(3, 6, 5, 4, 8, 11));
        shapes.add(makeCuboidShape(4, 6, 3, 12, 8, 4));
        shapes.add(makeCuboidShape(4, 6, 12, 12, 8, 13));
        shapes.add(makeCuboidShape(4, 6, 4, 12, 7.5, 12));
        return result(shapes);

    }

}
