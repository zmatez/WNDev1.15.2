package com.matez.wildnature.itemGroup.tabs;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WNWoodBuildingItemGroup extends ItemGroup {
    public WNWoodBuildingItemGroup() {
        super("wildnature_wood_building");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(WNBlocks.CHERRY_PARQUET);
    }
}
