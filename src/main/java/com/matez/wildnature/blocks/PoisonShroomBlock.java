package com.matez.wildnature.blocks;

import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class PoisonShroomBlock extends CaveShroomBase {
    public PoisonShroomBlock(Properties properties, Item.Properties builder, ResourceLocation regName, boolean reversed) {
        super(properties, builder, regName, reversed);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(state.getBlock() instanceof PoisonShroomBlock && entityIn instanceof LivingEntity && CommonConfig.poisonIvyHurts.get()){
            if(CommonConfig.poisonIvyPoisons.get() && (!(entityIn instanceof PlayerEntity) || !((PlayerEntity) entityIn).isCreative())) {
                ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.BLINDNESS, Utilities.rint(200, 500), 0, true, false));
                ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.GLOWING, Utilities.rint(200, 500), 0, true, false));
                ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.POISON, Utilities.rint(60, 200), 0, true, false));
                worldIn.destroyBlock(pos,false);
            }
        }
    }
}
