package com.matez.wildnature.network.packet;

import com.matez.wildnature.network.packet.packets.WNBlowpipeShootPacket;
import com.matez.wildnature.network.packet.packets.WNParticlePacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.Optional;

public class WNPackets {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("wildnature", "networking"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    private static int id = 0;

    public static void registerAll(){
        INSTANCE.registerMessage(++id, WNBlowpipeShootPacket.class, WNBlowpipeShootPacket::compose, WNBlowpipeShootPacket::parse, WNBlowpipeShootPacket.Handler::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
        INSTANCE.registerMessage(++id, WNParticlePacket.class, WNParticlePacket::compose, WNParticlePacket::parse, WNParticlePacket.Handler::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    }
}
