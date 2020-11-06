package com.matez.wildnature.client.gui.screen.world.settings.components;

import com.matez.wildnature.client.gui.screen.world.WNWorldSettingsScreen;
import com.matez.wildnature.client.gui.screen.world.settings.SettingSection;
import com.matez.wildnature.client.gui.screen.world.settings.widgets.SettingButton;
import com.matez.wildnature.client.gui.screen.world.settings.widgets.SettingWidget;
import com.matez.wildnature.util.config.world.WorldConfig;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;

public class MultiButtonComponent extends OptionComponent{
    private ArrayList<MultiButton> buttons = new ArrayList<>();
    private boolean multipleSelection;
    public MultiButtonComponent(WorldConfig config, String codename, SettingSection section, String header, String description, boolean multipleSelection) {
        super(config, codename, section, header, description);
        this.multipleSelection = multipleSelection;
    }

    public MultiButtonComponent addButton(String text, boolean defaultValue, ToggleButtonComponent.ToggleAction action){
        int buttonBaseY = buttons.size() * (WNWorldSettingsScreen.BUTTON_DISTANCE + WNWorldSettingsScreen.BUTTON_SIZE);
        int buttonSize = WNWorldSettingsScreen.SETTINGS_SIZE - WNWorldSettingsScreen.MARGIN - WNWorldSettingsScreen.BUTTON_DISTANCE;
        int localId = buttons.size();
        MultiButton button = new MultiButton(10, buttonBaseY, buttonSize, WNWorldSettingsScreen.BUTTON_SIZE,text,localId,defaultValue,id -> {
            if(!multipleSelection){
                for (MultiButton btn : buttons) {
                    if(btn.id == id){
                        btn.setSelected(true);
                        btn.setMessage(TextFormatting.GREEN + btn.defaultText);
                        if(btn.id == localId) {
                            action.action(true);
                        }
                    }else {
                        btn.setSelected(false);
                        btn.setMessage(TextFormatting.RED + btn.defaultText);
                        if(btn.id == localId) {
                            action.action(false);
                        }
                    }
                }
            }else{
                for (MultiButton btn : buttons) {
                    if(btn.id == id){
                        if(btn.isSelected()) {
                            btn.setMessage(TextFormatting.RED + btn.defaultText);
                            btn.setSelected(false);
                            if(btn.id == localId) {
                                action.action(false);
                            }
                        }else{
                            btn.setMessage(TextFormatting.GREEN + btn.defaultText);
                            btn.setSelected(true);
                            if(btn.id == localId) {
                                action.action(true);
                            }
                        }
                    }else {
                        if(!btn.isSelected()) {
                            btn.setMessage(TextFormatting.RED + btn.defaultText);
                            if(btn.id == localId) {
                                action.action(false);
                            }
                        }
                    }
                }
            }
            int[] btnArray = new int[buttons.size()];
            for (int i = 0; i < buttons.size(); i++) {
                MultiButton btn = buttons.get(i);
                btnArray[i] = btn.isSelected() ? 0 : 1;
            }
            config.multiConfig(codename,btnArray);
        });
        if(button.isSelected){
            button.setMessage(TextFormatting.GREEN + button.defaultText);
        }else{
            button.setMessage(TextFormatting.RED + button.defaultText);
        }
        buttons.add(button);
        return this;
    }

    public SettingSection build(){
        int[] btnArray = new int[buttons.size()];
        for (int i = 0; i < buttons.size(); i++) {
            MultiButton btn = buttons.get(i);
            btnArray[i] = btn.isSelected() ? 0 : 1;
        }
        config.multiConfigDefaults(codename,btnArray);
        btnArray = config.getMultiConfig(codename);
        for (int i = 0; i < buttons.size(); i++) {
            MultiButton btn = buttons.get(i);
            btn.setSelected(btnArray[i] == 0);
            if(btn.isSelected){
                btn.setMessage(TextFormatting.GREEN + btn.defaultText);
            }else{
                btn.setMessage(TextFormatting.RED + btn.defaultText);
            }
        }
        return getSection();
    }

    public MultiButton getButtonById(int id){
        for (MultiButton btn : buttons) {
            if(btn.id == id){
                return btn;
            }
        }
        return null;
    }

    @Override
    public SettingWidget[] getWidgets() {
        return buttons.toArray(new MultiButton[0]);
    }

    public interface MultiAction {
        public void action(int action);
    }

    public static class MultiButton extends SettingButton{
        public int id;
        public boolean defaultValue;
        public boolean isSelected;
        public String defaultText = "";
        public MultiAction action;

        public MultiButton(int baseX, int baseY, int width, int height, String text, int id, boolean defaultValue, MultiAction action) {
            super(baseX, baseY, width, height, text, press -> {
                action.action(id);
            });
            this.defaultText = text;
            this.id = id;
            this.defaultValue = defaultValue;
            this.isSelected = defaultValue;
            this.action = action;

            action.action(id);
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public boolean isSelected() {
            return isSelected;
        }
    }
}

