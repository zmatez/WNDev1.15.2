package com.matez.wildnature.items;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

public class AlcoItem extends DrinkItem {
    public AlcoItem(Properties builder, String onEmpty) {
        super(builder, onEmpty);
    }

    public AlcoItem(Properties builder, String onEmpty, boolean ignore) {
        super(builder, onEmpty, ignore);
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        super.onItemUseFinish(stack,worldIn,entityLiving);

        if (!worldIn.isRemote) {
            entityLiving.addPotionEffect(new EffectInstance(Effects.NAUSEA, Utilities.rint(300, 600), Utilities.rint(0,5), true, false));
            entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, Utilities.rint(90, 300), Utilities.rint(0,2), true, false));
            entityLiving.addPotionEffect(new EffectInstance(Effects.WEAKNESS, Utilities.rint(90, 300), Utilities.rint(0,2), true, false));


        }
        if (entityLiving instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)entityLiving;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
            serverplayerentity.addStat(Stats.ITEM_USED.get(this));
        }

        if (entityLiving instanceof PlayerEntity && !((PlayerEntity)entityLiving).abilities.isCreativeMode) {
            stack.shrink(1);
        }

        if (!worldIn.isRemote) {
            entityLiving.addPotionEffect(new EffectInstance(Effects.NAUSEA, Utilities.rint(300, 600), Utilities.rint(0,5), true, false));
            entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, Utilities.rint(90, 300), Utilities.rint(0,2), true, false));
            entityLiving.addPotionEffect(new EffectInstance(Effects.WEAKNESS, Utilities.rint(90, 300), Utilities.rint(0,2), true, false));

        }

        return stack.isEmpty() ? new ItemStack(Main.getItemByID(onEmpty)) : stack;
    }
}
