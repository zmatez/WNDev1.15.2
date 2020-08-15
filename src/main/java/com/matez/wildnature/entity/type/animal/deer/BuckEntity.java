package com.matez.wildnature.entity.type.animal.deer;

import com.matez.wildnature.entity.EntityRegistry;
import com.matez.wildnature.entity.type.animal.duck.AbstractDuckEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class BuckEntity extends AbstractDeerEntity {
    public BuckEntity(EntityType<? extends AbstractDeerEntity> type, World worldIn) {
        super(type, worldIn, Gender.MALE);
    }

    public BuckEntity(World world){
        super(EntityRegistry.BUCK,world);
    }

    @Override
    public Gender getGender() {
        return gender;
    }
}
