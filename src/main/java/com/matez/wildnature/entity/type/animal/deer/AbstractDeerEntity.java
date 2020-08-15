package com.matez.wildnature.entity.type.animal.deer;

import com.matez.wildnature.entity.AI.BreakBlocksGoal;
import com.matez.wildnature.entity.AI.FamilyBreedGoal;
import com.matez.wildnature.entity.AI.FollowMotherGoal;
import com.matez.wildnature.entity.EntityRegistry;
import com.matez.wildnature.entity.type.animal.IFamily;
import com.matez.wildnature.lists.WNItems;
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
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class AbstractDeerEntity extends AnimalEntity implements IFamily {
    private static final Ingredient TEMPTATION_ITEMS;
    public Gender gender = null;
    private int eatingTimer;
    private EatGrassGoal eatGrassGoal;
    public Predicate<LivingEntity> predicate = new Predicate<LivingEntity>() {
        @Override
        public boolean test(LivingEntity entity) {
            return true;
        }
    };

    public AbstractDeerEntity(EntityType<? extends AbstractDeerEntity> deer, World world) {
        super(deer, world);
    }

    public AbstractDeerEntity(EntityType<? extends AbstractDeerEntity> deer, World world,Gender g) {
        super(deer, world);
        this.gender=g;
    }


    public AbstractDeerEntity(World worldIn) {
        super(EntityRegistry.BOAR, worldIn);
    }

    protected void registerGoals() {
        this.eatGrassGoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this,PlayerEntity.class,35f,1f,1.5F));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, VillagerEntity.class,25f,1f,1.5F));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, PillagerEntity.class,25f,1f,1.5F));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, WolfEntity.class,25f,1f,1.5F));
        this.goalSelector.addGoal(5, new BreakBlocksGoal(this,0.9f,8,Blocks.POTATOES,Blocks.BEETROOTS));
        this.goalSelector.addGoal(6, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(7, new FamilyBreedGoal(this, 1.0D,this.getGender()));
        this.goalSelector.addGoal(8, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
        this.goalSelector.addGoal(9, new FollowMotherGoal(this, 1.1D));
        this.goalSelector.addGoal(10, this.eatGrassGoal);
        this.goalSelector.addGoal(11, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(12, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(13, new LookRandomlyGoal(this));
    }


    protected void updateAITasks() {
        this.eatingTimer = this.eatGrassGoal.getEatingGrassTimer();
        super.updateAITasks();
    }

    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
    }

    protected SoundEvent getAmbientSound() {
        if(Utilities.rint(0,2)!=0){
            if(gender==Gender.FEMALE){
                return SoundRegistry.DEER_DOEGRUNT;
            }else if(gender==Gender.MALE){
                return SoundRegistry.DEER_BUCKGRUNT;
            }else{
                return SoundRegistry.DEER_CONTACT;
            }
        }else{
            switch(Utilities.rint(0,2)){
                case 0:
                    return SoundRegistry.DEER_SNORT;
                case 1:
                    return SoundRegistry.DEER_SNORT2;
                case 2:
                    return SoundRegistry.DEER_CONTACT;
            }
        }
        return SoundRegistry.DEER_SNORT;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundRegistry.DEER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundRegistry.DEER_DEATH;
    }

    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
    }

    public AbstractDeerEntity createChild(AgeableEntity p_90011_1_) {
        return null;//(AbstractDeerEntity)EntityRegistry.BOAR.create(this.world);
    }

    public boolean isBreedingItem(ItemStack p_70877_1_) {
        return TEMPTATION_ITEMS.test(p_70877_1_);
    }

    static {
        TEMPTATION_ITEMS = Ingredient.fromItems(new IItemProvider[]{WNItems.BELLADONNA_FRUIT,WNItems.BLUEBERRY, WNItems.BLACKBERRY, WNItems.CRANBERRIES, WNItems.WILD_STRAWBERRY, Items.POTATO, Items.BEETROOT});
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    public void livingTick() {
        if (this.world.isRemote) {
            this.eatingTimer = Math.max(0, this.eatingTimer - 1);
        }

        super.livingTick();
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 10) {
            this.eatingTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationPointY(float p_70894_1_) {
        if (this.eatingTimer <= 0) {
            return 0.0F;
        } else if (this.eatingTimer >= 4 && this.eatingTimer <= 36) {
            return 1.0F;
        } else {
            return this.eatingTimer < 4 ? ((float)this.eatingTimer - p_70894_1_) / 4.0F : -((float)(this.eatingTimer - 40) - p_70894_1_) / 4.0F;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationAngleX(float p_70890_1_) {
        if (this.eatingTimer > 4 && this.eatingTimer <= 36) {
            float f = ((float)(this.eatingTimer - 4) - p_70890_1_) / 32.0F;
            return ((float)Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
        } else {
            return this.eatingTimer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch * ((float)Math.PI / 180F);
        }
    }
}
