package com.matez.wildnature.world.generation.chunk.generation;


import com.matez.wildnature.world.generation.layer.ColumnBiomeContainer;
import com.matez.wildnature.world.generation.layer.SmoothColumnBiomeMagnifier;
import com.matez.wildnature.world.generation.biome.setup.BiomeVariants;
import com.matez.wildnature.world.generation.biome.setup.WNGenSettings;
import com.matez.wildnature.world.generation.chunk.generation.landscape.ChunkLandscape;
import com.matez.wildnature.world.generation.generators.carves.PathGenerator;
import com.matez.wildnature.world.generation.generators.functions.interpolation.LerpConfiguration;
import com.matez.wildnature.world.generation.generators.rivers.surface.RiverGenerator;
import com.matez.wildnature.world.generation.processors.TerrainProcessor;
import com.matez.wildnature.world.generation.processors.ThermalErosionProcessor;
import com.matez.wildnature.world.generation.processors.ThermalErosionTestProcessor;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorld;
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

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class WNSimplexChunkGenerator extends ChunkGenerator<WNGenSettings> {
    private static final BlockState AIR = Blocks.AIR.getDefaultState();
    protected IChunk chunk = null;

    private WNGenSettings settings;
    private final int verticalNoiseResolution;
    private final int horizontalNoiseResolution;
    private final int noiseSizeX;
    private final int noiseSizeY;
    private final int noiseSizeZ;

    private final PerlinNoiseGenerator surfaceDepthNoise;

    protected HashMap<Long, int[]> noiseCache = new HashMap<>();
    private static TerrainProcessor thermalErosionProcessor = new ThermalErosionProcessor();
    private static TerrainProcessor thermalErosionTestProcessor = new ThermalErosionTestProcessor();

    private SharedSeedRandom randomSeed;

    private PathGenerator pathGenerator;
    private RiverGenerator riverGenerator;

    public WNSimplexChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, WNGenSettings generationSettingsIn) {
        super(worldIn, biomeProviderIn, generationSettingsIn);
        this.settings = generationSettingsIn;
        this.randomSeed = new SharedSeedRandom(this.seed);

        this.verticalNoiseResolution = 8;
        this.horizontalNoiseResolution = 4;
        this.noiseSizeX = 16 / this.horizontalNoiseResolution;
        this.noiseSizeY = 256 / this.verticalNoiseResolution;
        this.noiseSizeZ = 16 / this.horizontalNoiseResolution;

        this.surfaceDepthNoise = new PerlinNoiseGenerator(this.randomSeed, 3, 0);

        this.pathGenerator = new PathGenerator(worldIn);
        this.riverGenerator = new RiverGenerator(worldIn);

        thermalErosionProcessor.init(this, this.seed);
        thermalErosionTestProcessor.init(this, this.seed);
    }

    @Override
    public void generateBiomes(IChunk chunkIn) {
        // Saves 98% of vanilla biome generation calls
        ((ChunkPrimer) chunkIn).func_225548_a_(new ColumnBiomeContainer(chunkIn.getPos(), biomeProvider));
    }

    public void generateSurface(WorldGenRegion worldGenRegion, IChunk chunkIn) {
        ChunkPos chunkpos = chunkIn.getPos();
        int i = chunkpos.x;
        int j = chunkpos.z;
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
        sharedseedrandom.setBaseChunkSeed(i, j);
        int xChunkPos = chunkpos.getXStart();
        int zChunkPos = chunkpos.getZStart();
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();


        for (int relativeX = 0; relativeX < 16; ++relativeX) {
            for (int relativeZ = 0; relativeZ < 16; ++relativeZ) {
                int x = xChunkPos + relativeX;
                int z = zChunkPos + relativeZ;
                int startHeight = chunkIn.getTopBlockY(Heightmap.Type.WORLD_SURFACE_WG, relativeX, relativeZ) + 1;
                double noise = surfaceDepthNoise.noiseAt((double)x * 0.0625, (double)z * 0.0625, 0.0625, (double)startHeight * 0.0625) * 15;
                Biome biome = worldGenRegion.getBiome(blockpos$mutable.setPos(xChunkPos + relativeX, startHeight, zChunkPos + relativeZ));

                if(x==0 && z==0){
                    //riverGenerator.generate(0,startHeight,0,biome,chunkIn);
                }


                biome.buildSurface(sharedseedrandom, chunkIn, x, z, startHeight, noise, this.getSettings().getDefaultBlock(), this.getSettings().getDefaultFluid(), this.getSeaLevel(), this.world.getSeed());

                pathGenerator.generate(x,startHeight,z,biome,chunkIn);
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

        for (BlockPos blockpos : BlockPos.getAllInBoxMutable(i, 0, j, i + 15, 0, j + 15)) {
            if (l > 0) {
                for (int i1 = l; i1 >= l - 4; --i1) {
                    if (i1 >= l - rand.nextInt(5)) {
                        chunkIn.setBlockState(blockpos$mutableblockpos.setPos(blockpos.getX(), i1, blockpos.getZ()), Blocks.BEDROCK.getDefaultState(), false);
                    }
                }
            }

            if (k < 256) {
                for (int j1 = k + 4; j1 >= k; --j1) {
                    if (j1 <= k + rand.nextInt(5)) {
                        chunkIn.setBlockState(blockpos$mutableblockpos.setPos(blockpos.getX(), j1, blockpos.getZ()), Blocks.BEDROCK.getDefaultState(), false);
                    }
                }
            }
        }

    }

    @Override
    public int getGroundHeight() {
        return this.getSeaLevel() + 1;
    }

    @Override
    public void makeBase(IWorld worldIn, IChunk chunkIn) {
        this.chunk = chunkIn;
        ObjectList<AbstractVillagePiece> structurePieces = new ObjectArrayList<>(10);
        ObjectList<JigsawJunction> jigsaws = new ObjectArrayList<>(32);
        ChunkPos chunkpos = chunkIn.getPos();
        int chunkX = chunkpos.x;
        int chunkZ = chunkpos.z;
        int chunkStartX = chunkX << 4;
        int chunkStartZ = chunkZ << 4;

        for (Structure<?> structure : Feature.ILLAGER_STRUCTURES) {
            String s = structure.getStructureName();
            LongIterator longiterator = chunkIn.getStructureReferences(s).iterator();

            while (longiterator.hasNext()) {
                long j1 = longiterator.nextLong();
                ChunkPos chunkpos1 = new ChunkPos(j1);
                IChunk ichunk = worldIn.getChunk(chunkpos1.x, chunkpos1.z);
                StructureStart structurestart = ichunk.getStructureStart(s);
                if (structurestart != null && structurestart.isValid()) {
                    for (StructurePiece structurepiece : structurestart.getComponents()) {
                        if (structurepiece.func_214810_a(chunkpos, 12) && structurepiece instanceof AbstractVillagePiece) {
                            AbstractVillagePiece abstractvillagepiece = (AbstractVillagePiece) structurepiece;
                            JigsawPattern.PlacementBehaviour jigsawpattern$placementbehaviour = abstractvillagepiece.getJigsawPiece().getPlacementBehaviour();
                            if (jigsawpattern$placementbehaviour == JigsawPattern.PlacementBehaviour.RIGID) {
                                structurePieces.add(abstractvillagepiece);
                            }

                            for (JigsawJunction jigsawjunction : abstractvillagepiece.getJunctions()) {
                                int k1 = jigsawjunction.getSourceX();
                                int l1 = jigsawjunction.getSourceZ();
                                if (k1 > chunkStartX - 12 && l1 > chunkStartZ - 12 && k1 < chunkStartX + 15 + 12 && l1 < chunkStartZ + 15 + 12) {
                                    jigsaws.add(jigsawjunction);
                                }
                            }
                        }
                    }
                }
            }
        }

        this.generateTerrain(worldIn, chunkIn, this.getHeightsInChunk(chunkpos, worldIn));
    }

    public void generateTerrain(IWorld world, IChunk chunk, int[] noise) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int height = (int) noise[(x * 16) + z];

                for (int y = 0; y < 256; y++) {
                    BlockPos pos = new BlockPos(x, y, z);

                    if (y > height) {
                        if (y < this.getSeaLevel()) {
                            chunk.setBlockState(pos, this.settings.getDefaultFluid(), false);
                        }
                    } else {
                        chunk.setBlockState(pos, this.settings.getDefaultBlock(), false);
                    }
                }
            }
        }

        //erode(world,chunk,noise);
    }

    protected void erode(IWorld world, IChunk chunk, int[] noise){
        int threads = 8;

        CompletableFuture<?>[] futures = new CompletableFuture[threads];
        for (int i = 0; i < threads; i++) {
            int position = i;
            futures[i] = CompletableFuture.runAsync(() -> runErosion(world,chunk,position * 16 / threads, 16 / threads,noise));
        }

        for (int i = 0; i < futures.length; i++) {
            futures[i].join();
        }
    }

    private void runErosion(IWorld world, IChunk chunk, int start, int size, int[] noise){
        for (int x = start; x < start + size; x++) {
            for (int z = 0; z < 16; z++) {
                thermalErosionTestProcessor.process(world, chunk, new Random(this.seed), chunk.getPos().x, chunk.getPos().z, x, z, noise);
            }
        }
    }

    protected int[] getHeightsInChunk(ChunkPos pos, IWorld worldIn) {
        int[] res = noiseCache.get(pos.asLong());
        if (res != null) return res;

        int[] vals = new int[256];

        // useNoise(vals, pos, 0, 16);
        int threads = 4;

        CompletableFuture<?>[] futures = new CompletableFuture[threads];
        for (int i = 0; i < threads; i++) {
            int position = i;
            futures[i] = CompletableFuture.runAsync(() -> useNoise(vals, pos, position * 16 / threads, 16 / threads, worldIn));
        }

        for (int i = 0; i < futures.length; i++) {
            futures[i].join();
        }

        noiseCache.put(pos.asLong(), vals);

        return vals;
    }

    public void useNoise(int[] noise, ChunkPos pos, int start, int size, IWorld worldIn) {
        final Object2DoubleMap<LerpConfiguration> weightMap16 = new Object2DoubleOpenHashMap<>(4), weightMap4 = new Object2DoubleOpenHashMap<>(2), weightMap1 = new Object2DoubleOpenHashMap<>();

        final ChunkArraySampler.CoordinateAccessor<LerpConfiguration> biomeAccessor = (x, z) -> {
            Biome biome = SmoothColumnBiomeMagnifier.SMOOTH.getBiome(worldIn.getSeed(), pos.getXStart() + x, 0, pos.getZStart() + z, worldIn);

            LerpConfiguration configuration = new LerpConfiguration(biome);
            /*if(pathGenerator.isPath(pathGenerator.applyPathNoise(x,z))){
                configuration.setCustomVariants(BiomeVariants.PATH);
            }*/
            return configuration;
        };

        final LerpConfiguration[] sampledBiomes16 = ChunkArraySampler.fillSampledArray(new LerpConfiguration[10 * 10], biomeAccessor, 4);
        final LerpConfiguration[] sampledBiomes4 = ChunkArraySampler.fillSampledArray(new LerpConfiguration[13 * 13], biomeAccessor, 2);
        final LerpConfiguration[] sampledBiomes1 = ChunkArraySampler.fillSampledArray(new LerpConfiguration[24 * 24], biomeAccessor);

        for (int x = start; x < start + size; x++) {
            for (int z = 0; z < 16; z++) {
                // Sample biome weights at different distances
                ChunkArraySampler.fillSampledWeightMap(sampledBiomes16, weightMap16, 4, x, z);
                ChunkArraySampler.fillSampledWeightMap(sampledBiomes4, weightMap4, 2, x, z);
                ChunkArraySampler.fillSampledWeightMap(sampledBiomes1, weightMap1, x, z);

                Function<LerpConfiguration, BiomeVariants> variantAccessor = LerpConfiguration::getBiomeVariants;

                // Group biomes at different distances. This has the effect of making some biome transitions happen over larger distances than others.
                // This is used to make most land biomes blend at maximum distance, while allowing biomes such as rivers to blend at short distances, creating better cliffs as river biomes are smaller width than other biomes.
                ChunkArraySampler.reduceGroupedWeightMap(weightMap4, weightMap16, variantAccessor.andThen(BiomeVariants::getLargeGroup), BiomeVariants.LargeGroup.SIZE);
                ChunkArraySampler.reduceGroupedWeightMap(weightMap1, weightMap4, variantAccessor.andThen(BiomeVariants::getSmallGroup), BiomeVariants.SmallGroup.SIZE);

                noise[(x * 16) + z] = getTerrainHeight((pos.x * 16) + x, (pos.z * 16) + z,weightMap1,variantAccessor);
            }
        }
    }

    public int getTerrainHeight(int x, int z, Object2DoubleMap<LerpConfiguration> weightMap1, Function<LerpConfiguration, BiomeVariants> variantAccessor) {
        Biome biome = this.biomeProvider.getNoiseBiome(x / 4, 1, z / 4);
        ChunkLandscape landscape = ChunkLandscape.getOrCreate(x, z, this.seed, this.getSeaLevel(), biome, this.chunk);

        int height = (int) landscape.generateHeightmap(biomeProvider,weightMap1,variantAccessor);

        return height;
    }

    public void applyHeightBasedBiomes(int height, int x, int z, Biome currentBiome){
        //lakes
        if(height < getSeaLevel()){
            float depth = currentBiome.getDepth();
            float scale = currentBiome.getScale();
            if((depth - scale) < 0){

            }
        }
    }


    @Override
    public int func_222529_a(int x, int z, Type heightmap) {
        return getSeaLevel();
    }
}
