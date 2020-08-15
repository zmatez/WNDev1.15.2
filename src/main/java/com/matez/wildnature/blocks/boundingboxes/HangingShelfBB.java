package com.matez.wildnature.blocks.boundingboxes;

import net.minecraft.util.math.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class HangingShelfBB extends IBoundingBox{

    @Override
    public boolean isSided(){
        return true;
    }

    @Override
    public VoxelShape getSouthShape() {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0.062, 0.062, 1, 0.125, 0.5)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0, 0, 0.25, 0.5, 0.062)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0, 0.062, 0.25, 0.062, 0.5)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0, 0.875, 0.5, 0.062)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.062, 0.875, 0.062, 0.5)); // CUBE
        return result(shapes);
    }

    @Override
    public VoxelShape getWestShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.5, 0.062, 0, 0.938, 0.125, 1)); // CUBE
        shapes.add(makeCuboidShape(0.938, 0, 0.125, 1, 0.5, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.5, 0, 0.125, 0.938, 0.062, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.938, 0, 0.75, 1, 0.5, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.5, 0, 0.75, 0.938, 0.062, 0.875)); // CUBE

        return result(shapes);

    }

    @Override
    public VoxelShape getNorthShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0.062, 0.5, 1, 0.125, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.938, 0.875, 0.5, 1)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.5, 0.875, 0.062, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0, 0.938, 0.25, 0.5, 1)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0, 0.5, 0.25, 0.062, 0.938)); // CUBE


        return result(shapes);

    }

    @Override
    public VoxelShape getEastShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.062, 0.062, 0, 0.5, 0.125, 1)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 0.75, 0.062, 0.5, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.062, 0, 0.75, 0.5, 0.062, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 0.125, 0.062, 0.5, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.062, 0, 0.125, 0.5, 0.062, 0.25)); // CUBE


        return result(shapes);

    }
}
