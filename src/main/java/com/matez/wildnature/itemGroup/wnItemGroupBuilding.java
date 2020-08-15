package com.matez.wildnature.itemGroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class wnItemGroupBuilding extends ItemGroup {
    public wnItemGroupBuilding() {
        super("wildnature_building");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Registry.ITEM.getOrDefault(new ResourceLocation("wildnature:cherry_parquet")));
    }
}
