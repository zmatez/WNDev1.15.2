package com.matez.wildnature.entity.type.animal.fish;

import com.matez.wildnature.entity.AI.AttackIfTooNear;
import com.matez.wildnature.entity.EntityRegistry;
import com.matez.wildnature.other.Utilities;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

public class PiranhaEntity extends AbstractGroupFishEntity {
    public Predicate<LivingEntity> predicate = new Predicate<LivingEntity>() {
        @Override
        public boolean test(LivingEntity entity) {
            return !(entity instanceof PiranhaEntity) && entity instanceof AbstractFishEntity ? Utilities.rint(0,10)==0 : true;
        }
    };
    public PiranhaEntity(EntityType<? extends PiranhaEntity> p_i50246_1_, World p_i50246_2_) {
        super(p_i50246_1_, p_i50246_2_);
    }
    public PiranhaEntity(World p_i50246_2_) {
        super(EntityRegistry.PIRANHA, p_i50246_2_);
    }

    public boolean isAngry(){
        return this.getRevengeTarget()!=null || this.getAttackTarget()!=null;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this,2,false));
        this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp(PiranhaEntity.class));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<PlayerEntity>(this, PlayerEntity.class, 10, false, true, predicate));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<CreatureEntity>(this, CreatureEntity.class, 10, false, true, predicate));
        GoalSelector var10000 = this.goalSelector;
        Predicate var10009 = EntityPredicates.NOT_SPECTATING;
        var10009.getClass();
        var10000.addGoal(5, new AvoidEntityGoal(this, PlayerEntity.class, 8.0F, 1.6D, 1.4D, var10009::test));
        this.goalSelector.addGoal(6, new SwimGoal(this));
        this.goalSelector.addGoal(7, new FollowSchoolLeaderGoal(this));

    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);

    }

    public int getMaxGroupSize() {
        return 8;
    }

    @Override
    public void tick() {
        super.tick();
        if(isAngry()){
            List<AbstractFishEntity> group = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(8.0D, 8.0D, 8.0D));
            for (AbstractFishEntity abstractFishEntity : group) {
                LivingEntity target = null;
                if(this.getAttackTarget()!=null){
                    target=this.getAttackTarget();
                }else{
                    target=this.getRevengeTarget();
                }
                abstractFishEntity.setAttackTarget(target);
            }
        }
        if(isInWater() && !eyesInWater){
            this.setMotion(this.getMotion().getX(),-0.05,this.getMotion().getZ());
        }
    }

    protected ItemStack getFishBucket() {
        return new ItemStack(Items.SALMON_BUCKET);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SALMON_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SALMON_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.ENTITY_SALMON_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_SALMON_FLOP;
    }

    static class PiranhaAttackGoal extends AttackIfTooNear{

        public PiranhaAttackGoal(LivingEntity entity, Class<? extends LivingEntity> target, double distance) {
            super(entity, target, distance);
            predicate = (new EntityPredicate()).setDistance(distance).setCustomPredicate(new Predicate<LivingEntity>() {
                @Override
                public boolean test(LivingEntity entity) {
                    return !(entity instanceof PiranhaEntity);
                }
            });
        }

        @Override
        public boolean shouldExecute() {
            return Utilities.rint(0,10)==0 && super.shouldExecute();
        }
    }

    static class SwimGoal extends RandomSwimmingGoal {
        private final AbstractFishEntity fish;

        public SwimGoal(AbstractFishEntity p_i48856_1_) {
            super(p_i48856_1_, 1.0D, 40);
            this.fish = p_i48856_1_;
        }

        public boolean shouldExecute() {
            if(this.fish instanceof AbstractGroupFishEntity){
                return !((AbstractGroupFishEntity)this.fish).hasGroupLeader()&& super.shouldExecute();
            }
            return super.shouldExecute();
        }
    }
}
