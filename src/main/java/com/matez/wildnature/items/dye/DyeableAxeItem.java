package com.matez.wildnature.items.dye;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;

public class DyeableAxeItem extends AxeItem implements IDyeableItem {
    public DyeableAxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
}
