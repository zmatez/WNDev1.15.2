package com.matez.wildnature.network.proxy;

import com.matez.wildnature.client.gui.screen.*;
import com.matez.wildnature.client.music.WNMusicPlayer;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.common.entity.render.cape.WNCapeLayer;
import com.matez.wildnature.client.gui.tileEntities.DungeonCommanderTileEntity;
import com.matez.wildnature.client.gui.initGuis;
import com.matez.wildnature.client.music.WNMusic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.toasts.SystemToast;
import net.minecraft.client.gui.toasts.ToastGui;
import net.minecraft.client.renderer.RenderSkyboxCube;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.layers.CapeLayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;

import java.util.Iterator;

public class ClientProxy implements IProxy {
    public static WNMusic music;

    @Override
    public void init() {
        if(CommonConfig.changePanorama.get()) {
            MainMenuScreen.PANORAMA_RESOURCES = new RenderSkyboxCube(new ResourceLocation("wildnature:textures/gui/title/background/panorama"));
        }
        ScreenManager.registerFactory(initGuis.POUCH, PouchScreen::new);
        ScreenManager.registerFactory(initGuis.BACKPACK_SMALL, BackpackSmallScreen::new);
        ScreenManager.registerFactory(initGuis.BACKPACK_MEDIUM, BackpackMediumScreen::new);
        ScreenManager.registerFactory(initGuis.BACKPACK_BIG, BackpackBigScreen::new);

        //ScreenManager.registerFactory(initGuis.CRAFTING_MANAGER_CONTAINER, CraftingManagerScreen::new);
        //music = new AmbientMusic();
        WN.usesFancyGraphics = Minecraft.getInstance().gameSettings.fancyGraphics;
        /*DistExecutor.runWhenOn(Dist.CLIENT, () -> new Runnable() {
            @Override
            public void run() {
                MinecraftForge.EVENT_BUS.addListener(new ClientPlayerEventHandler()::onPlayerJoin);
            }
        });*/

        music = new WNMusic();
        MinecraftForge.EVENT_BUS.addListener(WNMusicPlayer::playerTick);
    }

    public void openDungeonCommander(DungeonCommanderTileEntity entity){
        Minecraft.getInstance().displayGuiScreen(new DungeonCommanderScreen(entity));

    }

    public void toast(ITextComponent componentTitle, ITextComponent componentDescription){
        ToastGui toastgui = Minecraft.getInstance().getToastGui();
        toastgui.add(new SystemToast(SystemToast.Type.TUTORIAL_HINT,componentTitle, componentDescription));

    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void enqueueIMC(InterModEnqueueEvent event) {
        WN.LOGGER.info("Registering capes...");
        Minecraft.getInstance().gameSettings.setModelPartEnabled(PlayerModelPart.CAPE, true);
        Iterator var2 = Minecraft.getInstance().getRenderManager().getSkinMap().values().iterator();
        //MinecraftForge.EVENT_BUS.addListener(new ClientPlayerEventHandler()::onPlayerJoin);

        while(var2.hasNext()) {
            PlayerRenderer render = (PlayerRenderer)var2.next();

            /*try {
                List<LayerRenderer<?, ?>> layerRenderers = (List) ObfuscationReflectionHelper.getPrivateValue(LivingRenderer.class, render, "layerRenderers");
                ListIterator it = layerRenderers.listIterator();

                while(it.hasNext()) {
                    if (it.next() instanceof ElytraLayer) {
                        it.remove();
                    }
                }

                ObfuscationReflectionHelper.setPrivateValue(LivingRenderer.class, render, layerRenderers, "layerRenderers");
            } catch (Exception var6) {
                var6.printStackTrace();
            }*/


            render.addLayer(new WNCapeLayer(render));
            render.addLayer(new CapeLayer(render));

        }

    }


    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }

    @Override
    public ClientProxy getClient() {
        return this;
    }

    @Override
    public ServerProxy getServer() {
        return null;
    }
}
