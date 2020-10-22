package com.matez.wildnature.world.generation.feature.configs;

import com.matez.wildnature.util.other.TreeWeighList;
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