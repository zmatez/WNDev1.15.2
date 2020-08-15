package com.matez.wildnature.event;

import com.matez.wildnature.Main;
import com.matez.wildnature.particles.DungeonHeartParticle;
import com.matez.wildnature.registry.ParticleRegistry;
import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ParticleFactoryEvent{

    @SubscribeEvent
    public void registerParticles(net.minecraftforge.client.event.ParticleFactoryRegisterEvent event){
        Main.LOGGER.info("Registering particle factories...");
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.DUNGEON_HEART, DungeonHeartParticle.Factory::new);
    }
}
