package com.matez.wildnature.gui.container;

import com.matez.wildnature.lists.WNItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class PouchSlot extends Slot {
    public PouchSlot(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
        super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem()!= WNItems.POUCH;
    }
}
