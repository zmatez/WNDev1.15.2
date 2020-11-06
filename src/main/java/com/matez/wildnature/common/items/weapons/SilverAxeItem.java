package com.matez.wildnature.common.items.weapons;

import com.matez.wildnature.common.items.dye.IDyeableItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class SilverAxeItem extends AxeItem {
    public SilverAxeItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(target instanceof ZombieEntity || target instanceof SkeletonEntity){
            target.setFire(4);
        }
        return super.hitEntity(stack, target, attacker);
    }
}
