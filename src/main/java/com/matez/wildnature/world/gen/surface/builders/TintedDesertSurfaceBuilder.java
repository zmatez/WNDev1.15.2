package com.matez.wildnature.world.gen.surface.builders;

import com.matez.wildnature.Main;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class TintedDesertSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    public TintedDesertSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
        setRegistryName("wildnature", "tinted_desert_surface_builder");
    }


    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        SurfaceBuilderConfig rf = new SurfaceBuilderConfig(Main.getBlockByID("wildnature:sand_red_full").getDefaultState(), Main.getBlockByID("wildnature:sand_red_full").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig rh = new SurfaceBuilderConfig(Main.getBlockByID("wildnature:sand_red_half").getDefaultState(), Main.getBlockByID("wildnature:sand_red_half").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig rs = new SurfaceBuilderConfig(Main.getBlockByID("wildnature:sand_red_slight").getDefaultState(), Main.getBlockByID("wildnature:sand_red_slight").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig bf = new SurfaceBuilderConfig(Main.getBlockByID("wildnature:sand_brown_full").getDefaultState(), Main.getBlockByID("wildnature:sand_brown_full").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig bh = new SurfaceBuilderConfig(Main.getBlockByID("wildnature:sand_brown_half").getDefaultState(), Main.getBlockByID("wildnature:sand_brown_half").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig bs = new SurfaceBuilderConfig(Main.getBlockByID("wildnature:sand_brown_slight").getDefaultState(), Main.getBlockByID("wildnature:sand_brown_slight").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig w = new SurfaceBuilderConfig(Main.getBlockByID("wildnature:sand_white").getDefaultState(), Main.getBlockByID("wildnature:sand_white").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig r = new SurfaceBuilderConfig(Main.getBlockByID("minecraft:red_sand").getDefaultState(), Main.getBlockByID("minecraft:red_sand").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig n = new SurfaceBuilderConfig(Main.getBlockByID("minecraft:sand").getDefaultState(), Main.getBlockByID("minecraft:sand").getDefaultState(), config.getUnderWaterMaterial());

        SurfaceBuilderConfig result = null;

        if (noise > 2D) {
            result = rf;
        } else if (noise > 1.5D) {
            result = rh;
        } else if (noise > 1D) {
            result = rs;
        } else if (noise > 0.5D) {
            result = bf;
        } else if (noise > 0D) {
            result = bh;
        } else if (noise > -0.5D) {
            result = bs;
        } else if (noise > -1D) {
            result = w;
        } else if (noise > -1.5D) {
            result = r;
        } else {
            result = n;
        }

        SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, result);


    }
}