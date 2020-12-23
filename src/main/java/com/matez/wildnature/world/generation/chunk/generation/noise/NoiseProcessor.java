package com.matez.wildnature.world.generation.chunk.generation.noise;

import net.minecraft.world.biome.Biome;

import java.util.Random;

public abstract class NoiseProcessor {
    protected double lerpFactor = 0;

    public double getLerpFactor(){
        return lerpFactor;
    }

    public void setLerpFactor(double lerpFactor){
        this.lerpFactor = lerpFactor;
    }

    public boolean canProcess(Biome biome){
        return true;
    }

    public boolean smoothedOnBorders(){
        return true;
    }

    public int mixFactor(){
        return 1;
    }

    public abstract void init(long seed, Random random, int octaves);

    protected abstract double processNoise(int x, int z, Biome biome, double height, double scale,double freqModifier, double hilliness, double frequencyMin, double frequencyMax, double[] args, boolean rawNoise);

    public double getProcessedNoise(int x, int z, Biome biome, double height, double scale, double freqModifier, double hilliness, double frequencyMin, double frequencyMax, double[] args, boolean rawNoise){
        return processNoise(x,z,biome,height,scale,freqModifier,hilliness,frequencyMin, frequencyMax,args,rawNoise) * mixFactor();
    }
}
