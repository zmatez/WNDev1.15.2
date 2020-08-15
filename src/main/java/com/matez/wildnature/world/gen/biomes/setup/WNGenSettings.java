package com.matez.wildnature.world.gen.biomes.setup;

import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.customizable.CommonConfig;
import net.minecraft.world.gen.OverworldGenSettings;

public class WNGenSettings extends OverworldGenSettings {
    @Override
    public int getBiomeSize() {
        return CommonConfig.biomeSize.get();
    }

    @Override
    public int getRiverSize() {
        return CommonConfig.riverSize.get();
    }
}
