package com.matez.wildnature.itemGroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class wnItemGroupDeco extends ItemGroup {
    public wnItemGroupDeco() {
        super("wildnature_deco");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Registry.ITEM.getOrDefault(new ResourceLocation("wildnature:maple_chair")));
    }
}
