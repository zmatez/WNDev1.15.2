package com.matez.wildnature.client.gui.screen.world.settings.components;

import com.matez.wildnature.client.gui.screen.world.settings.SettingSection;
import com.matez.wildnature.client.gui.screen.world.settings.widgets.SettingWidget;
import com.matez.wildnature.util.config.world.WorldConfig;
import net.minecraft.client.gui.widget.Widget;

import java.util.ArrayList;

public abstract class OptionComponent {
    public String header, description;
    public int height;
    public SettingSection section;
    public WorldConfig config;
    public String codename;

    public OptionComponent(WorldConfig config, String codename, SettingSection section, String header, String description) {
        this.config = config;
        this.codename = codename;
        this.section = section;
        this.header = header;
        this.description = description;
    }

    public SettingSection getSection() {
        return section;
    }

    public void init(){
        int widgetHeight = 0;
        for (Widget widget : getWidgets()) {
            widgetHeight += widget.getHeight() + 5;
        }

        this.height = 15 + getDescriptionLines().size() * 15 + widgetHeight;
    }

    public ArrayList<String> getDescriptionLines(){
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder actualString = new StringBuilder();
        for(char c : description.toCharArray()){
            if(c == '\n'){
                strings.add(actualString.toString());
                actualString = new StringBuilder();
            }else{
                actualString.append(c);
            }
        }
        strings.add(actualString.toString());
        return strings;
    }

    public abstract SettingWidget[] getWidgets();
}
