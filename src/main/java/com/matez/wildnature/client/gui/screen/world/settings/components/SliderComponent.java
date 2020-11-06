package com.matez.wildnature.client.gui.screen.world.settings.components;

import com.matez.wildnature.client.gui.screen.world.WNWorldSettingsScreen;
import com.matez.wildnature.client.gui.screen.world.settings.SettingSection;
import com.matez.wildnature.client.gui.screen.world.settings.widgets.SettingSliderWidget;
import com.matez.wildnature.client.gui.screen.world.settings.widgets.SettingWidget;
import com.matez.wildnature.util.config.world.WorldConfig;

public class SliderComponent extends OptionComponent{
    private final SettingSliderWidget sliderWidget;
    public SliderComponent(WorldConfig config, String codename, SettingSection section, String header, String description, String prefix, double minVal, double maxVal, double currentVal, SlideAction action) {
        super(config, codename, section, header, description);
        sliderWidget = new SettingSliderWidget(10,0, WNWorldSettingsScreen.SETTINGS_SIZE - WNWorldSettingsScreen.MARGIN - WNWorldSettingsScreen.BUTTON_DISTANCE, WNWorldSettingsScreen.BUTTON_SIZE,prefix, minVal, maxVal, currentVal, press -> {

        }, change -> {
            config.numberConfig(codename,change.getValue());
            action.action(change, change.getValue());
        });
    }

    @Override
    public SettingWidget[] getWidgets() {
        return new SettingWidget[]{sliderWidget};
    }

    public interface SlideAction {
        public void action(SettingSliderWidget widget, double value);
    }
}
