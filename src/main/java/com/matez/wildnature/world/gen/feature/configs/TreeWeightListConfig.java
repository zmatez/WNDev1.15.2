package com.matez.wildnature.world.gen.feature.configs;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.matez.wildnature.other.TreeWeighList;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class TreeWeightListConfig implements IFeatureConfig {
   public final TreeWeighList list;

   public TreeWeightListConfig(TreeWeighList list) {
      this.list = list;
   }

   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
      return new Dynamic<>(ops);
   }

   public static <T> TreeWeightListConfig deserialize(Dynamic<T> dynamic) {
      return new TreeWeightListConfig(new TreeWeighList());
   }
}