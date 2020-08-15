package com.matez.wildnature.world.gen.noise;

import java.util.HashMap;

import com.matez.wildnature.Main;

import net.minecraft.util.math.BlockPos;

public class Sampler 
{
	protected HashMap<Long, Double> cache = new HashMap<>();
	protected HashMap<Long, Double> customCache = new HashMap<>();
	
	protected final OctaveNoiseSampler scaleSampler;
	protected final OctaveNoiseSampler heightSampler;
	
	public Sampler(OctaveNoiseSampler sampler, OctaveNoiseSampler customSampler)
	{
		this.scaleSampler = sampler;
		this.heightSampler = customSampler;
	}
	
	public double sample(int x, int z)
	{
		Double val = cache.get(BlockPos.pack(x, 0, z));
		if (val != null) return val;
		
		// Not in cache
		val = scaleSampler.sample(x, z);
		cache.put(BlockPos.pack(x, 0, z), val);
		return val;
	}
	
	public double sampleCustom(int x, int z, double samplingFrequency, double amplitude, int octaves)
	{
		Double val = customCache.get(BlockPos.pack(x, 0, z));
		if (val != null) return val;
		
		// Not in cache
		val = heightSampler.sampleCustom(x, z, samplingFrequency, amplitude, amplitude, octaves);
		customCache.put(BlockPos.pack(x, 0, z), val);
		return val;
	}
}
