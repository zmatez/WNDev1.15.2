package com.matez.wildnature.gui.tileEntities.seat;

import java.util.HashMap;

import com.matez.wildnature.entity.EntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;


public class SeatEntity extends Entity {

    public static final HashMap<BlockPos, SeatEntity> OCCUPIED = new HashMap<BlockPos, SeatEntity>();

    public SeatEntity(EntityType<SeatEntity> type, World world)
    {
        super(type, world);
    }

    public SeatEntity(World world, BlockPos pos)
    {
        super(EntityRegistry.SEAT, world);
        setPosition(pos.getX() + 0.5, pos.getY() + 0.3, pos.getZ() + 0.5);
        noClip = true;
        OCCUPIED.put(pos, this);
    }

    public SeatEntity(World world)
    {
        super(EntityRegistry.SEAT, world);
        initOnPos(this.getPosition());
    }

    public void initOnPos(BlockPos pos){
        setPosition(pos.getX() + 0.5, pos.getY() + 0.25, pos.getZ() + 0.5);
        noClip = true;
        OCCUPIED.put(pos, this);
    }

    @Override
    public void tick()
    {

        if(!this.world.isRemote)
        {
            if(!this.isBeingRidden() || this.world.isAirBlock(new BlockPos(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ())))
            {
                this.remove();
            }
        }
    }

    @Override
    protected void registerData()
    {

    }

    @Override
    protected void readAdditional(CompoundNBT compound)
    {

    }

    @Override
    protected void writeAdditional(CompoundNBT compound)
    {

    }

    @Override
    public IPacket<?> createSpawnPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}