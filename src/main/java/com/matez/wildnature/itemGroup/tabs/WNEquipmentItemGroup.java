package com.matez.wildnature.itemGroup.tabs;

import com.matez.wildnature.lists.WNItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WNEquipmentItemGroup extends ItemGroup {
    public WNEquipmentItemGroup() {
        super("wildnature_equipment");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(WNItems.AMETHYST_SWORD);
    }
}
