package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.storage.loot.LootContext;

import java.util.List;

public class ButtonBase extends AbstractButtonBlock implements IRenderLayer {
        private Item item;
    private boolean wooden = true;

    public ButtonBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(true, properties);
        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }
    public ButtonBase(Properties properties, Item.Properties builder, ResourceLocation regName,boolean wooden) {
        super(wooden, properties);
        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);
        this.wooden=wooden;

        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }

    protected SoundEvent getSoundEvent(boolean p_196369_1_) {
        if(wooden) {
            return p_196369_1_ ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF;
        }else{
            return p_196369_1_ ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
        }
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