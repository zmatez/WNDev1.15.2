package com.matez.wildnature.entity.type.animal.duck;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.AI.*;
import com.matez.wildnature.entity.AI.Movement.FlyingMovementControllerOld;
import com.matez.wildnature.entity.AI.RandomSwimmingGoal;
import com.matez.wildnature.entity.AI.RandomWalkingGoal;
import com.matez.wildnature.entity.AI.TemptGoal;
import com.matez.wildnature.entity.EntityRegistry;
import com.matez.wildnature.entity.type.animal.IFamily;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.sounds.SoundRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

public abstract class AbstractDuckEntity extends AnimalEntity implements IFamily, IFlyingAnimal {

   private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS, Items.BREAD);
   public float wingRotation;
   public float destPos;
   public float oFlapSpeed;
   public float oFlap;
   public float wingRotDelta = 1.0F;
   public int timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
   public Gender gender = null;
   public boolean isGroupLeader = false, breed = false, sleeping = false;
   public AbstractDuckEntity leader = this;
   public ArrayList<AbstractDuckEntity> group = new ArrayList<>();
   public int eatTicks = 0;
   public boolean flying = false;
   public boolean angry = false, wasAngry = true;
   public int angryFlight=0;
   public PathNavigator groundNavigator;
   public PathNavigator flyingNavigator;
   public PathNavigator waterNavigator;
   public MovementController groundMovementController = new MovementController(this);
   public MovementController flyingMovementController = new FlyingMovementControllerOld(this,0.3f);
   public static final Predicate<ItemEntity> predicate = (item) -> {
      return !item.cannotPickup() && item.isAlive() && checkIfContains(TEMPTATION_ITEMS.getMatchingStacks(),item.getItem().getItem());
   };
   public static final Predicate<LivingEntity> leaderPredicate = (entity) -> {
      if(entity instanceof AbstractDuckEntity){
         AbstractDuckEntity duck = (AbstractDuckEntity)entity;
         if((duck.isGroupLeader() || duck == duck.getLeader()) && duck.getGroup().size() > 1){
            return true;
         }
      }
      return false;
   };

   public AbstractDuckEntity(EntityType<? extends AbstractDuckEntity> type, World worldIn) {
      super(type, worldIn);
      init();
   }

   public AbstractDuckEntity(EntityType<? extends AbstractDuckEntity> type, World worldIn, Gender g) {
      super(type, worldIn);
      this.gender=g;
      init();
   }

   public AbstractDuckEntity(World worldIn) {
      super(EntityRegistry.DRAKE, worldIn);
      init();
   }

   @Nullable
   @Override
   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      if(this.getPosition().getY()<worldIn.getSeaLevel()){
         this.setPosition(this.getPosition().getX(),worldIn.getSeaLevel(),this.getPosition().getZ());
      }
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   @Override
   protected PathNavigator createNavigator(World worldIn) {
      groundNavigator = new GroundPathNavigator(this, this.getEntityWorld());
      flyingNavigator =  new FlyingPathNavigator(this, this.getEntityWorld());
      waterNavigator = new SwimmerPathNavigator(this, this.getEntityWorld());
      return groundNavigator;
   }

   public void init(){
      this.setPathPriority(PathNodeType.WATER, 20.0F);
      groundNavigator.setCanSwim(true);
      waterNavigator.setCanSwim(true);
      flyingNavigator.setCanSwim(true);

   }

   @Override
   public PathNavigator getNavigator() {
      if((this.getAttackTarget()==null && this.getRevengeTarget()==null && !flying) || this.getGender()==Gender.CHILD){
         if(this.isInWater()){
            navigator=waterNavigator;
            this.moveController = groundMovementController;
            return waterNavigator;
         }else{
            navigator=groundNavigator;
            this.moveController = groundMovementController;
            return groundNavigator;
         }
      }else{
         flying=true;
         navigator=flyingNavigator;
         this.moveController = flyingMovementController;
         return flyingNavigator;
      }
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(1, new DuckSwimGoal(this));
      this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
      this.goalSelector.addGoal(2, new CreateGroupGoal(this));
      this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, FoxEntity.class,16,0.8F,1.2F));
      this.goalSelector.addGoal(4, new DuckAvoidEntityGoal(this, PlayerEntity.class,16,0.7F,1.3F));
      this.goalSelector.addGoal(5, new AvoidEntityGoal<AbstractDuckEntity>(this, AbstractDuckEntity.class,16,0.7F,1.3F,leaderPredicate));
      this.goalSelector.addGoal(6, new FamilyBreedGoal(this, 1.0D,this.getGender()));
      this.goalSelector.addGoal(7, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
      this.goalSelector.addGoal(8, new FollowMotherGoal(this, 1.1D));
      this.goalSelector.addGoal(9, new StayInGroup(this, 8,1.0D));
      //this.goalSelector.addGoal(9, new SleepInGroup(this));
      this.goalSelector.addGoal(11, new FindItemsGoal(this, predicate));
      this.goalSelector.addGoal(12, new RandomSwimmingGoal(this, 1.0D,220,20,4));
      this.goalSelector.addGoal(13, new RandomWalkingGoal(this, 1.0D,120,20,10));
      this.goalSelector.addGoal(14, new RandomFlyingGoal(this, 1.3D,60));
      this.goalSelector.addGoal(15, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(15, new LookAtGoal(this, AbstractDuckEntity.class, 6.0F));
      this.goalSelector.addGoal(16, new LookRandomlyGoal(this));
   }


   @Override
   public void tick() {
      super.tick();
      if (this.isInWater()) {
         this.setMotion(this.getMotion().add(0.0D, 0.005D, 0.0D));
      }
      if(this.isSleeping()){
         this.setMotion(0,this.getMotion().y,0);
      }

      if(Utilities.rint(0,100)==0 && !isSleeping() && this.isInWater() && !this.angry){
         //this.angry = true;
         //angryFlight=100;
      }
      if(angry){
         if(angryFlight==100){
            this.playSound(SoundRegistry.DUCK_SCARED,1,1);
         }
         if(angryFlight>0){
            angryFlight--;
            this.setMoveVertical(1.5F);
            this.setMoveForward(4F);

         }else{
            angry=false;
            angryFlight=0;
         }
      }

      if(this.isInWater() && (this.getMotion().x!=0 || this.getMotion().z!=0)){
         Vec3d vec3d = this.getLook(0.0F);
         for(int i = 0; i < 2; ++i) {
            this.world.addParticle(ParticleTypes.FALLING_WATER, this.getPosX() - vec3d.x, this.getPosY() - vec3d.y, this.getPosZ() - vec3d.z , 0.0D, 0.0D, 0.0D);
            this.world.addParticle(ParticleTypes.FALLING_WATER, this.getPosX() - vec3d.x , this.getPosY() - vec3d.y, this.getPosZ() - vec3d.z, 0.0D, 0.0D, 0.0D);
         }
      }
   }


   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return this.isChild() ? sizeIn.height * 0.85F : sizeIn.height * 0.92F;
   }

   protected void registerAttributes() {
      super.registerAttributes();
      this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
      this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0D);
      this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue((double)2F);
      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
      this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100D);
      this.getAttribute(SWIM_SPEED).setBaseValue(2D);
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void livingTick() {
      super.livingTick();
      this.oFlap = this.wingRotation;
      this.oFlapSpeed = this.destPos;
      this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);
      this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);
      if (!this.onGround && this.wingRotDelta < 1.0F) {
         this.wingRotDelta = 1.0F;
      }

      this.wingRotDelta = (float)((double)this.wingRotDelta * 0.9D);
      Vec3d vec3d = this.getMotion();
      if (!this.onGround && vec3d.y < 0.0D) {
         this.setMotion(vec3d.mul(1.0D, 0.6D, 1.0D));
      }

      this.wingRotation += this.wingRotDelta * 2.0F;
      if (!this.world.isRemote && this.isAlive() && !this.isChild() && getGender()==Gender.FEMALE && --this.timeUntilNextEgg <= 0) {
         this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
         this.entityDropItem(Items.EGG);
         this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
      }

      ++this.eatTicks;
      ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
      if (this.canEatItem(itemstack)) {
         if (this.eatTicks > 600) {
            ItemStack itemstack1 = itemstack.onItemUseFinish(this.world, this);
            if (!itemstack1.isEmpty()) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack1);
            }

            this.eatTicks = 0;
         } else if (this.eatTicks > 560 && this.rand.nextFloat() < 0.1F) {
            this.playSound(this.getEatSound(itemstack), 1.0F, 1.0F);
            this.world.setEntityState(this, (byte)45);
         }
      }

   }

   private boolean canEatItem(ItemStack itemStackIn) {
      return !this.isSleeping() && (this.onGround || this.inWater) && checkIfContains(TEMPTATION_ITEMS.getMatchingStacks(),itemStackIn.getItem());
   }

   public void fall(float distance, float damageMultiplier) {
   }



   protected SoundEvent getAmbientSound() {
      if(getGender()==Gender.CHILD){
         return SoundRegistry.DUCK_CHICK;
      }else{
         return SoundRegistry.DUCK_QUACK;
      }
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      if(getGender()==Gender.CHILD){
         return SoundRegistry.DUCK_CHICK;
      }else{
         return SoundRegistry.DUCK_SCARED;
      }
   }

   protected SoundEvent getDeathSound() {
      if(getGender()==Gender.CHILD){
         return SoundRegistry.DUCK_CHICK;
      }else{
         return SoundRegistry.DUCK_SCARED;
      }
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.1F, 1.0F);
   }

   protected SoundEvent getSwimSound() {
      return SoundEvents.ENTITY_GENERIC_SWIM;
   }


   public AbstractDuckEntity createChild(AgeableEntity ageable) {
      return EntityRegistry.DUCKLING.create(this.world);
   }

   /**
    * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
    * the animal type)
    */
   public boolean isBreedingItem(ItemStack stack) {
      return TEMPTATION_ITEMS.test(stack);
   }

   /**
    * Get the experience points the entity currently has.
    */
   protected int getExperiencePoints(PlayerEntity player) {
      return super.getExperiencePoints(player);
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      if (compound.contains("EggLayTime")) {
         this.timeUntilNextEgg = compound.getInt("EggLayTime");
      }
      if (compound.contains("isBreed")) {
         this.breed = compound.getBoolean("isBreed");
      }
      if (compound.contains("isSleeping")) {
         this.sleeping = compound.getBoolean("isSleeping");
      }
      if (compound.contains("leaderEntity") && !world.isRemote()) {
         Entity e = ((ServerWorld)world).getEntityByUuid(UUID.fromString(compound.getString("leaderEntity")));
         if(e instanceof AbstractDuckEntity){
            leader = (AbstractDuckEntity) e;
            Main.LOGGER.debug("My leader is " + leader==this + " " + leader);
         }
      }else{
         Main.LOGGER.debug("Cannot get leader");

      }
      if (compound.contains("isGroupLeader")) {
         this.isGroupLeader = compound.getBoolean("isGroupLeader");
         if(!world.isRemote() && compound.contains("duckGroup")){
            ListNBT l = (ListNBT)compound.get("duckGroup");

            assert l != null;

            for(INBT nbt : l){
               Main.LOGGER.info("Reading nbt...");
               String s = ((CompoundNBT)nbt).getString("uuid");
               Entity e = ((ServerWorld)world).getEntityByUuid(UUID.fromString(s));
               if(e instanceof AbstractDuckEntity){
                  Main.LOGGER.info("Readed from uuid " + group.size() + " : " + e);

                  group.add((AbstractDuckEntity)e);
               }
            }
         }
      }else{
         //new spawned
      }

   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putInt("EggLayTime", this.timeUntilNextEgg);
      compound.putBoolean("isGroupLeader", this.isGroupLeader);
      compound.putBoolean("isBreed", this.breed);
      compound.putBoolean("isSleeping", this.sleeping);
      compound.putString("leaderEntity",getLeader().getUniqueID().toString());


      ListNBT l = new ListNBT();
      for (AbstractDuckEntity duck : group) {
         CompoundNBT n = new CompoundNBT();
         n.putString("uuid",duck.getUniqueID().toString());
         l.add(n);
      }

      compound.put("duckGroup",l);


   }

   public boolean canDespawn(double distanceToClosestPlayer) {
      return !this.isBeingRidden();
   }

   public Gender getGender() {
      return gender;
   }

   @Override
   public boolean canMateWith(AnimalEntity otherAnimal) {
      Main.LOGGER.debug("breed ");
      if (otherAnimal == this) {
         return false;
      }else {
         if(otherAnimal instanceof AbstractDuckEntity){
            if(((AbstractDuckEntity)otherAnimal).getGender()==this.getGender()){
               return false;
            }
            if(((AbstractDuckEntity)otherAnimal).getGender()==Gender.CHILD){
               return false;
            }
            Main.LOGGER.debug("breed y");
            return this.isInLove() && otherAnimal.isInLove();
         }
         return false;
      }
   }

   @Override
   public boolean isSleeping() {
      return sleeping;
   }

   public void setSleeping(boolean sleeping) {
      this.sleeping = sleeping;
   }

   public ArrayList<AbstractDuckEntity> getGroup() {
      return getLeader().group;
   }

   public boolean isGroupLeader() {
      return isGroupLeader;
   }

   public void setGroupLeader(boolean groupLeader) {
      leader.isGroupLeader = groupLeader;
   }

   public void setGroup(ArrayList<AbstractDuckEntity> ducks){
      this.group=ducks;
   }

   public AbstractDuckEntity getLeader() {
      return leader;
   }

   public void setLeader(AbstractDuckEntity leader) {
      this.leader = leader;
   }

   public boolean isFlying() {
      return flying;
   }

   public void setFlying(boolean flying) {
      this.flying = flying;
   }


   public static boolean registerSpawning(EntityType<AbstractDuckEntity> duck, IWorld world, SpawnReason reason, BlockPos pos, Random random) {
      Block blockDown = world.getBlockState(pos.down()).getBlock();
      Block block = world.getBlockState(pos).getBlock();
      return (blockDown.isIn(BlockTags.SAND) || blockDown instanceof GrassBlock || block == Blocks.WATER || blockDown==Blocks.WATER);
   }


   public static boolean checkIfContains(ItemStack[] stacks, Item i){
      for (ItemStack stack : stacks) {
         if(stack.getItem()==i){
            return true;
         }
      }
      return false;
   }


   public static class DuckAvoidEntityGoal extends AvoidEntityGoal {
      public DuckAvoidEntityGoal(CreatureEntity entityIn, Class classToAvoidIn, float avoidDistanceIn, double farSpeedIn, double nearSpeedIn) {
         super(entityIn, classToAvoidIn, avoidDistanceIn, farSpeedIn, nearSpeedIn);
      }

      public DuckAvoidEntityGoal(CreatureEntity entityIn, Class avoidClass, Predicate targetPredicate, float distance, double nearSpeedIn, double farSpeedIn, Predicate p_i48859_9_) {
         super(entityIn, avoidClass, targetPredicate, distance, nearSpeedIn, farSpeedIn, p_i48859_9_);
      }

      public DuckAvoidEntityGoal(CreatureEntity p_i48860_1_, Class p_i48860_2_, float p_i48860_3_, double p_i48860_4_, double p_i48860_6_, Predicate p_i48860_8_) {
         super(p_i48860_1_, p_i48860_2_, p_i48860_3_, p_i48860_4_, p_i48860_6_, p_i48860_8_);
      }

      @Override
      public boolean shouldExecute() {
         Main.LOGGER.debug("avoiding player");
         if(entity instanceof AbstractDuckEntity){
            if(((AbstractDuckEntity)entity).breed){
               Main.LOGGER.debug("false");
               return false;
            }
         }

         if(super.shouldExecute()){
            if(entity instanceof AbstractDuckEntity){
               ((AbstractDuckEntity)entity).setFlying(true);
            }
         }
         return false;
      }

      @Override
      public boolean shouldContinueExecuting() {
         if(!super.shouldContinueExecuting()){
            if(entity instanceof AbstractDuckEntity){
               ((AbstractDuckEntity)entity).setFlying(false);
            }
         }
         return true;
      }
   }
}