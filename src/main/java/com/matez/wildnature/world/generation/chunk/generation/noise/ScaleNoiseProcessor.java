package com.matez.wildnature.world.generation.chunk.generation.noise;

import com.matez.wildnature.world.generation.noise.OctaveNoiseSampler;
import com.matez.wildnature.world.generation.noise.OpenSimplexNoise;
import net.minecraft.world.biome.Biome;

import java.util.Random;

public class ScaleNoiseProcessor extends NoiseProcessor {
    protected OctaveNoiseSampler<OpenSimplexNoise> heightNoise;
    protected OctaveNoiseSampler<OpenSimplexNoise> scaleNoise;
    protected int octaves;

    @Override
    public void init(long seed, Random random, int octaves) {
        this.octaves = octaves;
        double amplitude = Math.pow(2, octaves);

        this.heightNoise = new OctaveNoiseSampler<>(OpenSimplexNoise.class, random, this.octaves, 0.75 * amplitude, amplitude, amplitude);
        this.scaleNoise = new OctaveNoiseSampler<>(OpenSimplexNoise.class, random, 2, Math.pow(2, 10), 0.2, 0.09);
    }

    @Override
    public boolean smoothedOnBorders() {
        return false;
    }
    /*
        freqModifier high = terrain is _______________------------------ (20)
        freqModifier low = terrain is ___--- (0.25)
        freqModifier really low = terrain is _-_-_-_-_ (0.025)

        amplitude 0.2 = Y77 +/-
        amplitude 2 = over 256 and under 0
        amplitude 0.5 = over 256 and under 0
        amplitude 0.1 = from 190 to 25
        amplitude 0 means flat terrain
     */
    @Override
    public double processNoise(int x, int z, Biome biome, double height, double scale, boolean rawNoise) {
        double frequency = this.scaleNoise.sampleCustom(x, z, 1, -scale, scale, 2);
        double noise = this.heightNoise.sampleCustom(x, z, 1, frequency, frequency, octaves);

        return noise;
    }
}
