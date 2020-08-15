package com.matez.wildnature.gui.inventory;

import com.matez.wildnature.lists.WNItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.util.NonNullList;

public class PouchInventory implements IInventory {
    private NonNullList<ItemStack> stackList;
    private final int width;
    private final int height;
    private final Container container;

    public PouchInventory(Container eventHandlerIn, int width, int height) {
        this.stackList = NonNullList.withSize(width * height, ItemStack.EMPTY);
        this.container = eventHandlerIn;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory() {
        return this.stackList.size();
    }

    public NonNullList<ItemStack> getStackList() {
        return stackList;
    }


    public boolean isEmpty() {
        for(ItemStack itemstack : this.stackList) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the stack in the given slot.
     */
    public ItemStack getStackInSlot(int index) {
        return index >= this.getSizeInventory() ? ItemStack.EMPTY : this.stackList.get(index);
    }

    /**
     * Removes a stack from the given slot and returns it.
     */
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.stackList, index);
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    public ItemStack decrStackSize(int index, int count) {
        ItemStack itemstack = ItemStackHelper.getAndSplit(this.stackList, index, count);
        if (!itemstack.isEmpty()) {
            this.container.onCraftMatrixChanged(this);
        }

        return itemstack;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.stackList.set(index, stack);
        this.container.onCraftMatrixChanged(this);
    }

    public void setStackList(NonNullList<ItemStack> stack) {
        this.stackList = stack;
        this.container.onCraftMatrixChanged(this);
    }

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    public void markDirty() {
    }

    /**
     * Don't rename this method to canInteractWith due to conflicts with Container
     */
    public boolean isUsableByPlayer(PlayerEntity player) {
        return true;
    }

    public void clear() {
        this.stackList.clear();
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void fillStackedContents(RecipeItemHelper helper) {
        for(ItemStack itemstack : this.stackList) {
            helper.accountPlainStack(itemstack);
        }

    }
}
