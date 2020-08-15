package com.matez.wildnature.world.gen.surface.configs;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class CanyonSurfaceBuilderConfig extends SurfaceBuilderConfig {
    private final SurfaceBuilder<SurfaceBuilderConfig> config;

    public CanyonSurfaceBuilderConfig(BlockState topMaterial, BlockState underMaterial, BlockState underWaterMaterial, SurfaceBuilder<SurfaceBuilderConfig> config) {
        super(topMaterial, underMaterial, underWaterMaterial);
        this.config = config;
    }

    public CanyonSurfaceBuilderConfig(SurfaceBuilderConfig builderConfig, SurfaceBuilder<SurfaceBuilderConfig> config) {
        super(builderConfig.getTop(), builderConfig.getUnder(), builderConfig.getUnderWaterMaterial());
        this.config = config;
    }

    public static CanyonSurfaceBuilderConfig deserialize(Dynamic<?> p_215455_0_) {
        BlockState blockstate = p_215455_0_.get("top_material").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        BlockState blockstate1 = p_215455_0_.get("under_material").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        BlockState blockstate2 = p_215455_0_.get("underwater_material").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        return new CanyonSurfaceBuilderConfig(blockstate, blockstate1, blockstate2, null);
    }

    public SurfaceBuilder<SurfaceBuilderConfig> getConfig() {
        return config;
    }
}
