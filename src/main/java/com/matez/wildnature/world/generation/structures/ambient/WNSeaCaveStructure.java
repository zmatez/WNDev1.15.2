package com.matez.wildnature.world.generation.structures.ambient;

import com.matez.wildnature.init.WN;
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
    public WNSeaCaveStructure(ResourceLocation path, StructurePlacement placement, Direction facing) {
        super(path, placement);
        this.facing = facing;
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
        WN.LOGGER.debug("Starting at " + pos);

        /*BlockPos.Mutable fixedBPos = new BlockPos.Mutable(pos);
        boolean isValid = false;
        for(int i = 0; i < 24; i++){
            ArrayList<Pair<BlockPos, Direction>> seaDirections = new ArrayList<>();
            for (Direction direction : directions) {
                for(int j = displacement; j < (displacement * 4); j+=displacement) {
                    BlockPos bPos = fixedBPos.offset(direction, j);
                    if (worldIn.getBlockState(new BlockPos(bPos.getX(), 62, bPos.getZ())).getFluidState().getFluid() == Fluids.WATER) {
                        seaDirections.add(new Pair<>(new BlockPos(fixedBPos.getX(),fixedBPos.getY(),fixedBPos.getZ()).offset(direction,j - displacement),direction));
                    }
                }
            }

            if(seaDirections.isEmpty()){
                fixedBPos.move(Utilities.rint(-displacementMove,displacementMove,rand), 0, Utilities.rint(-displacementMove,displacementMove,rand));
                fixedBPos.setY(getStructureY(fixedBPos.getX(),fixedBPos.getZ(),worldIn,worldIn.getChunk(fixedBPos),generator,rand));
                continue;
            }

            Pair<BlockPos, Direction> blockPosDirectionPair = seaDirections.get(Utilities.rint(0,seaDirections.size() - 1,rand));
            rot = applyRotation(facing, blockPosDirectionPair.getValue());
            fixedBPos = new BlockPos.Mutable(blockPosDirectionPair.getKey());
            isValid = true;
            break;
        }

        if(!isValid){
            return false;
        }

        placeBlocks(fixedBPos, worldIn, rot, rand);*/

        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for(int x = getMin().getX() - (int)(getMin().getX() / 1.5); x < getMax().getX() + (int)(getMax().getX() / 1.5); x++){
            for(int z = getMin().getZ() - (int)(getMin().getZ() / 1.5); z < getMax().getZ() + (int)(getMax().getZ() / 1.5); z++){
                mutable.setPos(pos.getX() + x,0,pos.getZ() + z);
                mutable.setY(getStructureY(x,z,worldIn,worldIn.getChunk(mutable),generator,rand));

                BlockState downState = worldIn.getBlockState(mutable.down());
                Block block = downState.getBlock();
                if(block == Blocks.WATER){
                    WN.LOGGER.debug("Water at " + mutable);
                    BlockPos.Mutable landPos = new BlockPos.Mutable(mutable.down());
                    for (Direction direction : directions) {
                        BlockState landState = worldIn.getBlockState(landPos.offset(direction,displacementMove));
                        if(landState.isSolid()){
                            WN.LOGGER.debug("Found at " + landPos.offset(direction,displacement));
                            mutable.setPos(landPos.offset(direction,displacement));
                            mutable.setY(getStructureY(x,z,worldIn,worldIn.getChunk(mutable),generator,rand));
                            rot = applyRotation(facing,direction);
                            break;
                        }
                    }
                    if(rot != null){
                        break;
                    }
                }

            }
        }

        if(rot == null){
            return false;
        }

        mutable.setY(62);

        WN.LOGGER.debug("Placing blocks at " + mutable);
        placeBlocks(mutable,worldIn,rot,rand);
        return true;
    }

    @Override
    protected BlockState airState(IWorld world, BlockPos pos) {
        return pos.getY() >= world.getSeaLevel() ? Blocks.AIR.getDefaultState() : Blocks.WATER.getDefaultState();
    }
}
