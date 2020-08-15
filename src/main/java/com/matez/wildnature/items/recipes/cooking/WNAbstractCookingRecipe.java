package com.matez.wildnature.items.recipes.cooking;

import com.matez.wildnature.Main;
import com.matez.wildnature.commands.RecipeCommand;
import com.matez.wildnature.items.recipes.PotCrafting;
import com.matez.wildnature.other.Utilities;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class WNAbstractCookingRecipe implements IRecipe<IInventory> {
   protected final IRecipeType<?> type;
   protected final ResourceLocation id;
   public String group;
   public Ingredient ingredient;
   public ItemStack result;
   public float experience;
   public int cookTime;

   public WNAbstractCookingRecipe(IRecipeType<?> typeIn, ResourceLocation idIn, String groupIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {
      this.type = typeIn;
      this.id = idIn;
      this.group = groupIn;
      this.ingredient = ingredientIn;
      this.result = resultIn;
      this.experience = experienceIn;
      this.cookTime = cookTimeIn;
   }

   public boolean matches(IInventory inv, World worldIn) {
      return checkMatching(new ArrayList<ItemStack>(((Inventory)inv).inventoryContents),ingredient,worldIn);
   }

   public boolean checkMatching(ArrayList<ItemStack> stacks, Ingredient i, World world){
      boolean ok = true;
      int matching = 0;
      if(stacks.isEmpty()){
         return false;
      }




      int d = 0;
      for (ItemStack stack : stacks) {
         if(!checkForMatch(stack,i,stacks)){
            ok=false;
         }else{
            matching++;
         }

      }



      if(PotCrafting.SimpleItemStack.sumLists(new ArrayList<>(Arrays.asList(i.matchingStacks)),new ArrayList<>()).size()>=9){
         return false;
      }

      if(PotCrafting.SimpleItemStack.sumLists(new ArrayList<>(Arrays.asList(i.matchingStacks)),new ArrayList<>()).size()!=matching){
         return false;
      }

      /*ArrayList<ArrayList<ItemStack>> sc = RecipeCommand.checkIngredients(world,this.result.copy());
      for (ArrayList<ItemStack> itemStacks : sc) {
         for (ItemStack itemStack : itemStacks) {
            if(itemStack.getItem()==)
         }
      }*/




      return ok;
   }

   public static ArrayList<Item> convertItemStackListToItemList(ItemStack[] stacks){
      ArrayList<Item> items = new ArrayList<>();
      for (ItemStack stack : stacks) {
         int count = stack.getCount();
         for(int i = 0; i<count; i++){
            items.add(stack.getItem());
         }
      }
      return items;
   }

   public boolean checkForMatch(@Nullable ItemStack itemStack, Ingredient i, ArrayList<ItemStack> stacks) {
      if (itemStack == null) {
         return false;
      } else if (i.acceptedItems.length == 0) {
         return itemStack.isEmpty();
      } else {
         determineMatchingStacks(i);

         boolean ok = true;

         if(i.matchingStacks.length==0){
            return false;
         }


         ArrayList<PotCrafting.SimpleItemStack> s = PotCrafting.SimpleItemStack.sumLists(new ArrayList<>(Arrays.asList(i.matchingStacks)),new ArrayList<>());

         ArrayList<ItemStack> resultIngredients = new ArrayList<>();
         for (PotCrafting.SimpleItemStack simpleItemStack : s) {
            resultIngredients.add(new ItemStack(simpleItemStack.getItem(),simpleItemStack.getCount()));
         }

         for(ItemStack itemstack : resultIngredients) {
            if (itemstack.getItem() == itemStack.getItem() && (itemStack.getCount())==itemstack.getCount()) {
               return ok;
            }

         }

         i.matchingStacks=resultIngredients.toArray(new ItemStack[resultIngredients.size()]);


         return false;

      }
   }

   private void determineMatchingStacks(Ingredient i) {
      if (i.matchingStacks == null) {
         i.matchingStacks = Arrays.stream(i.acceptedItems).flatMap((p_209359_0_) -> {
            return p_209359_0_.getStacks().stream();
         }).distinct().toArray((p_209358_0_) -> {
            return new ItemStack[p_209358_0_];
         });
      }

   }

   public ItemStack getCraftingResult(IInventory inv) {
      return this.result.copy();
   }

   /**
    * Used to determine if this recipe can fit in a grid of the given width/height
    */
   public boolean canFit(int width, int height) {
      return true;
   }

   public NonNullList<Ingredient> getIngredients() {
      NonNullList<Ingredient> nonnulllist = NonNullList.create();
      nonnulllist.add(this.ingredient);
      return nonnulllist;
   }

   /**
    * Gets the experience of this recipe
    */
   public float getExperience() {
      return this.experience;
   }

   /**
    * Get the result of this recipe, usually for display purposes (e.g. recipe book). If your recipe has more than one
    * possible result (e.g. it's dynamic and depends on its inputs), then return an empty stack.
    */
   public ItemStack getRecipeOutput() {
      return this.result;
   }

   /**
    * Recipes with equal group are combined into one button in the recipe book
    */
   public String getGroup() {
      return this.group;
   }

   /**
    * Gets the cook time in ticks
    */
   public int getCookTime() {
      return this.cookTime;
   }

   public ResourceLocation getId() {
      return this.id;
   }

   public IRecipeType<?> getType() {
      return this.type;
   }
}