package com.matez.wildnature.entity.type.animal.insect;

import com.matez.wildnature.entity.AI.BreakBlocksGoal;
import com.matez.wildnature.entity.AI.BushFlyingGoal;
import com.matez.wildnature.entity.AI.Movement.InsectFlyingMovementController;
import com.matez.wildnature.entity.AI.RandomFlyingGoal;
import com.matez.wildnature.entity.EntityRegistry;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.sounds.SoundRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.tags.Tag;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class DragonflyEntity extends AnimalEntity implements IFlyingAnimal {
    public Predicate<LivingEntity> predicate = new Predicate<LivingEntity>() {
        @Override
        public boolean test(LivingEntity entity) {
            return true;
        }
    };

    private boolean canMove = true;
    private DragonFlyVariant variant = null;
    public float flap;
    public float flapSpeed;
    public float oFlapSpeed;
    public float oFlap;
    public float flapping = 1.0F;

    public DragonflyEntity(EntityType<? extends DragonflyEntity> boar, World world) {
        super(boar, world);
        this.moveController = new InsectFlyingMovementController(this, 20, true);
        //this.lookController = new BeeEntity.BeeLookController(this);
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        //this.setPathPriority(PathNodeType.COCOA, -1.0F);
        this.setPathPriority(PathNodeType.FENCE, -1.0F);
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        randomVariant();
        return super.onInitialSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
    }

    public DragonFlyVariant getVariant() {
        return variant;
    }

    public DragonflyEntity(World worldIn) {
        super(EntityRegistry.DRAGONFLY, worldIn);
        this.moveController = new InsectFlyingMovementController(this, 20, true);
        //this.lookController = new BeeEntity.BeeLookController(this);
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        //this.setPathPriority(PathNodeType.COCOA, -1.0F);
        this.setPathPriority(PathNodeType.FENCE, -1.0F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BushFlyingGoal(this,2.4,26,1,10));
        //this.goalSelector.addGoal(1, new BreakBlocksGoal(this,2.4f,20, WNBlocks.RIVER_CANE));

        //this.goalSelector.addGoal(2,new RandomFlyingGoal(this,1.1));
    }

    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(1.4F);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(26.0D);
    }

    public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
        return worldIn.getBlockState(pos).isAir() ? 10.0F : 0.0F;
    }

    protected PathNavigator createNavigator(World worldIn) {
        FlyingPathNavigator flyingpathnavigator = new FlyingPathNavigator(this, worldIn) {
            public boolean canEntityStandOnPos(BlockPos pos) {
                return !this.world.getBlockState(pos.down()).isAir();
            }

            public void tick() {
                if (canMove) {
                    super.tick();
                }
            }
        };
        flyingpathnavigator.setCanOpenDoors(false);
        flyingpathnavigator.setCanSwim(false);
        flyingpathnavigator.setCanEnterDoors(true);
        return flyingpathnavigator;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.isChild() ? sizeIn.height * 0.5F : sizeIn.height * 0.5F;
    }

    private void calculateFlapping() {
        this.oFlap = this.flap;
        this.oFlapSpeed = this.flapSpeed;
        this.flapSpeed = (float)((double)this.flapSpeed + (double)(!this.onGround && !this.isPassenger() ? 4 : -1) * 0.3D);
        this.flapSpeed = MathHelper.clamp(this.flapSpeed, 0.0F, 1.0F);
        if (!this.onGround && this.flapping < 1.0F) {
            this.flapping = 1.0F;
        }

        this.flapping = (float)((double)this.flapping * 0.9D);
        Vec3d vec3d = this.getMotion();
        if (!this.onGround && vec3d.y < 0.0D) {
            this.setMotion(vec3d.mul(1.0D, 0.6D, 1.0D));
        }

        this.flap += this.flapping * 2.0F;
    }

    @Override
    public void livingTick() {
        super.livingTick();
        this.calculateFlapping();

    }

    protected boolean makeFlySound() {
        return true;
    }

    @Override
    public boolean onLivingFall(float p_225503_1_, float p_225503_2_) {
        return false;
    }

    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(AnimalEntity otherAnimal) {
        return false;
    }

    @Nullable
    public AgeableEntity createChild(AgeableEntity ageable) {
        return null;
    }

    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.ARTHROPOD;
    }

    protected void handleFluidJump(Tag<Fluid> fluidTag) {
        this.setMotion(this.getMotion().add(0.0D, 0.01D, 0.0D));
    }


    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundRegistry.DRAGONFLY_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundRegistry.DRAGONFLY_HURT;
    }

    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
    }

    @Override
    protected float playFlySound(float volume) {
        this.playSound(SoundRegistry.DRAGONFLY_FLAP, 0.15F, 1.0F);
        return volume + this.flapSpeed / 2.0F;
    }

    public void randomVariant(){
        int variant = Utilities.rint(0,4);
        this.variant = DragonFlyVariant.values()[variant];
    }

    @Override
    public void writeAdditional(CompoundNBT nbt) {
        super.writeAdditional(nbt);
        nbt.putString("variant",variant.getName());
    }

    @Override
    public void readAdditional(CompoundNBT nbt) {
        super.readAdditional(nbt);
        if(nbt.contains("variant")) {
            this.variant = DragonFlyVariant.valueOf(nbt.getString("variant").toUpperCase());
        }else{
            if(variant==null) {
                randomVariant();
            }
        }
    }

    public static enum DragonFlyVariant implements IStringSerializable{
        BLUE("blue","dragon_fly_blue.png"),
        GREEN("green","dragon_fly_green.png"),
        RED("red","dragon_fly_red.png"),
        BROWN("brown","dragon_fly_brown.png"),
        YELLOW("yellow","dragon_fly_yellow.png");

        private String name;
        private String path;
        private DragonFlyVariant(String name, String path){
            this.name=name;
            this.path=path;
        }

        @Override
        public String getName() {
            return name;
        }

        public String getPath() {
            return path;
        }
    }
}
