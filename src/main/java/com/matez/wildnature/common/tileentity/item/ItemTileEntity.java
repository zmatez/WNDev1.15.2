package com.matez.wildnature.common.tileentity.item;

import com.matez.wildnature.client.gui.initGuis;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ItemTileEntity extends TileEntity implements ITickableTileEntity {
    public static ArrayList<Block> SUPPORTED_BLOCKS = new ArrayList<>();
    private ItemStack placedStack;
    private Direction facing = Direction.NORTH;
    private PlayerEntity eatingPlayer;
    private int eatingTime = 0;
    private Random rand = new Random();

    public ItemTileEntity() {
        super(initGuis.ITEM_TILE_ENTITY);
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
        markDirty();
    }

    public Direction getFacing() {
        return facing;
    }

    public boolean hasPlacedStack() {
        return placedStack != null && !placedStack.isEmpty();
    }

    public ItemStack getPlacedStack() {
        return placedStack;
    }

    public void setPlacedStack(ItemStack placedStack) {
        this.placedStack = placedStack;
        markDirty();
    }

    public void destroy(World world, BlockPos pos) {
        dropItemStack(world, pos);
        remove();
    }

    public void removeItemStack() {
        placedStack = ItemStack.EMPTY;
        markDirty();
    }

    public void addItemStack(World world, BlockPos pos, ItemStack stack) {
        dropItemStack(world, pos);
        placedStack = stack;
        markDirty();
    }

    public void dropItemStack(World world, BlockPos pos) {
        if (hasPlacedStack()) {
            Block.spawnAsEntity(world, pos, placedStack);
            removeItemStack();
        }
    }

    public void setEatingPlayer(PlayerEntity eatingPlayer) {
        this.eatingPlayer = eatingPlayer;
    }

    public void eat(PlayerEntity entity) {
        if (placedStack.getItem().getFood() != null && entity.canEat(placedStack.getItem().getFood().canEatWhenFull())) {
            if (eatingPlayer == null) {
                eatingPlayer = entity;
                eatingTime = 0;
            } else if (eatingPlayer == entity) {
                eatingTime++;
                addItemParticles(eatingPlayer, placedStack, 1);
                eatingPlayer.playSound(eatingPlayer.getEatSound(placedStack), 0.5F + 0.5F * (float) this.rand.nextInt(2), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
                if (eatingTime >= placedStack.getUseDuration() / 4) {
                    //eaten
                    placedStack.onItemUseFinish(entity.getEntityWorld(), entity);
                    eatingTime = 0;
                    eatingPlayer = null;
                    placedStack.shrink(1);
                }
            }
        }
    }

    private void addItemParticles(PlayerEntity entity, ItemStack stack, int count) {
        for (int i = 0; i < count; ++i) {
            Vec3d vec3d = new Vec3d(((double) this.rand.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
            vec3d = vec3d.rotatePitch(-entity.rotationPitch * ((float) Math.PI / 180F));
            vec3d = vec3d.rotateYaw(-entity.rotationYaw * ((float) Math.PI / 180F));
            double d0 = (double) (-this.rand.nextFloat()) * 0.6D - 0.3D;
            Vec3d vec3d1 = new Vec3d(((double) this.rand.nextFloat() - 0.5D) * 0.3D, d0, 0.6D);
            vec3d1 = vec3d1.rotatePitch(-entity.rotationPitch * ((float) Math.PI / 180F));
            vec3d1 = vec3d1.rotateYaw(-entity.rotationYaw * ((float) Math.PI / 180F));
            vec3d1 = vec3d1.add(entity.getPosX(), entity.getPosYEye(), entity.getPosZ());
            if (this.world instanceof ServerWorld) //Forge: Fix MC-2518 spawnParticle is nooped on server, need to use server specific variant
                ((ServerWorld) this.world).spawnParticle(new ItemParticleData(ParticleTypes.ITEM, stack), vec3d1.x, vec3d1.y, vec3d1.z, 1, vec3d.x, vec3d.y + 0.05D, vec3d.z, 0.0D);
            else
                this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, stack), vec3d1.x, vec3d1.y, vec3d1.z, vec3d.x, vec3d.y + 0.05D, vec3d.z);
        }

    }

    int eatingLeftToReset = 5;
    int oldEatingTime;

    @Override
    public void tick() {
        if (eatingTime != 0) {
            if (oldEatingTime == eatingTime) {
                eatingLeftToReset--;
                if (eatingLeftToReset <= 0) {
                    eatingPlayer = null;
                    eatingTime = 0;
                    eatingLeftToReset = 5;
                }
            } else {
                eatingLeftToReset = 5;
            }
        } else {
            eatingLeftToReset = 5;
        }
        oldEatingTime = eatingTime;
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);

        ArrayList<ItemStack> readStack = Utilities.loadItems(compound);
        if(!readStack.isEmpty()) {
            placedStack = readStack.get(0);
        }
        if (compound.contains("facing")) {
            facing = Direction.byHorizontalIndex(compound.getInt("facing"));
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (hasPlacedStack()) {
            Utilities.saveItems(compound, new ArrayList<>(Collections.singletonList(placedStack)));
        } else {
            Utilities.saveItems(compound, new ArrayList<>(Collections.singletonList(ItemStack.EMPTY)));
        }
        compound.putInt("facing", facing.getHorizontalIndex());
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
