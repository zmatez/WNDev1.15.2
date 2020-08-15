package com.matez.wildnature.entity.AI;

import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.merchant.villager.VillagerEntity;

public class AttackIfTooNear extends Goal {

    private double distance = 0;
    public LivingEntity entity,nearest;
    private Class<? extends LivingEntity> target;
    public EntityPredicate predicate = (new EntityPredicate()).setDistance(distance);
    public AttackIfTooNear(LivingEntity entity, Class<? extends LivingEntity> target, double distance){
        this.entity=entity;
        this.target=target;
        this.distance=distance;
    }
    @Override
    public boolean shouldExecute() {

        nearest = this.entity.world.getClosestEntityWithinAABB(entity.getClass(), predicate, this.entity, this.entity.getPosition().getX(), this.entity.getPosition().getY(), this.entity.getPosition().getZ(), this.entity.getBoundingBox().grow(6.0D, 2.0D, 6.0D));
        return nearest!=null;
    }

    @Override
    public void startExecuting() {
        entity.setRevengeTarget(nearest);
        if(entity instanceof MobEntity){
            ((MobEntity)entity).setAttackTarget(nearest);
        }
    }
}
