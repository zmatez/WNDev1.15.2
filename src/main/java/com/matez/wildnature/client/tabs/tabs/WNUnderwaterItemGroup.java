package com.matez.wildnature.client.tabs.tabs;

import com.matez.wildnature.util.lists.WNBlocks;
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
