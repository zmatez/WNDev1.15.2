package com.matez.wildnature.world.gen.biomes.setup;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;

public enum EnumBiomes {
	ALL;
	
	public static EnumBiomes[] ALL_BIOMES = values();
	private ArrayList<WeightedBiome> BIOMES;
	private int totalWeight = 0;
	
	private EnumBiomes()
	{
		this.BIOMES = new ArrayList<WeightedBiome>();
	}
	
	public EnumBiomes add(Biome biome, int weight)
	{
		this.BIOMES.add(new WeightedBiome(weight, biome));
		this.totalWeight += weight;
		
		return this;
	}
	
	public Biome randomBiome(INoiseRandom context)
	{
        int weight = context.random(this.totalWeight);
        Iterator<WeightedBiome> iterator = this.BIOMES.iterator();
        WeightedBiome item;
        do
        {
            item = iterator.next();
            weight -= item.weight;
        }
        while (weight >= 0);
        return item.biome;
	}
	
	public static class WeightedBiome
	{
		public final int weight;
		public final Biome biome;
		
		public WeightedBiome(int weight, Biome biome)
		{
			this.weight = weight;
			this.biome = biome;
		}
	}
}