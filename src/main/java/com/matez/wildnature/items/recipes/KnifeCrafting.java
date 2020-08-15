package com.matez.wildnature.items.recipes;

import com.matez.wildnature.items.GiftItem;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class KnifeCrafting extends SpecialRecipe {

    public KnifeCrafting(ResourceLocation idIn) {
        super(idIn);
    }

    public boolean matches(CraftingInventory inv, World worldIn) {
        int i = 0;
        int j = 0;
        for(int k = 0; k < inv.getSizeInventory(); ++k) {
            ItemStack itemstack = inv.getStackInSlot(k);
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem()== WNItems.CHEF_KNIFE) {
                    ++i;
                } else {
                    ++j;
                }

                if ( i > 1 || j>1) {
                    return false;
                }
            }
        }

        return i == 1 && j == 1;
    }

    public ItemStack getCraftingResult(CraftingInventory inv) {
        ItemStack knife = ItemStack.EMPTY;
        ItemStack chopping = ItemStack.EMPTY;
        int knifeSlot = 0;

        for(int i = 0; i < inv.getSizeInventory(); ++i) {
            ItemStack itemstack1 = inv.getStackInSlot(i);
            if (!itemstack1.isEmpty()) {
                Item item = itemstack1.getItem();
                if (item== WNItems.CHEF_KNIFE) {
                    knife = itemstack1;
                    knifeSlot=i;
                } else {
                    chopping = itemstack1;
                }
            }
        }


        ItemStack knifeCopy = new ItemStack(knife.getItem());
        Item chop = chopping.getItem();
        ItemStack item = getValidItem(chop);
        if(item!=null && !knife.isEmpty() && !chopping.isEmpty()){
            CompoundNBT nbt = knife.copy().getOrCreateTag();
            Utilities.saveItem(nbt,new ItemStack(chop));
            knifeCopy.setTag(nbt);
        }

        return knifeCopy;
    }

    public static ItemStack getValidItem(Item chop){
        if(chop== Items.BREAD){
            return new ItemStack(WNItems.SLICED_BREAD,4);
        }
        if(chop== WNItems.GARLIC){
            return new ItemStack(WNItems.GARLIC_CLOVES,2);
        }
        if(chop== WNItems.CHIVES){
            return new ItemStack(WNItems.CHOPPED_CHIVES,2);
        }
        if(chop== WNItems.COOKED_BACON){
            return new ItemStack(WNItems.BACON_BITS,3);
        }
        if(chop== Items.PORKCHOP){
            return new ItemStack(WNItems.RAW_BACON,3);
        }
        if(chop== WNItems.LEMON){
            return new ItemStack(WNItems.LEMON_WEDGE,4);
        }
        return null;
    }

    public boolean canFit(int width, int height) {
        return width * height >= 2;
    }


    @Override
    public IRecipeSerializer<?> getSerializer() {
        return Registry.RECIPE_SERIALIZER.getOrDefault(new ResourceLocation("wildnature:knife_chopping"));
    }
}
