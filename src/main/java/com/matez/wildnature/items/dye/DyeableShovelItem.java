package com.matez.wildnature.items.dye;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ShovelItem;

public class DyeableShovelItem extends ShovelItem implements IDyeableItem {
    public DyeableShovelItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
}
