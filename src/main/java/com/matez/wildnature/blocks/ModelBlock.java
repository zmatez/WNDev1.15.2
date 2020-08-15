package com.matez.wildnature.blocks;

import com.matez.wildnature.blocks.boundingboxes.IBoundingBox;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class ModelBlock extends RotateableBlock {
    private IBoundingBox box;
    public ModelBlock(Properties properties, Item.Properties builder, ResourceLocation regName, boolean onWall, IBoundingBox box) {
        super(properties, builder, regName, onWall);
        this.box=box;
        this.box.SHAPE = box.generateShape();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if(box.isSided()){
            if(state.get(FACING)== Direction.NORTH){
                return box.getNorthShape();
            }else if(state.get(FACING)== Direction.SOUTH){
                return box.getSouthShape();
            }else if(state.get(FACING)== Direction.EAST){
                return box.getEastShape();
            }else{
                return box.getWestShape();
            }
        }else {
            return box.getShape(state, worldIn, pos, context);
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return getShape(state,worldIn,pos,context);
    }
}
