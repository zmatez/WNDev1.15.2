package com.matez.wildnature.common.blocks;

import com.matez.wildnature.common.tileentity.item.ItemTileEntity;
import com.matez.wildnature.client.render.IRenderLayer;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class TableBase extends HorizontalContainerBase implements IRenderLayer{
    public TableBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
        ItemTileEntity.SUPPORTED_BLOCKS.add(this);
    }

    @Override
    public RenderType getRenderLayer() {
        return RenderType.getCutout();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        TileEntity entity = worldIn.getTileEntity(pos);
        if(entity!=null && entity instanceof ItemTileEntity){
            ItemTileEntity itemEntity = (ItemTileEntity) entity;
            ItemStack heldItem = player.getHeldItem(handIn);

            if(heldItem.isEmpty()){
                if(itemEntity.hasPlacedStack()){
                    if(!player.isSneaking() && itemEntity.getPlacedStack().getItem().isFood()){
                        itemEntity.eat(player);
                    }else {
                        player.setHeldItem(handIn, itemEntity.getPlacedStack());
                        itemEntity.removeItemStack();
                    }
                    return ActionResultType.SUCCESS;
                }else{
                    return ActionResultType.PASS;
                }
            }else{
                if (!itemEntity.hasPlacedStack()) {
                    if (!player.isSneaking()) {
                        itemEntity.setFacing(player.getHorizontalFacing());
                        itemEntity.addItemStack(worldIn, pos, heldItem);
                        player.setHeldItem(handIn, ItemStack.EMPTY);
                        return ActionResultType.SUCCESS;
                    }
                }
                return ActionResultType.PASS;
            }
        }
        return ActionResultType.FAIL;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        TileEntity entity = worldIn.getTileEntity(pos);
        if(entity!=null && entity instanceof ItemTileEntity){
            ((ItemTileEntity)entity).destroy(worldIn,pos);
        }
        super.onBlockHarvested(worldIn, pos, state, player);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        ItemTileEntity entity = new ItemTileEntity();
        return entity;
    }
}
