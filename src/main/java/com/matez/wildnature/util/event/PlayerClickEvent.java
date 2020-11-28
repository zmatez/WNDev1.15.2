package com.matez.wildnature.util.event;

import com.matez.wildnature.common.items.blowpipe.BlowpipeItem;
import com.matez.wildnature.network.packet.packets.WNBlowpipeShootPacket;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

public class PlayerClickEvent {

    @SubscribeEvent
    public void onPlayerClick(InputEvent.MouseInputEvent event){
        if(event.getButton()== GLFW.GLFW_MOUSE_BUTTON_LEFT && event.getAction() == GLFW.GLFW_PRESS){
            if(Minecraft.getInstance().player!=null) {
                if(!Minecraft.getInstance().player.getActiveItemStack().isEmpty()) {
                    if(Minecraft.getInstance().player.getActiveItemStack().getItem() instanceof BlowpipeItem) {
                        WNBlowpipeShootPacket.sendToServer(Minecraft.getInstance().player.getUniqueID());
                    }
                }
            }
        }
    }
}
