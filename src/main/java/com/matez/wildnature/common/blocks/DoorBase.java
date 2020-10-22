package com.matez.wildnature.common.blocks;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.client.render.IRenderLayer;
import net.minecraft.block.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.LootContext;

import java.util.List;

public class DoorBase extends DoorBlock implements IRenderLayer {
    private Item item;

    public DoorBase(Block.Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties);
        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);

        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && state.get(HALF)==DoubleBlockHalf.LOWER){
            list.add(new ItemStack(item, 1));
        }

        return list;
    }

    @Override
    public RenderType getRenderLayer() {
        return RenderType.getCutoutMipped();
    }
}