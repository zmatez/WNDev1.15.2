package com.matez.wildnature.gui.tileEntities;

import com.matez.wildnature.gui.initGuis;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import javax.annotation.Nullable;

public class ParticleGeneratorTileEntity extends TileEntity implements INamedContainerProvider {
    public String particle = "", posX = "~0",posY = "~1",posZ = "~0";
    public double deltaX = 0,deltaY = 0,deltaZ = 0;
    public float speed = 0;
    public int count = 10;
    boolean changed = false;
    public boolean force = false;
    private boolean shouldGenerate = false;
    public ParticleGeneratorTileEntity() {
        super(initGuis.PARTICLE_GENERATOR_TILE);
    }



    @Override
    public void read(CompoundNBT tag) {
        particle=tag.getString("particle");
        posX=tag.getString("posX");
        posY=tag.getString("posY");
        posZ=tag.getString("posZ");
        deltaX=tag.getDouble("deltaX");
        deltaY=tag.getDouble("deltaY");
        deltaZ=tag.getDouble("deltaZ");
        speed=tag.getFloat("speed");
        count=tag.getInt("count");
        changed=!tag.isEmpty();
        super.read(tag);

        if(posX==null || posX.isEmpty()){
            posX="~0";
        }
        if(posY==null || posY.isEmpty()){
            posY="~1";
        }
        if(posZ==null || posZ.isEmpty()){
            posZ="~0";
        }

    }

    @Override
    public CompoundNBT write(CompoundNBT tag) {
        tag.putString("particle",particle);
        tag.putString("posX",posX+"");
        tag.putString("posY",posY+"");
        tag.putString("posZ",posZ+"");
        tag.putDouble("deltaX",deltaX);
        tag.putDouble("deltaY",deltaY);
        tag.putDouble("deltaZ",deltaZ);
        tag.putFloat("speed",speed);
        tag.putInt("count",count);
        return super.write(tag);
    }

    public double blockPosDecoder(String pos,double blockPos){
        if(pos.contains("~")) {
            return blockPos + Double.parseDouble(pos.replace("~",""));
        }else{
            return Double.parseDouble(pos);
        }
    }

    public boolean hasCustomData(){
        return changed;
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return null;
    }

    @Override
    public boolean canRenderBreaking() {
        return false;
    }

    @Override
    public boolean hasFastRenderer() {
        return false;
    }

    @Override
    public void requestModelDataUpdate() {

    }


    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent("wildnature:particle_generator");
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return null;
    }

}
