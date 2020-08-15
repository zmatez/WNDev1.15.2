package com.matez.wildnature.blocks;

import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class MossBlock extends BushBase implements IRenderLayer {
    public MossBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 1.0D, 14.0D);

    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).isSolid() &&worldIn.getBlockState(pos.down()).isNormalCube(worldIn,pos) ;
    }

}
