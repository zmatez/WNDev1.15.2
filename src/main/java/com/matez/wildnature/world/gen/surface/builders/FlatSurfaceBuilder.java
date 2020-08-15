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

public class FlatSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {


    public FlatSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
        super(p_i51305_1_);
        setRegistryName("wildnature", "flat_surface_builder");
    }


    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        boolean tooBig = startHeight > seaLevel;
        int height = startHeight;
        while ((height > seaLevel || height < seaLevel)) {
            if (tooBig) {
                chunkIn.setBlockState(new BlockPos(x, height, z), Blocks.AIR.getDefaultState(), false);
                height--;
            } else {
                chunkIn.setBlockState(new BlockPos(x, height, z), Blocks.AIR.getDefaultState(), false);
                height++;
            }
        }

        SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, height, noise, defaultBlock, defaultFluid, seaLevel, seed, new SurfaceBuilderConfig(config.getTop(), config.getUnder(), config.getUnderWaterMaterial()));

    }
}
