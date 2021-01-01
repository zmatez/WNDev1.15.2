package com.matez.wildnature.world.generation.structures.ambient;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.util.other.Pair;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.structures.WNAbstractStructure;
import com.matez.wildnature.world.generation.structures.utils.StructurePlacement;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;

import java.util.ArrayList;
import java.util.Random;

public class WNSeaCaveStructure extends WNAbstractStructure {
    private Direction facing;
    private Direction[] directions = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
    private int displacement = 5, displacementMove = 4;
    private int offset = 0;
    public WNSeaCaveStructure(ResourceLocation path, StructurePlacement placement, Direction facing, int offset) {
        super(path, placement);
        this.facing = facing;
        this.offset = offset;
    }

    @Override
    protected int getBiomeFeatureDistance(ChunkGenerator<?> chunkGenerator) {
        return 12;
    }

    @Override
    protected int getBiomeFeatureSeparation(ChunkGenerator<?> chunkGenerator) {
        return 2;
    }

    @Override
    public int getCenterYOffset() {
        return -1;
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos) {
        Rotation rot = null;
        this.clearBlockReplacements();

        Block sandBlock = Blocks.SAND;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for(int x = -25; x < 25; x++){
            for(int z = -25; z < 25; z++){
                mutable.setPos(pos.getX() + x,0,pos.getZ() + z);
                mutable.setY(getStructureY(x,z,worldIn,worldIn.getChunk(mutable),generator,rand));

                BlockState downState = worldIn.getBlockState(mutable.down());
                Block block = downState.getBlock();
                if(block == Blocks.WATER || block == Blocks.ICE){
                    BlockPos.Mutable landPos = new BlockPos.Mutable(mutable.down());
                    boolean found = false;
                    for (Direction direction : directions) {
                        BlockState landState = worldIn.getBlockState(landPos.offset(direction,displacementMove));
                        if(landState.isIn(BlockTags.SAND)){
                            sandBlock = landState.getBlock();
                            mutable.setPos(landPos.offset(direction, offset));
                            mutable.setY(getStructureY(x, z, worldIn, worldIn.getChunk(mutable), generator, rand));
                            rot = applyRotation(facing, direction);
                            found = true;
                            break;
                        }
                    }
                    if(found){
                        break;
                    }
                }

            }
        }

        if(rot == null){
            return false;
        }

        mutable.setY(62);

        if(sandBlock == WNBlocks.WHITE_SAND || sandBlock == WNBlocks.WHITE_SANDSTONE){
                    addBlockReplacement(Blocks.SAND, WNBlocks.WHITE_SAND);
                    addBlockReplacement(Blocks.SANDSTONE, WNBlocks.WHITE_SANDSTONE);
                    addBlockReplacement(Blocks.SMOOTH_SANDSTONE, WNBlocks.SMOOTH_WHITE_SANDSTONE);
        }

        placeBlocks(mutable,worldIn,rot,rand);
        return true;
    }

    @Override
    protected BlockState airState(IWorld world, BlockPos pos) {
        return pos.getY() >= world.getSeaLevel() ? Blocks.AIR.getDefaultState() : Blocks.WATER.getDefaultState();
    }
}
