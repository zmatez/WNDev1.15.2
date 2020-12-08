package com.matez.wildnature.common.tileentity.present;

import com.matez.wildnature.client.gui.initGuis;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PresentTileEntity extends TileEntity {
    public static ArrayList<Block> SUPPORTED_BLOCKS = new ArrayList<>();
    private ItemStack gift;

    public PresentTileEntity() {
        super(initGuis.PRESENT_TILE_ENTITY);
    }

    public void setGift(ItemStack gift) {
        this.gift = gift;
        markDirty();
    }

    public ItemStack getGift() {
        return gift;
    }

    public void dropGift(World world, BlockPos pos) {
        if (hasGift()) {
            Block.spawnAsEntity(world, pos, gift);
            gift = ItemStack.EMPTY;
            markDirty();
        }
    }

    public boolean putGiftToHand(PlayerEntity entity, Hand hand) {
        if (hasGift()) {
            if (entity.getHeldItem(hand).isEmpty()) {
                entity.setHeldItem(hand, gift);
                gift = ItemStack.EMPTY;
                markDirty();
            }
        }
        return false;
    }

    public boolean hasGift() {
        return gift != null && !gift.isEmpty();
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        gift = Utilities.loadItems(compound).get(0);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (gift != null) {
            Utilities.saveItems(compound, new ArrayList<>(Collections.singletonList(gift)));
        } else {
            Utilities.saveItems(compound, new ArrayList<>(Collections.singletonList(ItemStack.EMPTY)));
        }
        return compound;
    }


    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT nbtTagCompound = new CompoundNBT();
        write(nbtTagCompound);
        return nbtTagCompound;
    }

    @Override
    public void handleUpdateTag(CompoundNBT tag) {
        this.read(tag);
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        int tileEntityType = initGuis.tileEntityType + 1;
        return new SUpdateTileEntityPacket(this.pos, tileEntityType, this.getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        handleUpdateTag(pkt.getNbtCompound());
    }

}
