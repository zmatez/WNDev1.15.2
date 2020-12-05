package com.matez.wildnature.common.compatibility;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameters;

public class WNLoot {
    public static boolean isBrokenByPickaxe(LootContext.Builder builder){
        ItemStack i = builder.get(LootParameters.TOOL);
        if(i!=null){
            return i.getItem() instanceof PickaxeItem;
        }
        return false;
    }
    public static boolean isSilkTouch(LootContext.Builder builder){
        ItemStack i = builder.get(LootParameters.TOOL);
        if(i != null) {
            int level = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, i);
            if (level != 0) {
                return true;
            }
        }
        return false;
    }

    public static int getFortune(LootContext.Builder builder){
        ItemStack i = builder.get(LootParameters.TOOL);
        return  EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,i);
    }
}
