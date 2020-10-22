package com.matez.wildnature.client.tabs.tabs;

import com.matez.wildnature.util.lists.WNBlocks;
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
