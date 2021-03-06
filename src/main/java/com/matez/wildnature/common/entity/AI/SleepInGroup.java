package com.matez.wildnature.common.entity.AI;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.entity.type.animal.duck.AbstractDuckEntity;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.entity.ai.goal.Goal;

public class SleepInGroup extends Goal {
    private AbstractDuckEntity duck;
    private AbstractDuckEntity leader;
    private double speed = 0.7D;
    private double maxDistanceToLeader = 5;
    public SleepInGroup(AbstractDuckEntity duck){
        this.duck=duck;
    }

    @Override
    public boolean shouldExecute() {
        leader=duck.getLeader();
        if (this.duck.getRevengeTarget() != null || this.duck.isBurning()) {
            duck.setSleeping(false);
            leader.setSleeping(false);
            return false;
        }

        if(duck.isSleeping()){
            if(!duck.getLeader().isSleeping()){
                duck.setSleeping(false);
                return false;
            }
            return true;
        }

        if(leader==duck){
            if(Utilities.rint(0,500)==0){
                return true;
            }
        }else{
            if(duck.getLeader().isSleeping()){
                this.duck.getNavigator().tryMoveToEntityLiving(duck.getLeader(),speed);
                return Utilities.getDistance(duck.getPosition(),leader.getPosition())<=maxDistanceToLeader;
            }else{
                duck.setSleeping(false);
            }
        }
        return false;
    }

    @Override
    public void startExecuting() {
        duck.setSleeping(true);
        WN.LOGGER.debug("Sleeping " + duck);
    }

    @Override
    public void tick() {
        if(leader==duck){
            if(Utilities.rint(0,500)==0){
                duck.setSleeping(false);
            }
        }
    }
}
