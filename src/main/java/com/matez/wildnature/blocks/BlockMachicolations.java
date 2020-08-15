package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import java.util.ArrayList;
import java.util.List;

public class BlockMachicolations extends Block {
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

    public Item item;


    public BlockMachicolations(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties);

        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);

    }

    public VoxelShape result(List<VoxelShape> shapes){
        VoxelShape result = VoxelShapes.empty();
        int x=0;
        while(x<shapes.size()){
            result = VoxelShapes.combine(result,shapes.get(x),IBooleanFunction.OR);
            x++;
        }
        return result.simplify();
    }

    public VoxelShape getNorthShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 15, 0, 16, 16, 7)); // CUBE
        shapes.add(makeCuboidShape(13, 15, 7, 16, 16, 16)); // CUBE
        shapes.add(makeCuboidShape(13, 11, 0, 16, 15, 16)); // CUBE
        shapes.add(makeCuboidShape(13, 0, 12, 16, 3, 16)); // CUBE
        shapes.add(makeCuboidShape(13, 3, 7, 16, 7, 16)); // CUBE
        shapes.add(makeCuboidShape(13, 7, 3, 16, 11, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 15, 7, 3, 16, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 11, 0, 3, 15, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 7, 3, 3, 11, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 12, 3, 3, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 3, 7, 3, 7, 16)); // CUBE

        return result(shapes);

    }

    public VoxelShape getWestShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 15, 0, 7, 16, 16)); // CUBE
        shapes.add(makeCuboidShape(7, 15, 0, 16, 16, 3)); // CUBE
        shapes.add(makeCuboidShape(0, 11, 0, 16, 15, 3)); // CUBE
        shapes.add(makeCuboidShape(12, 0, 0, 16, 3, 3)); // CUBE
        shapes.add(makeCuboidShape(7, 3, 0, 16, 7, 3)); // CUBE
        shapes.add(makeCuboidShape(3, 7, 0, 16, 11, 3)); // CUBE
        shapes.add(makeCuboidShape(7, 15, 13, 16, 16, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 11, 13, 16, 15, 16)); // CUBE
        shapes.add(makeCuboidShape(3, 7, 13, 16, 11, 16)); // CUBE
        shapes.add(makeCuboidShape(12, 0, 13, 16, 3, 16)); // CUBE
        shapes.add(makeCuboidShape(7, 3, 13, 16, 7, 16)); // CUBE

        return result(shapes);

    }

    public VoxelShape getEastShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(9, 15, 0, 16, 16, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 15, 13, 9, 16, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 11, 13, 16, 15, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 13, 4, 3, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 3, 13, 9, 7, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 7, 13, 13, 11, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 15, 0, 9, 16, 3)); // CUBE
        shapes.add(makeCuboidShape(0, 11, 0, 16, 15, 3)); // CUBE
        shapes.add(makeCuboidShape(0, 7, 0, 13, 11, 3)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 0, 4, 3, 3)); // CUBE
        shapes.add(makeCuboidShape(0, 3, 0, 9, 7, 3)); // CUBE

        return result(shapes);

    }

    public VoxelShape getSouthShape() {
        /* Methods */
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(makeCuboidShape(0, 15, 9, 16, 16, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 15, 0, 3, 16, 9)); // CUBE
        shapes.add(makeCuboidShape(0, 11, 0, 3, 15, 16)); // CUBE
        shapes.add(makeCuboidShape(0, 0, 0, 3, 3, 4)); // CUBE
        shapes.add(makeCuboidShape(0, 3, 0, 3, 7, 9)); // CUBE
        shapes.add(makeCuboidShape(0, 7, 0, 3, 11, 13)); // CUBE
        shapes.add(makeCuboidShape(13, 15, 0, 16, 16, 9)); // CUBE
        shapes.add(makeCuboidShape(13, 11, 0, 16, 15, 16)); // CUBE
        shapes.add(makeCuboidShape(13, 7, 0, 16, 11, 13)); // CUBE
        shapes.add(makeCuboidShape(13, 0, 0, 16, 3, 4)); // CUBE
        shapes.add(makeCuboidShape(13, 3, 0, 16, 7, 9)); // CUBE

        return result(shapes);

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        switch((Direction)state.get(FACING))
        {
            case NORTH:
                return getNorthShape();
            case SOUTH:
                return getSouthShape();
            case WEST:
                return getWestShape();
            case EAST:
                return getEastShape();
            default:
                return getNorthShape();
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

}