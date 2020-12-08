package com.matez.wildnature.common.blocks;

import com.matez.wildnature.util.lists.WNBlocks;
import net.minecraft.block.ContainerBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public abstract class ContainerBase extends ContainerBlock {
    public Item item;

    private static Properties Properties(Properties properties){
        return properties;
    }

    public ContainerBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(Properties(properties));

        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }

    public ContainerBase(Properties properties, ResourceLocation regName) {
        super(Properties(properties));

        this.setRegistryName(regName);

        WNBlocks.BLOCKS.add(this);
    }
}
