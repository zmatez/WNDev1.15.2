package com.matez.wildnature.common.tileentity.tree;

import com.matez.wildnature.client.gui.initGuis;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
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
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TreeTileEntity extends TileEntity {
    public static ArrayList<Block> SUPPORTED_BLOCKS = new ArrayList<>();
    private BlockPos min, max;
    private String leafBlock = "";

    public TreeTileEntity() {
        super(initGuis.TREE_TILE_ENTITY);
    }
    
    public void setData(BlockPos min, BlockPos max, String leafBlock){
        this.min = min;
        this.max = max;
        this.leafBlock = leafBlock;
    }

    public void destroy(IWorld worldIn, BlockPos blockPos){
        if(min != null & max != null && !leafBlock.isEmpty()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    BlockPos.getAllInBox(min,max).forEach(pos -> {
                        try {
                            BlockState state = worldIn.getBlockState(pos);
                            if (state.getBlock().getRegistryName().toString().equals(leafBlock)) {
                                worldIn.setBlockState(pos,state.with(LeavesBlock.PERSISTENT,false).with(LeavesBlock.DISTANCE,7),19);
                            }
                        }catch (Exception e){

                        }
                    });
                }
            }).start();

        }
    }
    
    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        if(compound.contains("minX") && compound.contains("minY") && compound.contains("minZ")){
            min = new BlockPos(compound.getInt("minX"), compound.getInt("minY"), compound.getInt("minZ"));
        }
        if(compound.contains("maxX") && compound.contains("maxY") && compound.contains("maxZ")){
            max = new BlockPos(compound.getInt("maxX"), compound.getInt("maxY"), compound.getInt("maxZ"));
        }
        if(compound.contains("leafBlock")){
            leafBlock = compound.getString("leafBlock");
        }
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        
        if(min != null){
            compound.putInt("minX",min.getX());
            compound.putInt("minY",min.getY());
            compound.putInt("minZ",min.getZ());
        }
        if(max != null){
            compound.putInt("maxX",max.getX());
            compound.putInt("maxY",max.getY());
            compound.putInt("maxZ",max.getZ());
        }
        compound.putString("leafBlock",leafBlock);
        
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
        int tileEntityType = initGuis.tileEntityType + 2;
        return new SUpdateTileEntityPacket(this.pos, tileEntityType, this.getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        handleUpdateTag(pkt.getNbtCompound());
    }


}
