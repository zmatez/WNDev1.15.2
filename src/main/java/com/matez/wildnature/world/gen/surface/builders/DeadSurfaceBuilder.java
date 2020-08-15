package com.matez.wildnature.world.gen.surface.builders;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class DeadSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    public DeadSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
        setRegistryName("wildnature", "dead_surface_builder");
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        int i = Utilities.rint(0, 1, random);
        if (i == 0) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Main.getBlockByID("minecraft:dirt").getDefaultState(), Main.getBlockByID("minecraft:dirt").getDefaultState(), Main.getBlockByID("minecraft:dirt").getDefaultState()));
        } else if (i == 1) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Main.getBlockByID("minecraft:coarse_dirt").getDefaultState(), Main.getBlockByID("minecraft:dirt").getDefaultState(), Main.getBlockByID("minecraft:dirt").getDefaultState()));

        }

    }
}
