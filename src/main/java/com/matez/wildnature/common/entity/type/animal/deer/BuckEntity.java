package com.matez.wildnature.common.entity.type.animal.deer;

import com.matez.wildnature.common.entity.EntityRegistry;
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
