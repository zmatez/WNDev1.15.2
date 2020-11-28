package com.matez.wildnature.network.packet.packets;

import com.matez.wildnature.common.items.blowpipe.BlowpipeItem;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.network.packet.WNPackets;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class WNBlowpipeShootPacket {
    private UUID uuid;

    public static void sendToServer(UUID uuid) {
        WNPackets.INSTANCE.sendToServer(new WNBlowpipeShootPacket(uuid));
    }

    public WNBlowpipeShootPacket(UUID uuid) {
        this.uuid = uuid;
    }

    /*
     * How the server will read the packet.
     */
    public static WNBlowpipeShootPacket parse(final PacketBuffer buf) {
        return new WNBlowpipeShootPacket(buf.readUniqueId());
    }

    /*
     * creates the packet buffer and sets its values
     */
    public static void compose(final WNBlowpipeShootPacket packet, final PacketBuffer buf) {
        buf.writeUniqueId(packet.uuid);
    }

    public UUID getUuid() {
        return uuid;
    }

    /*
     * What the client will do with the packet
     */
    public static class Handler {
        //this is what gets run on the server
        public static void handle(final WNBlowpipeShootPacket pkt, final Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(new Runnable() {
                @Override
                public void run() {
                    ServerPlayerEntity entity = ctx.get().getSender();
                    if (entity != null) {
                        MinecraftServer server = entity.getServer();
                        PlayerEntity player = Utilities.getPlayerByUUID(pkt.uuid, server);
                        if (player != null) {
                            if (!player.getActiveItemStack().isEmpty()) {
                                if (player.getActiveItemStack().getItem() instanceof BlowpipeItem){
                                    ((BlowpipeItem)player.getActiveItemStack().getItem()).shoot(player.getActiveItemStack(),entity.getServerWorld(),player);
                                }
                            }
                        }
                    }
                }
            });
            ctx.get().setPacketHandled(true);
        }
    }
}