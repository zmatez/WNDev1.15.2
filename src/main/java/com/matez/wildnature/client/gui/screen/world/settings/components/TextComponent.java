package com.matez.wildnature.client.gui.screen.world.settings.components;

import com.matez.wildnature.client.gui.screen.world.WNWorldSettingsScreen;
import com.matez.wildnature.client.gui.screen.world.settings.SettingSection;
import com.matez.wildnature.client.gui.screen.world.settings.widgets.SettingTextWidget;
import com.matez.wildnature.client.gui.screen.world.settings.widgets.SettingWidget;
import com.matez.wildnature.util.config.world.WorldConfig;

public class TextComponent extends OptionComponent{
    private final SettingTextWidget textWidget;
    public TextComponent(WorldConfig config, String codename, SettingSection section, String header, String description, String text, SettingTextWidget.TextAction action) {
        super(config, codename, section, header, description);
        textWidget = new SettingTextWidget(section.minecraft.fontRenderer, 10,0, WNWorldSettingsScreen.SETTINGS_SIZE - WNWorldSettingsScreen.MARGIN - WNWorldSettingsScreen.BUTTON_DISTANCE, WNWorldSettingsScreen.BUTTON_SIZE, text,act -> {
            config.textConfig(codename,act);
            action.action(act);
        });
    }

    public SettingTextWidget getTextWidget() {
        return textWidget;
    }

    @Override
    public SettingWidget[] getWidgets() {
        return new SettingWidget[]{textWidget};
    }


}
