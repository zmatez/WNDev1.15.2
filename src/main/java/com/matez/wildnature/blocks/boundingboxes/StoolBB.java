package com.matez.wildnature.blocks.boundingboxes;

import net.minecraft.util.math.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class StoolBB extends IBoundingBox {

    @Override
    public VoxelShape generateShape()
    {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.125, 0.375, 0.125, 0.875, 0.5, 0.875)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0, 0.188, 0.312, 0.375, 0.312)); // CUBE
        shapes.add(makeCuboidShape(0.188, 0, 0.688, 0.312, 0.375, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.688, 0, 0.688, 0.812, 0.375, 0.812)); // CUBE
        shapes.add(makeCuboidShape(0.688, 0, 0.188, 0.812, 0.375, 0.312)); // CUBE

        return result(shapes);
    }


}
