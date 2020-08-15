package com.matez.wildnature.event;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.entity.render.cape.CapeTexture;
import com.matez.wildnature.event.capeBuffers.IImageBuffer;
import com.matez.wildnature.other.Patron;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;

public class ClientPlayerEventHandler {
    public static ArrayList<String> loadedCapes = new ArrayList<>();



    @SubscribeEvent
    public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player=event.getPlayer();
        String uuid = event.getEntity().getUniqueID().toString().replace("-", "");

        Main.LOGGER.info("Loading capes for player: " + event.getPlayer().getDisplayName().getFormattedText());
        new Thread(new Runnable() {
            public void run() {
                if(CommonConfig.renderCapes.get()) {
                    download(uuid,player);
                }
            }
        }).start();
    }

    public static void download(final String uuid,PlayerEntity player) {
        if(loadedCapes.contains(uuid)){
            Main.LOGGER.debug("Cape already loaded");
            return;
        }
        Patron p = PlayerEventHandler.isPatron(player);

        if (p !=null && uuid != null && !uuid.isEmpty()) {
            String url = "https://wildnaturemod.com/data/capes/"+uuid;
            if(Main.is404(url)){
                url = "https://wildnaturemod.com/data/capes/" + "cape-basic";
            }else{
                Main.LOGGER.info("Found customized cape for " + player.getDisplayName());
            }

            ResourceLocation rl = new ResourceLocation("wildnature", "capes/" + uuid);
            TextureManager textureManager = Minecraft.getInstance().getTextureManager();
            IImageBuffer iib = new IImageBuffer() {
                public NativeImage parseUserSkin(NativeImage img) {
                    return parseCape(img, uuid);
                }

                public void skinAvailable() {
                }
            };
            CapeTexture textureCape = new CapeTexture(url, (ResourceLocation)null, iib);
            textureManager.loadTexture(rl, textureCape);
            loadedCapes.add(uuid);
        }

    }

    public static NativeImage parseCape(NativeImage img, String uuid) {
        int imageWidth = 64;
        int imageHeight = 32;
        int srcWidth = img.getWidth();

        int x;
        for(x = img.getHeight(); imageWidth < srcWidth || imageHeight < x; imageHeight *= 2) {
            imageWidth *= 2;
        }

        NativeImage imgNew = new NativeImage(imageWidth, imageHeight, true);

        for(x = 0; x < img.getWidth(); ++x) {
            for(int y = 0; y < img.getHeight(); ++y) {
                imgNew.setPixelRGBA(x, y, img.getPixelRGBA(x, y));
            }
        }

        img.close();
        PlayerEventHandler.playersCape.put(uuid, true);
        return imgNew;
    }
}
