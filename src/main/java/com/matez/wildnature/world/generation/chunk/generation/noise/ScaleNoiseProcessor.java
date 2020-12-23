package com.matez.wildnature.world.generation.chunk.generation.noise;

import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.noise.OctaveNoiseSampler;
import com.matez.wildnature.world.generation.noise.OpenSimplexNoise;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoiseLite;
import net.minecraft.world.biome.Biome;

import java.util.Random;

public class ScaleNoiseProcessor extends NoiseProcessor {
    protected OctaveNoiseSampler<OpenSimplexNoise> heightNoise;
    protected OctaveNoiseSampler<OpenSimplexNoise> scaleNoise;
    protected int octaves;
    protected FastNoiseLite cliffNoise, cliffNoiseMask;

    @Override
    public void init(long seed, Random random, int octaves) {
        this.octaves = octaves;
        double amplitude = Math.pow(2, octaves);

        this.heightNoise = new OctaveNoiseSampler<>(OpenSimplexNoise.class, random, this.octaves, 0.75 * amplitude, amplitude, amplitude);
        this.scaleNoise = new OctaveNoiseSampler<>(OpenSimplexNoise.class, random, 2, Math.pow(2, 10), 0.2, 0.09);

        this.cliffNoise = new FastNoiseLite((int)seed);
        this.cliffNoise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2S);
        this.cliffNoise.SetFrequency(0.001F);

        this.cliffNoiseMask = new FastNoiseLite((int)seed + 1);
        this.cliffNoiseMask.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2S);
        this.cliffNoiseMask.SetFrequency(0.005F);
    }

    public FastNoiseLite getCliffNoise() {
        return cliffNoise;
    }

    public FastNoiseLite getCliffNoiseMask() {
        return cliffNoiseMask;
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
    // /tp 5426.13 126.81 -321.16
    @Override
    public double processNoise(int x, int z, Biome biome, double height, double scale, double freqModifier, double hilliness, double frequencyMin, double frequencyMax, double[] args, boolean rawNoise) {
        double frequency = this.scaleNoise.sampleCustom(x, z, hilliness, frequencyMin, frequencyMax, 2);

        double noise = this.heightNoise.sampleCustom(x,  z, freqModifier, frequency, frequency, octaves);
        /*double cliffNoise = this.cliffNoise.GetNoise(x,z);
        double cliffNoiseMask = this.cliffNoiseMask.GetNoise(x,z);
        if(cliffNoise > 0.6F){
            double cliffFactor = Utilities.scaleBetween(cliffNoise,0,1,0.6,0.63);
            double cliffMaskFactor = Utilities.scaleBetween(cliffNoiseMask,0,1,0.5,0.7);
            double factor = scale * 20;
            double newNoise = ((int)(noise/factor))*factor;
            noise = Math.max(noise, (newNoise * cliffFactor) * cliffMaskFactor);
        }*/

        return noise;
    }
}
