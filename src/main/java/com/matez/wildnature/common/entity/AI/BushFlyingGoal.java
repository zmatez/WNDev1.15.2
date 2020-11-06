package com.matez.wildnature.common.entity.AI;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.block.BushBlock;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;

import javax.annotation.Nullable;
import java.util.Random;

public class BushFlyingGoal extends MoveToBlockGoal {

    private int transportChance;
    private Random rand = new Random();
    private int maxDistance = 0;
    public BushFlyingGoal(CreatureEntity entity, double speed, int maxDistanceToBush, int minDistanceToBush, int transportChance){
        super(entity,speed,maxDistanceToBush,minDistanceToBush);
        this.transportChance=transportChance;
        this.maxDistance=maxDistanceToBush;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void tick() {
        if(destinationBlock==null || destinationBlock==BlockPos.ZERO) {
            WN.LOGGER.debug("Ticking: " + destinationBlock);
            BlockPos target = findTarget(this.creature.getPosition(), this.creature.getEntityWorld());
            if (target != null) {
                destinationBlock = target;
                super.tick();
            }
        }else{
            super.tick();
            if(getIsAboveDestination()){
                WN.LOGGER.debug("Reseting");
                if(Utilities.rint(0,transportChance)==0){
                    destinationBlock=BlockPos.ZERO;
                }
            }
        }

        if(destinationBlock!=null && destinationBlock!=BlockPos.ZERO && Utilities.getDistance(creature.getPosition(),destinationBlock)>maxDistance){
            WN.LOGGER.debug("Reseting too big");
            destinationBlock=BlockPos.ZERO;

        }
    }



    @Nullable
    private BlockPos findTarget(BlockPos blockpos, IBlockReader world) {
        for(int j = 0; j < 128; ++j) {
            BlockPos b = blockpos.add(rand.nextInt(maxDistance) - rand.nextInt(maxDistance), rand.nextInt(maxDistance) - rand.nextInt(maxDistance), rand.nextInt(maxDistance) - rand.nextInt(maxDistance));
            if ((world.getBlockState(b).getBlock()) instanceof BushBlock) {
                if(Utilities.getDistance(blockpos,b)<maxDistance-3) {
                    return b;
                }
            }
        }

        return null;
    }



    public boolean shouldExecute() {
        if (this.runDelay > 0) {
            --this.runDelay;
            return false;
        } else {
            this.runDelay = this.getRunDelay(this.creature);
            return Utilities.rint(0,transportChance)==0 || (this.destinationBlock!=null && !getIsAboveDestination());
        }
    }

    protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
        IChunk ichunk = worldIn.getChunk(pos.getX() >> 4, pos.getZ() >> 4, ChunkStatus.FULL, false);
        if (ichunk == null) {
            return false;
        } else {
            return ichunk.getBlockState(pos).getBlock() instanceof BushBlock;
        }
    }
}
