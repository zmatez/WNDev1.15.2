package com.matez.wildnature.util.event;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.client.particles.DungeonHeartParticle;
import com.matez.wildnature.common.registry.particles.ParticleRegistry;
import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ParticleFactoryEvent{

    @SubscribeEvent
    public void registerParticles(net.minecraftforge.client.event.ParticleFactoryRegisterEvent event){
        WN.LOGGER.info("Registering particle factories...");
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.DUNGEON_HEART, DungeonHeartParticle.Factory::new);
    }
}
