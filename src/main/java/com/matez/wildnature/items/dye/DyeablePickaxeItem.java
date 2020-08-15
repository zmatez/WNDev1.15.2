package com.matez.wildnature.items.dye;

import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class DyeablePickaxeItem extends PickaxeItem implements IDyeableItem {
    public DyeablePickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
}
