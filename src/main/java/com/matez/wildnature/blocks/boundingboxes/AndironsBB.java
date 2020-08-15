package com.matez.wildnature.blocks.boundingboxes;

import net.minecraft.util.math.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class AndironsBB extends IBoundingBox{

    @Override
    public boolean isSided(){
        return true;
    }

    @Override
    public VoxelShape getSouthShape() {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.188, 0.125, 0, 0.25, 0.188, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.125, 0, 0.812, 0.188, 0.812)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.062, 0.125, 0, 0.938, 0.188, 0.062)); // CUBE
        shapes.add(makeCuboidShape(0.062, 0.125, 0.688, 0.938, 0.188, 0.75)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0.188, 0.688, 0.25, 0.688, 0.75)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.188, 0.688, 0.812, 0.688, 0.75)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.5, 0.75, 0.812, 0.625, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0.5, 0.75, 0.25, 0.625, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.312, 0.125, 0, 0.375, 0.188, 0.75)); // CUBE
        shapes.add(makeCuboidShape(0.625, 0.125, 0, 0.688, 0.188, 0.75)); // CUBE
        shapes.add(makeCuboidShape(0.438, 0.125, 0, 0.562, 0.188, 0.75)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.062, 0.188, 0.438, 0.938, 0.438, 0.688)); // LOG1
        shapes.add(makeCuboidShape(0.062, 0.188, 0.062, 0.938, 0.438, 0.312)); // LOG1
        // Skipped 'Log1', as it has rotation
        shapes.add(makeCuboidShape(0.188, 0.188, 0, 0.25, 0.375, 0.062)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.188, 0, 0.812, 0.375, 0.062)); // CUBE

        return result(shapes);
    }

    @Override
    public VoxelShape getWestShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.188, 0.125, 0.188, 1, 0.188, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0.125, 0.75, 1, 0.188, 0.812)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.938, 0.125, 0.062, 1, 0.188, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.25, 0.125, 0.062, 0.312, 0.188, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.25, 0.188, 0.188, 0.312, 0.688, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.25, 0.188, 0.75, 0.312, 0.688, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0.5, 0.75, 0.25, 0.625, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0.5, 0.188, 0.25, 0.625, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.25, 0.125, 0.312, 1, 0.188, 0.375)); // CUBE
        shapes.add(makeCuboidShape(0.25, 0.125, 0.625, 1, 0.188, 0.688)); // CUBE
        shapes.add(makeCuboidShape(0.25, 0.125, 0.438, 1, 0.188, 0.562)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.312, 0.188, 0.062, 0.562, 0.438, 0.938)); // LOG1
        shapes.add(makeCuboidShape(0.688, 0.188, 0.062, 0.938, 0.438, 0.938)); // LOG1
        // Skipped 'Log1', as it has rotation
        shapes.add(makeCuboidShape(0.938, 0.188, 0.188, 1, 0.375, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.938, 0.188, 0.75, 1, 0.375, 0.812)); // CUBE

        return result(shapes);

    }

    @Override
    public VoxelShape getNorthShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.75, 0.125, 0.188, 0.812, 0.188, 1)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0.125, 0.188, 0.25, 0.188, 1)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.062, 0.125, 0.938, 0.938, 0.188, 1)); // CUBE
        shapes.add(makeCuboidShape(0.062, 0.125, 0.25, 0.938, 0.188, 0.312)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.188, 0.25, 0.812, 0.688, 0.312)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0.188, 0.25, 0.25, 0.688, 0.312)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0.5, 0.188, 0.25, 0.625, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.5, 0.188, 0.812, 0.625, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.625, 0.125, 0.25, 0.688, 0.188, 1)); // CUBE
        shapes.add(makeCuboidShape(0.312, 0.125, 0.25, 0.375, 0.188, 1)); // CUBE
        shapes.add(makeCuboidShape(0.438, 0.125, 0.25, 0.562, 0.188, 1)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.062, 0.188, 0.312, 0.938, 0.438, 0.562)); // LOG1
        shapes.add(makeCuboidShape(0.062, 0.188, 0.688, 0.938, 0.438, 0.938)); // LOG1
        // Skipped 'Log1', as it has rotation
        shapes.add(makeCuboidShape(0.75, 0.188, 0.938, 0.812, 0.375, 1)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0.188, 0.938, 0.25, 0.375, 1)); // CUBE


        return result(shapes);

    }

    @Override
    public VoxelShape getEastShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0.125, 0.75, 0.812, 0.188, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0, 0.125, 0.188, 0.812, 0.188, 0.25)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0, 0.125, 0.062, 0.062, 0.188, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.688, 0.125, 0.062, 0.75, 0.188, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.688, 0.188, 0.75, 0.75, 0.688, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.688, 0.188, 0.188, 0.75, 0.688, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.5, 0.188, 0.812, 0.625, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0.5, 0.75, 0.812, 0.625, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0, 0.125, 0.625, 0.75, 0.188, 0.688)); // CUBE
        shapes.add(makeCuboidShape(0, 0.125, 0.312, 0.75, 0.188, 0.375)); // CUBE
        shapes.add(makeCuboidShape(0, 0.125, 0.438, 0.75, 0.188, 0.562)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.438, 0.188, 0.062, 0.688, 0.438, 0.938)); // LOG1
        shapes.add(makeCuboidShape(0.062, 0.188, 0.062, 0.312, 0.438, 0.938)); // LOG1
        // Skipped 'Log1', as it has rotation
        shapes.add(makeCuboidShape(0, 0.188, 0.75, 0.062, 0.375, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0, 0.188, 0.188, 0.062, 0.375, 0.25)); // CUBE


        return result(shapes);

    }
}
