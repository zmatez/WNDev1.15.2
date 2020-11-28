package com.matez.wildnature.common.entity.type.misc.blowpipe;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class BlowdartEntity extends AbstractBlowdartEntity{
    protected BlowdartEntity(EntityType<? extends AbstractBlowdartEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected BlowdartEntity(EntityType<? extends AbstractBlowdartEntity> type, double x, double y, double z, World worldIn) {
        super(type, x, y, z, worldIn);
    }

    protected BlowdartEntity(EntityType<? extends AbstractBlowdartEntity> type, LivingEntity shooter, World worldIn) {
        super(type, shooter, worldIn);
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(Items.AIR,1);
    }
}
