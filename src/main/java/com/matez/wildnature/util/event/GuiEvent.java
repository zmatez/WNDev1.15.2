package com.matez.wildnature.util.event;

import com.matez.wildnature.client.gui.screen.WNWorldLoadProgressScreen;
import com.matez.wildnature.client.gui.screen.WildNatureScreen;
import com.matez.wildnature.client.gui.screen.world.WNGeneratorWarningScreen;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.CommonConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.WorldLoadProgressScreen;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GuiEvent {
    private static final ResourceLocation WNLOGO = new ResourceLocation("wildnature", "textures/gui/wnlogo.png");

    public GuiEvent() {
    }

    private boolean shown = false;
    private WNWorldLoadProgressScreen worldRender = null;
    private WNGeneratorWarningScreen generatorWarningScreen;

    @SubscribeEvent
    public void guiScreenEvent(GuiScreenEvent.InitGuiEvent event) {

        if (event.getGui().getClass() == MainMenuScreen.class) {
            if(CommonConfig.generatorWarning.get()) {
                WN.gotInfoAboutWorld = false;
                if (!shown) {
                    shown = true;
                    if (WN.loadedNewVersion) {
                        WN.proxy.getClient().toast(new StringTextComponent(TextFormatting.GREEN + "Using WildNature " + TextFormatting.GOLD + WN.version), new StringTextComponent(TextFormatting.GRAY + "Enjoy! :)"));
                        WN.proxy.getClient().toast(new StringTextComponent(TextFormatting.DARK_AQUA + "See what's changed"), new StringTextComponent(TextFormatting.GRAY + "bit.ly/wildnature-files"));
                        WN.proxy.getClient().toast(new StringTextComponent(TextFormatting.DARK_AQUA + "Join our Discord"), new StringTextComponent(TextFormatting.GRAY + "bit.ly/wildnature-discord"));
                        WN.proxy.getClient().toast(new StringTextComponent(TextFormatting.GOLD + "Want a cape?"), new StringTextComponent(TextFormatting.GRAY + "wildnaturemod.com/donate"));
                        if (WN.instance.getSupportedLanguages().contains(Minecraft.getInstance().getLanguageManager().getCurrentLanguage().getCode()) && !Minecraft.getInstance().getLanguageManager().getCurrentLanguage().getCode().equals("en_us")) {
                            WN.proxy.getClient().toast(new StringTextComponent(TextFormatting.LIGHT_PURPLE + "Using " + TextFormatting.GOLD + Minecraft.getInstance().getLanguageManager().getCurrentLanguage().getCode() + TextFormatting.LIGHT_PURPLE + " language."), new StringTextComponent(TextFormatting.GRAY + "Made by " + TextFormatting.DARK_PURPLE + new TranslationTextComponent("lang.credits").getFormattedText()));
                        }

                    }
                }
                if (!Minecraft.getInstance().isDemo()) {
                    int j = event.getGui().height / 4 + 48;
                    event.addWidget(new ImageButton(event.getGui().width / 2 + 104 + 24, j + 72 + 12, 20, 20, 0, 0, 20, WNLOGO, 32, 64, (p_213088_1_) -> {
                        Minecraft.getInstance().displayGuiScreen(new WildNatureScreen());

                        //Main.proxy.getClient().toast( new StringTextComponent(TextFormatting.RED + "This menu is in progress"), new StringTextComponent(TextFormatting.GRAY + "Wait for updates!"));


                    }, new TranslationTextComponent("narrator.button.wildnature").getFormattedText()));
                }
            }else{
                generatorWarningScreen = new WNGeneratorWarningScreen();
                Minecraft.getInstance().displayGuiScreen(generatorWarningScreen);
            }

        }
        if (event.getGui().getClass() == WorldLoadProgressScreen.class) {
            WN.gotInfoAboutWorld = false;
        }

        if (event.getGui().getClass() == WorldLoadProgressScreen.class && CommonConfig.newLoadingWorldScreen.get()) {
            worldRender = new WNWorldLoadProgressScreen(Minecraft.getInstance().refChunkStatusListener.get());
            //worldRender = new WNWorldCreateProgress(Minecraft.getInstance().refChunkStatusListener.get());
            Minecraft.getInstance().displayGuiScreen(worldRender);
        } else {
            if (worldRender != null && event.getGui().getClass() != WNWorldLoadProgressScreen.class) {
                //worldRender.onClose();
            }
        }

    }
}
