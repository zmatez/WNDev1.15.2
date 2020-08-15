package com.matez.wildnature.world.gen.surface.builders;

import com.matez.wildnature.Main;
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

public class XMASSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {


    public XMASSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
        super(p_i51305_1_);
        setRegistryName("wildnature", "christmas_surface_builder");
    }


    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        if (noise > 1.6D) {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(Blocks.SNOW.getDefaultState().with(SnowBlock.LAYERS, Utilities.rint(1, 3, new Random())), Blocks.SNOW_BLOCK.getDefaultState(), Main.getBlockByID("minecraft:gravel").getDefaultState()));
        } else {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceRegistry.BROWN_CONFIG);
        }
    }
}
