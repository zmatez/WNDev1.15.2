package com.matez.wildnature.client.tabs.tabs;

import com.matez.wildnature.util.lists.WNItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WNSurfaceItemGroup extends ItemGroup {
    public WNSurfaceItemGroup() {
        super("wildnature_surface");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(WNItems.PLUM);
    }
}
