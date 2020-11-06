package com.matez.wildnature.world.generation.surface.builders;

import com.matez.wildnature.init.WN;
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
        SurfaceBuilderConfig rf = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:sand_red_full").getDefaultState(), WN.getBlockByID("wildnature:sand_red_full").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig rh = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:sand_red_half").getDefaultState(), WN.getBlockByID("wildnature:sand_red_half").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig rs = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:sand_red_slight").getDefaultState(), WN.getBlockByID("wildnature:sand_red_slight").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig bf = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:sand_brown_full").getDefaultState(), WN.getBlockByID("wildnature:sand_brown_full").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig bh = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:sand_brown_half").getDefaultState(), WN.getBlockByID("wildnature:sand_brown_half").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig bs = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:sand_brown_slight").getDefaultState(), WN.getBlockByID("wildnature:sand_brown_slight").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig w = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:sand_white").getDefaultState(), WN.getBlockByID("wildnature:sand_white").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig r = new SurfaceBuilderConfig(WN.getBlockByID("minecraft:red_sand").getDefaultState(), WN.getBlockByID("minecraft:red_sand").getDefaultState(), config.getUnderWaterMaterial());
        SurfaceBuilderConfig n = new SurfaceBuilderConfig(WN.getBlockByID("minecraft:sand").getDefaultState(), WN.getBlockByID("minecraft:sand").getDefaultState(), config.getUnderWaterMaterial());

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