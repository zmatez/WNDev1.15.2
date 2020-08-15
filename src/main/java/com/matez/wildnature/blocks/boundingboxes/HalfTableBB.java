package com.matez.wildnature.blocks.boundingboxes;

import net.minecraft.util.math.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class HalfTableBB extends IBoundingBox{

    @Override
    public boolean isSided(){
        return true;
    }

    @Override
    public VoxelShape getSouthShape() {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0.75, 0, 1, 1, 1)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.062, 1, 0.75, 0.312)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 0.062, 0.25, 0.75, 0.312)); // CUBE
        shapes.add(makeCuboidShape(0.25, 0.125, 0.125, 0.75, 0.312, 0.25)); // CUBE
        return result(shapes);
    }

    @Override
    public VoxelShape getWestShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0.75, 0, 1, 1, 1)); // CUBE
        shapes.add(makeCuboidShape(0.688, 0, 0.75, 0.938, 0.75, 1)); // CUBE
        shapes.add(makeCuboidShape(0.688, 0, 0, 0.938, 0.75, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.125, 0.25, 0.875, 0.312, 0.75)); // CUBE

        return result(shapes);

    }

    @Override
    public VoxelShape getNorthShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0.75, 0, 1, 1, 1)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 0.688, 0.25, 0.75, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.688, 1, 0.75, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.25, 0.125, 0.75, 0.75, 0.312, 0.875)); // CUBE


        return result(shapes);

    }

    @Override
    public VoxelShape getEastShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0.75, 0, 1, 1, 1)); // CUBE
        shapes.add(makeCuboidShape(0.062, 0, 0, 0.312, 0.75, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.062, 0, 0.75, 0.312, 0.75, 1)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.125, 0.25, 0.25, 0.312, 0.75)); // CUBE


        return result(shapes);

    }
}
