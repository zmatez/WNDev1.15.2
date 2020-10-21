package com.matez.wildnature.itemGroup.tabs;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WNUnderwaterItemGroup extends ItemGroup {
    public WNUnderwaterItemGroup() {
        super("wildnature_underwater");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(WNBlocks.OAR_WEED);
    }
}
