package com.matez.wildnature.world.generation.chunk.generation.landscape;

import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.chunk.generation.noise.NoiseProcessor;
import com.matez.wildnature.world.generation.terrain.Terrain;
import com.matez.wildnature.world.generation.grid.Cell;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TerrainLandscape {
    public static HashMap<String, Class<? extends TerrainLandscape>> landscapeCache = new HashMap<String, Class<? extends TerrainLandscape>>();

    protected Cell cell;
    protected Terrain terrain;
    protected int x;
    protected int z;

    public IChunk chunk;
    public Biome biome;
    public Random random;

    protected float depth;
    protected float scale;
    protected int octaves = 11;
    public long seed;
    public int sealevel;

    protected ArrayList<NoiseProcessor> noiseProcessors = new ArrayList<>();
    protected ArrayList<NoiseProcessor> validNoiseProcessors = new ArrayList<>();

    public TerrainLandscape(Cell cell, Terrain terrain, int x, int z, long seed, int sealevel, Biome biome, IChunk chunkIn) {
        this.cell = cell;
        this.terrain = terrain;
        this.x = x;
        this.z = z;
        this.biome = biome;

        this.chunk = chunkIn;

        this.depth = biome.getDepth();
        this.scale = biome.getScale();
        this.random = new Random(seed);
        this.seed = seed;
        this.sealevel = sealevel;

        //PROCESSORS - here add noise processors

        //
        initNoiseProcessors();
    }

    public static void addLandscape(Biome biome, Class<? extends TerrainLandscape> landscape) {
        TerrainLandscape.landscapeCache.put(biome.getRegistryName().getPath(), landscape);
    }

    public void addNoiseProcessor(NoiseProcessor processor){
        noiseProcessors.add(processor);
    }

    public void initNoiseProcessors(){
        for (NoiseProcessor noiseProcessor : noiseProcessors) {
            if(noiseProcessor.canProcess(biome)){
                noiseProcessor.init(seed, random,octaves);
                validNoiseProcessors.add(noiseProcessor);
            }
        }
    }

    public double editHeightmap(double biomeHeightmap, BiomeProvider biomeProvider) {
        return sampleArea(biomeHeightmap,x,z,biomeProvider);
    }

    private double sampleArea(double biomeHeightmap, int x, int z, BiomeProvider biomeProvider) {
        double noise = sampleNoise(cell,x, z, biomeHeightmap, scale,true);
        noise += sampleNoise(cell,x + 4, z, biomeHeightmap, scale,false);
        noise += sampleNoise(cell,x - 4, z, biomeHeightmap, scale,false);
        noise += sampleNoise(cell,x, z + 4, biomeHeightmap, scale,false);
        noise += sampleNoise(cell,x, z - 4, biomeHeightmap, scale,false);
        noise *= 0.2;

        //80 means 69Y, 100 means 92Y as base height
        noise += biomeHeightmap;

        //limiter
        if(noise > 230){
            return 230;
        }

        return noise;
    }

    private double sampleNoise(Cell cell, int x, int z, double height, double scale, boolean rawCoords) {
        double output = 0;
        double d = 0;
        double f = Utilities.scaleBetween(cell.terrainCellEdge,0,1,0,0.1);
        double factor = cell.terrainCellEdge > 0.1 ? 1 : f;
        for (NoiseProcessor noiseProcessor : validNoiseProcessors) {
            double noise = noiseProcessor.getProcessedNoise(x,z,biome,height,scale,rawCoords);
            if(noiseProcessor.smoothedOnBorders()){
                output += noise * factor;//factor 0 on biome borders, otherwise 1 (it's smoothed)
                d += factor;
            }else{
                output += noise;
                d++;
            }
        }
        if(d==0){
            return output;
        }
        return output / d;
    }

    public ArrayList<NoiseProcessor> getValidNoiseProcessors() {
        return validNoiseProcessors;
    }

    public TerrainLandscape applyValues(Cell cell, Terrain terrain, int x, int z, Long seed, int sealevel, Biome biome, IChunk chunkIn) {
        this.x = x;
        this.z = z;
        this.random.setSeed(seed);

        this.sealevel = sealevel;
        this.biome = biome;
        this.chunk = chunkIn;

        return this;
    }

    // This way, if we have a biome that would require different terrain we can create a class that extends ChunkLandscape and add it by calling "ChunkLandscape.addLandscape(WNBiomes.THE_BIOME, THE_CHUNK_LANDSCAPE.class);"
    public static TerrainLandscape getOrCreate(Cell cell, Terrain terrain, int x, int z, long seed, int sealevel, Biome biome, IChunk chunkIn) {
        Class<? extends TerrainLandscape> landscape = landscapeCache.get(biome.getRegistryName().getPath());
        if (landscape != null) {
            try {
                return landscape.getDeclaredConstructor(Cell.class, Terrain.class, int.class, int.class, long.class, int.class, Biome.class, IChunk.class).newInstance(cell, terrain, x, z, seed, sealevel, biome, chunkIn);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return new TerrainLandscape(cell, terrain, x, z, seed,sealevel, biome, chunkIn);
    }
}
