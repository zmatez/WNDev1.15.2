package com.matez.wildnature.common.blocks;

import java.util.List;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.client.render.IRenderLayer;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.LootContext;

public class StairsBase extends StairsBlock implements IWaterLoggable, IRenderLayer {
    private Item item;

    public StairsBase(BlockState state, Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(state,properties);
        this.setRegistryName(regName);

        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }


    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && !silkTouch){
            list.add(new ItemStack(item, 1));
        }

        return list;
    }
}