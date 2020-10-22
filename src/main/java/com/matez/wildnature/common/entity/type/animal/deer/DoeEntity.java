package com.matez.wildnature.common.entity.type.animal.deer;

import com.matez.wildnature.common.entity.EntityRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class DoeEntity extends AbstractDeerEntity {
    public DoeEntity(EntityType<? extends AbstractDeerEntity> type, World worldIn) {
        super(type, worldIn, Gender.FEMALE);
    }

    public DoeEntity(World world){
        super(EntityRegistry.DOE,world);
    }

    @Override
    public Gender getGender() {
        return gender;
    }
}
