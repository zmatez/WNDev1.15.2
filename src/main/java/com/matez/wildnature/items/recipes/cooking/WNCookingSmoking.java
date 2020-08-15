package com.matez.wildnature.items.recipes.cooking;

import com.matez.wildnature.items.CookingItem;
import com.matez.wildnature.items.recipes.special.SpecialSmelting;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class WNCookingSmoking extends SpecialSmelting {
    public WNCookingSmoking(ResourceLocation p_i48715_1_) {
        super(p_i48715_1_, "smoking",Ingredient.fromItems(WNItems.POT_WATER),new ItemStack(WNItems.POT_EMPTY,1),1f,150);
    }
    private World w;

    @Override
    public boolean matches(IInventory inventory, World world) {
        if(inventory.getStackInSlot(0).getItem() instanceof CookingItem) {
            WNAbstractCookingRecipe recipe = CookingItem.checkForRecipes(world, Utilities.loadItems(inventory.getStackInSlot(0).getOrCreateTag()),((CookingItem)inventory.getStackInSlot(0).getItem()).getToolType());
            w = world;
            if(recipe!=null && recipe.ingredient!=null && recipe.result!=null) {
                //ingredient = recipe.ingredient;
                result = getCraftingResult(inventory).copy();

            }
            return recipe != null && recipe.getRecipeOutput() != null;
        }else{
            return false;
        }
    }

    @Override
    public ItemStack getCraftingResult(IInventory inventory) {
        ItemStack s = inventory.getStackInSlot(0).copy();
        if(s.getItem() instanceof CookingItem) {
            WNAbstractCookingRecipe recipe = CookingItem.checkForRecipes(w, Utilities.loadItems(inventory.getStackInSlot(0).getOrCreateTag()),((CookingItem)inventory.getStackInSlot(0).getItem()).getToolType());
            if (recipe == null) {
                return ItemStack.EMPTY;
            } else {
                ItemStack output = recipe.getRecipeOutput().copy();
                CompoundNBT nbt = s.getOrCreateTag();

                if (nbt.contains("Items")) {
                    nbt.remove("Items");
                }
                if (nbt.contains("Slot")) {
                    nbt.remove("Slot");
                }

                Utilities.saveItem(nbt,output);
                nbt.putBoolean("cooked",true);
                nbt.putString("fill",CookingItem.getGroupParams(recipe.getGroup())[1]);
                ItemStack r = s.copy();
                r.setTag(nbt);
                return r;
            }
        }else{
            return ItemStack.EMPTY;
        }
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return Registry.RECIPE_SERIALIZER.getOrDefault(new ResourceLocation("wildnature:smoker_cooking"));
    }


}
