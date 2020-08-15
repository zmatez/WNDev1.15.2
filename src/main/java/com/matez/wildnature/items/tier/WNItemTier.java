package com.matez.wildnature.items.tier;

import com.matez.wildnature.lists.WNItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum WNItemTier implements IItemTier {
    KITCHEN_TOOLS(1, 200, 1F, 1.5F, 1, () -> {
        return Ingredient.fromItems(Items.IRON_INGOT);
    }),
    BRONZE(2, 250, 7F, 2.5F, 20, () -> {
        return Ingredient.fromItems(WNItems.BRONZE_INGOT);
    }),
    AMETHYST(3, 1337, 7.5F, 4F, 7, () -> {
        return Ingredient.fromItems(WNItems.AMETHYST_CRYSTAL);
    }),
    SAPPHIRE(3, 2200, 8.5F, 5F, 8, () -> {
        return Ingredient.fromItems(WNItems.SAPPHIRE_CRYSTAL);
    }),
    MALACHITE(4, 1410, 9.5F, 6F, 10, () -> {
        return Ingredient.fromItems(WNItems.MALACHITE_CRYSTAL);
    }),
    SILVER(4, 1989, 11F, 5F, 12, () -> {
        return Ingredient.fromItems(WNItems.SILVER_INGOT);
    }),
    AMBER(2, 510, 13F, 5F, 30, () -> {
        return Ingredient.fromItems(WNItems.AMBER_CRYSTAL);
    }),
    RUBY(5, 1234, 12F, 9F, 20, () -> {
        return Ingredient.fromItems(WNItems.RUBY_CRYSTAL);
    });


    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private WNItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public float getEfficiency() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
