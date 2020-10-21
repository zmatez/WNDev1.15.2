package com.matez.wildnature.blocks;

import com.matez.wildnature.gui.tileEntities.item.ItemTileEntity;
import com.matez.wildnature.items.FoodItem;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.player.PlayerEntity;
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

public class TableBase extends HorizontalBase implements IRenderLayer {
    public TableBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
        ItemTileEntity.SUPPORTED_BLOCKS.add(this);
    }

    public TableBase(Properties properties, Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
        super(properties, builder, drop, min, max, exp, regName);
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
                        return ActionResultType.SUCCESS;
                    }else {
                        player.setHeldItem(handIn, itemEntity.getPlacedStack());
                        itemEntity.removeItemStack();
                        return ActionResultType.SUCCESS;
                    }
                }else{
                    return ActionResultType.PASS;
                }
            }else{
                if(itemEntity.hasPlacedStack()){
                    return ActionResultType.PASS;
                }else{
                    if(!player.isSneaking()) {
                        itemEntity.setFacing(player.getHorizontalFacing());
                        itemEntity.addItemStack(worldIn, pos, heldItem);
                        player.setHeldItem(handIn, ItemStack.EMPTY);
                        return ActionResultType.SUCCESS;
                    }
                    return ActionResultType.PASS;
                }
            }
        }
        return ActionResultType.FAIL;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        ItemTileEntity entity = new ItemTileEntity();
        entity.setFacing(state.get(FACING));
        return entity;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        TileEntity entity = worldIn.getTileEntity(pos);
        if(entity!=null && entity instanceof ItemTileEntity){
            ((ItemTileEntity)entity).destroy(worldIn,pos);
        }
        super.onBlockHarvested(worldIn, pos, state, player);
    }
}
