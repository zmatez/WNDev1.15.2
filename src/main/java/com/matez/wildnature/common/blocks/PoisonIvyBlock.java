package com.matez.wildnature.common.blocks;

import com.matez.wildnature.common.damage.WNDamageSource;
import com.matez.wildnature.common.effect.WNEffects;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.other.Utilities;
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

public class PoisonIvyBlock extends FloweringBushBase {
    public PoisonIvyBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties.hardnessAndResistance(0.4f,0), builder, regName);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(Utilities.canPlantHurt(entityIn)) {
            if (state.getBlock() instanceof FloweringBushBase && entityIn instanceof LivingEntity && state.get(FLOWERING) && CommonConfig.poisonIvyHurts.get()) {
                if (CommonConfig.poisonIvyPoisons.get()) {
                    ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(WNEffects.IVY_POISON, Utilities.rint(30, 90), 1, true, false));
                }
                if (Utilities.rint(0, 15) == 0) {
                    ((LivingEntity) entityIn).attackEntityFrom(WNDamageSource.POISON_IVY, (float) (0.0F + CommonConfig.poisonIvyDamage.get()));
                }
            }
        }else{
            ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.WEAKNESS, Utilities.rint(100, 250), 1, true, false));
            ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, Utilities.rint(100, 250), 1, true, false));
        }
        entityIn.setMotionMultiplier(state, new Vec3d(0.96D, (double) 0.99F, 0.96D));
    }
}
