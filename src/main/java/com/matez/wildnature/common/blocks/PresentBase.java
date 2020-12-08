package com.matez.wildnature.common.blocks;

import com.matez.wildnature.common.tileentity.item.ItemTileEntity;
import com.matez.wildnature.common.tileentity.present.PresentTileEntity;
import com.matez.wildnature.init.WN;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class PresentBase extends HorizontalContainerBase {
    protected static final VoxelShape UP = Block.makeCuboidShape(2.0D, 0D, 2.0D, 14.0D, 8.0D, 14.0D);
    public PresentBase(Properties properties, ResourceLocation regName) {
        super(properties.hardnessAndResistance(0.5f,0.2f), regName);
        PresentTileEntity.SUPPORTED_BLOCKS.add(this);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return UP;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        PresentTileEntity entity = new PresentTileEntity();
        return entity;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        TileEntity entity = worldIn.getTileEntity(pos);
        if(entity instanceof PresentTileEntity){
            ((PresentTileEntity)entity).dropGift(worldIn,pos);
        }
        super.onBlockHarvested(worldIn, pos, state, player);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        TileEntity entity = worldIn.getTileEntity(pos);
        if(entity instanceof PresentTileEntity){
            ((PresentTileEntity)entity).setGift(stack.copy());
        }
    }
}
