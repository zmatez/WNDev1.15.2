package com.matez.wildnature.common.damage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;

import javax.annotation.Nullable;

public class WNDamageSource{
    public static final DamageSource QUICKSAND = (new DamageSource("quicksand")).setDamageBypassesArmor();
    public static final DamageSource MUD = (new DamageSource("mud")).setDamageBypassesArmor();
    public static final DamageSource POISON_IVY = (new DamageSource("poisonIvy")).setDamageBypassesArmor();
    public static final DamageSource THISTLE = (new DamageSource("thistle")).setDamageBypassesArmor();
    public static final DamageSource NETTLE = (new DamageSource("nettle")).setDamageBypassesArmor();
    public static final DamageSource POISON_SHROOM = (new DamageSource("poison_shroom")).setDamageBypassesArmor();
    public static final DamageSource MONKSHOOD_BLUE = (new DamageSource("monkshood_blue")).setDamageBypassesArmor();
    public static final DamageSource BELLADONNA = (new DamageSource("belladonna")).setDamageBypassesArmor();

    public static DamageSource causeArrowDamage(Entity arrow, @Nullable Entity indirectEntityIn) {
        return (new IndirectEntityDamageSource("arrow", arrow, indirectEntityIn)).setProjectile();
    }
}
