package com.matez.wildnature.blocks;

import net.minecraft.util.ResourceLocation;

public class GreenBeansBush extends CornPlant {
    public GreenBeansBush(Properties properties, ResourceLocation regName) {
        super(properties, regName);
    }

    @Override
    public String getDrop() {
        return "green_beans";
    }

    @Override
    public String getBush() {
        return "wildnature:green_bean_bush";
    }
}
