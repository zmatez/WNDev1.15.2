package com.matez.wildnature.client.gui.screen.world.settings;

import com.matez.wildnature.client.gui.screen.world.WNWorldSettingsScreen;
import com.matez.wildnature.client.gui.screen.world.settings.components.OptionComponent;
import com.matez.wildnature.client.gui.screen.world.settings.widgets.SettingWidget;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.world.WorldConfig;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.gui.ScrollPanel;

import java.util.ArrayList;
import java.util.List;

public class WorldSettings {
    private final ArrayList<SettingSection> sections = new ArrayList<>();
    private final int screenX, screenZ;
    private final int width, height;
    private ScrollPanel scrollPanel;
    private final Screen screen;
    private final WorldConfig worldConfig;

    public WorldSettings(Screen screen, int screenX, int screenZ, int width, int height) {
        this.screenX = screenX;
        this.screenZ = screenZ;
        this.width = width;
        this.height = height;
        this.screen = screen;
        this.worldConfig = new WorldConfig();
    }

    public void initSections() {
        addSection("first","Siemanko").addToggleComponent("","Oto jest przykład", "Fajne co nie,\nteż mi się tak zdaje\ndobra koniec juz", "Tak", "Nie", true, bool -> {
            WN.LOGGER.debug("CLICK " + bool);
        }).addToggleComponent("","Oto jest przykład 2", "Nic tu nie ma", "OKEJ ZARĄBISCIE SUEPER", "spok", true, bool -> {
            WN.LOGGER.debug("CLICK2 " + bool);
        }).addToggleComponent("","Oto jest przykład 3", "Fajne co nie,\nteż mi się tak zdaje\ndobra koniec juz\nxd\njanusz grzyb tanczy", "Nie wiem", "Chyba nie", true, bool -> {
            WN.LOGGER.debug("CLICK3 " + bool);
        }).addMultiComponent("","Przyklad multi", "oto on", false)
                .addButton("Pierwszy przycisk", true, bool -> {
                    WN.LOGGER.debug("BTN 1" + bool);
                }).addButton("Drugi przycisk", false, bool -> {
                    WN.LOGGER.debug("BTN 2" + bool);
                }).addButton("Trzeci przycisk", true, bool -> {
                    WN.LOGGER.debug("BTN 3" + bool);
                }).addButton("Czwarty przycisk", true, bool -> {
                    WN.LOGGER.debug("BTN 4" + bool);
                }).getSection().addModeButton("","Przykład mode","tenteges",(index,text) -> {
                    WN.LOGGER.debug("MODE: " + index + " " + text);
        }, "Janusz","Grzyb","Tańczy").addTextComponent("","Tekst","text component","Przykladowy tekst",text -> {
            WN.LOGGER.debug("TEXT INPUT " + text);
        }).getSection().addSlider("","Slider","That's a slider","Prefix",-10,10,0,(slider, slide) -> {
            WN.LOGGER.debug("SlIDE: " + slide);
        });

        addSection("second", "SiemankoXDDDDD").addToggleComponent("","Oto jest przykład", "Fajne co nie,\nteż mi się tak zdaje\ndobra koniec juz", "Tak", "Nie", true, bool -> {
            WN.LOGGER.debug("CLICK " + bool);
        }).addToggleComponent("","Oto jest przykład 2", "Nic tu nie ma", "OKEJ ZARĄBISCIE SUEPER", "spok", true, bool -> {
            WN.LOGGER.debug("CLICK2 " + bool);
        }).addToggleComponent("","Oto jest przykład 3", "Fajne co nie,\nteż mi się tak zdaje\ndobra koniec juz\nxd\njanusz grzyb tanczy", "Nie wiem", "Chyba nie", true, bool -> {
            WN.LOGGER.debug("CLICK3 " + bool);
        });


        initComponents();
        initScrollPanel();
    }

    public void initComponents() {
        for (SettingSection section : sections) {
            for (OptionComponent component : section.getComponents()) {
                component.init();
                for (Widget widget : component.getWidgets()) {
                    ((List<IGuiEventListener>) screen.children()).add(widget);
                }
            }
        }
    }

