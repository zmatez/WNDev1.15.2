package com.matez.wildnature.items.dye;

import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class DyeableSwordItem extends SwordItem implements IDyeableItem {
    public DyeableSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
}
