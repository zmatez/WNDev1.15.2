package com.matez.wildnature.world.generation.structures.nature.fallen;

import com.matez.wildnature.common.blocks.FloweringLeaves;
import com.matez.wildnature.common.blocks.FruitableLeaves;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.IWorldGenerationReader;

import java.util.Random;

public class FallenSchemFeature extends SchemFeature {
    private final int maxFall = 25;

    @Override
    protected boolean place(IWorldGenerationReader worldIn, Random rand, BlockPos position, boolean isNaturalPlace) {
        BlockPos soilPos = position.down();
        if (isNaturalPlace) {
            if (!canGrowTree(worldIn, position.down(), getSapling())) {
                return false;
            }

            int x = 0;
            while (isWater(worldIn, soilPos)) {
                soilPos = soilPos.down();
                x++;
            }
            if (x >= 15) {
                return false;
            }
        }

        this.world = (IWorld) worldIn;
        this.startBlockPos = soilPos.up(terrainIncrease + 2);
        this.random = rand;
        rotation = Utilities.rint(1, 4, rand);
        canGenerate = true;
        addedBlocks.clear();
        virtualPlace = false;
        setBlocks();
        return true;
    }

    @Override
    public void Block(int x, int y, int z, BlockState state) {
        if (LOG_OVERRIDE != null && state.getBlock() instanceof LogBlock) {
            state = LOG_OVERRIDE;
        }
        if (LEAVES_OVERRIDE != null && state.getBlock() instanceof LeavesBlock) {
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

        pos = fallBlock(world, state, pos);

        if (!state.isSolid()) {
            if (world.getBlockState(pos).isSolid() || world.getBlockState(pos).getFluidState().getFluid() == Fluids.WATER || world.getBlockState(pos).getFluidState().getFluid() == Fluids.LAVA) {
                return;
            }
        }

        if (!virtualPlace) {
            if ((isLeaf(state.getBlock()) && !world.getBlockState(pos).isSolid())) {
                world.setBlockState(pos, state, 19);
            } else if (!isLeaf(state.getBlock())) {
                world.setBlockState(pos, state, 19);
            }
        }
        if ((isLeaf(state.getBlock()) && !world.getBlockState(pos).isSolid()) || !isLeaf(state.getBlock())) {
            addedBlocks.add(pos);
        }

    }

    private BlockPos fallBlock(IWorld world, BlockState state, BlockPos pos) {
        BlockPos.Mutable mutable = new BlockPos.Mutable(pos);
        for (int i = 0; i < maxFall; i++) {
            if (mutable.down().getY() <= 5) {
                return mutable;
            }
            if (!world.getBlockState(mutable.down()).isSolid()) {
                mutable.setY(mutable.getY() - 1);
            } else {
                break;
            }
        }
        return mutable;
    }

    @Override
    public FallenSchemFeature setCustomLeafOverride(BlockState leaf) {
        super.setCustomLeafOverride(leaf);
        return this;
    }

    @Override
    public FallenSchemFeature setCustomLogOverride(BlockState log) {
        super.setCustomLogOverride(log);
        return this;
    }
}
