package com.matez.wildnature.common.entity.type.animal.duck;

import com.matez.wildnature.common.entity.EntityRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class DuckEntity extends AbstractDuckEntity {
    public DuckEntity(EntityType<? extends AbstractDuckEntity> type, World worldIn) {
        super(type, worldIn, Gender.FEMALE);
    }

    public DuckEntity(World world){
        super(EntityRegistry.DUCK,world);
    }

    @Override
    public Gender getGender() {
        return gender;
    }
}
