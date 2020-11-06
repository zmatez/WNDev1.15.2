package com.matez.wildnature.common.items.weapons;

import com.matez.wildnature.common.items.dye.IDyeableItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.particles.ParticleTypes;

public class SilverSwordItem extends SwordItem{
    public SilverSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(target instanceof ZombieEntity || target instanceof SkeletonEntity){
            target.setFire(4);
        }
        if(target.getCollisionBoundingBox()!=null) {
            target.getEntityWorld().addParticle(ParticleTypes.LAVA, target.getPosX() + 0.5, target.getPosY() + (target.getCollisionBoundingBox().maxY) / 2, target.getPosZ() + 0.5, 0, 0, 0);
        }
        return super.hitEntity(stack, target, attacker);
    }
}
