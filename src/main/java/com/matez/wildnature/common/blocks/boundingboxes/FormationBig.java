package com.matez.wildnature.common.blocks.boundingboxes;

import net.minecraft.util.math.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class FormationBig extends IBoundingBox {

    @Override
    public VoxelShape getUpShape()
    {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.3, 0, 0.3, 0.7, 0.8, 0.7)); // ELEMENT
        return result(shapes);
    }

    @Override
    public VoxelShape getDownShape()
    {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.3, 0.8, 0.3, 0.7, 0, 0.7)); // ELEMENT

        return result(shapes);
    }

    @Override
    public VoxelShape getSouthShape()
    {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.3, 0.8, 0.3, 0.7, 0, 0.7)); // ELEMENT

        return result(shapes);
    }

    @Override
    public VoxelShape getWestShape()
    {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.3, 0.8, 0.3, 0.7, 0, 0.7)); // ELEMENT

        return result(shapes);
    }

    @Override
    public VoxelShape getEastShape()
    {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.3, 0.8, 0.3, 0.7, 0, 0.7)); // ELEMENT

        return result(shapes);
    }

    @Override
    public VoxelShape getNorthShape()
    {
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0.3, 0.8, 0.3, 0.7, 0, 0.7)); // ELEMENT

        return result(shapes);
    }

}
