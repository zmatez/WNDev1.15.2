package com.matez.wildnature.world.gen.feature.configs;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.matez.wildnature.other.WeightedList;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class StructureWeightListConfig implements IFeatureConfig {
   public final WeightedList<SchemFeature> list;

   public StructureWeightListConfig(WeightedList<SchemFeature> list) {
      this.list = list;
   }

   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
      Gson gson = new Gson();
      return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("structures"), ops.createString(gson.toJson(list)))));
   }

   public static <T> StructureWeightListConfig deserialize(Dynamic<T> dynamic) {
      String json = dynamic.get("structures").asString("{}");
      Gson gson = new Gson();
      return new StructureWeightListConfig((WeightedList<SchemFeature>)gson.fromJson(json,WeightedList.class));
   }
}