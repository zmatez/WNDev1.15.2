package com.matez.wildnature.client.gui.screen.world;


import com.matez.wildnature.client.gui.screen.world.settings.WorldSettings;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.CreateWorldScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

public class WNWorldSettingsScreen extends Screen {
    public static int SETTINGS_SIZE = 300;
    public static int BUTTON_DISTANCE = 10;
    public static int BUTTON_SIZE = 20;
    public static int MARGIN = 20;

    private static String logMessage = "";

    private CreateWorldScreen parent;
    private CompoundNBT nbt;

    private WorldSettings worldSettings;

    private int centerWidth, centerHeight;


    private String header = TextFormatting.BOLD + "WildNature Terrain Generator";
    private String version = "Version 0.1 --- " + TextFormatting.RED + " WORK IN PROGRESS - press ESC to exit";

    private Button saveButton, cancelButton, savePresetButton;


    public WNWorldSettingsScreen(CreateWorldScreen parentScreen, CompoundNBT nbt) {
        super(new StringTextComponent("WildNature Terrain Generator"));
        this.parent = parentScreen;
        this.nbt = nbt;
    }

    public void removed() {
        NarratorChatListener.INSTANCE.say(I18n.format("narrator.loading.done"));
    }

    public static void fill(int x1, int y1, int x2, int y2) {
        fill(x1, y1, x2, y2, -1072689136);
    }

    public static void fillColor(int x1, int y1, int x2, int y2, int hex) {
        fill(x1, y1, x2, y2, Utilities.getColorValue(hex));
    }

    public boolean shouldCloseOnEsc() {
        return true;//
    }

    @Override
    protected void init() {
        this.centerWidth = this.width / 2;
        this.centerHeight = this.height / 2;

        SETTINGS_SIZE = width / 3;
        if(SETTINGS_SIZE > 300){
            SETTINGS_SIZE = 300;
        }

        int buttonSize = 100;
        savePresetButton = new Button(width - MARGIN - buttonSize,height - (MARGIN * 2)+ MARGIN,buttonSize,BUTTON_SIZE, "Save as preset", press -> {

        });
        addButton(savePresetButton);
        cancelButton = new Button(width - MARGIN - buttonSize - BUTTON_DISTANCE - BUTTON_DISTANCE - buttonSize , height - (MARGIN * 2)+ MARGIN,buttonSize,BUTTON_SIZE, "Cancel", press -> {

        });
        addButton(cancelButton);
        saveButton = new Button(width - MARGIN - buttonSize - BUTTON_DISTANCE - BUTTON_DISTANCE - buttonSize - BUTTON_DISTANCE - buttonSize,height - (MARGIN * 2)+ MARGIN,buttonSize,BUTTON_SIZE, "Save", press -> {

        });
        addButton(saveButton);

        worldSettings = new WorldSettings(this,MARGIN,MARGIN,SETTINGS_SIZE, height - (MARGIN * 2));
        worldSettings.initSections();
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        renderUIScreen();
        renderInterface(mouseX,mouseY,partialTicks);
        super.render(mouseX,mouseY,partialTicks);
    }

    private void renderUIScreen() {
        this.renderBackground();

    }

    private void renderInterface(int mouseX, int mouseY, float partialTicks){
        drawString(getMinecraft().fontRenderer, header + "   " + TextFormatting.GRAY + version, (int)(MARGIN * 1.5), MARGIN / 2, 16777215);
        drawString(getMinecraft().fontRenderer, TextFormatting.GRAY + logMessage, (int)(MARGIN * 1.5), height - (int)(MARGIN / 1.5), 16777215);
        worldSettings.render(mouseX, mouseY, partialTicks);
        fill(SETTINGS_SIZE + MARGIN, MARGIN, SETTINGS_SIZE + MARGIN + MARGIN, height - (MARGIN * 2) + MARGIN);//toolbox
        fill(SETTINGS_SIZE + (MARGIN / 2) + (MARGIN * 2), MARGIN, width - MARGIN, height - (MARGIN * 2)+ MARGIN);

    }

    public static void log(String logMessage) {
        WNWorldSettingsScreen.logMessage = logMessage;
    }
}
