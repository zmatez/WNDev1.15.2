package com.matez.wildnature.world.generation.chunk.generation.noise;

import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import java.util.Random;

public class TestNoiseProcessor implements NoiseProcessor{
    private FastNoise noise;
    @Override
    public void init(long seed, Random random, int octaves) {
        noise = new FastNoise();
        noise.SetFractalLacunarity(2.0f);
        noise.SetFractalGain(0.5f);
        noise.SetFractalOctaves(3);
        noise.SetFractalType(FastNoise.FractalType.RigidMulti);
    }

    @Override
    public boolean canProcess(Biome biome) {
        return biome == Biomes.MOUNTAINS;
    }

    @Override
    public double processNoise(int x, int z, Biome biome, double height, double scale, boolean rawNoise) {
        return noise.GetSimplexFractal(x,z);
    }

    @Override
    public int mixFactor() {
        return 1;
    }
}