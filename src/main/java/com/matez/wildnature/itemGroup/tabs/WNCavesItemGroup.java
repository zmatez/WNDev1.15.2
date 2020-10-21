package com.matez.wildnature.itemGroup.tabs;

import com.matez.wildnature.lists.WNItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WNCavesItemGroup extends ItemGroup {
    public WNCavesItemGroup() {
        super("wildnature_caves");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(WNItems.GLOWSHROOM_DUST);
    }
}
