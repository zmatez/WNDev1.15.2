package com.matez.wildnature.common.entity.type.misc.blowpipe.darts;

import com.matez.wildnature.common.entity.EntityRegistry;
import com.matez.wildnature.common.entity.type.misc.blowpipe.AbstractBlowdartEntity;
import com.matez.wildnature.common.entity.type.misc.blowpipe.BlowdartEntity;
import com.matez.wildnature.init.WN;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

public class RowanBlowdartEntity extends BlowdartEntity {
    public RowanBlowdartEntity(EntityType<? extends AbstractBlowdartEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public RowanBlowdartEntity(EntityType<? extends AbstractBlowdartEntity> type, double x, double y, double z, World worldIn) {
        super(type, x, y, z, worldIn);
    }

    public RowanBlowdartEntity(EntityType<? extends AbstractBlowdartEntity> type, LivingEntity shooter, World worldIn) {
        super(type, shooter, worldIn);
    }

    public RowanBlowdartEntity(World worldIn) {
        super(EntityRegistry.ROWAN_BLOWDART, worldIn);
    }

    public RowanBlowdartEntity(double x, double y, double z, World worldIn) {
        super(EntityRegistry.ROWAN_BLOWDART, x, y, z, worldIn);
    }

    public RowanBlowdartEntity(LivingEntity shooter, World worldIn) {
        super(EntityRegistry.ROWAN_BLOWDART, shooter, worldIn);
    }

    public RowanBlowdartEntity(World worldIn, double x, double y, double z) {
        super(EntityRegistry.ROWAN_BLOWDART, x, y, z, worldIn);
    }

    public RowanBlowdartEntity(World worldIn, LivingEntity shooter) {
        super(EntityRegistry.ROWAN_BLOWDART, shooter, worldIn);
    }

    @Override
    protected void onHit(RayTraceResult raytraceResultIn) {
        RayTraceResult.Type raytraceresult$type = raytraceResultIn.getType();
        if (raytraceresult$type == RayTraceResult.Type.ENTITY) {
            this.onEntityHit((EntityRayTraceResult)raytraceResultIn);
        } else if (raytraceresult$type == RayTraceResult.Type.BLOCK) {
            WN.LOGGER.debug("Hit");
            BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)raytraceResultIn;
            BlockState blockstate = this.world.getBlockState(blockraytraceresult.getPos());
            this.inBlockState = blockstate;
            Vec3d vec3d = blockraytraceresult.getHitVec().subtract(this.getPosX(), this.getPosY(), this.getPosZ());
            this.setMotion(vec3d);
            Vec3d vec3d1 = vec3d.normalize().scale((double)0.05F);
            this.setRawPosition(this.getPosX() - vec3d1.x, this.getPosY() - vec3d1.y, this.getPosZ() - vec3d1.z);
            Direction nearestDirection = null;
            double nearestDistance = -1;
            for (Direction value : Direction.values()) {
                BlockPos dir = this.getPosition().offset(value);
                double distance = this.getPositionVec().distanceTo(new Vec3d(dir.getX() + 0.5f, dir.getY() + 0.5f, dir.getZ() + 0.5f));
                if(nearestDirection == null || nearestDistance < distance){
                    nearestDirection = value;
                    nearestDistance = distance;
                }
            }

            if(nearestDirection != null) {
                WN.LOGGER.debug("RotB " + this.getYaw(1) + " : " + this.getPitch(1));
                WN.LOGGER.debug("RotBx " + this.getYaw(0) + " : " + this.getPitch(0));
                float pitch = nearestDirection == Direction.UP ? -90 : (nearestDirection == Direction.DOWN ? 90 : 0);
                float yaw = nearestDirection.getHorizontalAngle();
                this.rotationYaw = yaw % 360.0F;
                this.rotationPitch = MathHelper.clamp(pitch, -90.0F, 90.0F) % 360.0F;
                this.prevRotationYaw = this.rotationYaw;
                this.prevRotationPitch = this.rotationPitch;
                WN.LOGGER.debug("RotA " + this.getYaw(1) + " : " + this.getPitch(1));
                WN.LOGGER.debug("RotAx " + this.getYaw(0) + " : " + this.getPitch(0));
            }


            this.playSound(this.getHitGroundSound(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
            this.inGround = true;
            this.arrowShake = 0;
            this.setIsCritical(false);
            this.setPierceLevel((byte)0);
            this.setHitSound(SoundEvents.ENTITY_ARROW_HIT);
            this.setShotFromCrossbow(false);
            this.clearEntities();
            blockstate.onProjectileCollision(this.world, blockstate, blockraytraceresult, this);
        }

    }
}
