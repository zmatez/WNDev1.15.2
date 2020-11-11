package com.matez.wildnature.common.items.tier;

import com.matez.wildnature.util.lists.WNItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum WNItemTier implements IItemTier {
    KITCHEN_TOOLS(1, 200, 1F, 2F, 1, () -> {
        return Ingredient.fromItems(Items.IRON_INGOT);
    }),
    BRONZE(3, 350, 7F, 2F, 12, () -> {
        return Ingredient.fromItems(WNItems.BRONZE_INGOT);
    }),
    STEEL(2, 825, 7F, 4F, 10, () -> {
        return Ingredient.fromItems(WNItems.STEEL_INGOT);
    }),
    SILVER(3, 500, 7F, 3.2F, 15, () -> {
        return Ingredient.fromItems(WNItems.SILVER_INGOT);
    }),
    SAPPHIRE(4, 1200, 9F, 5F, 10, () -> {
        return Ingredient.fromItems(WNItems.SAPPHIRE_INGOT);
    }),
    RUBY(4, 1200, 9F, 5F, 15, () -> {
        return Ingredient.fromItems(WNItems.RUBY_INGOT);
    }),
    MALACHITE(4, 1900, 10F, 6F, 18, () -> {
        return Ingredient.fromItems(WNItems.MALACHITE_INGOT);
    }),
    AMETHYST(5, 2250, 12F, 7F, 25, () -> {
        return Ingredient.fromItems(WNItems.AMETHYST_INGOT);
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
