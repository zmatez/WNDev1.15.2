package com.matez.wildnature.client.gui.screen.world.settings;

import com.matez.wildnature.client.gui.screen.world.settings.components.*;
import com.matez.wildnature.client.gui.screen.world.settings.widgets.SettingTextWidget;
import com.matez.wildnature.util.config.world.WorldConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;

import java.util.ArrayList;


public class SettingSection {
    public Minecraft minecraft;
    public int height = 15;
    private final String name;
    private final ArrayList<OptionComponent> components = new ArrayList<>();
    private final String codename;
    private final WorldConfig config;
    public SettingSection(Minecraft minecraft, WorldConfig config, String codename, String name){
        this.codename = codename;
        this.config = config;
        this.name = name;
        this.minecraft = minecraft;
    }

    public String getName() {
        return name;
    }

    public ArrayList<OptionComponent> getComponents() {
        return components;
    }

    public TextComponent addTextComponent(String codename, String header, String description, String defaultText, SettingTextWidget.TextAction action){
        config.textConfigDefaults(codename,defaultText);
        TextComponent component = new TextComponent(config, codename,this,header,description,config.getTextConfig(codename),action);
        components.add(component);
        return component;
    }

    public SettingSection addSlider(String codename, String header, String description, String prefix, int minVal, int maxVal, int defaultValue, SliderComponent.SlideAction action){
        config.numberConfigDefaults(codename,defaultValue);
        SliderComponent component = new SliderComponent(config, codename,this,header,description, prefix, minVal, maxVal, config.getNumberConfig(codename), action);
        components.add(component);
        return this;
    }

    public SettingSection addToggleComponent(String codename, String header, String description, String toggleButtonText, String unToggleButtonText, boolean defaultValue, ToggleButtonComponent.ToggleAction action){
        config.modeConfigDefaults(codename,defaultValue ? 0 : 1);
        ToggleButtonComponent component = new ToggleButtonComponent(config, codename,this,header,description,toggleButtonText,unToggleButtonText,config.getModeConfig(codename) == 0, action);
        components.add(component);
        return this;
    }

    public SettingSection addModeButton(String codename, String header, String description, ModeButtonComponent.ModeAction action, String... options){
        config.modeConfigDefaults(codename,0);
        ModeButtonComponent component = new ModeButtonComponent(config, codename,this,header,description,config.getModeConfig(codename),action,options);
        components.add(component);
        return this;
    }

    public MultiButtonComponent addMultiComponent(String codename, String header, String description, boolean multipleSelection){
        MultiButtonComponent component = new MultiButtonComponent(config, codename,this,header, description, multipleSelection);
        components.add(component);
        return component;
    }
}

