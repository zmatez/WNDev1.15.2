package com.matez.wildnature.entity.type.animal.bird;

import com.matez.wildnature.entity.type.animal.bird.core.AbstractBirdEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public class SparrowEntity extends AbstractBirdEntity {

    public SparrowEntity(EntityType<? extends AnimalEntity> animal, World world) {
        super(animal, world);
    }

    public SparrowEntity(World world) {
        super(world);
    }
}
