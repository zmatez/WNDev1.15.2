package com.matez.wildnature.common.entity.AI;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.common.entity.type.animal.duck.AbstractDuckEntity;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.entity.ai.goal.Goal;

public class StayInGroup extends Goal {
    private AbstractDuckEntity duck;
    private double maxDistance;
    private double speed;
    public StayInGroup(AbstractDuckEntity duck, double maxDistance, double speed){
        this.duck=duck;
        this.maxDistance=maxDistance;
        this.speed=speed;
    }

    @Override
    public boolean shouldExecute() {
        if(duck.getLeader()==duck){
            return false;
        }

        if(duck.getGroup().isEmpty() || duck.getGroup().size()==1){
            return false;
        }

        return Utilities.getDistance(duck.getPosition(),duck.getLeader().getPosition())>maxDistance;
    }

    @Override
    public void startExecuting() {
        WN.LOGGER.info("Group: " + duck.getGroup().size() + duck.getGroup());
        boolean success = this.duck.getNavigator().tryMoveToEntityLiving(duck.getLeader(),speed);
        WN.LOGGER.debug("success");
    }

    @Override
    public void tick() {
        if(Utilities.rint(0,5)==0 && !(Utilities.getDistance(duck.getPosition(),duck.getLeader().getPosition())>maxDistance/4)){
            this.duck.getNavigator().setPath(null,0);
        }
    }
}
