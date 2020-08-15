package com.matez.wildnature.items;

import com.matez.wildnature.Main;
import com.matez.wildnature.items.recipes.cooking.CookingToolType;
import com.matez.wildnature.items.recipes.cooking.FillTool;
import com.matez.wildnature.items.recipes.cooking.WNAbstractCookingRecipe;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CookingItem extends Item {
    private CookingToolType toolType;
    public CookingItem(Properties p_i48487_1_, CookingToolType toolType) {
        super(p_i48487_1_);
        this.toolType=toolType;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        ArrayList<ItemStack> items = Utilities.loadItems(stack.getOrCreateTag());
        int i = 0;
        int j = 0;

        CompoundNBT nbt = stack.getOrCreateTag();
        if(nbt.contains("cooked") && nbt.getBoolean("cooked")){
            ItemStack result = Utilities.loadItem(nbt);
            if(result!=null && !result.isEmpty()) {
                tooltip.add((new StringTextComponent(TextFormatting.GOLD + "Cooked " + TextFormatting.YELLOW + result.getDisplayName().getFormattedText() + " x" + result.getCount())));

                if(nbt.contains("fill")){
                    String fill = nbt.getString("fill");
                    Item fillItem = getFillItem(fill);
                    if(fillItem!=null){
                        tooltip.add((new StringTextComponent(TextFormatting.AQUA + "Filling " + fillItem.getDisplayName(new ItemStack(fillItem,1)).getFormattedText())));
                    }
                }
                tooltip.add((new StringTextComponent(TextFormatting.GREEN + "Right click to get it")));

            }
        }else {

            if (worldIn != null) {
                WNAbstractCookingRecipe recipe = checkForRecipes(worldIn, items,getToolType());
                if (recipe != null) {
                    ItemStack output = recipe.getRecipeOutput();
                    tooltip.add((new StringTextComponent(TextFormatting.GOLD + "Cook now to get " + TextFormatting.YELLOW + output.getDisplayName().getFormattedText() + " x" + output.getCount())));
                }
            } else {
                tooltip.add((new StringTextComponent(TextFormatting.RED + "Cannot get recipes for this world")));
            }


            for (ItemStack itemstack : items) {
                if (!itemstack.isEmpty()) {
                    ++j;
                    if (i <= 4) {
                        ++i;
                        ITextComponent itextcomponent = itemstack.getDisplayName().deepCopy().applyTextStyle(TextFormatting.DARK_GREEN);
                        ITextComponent itextcomponent2 = new StringTextComponent("").appendText(" x").appendText(String.valueOf(itemstack.getCount())).applyTextStyle(TextFormatting.GRAY);
                        tooltip.add(itextcomponent.appendSibling(itextcomponent2));
                    }
                }
            }


            if (j - i > 0) {
                tooltip.add((new TranslationTextComponent("container.shulkerBox.more", j - i)).applyTextStyle(TextFormatting.GRAY).applyTextStyle(TextFormatting.ITALIC));
            }
        }
    }

    private int clickCount = 0;
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        super.onItemRightClick(world,player,hand);
        ItemStack stack = player.getHeldItem(hand);
        CompoundNBT nbt = stack.getOrCreateTag();
        if(nbt.contains("cooked") && nbt.getBoolean("cooked")){

            ItemStack result = Utilities.loadItem(nbt);
            if(result!=null && !result.isEmpty()) {
                if(nbt.contains("fill")){
                    ItemStack need = new ItemStack(getFillItem(nbt.getString("fill")),result.getCount());
                    boolean success = false;
                    if(need.isEmpty() || need==null){
                        success=true;
                        player.addItemStackToInventory(result);
                    }
                    if(!success) {
                        for (int a = 0; a < result.getCount(); a++) {
                            for (int x = 0; x < player.inventory.getSizeInventory(); x++) {
                                ItemStack slot = player.inventory.getStackInSlot(x);
                                if (slot.isItemEqual(need)) {
                                    //checks if player has "need" item
                                    player.addItemStackToInventory(new ItemStack(result.getItem(), 1));//adds e.g milk bucket
                                    slot.setCount(slot.getCount() - 1);//removes 1 from player item
                                    player.inventory.setInventorySlotContents(x, slot);//sets slot
                                    need.setCount(need.getCount() - 1);//removes 1 from needed item
                                    nbt.remove("fill");
                                    success = true;
                                }
                            }
                        }
                    }
                    if(!success) {
                        return new ActionResult<>(ActionResultType.FAIL, stack);
                    }
                }else {
                    player.addItemStackToInventory(result);
                }
                nbt.remove("cooked");
                stack.setTag(new CompoundNBT());
                return new ActionResult<>(ActionResultType.SUCCESS, stack);
            }
        }else {

            ArrayList<ItemStack> items = Utilities.loadItems(nbt);
            if(items.isEmpty()){
                return new ActionResult<>(ActionResultType.PASS, stack);
            }
            ArrayList<ItemStack> itemsLeft = new ArrayList<>();
            ArrayList<ItemStack> needed = new ArrayList<>();

            if (nbt.contains("Items")) {
                nbt.remove("Items");
            }
            if (nbt.contains("Slot")) {
                nbt.remove("Slot");
            }

            for (ItemStack itemStack : items) {
                Item i = itemStack.getItem();
                if(i.getRegistryName()==Items.MILK_BUCKET.getRegistryName()){
                    itemsLeft.add(itemStack);
                    ItemStack need = new ItemStack(Items.BUCKET,itemStack.getCount());
                    for(int a = 0; a < itemStack.getCount(); a++){
                        for(int x = 0; x < player.inventory.getSizeInventory(); x++){
                            ItemStack slot = player.inventory.getStackInSlot(x);
                            if(slot.isItemEqual(need)){
                                //checks if player has "need" item
                                player.addItemStackToInventory(new ItemStack(itemStack.getItem(),1));//adds e.g milk bucket
                                slot.setCount(slot.getCount()-1);//removes 1 from player item
                                player.inventory.setInventorySlotContents(x,slot);//sets slot
                                need.setCount(need.getCount()-1);//removes 1 from needed item
                            }
                        }
                    }
                    if(!need.isEmpty()) {
                        needed.add(need);
                    }else{
                        itemsLeft.remove(itemStack);
                    }
                }else {
                    player.addItemStackToInventory(itemStack);
                }
            }

            if(!itemsLeft.isEmpty() && !needed.isEmpty()) {
                final String[] s = {""};
                needed.forEach(itemStack -> {
                    s[0] = s[0] + itemStack.getDisplayName().getFormattedText() + " x" + itemStack.getCount() + ",";
                });
                s[0] = s[0].substring(0,s[0].length()-1);

                final String[] s2 = {""};
                itemsLeft.forEach(itemStack -> {
                    s2[0] = s2[0] + itemStack.getDisplayName().getFormattedText() + " x" + itemStack.getCount() + ",";
                });
                s2[0] = s2[0].substring(0,s2[0].length()-1);
                if(clickCount==0) {
                    ITextComponent t = new StringTextComponent("").appendSibling(Main.WNPrefix).appendText(TextFormatting.RED + "You need " + TextFormatting.GOLD + s[0] + TextFormatting.RED + " in your inventory to take out " + TextFormatting.GOLD + s2[0]);
                    Utilities.saveItems(nbt, itemsLeft);
                    Main.sendChatMessage(player, t);
                }
            }
            stack.setTag(nbt);

            clickCount++;
            if(clickCount==2){
                clickCount=0;
            }
            return new ActionResult<>(ActionResultType.SUCCESS, stack);
        }

        return new ActionResult<>(ActionResultType.PASS, stack);
    }

    public CookingToolType getToolType() {
        return toolType;
    }

    public static Item getFillItem(String fill){
        for (FillTool value : FillTool.values()) {
            if(value.getName().equals(fill)){
                return value.getItem();
            }
        }
        return null;
    }

    public static WNAbstractCookingRecipe checkForRecipes(World world, ArrayList<ItemStack> items, CookingToolType type){
        ItemStack[] itemStacks = new ItemStack[items.size()];
        items.toArray(itemStacks);
        Inventory i = new Inventory(itemStacks);
        WNAbstractCookingRecipe recipe = world.getRecipeManager().getRecipe((IRecipeType<WNAbstractCookingRecipe>) Registry.RECIPE_TYPE.getOrDefault(new ResourceLocation("wildnature:cooking")), i, world).orElse(null);
        assert recipe != null && recipe.getRecipeOutput() != null;
        try {
            if(!getGroupParams(recipe.getGroup())[0].equals(type.getName())){
                return null;
            }
        }catch (Exception e){
            return null;
        };
        return recipe;
    }

    public static String[] getGroupParams(String group){
        String[] s = new String[2];
        try{
            s[0]=group.split(";")[0];
            if(s[0].isEmpty()){
                throw new NullPointerException("Null tool type");
            }
            s[1]=group.split(";")[1];
            if(s[1].isEmpty()){
                s[1]="none";
            }
        }catch (Exception e){
            s[0]=group;
            s[1]="none";
        }
        return s;
    }


}
