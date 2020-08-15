package com.matez.wildnature.blocks;

import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MonkshoodBlueBlock extends DoubleBushBaseFlowering {
    public MonkshoodBlueBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(state.getBlock() instanceof MonkshoodBlueBlock && entityIn instanceof LivingEntity && state.get(FLOWERING) && CommonConfig.poisonIvyHurts.get()){
            if(CommonConfig.poisonIvyPoisons.get()) {
                ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.WITHER, Utilities.rint(100, 250), 1, true, false));
            }
            if(Utilities.rint(0,15)==0){
                ((LivingEntity)entityIn).attackEntityFrom(DamageSource.SWEET_BERRY_BUSH,(float)(0.0F+CommonConfig.poisonIvyDamage.get()));
            }
        }
        entityIn.setMotionMultiplier(state, new Vec3d(0.96D, (double) 0.99F, 0.96D));
        super.onEntityCollision(state, worldIn, pos, entityIn);
    }

}