    public void initScrollPanel() {
        this.scrollPanel = new ScrollPanel(screen.getMinecraft(), width, height, screenX, screenZ) {
            private int contentHeight = this.height;

            @Override
            protected int getContentHeight() {
                return Math.max(drawPanel(true, 0, 0, null, 0, 0), this.height);
            }

            @Override
            protected void drawPanel(int entryRight, int relativeY, Tessellator tess, int mouseX, int mouseY) {
                drawPanel(false, entryRight, relativeY, tess, mouseX, mouseY);
            }

            protected int drawPanel(boolean fakeDraw, int entryRight, int relativeY, Tessellator tess, int mouseX, int mouseY) {
                int relativeX = screenX;
                int actualY = 0;
                int fontSize = screen.getMinecraft().fontRenderer.FONT_HEIGHT;
                for (SettingSection section : sections) {
                    int posSection = actualY;
                    if (!fakeDraw) {
                        WNWorldSettingsScreen.fillColor(relativeX + 5, relativeY + posSection, width - 5, relativeY + posSection + 1, 0xeeeeee);
                    }
                    int posSectionName = posSection + 10;
                    if (!fakeDraw) {
                        screen.drawString(screen.getMinecraft().fontRenderer, TextFormatting.BOLD + section.getName(), relativeX + 30, relativeY + posSectionName, 16777215);
                    }
                    int posComponentStart = posSectionName + 15;
                    int componentActualY = 0;
                    for (OptionComponent component : section.getComponents()) {
                        int posComponent = posComponentStart + componentActualY;
                        if (!fakeDraw) {
                            WNWorldSettingsScreen.fillColor(relativeX + 5, relativeY + posComponent + (fontSize / 2) - 1, relativeX + 15, relativeY + posComponent + 1 + (fontSize / 2) - 1, 0x707070);
                            screen.drawString(screen.getMinecraft().fontRenderer, component.header, relativeX + 20, relativeY + posComponent, 16777215);
                        }
                        int posDescriptionStart = posComponent + 10;
                        int descriptionMax = 0;
                        for (String descriptionLine : component.getDescriptionLines()) {
                            int posDescription = posDescriptionStart + descriptionMax;
                            if (!fakeDraw) {
                                screen.drawString(screen.getMinecraft().fontRenderer, TextFormatting.GRAY + descriptionLine, relativeX + 15, relativeY + posDescription, 16777215);
                            }
                            descriptionMax += 10;
                        }
                        if (!fakeDraw) {
                            WNWorldSettingsScreen.fillColor(relativeX + 4, relativeY + posDescriptionStart - 3, relativeX + 5, relativeY + posDescriptionStart + descriptionMax, 0x707070);
                        }
                        int widgetStart = posDescriptionStart + descriptionMax + 10;
                        int widgetMax = 0;
                        int maxWidgetY = -1;
                        int maxWidgetYHeight = -1;
                        for (SettingWidget widget : component.getWidgets()) {
                            if (!fakeDraw) {
                                widget.setPosition(relativeX, relativeY + widgetStart);
                                widget.render(mouseX, mouseY, 0);
                            }
                            if(maxWidgetY < widget.baseY){
                                maxWidgetY = widget.baseY;
                                maxWidgetYHeight = widget.getHeight();
                            }
                        }
                        widgetMax += maxWidgetY + maxWidgetYHeight + 5;

                        componentActualY += descriptionMax + 10 + widgetMax + 20;
                    }
                    if (!fakeDraw) {
                        //WNWorldSettingsScreen.fillColor(relativeX + 4, relativeY + posSection, relativeX + 5, relativeY +  componentActualY + 15 + 1, 0xffffff);
                        //WNWorldSettingsScreen.fillColor(relativeX + 5, relativeY + componentActualY + 15, width - 5, relativeY + componentActualY + 15 + 1, 0xffffff);
                    }
                    actualY += 15 + componentActualY + 15;
                }
                contentHeight = actualY;
                return contentHeight;
            }

            @Override
            public boolean mouseScrolled(double mouseX, double mouseY, double scroll) {
                return super.mouseScrolled(mouseX, mouseY, scroll);

            }
        };
        ((List<IGuiEventListener>) screen.children()).add(scrollPanel);
    }


    public SettingSection addSection(String codename, String name) {
        SettingSection settingSection = new SettingSection(screen.getMinecraft(),worldConfig, codename, name);
        sections.add(settingSection);
        return settingSection;
    }


    public void render(int mouseX, int mouseY, float partialTicks) {
        scrollPanel.render(mouseX, mouseY, partialTicks);
    }
}
