package com.matez.wildnature.blocks.boundingboxes;

import net.minecraft.util.math.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class WeaponsRackBB extends IBoundingBox{

    @Override
    public boolean isSided(){
        return true;
    }

    @Override
    public VoxelShape getSouthShape() {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0.062, 0.438, 1, 0.188, 0.562)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 0, 0.125, 0.062, 1)); // CUBE
        shapes.add(makeCuboidShape(0.875, 0, 0, 1, 0.062, 1)); // CUBE
        shapes.add(makeCuboidShape(0, 0.188, 0.438, 0.125, 1, 0.562)); // CUBE
        shapes.add(makeCuboidShape(0.875, 0.188, 0.438, 1, 1, 0.562)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.375, 0.438, 0.875, 0.5, 0.5)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.688, 0.438, 0.875, 0.812, 0.5)); // CUBE
        shapes.add(makeCuboidShape(0, 0.688, 0.562, 1, 0.812, 0.625)); // CUBE
        return result(shapes);
    }

    @Override
    public VoxelShape getWestShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.438, 0.062, 0, 0.562, 0.188, 1)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 0, 1, 0.062, 0.125)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 0.875, 1, 0.062, 1)); // CUBE
        shapes.add(makeCuboidShape(0.438, 0.188, 0, 0.562, 1, 0.125)); // CUBE
        shapes.add(makeCuboidShape(0.438, 0.188, 0.875, 0.562, 1, 1)); // CUBE
        shapes.add(makeCuboidShape(0.5, 0.375, 0.125, 0.562, 0.5, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.5, 0.688, 0.125, 0.562, 0.812, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.375, 0.688, 0, 0.438, 0.812, 1)); // CUBE

        return result(shapes);

    }

    @Override
    public VoxelShape getNorthShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0.062, 0.438, 1, 0.188, 0.562)); // CUBE
        shapes.add(makeCuboidShape(0.875, 0, 0, 1, 0.062, 1)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 0, 0.125, 0.062, 1)); // CUBE
        shapes.add(makeCuboidShape(0.875, 0.188, 0.438, 1, 1, 0.562)); // CUBE
        shapes.add(makeCuboidShape(0, 0.188, 0.438, 0.125, 1, 0.562)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.375, 0.5, 0.875, 0.5, 0.562)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.688, 0.5, 0.875, 0.812, 0.562)); // CUBE
        shapes.add(makeCuboidShape(0, 0.688, 0.375, 1, 0.812, 0.438)); // CUBE


        return result(shapes);

    }

    @Override
    public VoxelShape getEastShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.438, 0.062, 0, 0.562, 0.188, 1)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 0.875, 1, 0.062, 1)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 0, 1, 0.062, 0.125)); // CUBE
        shapes.add(makeCuboidShape(0.438, 0.188, 0.875, 0.562, 1, 1)); // CUBE
        shapes.add(makeCuboidShape(0.438, 0.188, 0, 0.562, 1, 0.125)); // CUBE
        shapes.add(makeCuboidShape(0.438, 0.375, 0.125, 0.5, 0.5, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.438, 0.688, 0.125, 0.5, 0.812, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.562, 0.688, 0, 0.625, 0.812, 1)); // CUBE


        return result(shapes);

    }
}
