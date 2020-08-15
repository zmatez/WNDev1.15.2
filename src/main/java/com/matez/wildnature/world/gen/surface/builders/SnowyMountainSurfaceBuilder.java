package com.matez.wildnature.world.gen.surface.builders;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class SnowyMountainSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    private int halfSnowed = 100, fullySnowed = 160;
    private int snowRange = 2;

    public SnowyMountainSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
        setRegistryName("wildnature", "snowy_mountain_surface_builder");
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        int y = startHeight;
        int xhalfsnowed = Utilities.rint(halfSnowed - snowRange, halfSnowed + snowRange, random);
        int xfullysnowed = Utilities.rint(fullySnowed - snowRange, fullySnowed + snowRange, random);
        if (y < xhalfsnowed) {
            if (noise > 1.75D) {
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(STONE, STONE, STONE));
            } else if (noise > -0.95D) {
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(STONE, STONE, STONE));
            } else {
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceRegistry.BROWN_CONFIG);
            }
        } else if (y >= xhalfsnowed && y < xfullysnowed) {
            if (noise > 1.75D) {
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(STONE, STONE, STONE));
            } else if (noise > -0.95D) {
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.SNOW.getDefaultState().with(SnowBlock.LAYERS, Utilities.rint(1, 4, random)), Blocks.SNOW_BLOCK.getDefaultState(), STONE));
            } else {
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceRegistry.BROWN_CONFIG);
            }
        } else {
            if (noise > 1.75D) {
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.SNOW.getDefaultState().with(SnowBlock.LAYERS, Utilities.rint(1, 4, random)), Blocks.SNOW_BLOCK.getDefaultState(), STONE));

            } else if (noise > -0.95D) {
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.SNOW.getDefaultState().with(SnowBlock.LAYERS, Utilities.rint(1, 4, random)), Blocks.SNOW_BLOCK.getDefaultState(), STONE));

            } else {
                SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.SNOW.getDefaultState().with(SnowBlock.LAYERS, Utilities.rint(1, 4, random)), Blocks.SNOW_BLOCK.getDefaultState(), STONE));

            }
        }

    }
}