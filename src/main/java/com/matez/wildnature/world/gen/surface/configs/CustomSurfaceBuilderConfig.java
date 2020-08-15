package com.matez.wildnature.world.gen.surface.configs;

import com.matez.wildnature.world.gen.surface.builders.CustomSurfaceBuilder;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class CustomSurfaceBuilderConfig extends SurfaceBuilderConfig {
    private final CustomSurfaceBuilder.BlockCfg[] cfgs;

    public CustomSurfaceBuilderConfig(CustomSurfaceBuilder.BlockCfg... cfgs) {
        super(Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState());
        this.cfgs = cfgs;
    }

    public static CustomSurfaceBuilderConfig deserialize(Dynamic<?> p_215455_0_) {
        return new CustomSurfaceBuilderConfig();
    }

    public CustomSurfaceBuilder.BlockCfg[] getCfgs() {
        return cfgs;
    }
}
