package com.matez.wildnature.itemGroup;

import com.matez.wildnature.lists.WNItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class wnItemGroup extends ItemGroup {
    public wnItemGroup() {
        super("wildnature");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(WNItems.PLUM);
    }
}
