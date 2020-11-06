package com.matez.wildnature.client.gui.screen.world.settings.components;

import com.matez.wildnature.client.gui.screen.world.WNWorldSettingsScreen;
import com.matez.wildnature.client.gui.screen.world.settings.SettingSection;
import com.matez.wildnature.client.gui.screen.world.settings.widgets.SettingButton;
import com.matez.wildnature.client.gui.screen.world.settings.widgets.SettingWidget;
import com.matez.wildnature.util.config.world.WorldConfig;

import java.util.ArrayList;

public class ModeButtonComponent extends OptionComponent{
    public final ArrayList<ModeButton> buttons = new ArrayList<>();
    public SettingButton button;
    public int selectedIndex = 0;
    public ModeButtonComponent(WorldConfig config, String codename, SettingSection section, String header, String description, int defaultValue, ModeAction action, String... options) {
        super(config,codename, section, header, description);
        for(int i = 0; i < options.length; i++){
            buttons.add(new ModeButton(options[i],i));
        }
        this.selectedIndex = defaultValue;
        button = new SettingButton(10,0, WNWorldSettingsScreen.SETTINGS_SIZE - WNWorldSettingsScreen.MARGIN - WNWorldSettingsScreen.BUTTON_DISTANCE, WNWorldSettingsScreen.BUTTON_SIZE,buttons.get(0).getText(),press -> {
            if(selectedIndex >= buttons.size() -1){
                selectedIndex = 0;
            }else{
                selectedIndex ++;
            }
            press.setMessage(buttons.get(selectedIndex).getText());
            config.modeConfig(codename,selectedIndex);
            action.action(selectedIndex,buttons.get(selectedIndex).getText());
        });
        button.setMessage(buttons.get(defaultValue).getText());
    }

    @Override
    public SettingWidget[] getWidgets() {
        return new SettingWidget[]{button};
    }

    public interface ModeAction{
        public void action(int selection, String selectedText);
    }

    public static class ModeButton{
        public String text;
        public int id;
        public ModeButton(String text, int id){
            this.text = text;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getText() {
            return text;
        }
    }
}
