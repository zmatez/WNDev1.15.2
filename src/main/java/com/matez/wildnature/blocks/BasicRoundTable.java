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

public class BasicRoundTable extends HorizontalBase implements IRenderLayer {


    public BasicRoundTable(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    public BasicRoundTable(Properties properties, Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
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

        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(7, 3, 7, 9, 14, 9));
        shapes.add(makeCuboidShape(2, 14, 2, 14, 16, 14));
        shapes.add(makeCuboidShape(6, 0, 6, 10, 3, 10));
        return result(shapes);

    }

}
