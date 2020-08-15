package com.matez.wildnature.world.gen.structures.nature;

import com.google.common.collect.Sets;
import com.google.gson.annotations.Expose;
import com.matez.wildnature.blocks.FloweringLeaves;
import com.matez.wildnature.blocks.FruitableLeaves;
import com.matez.wildnature.blocks.LeavesBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.*;
import net.minecraft.command.arguments.BlockStateArgument;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.IPlantable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import static net.minecraft.world.gen.feature.AbstractTreeFeature.isWater;

public class SchemFeature extends Feature<NoFeatureConfig> {

    public BlockState LEAVES = notDecayingLeaf(Blocks.OAK_LEAVES);
    public BlockState LOG = Blocks.OAK_LOG.getDefaultState();
    public BlockState LEAVES_OVERRIDE = null;
    public BlockState LOG_OVERRIDE = null;
    public BlockState DIRT = Blocks.DIRT.getDefaultState();
    public BlockState BRANCH = LEAVES;
    @Expose
    public IWorld world;
    public BlockPos startBlockPos;
    public Random random;
    public int terrainIncrease = 0;
    @Expose
    private ArrayList<BlockPos> addedBlocks = new ArrayList<>();
    @Expose
    private ArrayList<BlockPos> bottomBlocks = new ArrayList<>();
    private int rotation;
    private boolean canGenerate = true;
    private boolean virtualPlace = false;
    private net.minecraftforge.common.IPlantable sapling = (net.minecraftforge.common.IPlantable)net.minecraft.block.Blocks.OAK_SAPLING;

