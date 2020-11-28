package com.matez.wildnature.network.packet.packets;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.network.packet.WNPackets;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;

import java.util.function.Supplier;

public class WNParticlePacket {

    public static void sendToClient(ServerPlayerEntity entity, WNParticlePacket packet){
        WNPackets.INSTANCE.send(PacketDistributor.PLAYER.with(() -> {
            return entity;
        }), packet);
    }

    private float xCoord;
    private float yCoord;
    private float zCoord;
    private float xSpeed;
    private float ySpeed;
    private float zSpeed;
    private int particleCount;
    private boolean longDistance;
    private IParticleData particle;

    public <T extends IParticleData> WNParticlePacket(T particleData, boolean longDistance, float xCoord, float yCoord, float zCoord, float xSpeed, float ySpeed, float zSpeed, int particleCount) {
        this.particle = particleData;
        this.longDistance = longDistance;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.zSpeed = zSpeed;
        this.particleCount = particleCount;
    }

    /**
     * Reads the raw packet data from the data stream.
     */
    public static WNParticlePacket parse(final PacketBuffer buf) {
        ParticleType<?> particletype = Registry.PARTICLE_TYPE.getByValue(buf.readInt());
        if (particletype == null) {
            particletype = ParticleTypes.BARRIER;
        }

        return new WNParticlePacket(readParticle(buf, particletype),buf.readBoolean(),buf.readFloat(),buf.readFloat(),buf.readFloat(),buf.readFloat(),buf.readFloat(),buf.readFloat(),buf.readInt());
    }

    private static <T extends IParticleData> T readParticle(PacketBuffer p_199855_1_, ParticleType<T> p_199855_2_) {
        return p_199855_2_.getDeserializer().read(p_199855_2_, p_199855_1_);
    }

    /**
     * Writes the raw packet data to the data stream.
     */
    public static void compose(final WNParticlePacket packet, final PacketBuffer buf) {
        buf.writeInt(Registry.PARTICLE_TYPE.getId(packet.particle.getType()));
        buf.writeBoolean(packet.longDistance);
        buf.writeFloat(packet.xCoord);
        buf.writeFloat(packet.yCoord);
        buf.writeFloat(packet.zCoord);
        buf.writeFloat(packet.xSpeed);
        buf.writeFloat(packet.ySpeed);
        buf.writeFloat(packet.zSpeed);
        buf.writeInt(packet.particleCount);
        packet.particle.write(buf);
    }

    public static class Handler {
        //this is what gets run on the server
        public static void handle(final WNParticlePacket packet, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(new Runnable() {
                @Override
                public void run() {
                    ClientWorld world = Minecraft.getInstance().world;
                    if(world==null){
                        return;
                    }
                    if (packet.particleCount == 0) {
                        try {
                            world.addParticle(packet.particle, packet.longDistance, packet.xCoord, packet.yCoord, packet.zCoord, packet.xSpeed, packet.ySpeed, packet.zSpeed);
                        } catch (Throwable var17) {
                            WN.LOGGER.warn("Could not spawn particle effect {}", (Object) packet.particle);
                        }
                    } else {
                        for (int i = 0; i < packet.particleCount; ++i) {
                            try {
                                world.addParticle(packet.particle, packet.longDistance, packet.xCoord, packet.yCoord, packet.zCoord, packet.xSpeed, packet.ySpeed, packet.zSpeed);
                            } catch (Throwable var17) {
                                WN.LOGGER.warn("Could not spawn particle effect {}", (Object) packet.particle);
                            }
                        }
                    }
                }
            });
            ctx.get().setPacketHandled(true);
        }
    }
}
