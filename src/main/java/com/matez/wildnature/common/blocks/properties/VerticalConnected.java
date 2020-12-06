package com.matez.wildnature.common.blocks.properties;

import net.minecraft.util.IStringSerializable;

public enum VerticalConnected implements IStringSerializable {
    SINGLE("single"),
    TOP("top"),
    MIDDLE("middle"),
    BOTTOM("bottom");

    private final String name;

    private VerticalConnected(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public String getName() {
        return this.name;
    }

}