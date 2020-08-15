package com.matez.wildnature.world.gen.chunk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.biomes.setup.WNGenSettings;
import com.matez.wildnature.world.gen.chunk.landscape.ChunkLandscape;
import com.matez.wildnature.world.gen.noise.*;
import com.matez.wildnature.world.gen.noise.bukkit.SimplexOctaveGenerator;

import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.jigsaw.JigsawJunction;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.StructureStart;

public class WNSimplexChunkGenerator extends ChunkGenerator<WNGenSettings>
{
	protected IChunk chunk = null;
	public static final float[] biomeData = Util.make(new float[25], (data) -> {
        for(int i = -2; i <= 2; ++i) {
            for(int j = -2; j <= 2; ++j) {
                float f = 10.0F / MathHelper.sqrt((float)(i * i + j * j) + 0.2F);
                data[i + 2 + (j + 2) * 5] = f;
            }
        }

    });
	
	private WNGenSettings settings;
	
	private final OctavesNoiseGenerator surfaceDepthNoise;


	protected HashMap<Long, int[]> noiseCache = new HashMap<>();
	
	private SharedSeedRandom randomSeed;
	
	public WNSimplexChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, WNGenSettings generationSettingsIn)
	{
		super(worldIn, biomeProviderIn, generationSettingsIn);
		this.settings = generationSettingsIn;
		this.randomSeed = new SharedSeedRandom(this.seed);
		
		this.surfaceDepthNoise = new OctavesNoiseGenerator(this.randomSeed, 4,0);
	}


	public void generateSurface(WorldGenRegion worldGenRegion, IChunk chunkIn) {
		ChunkPos chunkpos = chunkIn.getPos();
		int i = chunkpos.x;
		int j = chunkpos.z;
		SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
		sharedseedrandom.setBaseChunkSeed(i, j);
		ChunkPos chunkpos1 = chunkIn.getPos();
		int xChunkPos = chunkpos1.getXStart();
		int zChunkPos = chunkpos1.getZStart();
		double d0 = 0.0625D;
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();


		for(int relativeX = 0; relativeX < 16; ++relativeX) {
			for (int relativeZ = 0; relativeZ < 16; ++relativeZ) {
				int x = xChunkPos + relativeX;
				int z = zChunkPos + relativeZ;
				int startHeight = chunkIn.getTopBlockY(Heightmap.Type.WORLD_SURFACE_WG, relativeX, relativeZ) + 1;
				double d1 = this.surfaceDepthNoise.noiseAt((double) x * 0.0625D, (double) z * 0.0625D, 0.0625D, (double) startHeight * 0.0625D) * 15.0D;

				Biome biome = worldGenRegion.getBiome(blockpos$mutable.setPos(xChunkPos + relativeX, startHeight, zChunkPos + relativeZ));
				biome.buildSurface(sharedseedrandom, chunkIn, x, z, startHeight, d1, this.getSettings().getDefaultBlock(), this.getSettings().getDefaultFluid(), this.getSeaLevel(), this.world.getSeed());
			}
		}

		this.makeBedrock(chunkIn, sharedseedrandom);
	}
	
	protected void makeBedrock(IChunk chunkIn, Random rand) {
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
        int i = chunkIn.getPos().getXStart();
        int j = chunkIn.getPos().getZStart();
        WNGenSettings t = this.getSettings();
        int k = t.getBedrockFloorHeight();
        int l = t.getBedrockRoofHeight();

        for(BlockPos blockpos : BlockPos.getAllInBoxMutable(i, 0, j, i + 15, 0, j + 15)) {
            if (l > 0) {
                for(int i1 = l; i1 >= l - 4; --i1) {
                    if (i1 >= l - rand.nextInt(5)) {
                        chunkIn.setBlockState(blockpos$mutableblockpos.setPos(blockpos.getX(), i1, blockpos.getZ()), Blocks.BEDROCK.getDefaultState(), false);
                    }
                }
            }

            if (k < 256) {
                for(int j1 = k + 4; j1 >= k; --j1) {
                    if (j1 <= k + rand.nextInt(5)) {
                        chunkIn.setBlockState(blockpos$mutableblockpos.setPos(blockpos.getX(), j1, blockpos.getZ()), Blocks.BEDROCK.getDefaultState(), false);
                    }
                }
            }
        }

    }

	@Override
	public int getGroundHeight() 
	{
		return this.getSeaLevel() + 1;
	}

	@Override
	public void makeBase(IWorld worldIn, IChunk chunkIn) 
	{
		this.chunk = chunkIn;
        ObjectList<AbstractVillagePiece> objectlist = new ObjectArrayList<>(10);
        ObjectList<JigsawJunction> objectlist1 = new ObjectArrayList<>(32);
        ChunkPos chunkpos = chunkIn.getPos();
        int x = chunkpos.x;
        int z = chunkpos.z;
        int l = x << 4;
        int i1 = z << 4;

        for(Structure<?> structure : Feature.ILLAGER_STRUCTURES) {
            String s = structure.getStructureName();
            LongIterator longiterator = chunkIn.getStructureReferences(s).iterator();

            while(longiterator.hasNext()) {
                long j1 = longiterator.nextLong();
                ChunkPos chunkpos1 = new ChunkPos(j1);
                IChunk ichunk = worldIn.getChunk(chunkpos1.x, chunkpos1.z);
                StructureStart structurestart = ichunk.getStructureStart(s);
                if (structurestart != null && structurestart.isValid()) {
                    for(StructurePiece structurepiece : structurestart.getComponents()) {
                        if (structurepiece.func_214810_a(chunkpos, 12) && structurepiece instanceof AbstractVillagePiece) {
                            AbstractVillagePiece abstractvillagepiece = (AbstractVillagePiece)structurepiece;
                            JigsawPattern.PlacementBehaviour jigsawpattern$placementbehaviour = abstractvillagepiece.getJigsawPiece().getPlacementBehaviour();
                            if (jigsawpattern$placementbehaviour == JigsawPattern.PlacementBehaviour.RIGID) {
                                objectlist.add(abstractvillagepiece);
                            }

                            for(JigsawJunction jigsawjunction : abstractvillagepiece.getJunctions()) {
                                int k1 = jigsawjunction.getSourceX();
                                int l1 = jigsawjunction.getSourceZ();
                                if (k1 > l - 12 && l1 > i1 - 12 && k1 < l + 15 + 12 && l1 < i1 + 15 + 12) {
                                    objectlist1.add(jigsawjunction);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        this.generateTerrain(chunkIn, this.getHeightsInChunk(chunkpos));
	}
	
	public void generateTerrain(IChunk chunk, int[] noise)
	{
		for(int x = 0; x < 16; x++)
        {
        	for(int z = 0; z < 16; z++)
        	{
        		int height = (int) noise[(x * 16) + z];
				double depth = sampleDepthAndScale((chunk.getPos().x * 16) + x,(chunk.getPos().z * 16) + z)[0];
        		double scale = sampleDepthAndScale((chunk.getPos().x * 16) + x,(chunk.getPos().z * 16) + z)[1];
        		
        		for(int y = 0; y < 256; y++)
        		{
        			BlockPos pos = new BlockPos(x, y, z);
					Biome b = chunk.getBiomes().getNoiseBiome(x,y,z);

					if (y > (height * 0.75) + (height * 0.3 * scale) + (depth * 15))
					//if (y > height)
					{
        				if (y < this.getSeaLevel())
        				{
        					chunk.setBlockState(pos, this.settings.getDefaultFluid(), false);
        				}
        			}
        			else
        			{
        				chunk.setBlockState(pos, this.settings.getDefaultBlock(), false);
        			}
        		}
        	}
        }
	}


	private boolean amplified = false;
	public double[] sampleDepthAndScale(int x, int z) {
		double[] adouble = new double[2];
		float f = 0.0F;
		float f1 = 0.0F;
		float f2 = 0.0F;
		int i = 2;
		float depth = this.biomeProvider.getNoiseBiome(x, this.getSeaLevel(), z).getDepth();

		for(int j = -2; j <= 2; ++j) {
			for(int k = -2; k <= 2; ++k) {
				Biome biome = this.biomeProvider.getNoiseBiome(x + j, this.getSeaLevel(), z + k);
				float biomeDepth = biome.getDepth();
				float biomeScale = biome.getScale();
				if (amplified && biomeDepth > 0.0F) {
					biomeDepth = 1.0F + biomeDepth * 2.0F;
					biomeScale = 1.0F + biomeScale * 4.0F;
				}

				float f6 = biomeData[j + 2 + (k + 2) * 5] / (biomeDepth + 2.0F);
				if (biome.getDepth() > depth) {
					f6 /= 2.0F;
				}

				f += biomeScale * f6;
				f1 += biomeDepth * f6;
				f2 += f6;
			}
		}

		f = f / f2;
		f1 = f1 / f2;
		f = f * 0.9F + 0.1F;
		f1 = (f1 * 4.0F - 1.0F) / 8.0F;
		adouble[0] = (double)f1 + this.func_222574_c(x, z);
		adouble[1] = (double)f;
		return adouble;
	}

	private double func_222574_c(int p_222574_1_, int p_222574_2_) {
		double d0 = this.surfaceDepthNoise.getValue((double)(p_222574_1_ * 200), 10.0D, (double)(p_222574_2_ * 200), 1.0D, 0.0D, true) / 8000.0D;
		if (d0 < 0.0D) {
			d0 = -d0 * 0.3D;
		}

		d0 = d0 * 3.0D - 2.0D;
		if (d0 < 0.0D) {
			d0 = d0 / 28.0D;
		} else {
			if (d0 > 1.0D) {
				d0 = 1.0D;
			}

			d0 = d0 / 40.0D;
		}

		return d0;
	}
	
	protected int[] getHeightsInChunk(ChunkPos pos)
	{
		int[] res = noiseCache.get(pos.asLong());
		if (res != null) return res;
		
		int[] vals = new int[256];
		
		// useNoise(vals, pos, 0, 16);
		int threads = 2;
		
		CompletableFuture<?>[] futures = new CompletableFuture[threads];
		for (int i = 0; i < threads; i++)
		{
			int position = i;
			futures[i] = CompletableFuture.runAsync(() -> useNoise(vals, pos, position * 16 / threads, 16 / threads));
		}
		
		for (int i = 0; i < futures.length; i++)
		{
			futures[i].join();
		}
		
		noiseCache.put(pos.asLong(), vals);
		
		return vals;
	}
	
	public void useNoise(int[] noise, ChunkPos pos, int start, int size)
	{
		for(int x = start; x < start + size; x++)
		{
			for(int z = 0; z < 16; z++)
			{
				noise[(x * 16) + z] = getTerrainHeight((pos.x * 16) + x, (pos.z * 16) + z);
			}
		}
	}
	
	public int getTerrainHeight(int x, int z)
	{
		Biome biome = this.biomeProvider.getNoiseBiome(x,0, z);
		ChunkLandscape landscape = ChunkLandscape.getOrCreate(x, z, this.seed,this.getSeaLevel(), biome, this.chunk);
		
		return (int) landscape.generateHeightmap();
	}
	


	@Override
	public int func_222529_a(int x, int z, Type p_222529_3_)
	{
		return getTerrainHeight(x, z);
	}
}
