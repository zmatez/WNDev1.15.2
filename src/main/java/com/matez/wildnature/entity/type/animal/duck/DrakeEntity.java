package com.matez.wildnature.entity.type.animal.duck;

import com.matez.wildnature.entity.EntityRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class DrakeEntity extends AbstractDuckEntity {
    public DrakeEntity(EntityType<? extends AbstractDuckEntity> type, World worldIn) {
        super(type, worldIn, Gender.MALE);
    }

    public DrakeEntity(World world){
        super(EntityRegistry.DRAKE,world);
    }

    @Override
    public Gender getGender() {
        return gender;
    }
}
