package com.matez.wildnature.common.entity.type.animal.deer;

import com.matez.wildnature.common.entity.EntityRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class FawnEntity extends AbstractDeerEntity {
    public FawnEntity(EntityType<? extends AbstractDeerEntity> type, World worldIn) {
        super(type, worldIn, Gender.CHILD);
    }

    public FawnEntity(World world){
        super(EntityRegistry.FAWN,world);
    }

    @Override
    public Gender getGender() {
        return gender;
    }
}
