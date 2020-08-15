package com.matez.wildnature.entity.type.animal.duck;

import com.matez.wildnature.entity.EntityRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class DucklingEntity extends AbstractDuckEntity {
    public DucklingEntity(EntityType<? extends AbstractDuckEntity> type, World worldIn) {
        super(type, worldIn, Gender.CHILD);
    }

    public DucklingEntity(World world){
        super(EntityRegistry.DUCKLING,world);
    }

    @Override
    public Gender getGender() {
        return gender;
    }
}
