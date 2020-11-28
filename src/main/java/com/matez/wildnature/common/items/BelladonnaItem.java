package com.matez.wildnature.common.items;

import com.matez.wildnature.common.effect.WNEffects;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class BelladonnaItem extends Item {
    public BelladonnaItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote) {
            entityLiving.addPotionEffect(new EffectInstance(WNEffects.BELLADONNA_POISON, Utilities.rint(50, 450), 0, true, false));
            entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, Utilities.rint(90, 600), Utilities.rint(0,2), true, false));
            entityLiving.addPotionEffect(new EffectInstance(Effects.WEAKNESS, Utilities.rint(90, 600), Utilities.rint(0,2), true, false));
            entityLiving.addPotionEffect(new EffectInstance(Effects.HUNGER, Utilities.rint(50, 500), 1, true, false));
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
