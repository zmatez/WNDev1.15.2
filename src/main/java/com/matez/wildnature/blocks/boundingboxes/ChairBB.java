package com.matez.wildnature.blocks.boundingboxes;

import net.minecraft.util.math.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class ChairBB extends IBoundingBox{

    @Override
    public boolean isSided(){
        return true;
    }

    @Override
    public VoxelShape getSouthShape() {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.125, 0.375, 0.125, 0.875, 0.5, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0, 0.125, 0.25, 0.375, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0, 0.75, 0.25, 0.375, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.75, 0.875, 0.375, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.125, 0.875, 0.375, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.5, 0.125, 0.25, 1.188, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.5, 0.125, 0.875, 1.188, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.375, 0.5, 0.125, 0.625, 1.312, 0.25)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.25, 0.75, 0.125, 0.375, 0.875, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.625, 0.75, 0.125, 0.75, 0.875, 0.25)); // CUBE

        return result(shapes);
    }

    @Override
    public VoxelShape getWestShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.125, 0.375, 0.125, 0.875, 0.5, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.125, 0.875, 0.375, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0, 0.125, 0.25, 0.375, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0, 0.75, 0.25, 0.375, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.75, 0.875, 0.375, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.5, 0.125, 0.875, 1.188, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.5, 0.75, 0.875, 1.188, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.5, 0.375, 0.875, 1.312, 0.625)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.75, 0.75, 0.25, 0.875, 0.875, 0.375)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.75, 0.625, 0.875, 0.875, 0.75)); // CUBE

        return result(shapes);

    }

    @Override
    public VoxelShape getNorthShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.125, 0.375, 0.125, 0.875, 0.5, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.75, 0.875, 0.375, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.125, 0.875, 0.375, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0, 0.125, 0.25, 0.375, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0, 0.75, 0.25, 0.375, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.5, 0.75, 0.875, 1.188, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.5, 0.75, 0.25, 1.188, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.375, 0.5, 0.75, 0.625, 1.312, 0.875)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.625, 0.75, 0.75, 0.75, 0.875, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.25, 0.75, 0.75, 0.375, 0.875, 0.875)); // CUBE


        return result(shapes);

    }

    @Override
    public VoxelShape getEastShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.125, 0.375, 0.125, 0.875, 0.5, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0, 0.75, 0.25, 0.375, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.75, 0.875, 0.375, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.125, 0.875, 0.375, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0, 0.125, 0.25, 0.375, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.5, 0.75, 0.25, 1.188, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.5, 0.125, 0.25, 1.188, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.5, 0.375, 0.25, 1.312, 0.625)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.125, 0.75, 0.625, 0.25, 0.875, 0.75)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.75, 0.25, 0.25, 0.875, 0.375)); // CUBE


        return result(shapes);

    }
}
