package com.matez.wildnature.world.generation.structures;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import com.matez.wildnature.world.generation.chunk.generation.IWNChunkGenerator;
import com.matez.wildnature.world.generation.structures.utils.BlockData;
import com.matez.wildnature.world.generation.structures.utils.BlockReplacement;
import com.matez.wildnature.world.generation.structures.utils.StructureCache;
import com.matez.wildnature.world.generation.structures.utils.StructurePlacement;
import com.mojang.brigadier.StringReader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.command.arguments.BlockStateInput;
import net.minecraft.command.arguments.BlockStateParser;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;
import org.apache.commons.io.IOUtils;

import javax.annotation.Nullable;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.zip.ZipInputStream;

public abstract class WNAbstractStructure {
    private final ResourceLocation path;
    private final ArrayList<BlockData> blockData = new ArrayList<>();
    private final StructurePlacement placement;
    private final ArrayList<BlockReplacement> blockReplacements = new ArrayList<>();
    private BlockPos min = new BlockPos(0, 0, 0), max = new BlockPos(0, 0, 0);

    protected boolean randomRotation = true;
    protected Rotation rotation = Rotation.CLOCKWISE_180;

    public WNAbstractStructure(ResourceLocation path, StructurePlacement placement) {
        this.path = path;
        this.placement = placement;
    }

    public String getName() {
        return path.toString();
    }

    public ResourceLocation getPath() {
        return path;
    }

    public int getStructureY(int x, int z, IWorld world, IChunk chunk, ChunkGenerator<?> chunkGenerator, Random random) {
        return placement.getPlacement().getPlacePosition(x, z, chunk, world, chunkGenerator, random);
    }

    public StructurePlacement getPlacement() {
        return placement;
    }

    public void init() {
        WN.LOGGER.info("Initializing structure: " + path);

        String contents = getFile();
        CompletableFuture<?> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                BlockPos.Mutable newMin = new BlockPos.Mutable(min);
                BlockPos.Mutable newMax = new BlockPos.Mutable(max);
                if (contents != null) {
                    Scanner scanner = new Scanner(contents);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String rLine = line.replaceAll(" ", "");
                        if (rLine.startsWith("//")) {
                            continue;
                        }

                        if (rLine.startsWith("Block")) {
                            rLine = rLine.replace("Block", "");
                            String xString = "", yString = "", zString = "", blockString = "";
                            int currentIndex = 0;
                            for (char c : rLine.toCharArray()) {
                                if (c == '(') {
                                    currentIndex++;
                                    continue;
                                } else if (c == ')') {
                                    currentIndex++;
                                    continue;
                                } else if (c == ',') {
                                    currentIndex++;
                                    continue;
                                } else if (c == '"') {
                                    currentIndex++;
                                    continue;
                                }
                                if (currentIndex == 1) {
                                    xString += c;
                                } else if (currentIndex == 2) {
                                    yString += c;
                                } else if (currentIndex == 3) {
                                    zString += c;
                                } else if (currentIndex == 5) {
                                    blockString += c;
                                }
                            }
                            int x = 0, y = 0, z = 0;
                            try {
                                x = Integer.parseInt(xString);
                                y = Integer.parseInt(yString);
                                z = Integer.parseInt(zString);
                            } catch (Exception e) {
                                WN.LOGGER.warn("Unable to parse ints at line \"" + rLine + "\" at structure " + path);
                            }

                            if (x < newMin.getX()) {
                                newMin.setX(x);
                            }
                            if (y < newMin.getY()) {
                                newMin.setY(y);
                            }
                            if (z < newMin.getZ()) {
                                newMin.setZ(z);
                            }

                            if (x > newMax.getX()) {
                                newMax.setX(x);
                            }
                            if (y > newMax.getY()) {
                                newMax.setY(y);
                            }
                            if (z > newMax.getZ()) {
                                newMax.setZ(z);
                            }

                            BlockStateInput blockStateInput = parseBlockState(blockString);
                            if (blockStateInput != null) {
                                BlockData data = new BlockData(new BlockPos(x, y, z), blockStateInput);
                                blockData.add(data);
                            } else {
                                WN.LOGGER.warn("Unable to parse blockstate at line \"" + rLine + "\" at structure " + path);
                            }
                        }
                    }
                }

