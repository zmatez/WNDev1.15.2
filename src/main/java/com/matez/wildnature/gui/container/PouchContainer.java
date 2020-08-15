package com.matez.wildnature.gui.container;


import com.matez.wildnature.gui.inventory.PouchInventory;
import com.matez.wildnature.gui.tileEntities.ParticleGeneratorTileEntity;
import com.matez.wildnature.items.PouchItem;
import com.matez.wildnature.lists.WNItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.*;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import javax.annotation.Nullable;

import static com.matez.wildnature.gui.initGuis.POUCH;

public class PouchContainer extends Container {
    private ItemStack stack = ItemStack.EMPTY;
    private PouchInventory pouchInventory;

    public PouchContainer(final int windowId, final PlayerInventory playerInventory, PacketBuffer data)
    {
        this(windowId, playerInventory.player.getEntityWorld(),playerInventory,playerInventory.player);
    }



    public PouchContainer(int windowId, World world, PlayerInventory playerInventory, PlayerEntity player) {
        super(POUCH, windowId);
        stack=playerInventory.getCurrentItem();
        pouchInventory = new PouchInventory(this,9,2);

        NonNullList<ItemStack> stacks = pouchInventory.getStackList();
        ItemStackHelper.loadAllItems(stack.getOrCreateTag(),stacks);
        pouchInventory.setStackList(stacks);

        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new PouchSlot(pouchInventory, j + i * 9, 8 + j * 18, 22 + i * 18));
            }
        }


        for(int k = 0; k < 3; ++k) {
            for(int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 78 + k * 18));
            }
        }

        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(playerInventory, l, 8 + l * 18, 136));
        }


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


    public ItemStack getPouchStack() {
        return stack;
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return stack.getItem() instanceof PouchItem;
    }

    @OnlyIn(Dist.CLIENT)
    public int getSize() {
        return 18;
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
