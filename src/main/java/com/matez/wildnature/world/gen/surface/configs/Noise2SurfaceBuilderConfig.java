package com.matez.wildnature.world.gen.surface.configs;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class Noise2SurfaceBuilderConfig extends SurfaceBuilderConfig {
    private final SurfaceBuilderConfig config1, config2;

    public Noise2SurfaceBuilderConfig(SurfaceBuilderConfig config1, SurfaceBuilderConfig config2) {
        super(Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState());
        this.config1 = config1;
        this.config2 = config2;
    }

    public static Noise2SurfaceBuilderConfig deserialize(Dynamic<?> p_215455_0_) {
        return new Noise2SurfaceBuilderConfig(null, null);
    }

    public SurfaceBuilderConfig getConfig1() {
        return config1;
    }

    public SurfaceBuilderConfig getConfig2() {
        return config2;
    }
}
