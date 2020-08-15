package com.matez.wildnature.world.gen.surface.builders;

import com.matez.wildnature.world.gen.surface.configs.Noise3SurfaceBuilderConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import java.util.Random;
import java.util.function.Function;

public class Noise3xSurfaceBuilder extends SurfaceBuilder<Noise3SurfaceBuilderConfig> {
    public Noise3xSurfaceBuilder(Function<Dynamic<?>, ? extends Noise3SurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
        setRegistryName("wildnature", "noise3_surface_builder");
    }


    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, Noise3SurfaceBuilderConfig config) {
        if (noise > 1.75D) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config.getConfig1());

        } else if (noise > -0.95D) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config.getConfig2());

        }

        SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config.getConfig3());


    }
}