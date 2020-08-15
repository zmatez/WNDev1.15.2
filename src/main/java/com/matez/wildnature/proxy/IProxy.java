package com.matez.wildnature.proxy;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;

public interface IProxy {

    void init();

    void enqueueIMC(InterModEnqueueEvent event);

    World getClientWorld();

    PlayerEntity getClientPlayer();

    ClientProxy getClient();

    ServerProxy getServer();
}