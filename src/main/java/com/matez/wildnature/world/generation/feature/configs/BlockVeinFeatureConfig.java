package com.matez.wildnature.world.generation.feature.configs;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class BlockVeinFeatureConfig implements IFeatureConfig {
   public final BlockState state;
   public final int veinSizeMin;
   public final int veinSizeMax;
   public BlockVeinFeatureConfig(BlockState state, int veinSizeMin, int veinSizeMax) {
      this.state = state;
      this.veinSizeMin = veinSizeMin;
      this.veinSizeMax = veinSizeMax;
   }

   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
      return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("state"), BlockState.serialize(ops, this.state).getValue(),ops.createInt(veinSizeMin), ops.createString("veinSizeMin"),ops.createInt(veinSizeMax), ops.createString("veinSizeMax"))));
   }

   public static <T> BlockVeinFeatureConfig deserialize(Dynamic<T> dynamic) {
      BlockState blockstate = dynamic.get("state").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
      int vmin = dynamic.get("veinSizeMin").asInt(1);
      int vmax = dynamic.get("veinSizeMax").asInt(1);
      return new BlockVeinFeatureConfig(blockstate,vmin,vmax);
   }
}