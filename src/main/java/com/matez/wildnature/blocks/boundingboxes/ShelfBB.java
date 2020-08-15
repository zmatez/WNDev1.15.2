package com.matez.wildnature.blocks.boundingboxes;

import net.minecraft.util.math.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class ShelfBB extends IBoundingBox{

    @Override
    public boolean isSided(){
        return true;
    }

    @Override
    public VoxelShape getSouthShape() {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.062, 0.938, 0, 1, 1, 0.562)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.438, 0, 0.25, 0.938, 0.062)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.875, 0.062, 0.25, 0.938, 0.562)); // CUBE
        shapes.add(makeCuboidShape(0.812, 0.438, 0, 0.938, 0.938, 0.062)); // CUBE
        shapes.add(makeCuboidShape(0.812, 0.875, 0.062, 0.938, 0.938, 0.562)); // CUBE
        return result(shapes);
    }

    @Override
    public VoxelShape getWestShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.438, 0.938, 0.062, 1, 1, 1)); // CUBE
        shapes.add(makeCuboidShape(0.938, 0.438, 0.125, 1, 0.938, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.438, 0.875, 0.125, 0.938, 0.938, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.938, 0.438, 0.812, 1, 0.938, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.438, 0.875, 0.812, 0.938, 0.938, 0.938)); // CUBE

        return result(shapes);

    }

    @Override
    public VoxelShape getNorthShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0.938, 0.438, 0.938, 1, 1)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.438, 0.938, 0.875, 0.938, 1)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.875, 0.438, 0.875, 0.938, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.062, 0.438, 0.938, 0.188, 0.938, 1)); // CUBE
        shapes.add(makeCuboidShape(0.062, 0.875, 0.438, 0.188, 0.938, 0.938)); // CUBE


        return result(shapes);

    }

    @Override
    public VoxelShape getEastShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0.938, 0, 0.562, 1, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0, 0.438, 0.75, 0.062, 0.938, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.062, 0.875, 0.75, 0.562, 0.938, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0, 0.438, 0.062, 0.062, 0.938, 0.188)); // CUBE
        shapes.add(makeCuboidShape(0.062, 0.875, 0.062, 0.562, 0.938, 0.188)); // CUBE


        return result(shapes);

    }
}
