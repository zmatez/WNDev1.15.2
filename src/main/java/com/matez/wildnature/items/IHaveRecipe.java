package com.matez.wildnature.items;

import com.matez.wildnature.Main;
import com.matez.wildnature.items.recipes.KnifeCrafting;
import com.matez.wildnature.items.tier.WNItemTier;
import com.matez.wildnature.lists.WNItems;
import net.java.games.input.Keyboard;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.list.KeyBindingList;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.settings.KeyBindingMap;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static com.matez.wildnature.commands.RecipeCommand.checkIngredients;
public class IHaveRecipe {

    public static void addInformation(Item clazz,ItemStack itemStackInfo, @Nullable World world, List<ITextComponent> tooltips, ITooltipFlag tooltipFlag) {
        if(Main.canShowAdvancedTooltip) {
            if (world != null) {
                ArrayList<ArrayList<ItemStack>> stacks = checkIngredients(world, new ItemStack(clazz, 1));
                int x = 0;
                for (ArrayList<ItemStack> stack : stacks) {
                    x++;
                    StringTextComponent sr = new StringTextComponent(TextFormatting.LIGHT_PURPLE + itemStackInfo.getDisplayName().getFormattedText());

                    ITextComponent tooltip1 = (new StringTextComponent("").appendSibling(new StringTextComponent(TextFormatting.GRAY + "Recipe " + x + "/" + stacks.size())));
                    tooltips.add(tooltip1);
                    int i = 0;
                    ItemStack tool = ItemStack.EMPTY;
                    for (ItemStack itemStack : stack) {
                        if (itemStack.getItem() instanceof CookingItem || itemStack.getItem() instanceof CookingItem || itemStack.getItem()==Item.getItemFromBlock(Blocks.CRAFTING_TABLE) || itemStack.getItem()==Item.getItemFromBlock(Blocks.STONE)) {
                            tool = itemStack.copy();
                        } else {
                            i++;
                            StringTextComponent si = new StringTextComponent(TextFormatting.DARK_GREEN + itemStack.getDisplayName().getFormattedText());

                            ITextComponent tooltip2 = (new StringTextComponent(TextFormatting.GRAY + "- ")
                                    .appendSibling(new StringTextComponent(TextFormatting.DARK_GREEN + "").appendSibling(si).appendSibling(new StringTextComponent(TextFormatting.DARK_AQUA + " x" + itemStack.getCount()))));
                            tooltips.add(tooltip2);
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
                            ITextComponent cook = (new StringTextComponent(TextFormatting.GRAY + "Craft it in "+TextFormatting.YELLOW+Item.getItemFromBlock(Blocks.CRAFTING_TABLE).getDisplayName(new ItemStack(Blocks.CRAFTING_TABLE,1)).getFormattedText()));
                            tooltips.add(cook);
                        }else {
                            ITextComponent cook = (new StringTextComponent(TextFormatting.GRAY + "Cook it using ").appendSibling(st));
                            tooltips.add(cook);
                        }
                    }
                }

                if (stacks.isEmpty()) {
                    if(itemStackInfo.getItem()== WNItems.GARLIC_CLOVES){
                        ITextComponent unable = (new StringTextComponent("").appendSibling(new StringTextComponent(TextFormatting.GRAY+ "Chop "+TextFormatting.WHITE + WNItems.GARLIC.getDisplayName(new ItemStack(WNItems.GARLIC,1)).getFormattedText() + TextFormatting.GRAY + " using " + TextFormatting.WHITE + WNItems.CHEF_KNIFE.getDisplayName(new ItemStack(WNItems.CHEF_KNIFE,1)).getFormattedText())));
                        tooltips.add(unable);
                    }else if(itemStackInfo.getItem()== WNItems.SLICED_BREAD){
                        ITextComponent unable = (new StringTextComponent("").appendSibling(new StringTextComponent(TextFormatting.GRAY+ "Chop "+TextFormatting.WHITE + Items.BREAD.getDisplayName(new ItemStack(Items.BREAD,1)).getFormattedText() + TextFormatting.GRAY + " using " + TextFormatting.WHITE + WNItems.CHEF_KNIFE.getDisplayName(new ItemStack(WNItems.CHEF_KNIFE,1)).getFormattedText())));
                        tooltips.add(unable);
                    }else if(itemStackInfo.getItem()== WNItems.CHOPPED_CHIVES){
                        ITextComponent unable = (new StringTextComponent("").appendSibling(new StringTextComponent(TextFormatting.GRAY+ "Chop "+TextFormatting.WHITE + WNItems.CHIVES.getDisplayName(new ItemStack(WNItems.CHIVES,1)).getFormattedText() + TextFormatting.GRAY + " using " + TextFormatting.WHITE + WNItems.CHEF_KNIFE.getDisplayName(new ItemStack(WNItems.CHEF_KNIFE,1)).getFormattedText())));
                        tooltips.add(unable);
                    }else if(itemStackInfo.getItem()== WNItems.BACON_BITS){
                        ITextComponent unable = (new StringTextComponent("").appendSibling(new StringTextComponent(TextFormatting.GRAY+ "Chop "+TextFormatting.WHITE + WNItems.COOKED_BACON.getDisplayName(new ItemStack(WNItems.COOKED_BACON,1)).getFormattedText() + TextFormatting.GRAY + " using " + TextFormatting.WHITE + WNItems.CHEF_KNIFE.getDisplayName(new ItemStack(WNItems.CHEF_KNIFE,1)).getFormattedText())));
                        tooltips.add(unable);
                    }else if(itemStackInfo.getItem()== WNItems.LEMON_WEDGE){
                        ITextComponent unable = (new StringTextComponent("").appendSibling(new StringTextComponent(TextFormatting.GRAY+ "Chop "+TextFormatting.WHITE + WNItems.LEMON.getDisplayName(new ItemStack(WNItems.LEMON,1)).getFormattedText() + TextFormatting.GRAY + " using " + TextFormatting.WHITE + WNItems.CHEF_KNIFE.getDisplayName(new ItemStack(WNItems.CHEF_KNIFE,1)).getFormattedText())));
                        tooltips.add(unable);
                    }else if(itemStackInfo.getItem()== WNItems.RAW_BACON){
                        ITextComponent unable = (new StringTextComponent("").appendSibling(new StringTextComponent(TextFormatting.GRAY+ "Chop "+TextFormatting.WHITE + Items.PORKCHOP.getDisplayName(new ItemStack(Items.PORKCHOP,1)).getFormattedText() + TextFormatting.GRAY + " using " + TextFormatting.WHITE + WNItems.CHEF_KNIFE.getDisplayName(new ItemStack(WNItems.CHEF_KNIFE,1)).getFormattedText())));
                        tooltips.add(unable);
                    }else if(itemStackInfo.getItem()== WNItems.DRIED_MUSHROOM_MIX){
                        ITextComponent unable = (new StringTextComponent("").appendSibling(new StringTextComponent(TextFormatting.GRAY+ "Cook "+TextFormatting.WHITE + WNItems.MUSHROOM_MIX.getDisplayName(new ItemStack(WNItems.DRIED_MUSHROOM_MIX,1)).getFormattedText() + TextFormatting.GRAY + " in " + TextFormatting.WHITE + Item.getItemFromBlock(Blocks.SMOKER).getDisplayName(new ItemStack(Item.getItemFromBlock(Blocks.SMOKER),1)).getFormattedText())));
                        tooltips.add(unable);
                    }else if(itemStackInfo.getItem()== WNItems.TOAST){
                        ITextComponent unable = (new StringTextComponent("").appendSibling(new StringTextComponent(TextFormatting.GRAY+ "Cook "+TextFormatting.WHITE + WNItems.SLICED_BREAD.getDisplayName(new ItemStack(WNItems.SLICED_BREAD,1)).getFormattedText() + TextFormatting.GRAY + " in " + TextFormatting.WHITE + Item.getItemFromBlock(Blocks.SMOKER).getDisplayName(new ItemStack(Item.getItemFromBlock(Blocks.SMOKER),1)).getFormattedText())));
                        tooltips.add(unable);
                    }else {
                        ITextComponent unable = (new StringTextComponent("").appendSibling(new StringTextComponent(TextFormatting.RED + "Recipes not found")));
                        tooltips.add(unable);
                    }

                }

            }
        }else{
            StringTextComponent s = new StringTextComponent(TextFormatting.GRAY + ""+TextFormatting.ITALIC+"Hold SHIFT to show recipes");
            tooltips.add(s);

        }
    }

}
