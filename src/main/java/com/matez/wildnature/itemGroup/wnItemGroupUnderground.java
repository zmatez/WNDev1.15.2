package com.matez.wildnature.itemGroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class wnItemGroupUnderground extends ItemGroup {
    public wnItemGroupUnderground() {
        super("wildnature_underground");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Registry.ITEM.getOrDefault(new ResourceLocation("wildnature:glowshroom_dust")));
    }
}
