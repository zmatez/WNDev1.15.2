package com.matez.wildnature.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class PlanksBase extends BlockBase {
    private static Properties Properties(Properties properties){

        properties.hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD);

        return properties;
    }

    public PlanksBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(Properties(properties), builder, regName);
    }
}
