package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import com.matez.wildnature.items.CookingItem;
import com.matez.wildnature.items.recipes.PotCrafting;
import com.matez.wildnature.items.recipes.cooking.WNAbstractCookingRecipe;
import com.matez.wildnature.items.recipes.cooking.WNCookingRecipe;
import com.matez.wildnature.lists.WNItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeCommand {

    public int recipe(ServerPlayerEntity p, ItemStack item){
        ArrayList<ArrayList<ItemStack>> stacks = checkIngredients(p.getEntityWorld(),item);
        int x = 0;
        for (ArrayList<ItemStack> stack : stacks) {
            x++;
            StringTextComponent sr = new StringTextComponent(TextFormatting.LIGHT_PURPLE + item.getDisplayName().getFormattedText());
            sr.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM,new StringTextComponent(item.write(new CompoundNBT()).toString())));

            Main.sendChatMessage(p,new StringTextComponent("")
                    .appendSibling(Main.WNPrefix).appendSibling(new StringTextComponent(TextFormatting.GREEN+"Recipe " + x+ "/" + stacks.size()))
                    .appendSibling(new StringTextComponent(TextFormatting.GRAY+"  - - -  "))
                    .appendSibling(new StringTextComponent(TextFormatting.LIGHT_PURPLE+ "").appendSibling(sr).appendSibling(new StringTextComponent(" " + TextFormatting.DARK_PURPLE+"x"+item.getCount()))));

            int i = 0;
            ItemStack tool = ItemStack.EMPTY;
            for (ItemStack itemStack : stack) {
                if(itemStack.getItem() instanceof CookingItem || itemStack.getItem()==Item.getItemFromBlock(Blocks.CRAFTING_TABLE) || itemStack.getItem()==Item.getItemFromBlock(Blocks.STONE)){
                    tool=itemStack.copy();
                }else {
                    i++;
                    StringTextComponent si = new StringTextComponent(TextFormatting.DARK_GREEN + itemStack.getDisplayName().getFormattedText());
                    si.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM,new StringTextComponent(itemStack.write(new CompoundNBT()).toString())));

                    Main.sendChatMessage(p, new StringTextComponent(TextFormatting.GRAY + "[" + i + "] ")
                            .appendSibling(new StringTextComponent(TextFormatting.DARK_GREEN + "").appendSibling(si).appendSibling(new StringTextComponent(TextFormatting.DARK_AQUA + " x" + itemStack.getCount()))));
                }
            }
            if(!tool.isEmpty()) {
                StringTextComponent st = new StringTextComponent(TextFormatting.GOLD + tool.getDisplayName().getFormattedText());
                if(tool.getItem()==Item.getItemFromBlock(Blocks.STONE) || tool.isEmpty()){
                    st = new StringTextComponent(TextFormatting.RED+"unknown");
                }  else {
                    st.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM, new StringTextComponent(tool.write(new CompoundNBT()).toString())));
                }
                if (tool.getItem() == Item.getItemFromBlock(Blocks.CRAFTING_TABLE)) {
                    Main.sendChatMessage(p, new StringTextComponent(TextFormatting.GRAY + "Craft it in " + TextFormatting.YELLOW+Item.getItemFromBlock(Blocks.CRAFTING_TABLE).getDisplayName(new ItemStack(Blocks.CRAFTING_TABLE,1)).getFormattedText()));
                }else {
                    Main.sendChatMessage(p, new StringTextComponent(TextFormatting.GRAY + "Cook it using ").appendSibling(st));
                }
            }

            Main.sendChatMessage(p,new StringTextComponent(TextFormatting.DARK_GRAY+"----------------------------------"));
        }

        if(stacks.isEmpty()){
            Main.sendChatMessage(p,new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(new StringTextComponent(TextFormatting.RED+"Unable to find recipes for " + TextFormatting.GOLD+item.getDisplayName().getFormattedText()+" x" +item.getCount()+TextFormatting.RED+".")));


        }

        return x!=0? 0 : 1;
    }
    private static Item item;
    public static ArrayList<ArrayList<ItemStack>> checkIngredients(World world, ItemStack result){
        ArrayList<IRecipe<?>> recipe = new ArrayList<>(world.getRecipeManager().getRecipes());
        ArrayList<ArrayList<ItemStack>> stacks = new ArrayList<>();
        item = null;
        for (IRecipe<?> iRecipe : recipe) {
            if(iRecipe instanceof WNAbstractCookingRecipe){
                WNAbstractCookingRecipe r = (WNAbstractCookingRecipe) iRecipe;
                if(r.getRecipeOutput().getItem()==result.getItem()){
                    ArrayList<ItemStack> rcipe = new ArrayList<>();
                    for (Ingredient ingredient : r.getIngredients()) {
                        rcipe.addAll(Arrays.asList(ingredient.getMatchingStacks()));
                    }
                    ArrayList<PotCrafting.SimpleItemStack> s = PotCrafting.SimpleItemStack.sumLists(rcipe,new ArrayList<>());
                    ArrayList<ItemStack> fromSimple = new ArrayList<>();
                    for (PotCrafting.SimpleItemStack simpleItemStack : s) {
                        fromSimple.add(new ItemStack(simpleItemStack.getItem(),simpleItemStack.getCount()));
                    }

                    if(iRecipe instanceof WNCookingRecipe){
                        if(CookingItem.getGroupParams(r.getGroup())[0].equals("pot")){
                            item=WNItems.POT_WATER;
                        }else if(CookingItem.getGroupParams(r.getGroup())[0].equals("frying_pan")){
                            item=WNItems.FRYING_PAN;
                        }else if(CookingItem.getGroupParams(r.getGroup())[0].equals("cake_pan")){
                            item=WNItems.CAKE_PAN;
                        }else{
                            item=Item.getItemFromBlock(Blocks.STONE);
                        }

                        fromSimple.add(new ItemStack(item,1));
                    }
                    stacks.add(fromSimple);


                }
            }
            if(iRecipe instanceof ShapelessRecipe){
                ShapelessRecipe r = (ShapelessRecipe)iRecipe;
                if(r.getRecipeOutput().getItem()==result.getItem()){
                    ArrayList<ItemStack> rcipe = new ArrayList<>();
                    for (Ingredient ingredient : r.getIngredients()) {
                        rcipe.addAll(Arrays.asList(ingredient.getMatchingStacks()));
                    }
                    ArrayList<PotCrafting.SimpleItemStack> s = PotCrafting.SimpleItemStack.sumLists(rcipe,new ArrayList<>());
                    ArrayList<ItemStack> fromSimple = new ArrayList<>();
                    for (PotCrafting.SimpleItemStack simpleItemStack : s) {
                        fromSimple.add(new ItemStack(simpleItemStack.getItem(),simpleItemStack.getCount()));
                    }

                    item= Items.CRAFTING_TABLE;

                    fromSimple.add(new ItemStack(item,1));

                    stacks.add(fromSimple);


                }
            }
        }
        return stacks;
    }
}
