package com.matez.wildnature.event;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;

public class RenderCapeHandler {

    public static ArrayList<String> alreadyRendered = new ArrayList<>();

    @SubscribeEvent
    public void onRender(RenderPlayerEvent event){
        PlayerEntity entity = event.getPlayer();
        String playerUUID = entity.getUniqueID().toString().replace("-", "");

        if(!alreadyRendered.contains(playerUUID) && CommonConfig.renderCapes.get()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (!ClientPlayerEventHandler.loadedCapes.contains(playerUUID)) {
                        if (CommonConfig.renderCapes.get()) {
                            alreadyRendered.add(playerUUID);
                            Main.LOGGER.info("Loading cape for " + entity.getName().getFormattedText());
                            ClientPlayerEventHandler.download(playerUUID,entity);

                        }
                    } else {
                        alreadyRendered.add(playerUUID);
                    }
                }
            }).start();

        }
    }
}
