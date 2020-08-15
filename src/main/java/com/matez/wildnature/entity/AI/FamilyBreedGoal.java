package com.matez.wildnature.entity.AI;

import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nullable;

import com.matez.wildnature.Main;
import com.matez.wildnature.entity.type.animal.IFamily;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class FamilyBreedGoal extends Goal {
    private static final EntityPredicate predicate = (new EntityPredicate()).setDistance(8.0D).allowInvulnerable().allowFriendlyFire().setLineOfSiteRequired();
    protected final AnimalEntity animal;
    private final Class<? extends AnimalEntity> mateClass;
    protected final World world;
    protected AnimalEntity mateWithEntity;
    private int spawnBabyDelay;
    private final double moveSpeed;
    private final IFamily.Gender gender;

    public FamilyBreedGoal(AnimalEntity animal, double speedIn, IFamily.Gender gender) {
        this(animal, speedIn, animal.getClass(),gender);
    }

    public FamilyBreedGoal(AnimalEntity entity, double moveSpeed, Class<? extends AnimalEntity> clazz, IFamily.Gender gender) {
        this.animal = entity;
        this.world = entity.world;
        this.mateClass = clazz;
        this.moveSpeed = moveSpeed;
        this.gender=gender;
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        if (!this.animal.isInLove()) {
            return false;
        } else {
            this.mateWithEntity = this.getNearbyMate();
            return this.mateWithEntity != null;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting() {
        return this.mateWithEntity.isAlive() && this.mateWithEntity.isInLove() && this.spawnBabyDelay < 60;
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask() {
        this.mateWithEntity = null;
        this.spawnBabyDelay = 0;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        this.animal.getLookController().setLookPositionWithEntity(this.mateWithEntity, 10.0F, (float)this.animal.getVerticalFaceSpeed());
        this.animal.getNavigator().tryMoveToEntityLiving(this.mateWithEntity, this.moveSpeed);
        ++this.spawnBabyDelay;
        if (this.spawnBabyDelay >= 60 && this.animal.getDistanceSq(this.mateWithEntity) < 9.0D) {
            this.spawnBaby();
        }

    }

    /**
     * Loops through nearby animals and finds another animal of the same type that can be mated with. Returns the first
     * valid mate found.
     */
    @Nullable
    private AnimalEntity getNearbyMate() {
        List<AnimalEntity> list = this.world.getTargettableEntitiesWithinAABB(this.mateClass, predicate, this.animal, this.animal.getBoundingBox().grow(8.0D));
        double d0 = Double.MAX_VALUE;
        AnimalEntity animalentity = null;

        for(AnimalEntity animalentity1 : list) {
            if (this.animal.canMateWith(animalentity1) && this.animal.getDistanceSq(animalentity1) < d0) {
                animalentity = animalentity1;
                d0 = this.animal.getDistanceSq(animalentity1);
            }
        }

        return animalentity;
    }

    /**
     * Spawns a baby animal of the same type.
     */
    protected void spawnBaby() {
        Main.LOGGER.debug("Spawning babe");
        AgeableEntity ageableentity = this.animal.createChild(this.mateWithEntity);
        AnimalEntity mother = null;
        AnimalEntity father = null;
        if(((IFamily)animal).getGender()== IFamily.Gender.MALE){
            //animal = male
            mother=mateWithEntity;
            father=animal;
        }else{
            //animal = female
            mother=animal;
            father=mateWithEntity;
        }
        final net.minecraftforge.event.entity.living.BabyEntitySpawnEvent event = new net.minecraftforge.event.entity.living.BabyEntitySpawnEvent(mother, father, ageableentity);
        final boolean cancelled = net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
        ageableentity = event.getChild();
        if (cancelled) {
            //Reset the "inLove" state for the animals
            this.animal.setGrowingAge(6000);
            this.mateWithEntity.setGrowingAge(6000);
            this.animal.resetInLove();
            this.mateWithEntity.resetInLove();
            return;
        }
        if (ageableentity != null) {
            Main.LOGGER.debug("Spawning babe2");
            ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
            if (serverplayerentity == null && this.mateWithEntity.getLoveCause() != null) {
                serverplayerentity = this.mateWithEntity.getLoveCause();
            }

            if (serverplayerentity != null) {
                serverplayerentity.addStat(Stats.ANIMALS_BRED);
                CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, mother, father, ageableentity);
            }

            this.animal.setGrowingAge(6000);
            this.mateWithEntity.setGrowingAge(6000);
            this.animal.resetInLove();
            this.mateWithEntity.resetInLove();
            ageableentity.setGrowingAge(-24000);
            ageableentity.setLocationAndAngles(mother.getPosition().getX(), mother.getPosition().getY(), mother.getPosition().getZ(), 0.0F, 0.0F);
            this.world.addEntity(ageableentity);
            this.world.setEntityState(mother, (byte)18);
            if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
                this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosition().getX(), this.animal.getPosition().getY(), this.animal.getPosition().getZ(), mother.getRNG().nextInt(7) + 1));
            }

            Main.LOGGER.debug("Spawned");
        }
    }
}