                min = newMin;
                max = newMax;
            }
        });
        WNStructures.futures.add(future);
    }

    private BlockStateInput parseBlockState(String blockState) {
        try {
            BlockStateParser blockstateparser = (new BlockStateParser(new StringReader(blockState), true)).parse(true);
            return new BlockStateInput(blockstateparser.getState(), blockstateparser.getProperties().keySet(), blockstateparser.getNbt());
        } catch (Exception e) {
            return null;
        }
    }

    private String getFile() {
        try {
            InputStream inputStream = getResourceAsStream("data/" + path.getNamespace() + "/wnstructures/" + path.getPath() + ".wnstruct.zip", WNAbstractStructure.class);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);

            zipInputStream.getNextEntry();
            String out = IOUtils.toString(zipInputStream, StandardCharsets.UTF_8);
            zipInputStream.close();
            bufferedInputStream.close();
            inputStream.close();
            return out;

        } catch (IOException e) {
            WN.LOGGER.fatal("Unable to load structure \"" + path + "\" from \"" + "data/" + path.getNamespace() + "/wnstructures/" + "\".");
        }
        return null;
    }

    private static InputStream getResourceAsStream(String resource, Class clazz) {
        final InputStream in = getContextClassLoader().getResourceAsStream(resource);

        return in == null ? clazz.getResourceAsStream(resource) : in;
    }

    private static ClassLoader getContextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public void applyRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    public Rotation applyRotation(Direction none, Direction newDirection) {
        int off = Math.abs(none.getHorizontalIndex() - newDirection.getHorizontalIndex());
        if(off == 0){
            return Rotation.NONE;
        }else if(off == 1){
            return Rotation.CLOCKWISE_90;
        }else if(off == 2){
            return Rotation.CLOCKWISE_180;
        }else if(off == 3){
            return Rotation.COUNTERCLOCKWISE_90;
        }
        return Rotation.NONE;
    }

    public void setRandomRotation(boolean randomRotation) {
        this.randomRotation = randomRotation;
    }

    protected Rotation randomRotation(Random random){
        int i = Utilities.rint(0,3,random);
        switch (i){
            case 0:
                return Rotation.NONE;
            case 1:
                return Rotation.CLOCKWISE_90;
            case 2:
                return Rotation.CLOCKWISE_180;
            case 3:
                return Rotation.COUNTERCLOCKWISE_90;
        }
        return Rotation.NONE;
    }

    public WNAbstractStructure addBlockReplacement(Block from, Block to) {
        blockReplacements.add(new BlockReplacement(from, to));
        return this;
    }

    private BlockState replaceBlock(BlockState blockState) {
        Block block = blockState.getBlock();
        for (BlockReplacement blockReplacement : blockReplacements) {
            Block newBlock = blockReplacement.process(block);
            if (newBlock != block) {
                return newBlock.getDefaultState();
            }
        }
        return blockState;
    }

    // GENERATION
    public boolean canBeGenerated(BiomeManager biomeManagerIn, ChunkGenerator<?> generatorIn, Random randIn, int chunkX, int chunkZ, Biome biomeIn) {
        if (generatorIn instanceof IWNChunkGenerator) {
            IWNChunkGenerator structureAccess = (IWNChunkGenerator) generatorIn;
            ChunkPos chunkpos = this.getStartPositionForPosition(generatorIn, structureAccess, randIn, chunkX, chunkZ, 0, 0);
            return chunkX == chunkpos.x && chunkZ == chunkpos.z && structureAccess.hasStructure(biomeIn, this);
        }
        return false;
    }

    protected int getBiomeFeatureDistance(ChunkGenerator<?> chunkGenerator) {
        return chunkGenerator.getSettings().getBiomeFeatureDistance();
    }

    protected int getBiomeFeatureSeparation(ChunkGenerator<?> chunkGenerator) {
        return chunkGenerator.getSettings().getBiomeFeatureSeparation();
    }

    protected ChunkPos getStartPositionForPosition(ChunkGenerator<?> chunkGenerator, IWNChunkGenerator structureAccess, Random random, int x, int z, int spacingOffsetsX, int spacingOffsetsZ) {
        int i = this.getBiomeFeatureDistance(chunkGenerator);
        int j = this.getBiomeFeatureSeparation(chunkGenerator);
        int k = x + i * spacingOffsetsX;
        int l = z + i * spacingOffsetsZ;
        int i1 = k < 0 ? k - i + 1 : k;
        int j1 = l < 0 ? l - i + 1 : l;
        int k1 = i1 / i;
        int l1 = j1 / i;
        ((SharedSeedRandom) random).setLargeFeatureSeedWithSalt(chunkGenerator.getSeed(), k1, l1, this.getSeedModifier());
        k1 = k1 * i;
        l1 = l1 * i;
        k1 = k1 + random.nextInt(i - j);
        l1 = l1 + random.nextInt(i - j);
        return new ChunkPos(k1, l1);
    }

    protected int getSeedModifier() {
        return WNStructures.count;
    }

    @Nullable
    public BlockPos findNearest(World worldIn, ChunkGenerator<? extends GenerationSettings> chunkGenerator, IWNChunkGenerator structureAccess, BlockPos pos, int radius, boolean skipExistingChunks) {
        return this.findNearest(worldIn,chunkGenerator,structureAccess,pos,radius,skipExistingChunks,(x,z) -> {});
    }

    @Nullable
    public BlockPos findNearest(World worldIn, ChunkGenerator<? extends GenerationSettings> chunkGenerator, IWNChunkGenerator structureAccess, BlockPos pos, int radius, boolean skipExistingChunks, FindUpdate update) {
        int i = pos.getX() >> 4;
        int j = pos.getZ() >> 4;
        int k = 0;

        for (SharedSeedRandom sharedseedrandom = new SharedSeedRandom(); k <= radius; ++k) {
            for (int l = -k; l <= k; ++l) {
                boolean flag = l == -k || l == k;

                for (int i1 = -k; i1 <= k; ++i1) {
                    boolean flag1 = i1 == -k || i1 == k;
                    if (flag || flag1) {
                        ChunkPos chunkpos = this.getStartPositionForPosition(chunkGenerator,structureAccess, sharedseedrandom, i, j, l, i1);
                        Biome biome = structureAccess.getGridProvider().getNoiseBiome(chunkpos.getXStart(),0,chunkpos.getZStart());
                        if(biome instanceof WNBiome) {
                            if(((WNBiome)biome).hasStructure(this)) {
                                IChunk chunk = worldIn.getChunk(chunkpos.x, chunkpos.z, ChunkStatus.STRUCTURE_STARTS);
                                StructureCache cache = StructureCache.get(chunkpos);
                                if (cache != null) {
                                    chunk = worldIn.getChunk(chunkpos.x, chunkpos.z);
                                    cache = StructureCache.get(chunkpos);
                                    if(cache != null) {
                                        return new BlockPos(chunkpos.getXStart(), cache.getStructureCenterY(), chunkpos.getZStart());
                                    }
                                }
                            }
                        }

                        update.update(chunkpos.x,chunkpos.z);


                        if (k == 0) {
                            break;
                        }
                    }
                }

                if (k == 0) {
                    break;
                }
            }
        }

        return null;
    }

    public int getCenterYOffset(){
        return 0;
    }

    public BlockPos getMax() {
        return max;
    }

    public BlockPos getMin() {
        return min;
    }

    public boolean generate(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos) {
        if(worldIn instanceof WorldGenRegion){
            IChunk currentChunk = worldIn.getChunk(pos);
            int minChunkX = (min.getX() << 4) - 1 + currentChunk.getPos().x;
            int minChunkZ = (min.getZ() << 4) - 1 + currentChunk.getPos().z;
            int maxChunkX = (max.getX() << 4) - 1 + currentChunk.getPos().x;
            int maxChunkZ = (max.getZ() << 4) - 1 + currentChunk.getPos().z;

            if(!((WorldGenRegion)worldIn).chunkExists(minChunkX, minChunkZ) || !((WorldGenRegion)worldIn).chunkExists(maxChunkX, maxChunkZ)){
                return false;
            }
        }
        return place(worldIn, generator, rand, pos);
    }

    protected boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos) {
        Rotation rot = rotation;
        if (randomRotation) {
            rot = randomRotation(rand);
        }

        placeBlocks(pos, worldIn, rot, rand);
        return true;
    }

    protected void placeBlocks(BlockPos startPos, IWorld world, Rotation rotation, Random random) {
        startPos = new BlockPos(startPos.getX(),startPos.getY() ,startPos.getZ() ).up(getCenterYOffset());
        for (BlockData blockDatum : blockData) {
            block(world, startPos, blockDatum.getBlockPos(), blockDatum.getBlockStateInput(), rotation, random);
        }
    }

    private void block(IWorld world, BlockPos startPos, BlockPos pos, BlockStateInput input, Rotation rotation, Random random) {
        BlockState state = input.getState();
        BlockPos realPos = pos.rotate(rotation).add(startPos.getX(),startPos.getY(),startPos.getZ());
        BlockState currentState = world.getBlockState(realPos);

        if(currentState.getBlock() == Blocks.WATER && state.getBlock() instanceof IWaterLoggable) {
            state = state.with(BlockStateProperties.WATERLOGGED, true);
        }

        if(state.getBlock() == Blocks.STRUCTURE_VOID){
            state = airState(world,realPos);
        }

        state = replaceBlock(state);
        state.rotate(rotation);

        world.setBlockState(realPos, state, 19);
    }

    protected BlockState airState(IWorld world, BlockPos pos){
        return pos.getY() >= world.getSeaLevel() ? Blocks.AIR.getDefaultState() : Blocks.CAVE_AIR.getDefaultState();
    }

    public static interface FindUpdate{
        public void update(int x, int z);
    }
}
