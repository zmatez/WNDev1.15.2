package com.matez.wildnature.world.gen.feature.configs;

import com.google.common.collect.ImmutableMap;
import com.matez.wildnature.other.BlockWeighList;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.ArrayList;
import java.util.List;

public class BlockWeightListAndSpawnChanceConfig implements IFeatureConfig {
   public final BlockWeighList list;
   public final int spawnChance;

   public BlockWeightListAndSpawnChanceConfig(BlockWeighList list, int spawnChance) {
      this.list = list;
      this.spawnChance=spawnChance;
   }

   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
      return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("blockstates"), ops.createList(serializeList(ops,list.getNormalArrayList()).stream()),ops.createString("spawnChance"),ops.createInt(spawnChance))));
   }

   private <T> ArrayList<T> serializeList(DynamicOps<T> ops, ArrayList<BlockState> states){
      ArrayList<T> serializedList = new ArrayList<>();
      for (BlockState state : states) {
         serializedList.add(BlockState.serialize(ops, state).getValue());
      }
      return serializedList;
   }

   public static <T> BlockWeightListAndSpawnChanceConfig deserialize(Dynamic<T> dynamic) {
      List<BlockState> blockstates = dynamic.get("blockstates").asList(BlockState::deserialize);
      return new BlockWeightListAndSpawnChanceConfig(BlockWeighList.parseFromNormalArrayList((ArrayList<BlockState>)blockstates),dynamic.get("spawnChance").asInt(1));
   }
}