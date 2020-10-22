package com.matez.wildnature.client.tabs.tabs;

import com.matez.wildnature.util.lists.WNBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WNFurnitureItemGroup extends ItemGroup {
    public WNFurnitureItemGroup() {
        super("wildnature_furniture");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(WNBlocks.ICESHROOM_LANTERN);
    }
}
