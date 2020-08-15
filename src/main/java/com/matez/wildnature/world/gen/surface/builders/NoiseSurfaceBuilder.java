package com.matez.wildnature.world.gen.surface.builders;

import com.matez.wildnature.world.gen.surface.configs.Noise2SurfaceBuilderConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import java.util.Random;
import java.util.function.Function;

public class NoiseSurfaceBuilder extends SurfaceBuilder<Noise2SurfaceBuilderConfig> {
    private double fRarity = -0.95D;

    public NoiseSurfaceBuilder(Function<Dynamic<?>, ? extends Noise2SurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
        setRegistryName("wildnature", "noise2_surface_builder");
    }

    public NoiseSurfaceBuilder(Function<Dynamic<?>, ? extends Noise2SurfaceBuilderConfig> p_i51312_1_, double fRarity) {
        super(p_i51312_1_);
        this.fRarity = fRarity;
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, Noise2SurfaceBuilderConfig config) {
        if (noise > fRarity) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config.getConfig1());
        } else {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config.getConfig2());
        }

    }
}