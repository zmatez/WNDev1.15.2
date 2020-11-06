package com.matez.wildnature.client.gui.container;

import com.matez.wildnature.client.gui.inventory.PouchInventory;
import com.matez.wildnature.util.lists.WNItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import static com.matez.wildnature.client.gui.initGuis.BACKPACK_MEDIUM;

public class BackpackMediumContainer extends PouchContainer{
    public BackpackMediumContainer(int windowId, PlayerInventory playerInventory, PacketBuffer data) {
        super(windowId, playerInventory, data);
    }

    public BackpackMediumContainer(int windowId, World world, PlayerInventory playerInventory, PlayerEntity player) {
        this(BACKPACK_MEDIUM,windowId,world,playerInventory,player);
    }

    public BackpackMediumContainer(ContainerType<BackpackMediumContainer> type, int windowId, World world, PlayerInventory playerInventory, PlayerEntity player) {
        super(type, windowId, world, playerInventory, player);
    }

    @Override
    public void init(int windowId, World world, PlayerInventory playerInventory, PlayerEntity player) {
        stack=playerInventory.getCurrentItem();
        pouchInventory = new PouchInventory(this,9,3);

        NonNullList<ItemStack> stacks = pouchInventory.getStackList();
        ItemStackHelper.loadAllItems(stack.getOrCreateTag(),stacks);
        pouchInventory.setStackList(stacks);

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new PouchSlot(pouchInventory, j + i * 9, 7 + j * 18, 22 + i * 18));
            }
        }


        for(int k = 0; k < 3; ++k) {
            for(int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(playerInventory, i1 + k * 9 + 9, 7 + i1 * 18, 96 + k * 18));
            }
        }

        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(playerInventory, l, 7 + l * 18, 154));
        }
    }

    @Override
    public int getSize() {
        return pouchInventory.getSizeInventory();
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return stack.getItem() == WNItems.BACKPACK_MEDIUM;
    }
}
