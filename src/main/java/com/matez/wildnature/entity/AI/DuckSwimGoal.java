package com.matez.wildnature.entity.AI;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.tags.FluidTags;

public class DuckSwimGoal extends SwimGoal {
    private final MobEntity entity;
    public DuckSwimGoal(MobEntity entityIn) {
        super(entityIn);
        this.entity=entityIn;
    }

    public boolean shouldExecute() {
        return entity.areEyesInFluid(FluidTags.WATER);
    }
}
