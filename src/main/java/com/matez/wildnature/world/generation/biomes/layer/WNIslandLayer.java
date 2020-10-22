package com.matez.wildnature.world.generation.biomes.layer;

import com.matez.wildnature.init.Main;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.world.generation.biomes.setup.WNBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IBishopTransformer;

import java.util.ArrayList;

public enum WNIslandLayer implements IBishopTransformer {
   INSTANCE;

   private static final int EASTER_ISLAND = Registry.BIOME.getId(WNBiomes.EasterIsland);
   private static final int TROPICAL_ISLAND = Registry.BIOME.getId(WNBiomes.TropicalIsland);
   private static final int MADAGASCAR = Registry.BIOME.getId(WNBiomes.Madagascar);
   private static final int CHRISTMAS_ISLAND = Registry.BIOME.getId(WNBiomes.ChristmasIsland);
   public static ArrayList<Island> islands = new ArrayList<>();

   static {
      applyIslands();
   }

   public static void applyIslands(){
      Main.LOGGER.debug("Applying islands");
      islands.add(new Island(EASTER_ISLAND,70));
      islands.add(new Island(TROPICAL_ISLAND,40));
      islands.add(new Island(MADAGASCAR,30));
      islands.add(new Island(CHRISTMAS_ISLAND,50));
      Main.LOGGER.debug("Islands appiled: ");
      for (Island island : islands) {
         Main.LOGGER.debug("Island " + island.getBiome());
      }
   }


   @Override
   public int apply(INoiseRandom context, int side, int side1, int side2, int side3, int side4) {
      if(WNLayerUtil.isOcean(side) && WNLayerUtil.isOcean(side1) && WNLayerUtil.isOcean(side2) && WNLayerUtil.isOcean(side3) && WNLayerUtil.isOcean(side4)){
         for(Island island : islands){
            if(context.random(island.rarity)==0){
               Main.LOGGER.debug("adding island " + island.getBiome());
               if(!CommonConfig.blacklistedBiomes.contains(Registry.BIOME.getByValue(island.getBiome()))) {
                  Main.LOGGER.debug("added island " + island.getBiome());
                  return island.getBiome();
               }
            }
         }
      }

      for(Island island : islands){
         if(isSame(side,island.getBiome()) || isSame(side1,island.getBiome()) || isSame(side2,island.getBiome()) || isSame(side3,island.getBiome()) || isSame(side4,island.getBiome())){
            if(context.random(island.rarity)!=0){
               if(!CommonConfig.blacklistedBiomes.contains(Registry.BIOME.getByValue(island.getBiome()))) {
                  return island.getBiome();
               }
            }
         }

      }
      return side;
   }
   
   private boolean isSame(int biome, int island){
      return biome==island;
   }

   public static class Island{
      private int biome;
      private int rarity;//smaller = more
      public Island(int b, int rarity){
         this.biome=b;
         this.rarity=rarity;
      }

      public int getBiome() {
         return biome;
      }

      public int getRarity() {
         return rarity;
      }
   }
}
