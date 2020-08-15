package com.matez.wildnature.entity.AI;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.type.animal.duck.AbstractDuckEntity;
import com.matez.wildnature.other.Utilities;
import net.minecraft.entity.ai.goal.Goal;

import java.util.ArrayList;

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
        Main.LOGGER.info("Group: " + duck.getGroup().size() + duck.getGroup());
        boolean success = this.duck.getNavigator().tryMoveToEntityLiving(duck.getLeader(),speed);
        Main.LOGGER.debug("success");
    }

    @Override
    public void tick() {
        if(Utilities.rint(0,5)==0 && !(Utilities.getDistance(duck.getPosition(),duck.getLeader().getPosition())>maxDistance/4)){
            this.duck.getNavigator().setPath(null,0);
        }
    }
}
