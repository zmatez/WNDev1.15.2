package com.matez.wildnature.world.gen.chunk.landscape;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Random;

import com.matez.wildnature.world.gen.noise.OctaveNoiseSampler;
import com.matez.wildnature.world.gen.noise.OpenSimplexNoise;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;

public class ChunkLandscape 
{
	public static HashMap<String, Class<? extends ChunkLandscape>> landscapeCache = new HashMap<String, Class<? extends ChunkLandscape>>();
	
	protected int x;
	protected int z;
	
	protected IChunk chunk;
	protected Biome biome;
	protected Random random;
	
	protected float depth;
	protected float scale;
	protected int octaves = 11;
	
	protected OctaveNoiseSampler<OpenSimplexNoise> heightNoise;
	protected OctaveNoiseSampler<OpenSimplexNoise> scaleNoise;
	
	public ChunkLandscape(int x, int z, long seed, Biome biome, IChunk chunkIn)
	{
		this.x = x;
		this.z = z;
		this.biome = biome;
		
		this.chunk = chunkIn;
		
		this.depth = biome.getDepth();
		this.scale = biome.getScale();
		this.random = new Random(seed);
		
		double amplitude = Math.pow(2, octaves);
		
		this.heightNoise = new OctaveNoiseSampler<>(OpenSimplexNoise.class, this.random, this.octaves, 0.75 * amplitude, amplitude, amplitude);
		this.scaleNoise = new OctaveNoiseSampler<>(OpenSimplexNoise.class, this.random, 2, Math.pow(2, 10), 0.2, 0.09);
	}
	
	public static void addLandscape(Biome biome, Class<? extends ChunkLandscape> landscape)
	{
		ChunkLandscape.landscapeCache.put(biome.getRegistryName().getPath(), landscape);
	}
	
	private double sigmoid(double noise)
	{
		return 256 / (Math.exp(8 / 3f - noise / 48) + 1);
	}
	
	public double generateHeightmap()
	{
		int xLow = ((x >> 2) << 2);
		int zLow = ((z >> 2) << 2);
		int xUpper = xLow + 4;
		int zUpper = zLow + 4;
		
		double xProgress = (double)(x - xLow) * 0.25;
		double zProgress = (double)(z - zLow) * 0.25;
		
		xProgress = xProgress * xProgress * (3 - (xProgress * 2));
		zProgress = zProgress * zProgress * (3 - (zProgress * 2));
		
		// Start of sample
		final double[] samples = new double[4];
		samples[0] = sampleArea(xLow, zLow);
		samples[1] = sampleArea(xUpper, zLow);
		samples[2] = sampleArea(xLow, zUpper);
		samples[3] = sampleArea(xUpper, zUpper);
		
		double sample = MathHelper.lerp(zProgress,
						MathHelper.lerp(xProgress, samples[0], samples[1]),
						MathHelper.lerp(xProgress, samples[2], samples[3]));
		
		return sigmoid(sample);
	}
	
	private double sampleArea(int x, int z)
	{
		double noise = sampleNoise(x, z);
		noise += sampleNoise(x + 4, z);
		noise += sampleNoise(x - 4, z);
		noise += sampleNoise(x, z + 4);
		noise += sampleNoise(x, z - 4);
		noise *= 0.2;
		
		noise += 100;
		
		return noise;
	}
	
	private double sampleNoise(int x, int z)
	{
		double frequency = this.scaleNoise.sample(x, z);
		double noise = this.heightNoise.sampleCustom(x, z, 1, frequency, frequency, octaves);
		
		return noise;
	}
	
	public ChunkLandscape applyValues(int x, int z, Long seed, Biome biome, IChunk chunkIn)
	{
		this.x = x;
		this.z = z;
		this.random.setSeed(seed);
		
		this.biome = biome;
		this.chunk = chunkIn;
		
		return this;
	}
	
	// This way, if we have a biome that would require different terrain we can create a class that extends ChunkLandscape and add it by calling "ChunkLandscape.addLandscape(WNBiomes.THE_BIOME, THE_CHUNK_LANDSCAPE.class);"
	public static ChunkLandscape getOrCreate(int x, int z, long seed, int sealevel, Biome biome, IChunk chunkIn)
	{
		Class<? extends ChunkLandscape> landscape = landscapeCache.get(biome.getRegistryName().getPath());
		if (landscape != null)
		{
			try
			{
				return landscape.getDeclaredConstructor(int.class, int.class, long.class, Biome.class, IChunk.class).newInstance(x, z, seed, biome, chunkIn);
			}
			catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
			{
				e.printStackTrace();
			}
		}
		
		return new ChunkLandscape(x, z, seed, biome, chunkIn);
	}
}
