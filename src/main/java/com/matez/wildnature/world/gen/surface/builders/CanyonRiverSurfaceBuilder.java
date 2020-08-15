package com.matez.wildnature.world.gen.surface.builders;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class CanyonRiverSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    public CanyonRiverSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
        setRegistryName("wildnature", "canyon_river_surface_builder");
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        int realHeight = startHeight;
        while (realHeight > seaLevel - 5) {
            if (realHeight >= seaLevel) {
                chunkIn.setBlockState(new BlockPos(x, realHeight, z), Blocks.AIR.getDefaultState(), false);
            } else {
                chunkIn.setBlockState(new BlockPos(x, realHeight, z), Blocks.WATER.getDefaultState(), false);

            }
            realHeight--;
        }
        SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, realHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
    }
}
