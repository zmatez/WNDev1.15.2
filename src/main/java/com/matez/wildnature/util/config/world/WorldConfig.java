package com.matez.wildnature.util.config.world;

import com.matez.wildnature.client.gui.screen.world.WNWorldSettingsScreen;
import com.matez.wildnature.init.WN;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.TextFormatting;

import java.util.Arrays;

public class WorldConfig {
    private CompoundNBT nbt;
    public WorldConfig(){
        this.nbt = new CompoundNBT();
    }

    public void textConfig(String codename, String text){
        if(codename.isEmpty()){
            WN.LOGGER.warn("Missing text config codename! Value: " + text);
        }
        WNWorldSettingsScreen.log(TextFormatting.GRAY + "" + TextFormatting.ITALIC + codename + TextFormatting.RESET + TextFormatting.GRAY + " option was set to " + TextFormatting.ITALIC + (text.length() > 20 ? (text.substring(0,17) + "...") : text));
        nbt.putString(codename,text);
    }

    public void textConfigDefaults(String codename, String defaultText){
        if(!nbt.contains(codename)){
            nbt.putString(codename, defaultText);
        }
    }

    public String getTextConfig(String codename){
        if (nbt.contains(codename)) {
            return nbt.getString(codename);
        }
        WN.LOGGER.warn("Missing text config value! Codename: " + codename);
        return "";
    }

    public void numberConfig(String codename, double number){
        if(codename.isEmpty()){
            WN.LOGGER.warn("Missing number config codename! Value: " + number);
        }
        WNWorldSettingsScreen.log(TextFormatting.GRAY + "" + TextFormatting.ITALIC + codename + TextFormatting.RESET + TextFormatting.GRAY + " option was set to " + TextFormatting.ITALIC + number);
        nbt.putDouble(codename,number);
    }

    public void numberConfigDefaults(String codename, double defaultNumber){
        if(!nbt.contains(codename)){
            nbt.putDouble(codename, defaultNumber);
        }
    }

    public double getNumberConfig(String codename){
        if (nbt.contains(codename)) {
            return nbt.getDouble(codename);
        }
        WN.LOGGER.warn("Missing double config value! Codename: " + codename);
        return 0;
    }

    public void modeConfig(String codename, int mode){
        if(codename.isEmpty()){
            WN.LOGGER.warn("Missing mode config codename! Value: " + mode);
        }
        WNWorldSettingsScreen.log(TextFormatting.GRAY + "" + TextFormatting.ITALIC + codename + TextFormatting.RESET + TextFormatting.GRAY + " option was set to option nr. " + TextFormatting.ITALIC + mode);
        nbt.putInt(codename,mode);
    }

    public void modeConfigDefaults(String codename, int defaultMode){
        if(!nbt.contains(codename)){
            nbt.putInt(codename, defaultMode);
        }
    }

    public int getModeConfig(String codename){
        if (nbt.contains(codename)) {
            return nbt.getInt(codename);
        }
        WN.LOGGER.warn("Missing int config value! Codename: " + codename);
        return 0;
    }

    public void multiConfig(String codename, int[] values){
        if(codename.isEmpty()){
            WN.LOGGER.warn("Missing multi config codename! Value: " + Arrays.toString(values));
        }
        WNWorldSettingsScreen.log(TextFormatting.GRAY + "" + TextFormatting.ITALIC + codename + TextFormatting.RESET + TextFormatting.GRAY + " option was set to values " + TextFormatting.ITALIC + Arrays.toString(values));
        nbt.putIntArray(codename,values);
    }

    public void multiConfigDefaults(String codename, int[] defaultValues){
        if(!nbt.contains(codename)){
            nbt.putIntArray(codename, defaultValues);
        }
    }

    public int[] getMultiConfig(String codename){
        if (nbt.contains(codename)) {
            return nbt.getIntArray(codename);
        }
        WN.LOGGER.warn("Missing int config value! Codename: " + codename);
        return new int[0];
    }

}
