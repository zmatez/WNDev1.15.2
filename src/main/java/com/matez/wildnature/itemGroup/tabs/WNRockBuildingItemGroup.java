package com.matez.wildnature.itemGroup.tabs;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WNRockBuildingItemGroup extends ItemGroup {
    public WNRockBuildingItemGroup() {
        super("wildnature_rock_building");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(WNBlocks.MARBLE_SMOOTH_PILLAR);
    }
}
