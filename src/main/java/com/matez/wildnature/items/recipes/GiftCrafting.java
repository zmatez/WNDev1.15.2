package com.matez.wildnature.items.recipes;

import com.matez.wildnature.items.GiftItem;
import com.matez.wildnature.other.Utilities;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class GiftCrafting extends SpecialRecipe {

    public GiftCrafting(ResourceLocation idIn) {
        super(idIn);
    }

    public boolean matches(CraftingInventory inv, World worldIn) {
        int i = 0;
        int j = 0;
        for(int k = 0; k < inv.getSizeInventory(); ++k) {
            ItemStack itemstack = inv.getStackInSlot(k);
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem() instanceof GiftItem) {
                    if(itemstack.getOrCreateTag().isEmpty()) {
                        ++i;
                    }
                } else {
                    ++j;
                }

                if (j > 1 || i > 1) {
                    return false;
                }
            }
        }

        return i == 1 && j == 1;
    }

    public ItemStack getCraftingResult(CraftingInventory inv) {
        ItemStack giftItemStack = ItemStack.EMPTY;
        ItemStack gift = ItemStack.EMPTY;



        for(int i = 0; i < inv.getSizeInventory(); ++i) {
            ItemStack itemstack1 = inv.getStackInSlot(i);
            if (!itemstack1.isEmpty()) {
                Item item = itemstack1.getItem();
                if (item instanceof GiftItem) {
                    giftItemStack = itemstack1;
                } else {
                    gift = itemstack1;
                }
            }
        }

        ItemStack result = new ItemStack(giftItemStack.getItem());
        CompoundNBT nbt = giftItemStack.getOrCreateTag();
        if(nbt.isEmpty() && !giftItemStack.isEmpty() && !gift.isEmpty()) {
            Utilities.saveItem(nbt, new ItemStack(gift.getItem()));
            result.setTag(nbt);
            giftItemStack.setTag(new CompoundNBT());
        }else{
            return null;
        }

        return result;
    }

    public boolean canFit(int width, int height) {
        return width * height >= 2;
    }


    @Override
    public IRecipeSerializer<?> getSerializer() {
        return Registry.RECIPE_SERIALIZER.getOrDefault(new ResourceLocation("wildnature:gift_crafting"));
    }
}
