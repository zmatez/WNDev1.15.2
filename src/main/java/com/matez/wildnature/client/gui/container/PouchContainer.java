package com.matez.wildnature.client.gui.container;


import com.matez.wildnature.client.gui.inventory.PouchInventory;
import com.matez.wildnature.common.items.PouchItem;
import com.matez.wildnature.util.lists.WNItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.*;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.matez.wildnature.client.gui.initGuis.POUCH;

public class PouchContainer extends Container {
    public ItemStack stack = ItemStack.EMPTY;
    public PouchInventory pouchInventory;

    public PouchContainer(final int windowId, final PlayerInventory playerInventory, PacketBuffer data) {
        this(windowId, playerInventory.player.getEntityWorld(),playerInventory,playerInventory.player);
    }

    public PouchContainer(int windowId, World world, PlayerInventory playerInventory, PlayerEntity player) {
        this(POUCH,windowId,world,playerInventory,player);
    }

    public PouchContainer(ContainerType<? extends PouchContainer> type, int windowId, World world, PlayerInventory playerInventory, PlayerEntity player) {
        super(type, windowId);
        init(windowId,world,playerInventory,player);


        addListener(new IContainerListener() {
            @Override
            public void sendAllContents(Container containerToSend, NonNullList<ItemStack> itemsList) {

            }

            @Override
            public void sendSlotContents(Container containerToSend, int slotInd, ItemStack stack) {
                ItemStackHelper.saveAllItems(getPouchStack().getOrCreateTag(), pouchInventory.getStackList());

            }

            @Override
            public void sendWindowProperty(Container containerIn, int varToUpdate, int newValue) {

            }
        });
    }

    public void init(int windowId, World world, PlayerInventory playerInventory, PlayerEntity player){
        stack=playerInventory.getCurrentItem();
        pouchInventory = new PouchInventory(this,9,1);

        NonNullList<ItemStack> stacks = pouchInventory.getStackList();
        ItemStackHelper.loadAllItems(stack.getOrCreateTag(),stacks);
        pouchInventory.setStackList(stacks);

        for(int i = 0; i < 1; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new PouchSlot(pouchInventory, j + i * 9, 7 + j * 18, 22 + i * 18));
            }
        }


        for(int k = 0; k < 3; ++k) {
            for(int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(playerInventory, i1 + k * 9 + 9, 7 + i1 * 18, 60 + k * 18));
            }
        }

        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(playerInventory, l, 7 + l * 18, 118));
        }
    }

    public ItemStack getPouchStack() {
        return stack;
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return stack.getItem() == WNItems.POUCH;
    }

    public int getSize() {
        return pouchInventory.getSizeInventory();
    }

    @Override
    public void onContainerClosed(PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
    }

    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();

            itemstack = itemstack1.copy();
            if(itemstack1.getItem() instanceof PouchItem){
                //playerIn.dropItem(itemstack,false);
                //slot.putStack(ItemStack.EMPTY);
                return ItemStack.EMPTY;
            }
            if (index < this.pouchInventory.getSizeInventory()) {
                if (!this.mergeItemStack(itemstack1, this.pouchInventory.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, this.pouchInventory.getSizeInventory(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }


        return itemstack;
    }

}
