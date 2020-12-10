package com.matez.wildnature.client.gui.screen.world;


import com.matez.wildnature.client.gui.screen.ScreenUtils;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.CommonConfig;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.client.gui.GuiUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class WNGeneratorWarningScreen extends Screen {
    private static final ResourceLocation SCREENSHOT = new ResourceLocation("wildnature:textures/gui/images/generator_screenshot.png");

    private int centerWidth, centerHeight;
    private int screenX1, screenY1, screenX2, screenY2;
    private int imageWidth = 904, imageHeight = 506;

    private String header = TextFormatting.BOLD + "WildNature " + WN.version;
    private String body1 = "Choose World Generator";
    private String body2 = "New generator makes your world insane!";
    private String body3 = "It's still being developed, so it's not a final version.";
    private String body4 = "Terrain may still change in future." + TextFormatting.LIGHT_PURPLE + "It's experimental!";
    private String body5 = TextFormatting.RED + "WARNING: " + TextFormatting.RESET + "This makes your world incompatible with already existing worlds.";
    private String configInfo1 = TextFormatting.WHITE + "You can still change this setting whenever you want.";
    private String configInfo2 = TextFormatting.GRAY + "See " + TextFormatting.ITALIC + ".minecraft/config/wildnature-common.toml" + TextFormatting.RESET + TextFormatting.GRAY+ " at "+ TextFormatting.ITALIC +  "generator.generatorType";

    private String buttonNewText = TextFormatting.GOLD + "Use new generator", buttonOldText = TextFormatting.RED + "Use old generator";
    private Button buttonNew, buttonOld;

    public WNGeneratorWarningScreen() {
        super(new StringTextComponent("Generator Warning"));
    }

    public static CompletableFuture<Void> loadAsync(TextureManager texMngr, Executor backgroundExecutor) {
        return CompletableFuture.allOf(texMngr.loadAsync(SCREENSHOT, backgroundExecutor));
    }

    public void removed() {
        NarratorChatListener.INSTANCE.say(I18n.format("narrator.loading.done"));
    }

    public void fill(int x1, int y1, int x2, int y2) {
        fill(x1, y1, x2, y2, -1072689136);
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    @Override
    protected void init() {
        this.centerWidth = this.width / 2;
        this.centerHeight = this.height / 2;


        int properWidth = ScreenUtils.getWidthByResolution(width,(height - 65) - 80, 16,9);

        screenX1 = centerWidth - properWidth;
        screenX2 = centerWidth + properWidth;
        screenY1 = 80;
        screenY2 = height - 65;

        //Main.LOGGER.debug(screenX1 + " "  + screenY1 + " " + screenX2 + " " + screenY2 + " " + width + " " + height);

        buttonNew = this.addButton(new Button(centerWidth - 130, height - 60, 120, 20, buttonNewText, button -> {
            action(true);
        }));
        buttonOld = this.addButton(new Button(centerWidth + 130 - 120, height - 60, 120, 20, buttonOldText, button -> {
            action(false);
        }));

    }

    private void action(boolean clickedNew){
        CommonConfig.generatorType.set(clickedNew ? "new" : "old");
        onClose();
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        renderUIScreen();
        renderInterface();
        super.render(mouseX,mouseY,partialTicks);
    }

    private void renderUIScreen() {
        this.renderBackground();
        //fill(screenX1,screenY1,screenX2,screenY2);
        Minecraft.getInstance().getTextureManager().bindTexture(SCREENSHOT);
        RenderSystem.enableBlend();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        GuiUtils.drawInscribedRect(screenX1, screenY1, screenX2 - screenX1, screenY2 - screenY1, imageWidth, imageHeight, true, false);
    }

    private void renderInterface(){
        this.drawCenteredString(font, header, centerWidth, 10, 16777215);
        this.drawCenteredString(font, body1, centerWidth, 15, 16777215);
        this.drawCenteredString(font, body2, centerWidth, 35, 16777215);
        this.drawCenteredString(font, body3, centerWidth, 45, 16777215);
        this.drawCenteredString(font, body4, centerWidth, 55, 16777215);
        this.drawCenteredString(font, body5, centerWidth, 65, 16777215);

        this.drawCenteredString(font, configInfo1, centerWidth, height - 30, 16777215);
        this.drawCenteredString(font, configInfo2, centerWidth, height - 15, 16777215);


    }

}
