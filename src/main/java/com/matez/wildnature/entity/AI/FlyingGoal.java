package com.matez.wildnature.entity.AI;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BushBlock;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Random;

public class FlyingGoal extends Goal {

    private AnimalEntity entity;
    private int followRange;
    private double speed;
    private int startFlyingChance, endFlyingChance, maxFlyDistance;
    private Random rand = new Random();
    private BlockPos startPos = null, startAirPos = null;
    private boolean lookSet = false;
    public FlyingGoal(AnimalEntity entity, int followRange, double speed, int startFlyingChance, int endFlyingChance, int maxFlyDistance){
        this.entity=entity;
        this.followRange=followRange;
        this.speed=speed;
        this.startFlyingChance=startFlyingChance;
        this.endFlyingChance=endFlyingChance;
        this.maxFlyDistance=maxFlyDistance;
        setMutexFlags(EnumSet.of(Flag.JUMP,Flag.LOOK,Flag.MOVE));
    }

    @Override
    public boolean shouldExecute() {
        if(Utilities.rint(0,startFlyingChance)==0){
            BlockPos airPos = findTarget(entity.getPosition(),entity.getEntityWorld());
            if(airPos!=null){
                boolean isNavigating = entity.getNavigator().tryMoveToXYZ(airPos.getX(),airPos.getY(), airPos.getZ(),Utilities.rdoub(speed-speed/5,speed+speed/5));
                Main.LOGGER.debug("navi: " + isNavigating + "   "+airPos);
                startAirPos=airPos;
                startPos=new BlockPos(entity.getPosition());
                return isNavigating;
            }
        }

        return false;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return Utilities.getDistance(startAirPos,entity.getPosition())<maxFlyDistance && isInAir();
    }

    @Override
    public void tick() {
        Main.LOGGER.debug("tick " + Utilities.getDistance(entity.getPosition(),startAirPos) + " air: " + isInAir());
        if(Utilities.getDistance(entity.getPosition(),startAirPos)<3){
            if(!lookSet){
                double lvt_1_1_ = 6.283185307179586D * rand.nextDouble();
                double lookX = Math.cos(lvt_1_1_);
                double lookZ = Math.sin(lvt_1_1_);
                this.entity.getLookController().setLookPosition(this.entity.getPosition().getX() + lookX, this.entity.getPosition().getY() + (double)this.entity.getEyeHeight(), this.entity.getPosition().getZ() + lookZ);
                lookSet=true;
            }
            if(isInAir()) {
                entity.setMoveForward((float) Utilities.rdoub(speed - speed / 5, speed + speed / 5));
                entity.setMoveVertical((float)Utilities.rdoub(-0.3,0.3));
                Main.LOGGER.debug("Flying");
            }
        }else{
            entity.getNavigator().tryMoveToXYZ(startAirPos.getX(),startAirPos.getY(), startAirPos.getZ(),Utilities.rdoub(speed-speed/5,speed+speed/5));
        }
    }

    @Override
    public void resetTask() {
        Main.LOGGER.debug("reseting");
        lookSet=false;
        BlockPos landPos = land(entity.getPosition(),entity.getEntityWorld());
        if(landPos!=null) {
            entity.getNavigator().tryMoveToXYZ(landPos.getX(), landPos.getY(), landPos.getZ(), Utilities.rdoub(speed - speed / 5, speed + speed / 5));
        }
    }

    public boolean isInAir(){
        IWorld world = entity.getEntityWorld();
        BlockPos pos = entity.getPosition();
        try {
            if (!world.getBlockState(pos.offset(Direction.NORTH)).isAir()) {
                return false;
            }
            if (!world.getBlockState(pos.offset(Direction.SOUTH)).isAir()) {
                return false;
            }
            if (!world.getBlockState(pos.offset(Direction.EAST)).isAir()) {
                return false;
            }
            if (!world.getBlockState(pos.offset(Direction.WEST)).isAir()) {
                return false;
            }

            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Nullable
    private BlockPos findTarget(BlockPos blockpos, IBlockReader world) {
        for(int j = 0; j < 128; ++j) {
            BlockPos b = blockpos.add(rand.nextInt(followRange) - rand.nextInt(followRange), rand.nextInt(followRange) - rand.nextInt(followRange), rand.nextInt(followRange) - rand.nextInt(followRange));
            if(world.getBlockState(b).isAir() && Utilities.getDistance(blockpos,b)<followRange-1) {
                return b;
            }
        }

        return null;
    }

    @Nullable
    private BlockPos land(BlockPos blockpos, IBlockReader world) {
        for(int j = 0; j < 128; ++j) {
            BlockPos b = blockpos.add(rand.nextInt(followRange) - rand.nextInt(followRange), rand.nextInt(followRange) - rand.nextInt(followRange), rand.nextInt(followRange) - rand.nextInt(followRange));
            if(world.getBlockState(b).isAir() && world.getBlockState(b.down()).isSolid()) {
                return b;
            }
        }

        return null;
    }
}
