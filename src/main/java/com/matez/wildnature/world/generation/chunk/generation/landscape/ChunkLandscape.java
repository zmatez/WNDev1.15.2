package com.matez.wildnature.world.generation.chunk.generation.landscape;

import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.biome.setup.BiomeVariants;
import com.matez.wildnature.world.generation.chunk.generation.noise.NoiseProcessor;
import com.matez.wildnature.world.generation.chunk.generation.noise.NoiseProcessors;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoise;
import com.matez.wildnature.world.generation.generators.functions.interpolation.BiomeBlender;
import com.matez.wildnature.world.generation.generators.functions.interpolation.LerpConfiguration;
import com.matez.wildnature.world.generation.grid.Cell;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.function.Function;

public class ChunkLandscape {
    public static HashMap<String, Class<? extends ChunkLandscape>> landscapeCache = new HashMap<String, Class<? extends ChunkLandscape>>();

    protected int x;
    protected int z;

    public IChunk chunk;
    public Biome biome;
    public Random random;

    protected float depth;
    protected float scale;
    public static int octaves = 11;
    public long seed;
    public int sealevel;

    protected ArrayList<NoiseProcessor> noiseProcessors = new ArrayList<>();
    protected ArrayList<NoiseProcessor> validNoiseProcessors = new ArrayList<>();

    private final FastNoise worldLimitNoise;
    private static final double[] EMPTY_ARGS = new double[]{};

    public ChunkLandscape(int x, int z, long seed, int sealevel, Biome biome, IChunk chunkIn) {
        this.x = x;
        this.z = z;
        this.biome = biome;

        this.chunk = chunkIn;

        this.depth = biome.getDepth();
        this.scale = biome.getScale();
        this.random = new Random(seed);
        this.seed = seed;
        this.sealevel = sealevel;
        this.worldLimitNoise = new FastNoise((int)seed);
        this.worldLimitNoise.SetFrequency(0.005f);

        //PROCESSORS - here add noise processors
        addNoiseProcessor(NoiseProcessors.SCALE);
        //addNoiseProcessor(NoiseProcessors.MOUNTAIN_RANGE);
        //
        initNoiseProcessors();
    }

    public static void addLandscape(Biome biome, Class<? extends ChunkLandscape> landscape) {
        ChunkLandscape.landscapeCache.put(biome.getRegistryName().getPath(), landscape);
    }

    public void addNoiseProcessor(NoiseProcessor processor){
        noiseProcessors.add(processor);
    }

    public void initNoiseProcessors(){
        for (NoiseProcessor noiseProcessor : noiseProcessors) {
            if(noiseProcessor.canProcess(biome)){
                validNoiseProcessors.add(noiseProcessor);
            }
        }
    }

    private double sigmoid(double noise) {
        return 256 / (Math.exp(8 / 3f - noise / 48) + 1);
    }

    public double generateHeightmap(BiomeProvider biomeProvider, Object2DoubleMap<LerpConfiguration> weightMap1, Function<LerpConfiguration, BiomeVariants> variantAccessor) {
        return (sigmoid(sampleArea(x, z, biomeProvider,weightMap1,variantAccessor)));
    }

    private double sampleArea(int x, int z, BiomeProvider biomeProvider, Object2DoubleMap<LerpConfiguration> weightMap1, Function<LerpConfiguration, BiomeVariants> variantAccessor) {
        double[] output = BiomeBlender.smoothLerp(x, z, this, weightMap1,variantAccessor);
        double height = output[0];
        double scale = output[1];
        double noiseFactor = output[2];
        double freqModifier = output[3];
        double hilliness = output[4];
        double frequencyMin = output[5];
        double frequencyMax = output[6];

        double noise = sampleNoise(x, z, height, scale,freqModifier,hilliness,frequencyMin,frequencyMax,EMPTY_ARGS,noiseFactor,true);
        noise += sampleNoise(x + 4, z, height, scale,freqModifier,hilliness,frequencyMin,frequencyMax,EMPTY_ARGS,noiseFactor,false);
        noise += sampleNoise(x - 4, z, height, scale,freqModifier,hilliness,frequencyMin,frequencyMax,EMPTY_ARGS,noiseFactor,false);
        noise += sampleNoise(x, z + 4, height, scale,freqModifier,hilliness,frequencyMin,frequencyMax,EMPTY_ARGS,noiseFactor,false);
        noise += sampleNoise(x, z - 4, height, scale,freqModifier,hilliness,frequencyMin,frequencyMax,EMPTY_ARGS,noiseFactor,false);
        noise *= 0.2;

        //80 means 69Y, 100 means 92Y as base height
        noise += height;

        //limiter
        if(noise > 230){
            int limitNoise = Math.round(Utilities.scaleBetween(worldLimitNoise.GetSimplex(x,z),-5,5,-1,1));
            return 230 + limitNoise;
        }else if(noise < 25){
            int limitNoise = Math.round(Utilities.scaleBetween(worldLimitNoise.GetSimplex(x,z),-5,5,-1,1));
            return 25 + limitNoise;
        }

        return noise;
    }

    public double sampleNoise(int x, int z, double height, double scale, double freqModifier, double hilliness, double frequencyMin, double frequencyMax, double[] args, double noiseFactor, boolean rawCoords) {
        double output = 0;
        double d = 0;

        for (NoiseProcessor noiseProcessor : validNoiseProcessors) {
            double noise = noiseProcessor.getProcessedNoise(x,z,biome,height,scale,freqModifier,hilliness,frequencyMin,frequencyMax,args,rawCoords);
            if(noiseProcessor.smoothedOnBorders()){
                output += noise * noiseFactor;//factor 0 on biome borders, otherwise 1 (it's smoothed)
                d += noiseFactor;
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

    @Deprecated
    public double sampleNoise(int x, int z, double height, double scale, double noiseFactor, boolean rawCoords) {
        double output = 0;
        double d = 0;

        for (NoiseProcessor noiseProcessor : validNoiseProcessors) {
            double noise = noiseProcessor.getProcessedNoise(x,z,biome,height,scale,1,1,scale,scale,EMPTY_ARGS,rawCoords);
            if(noiseProcessor.smoothedOnBorders()){
                output += noise * noiseFactor;//factor 0 on biome borders, otherwise 1 (it's smoothed)
                d += noiseFactor;
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

    public ChunkLandscape applyValues(int x, int z, Long seed, int sealevel, Biome biome, IChunk chunkIn) {
        this.x = x;
        this.z = z;
        this.random.setSeed(seed);

        this.sealevel = sealevel;
        this.biome = biome;
        this.chunk = chunkIn;

        return this;
    }

    // This way, if we have a biome that would require different terrain we can create a class that extends ChunkLandscape and add it by calling "ChunkLandscape.addLandscape(WNBiomes.THE_BIOME, THE_CHUNK_LANDSCAPE.class);"
    public static ChunkLandscape getOrCreate(int x, int z, long seed, int sealevel, Biome biome, IChunk chunkIn) {
        Class<? extends ChunkLandscape> landscape = landscapeCache.get(biome.getRegistryName().getPath());
        if (landscape != null) {
            try {
                return landscape.getDeclaredConstructor(int.class, int.class, long.class, int.class, Biome.class, IChunk.class).newInstance(x, z, seed, sealevel, biome, chunkIn);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return new ChunkLandscape(x, z, seed,sealevel, biome, chunkIn);
    }
}
