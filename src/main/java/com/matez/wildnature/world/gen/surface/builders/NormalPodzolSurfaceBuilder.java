package com.matez.wildnature.world.gen.surface.builders;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class NormalPodzolSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    public NormalPodzolSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
        setRegistryName("wildnature", "normal_podzol_surface_builder");
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        SurfaceBuilderConfig podzolConfig = new SurfaceBuilderConfig(Main.getBlockByID("minecraft:podzol").getDefaultState(), config.getUnderWaterMaterial(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig coarseConfig = new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(), config.getUnderWaterMaterial(), config.getUnderWaterMaterial());
        if (noise > -0.95D) {
            if (Utilities.rint(0, 1) == 0) {
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, podzolConfig);
            } else {
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, coarseConfig);
            }
        } else {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
        }

    }
}