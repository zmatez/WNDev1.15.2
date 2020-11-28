package com.matez.wildnature.common.blocks;

import com.matez.wildnature.common.damage.WNDamageSource;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.block.WebBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class QuicksandBlock extends SandBase{
    public QuicksandBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties.doesNotBlockMovement(), builder, regName);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn){
        if(entityIn.getHeight() + entityIn.getPosition().getY() < pos.getY() + 1){
            if(Utilities.rint(0,8)==0){
                entityIn.attackEntityFrom(WNDamageSource.QUICKSAND, (float) (0.5F));
            }
        }
        entityIn.setMotionMultiplier(state, new Vec3d(0.25D, (double)0.05F, 0.25D));
    }


}
