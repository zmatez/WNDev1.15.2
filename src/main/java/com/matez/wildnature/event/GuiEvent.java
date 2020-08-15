package com.matez.wildnature.event;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.gui.screen.WNWorldLoadProgressScreen;
import com.matez.wildnature.gui.screen.WildNatureScreen;
import com.matez.wildnature.items.recipes.cooking.CraftingTweaker;
import com.matez.wildnature.lists.WNItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.WorldLoadProgressScreen;
import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GuiEvent {
    private static final ResourceLocation WNLOGO = new ResourceLocation("wildnature","textures/gui/wnlogo.png");
    public GuiEvent(){}
    private boolean shown = false;
    private WNWorldLoadProgressScreen worldRender = null;

    @SubscribeEvent
    public void guiScreenEvent(GuiScreenEvent.InitGuiEvent event){

        if(event.getGui().getClass()== MainMenuScreen.class){
            Main.gotInfoAboutWorld = false;
            if(!shown) {
                shown = true;
                if (Main.loadedNewVersion) {
                    Main.proxy.getClient().toast(new StringTextComponent(TextFormatting.GREEN + "Using WildNature " + TextFormatting.GOLD + Main.version), new StringTextComponent(TextFormatting.GRAY + "Enjoy! :)"));
                    Main.proxy.getClient().toast(new StringTextComponent(TextFormatting.DARK_AQUA + "See what's changed"), new StringTextComponent(TextFormatting.GRAY + "bit.ly/wildnature-files"));
                    Main.proxy.getClient().toast(new StringTextComponent(TextFormatting.DARK_AQUA + "Join our Discord"), new StringTextComponent(TextFormatting.GRAY + "bit.ly/wildnature-discord"));
                    Main.proxy.getClient().toast(new StringTextComponent(TextFormatting.GOLD + "Want a cape?"), new StringTextComponent(TextFormatting.GRAY + "wildnaturemod.com/donate"));
                    Main.proxy.getClient().toast(new StringTextComponent(TextFormatting.GOLD + "Server.pro - free servers"), new StringTextComponent(TextFormatting.GRAY + "bit.ly/wildnature-server-pro"));
                    if(Main.instance.getSupportedLanguages().contains(Minecraft.getInstance().getLanguageManager().getCurrentLanguage().getCode()) && !Minecraft.getInstance().getLanguageManager().getCurrentLanguage().getCode().equals("en_us")){
                        Main.proxy.getClient().toast(new StringTextComponent(TextFormatting.LIGHT_PURPLE + "Using " + TextFormatting.GOLD + Minecraft.getInstance().getLanguageManager().getCurrentLanguage().getCode() + TextFormatting.LIGHT_PURPLE+" language."), new StringTextComponent(TextFormatting.GRAY + "Made by " + TextFormatting.DARK_PURPLE+new TranslationTextComponent("lang.credits").getFormattedText()));
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

        }
        if(event.getGui().getClass()== WorldLoadProgressScreen.class){
            Main.gotInfoAboutWorld = false;
        }

        if(event.getGui().getClass()==WorldLoadProgressScreen.class && CommonConfig.newLoadingWorldScreen.get()){
            worldRender = new WNWorldLoadProgressScreen(Minecraft.getInstance().refChunkStatusListener.get());
            Minecraft.getInstance().displayGuiScreen(worldRender);
        }else{
            if(worldRender!=null && event.getGui().getClass()!=WNWorldLoadProgressScreen.class){
                worldRender.onClose();
            }
        }

    }
}
