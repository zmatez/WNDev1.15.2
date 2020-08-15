package com.matez.wildnature.world.gen.biomes.layer;

import com.matez.wildnature.world.gen.biomes.setup.WNBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum WNShoreLayer implements ICastleTransformer {
   INSTANCE;
   private static final int BEACH = Registry.BIOME.getId(Biomes.BEACH);
   private static final int SNOWY_BEACH = Registry.BIOME.getId(Biomes.SNOWY_BEACH);
   private static final int DESERT = Registry.BIOME.getId(Biomes.DESERT);
   private static final int MOUNTAINS = Registry.BIOME.getId(Biomes.MOUNTAINS);
   private static final int WOODED_MOUNTAINS = Registry.BIOME.getId(Biomes.WOODED_MOUNTAINS);
   private static final int FOREST = Registry.BIOME.getId(Biomes.FOREST);
   private static final int JUNGLE = Registry.BIOME.getId(Biomes.JUNGLE);
   private static final int JUNGLE_EDGE = Registry.BIOME.getId(Biomes.JUNGLE_EDGE);
   private static final int JUNGLE_HILLS = Registry.BIOME.getId(Biomes.JUNGLE_HILLS);
   private static final int BADLANDS = Registry.BIOME.getId(Biomes.BADLANDS);
   private static final int WOODED_BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.WOODED_BADLANDS_PLATEAU);
   private static final int BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.BADLANDS_PLATEAU);
   private static final int ERODED_BADLANDS = Registry.BIOME.getId(Biomes.ERODED_BADLANDS);
   private static final int MODIFIED_WOODED_BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU);
   private static final int MODIFIED_BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.MODIFIED_BADLANDS_PLATEAU);
   private static final int MUSHROOM_FIELDS = Registry.BIOME.getId(Biomes.MUSHROOM_FIELDS);
   private static final int MUSHROOM_FIELD_SHORE = Registry.BIOME.getId(Biomes.MUSHROOM_FIELD_SHORE);
   private static final int RIVER = Registry.BIOME.getId(Biomes.RIVER);
   private static final int MOUNTAIN_EDGE = Registry.BIOME.getId(Biomes.MOUNTAIN_EDGE);
   private static final int STONE_SHORE = Registry.BIOME.getId(Biomes.STONE_SHORE);
   private static final int SWAMP = Registry.BIOME.getId(Biomes.SWAMP);
   private static final int TAIGA = Registry.BIOME.getId(Biomes.TAIGA);
   private static final int WHITE_BEACH = Registry.BIOME.getId(WNBiomes.WhiteBeach);
   private static final int MAHOGANY_RAINFOREST = Registry.BIOME.getId(WNBiomes.MahoganyRainforest);
   private static final int MAHOGANY_CLIFFS = Registry.BIOME.getId(WNBiomes.MahoganyCliffs);
   private static final int TROPICAL_ISLAND = Registry.BIOME.getId(WNBiomes.TropicalIsland);
   private static final int MADAGASCAR = Registry.BIOME.getId(WNBiomes.Madagascar);
   private static final int MADAGASCAR_VALLEY = Registry.BIOME.getId(WNBiomes.MadagascarValley);
   private static final int TROPICAL_CLIFFS = Registry.BIOME.getId(WNBiomes.TropicalCliffs);
   private static final int CANYONS = Registry.BIOME.getId(WNBiomes.Canyons);
   private static final int GRAND_CANYON = Registry.BIOME.getId(WNBiomes.GrandCanyon);
   private static final int CANYON_RIVER = Registry.BIOME.getId(WNBiomes.CanyonRiver);
   private static final int ICELAND_RIVER = Registry.BIOME.getId(WNBiomes.IcelandRiver);
   private static final int ICELANDS = Registry.BIOME.getId(WNBiomes.Icelands);
   private static final int DAINTREE_RIVER = Registry.BIOME.getId(WNBiomes.DaintreeRiver);
   private static final int DAINTREE_CLIFFS = Registry.BIOME.getId(WNBiomes.DaintreeCliffs);
   private static final int POLDERS = Registry.BIOME.getId(WNBiomes.Polders);
   private static final int POLDERS_EDGE = Registry.BIOME.getId(WNBiomes.PoldersEdge);

   private static final int TATRA_FOOTHILLS = Registry.BIOME.getId(WNBiomes.TatraFoothills);
   private static final int TATRA_LOWER_FOREST = Registry.BIOME.getId(WNBiomes.TatraLowerForest);
   private static final int TATRA_UPPER_FOREST = Registry.BIOME.getId(WNBiomes.TatraUpperForest);
   private static final int TATRA_MOUNTAINS = Registry.BIOME.getId(WNBiomes.TatraMountains);
   private static final int TATRA_GREENED_PEAK = Registry.BIOME.getId(WNBiomes.TatraGreenedPeak);
   private static final int TATRA_KASPROWY_PEAK = Registry.BIOME.getId(WNBiomes.TatraKasprowyPeak);
   private static final int CHOCHOLOWSKA_GLADE = Registry.BIOME.getId(WNBiomes.ChocholowskaGlade);
   private static final int FIREWEED_VALLEY = Registry.BIOME.getId(WNBiomes.FireweedValley);
   private static final int CRACOW_GORGE = Registry.BIOME.getId(WNBiomes.CracowGorge);
   private static final int MORSKIE_OKO = Registry.BIOME.getId(WNBiomes.MorskieOko);
   private static final int GIEWONT = Registry.BIOME.getId(WNBiomes.Giewont);
   private static final int RYSY = Registry.BIOME.getId(WNBiomes.Rysy);
   private static final int TATRA_STREAM = Registry.BIOME.getId(WNBiomes.TatraStream);

   private static final int SNOWY_TATRA_FOOTHILLS = Registry.BIOME.getId(WNBiomes.SnowyTatraFoothills);
   private static final int SNOWY_TATRA_LOWER_FOREST = Registry.BIOME.getId(WNBiomes.SnowyTatraLowerForest);
   private static final int SNOWY_TATRA_UPPER_FOREST = Registry.BIOME.getId(WNBiomes.SnowyTatraUpperForest);
   private static final int SNOWY_TATRA_MOUNTAINS = Registry.BIOME.getId(WNBiomes.SnowyTatraMountains);
   private static final int SNOWY_TATRA_KASPROWY_PEAK = Registry.BIOME.getId(WNBiomes.SnowyTatraKasprowyPeak);
   private static final int SNOWY_CHOCHOLOWSKA_GLADE = Registry.BIOME.getId(WNBiomes.SnowyChocholowskaGlade);
   private static final int SNOWY_FIREWEED_VALLEY = Registry.BIOME.getId(WNBiomes.SnowyFireweedValley);
   private static final int SNOWY_CRACOW_GORGE = Registry.BIOME.getId(WNBiomes.SnowyCracowGorge);
   private static final int FROZEN_MORSKIE_OKO = Registry.BIOME.getId(WNBiomes.FrozenMorskieOko);
   private static final int SNOWY_GIEWONT = Registry.BIOME.getId(WNBiomes.SnowyGiewont);


   private static boolean isTatra(int biomeNear){
      return biomeNear==TATRA_FOOTHILLS || biomeNear==TATRA_LOWER_FOREST || biomeNear==TATRA_UPPER_FOREST
              || biomeNear==TATRA_MOUNTAINS  || biomeNear==TATRA_GREENED_PEAK  || biomeNear==TATRA_KASPROWY_PEAK
              || biomeNear==CHOCHOLOWSKA_GLADE  || biomeNear==FIREWEED_VALLEY  || biomeNear==CRACOW_GORGE
              || biomeNear==MORSKIE_OKO  || biomeNear==GIEWONT  || biomeNear==RYSY;
   }

   private static boolean isSnowyTatra(int biomeNear){
      return biomeNear==SNOWY_TATRA_LOWER_FOREST || biomeNear==SNOWY_TATRA_UPPER_FOREST
              || biomeNear==SNOWY_TATRA_MOUNTAINS || biomeNear==SNOWY_TATRA_KASPROWY_PEAK
              || biomeNear==SNOWY_CHOCHOLOWSKA_GLADE  || biomeNear==SNOWY_FIREWEED_VALLEY  || biomeNear==SNOWY_CRACOW_GORGE
              || biomeNear==FROZEN_MORSKIE_OKO  || biomeNear==SNOWY_GIEWONT  || biomeNear==RYSY;
   }

   public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
      Biome biome = Registry.BIOME.getByValue(center);
      if (center == MUSHROOM_FIELDS) {
         if (WNLayerUtil.isShallowOcean(north) || WNLayerUtil.isShallowOcean(west) || WNLayerUtil.isShallowOcean(south) || WNLayerUtil.isShallowOcean(east)) {
            return MUSHROOM_FIELD_SHORE;
         }
      }else if(center==CANYONS || center==GRAND_CANYON){
         return center;
      }else if(isCanyonCompatible(north)||isCanyonCompatible(south)||isCanyonCompatible(west)||isCanyonCompatible(east)){
         return CANYON_RIVER;
      }else if(center==ICELANDS){
         return center;
      }else if(center==DAINTREE_CLIFFS){
         return center;
      }else if(center==CRACOW_GORGE){
         return center;
      }else if(isTatra(center)){
         return center;
      }else if(isSnowyTatra(center)){
         return center;
      }else if(isPolderComaptible(center)){
         return center;
      }else if(isIceCanyonCompatible(north)||isIceCanyonCompatible(south)||isIceCanyonCompatible(west)||isIceCanyonCompatible(east)){
         return CANYON_RIVER;
      }else if(isDaintreeCanyonCompatible(north)||isDaintreeCanyonCompatible(south)||isDaintreeCanyonCompatible(west)||isDaintreeCanyonCompatible(east)){
         return DAINTREE_RIVER;
      }else if(isCracowGorgeCompatible(north)||isCracowGorgeCompatible(south)||isCracowGorgeCompatible(west)||isCracowGorgeCompatible(east)){
         return TATRA_STREAM;
      }else if(isTatra(north)||isTatra(south)||isTatra(west)||isTatra(east)){
         return TATRA_FOOTHILLS;
      }else if(isSnowyTatra(north)||isSnowyTatra(south)||isSnowyTatra(west)||isSnowyTatra(east)){
      return SNOWY_TATRA_FOOTHILLS;
      }else if(isPolderComaptible(north)||isPolderComaptible(south)||isPolderComaptible(west)||isPolderComaptible(east)){
         return POLDERS_EDGE;
      }
      else if (center == MAHOGANY_RAINFOREST || center==MAHOGANY_CLIFFS || center == TROPICAL_ISLAND || center == TROPICAL_CLIFFS || center == MADAGASCAR || center == MADAGASCAR_VALLEY) {
         if (WNLayerUtil.isShallowOcean(north) || WNLayerUtil.isShallowOcean(west) || WNLayerUtil.isShallowOcean(south) || WNLayerUtil.isShallowOcean(east)) {
            return WHITE_BEACH;
         }
      } else if (biome != null && biome.getCategory() == Biome.Category.JUNGLE) {
         if (!isJungleCompatible(north) || !isJungleCompatible(west) || !isJungleCompatible(south) || !isJungleCompatible(east)) {
            return JUNGLE_EDGE;
         }

         if (WNLayerUtil.isOcean(north) || WNLayerUtil.isOcean(west) || WNLayerUtil.isOcean(south) || WNLayerUtil.isOcean(east)) {
            return BEACH;
         }
      } else if (center != MOUNTAINS && center != WOODED_MOUNTAINS && center != MOUNTAIN_EDGE) {
         if (biome != null && biome.getPrecipitation() == Biome.RainType.SNOW) {
            if (!WNLayerUtil.isOcean(center) && (WNLayerUtil.isOcean(north) || WNLayerUtil.isOcean(west) || WNLayerUtil.isOcean(south) || WNLayerUtil.isOcean(east))) {
               return SNOWY_BEACH;
            }
         } else if (center != BADLANDS && center != WOODED_BADLANDS_PLATEAU) {
            if (!WNLayerUtil.isOcean(center) && center != RIVER && center != SWAMP && (WNLayerUtil.isOcean(north) || WNLayerUtil.isOcean(west) || WNLayerUtil.isOcean(south) || WNLayerUtil.isOcean(east))) {
               return BEACH;
            }
         } else if (!WNLayerUtil.isOcean(north) && !WNLayerUtil.isOcean(west) && !WNLayerUtil.isOcean(south) && !WNLayerUtil.isOcean(east) && (!this.isMesa(north) || !this.isMesa(west) || !this.isMesa(south) || !this.isMesa(east))) {
            return DESERT;
         }
      } else if (!WNLayerUtil.isOcean(center) && (WNLayerUtil.isOcean(north) || WNLayerUtil.isOcean(west) || WNLayerUtil.isOcean(south) || WNLayerUtil.isOcean(east))) {
         return STONE_SHORE;
      }

      return center;
   }

   private static boolean isJungleCompatible(int p_151631_0_) {
      if (Registry.BIOME.getByValue(p_151631_0_) != null && Registry.BIOME.getByValue(p_151631_0_).getCategory() == Biome.Category.JUNGLE) {
         return true;
      } else {
         return p_151631_0_ == JUNGLE_EDGE || p_151631_0_ == JUNGLE || p_151631_0_ == JUNGLE_HILLS || p_151631_0_ == FOREST || p_151631_0_ == TAIGA || WNLayerUtil.isOcean(p_151631_0_);
      }
   }

   private static boolean isCanyonCompatible(int biomeNear){
      return biomeNear==GRAND_CANYON || biomeNear==CANYONS || biomeNear==CANYON_RIVER;
   }

   private static boolean isIceCanyonCompatible(int biomeNear){
      return biomeNear==ICELANDS || biomeNear==ICELAND_RIVER;
   }
   private static boolean isDaintreeCanyonCompatible(int biomeNear){
      return biomeNear==DAINTREE_CLIFFS || biomeNear==DAINTREE_RIVER;
   }
   private static boolean isCracowGorgeCompatible(int biomeNear){
      return biomeNear==CRACOW_GORGE || biomeNear==TATRA_STREAM;
   }
   private static boolean isPolderComaptible(int biomeNear){
      return biomeNear==POLDERS || biomeNear==POLDERS_EDGE;
   }
   private boolean isMesa(int p_151633_1_) {
      return p_151633_1_ == BADLANDS || p_151633_1_ == WOODED_BADLANDS_PLATEAU || p_151633_1_ == BADLANDS_PLATEAU || p_151633_1_ == ERODED_BADLANDS || p_151633_1_ == MODIFIED_WOODED_BADLANDS_PLATEAU || p_151633_1_ == MODIFIED_BADLANDS_PLATEAU;
   }
}