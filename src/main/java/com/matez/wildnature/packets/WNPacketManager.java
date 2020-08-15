package com.matez.wildnature.packets;

import com.matez.wildnature.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.network.PacketThreadUtil;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WNPacketManager {
    
    public static void handleParticle(IClientPlayNetHandler handler, WNSSpawnParticlePacket particle){
        if(handler instanceof ClientPlayNetHandler) {
            PacketThreadUtil.checkThreadAndEnqueue(particle, handler, Minecraft.getInstance());
            if (particle.getParticleCount() == 0) {
                double d0 = (double) (particle.getParticleSpeed() * particle.getXOffset());
                double d2 = (double) (particle.getParticleSpeed() * particle.getYOffset());
                double d4 = (double) (particle.getParticleSpeed() * particle.getZOffset());

                try {
                    ((ClientPlayNetHandler) handler).getWorld().addParticle(particle.getParticle(), particle.isLongDistance(), particle.getXCoordinate(), particle.getYCoordinate(), particle.getZCoordinate(), d0, d2, d4);
                } catch (Throwable var17) {
                    Main.LOGGER.warn("Could not spawn particle effect {}", (Object) particle.getParticle());
                }
            } else {
                for (int i = 0; i < particle.getParticleCount(); ++i) {
                    try {
                        ((ClientPlayNetHandler) handler).getWorld().addParticle(particle.getParticle(), particle.isLongDistance(), particle.getXCoordinate(), particle.getYCoordinate(), particle.getZCoordinate(), particle.getXOffset(), particle.getYOffset(), particle.getZOffset());
                    } catch (Throwable var16) {
                        Main.LOGGER.warn("Could not spawn particle effect {}", (Object) particle.getParticle());
                        return;
                    }
                }
            }
        }
    }
}
