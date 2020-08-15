package com.matez.wildnature.world.gen.carvers;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.EmptyCarverConfig;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class WNPathCarver extends WorldCarver<EmptyCarverConfig> {
    public WNPathCarver(Function<Dynamic<?>, ? extends EmptyCarverConfig> p_i49921_1_, int p_i49921_2_) {
        super(p_i49921_1_, p_i49921_2_);
    }

    @Override
    public boolean func_225555_a_(IChunk chunkIn, Function<BlockPos, Biome> p_225555_2_, Random p_225555_3_, int p_225555_4_, int p_225555_5_, int p_225555_6_, int p_225555_7_, int p_225555_8_, BitSet p_225555_9_, EmptyCarverConfig p_225555_10_) {
        return false;
    }

    @Override
    public boolean shouldCarve(Random rand, int chunkX, int chunkZ, EmptyCarverConfig config) {
        return false;
    }

    @Override
    protected boolean func_222708_a(double p_222708_1_, double p_222708_3_, double p_222708_5_, int p_222708_7_) {
        return false;
    }
}
