package com.matez.wildnature.blocks.boundingboxes;

import net.minecraft.util.math.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class SmallTableBB extends IBoundingBox {

    @Override
    public VoxelShape generateShape()
    {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 0.75, 0, 1, 1, 1)); // CUBE
        shapes.add(makeCuboidShape(0.375, 0, 0.375, 0.625, 0.75, 0.625)); // CUBE

        return result(shapes);
    }


}
