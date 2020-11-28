package com.matez.wildnature.common.effect;

import com.matez.wildnature.common.damage.WNDamageSource;
import com.matez.wildnature.init.WN;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

public class WNEffect extends Effect {
    public WNEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        if(this == WNEffects.IVY_POISON){
            if (entityLivingBaseIn.getHealth() > 1.0F || amplifier >= 1) {
                entityLivingBaseIn.attackEntityFrom(WNDamageSource.POISON_IVY, 1.0F);
            }
        }else if(this == WNEffects.SHROOM_POISON){
            if (entityLivingBaseIn.getHealth() > 1.0F || amplifier >= 1) {
                entityLivingBaseIn.attackEntityFrom(WNDamageSource.POISON_SHROOM, 1.0F);
            }
        }else if(this == WNEffects.MONKSHOOD_POISON){
            entityLivingBaseIn.attackEntityFrom(WNDamageSource.MONKSHOOD_BLUE, 2.0F);
        }else if(this == WNEffects.BELLADONNA_POISON){
            entityLivingBaseIn.attackEntityFrom(WNDamageSource.BELLADONNA, 1F);
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        if (this == WNEffects.IVY_POISON || this == WNEffects.SHROOM_POISON) {
            int j = 25 >> amplifier;
            if (j > 0) {
                return duration % j == 0;
            } else {
                return true;
            }
        }else if (this == WNEffects.MONKSHOOD_POISON || this == WNEffects.BELLADONNA_POISON) {
            int i = 40 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}
