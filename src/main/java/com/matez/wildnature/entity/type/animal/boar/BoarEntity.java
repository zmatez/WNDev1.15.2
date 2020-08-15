package com.matez.wildnature.entity.type.animal.boar;

import javax.annotation.Nullable;

import com.matez.wildnature.entity.AI.AttackIfTooNear;
import com.matez.wildnature.entity.AI.BreakBlocksGoal;
import com.matez.wildnature.entity.EntityRegistry;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.sounds.SoundRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class BoarEntity extends AnimalEntity {
    private static final Ingredient TEMPTATION_ITEMS;
    private boolean boosting;
    private int boostTime;
    private int totalBoostTime;
    public Predicate<LivingEntity> predicate = new Predicate<LivingEntity>() {
        @Override
        public boolean test(LivingEntity entity) {
            return true;
        }
    };

    public BoarEntity(EntityType<? extends BoarEntity> boar, World world) {
        super(boar, world);
    }

    public BoarEntity(World worldIn) {
        super(EntityRegistry.BOAR, worldIn);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.targetSelector.addGoal(1, new BoarEntity.HurtByAggressorGoal(this).setCallsForHelp(BoarEntity.class));
        this.targetSelector.addGoal(2, new BoarEntity.TargetAggressorGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this,1.3,false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<PlayerEntity>(this, PlayerEntity.class, 10, false, true, predicate));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<VillagerEntity>(this, VillagerEntity.class, 10, false, true, predicate));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<PillagerEntity>(this, PillagerEntity.class, 10, false, true, predicate));
        this.goalSelector.addGoal(4, new BoarAvoidGoal(this,PlayerEntity.class,25f,1f,1.5F));
        this.goalSelector.addGoal(5, new BoarAvoidGoal(this, VillagerEntity.class,25f,1f,1.5F));
        this.goalSelector.addGoal(6, new BoarAvoidGoal(this, PillagerEntity.class,25f,1f,1.5F));
        this.goalSelector.addGoal(8, new BreakBlocksGoal(this,0.9f,8, Blocks.WHEAT,Blocks.CARROTS,Blocks.POTATOES,Blocks.BEETROOTS));
        this.goalSelector.addGoal(9, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(10, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(11, new TemptGoal(this, 1.2D, Ingredient.fromItems(new IItemProvider[]{Items.CARROT_ON_A_STICK}), false));
        this.goalSelector.addGoal(12, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
        this.goalSelector.addGoal(13, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(14, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(15, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(16, new LookRandomlyGoal(this));
    }

    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(26.0D);
    }

    @Nullable
    public Entity getControllingPassenger() {
        return this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
    }


    public boolean canBeSteered() {
        Entity lvt_1_1_ = this.getControllingPassenger();
        if (!(lvt_1_1_ instanceof PlayerEntity)) {
            return false;
        } else {
            PlayerEntity lvt_2_1_ = (PlayerEntity)lvt_1_1_;
            return lvt_2_1_.getHeldItemMainhand().getItem() == Items.CARROT_ON_A_STICK || lvt_2_1_.getHeldItemOffhand().getItem() == Items.CARROT_ON_A_STICK;
        }
    }

    protected SoundEvent getAmbientSound() {
        if(Utilities.rint(0,1)==0){
            return SoundRegistry.BOAR_OINK;
        }else{
            return SoundRegistry.BOAR_SNORT;
        }
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundRegistry.BOAR_SCARED;
    }

    protected SoundEvent getDeathSound() {
        return SoundRegistry.BOAR_DEATH;
    }

    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
    }

    public boolean processInteract(PlayerEntity p_184645_1_, Hand p_184645_2_) {
        if (!super.processInteract(p_184645_1_, p_184645_2_)) {
            ItemStack lvt_3_1_ = p_184645_1_.getHeldItem(p_184645_2_);
            if (lvt_3_1_.getItem() == Items.NAME_TAG) {
                lvt_3_1_.interactWithEntity(p_184645_1_, this, p_184645_2_);
                return true;
            }else {
                return false;
            }
        } else {
            return true;
        }
    }


    public void onStruckByLightning(LightningBoltEntity p_70077_1_) {
        ZombiePigmanEntity lvt_2_1_ = (ZombiePigmanEntity)EntityType.ZOMBIE_PIGMAN.create(this.world);
        lvt_2_1_.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
        lvt_2_1_.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
        lvt_2_1_.setNoAI(this.isAIDisabled());
        if (this.hasCustomName()) {
            lvt_2_1_.setCustomName(this.getCustomName());
            lvt_2_1_.setCustomNameVisible(this.isCustomNameVisible());
        }

        this.world.addEntity(lvt_2_1_);
        this.remove();
    }

    public void travel(Vec3d p_213352_1_) {
        if (this.isAlive()) {
            Entity lvt_2_1_ = this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
            if (this.isBeingRidden() && this.canBeSteered()) {
                this.rotationYaw = lvt_2_1_.rotationYaw;
                this.prevRotationYaw = this.rotationYaw;
                this.rotationPitch = lvt_2_1_.rotationPitch * 0.5F;
                this.setRotation(this.rotationYaw, this.rotationPitch);
                this.renderYawOffset = this.rotationYaw;
                this.rotationYawHead = this.rotationYaw;
                this.stepHeight = 1.0F;
                this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
                if (this.boosting && this.boostTime++ > this.totalBoostTime) {
                    this.boosting = false;
                }

                if (this.canPassengerSteer()) {
                    float lvt_3_1_ = (float)this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue() * 0.225F;
                    if (this.boosting) {
                        lvt_3_1_ += lvt_3_1_ * 1.15F * MathHelper.sin((float)this.boostTime / (float)this.totalBoostTime * 3.1415927F);
                    }

                    this.setAIMoveSpeed(lvt_3_1_);
                    super.travel(new Vec3d(0.0D, 0.0D, 1.0D));
                } else {
                    this.setMotion(Vec3d.ZERO);
                }

                this.prevLimbSwingAmount = this.limbSwingAmount;
                double lvt_3_2_ = this.getPosX() - this.prevPosX;
                double lvt_5_1_ = this.getPosZ() - this.prevPosZ;
                float lvt_7_1_ = MathHelper.sqrt(lvt_3_2_ * lvt_3_2_ + lvt_5_1_ * lvt_5_1_) * 4.0F;
                if (lvt_7_1_ > 1.0F) {
                    lvt_7_1_ = 1.0F;
                }

                this.limbSwingAmount += (lvt_7_1_ - this.limbSwingAmount) * 0.4F;
                this.limbSwing += this.limbSwingAmount;
            } else {
                this.stepHeight = 0.5F;
                this.jumpMovementFactor = 0.02F;
                super.travel(p_213352_1_);
            }
        }
    }


    public BoarEntity createChild(AgeableEntity p_90011_1_) {
        return (BoarEntity)EntityRegistry.BOAR.create(this.world);
    }

    public boolean isBreedingItem(ItemStack p_70877_1_) {
        return TEMPTATION_ITEMS.test(p_70877_1_);
    }

    static {
        TEMPTATION_ITEMS = Ingredient.fromItems(new IItemProvider[]{Items.CARROT, Items.POTATO, Items.BEETROOT});
    }

    static class TargetAggressorGoal extends NearestAttackableTargetGoal<PlayerEntity> {
        public TargetAggressorGoal(BoarEntity p_i45829_1_) {
            super(p_i45829_1_, PlayerEntity.class, true);
        }

        public boolean shouldExecute() {
            return ((BoarEntity)this.goalOwner).getAttackTarget()!=null && super.shouldExecute();
        }
    }

    static class HurtByAggressorGoal extends HurtByTargetGoal {
        public HurtByAggressorGoal(BoarEntity p_i45828_1_) {
            super(p_i45828_1_, new Class[0]);
            this.setCallsForHelp(new Class[]{ZombieEntity.class});
        }

        protected void setAttackTarget(MobEntity p_220793_1_, LivingEntity p_220793_2_) {
            if (p_220793_1_ instanceof BoarEntity && this.goalOwner.canEntityBeSeen(p_220793_2_)) {
                p_220793_1_.setRevengeTarget(p_220793_2_);
                p_220793_1_.setAttackTarget(p_220793_2_);
            }

        }
    }

    static class BoarAvoidGoal extends AvoidEntityGoal{

        public BoarAvoidGoal(CreatureEntity p_i46404_1_, Class p_i46404_2_, float p_i46404_3_, double p_i46404_4_, double p_i46404_6_) {
            super(p_i46404_1_, p_i46404_2_, p_i46404_3_, p_i46404_4_, p_i46404_6_);
        }

        public BoarAvoidGoal(CreatureEntity p_i48859_1_, Class p_i48859_2_, Predicate p_i48859_3_, float p_i48859_4_, double p_i48859_5_, double p_i48859_7_, Predicate p_i48859_9_) {
            super(p_i48859_1_, p_i48859_2_, p_i48859_3_, p_i48859_4_, p_i48859_5_, p_i48859_7_, p_i48859_9_);
        }

        public BoarAvoidGoal(CreatureEntity p_i48860_1_, Class p_i48860_2_, float p_i48860_3_, double p_i48860_4_, double p_i48860_6_, Predicate p_i48860_8_) {
            super(p_i48860_1_, p_i48860_2_, p_i48860_3_, p_i48860_4_, p_i48860_6_, p_i48860_8_);
        }

        @Override
        public boolean shouldExecute() {
            return entity.getAttackTarget()==null && entity.getRevengeTarget()==null && super.shouldExecute();
        }
    }
}
