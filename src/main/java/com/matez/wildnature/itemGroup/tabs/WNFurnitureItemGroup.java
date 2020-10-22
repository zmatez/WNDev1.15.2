package com.matez.wildnature.itemGroup.tabs;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
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
