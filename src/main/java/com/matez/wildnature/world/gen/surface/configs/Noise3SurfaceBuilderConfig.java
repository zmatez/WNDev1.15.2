package com.matez.wildnature.world.gen.surface.configs;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class Noise3SurfaceBuilderConfig extends SurfaceBuilderConfig {
    private final SurfaceBuilderConfig config1, config2, config3;

    public Noise3SurfaceBuilderConfig(SurfaceBuilderConfig config1, SurfaceBuilderConfig config2, SurfaceBuilderConfig config3) {
        super(Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState());
        this.config1 = config1;
        this.config2 = config2;
        this.config3 = config3;
    }

    public static Noise3SurfaceBuilderConfig deserialize(Dynamic<?> p_215455_0_) {
        return new Noise3SurfaceBuilderConfig(null, null, null);
    }

    public SurfaceBuilderConfig getConfig1() {
        return config1;
    }

    public SurfaceBuilderConfig getConfig2() {
        return config2;
    }

    public SurfaceBuilderConfig getConfig3() {
        return config3;
    }
}
