package com.matez.wildnature.items.recipes;

import com.matez.wildnature.Main;
import com.matez.wildnature.items.CookingItem;
import com.matez.wildnature.items.GiftItem;
import com.matez.wildnature.items.recipes.cooking.WNAbstractCookingRecipe;
import com.matez.wildnature.items.recipes.cooking.WNCookingRecipe;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.*;

public class PotCrafting extends SpecialRecipe {

    public PotCrafting(ResourceLocation idIn) {
        super(idIn);
    }
    private boolean matching = true;
    public boolean matches(CraftingInventory inv, World worldIn) {
        matching=true;
        int i = 0;
        int j = 0;
        for(int k = 0; k < inv.getSizeInventory(); ++k) {
            ItemStack itemstack = inv.getStackInSlot(k);
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem() instanceof CookingItem) {
                    ++i;
                } else {
                    ++j;
                }

                if (i > 1) {
                    return false;
                }

                if(!(itemstack.getItem() instanceof CookingItem)) {

                    Collection<IRecipe<?>> recipe = worldIn.getRecipeManager().getRecipes();
                    ArrayList<Item> allMatchingItems = new ArrayList<>();
                    for (IRecipe<?> r : recipe) {
                        if (r instanceof WNCookingRecipe) {
                            for(ItemStack s : ((WNCookingRecipe)r).ingredient.getMatchingStacks()){
                                allMatchingItems.add(s.getItem());
                            }
                        }
                    }

                    if(!allMatchingItems.contains(itemstack.getItem())){
                        return false;
                    }
                }
            }
        }



        return i == 1 && j >= 1;
    }

    public ItemStack getCraftingResult(CraftingInventory inv) {
        ItemStack pot = ItemStack.EMPTY;
        ArrayList<ItemStack> newIngredients = new ArrayList<>();

        for(int i = 0; i < inv.getSizeInventory(); ++i) {
            ItemStack itemstack1 = inv.getStackInSlot(i);
            if (!itemstack1.isEmpty()) {
                Item item = itemstack1.getItem();
                if (item instanceof CookingItem) {
                    pot = itemstack1;
                } else {
                    newIngredients.add(itemstack1);
                }
            }
        }

        CompoundNBT nbt = pot.copy().getOrCreateTag();
        ArrayList<ItemStack> ingredients = Utilities.loadItems(nbt);

        ArrayList<SimpleItemStack> s = SimpleItemStack.sumLists(ingredients,newIngredients);

        ArrayList<ItemStack> resultIngredients = new ArrayList<>();
        for (SimpleItemStack simpleItemStack : s) {
            resultIngredients.add(new ItemStack(simpleItemStack.getItem(),simpleItemStack.getCount()));
        }


        ItemStack result = pot.copy();
        Utilities.saveItems(nbt,resultIngredients);
        result.setTag(nbt);
        return result;
    }

    public boolean canFit(int width, int height) {
        return width * height >= 2;
    }


    @Override
    public IRecipeSerializer<?> getSerializer() {
        return Registry.RECIPE_SERIALIZER.getOrDefault(new ResourceLocation("wildnature:pot_crafting"));
    }

    public static class SimpleItemStack{
        private Item item;
        private int count;
        public SimpleItemStack(Item item, int count){
            this.item=item;
            this.count=count;
        }

        public int getCount() {
            return count;
        }

        public Item getItem() {
            return item;
        }

        public static ArrayList<SimpleItemStack> sumLists(ArrayList<ItemStack> a1, ArrayList<ItemStack> a2){

            ArrayList<SimpleItemStack> x1 = new ArrayList<>();
            for (ItemStack newIngredient : a1) {
                x1.add(new SimpleItemStack(newIngredient.getItem(),newIngredient.getCount()));
            }
            ArrayList<SimpleItemStack> x2 = new ArrayList<>();
            for (ItemStack ingredient : a2) {
                x2.add(new SimpleItemStack(ingredient.getItem(),ingredient.getCount()));
            }

            ArrayList<SimpleItemStack> ss = new ArrayList<>();
            ss.addAll(x1);
            ss.addAll(x2);

            ArrayList<Item> rawItemStackList = new ArrayList<>();
            for (SimpleItemStack s : ss) {
                for(int a = 0; a < s.getCount(); a++){
                    rawItemStackList.add(s.getItem());
                }
            }

            ArrayList<SimpleItemStack> sortedList = new ArrayList<>();
            for (Item item : rawItemStackList) {
                boolean duplicate = false;
                for (SimpleItemStack simpleItemStack : sortedList) {
                    if(simpleItemStack.getItem()==item){
                        duplicate=true;
                        break;
                    }
                }
                if(!duplicate) {
                    int occurrences = Collections.frequency(rawItemStackList, item);
                    sortedList.add(new SimpleItemStack(item,occurrences));
                }
            }

            return sortedList;
        }
    }
}
