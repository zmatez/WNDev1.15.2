package com.matez.wildnature.world.gen.surface.builders;

import com.matez.wildnature.Main;
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

public class CrackedSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

    public CrackedSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
        setRegistryName("wildnature", "cracked_surface_builder");
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        if (noise > 2D) {

        } else if (noise > 1.5D) {

        } else if (noise > 1D) {

        } else if (noise > 0.5D) {

        } else if (noise > 0D) {

        } else if (noise > -0.5D) {

        } else if (noise > -1D) {

        } else if (noise > -1.5D) {
            chunkIn.setBlockState(new BlockPos(x, startHeight - 1, z), Blocks.AIR.getDefaultState(), false);
            chunkIn.setBlockState(new BlockPos(x, startHeight - 2, z), Blocks.AIR.getDefaultState(), false);
            chunkIn.setBlockState(new BlockPos(x, startHeight - 3, z), Blocks.AIR.getDefaultState(), false);
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight - 4, noise, Main.getBlockByID("sand_brown_full").getDefaultState(), defaultFluid, seaLevel, seed, config);
            return;
        } else {

        }
        SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);

    }
}
