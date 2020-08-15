package com.matez.wildnature.items;

import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class PsylocybinShroomItem extends BlockItem {


    public PsylocybinShroomItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote) {
            entityLiving.addPotionEffect(new EffectInstance(Effects.NAUSEA, Utilities.rint(50, 600), 1, true, false));
            entityLiving.addPotionEffect(new EffectInstance(Effects.SLOWNESS, Utilities.rint(90, 300), Utilities.rint(0,2), true, false));
            entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, Utilities.rint(90, 300), Utilities.rint(0,2), true, false));
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);

    }
}
