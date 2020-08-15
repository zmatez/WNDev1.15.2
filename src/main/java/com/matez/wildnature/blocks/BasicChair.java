package com.matez.wildnature.blocks;

import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BasicChair extends HorizontalBase implements IRenderLayer {
    public BasicChair(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    public BasicChair(Properties properties, Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
        super(properties, builder, drop, min, max, exp, regName);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return (BlockState)this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
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
            default:
            {
                List<VoxelShape> shapes = new ArrayList<>();
                shapes.add(makeCuboidShape(13, 0, 12, 14, 22, 14));
                shapes.add(makeCuboidShape(13, 0, 2, 14, 9, 4));
                shapes.add(makeCuboidShape(13, 7, 4, 14, 9, 12));
                shapes.add(makeCuboidShape(2, 7, 4, 3, 9, 12));
                shapes.add(makeCuboidShape(2, 0, 12, 3, 22, 14));
                shapes.add(makeCuboidShape(2, 0, 2, 3, 9, 4));
                shapes.add(makeCuboidShape(3, 7, 2, 13, 9, 3));
                shapes.add(makeCuboidShape(3, 7, 13, 13, 9, 14));
                shapes.add(makeCuboidShape(3, 7, 3, 13, 8.5, 13));
                shapes.add(makeCuboidShape(3, 12.5, 12.5, 13, 20.5, 13.5));
                return result(shapes);
            }
            case EAST:
            {
                List<VoxelShape> shapes = new ArrayList<>();
                shapes.add(makeCuboidShape(2, 0, 13, 4, 22, 14)); 
                shapes.add(makeCuboidShape(12, 0, 13, 14, 9, 14));
                shapes.add(makeCuboidShape(4, 7, 13, 12, 9, 14));
                shapes.add(makeCuboidShape(4, 7, 2, 12, 9, 3));
                shapes.add(makeCuboidShape(2, 0, 2, 4, 22, 3));
                shapes.add(makeCuboidShape(12, 0, 2, 14, 9, 3));
                shapes.add(makeCuboidShape(13, 7, 3, 14, 9, 13));
                shapes.add(makeCuboidShape(2, 7, 3, 3, 9, 13));
                shapes.add(makeCuboidShape(3, 7, 3, 13, 8.5, 13));
                shapes.add(makeCuboidShape(2.5, 12.5, 3, 3.5, 20.5, 13));
                return result(shapes);
            }
            case WEST:
            {
                List<VoxelShape> shapes = new ArrayList<>();
                shapes.add(makeCuboidShape(12, 0, 2, 14, 22, 3));
                shapes.add(makeCuboidShape(2, 0, 2, 4, 9, 3));
                shapes.add(makeCuboidShape(4, 7, 2, 12, 9, 3));
                shapes.add(makeCuboidShape(4, 7, 13, 12, 9, 14));
                shapes.add(makeCuboidShape(12, 0, 13, 14, 22, 14));
                shapes.add(makeCuboidShape(2, 0, 13, 4, 9, 14));
                shapes.add(makeCuboidShape(2, 7, 3, 3, 9, 13));
                shapes.add(makeCuboidShape(13, 7, 3, 14, 9, 13));
                shapes.add(makeCuboidShape(3, 7, 3, 13, 8.5, 13));
                shapes.add(makeCuboidShape(12.5, 12.5, 3, 13.5, 20.5, 13));
                return result(shapes);
            }
            case SOUTH:
            {
                List<VoxelShape> shapes = new ArrayList<>();
                shapes.add(makeCuboidShape(2, 0, 2, 3, 22, 4));
                shapes.add(makeCuboidShape(2, 0, 12, 3, 9, 14));
                shapes.add(makeCuboidShape(2, 7, 4, 3, 9, 12));
                shapes.add(makeCuboidShape(13, 7, 4, 14, 9, 12));
                shapes.add(makeCuboidShape(13, 0, 2, 14, 22, 4));
                shapes.add(makeCuboidShape(13, 0, 12, 14, 9, 14));
                shapes.add(makeCuboidShape(3, 7, 13, 13, 9, 14));
                shapes.add(makeCuboidShape(3, 7, 2, 13, 9, 3));
                shapes.add(makeCuboidShape(3, 7, 3, 13, 8.5, 13));
                shapes.add(makeCuboidShape(3, 12.5, 2.5, 13, 20.5, 3.5));
                return result(shapes);
            }
        }

    }



}