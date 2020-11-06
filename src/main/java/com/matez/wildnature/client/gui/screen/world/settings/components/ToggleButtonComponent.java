package com.matez.wildnature.client.gui.screen.world.settings.components;

import com.matez.wildnature.client.gui.screen.world.WNWorldSettingsScreen;
import com.matez.wildnature.client.gui.screen.world.settings.SettingSection;
import com.matez.wildnature.client.gui.screen.world.settings.utils.ComponentUtils;
import com.matez.wildnature.client.gui.screen.world.settings.widgets.SettingButton;
import com.matez.wildnature.client.gui.screen.world.settings.widgets.SettingWidget;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.world.WorldConfig;

public class ToggleButtonComponent extends OptionComponent{
    private SettingButton toggleButton = null;
    private SettingButton unToggleButton = null;
    public ToggleButtonComponent(WorldConfig config, String codename, SettingSection section, String header, String description, String toggleButtonText, String unToggleButtonText, boolean defaultValue, ToggleAction action) {
        super(config, codename, section, header, description);
        int screenSize = WNWorldSettingsScreen.SETTINGS_SIZE;
        int buttonSize = toggleButtonText.length() > unToggleButtonText.length() ? ComponentUtils.calculateButtonSize(toggleButtonText) : ComponentUtils.calculateButtonSize(unToggleButtonText);

        if(buttonSize * 2 + 20 >= screenSize){
            //two rows
            WN.LOGGER.debug("TWO");
            buttonSize = WNWorldSettingsScreen.SETTINGS_SIZE - WNWorldSettingsScreen.MARGIN - WNWorldSettingsScreen.BUTTON_DISTANCE;

            this.toggleButton = new SettingButton(10,0, buttonSize, WNWorldSettingsScreen.BUTTON_SIZE, toggleButtonText, press -> {
                press.active = false;
                unToggleButton.active = true;
                action.action(true);
                save();
            });
            this.unToggleButton = new SettingButton(10,WNWorldSettingsScreen.BUTTON_DISTANCE + WNWorldSettingsScreen.BUTTON_SIZE, buttonSize, WNWorldSettingsScreen.BUTTON_SIZE, unToggleButtonText, press -> {
                press.active = false;
                toggleButton.active = true;
                action.action(false);
                save();
            });
        }else{
            //one row
            WN.LOGGER.debug("ONE");
            buttonSize = (WNWorldSettingsScreen.SETTINGS_SIZE - WNWorldSettingsScreen.MARGIN ) / 2 - WNWorldSettingsScreen.BUTTON_DISTANCE;

            this.toggleButton = new SettingButton(10,0, buttonSize, WNWorldSettingsScreen.BUTTON_SIZE, toggleButtonText, press -> {
                press.active = false;
                unToggleButton.active = true;
                action.action(true);
                save();
            });
            this.unToggleButton = new SettingButton(buttonSize + 10 + WNWorldSettingsScreen.BUTTON_DISTANCE,0, buttonSize, WNWorldSettingsScreen.BUTTON_SIZE, unToggleButtonText, press -> {
                press.active = false;
                toggleButton.active = true;
                action.action(false);
                save();
            });
        }

        if(defaultValue){
            this.toggleButton.onPress();
        }else{
            this.unToggleButton.onPress();
        }
    }

    public void save(){
        config.modeConfig(codename, toggleButton.active ? 0 : 1);
    }

    @Override
    public SettingWidget[] getWidgets() {
        return new SettingWidget[]{toggleButton,unToggleButton};
    }

    public interface ToggleAction{
        public void action(boolean isToggled);
    }
}

