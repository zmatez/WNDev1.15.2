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

import static com.matez.wildnature.client.gui.initGuis.BACKPACK_BIG;
import static com.matez.wildnature.client.gui.initGuis.BACKPACK_MEDIUM;

public class BackpackBigContainer extends PouchContainer{
    public BackpackBigContainer(int windowId, PlayerInventory playerInventory, PacketBuffer data) {
        super(windowId, playerInventory, data);
    }

    public BackpackBigContainer(int windowId, World world, PlayerInventory playerInventory, PlayerEntity player) {
        this(BACKPACK_BIG,windowId,world,playerInventory,player);
    }

    public BackpackBigContainer(ContainerType<BackpackBigContainer> type, int windowId, World world, PlayerInventory playerInventory, PlayerEntity player) {
        super(type, windowId, world, playerInventory, player);
    }

    @Override
    public void init(int windowId, World world, PlayerInventory playerInventory, PlayerEntity player) {
        stack=playerInventory.getCurrentItem();
        pouchInventory = new PouchInventory(this,11,4);

        NonNullList<ItemStack> stacks = pouchInventory.getStackList();
        ItemStackHelper.loadAllItems(stack.getOrCreateTag(),stacks);
        pouchInventory.setStackList(stacks);

        for(int i = 0; i < 4; ++i) {
            for(int j = 0; j < 11; ++j) {
                int xpos = 7 + j * 18;
                int ypos = 22 + i * 18;
                if(j == 0){

                }else if(j == 10){
                    xpos += 14;
                }else{
                    xpos += 7;
                }

                this.addSlot(new PouchSlot(pouchInventory, j + i * 11, xpos, ypos));
            }
        }


        for(int k = 0; k < 3; ++k) {
            for(int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(playerInventory, i1 + k * 9 + 9, 32 + i1 * 18, 114 + k * 18));
            }
        }

        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(playerInventory, l, 32 + l * 18, 172));
        }
    }

    @Override
    public int getSize() {
        return pouchInventory.getSizeInventory();
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return stack.getItem() == WNItems.BACKPACK_BIG;
    }
}
