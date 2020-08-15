package com.matez.wildnature.compatibility;

import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.Heightmap;

import java.util.Random;

public class WNMobSpawnFix {
    private static EntitySpawnPlacementRegistry.Entry entrySpawnType;
    
    public static void fixAll(){
        fix(EntityType.CHICKEN, WNMobSpawnFix::animalFix);
        fix(EntityType.COW, WNMobSpawnFix::animalFix);
        fix(EntityType.DONKEY, WNMobSpawnFix::animalFix);
        fix(EntityType.HORSE, WNMobSpawnFix::animalFix);
        fix(EntityType.LLAMA, WNMobSpawnFix::animalFix);
        fix(EntityType.MULE, WNMobSpawnFix::animalFix);
        fix(EntityType.OCELOT, WNMobSpawnFix::ocelotFix);
        fix(EntityType.PARROT, WNMobSpawnFix::parrotFix);
        fix(EntityType.PIG, WNMobSpawnFix::animalFix);
        fix(EntityType.RABBIT, WNMobSpawnFix::rabbitFix);
        fix(EntityType.SHEEP, WNMobSpawnFix::animalFix);
        fix(EntityType.TURTLE, WNMobSpawnFix::turtleFix);
        fix(EntityType.WOLF, WNMobSpawnFix::animalFix);
        fix(EntityType.CAT, WNMobSpawnFix::animalFix);
        fix(EntityType.FOX, WNMobSpawnFix::animalFix);
        fix(EntityType.PANDA, WNMobSpawnFix::animalFix);
        fix(EntityType.TRADER_LLAMA, WNMobSpawnFix::animalFix);
    }
    
    
    
    private static void fix(EntityType<? extends Entity> type, EntitySpawnPlacementRegistry.IPlacementPredicate<?> predicate){
        EntitySpawnPlacementRegistry.Entry e = EntitySpawnPlacementRegistry.REGISTRY.get(type);
        entrySpawnType=e;
        EntitySpawnPlacementRegistry.REGISTRY.replace(type,e, new EntitySpawnPlacementRegistry.Entry(e.type,e.placementType, predicate));
    }

    private static boolean animalFix(EntityType<?> p_223316_0_, IWorld p_223316_1_, SpawnReason p_223316_2_, BlockPos p_223316_3_, Random p_223316_4_) {
        return p_223316_1_.getBlockState(p_223316_3_.down()).getBlock() instanceof GrassBlock && p_223316_1_.getLightSubtracted(p_223316_3_, 0) > 8;
    }

    private static boolean ocelotFix(EntityType<?> p_223319_0_, IWorld p_223319_1_, SpawnReason p_223319_2_, BlockPos p_223319_3_, Random p_223319_4_) {
        return p_223319_4_.nextInt(3) != 0;
    }

    private static boolean parrotFix(EntityType<?> p_223317_0_, IWorld p_223317_1_, SpawnReason p_223317_2_, BlockPos p_223317_3_, Random p_223317_4_) {
        Block block = p_223317_1_.getBlockState(p_223317_3_.down()).getBlock();
        return (block.isIn(BlockTags.LEAVES) || block instanceof GrassBlock || block instanceof LogBlock || block == Blocks.AIR) && p_223317_1_.getLightSubtracted(p_223317_3_, 0) > 8;
    }

    private static boolean rabbitFix(EntityType<?> p_223321_0_, IWorld p_223321_1_, SpawnReason p_223321_2_, BlockPos p_223321_3_, Random p_223321_4_) {
        Block block = p_223321_1_.getBlockState(p_223321_3_.down()).getBlock();
        return (block instanceof GrassBlock || block == Blocks.SNOW || block == Blocks.SAND  || block == WNBlocks.WHITE_SAND) && p_223321_1_.getLightSubtracted(p_223321_3_, 0) > 8;
    }

    public static boolean turtleFix(EntityType<?> p_223322_0_, IWorld p_223322_1_, SpawnReason p_223322_2_, BlockPos p_223322_3_, Random p_223322_4_) {
        return p_223322_3_.getY() < p_223322_1_.getSeaLevel() + 4 && (p_223322_1_.getBlockState(p_223322_3_.down()).getBlock() == Blocks.SAND || p_223322_1_.getBlockState(p_223322_3_.down()).getBlock() == WNBlocks.WHITE_SAND) && p_223322_1_.getLightSubtracted(p_223322_3_, 0) > 8;
    }
}
