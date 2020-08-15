package com.matez.wildnature.blocks.boundingboxes;

import com.matez.wildnature.blocks.RotateableBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.IBlockReader;

import java.util.List;

public class IBoundingBox {

    /* Member variables */
    public VoxelShape SHAPE;
    public boolean isSided(){
        return false;
    }


    /* Methods */
    public VoxelShape generateShape()
    {
        System.out.println("The shape of block is null!");
        return null;
    }

    public VoxelShape getNorthShape(){
        System.out.println("The shape of block is null!");
        return null;
    }

    public VoxelShape getSouthShape(){
        System.out.println("The shape of block is null!");
        return null;
    }

    public VoxelShape getEastShape(){
        System.out.println("The shape of block is null!");
        return null;
    }

    public VoxelShape getWestShape(){
        System.out.println("The shape of block is null!");
        return null;
    }

    public VoxelShape getDownShape(){
        System.out.println("The shape of block is null!");
        return null;
    }

    public VoxelShape getUpShape(){
        System.out.println("The shape of block is null!");
        return null;
    }



    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context)
    {
        if(state.getBlock() instanceof RotateableBlock){
            return rotate(SHAPE,state.get(RotateableBlock.FACING));
        }
        return SHAPE;
    }

    public VoxelShape getCollisionShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context)
    {
        if(state.getBlock() instanceof RotateableBlock){
            return rotate(SHAPE,state.get(RotateableBlock.FACING));
        }
        return SHAPE;
    }

    public VoxelShape makeCuboidShape(double x1, double y1, double z1, double x2, double y2, double z2) {
        return VoxelShapes.create(x1, y1, z1, x2, y2, z2);
    }

    public VoxelShape result(List<VoxelShape> shapes){
        VoxelShape result = VoxelShapes.empty();
        int x=0;
        while(x<shapes.size()){
            result = VoxelShapes.combine(result,shapes.get(x),IBooleanFunction.OR);
            x++;
        }
        return result.simplify();
    }

    public VoxelShape rotate(VoxelShape shape, Direction direction){
        VoxelShape rotated = shape;
        if(direction==Direction.UP){

        }else if(direction==Direction.DOWN){

        }else{
            
        }
        return rotated;
    }

}
