package com.matez.wildnature.world.generation.chunk.generation;

import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.chunk.WNWorldContext;
import com.matez.wildnature.world.generation.chunk.generation.noise.NoiseProcessors;
import com.matez.wildnature.world.generation.generators.carves.UndergroundRiverGenerator;
import com.matez.wildnature.world.generation.geology.GeologyGenerator;
import com.matez.wildnature.world.generation.geology.GeoGeneratorConfig;
import com.matez.wildnature.world.generation.geology.GeoLayerConfig;
import com.matez.wildnature.world.generation.layer.grid.GridBiomeLayer;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.layer.ColumnBiomeContainer;
import com.matez.wildnature.world.generation.layer.SmoothColumnBiomeMagnifier;
import com.matez.wildnature.world.generation.biome.setup.BiomeVariants;
import com.matez.wildnature.world.generation.biome.setup.WNGenSettings;
import com.matez.wildnature.world.generation.chunk.generation.landscape.ChunkLandscape;
import com.matez.wildnature.world.generation.generators.carves.PathGenerator;
import com.matez.wildnature.world.generation.generators.functions.interpolation.LerpConfiguration;
import com.matez.wildnature.world.generation.noise.fastNoise.FastNoiseLite;
import com.matez.wildnature.world.generation.processors.TerrainProcessor;
import com.matez.wildnature.world.generation.processors.ThermalErosionProcessor;
import com.matez.wildnature.world.generation.processors.ThermalErosionTestProcessor;
import com.matez.wildnature.world.generation.provider.WNGridBiomeProvider;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.ReportedException;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.VillageSiege;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
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
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.CatSpawner;
import net.minecraft.world.spawner.PatrolSpawner;
import net.minecraft.world.spawner.PhantomSpawner;
import net.minecraft.world.spawner.WorldEntitySpawner;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class WNSimplexChunkGenerator extends ChunkGenerator<WNGenSettings> {
    private static final float[] field_222561_h = Util.make(new float[13824], (p_222557_0_) -> {
        for(int i = 0; i < 24; ++i) {
            for(int j = 0; j < 24; ++j) {
                for(int k = 0; k < 24; ++k) {
                    p_222557_0_[i * 24 * 24 + j * 24 + k] = (float)func_222554_b(j - 12, k - 12, i - 12);
                }
            }
        }

    });
    private int threadCount = CommonConfig.generatorThreads.get();
    private static final BlockState AIR = Blocks.AIR.getDefaultState();
    protected IChunk chunk = null;

    private WNGenSettings settings;
    private final int verticalNoiseResolution;
    private final int horizontalNoiseResolution;
    private final int noiseSizeX;
    private final int noiseSizeY;
    private final int noiseSizeZ;

    private final PerlinNoiseGenerator surfaceDepthNoise;

    //mobs
    private final PhantomSpawner phantomSpawner = new PhantomSpawner();
    private final PatrolSpawner patrolSpawner = new PatrolSpawner();
    private final CatSpawner catSpawner = new CatSpawner();
    private final VillageSiege siegeSpawner = new VillageSiege();
    //

    protected HashMap<Long, int[]> noiseCache = new HashMap<>();
    private static TerrainProcessor thermalErosionProcessor = new ThermalErosionProcessor();
    private static TerrainProcessor thermalErosionTestProcessor = new ThermalErosionTestProcessor();

    private SharedSeedRandom randomSeed;
    private WNWorldContext context;

    private final PathGenerator pathGenerator;
    private final UndergroundRiverGenerator undergroundRiverGenerator;

    private final WNGridBiomeProvider gridProvider;


    public WNSimplexChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, WNGenSettings generationSettingsIn) {
        super(worldIn, biomeProviderIn, generationSettingsIn);
        this.settings = generationSettingsIn;
        this.randomSeed = new SharedSeedRandom(this.seed);

        if(biomeProviderIn instanceof WNGridBiomeProvider){
            this.gridProvider = (WNGridBiomeProvider) biomeProviderIn;
        }else{
            this.gridProvider = null;
        }

        this.verticalNoiseResolution = 8;
        this.horizontalNoiseResolution = 4;
        this.noiseSizeX = 4;
        this.noiseSizeY = 32;
        this.noiseSizeZ = noiseSizeX;

        this.surfaceDepthNoise = new PerlinNoiseGenerator(this.randomSeed, 3, 0);

        this.pathGenerator = new PathGenerator(worldIn);
        this.undergroundRiverGenerator = new UndergroundRiverGenerator(worldIn);

        thermalErosionProcessor.init(this, this.seed);
        thermalErosionTestProcessor.init(this, this.seed);

        NoiseProcessors.init(getSeed(),randomSeed,ChunkLandscape.octaves);
    }

    public WNWorldContext getContext() {
        return context;
    }

    public WNGridBiomeProvider getGridProvider() {
        return gridProvider;
    }

    public WNSimplexChunkGenerator getGenerator() {
        return this;
    }

    public void setContext(WNWorldContext context){
        this.context = context;
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
                Biome biome = worldGenRegion.getBiome(blockpos$mutable.setPos(x, startHeight, z));
                Cell cell = gridProvider.getNoiseCell(x,z);
                biome = GridBiomeLayer.applyHeightmapBiome(biome,blockpos$mutable,worldGenRegion,1);

                biome.buildSurface(sharedseedrandom, chunkIn, x, z, startHeight, noise, this.getSettings().getDefaultBlock(), this.getSettings().getDefaultFluid(), this.getSeaLevel(), this.world.getSeed());

                pathGenerator.generate(x,startHeight,z,biome,chunkIn);
                undergroundRiverGenerator.generate(x,startHeight,z,cell,biome,chunkIn);
                cell = null;
            }
        }

        //this.makeBedrock(chunkIn, sharedseedrandom);
    }

    public void decorate(WorldGenRegion region) {
        int i = region.getMainChunkX();
        int j = region.getMainChunkZ();
        int k = i * 16;
        int l = j * 16;
        BlockPos blockpos = new BlockPos(k, 0, l);
        Biome biome = this.getBiome(region.getBiomeManager(), blockpos.add(8, 8, 8));
        biome = GridBiomeLayer.applyHeightmapBiome(biome,blockpos,region,16);

        SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
        long i1 = sharedseedrandom.setDecorationSeed(region.getSeed(), k, l);

        for(GenerationStage.Decoration generationstage$decoration : GenerationStage.Decoration.values()) {
            try {
                biome.decorate(generationstage$decoration, this, region, i1, sharedseedrandom, blockpos);
            } catch (Exception exception) {
                CrashReport crashreport = CrashReport.makeCrashReport(exception, "Biome decoration");
                crashreport.makeCategory("Generation").addDetail("CenterX", i).addDetail("CenterZ", j).addDetail("Step", generationstage$decoration).addDetail("Seed", i1).addDetail("Biome", Registry.BIOME.getKey(biome));
                throw new ReportedException(crashreport);
            }
        }

    }

    public void generateStructures(BiomeManager p_227058_1_, IChunk chunk, ChunkGenerator<?> p_227058_3_, TemplateManager p_227058_4_) {
        for(Structure<?> structure : Feature.STRUCTURES.values()) {
            if (p_227058_3_.getBiomeProvider().hasStructure(structure)) {
                StructureStart structurestart = chunk.getStructureStart(structure.getStructureName());
                int i = structurestart != null ? structurestart.getRefCount() : 0;
                SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
                ChunkPos chunkpos = chunk.getPos();
                StructureStart structurestart1 = StructureStart.DUMMY;

                BlockPos biomePos = new BlockPos(chunkpos.getXStart() + 9, 0, chunkpos.getZStart() + 9);
                //WN.LOGGER.debug("Locating at " + biomePos + " / " + (biomePos.getX() & 15) + ":"+ (biomePos.getZ() & 15));
                Biome biome = p_227058_1_.getBiome(biomePos);
                /*WN.LOGGER.debug("biome found " + biome.getRegistryName());
                biome = GridBiomeLayer.applyHeightmapBiome(Heightmap.Type.OCEAN_FLOOR_WG,biome,chunk,getSeaLevel(),biomePos.getX(), biomePos.getZ());
                WN.LOGGER.debug("biome fix " + biome.getRegistryName());*/
                //TODO Villages not spawn on lake biomes
                if (structure.canBeGenerated(p_227058_1_, p_227058_3_, sharedseedrandom, chunkpos.x, chunkpos.z, biome)) {
                    StructureStart structurestart2 = structure.getStartFactory().create(structure, chunkpos.x, chunkpos.z, MutableBoundingBox.getNewBoundingBox(), i, p_227058_3_.getSeed());
                    structurestart2.init(this, p_227058_4_, chunkpos.x, chunkpos.z, biome);
                    structurestart1 = structurestart2.isValid() ? structurestart2 : StructureStart.DUMMY;
                }

                chunk.putStructureStart(structure.getStructureName(), structurestart1);
            }
        }

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

        int[] chunkHeights = this.getHeightsInChunk(chunkpos, worldIn);

        /**
         *
         Geo Start

         */


        //Temp Config Start

        FastNoiseLite noise = new FastNoiseLite();
        noise.SetNoiseType(FastNoiseLite.NoiseType.Cellular);
        noise.SetCellularDistanceFunction(FastNoiseLite.CellularDistanceFunction.Euclidean);
        noise.SetCellularReturnType(FastNoiseLite.CellularReturnType.Distance2);
        noise.SetDomainWarpType(FastNoiseLite.DomainWarpType.OpenSimplex2);
        noise.SetDomainWarpAmp(64);

        List<GeoLayerConfig> soil = new ArrayList<>();
        soil.add(new GeoLayerConfig(Blocks.SAND, 5, 3, 2));
        soil.add(new GeoLayerConfig(Blocks.DIRT, 2, 1, 5));

        List<GeoLayerConfig> sedimentary = new ArrayList<>();
        sedimentary.add(new GeoLayerConfig(WNBlocks.LIMESTONE, 20, 18, 8));
        sedimentary.add(new GeoLayerConfig(Blocks.SANDSTONE, 5, 4, 4));
        sedimentary.add(new GeoLayerConfig(Blocks.RED_SANDSTONE, 3, 2, 1));

        List<GeoLayerConfig> carbonate = new ArrayList<>();
        carbonate.add(new GeoLayerConfig(WNBlocks.MARBLE, 20, 15, 2));
        carbonate.add(new GeoLayerConfig(WNBlocks.GNEISS, 4, 3, 4));
        carbonate.add(new GeoLayerConfig(WNBlocks.SLATE_BLUE, 15, 8, 8));
        carbonate.add(new GeoLayerConfig(WNBlocks.SLATE_PURPLE, 2, 1, 3));

         GeoGeneratorConfig geologyConfig = new GeoGeneratorConfig(
            GeoGeneratorConfig.Type.basic,
            noise,
            soil,
            sedimentary,
            carbonate
         );

        //Temp Config End

         GeologyGenerator manager = new GeologyGenerator(seed);

         //Creating BlockPos Instance.
         BlockPos.Mutable blockPos = new BlockPos.Mutable();

         for (int x = 0; x < 16; x++) {
             for (int z = 0; z < 16; z++) {

                blockPos.setPos(x,0,z);

                int height = chunkHeights[(x * 16) + z];

                manager.generateTile(geologyConfig, chunkStartX + x, height, chunkStartZ + z);

                manager.applyTile(chunk, blockPos, height);

            }
         }

         /**
          *
         *Geo End
          *
         */


        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                mutable.setPos(x,0,z);
                int rX = chunkStartX + x;
                int rZ = chunkStartZ + z;
                int height = chunkHeights[(x * 16) + z];
                for (AbstractVillagePiece piece : structurePieces) {
                    MutableBoundingBox boundingBox = piece.getBoundingBox();
                    int minX = boundingBox.minX - 1;
                    int minZ = boundingBox.minZ - 1;
                    int maxX = boundingBox.maxX + 1;
                    int maxZ = boundingBox.maxZ + 1;

                    if(rX >= minX && rX <= maxX && rZ >= minZ && rZ <= maxZ){
                        int structureY = boundingBox.minY;
                        if(structureY > height) {
                            int minXDist = rX - minX;
                            int minZDist = rZ - minZ;
                            int maxXDist = maxX - rX;
                            int maxZDist = maxZ - rZ;

                            int xDist = Math.min(minXDist,maxXDist);
                            int zDist = Math.min(minZDist,maxZDist);

                            int dist = Math.min(xDist,zDist);
                            for(int l = structureY; l > structureY - dist; l--){
                                mutable.setY(l-1);
                                chunk.setBlockState(mutable, this.settings.getDefaultBlock(), false);
                            }
                        }
                    }

                }

                //TODO JigsawJunction
            }
        }
    }


    public void generateTerrain(IChunk chunk, int[] noiseY) {

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                mutable.setPos(x,0,z);
                int height = noiseY[(x * 16) + z];

                for (int y = 0; y < 256; y++) {

                    mutable.setY(y);

                    if (y > height) {
                        if (y < this.getSeaLevel()) {
                            chunk.setBlockState(mutable, this.settings.getDefaultFluid(), false);
                        }
                    } else {
                        chunk.setBlockState(mutable, this.settings.getDefaultBlock(), false);
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
        //Thanks to SuperCoder79 for providing this code. See GitHub at: https://github.com/SuperCoder7979/simplexterrain
        int[] res = noiseCache.get(pos.asLong());
        if (res != null) return res;

        int[] vals = new int[256];

        // useNoise(vals, pos, 0, 16);
        int threads = threadCount;

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
        //Thanks to AlcatrazEscapee for providing this lerp code. See GitHub at: https://github.com/TerraFirmaCraft/TerraFirmaCraft/
        final Object2DoubleMap<LerpConfiguration> weightMap16 = new Object2DoubleOpenHashMap<>(4), weightMap4 = new Object2DoubleOpenHashMap<>(2), weightMap1 = new Object2DoubleOpenHashMap<>();

        final ChunkArraySampler.CoordinateAccessor<LerpConfiguration> biomeAccessor = (x, z) -> {
            Biome biome = SmoothColumnBiomeMagnifier.SMOOTH.getBiome(worldIn.getSeed(), (pos.x * 16) + x, 0, (pos.z * 16) + z, gridProvider, true);
            return LerpConfiguration.get(biome);
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
        Cell cell = gridProvider.getNoiseCell(x >> 2,z >> 2);
        Biome biome = gridProvider.getNoiseBiome(cell,x >> 2, 1, z >> 2,true);
        ChunkLandscape chunkLandscape = ChunkLandscape.getOrCreate(x, z, this.seed, this.getSeaLevel(), biome, this.chunk);

        int height =  (int) chunkLandscape.generateHeightmap(biomeProvider,weightMap1,variantAccessor);
        cell = null;
        return height;
    }

    //getHeight
    @Override
    public int func_222529_a(int blockX, int blockZ, Type heightmap) {
        int chunkX = blockX >> 4;
        int chunkZ = blockZ >> 4;

        final Object2DoubleMap<LerpConfiguration> weightMap16 = new Object2DoubleOpenHashMap<>(4), weightMap4 = new Object2DoubleOpenHashMap<>(2), weightMap1 = new Object2DoubleOpenHashMap<>();

        final ChunkArraySampler.CoordinateAccessor<LerpConfiguration> biomeAccessor = (x, z) -> {
            Biome biome = SmoothColumnBiomeMagnifier.SMOOTH.getBiome(seed, (chunkX * 16) + x, 0, (chunkZ * 16) + z, gridProvider,true);
            return LerpConfiguration.get(biome);
        };

        final LerpConfiguration[] sampledBiomes16 = ChunkArraySampler.fillSampledArray(new LerpConfiguration[10 * 10], biomeAccessor, 4);
        final LerpConfiguration[] sampledBiomes4 = ChunkArraySampler.fillSampledArray(new LerpConfiguration[13 * 13], biomeAccessor, 2);
        final LerpConfiguration[] sampledBiomes1 = ChunkArraySampler.fillSampledArray(new LerpConfiguration[24 * 24], biomeAccessor);

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                if((chunkX * 16) + x == blockX && (chunkZ * 16) + z == blockZ) {
                    // Sample biome weights at different distances
                    ChunkArraySampler.fillSampledWeightMap(sampledBiomes16, weightMap16, 4, x, z);
                    ChunkArraySampler.fillSampledWeightMap(sampledBiomes4, weightMap4, 2, x, z);
                    ChunkArraySampler.fillSampledWeightMap(sampledBiomes1, weightMap1, x, z);

                    Function<LerpConfiguration, BiomeVariants> variantAccessor = LerpConfiguration::getBiomeVariants;

                    // Group biomes at different distances. This has the effect of making some biome transitions happen over larger distances than others.
                    // This is used to make most land biomes blend at maximum distance, while allowing biomes such as rivers to blend at short distances, creating better cliffs as river biomes are smaller width than other biomes.
                    ChunkArraySampler.reduceGroupedWeightMap(weightMap4, weightMap16, variantAccessor.andThen(BiomeVariants::getLargeGroup), BiomeVariants.LargeGroup.SIZE);
                    ChunkArraySampler.reduceGroupedWeightMap(weightMap1, weightMap4, variantAccessor.andThen(BiomeVariants::getSmallGroup), BiomeVariants.SmallGroup.SIZE);

                    int height = getTerrainHeight((chunkX * 16) + x, (chunkZ * 16) + z, weightMap1, variantAccessor) + 1;
                    if(height <= getSeaLevel()){
                        return getSeaLevel();
                    }else{
                        return height;
                    }
                }
            }
        }
        return getSeaLevel();
    }

    public void spawnMobs(WorldGenRegion region) {
        int i = region.getMainChunkX();
        int j = region.getMainChunkZ();
        Biome biome = region.getBiome((new ChunkPos(i, j)).asBlockPos());
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
        sharedseedrandom.setDecorationSeed(region.getSeed(), i << 4, j << 4);
        WorldEntitySpawner.performWorldGenSpawning(region, biome, i, j, sharedseedrandom);
    }

    public void spawnMobs(ServerWorld worldIn, boolean spawnHostileMobs, boolean spawnPeacefulMobs) {
        this.phantomSpawner.tick(worldIn, spawnHostileMobs, spawnPeacefulMobs);
        this.patrolSpawner.tick(worldIn, spawnHostileMobs, spawnPeacefulMobs);
        this.catSpawner.tick(worldIn, spawnHostileMobs, spawnPeacefulMobs);
        this.siegeSpawner.tick(worldIn, spawnHostileMobs, spawnPeacefulMobs);
    }

    private static double func_222556_a(int p_222556_0_, int p_222556_1_, int p_222556_2_) {
        int i = p_222556_0_ + 12;
        int j = p_222556_1_ + 12;
        int k = p_222556_2_ + 12;
        if (i >= 0 && i < 24) {
            if (j >= 0 && j < 24) {
                return k >= 0 && k < 24 ? (double)field_222561_h[k * 24 * 24 + i * 24 + j] : 0.0D;
            } else {
                return 0.0D;
            }
        } else {
            return 0.0D;
        }
    }

    private static double func_222554_b(int p_222554_0_, int p_222554_1_, int p_222554_2_) {
        double d0 = (double)(p_222554_0_ * p_222554_0_ + p_222554_2_ * p_222554_2_);
        double d1 = (double)p_222554_1_ + 0.5D;
        double d2 = d1 * d1;
        double d3 = Math.pow(Math.E, -(d2 / 16.0D + d0 / 16.0D));
        double d4 = -d1 * MathHelper.fastInvSqrt(d2 / 2.0D + d0 / 2.0D) / 2.0D;
        return d4 * d3;
    }
}
