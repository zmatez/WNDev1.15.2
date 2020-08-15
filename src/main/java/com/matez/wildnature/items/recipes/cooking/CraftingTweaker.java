package com.matez.wildnature.items.recipes.cooking;

import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;

public class CraftingTweaker {
    @SubscribeEvent
    public void playerCraftedEvent(PlayerEvent.ItemCraftedEvent e){

        ItemStack recipe = e.getCrafting();
        Item i = recipe.getItem();
        if(i==WNItems.CAKE_PAN || i==WNItems.FRYING_PAN || i==WNItems.POT_EMPTY || i==WNItems.POT_WATER){
            ArrayList<ItemStack> items = Utilities.loadItems(recipe.getOrCreateTag());
            if(!items.isEmpty()){
                CraftingInventory inventory = (CraftingInventory)e.getInventory();
                ArrayList<SlotContent> contents = new ArrayList<>();
                int size = inventory.getSizeInventory();
                for(int x = 0; x<size; x++){
                    ItemStack s = inventory.getStackInSlot(x);

                    if(s.getItem()== Items.MILK_BUCKET){
                        contents.add(new SlotContent(x,new ItemStack(Items.BUCKET,s.getCount())));
                    }
                    else if(s.getItem()== WNItems.FLOUR){
                        contents.add(new SlotContent(x,new ItemStack(WNItems.EMPTY_BAG,s.getCount())));
                    }
                    else if(s.getItem()== WNItems.POPPY_SEED){
                        contents.add(new SlotContent(x,new ItemStack(WNItems.EMPTY_BAG,s.getCount())));
                    }
                    else if(s.getItem()== WNItems.RICE_BAG){
                        contents.add(new SlotContent(x,new ItemStack(WNItems.EMPTY_BAG,s.getCount())));
                    }
                    else if(s.getItem()== WNItems.SAUERKRAUT){
                        contents.add(new SlotContent(x,new ItemStack(WNItems.PLATE,s.getCount())));
                    }
                }

                inventory.clear();
                contents.forEach(slotContent -> {
                    //inventory.setInventorySlotContents(slotContent.index,slotContent.stack);
                    e.getPlayer().inventory.addItemStackToInventory(slotContent.stack);
                });

            }
        }
    }


    public static class SlotContent{
        private int index;
        private ItemStack stack;
        public SlotContent(int index, ItemStack stack){
            this.index=index;
            this.stack=stack;
        }
    }

}
