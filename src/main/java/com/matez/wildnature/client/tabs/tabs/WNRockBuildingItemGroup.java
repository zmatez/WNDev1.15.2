package com.matez.wildnature.client.tabs.tabs;

import com.matez.wildnature.util.lists.WNBlocks;
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
