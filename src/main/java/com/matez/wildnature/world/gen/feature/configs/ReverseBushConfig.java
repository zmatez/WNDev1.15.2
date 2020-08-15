package com.matez.wildnature.world.gen.feature.configs;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class ReverseBushConfig implements IFeatureConfig {
   public final BlockState state;
   public final boolean reverse;

   public ReverseBushConfig(BlockState state, boolean reverse) {
      this.state = state;
      this.reverse = reverse;
   }

   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
      return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("state"), BlockState.serialize(ops, this.state).getValue(),ops.createBoolean(reverse), ops.createString("reverse"))));
   }

   public static <T> ReverseBushConfig deserialize(Dynamic<T> dynamic) {
      BlockState blockstate = dynamic.get("state").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
      boolean reverse = dynamic.get("reverse").asBoolean(false);
      return new ReverseBushConfig(blockstate,reverse);
   }
}