    public SchemFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
        LOG = Blocks.OAK_LOG.getDefaultState();
        LEAVES = notDecayingLeaf(Blocks.OAK_LEAVES);
        LEAVES_OVERRIDE = null;
        LOG_OVERRIDE = null;
        BRANCH = LEAVES;
    }


    public SchemFeature() {
        this(NoFeatureConfig::deserialize);
    }

    public static BlockState notDecayingLeaf(Block block) {
        if (block instanceof LeavesBlock) {
            return block.getDefaultState().with(LeavesBlock.PERSISTENT, true);
        }
        return block.getDefaultState();
    }

    public SchemFeature setCustomLog(BlockState log) {
        LOG = log;
        return this;
    }

    public SchemFeature setCustomLeaf(BlockState leaf) {
        LEAVES = leaf;
        BRANCH = LEAVES;
        return this;
    }

    /**
     * use it if LEAVES or LOG isnt defined in the log, just strings with leaves and log
     * @param log
     * @return
     */
    public SchemFeature setCustomLogOverride(BlockState log) {
        LOG = log;
        LOG_OVERRIDE = log;
        return this;
    }

    /**
     * use it if LEAVES or LOG isnt defined in the log, just strings with leaves and log
     * @param leaf
     * @return
     */
    public SchemFeature setCustomLeafOverride(BlockState leaf) {
        LEAVES = leaf;
        LEAVES_OVERRIDE = leaf;
        BRANCH = LEAVES;
        return this;
    }

    public SchemFeature setCustomLogAndLeaf(BlockState log, BlockState leaf) {
        LOG = log;
        LEAVES = leaf;
        BRANCH = LEAVES;
        return this;
    }

    public IPlantable getSapling() {
        return sapling;
    }

    public void setDirt(BlockState dirt) {
        DIRT = dirt;
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        return place(worldIn,rand,pos);
    }

    //For AbstractTreeFeature
    protected boolean place(IWorldGenerationReader generationReader, Random rand, BlockPos positionIn, Set<BlockPos> changedLogs, Set<BlockPos> changedLeaves, MutableBoundingBox boundingBoxIn, NoFeatureConfig configIn) {
        return place(generationReader,rand,positionIn);
    }

    protected boolean place(IWorldGenerationReader worldIn, Random rand, BlockPos position) {
        if (!canGrowTree(worldIn, position.down(), getSapling())) {
            return false;
        }
        BlockPos soilPos = position.down();
        int x = 0;
        while (isWater(worldIn, soilPos)) {
            soilPos = soilPos.down();
            x++;
        }
        if (x >= 15) {
            return false;
        }

        this.world = (IWorld) worldIn;
        this.startBlockPos = soilPos.up(terrainIncrease);
        this.random = rand;
        rotation = Utilities.rint(1, 4, rand);
        canGenerate = true;
        addedBlocks.clear();
        virtualPlace = true;
        setBlocks();
        workWithTerrain();
        virtualPlace = false;
        if (canGenerate) {
            setBlocks();
        }
        return true;
    }

    public boolean canGrowTree(IWorldGenerationReader world, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
        return world.hasBlockState(pos, state -> state.canSustainPlant((net.minecraft.world.IBlockReader) world, pos, Direction.UP, sapling));
    }

    public static boolean isWater(IWorldGenerationBaseReader worldIn, BlockPos pos) {
        return worldIn.hasBlockState(pos, (p_214583_0_) -> {
            return p_214583_0_.getBlock() == Blocks.WATER;
        });
    }

    public Set<BlockPos> setBlocks() {
        return Sets.newHashSet(addedBlocks);
    }

    public void Block(int x, int y, int z, BlockState state) {
        if(LOG_OVERRIDE!=null && state.getBlock() instanceof LogBlock){
            state = LOG_OVERRIDE;
        }
        if(LEAVES_OVERRIDE!=null && state.getBlock() instanceof LeavesBlock){
            state = LEAVES_OVERRIDE;
        }
        if (state.getBlock() == WNBlocks.MAGNOLIA_LEAVES || state.getBlock() == WNBlocks.FORSYTHIA_LEAVES || Utilities.rint(0, 10) == 0) {
            if (state.getBlock() instanceof FloweringLeaves) {
                state = state.with(FloweringLeaves.FLOWERING, true);
            } else if (state.getBlock() instanceof FruitableLeaves) {
                state = state.with((((FruitableLeaves) state.getBlock()).getStage()), Utilities.rint(1, ((FruitableLeaves) state.getBlock()).getMaxStages()));
            }
        }

        BlockPos pos = startBlockPos;
        int sx = startBlockPos.getX();
        int sy = startBlockPos.getY() - 1;
        int sz = startBlockPos.getZ();
        if (rotation >= 1 && rotation <= 4) {
            if (rotation == 1) {
                pos = new BlockPos(x, y, z);//0
            } else if (rotation == 2) {
                pos = new BlockPos(x, y, z).rotate(Rotation.CLOCKWISE_180);//180
                state = state.rotate(Rotation.CLOCKWISE_180);
            } else if (rotation == 3) {
                pos = new BlockPos(x, y, z).rotate(Rotation.CLOCKWISE_90);//90
                state = state.rotate(Rotation.CLOCKWISE_90);
            } else {
                pos = new BlockPos(x, y, z).rotate(Rotation.COUNTERCLOCKWISE_90);//-90
                state = state.rotate(Rotation.COUNTERCLOCKWISE_90);
            }
            pos = new BlockPos(pos.getX() + sx, pos.getY() + sy, pos.getZ() + sz);
        } else {
            throw new IllegalArgumentException("Unknown rotation for tree at " + startBlockPos.toString() + " :\nrotation = " + rotation + " (1-4)\n   Please report it to author!");
        }

        if (world.getBlockState(pos).getBlock() == Blocks.WATER && state.getBlock() instanceof IWaterLoggable) {
            state = state.with(BlockStateProperties.WATERLOGGED, true);
        }

        if (!virtualPlace) {
            if ((isLeaf(state.getBlock()) && !world.getBlockState(pos).isSolid())) {
                world.setBlockState(pos, state, 19);
            }else if(!isLeaf(state.getBlock())){
                world.setBlockState(pos, state, 19);
            }
        }
        if ((isLeaf(state.getBlock()) && !world.getBlockState(pos).isSolid()) || !isLeaf(state.getBlock())) {
            addedBlocks.add(pos);
        }

    }


    public void Block(int x, int y, int z, String s) {
        try {
            BlockState bs = BlockStateArgument.blockState().parse(new StringReader(s)).getState();
            Block(x, y, z, bs);

            return;
        } catch (CommandSyntaxException e) {
        }
    }

    public void workWithTerrain() {
        if (bottomBlocks == null) {
            return;
        }

        int x = 0;
        BlockPos down = null;
        while (x < addedBlocks.size()) {
            if (down == null) {
                down = addedBlocks.get(x);
            }
            if (addedBlocks.get(x).getY() < down.getY()) {
                down = addedBlocks.get(x);
            }
            x++;
        }

        x = 0;
        while (x < addedBlocks.size()) {
            if (addedBlocks.get(x).getY() == down.getY() + 1) {
                bottomBlocks.add(downBlock(addedBlocks.get(x), 1));
            }
            x++;
        }

        if (bottomBlocks.size() != 0 && bottomBlocks.size() != 1) {
            for (int i = 0; i < 10; i++) {
                boolean allSolid = true;
                for (int a = 0; a < bottomBlocks.size(); a++) {
                    BlockState state = world.getBlockState(bottomBlocks.get(a).down(i));
                    if (!state.isSolid()) {
                        allSolid = false;
                        startBlockPos = startBlockPos.down();
                        break;
                    }
                }
                if (allSolid) {
                    break;
                }
                if (i == 9 && !allSolid) {
                    canGenerate = false;
                }
            }
        }

        addedBlocks.clear();
        bottomBlocks.clear();
    }

    private BlockPos downBlock(BlockPos blockPos, int down) {
        return new BlockPos(blockPos.getX(), blockPos.getY() - down, blockPos.getZ());
    }

    private boolean isLeaf(Block b) {
        return b instanceof LeavesBlock;
    }

    public static class BlockStatePos {
        private BlockState state;
        private BlockPos pos;

        public BlockStatePos(BlockState state, BlockPos pos) {
            this.state = state;
            this.pos = pos;
        }

        public BlockPos getPos() {
            return pos;
        }

        public BlockState getState() {
            return state;
        }
    }

}
