package com.matez.wildnature.client.tabs.tabs;

import com.matez.wildnature.util.lists.WNItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WNFoodItemGroup extends ItemGroup {
    public WNFoodItemGroup() {
        super("wildnature_food");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(WNItems.HAWTHORN_BERRY);
    }
}
