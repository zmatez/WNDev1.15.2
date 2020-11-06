package com.matez.wildnature.world.generation.biome.setup;

import com.matez.wildnature.util.config.CommonConfig;
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
