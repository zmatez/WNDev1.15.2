package com.matez.wildnature.blocks.boundingboxes;

import net.minecraft.util.math.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class AnvilBB extends IBoundingBox{

    @Override
    public boolean isSided(){
        return true;
    }

    @Override
    public VoxelShape getSouthShape() {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0, 0.312, 1, 0.125, 0.688)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0.125, 0.312, 0.812, 0.25, 0.688)); // CUBE
        shapes.add(makeCuboidShape(0.312, 0.25, 0.312, 0.688, 0.5, 0.688)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.062, 0, 0.688, 0.25, 0.125, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.688, 0.938, 0.125, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.188, 0.938, 0.125, 0.312)); // CUBE
        shapes.add(makeCuboidShape(0.062, 0, 0.188, 0.25, 0.125, 0.312)); // CUBE
        shapes.add(makeCuboidShape(0.25, 0.5, 0.312, 0.75, 0.625, 0.688)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.625, 0.312, 0.875, 0.75, 0.688)); // CUBE
        shapes.add(makeCuboidShape(0, 0.75, 0.312, 1, 1, 0.438)); // SURFACE
        shapes.add(makeCuboidShape(0, 0.75, 0.562, 1, 1, 0.688)); // SURFACE
        shapes.add(makeCuboidShape(0, 0.75, 0.438, 0.125, 1, 0.562)); // SURFACE
        shapes.add(makeCuboidShape(0.25, 0.75, 0.438, 0.75, 1, 0.562)); // SURFACE
        shapes.add(makeCuboidShape(0.875, 0.75, 0.438, 1.062, 1, 0.562)); // FLATHORN
        shapes.add(makeCuboidShape(1.062, 0.875, 0.438, 1.375, 1, 0.562)); // FLATHORN
        // Skipped 'flathorn', as it has rotation
        // Skipped 'flathorn', as it has rotation
        shapes.add(makeCuboidShape(-0.188, 0.812, 0.438, 0, 1, 0.562)); // ROUNDHORN
        // Skipped 'Roundhorn', as it has rotation
        // Skipped 'Roundhorn', as it has rotation
        // Skipped 'Roundhorn', as it has rotation
        // Skipped 'Roundhorn', as it has rotation
        shapes.add(makeCuboidShape(-0.375, 0.938, 0.438, -0.188, 1, 0.562)); // ROUNDHORN
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.375, 0, 0.125, 0.625, 0.188, 0.312)); // STUIKBLOK

        return result(shapes);
    }

    @Override
    public VoxelShape getWestShape() {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.312, 0, 0, 0.688, 0.125, 1)); // CUBE
        shapes.add(makeCuboidShape(0.312, 0.125, 0.188, 0.688, 0.25, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.312, 0.25, 0.312, 0.688, 0.5, 0.688)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.188, 0, 0.062, 0.312, 0.125, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0, 0.75, 0.312, 0.125, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.688, 0, 0.75, 0.812, 0.125, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.688, 0, 0.062, 0.812, 0.125, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.312, 0.5, 0.25, 0.688, 0.625, 0.75)); // CUBE
        shapes.add(makeCuboidShape(0.312, 0.625, 0.125, 0.688, 0.75, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.562, 0.75, 0, 0.688, 1, 1)); // SURFACE
        shapes.add(makeCuboidShape(0.312, 0.75, 0, 0.438, 1, 1)); // SURFACE
        shapes.add(makeCuboidShape(0.438, 0.75, 0, 0.562, 1, 0.125)); // SURFACE
        shapes.add(makeCuboidShape(0.438, 0.75, 0.25, 0.562, 1, 0.75)); // SURFACE
        shapes.add(makeCuboidShape(0.438, 0.75, 0.875, 0.562, 1, 1.062)); // FLATHORN
        shapes.add(makeCuboidShape(0.438, 0.875, 1.062, 0.562, 1, 1.375)); // FLATHORN
        // Skipped 'flathorn', as it has rotation
        // Skipped 'flathorn', as it has rotation
        shapes.add(makeCuboidShape(0.438, 0.812, -0.188, 0.562, 1, 0)); // ROUNDHORN
        // Skipped 'Roundhorn', as it has rotation
        // Skipped 'Roundhorn', as it has rotation
        // Skipped 'Roundhorn', as it has rotation
        // Skipped 'Roundhorn', as it has rotation
        shapes.add(makeCuboidShape(0.438, 0.938, -0.375, 0.562, 1, -0.188)); // ROUNDHORN
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.688, 0, 0.375, 0.875, 0.188, 0.625)); // STUIKBLOK


        return result(shapes);

    }

    @Override
    public VoxelShape getNorthShape() {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0, 0.312, 1, 0.125, 0.688)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0.125, 0.312, 0.812, 0.25, 0.688)); // CUBE
        shapes.add(makeCuboidShape(0.312, 0.25, 0.312, 0.688, 0.5, 0.688)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.75, 0, 0.188, 0.938, 0.125, 0.312)); // CUBE
        shapes.add(makeCuboidShape(0.062, 0, 0.188, 0.25, 0.125, 0.312)); // CUBE
        shapes.add(makeCuboidShape(0.062, 0, 0.688, 0.25, 0.125, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.75, 0, 0.688, 0.938, 0.125, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.25, 0.5, 0.312, 0.75, 0.625, 0.688)); // CUBE
        shapes.add(makeCuboidShape(0.125, 0.625, 0.312, 0.875, 0.75, 0.688)); // CUBE
        shapes.add(makeCuboidShape(0, 0.75, 0.562, 1, 1, 0.688)); // SURFACE
        shapes.add(makeCuboidShape(0, 0.75, 0.312, 1, 1, 0.438)); // SURFACE
        shapes.add(makeCuboidShape(0.875, 0.75, 0.438, 1, 1, 0.562)); // SURFACE
        shapes.add(makeCuboidShape(0.25, 0.75, 0.438, 0.75, 1, 0.562)); // SURFACE
        shapes.add(makeCuboidShape(-0.062, 0.75, 0.438, 0.125, 1, 0.562)); // FLATHORN
        shapes.add(makeCuboidShape(-0.375, 0.875, 0.438, -0.062, 1, 0.562)); // FLATHORN
        // Skipped 'flathorn', as it has rotation
        // Skipped 'flathorn', as it has rotation
        shapes.add(makeCuboidShape(1, 0.812, 0.438, 1.188, 1, 0.562)); // ROUNDHORN
        // Skipped 'Roundhorn', as it has rotation
        // Skipped 'Roundhorn', as it has rotation
        // Skipped 'Roundhorn', as it has rotation
        // Skipped 'Roundhorn', as it has rotation
        shapes.add(makeCuboidShape(1.188, 0.938, 0.438, 1.375, 1, 0.562)); // ROUNDHORN
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.375, 0, 0.688, 0.625, 0.188, 0.875)); // STUIKBLOK

        return result(shapes);

    }

    @Override
    public VoxelShape getEastShape() {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.312, 0, 0, 0.688, 0.125, 1)); // CUBE
        shapes.add(makeCuboidShape(0.312, 0.125, 0.188, 0.688, 0.25, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.312, 0.25, 0.312, 0.688, 0.5, 0.688)); // CUBE
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.688, 0, 0.75, 0.812, 0.125, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.688, 0, 0.062, 0.812, 0.125, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0, 0.062, 0.312, 0.125, 0.25)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0, 0.75, 0.312, 0.125, 0.938)); // CUBE
        shapes.add(makeCuboidShape(0.312, 0.5, 0.25, 0.688, 0.625, 0.75)); // CUBE
        shapes.add(makeCuboidShape(0.312, 0.625, 0.125, 0.688, 0.75, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.312, 0.75, 0, 0.438, 1, 1)); // SURFACE
        shapes.add(makeCuboidShape(0.562, 0.75, 0, 0.688, 1, 1)); // SURFACE
        shapes.add(makeCuboidShape(0.438, 0.75, 0.875, 0.562, 1, 1)); // SURFACE
        shapes.add(makeCuboidShape(0.438, 0.75, 0.25, 0.562, 1, 0.75)); // SURFACE
        shapes.add(makeCuboidShape(0.438, 0.75, -0.062, 0.562, 1, 0.125)); // FLATHORN
        shapes.add(makeCuboidShape(0.438, 0.875, -0.375, 0.562, 1, -0.062)); // FLATHORN
        // Skipped 'flathorn', as it has rotation
        // Skipped 'flathorn', as it has rotation
        shapes.add(makeCuboidShape(0.438, 0.812, 1, 0.562, 1, 1.188)); // ROUNDHORN
        // Skipped 'Roundhorn', as it has rotation
        // Skipped 'Roundhorn', as it has rotation
        // Skipped 'Roundhorn', as it has rotation
        // Skipped 'Roundhorn', as it has rotation
        shapes.add(makeCuboidShape(0.438, 0.938, 1.188, 0.562, 1, 1.375)); // ROUNDHORN
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        // Skipped 'Cube', as it has rotation
        shapes.add(makeCuboidShape(0.125, 0, 0.375, 0.312, 0.188, 0.625)); // STUIKBLOK



        return result(shapes);

    }
}
