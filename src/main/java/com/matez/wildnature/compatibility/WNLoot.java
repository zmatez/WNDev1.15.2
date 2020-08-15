package com.matez.wildnature.compatibility;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.ListNBT;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameters;

public class WNLoot {

    public static boolean isSilkTouch(LootContext.Builder builder){
        ItemStack i = builder.get(LootParameters.TOOL);
        int level = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH,i);
        if(level!=0){
            return true;
        }
        return false;
    }

    public static int getFortune(LootContext.Builder builder){
        ItemStack i = builder.get(LootParameters.TOOL);
        return  EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,i);
    }
}
