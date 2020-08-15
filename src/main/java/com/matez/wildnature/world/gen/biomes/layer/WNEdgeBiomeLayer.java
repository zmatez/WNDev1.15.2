package com.matez.wildnature.world.gen.biomes.layer;

import com.matez.wildnature.world.gen.biomes.setup.WNBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum WNEdgeBiomeLayer implements ICastleTransformer {
   INSTANCE;

   private static final int DESERT = Registry.BIOME.getId(Biomes.DESERT);
   private static final int MOUNTAINS = Registry.BIOME.getId(Biomes.MOUNTAINS);
   private static final int WOODED_MOUNTAINS = Registry.BIOME.getId(Biomes.WOODED_MOUNTAINS);
   private static final int SNOWY_TUNDRA = Registry.BIOME.getId(Biomes.SNOWY_TUNDRA);
   private static final int JUNGLE = Registry.BIOME.getId(Biomes.JUNGLE);
   private static final int BAMBOO_JUNGLE = Registry.BIOME.getId(Biomes.BAMBOO_JUNGLE);
   private static final int JUNGLE_EDGE = Registry.BIOME.getId(Biomes.JUNGLE_EDGE);
   private static final int BADLANDS = Registry.BIOME.getId(Biomes.BADLANDS);
   private static final int BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.BADLANDS_PLATEAU);
   private static final int WOODED_BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.WOODED_BADLANDS_PLATEAU);
   private static final int PLAINS = Registry.BIOME.getId(Biomes.PLAINS);
   private static final int GIANT_TREE_TAIGA = Registry.BIOME.getId(Biomes.GIANT_TREE_TAIGA);
   private static final int MOUNTAIN_EDGE = Registry.BIOME.getId(Biomes.MOUNTAIN_EDGE);
   private static final int SWAMP = Registry.BIOME.getId(Biomes.SWAMP);
   private static final int TAIGA = Registry.BIOME.getId(Biomes.TAIGA);
   private static final int SNOWY_TAIGA = Registry.BIOME.getId(Biomes.SNOWY_TAIGA);
   private static final int POLDERS = Registry.BIOME.getId(WNBiomes.Polders);
   private static final int POLDERS_EDGE = Registry.BIOME.getId(WNBiomes.PoldersEdge);

   private static final int TATRA_FOOTHILLS = Registry.BIOME.getId(WNBiomes.TatraFoothills);
   private static final int TATRA_LOWER_FOREST = Registry.BIOME.getId(WNBiomes.TatraLowerForest);
   private static final int TATRA_UPPER_FOREST = Registry.BIOME.getId(WNBiomes.TatraUpperForest);
   private static final int TATRA_MOUNTAINS = Registry.BIOME.getId(WNBiomes.TatraMountains);
   private static final int TATRA_GREENED_PEAK = Registry.BIOME.getId(WNBiomes.TatraGreenedPeak);
   private static final int TATRA_RED_PEAK = Registry.BIOME.getId(WNBiomes.TatraRedPeak);
   private static final int TATRA_KASPROWY_PEAK = Registry.BIOME.getId(WNBiomes.TatraKasprowyPeak);
   private static final int CHOCHOLOWSKA_GLADE = Registry.BIOME.getId(WNBiomes.ChocholowskaGlade);
   private static final int FIREWEED_VALLEY = Registry.BIOME.getId(WNBiomes.FireweedValley);
   private static final int CRACOW_GORGE = Registry.BIOME.getId(WNBiomes.CracowGorge);
   private static final int MORSKIE_OKO = Registry.BIOME.getId(WNBiomes.MorskieOko);
   private static final int GIEWONT = Registry.BIOME.getId(WNBiomes.Giewont);
   private static final int RYSY = Registry.BIOME.getId(WNBiomes.Rysy);

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
      return biomeNear==TATRA_LOWER_FOREST || biomeNear==TATRA_UPPER_FOREST
              || biomeNear==TATRA_MOUNTAINS  || biomeNear==TATRA_GREENED_PEAK  || biomeNear==TATRA_RED_PEAK  || biomeNear==TATRA_KASPROWY_PEAK
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
      int[] aint = new int[1];
      if (!this.func_202751_a(aint, north, west, south, east, center, MOUNTAINS, MOUNTAIN_EDGE) && !this.replaceBiomeEdge(aint, north, west, south, east, center, WOODED_BADLANDS_PLATEAU, BADLANDS) && !this.replaceBiomeEdge(aint, north, west, south, east, center, BADLANDS_PLATEAU, BADLANDS) && !this.replaceBiomeEdge(aint, north, west, south, east, center, GIANT_TREE_TAIGA, TAIGA)) {
         if (center != DESERT || north != SNOWY_TUNDRA && west != SNOWY_TUNDRA && east != SNOWY_TUNDRA && south != SNOWY_TUNDRA) {
            if (center == SWAMP) {
               if (north == DESERT || west == DESERT || east == DESERT || south == DESERT || north == SNOWY_TAIGA || west == SNOWY_TAIGA || east == SNOWY_TAIGA || south == SNOWY_TAIGA || north == SNOWY_TUNDRA || west == SNOWY_TUNDRA || east == SNOWY_TUNDRA || south == SNOWY_TUNDRA) {
                  return PLAINS;
               }

               if (north == JUNGLE || south == JUNGLE || west == JUNGLE || east == JUNGLE || north == BAMBOO_JUNGLE || south == BAMBOO_JUNGLE || west == BAMBOO_JUNGLE || east == BAMBOO_JUNGLE) {
                  return JUNGLE_EDGE;
               }

               if (north == POLDERS || south == POLDERS || west == POLDERS || east == POLDERS) {
                  return POLDERS_EDGE;
               }

               if (isTatra(north) || isTatra(south) || isTatra(east) || isTatra(west)) {
                  return TATRA_FOOTHILLS;
               }

               if (isSnowyTatra(north) || isSnowyTatra(south) || isSnowyTatra(east) || isSnowyTatra(west)) {
                  return SNOWY_TATRA_FOOTHILLS;
               }
            }

            return center;
         } if (north == POLDERS || south == POLDERS || west == POLDERS || east == POLDERS) {
            return POLDERS_EDGE;
         } else if (isSnowyTatra(north) || isSnowyTatra(south) || isSnowyTatra(east) || isSnowyTatra(west)) {
            return SNOWY_TATRA_FOOTHILLS;
         } else {
            return WOODED_MOUNTAINS;
         }
      } else {
         return aint[0];
      }
   }

   private boolean func_202751_a(int[] p_202751_1_, int p_202751_2_, int p_202751_3_, int p_202751_4_, int p_202751_5_, int p_202751_6_, int p_202751_7_, int p_202751_8_) {
      if (!LayerUtil.areBiomesSimilar(p_202751_6_, p_202751_7_)) {
         return false;
      } else {
         if (this.canBiomesBeNeighbors(p_202751_2_, p_202751_7_) && this.canBiomesBeNeighbors(p_202751_3_, p_202751_7_) && this.canBiomesBeNeighbors(p_202751_5_, p_202751_7_) && this.canBiomesBeNeighbors(p_202751_4_, p_202751_7_)) {
            p_202751_1_[0] = p_202751_6_;
         } else {
            p_202751_1_[0] = p_202751_8_;
         }

         return true;
      }
   }

   /**
    * Creates a border around a biome.
    */
   private boolean replaceBiomeEdge(int[] p_151635_1_, int p_151635_2_, int p_151635_3_, int p_151635_4_, int p_151635_5_, int p_151635_6_, int p_151635_7_, int p_151635_8_) {
      if (p_151635_6_ != p_151635_7_) {
         return false;
      } else {
         if (LayerUtil.areBiomesSimilar(p_151635_2_, p_151635_7_) && LayerUtil.areBiomesSimilar(p_151635_3_, p_151635_7_) && LayerUtil.areBiomesSimilar(p_151635_5_, p_151635_7_) && LayerUtil.areBiomesSimilar(p_151635_4_, p_151635_7_)) {
            p_151635_1_[0] = p_151635_6_;
         } else {
            p_151635_1_[0] = p_151635_8_;
         }

         return true;
      }
   }

   /**
    * Returns if two biomes can logically be neighbors. If one is hot and the other cold, for example, it returns false.
    */
   private boolean canBiomesBeNeighbors(int p_151634_1_, int p_151634_2_) {
      if (LayerUtil.areBiomesSimilar(p_151634_1_, p_151634_2_)) {
         return true;
      } else {
         Biome biome = Registry.BIOME.getByValue(p_151634_1_);
         Biome biome1 = Registry.BIOME.getByValue(p_151634_2_);
         if (biome != null && biome1 != null) {
            Biome.TempCategory biome$tempcategory = biome.getTempCategory();
            Biome.TempCategory biome$tempcategory1 = biome1.getTempCategory();
            return biome$tempcategory == biome$tempcategory1 || biome$tempcategory == Biome.TempCategory.MEDIUM || biome$tempcategory1 == Biome.TempCategory.MEDIUM;
         } else {
            return false;
         }
      }
   }
}