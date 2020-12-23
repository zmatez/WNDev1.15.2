package com.matez.wildnature.common.blocks;

import com.matez.wildnature.common.tileentity.item.ItemTileEntity;
import com.matez.wildnature.common.tileentity.tree.TreeTileEntity;
import com.matez.wildnature.init.WN;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import java.util.List;

public class SoilBase extends ContainerBase{
    private String dirt;
    public SoilBase(String dirt, Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
        this.dirt = dirt;
    }

    public SoilBase(String dirt, Properties properties, ResourceLocation regName) {
        super(properties, regName);
        this.dirt = dirt;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }


    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TreeTileEntity();
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        TileEntity entity = worldIn.getTileEntity(pos);
        if(entity instanceof TreeTileEntity){
            ((TreeTileEntity)entity).destroy(worldIn,pos);
        }
        super.onBlockHarvested(worldIn,pos,state,player);
        worldIn.setBlockState(pos, WN.getBlockByID(dirt).getDefaultState());
    }

    @Override
    public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
        TileEntity entity = worldIn.getTileEntity(pos);
        if(entity instanceof TreeTileEntity){
            ((TreeTileEntity)entity).destroy(worldIn,pos);
        }
    }
}
