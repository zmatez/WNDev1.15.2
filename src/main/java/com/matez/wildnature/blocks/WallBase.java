package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;

import java.util.List;

public class WallBase extends WallBlock implements IRenderLayer {
    private Item item;

    private static Properties Properties(Properties properties){
        properties.sound(SoundType.STONE);
        properties.hardnessAndResistance(1.5F,4F);
        return properties;
    }

    public WallBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(Properties(properties));
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
