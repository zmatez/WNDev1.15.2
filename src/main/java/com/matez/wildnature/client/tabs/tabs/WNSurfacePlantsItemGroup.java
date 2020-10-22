package com.matez.wildnature.client.tabs.tabs;

import com.matez.wildnature.util.lists.WNBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WNSurfacePlantsItemGroup extends ItemGroup {
    public WNSurfacePlantsItemGroup() {
        super("wildnature_surface_plants");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(WNBlocks.MATTHIOLA_PINK);
    }
}
