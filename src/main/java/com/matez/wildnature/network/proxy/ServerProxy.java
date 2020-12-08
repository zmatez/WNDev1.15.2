package com.matez.wildnature.network.proxy;

import com.matez.wildnature.common.tileentity.DungeonCommanderTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;

public class ServerProxy implements IProxy {
    @Override
    public void init() {

    }

    @Override
    public void enqueueIMC(InterModEnqueueEvent event) {

    }

    public void openDungeonCommander(DungeonCommanderTileEntity entity){
        entity.setSendToClient(true);
    }

    @Override
    public World getClientWorld() {
        return null;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return null;
    }

    @Override
    public ClientProxy getClient() {
        return null;
    }

    @Override
    public ServerProxy getServer() {
        return this;
    }
}
