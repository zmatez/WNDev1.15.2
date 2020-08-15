package com.matez.wildnature.entity.AI;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.type.animal.IFamily;
import com.matez.wildnature.entity.type.animal.duck.AbstractDuckEntity;
import com.matez.wildnature.other.Utilities;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;
import java.util.List;

public class CreateGroupGoal extends Goal {
    public static ArrayList<AbstractDuckEntity> runningInstances = new ArrayList<>();
    private AbstractDuckEntity duck;
    private double maxGroupingDistance =10;
    public CreateGroupGoal(AbstractDuckEntity duck){
        this.duck=duck;
    }
    @Override
    public boolean shouldExecute() {
        /*ArrayList<AbstractDuckEntity> newGroup = duck.getGroup();
        for (AbstractDuckEntity abstractDuckEntity : duck.getGroup()) {
            if(!abstractDuckEntity.isAlive() || abstractDuckEntity==null){
            }
        }*/
        return duck.getGroup().size()<=4;
    }

    @Override
    public void startExecuting() {
        boolean runningNearby = false;
        for (AbstractDuckEntity runningInstance : runningInstances) {
            double dist = Utilities.getDistance(runningInstance.getPosition(),duck.getPosition());
            if(dist<maxGroupingDistance){
                runningNearby=true;
                break;
            }
        }
        if(!runningNearby) {
            runningInstances.add(duck);
            ArrayList<AbstractDuckEntity> group = duck.getGroup();
            if(!group.contains(duck)) {
                group.add(duck);
            }
            AbstractDuckEntity nearestLeader = getNearestLeader(duck.getPosition());
            if(nearestLeader!=null && nearestLeader.isAlive()) {
                double distance = Utilities.getDistance(nearestLeader.getPosition(), duck.getPosition());
                if (distance <= maxGroupingDistance) {
                    group = nearestLeader.getGroup();
                }
            }

            Main.LOGGER.debug("Current group: " + group.size() + " : " + group);

            ArrayList<AbstractDuckEntity> entities = new ArrayList<>(duck.getEntityWorld().getEntitiesWithinAABB(AbstractDuckEntity.class, this.duck.getBoundingBox().grow(8.0D, 4.0D, 8.0D)));
            for (AbstractDuckEntity entity : entities) {
                double dist = Utilities.getDistance(entity.getPosition(),duck.getPosition());
                if(dist<maxGroupingDistance && !group.contains(entity) && (entity.getGroup().isEmpty() || entity.getGroup().size()==1)){
                    group.add(entity);
                    Main.LOGGER.info("Added to group("+group.size()+") " + entity.getPosition());

                }
            }

            boolean hasGroupLeader = false;
            AbstractDuckEntity leader = null;

            for (AbstractDuckEntity abstractDuckEntity : group) {
                if(abstractDuckEntity.isGroupLeader()){
                    hasGroupLeader=true;
                    leader = abstractDuckEntity;
                    break;
                }
            }
            if(!hasGroupLeader){
                AbstractDuckEntity e = null;
                for (AbstractDuckEntity abstractDuckEntity : group) {
                    if(abstractDuckEntity.getGender()== IFamily.Gender.MALE){
                        e = abstractDuckEntity;
                    }else if(group.indexOf(abstractDuckEntity)==group.size()-1){
                        e = abstractDuckEntity;
                    }
                }
                assert e != null;
                int index = group.indexOf(e);
                Main.LOGGER.info("New group leader is on " + e.getPosition());
                e.setGroupLeader(true);
                group.set(index,e);
                leader=e;

            }
            leader.setGroup(group);



            for (AbstractDuckEntity abstractDuckEntity : group) {
                abstractDuckEntity.setLeader(leader);
            }
            leader.setCustomName(new StringTextComponent(TextFormatting.GREEN+"Leader " + leader.getGroup().size()));
            Main.LOGGER.debug("After group: " + group.size() + " : " + duck.getGroup());

            runningInstances.remove(duck);
        }
    }

    public AbstractDuckEntity getNearestLeader(BlockPos pos){
        ArrayList<AbstractDuckEntity> entities = new ArrayList<>(duck.getEntityWorld().getEntitiesWithinAABB(AbstractDuckEntity.class, this.duck.getBoundingBox().grow(8.0D, 4.0D, 8.0D)));
        ArrayList<AbstractDuckEntity> leaders = new ArrayList<>();
        AbstractDuckEntity nearestLeader = null;
        double nearest = 0;
        for (AbstractDuckEntity entity : entities) {
            if(entity.isGroupLeader()){
                leaders.add(entity);
            }
        }

        for (AbstractDuckEntity leader : leaders) {
            if(nearestLeader==null){
                nearestLeader=leader;
                nearest= Utilities.blockDistance(pos,leader.getPosition());
            }else{
                int dist = Utilities.blockDistance(pos,leader.getPosition());
                if(dist<nearest){
                    nearestLeader=leader;
                    nearest=dist;
                }
            }
        }
        entities.clear();
        leaders.clear();
        return nearestLeader;
    }

    public AbstractDuckEntity getLeader(){
        if(duck.isGroupLeader){
            return duck;
        }
        for (AbstractDuckEntity abstractDuckEntity : duck.getGroup()) {
            if(abstractDuckEntity.isGroupLeader()){
                return abstractDuckEntity;
            }
        }
        return null;
    }
}
