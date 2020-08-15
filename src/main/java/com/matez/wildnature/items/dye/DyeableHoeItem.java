package com.matez.wildnature.items.dye;

import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;

public class DyeableHoeItem extends HoeItem implements IDyeableItem {
    public DyeableHoeItem(IItemTier tier, float attackSpeedIn, Properties builder) {
        super(tier, attackSpeedIn, builder);
    }
}
