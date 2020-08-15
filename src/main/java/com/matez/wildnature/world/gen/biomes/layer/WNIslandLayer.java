package com.matez.wildnature.world.gen.biomes.layer;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;
import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;

import java.util.ArrayList;

public enum WNIslandLayer implements IAreaTransformer1, IDimOffset1Transformer {
   INSTANCE;

   private static final int EASTER_ISLAND = Registry.BIOME.getId(WNBiomes.EasterIsland);
   private static final int TROPICAL_ISLAND = Registry.BIOME.getId(WNBiomes.TropicalIsland);
   private static final int MADAGASCAR = Registry.BIOME.getId(WNBiomes.Madagascar);
   private static final int CHRISTMAS_ISLAND = Registry.BIOME.getId(WNBiomes.ChristmasIsland);
   public static ArrayList<Island> islands = new ArrayList<>();

   public static void applyIslands(){
      islands.add(new Island(EASTER_ISLAND,70));
      islands.add(new Island(TROPICAL_ISLAND,40));
      islands.add(new Island(MADAGASCAR,30));
      islands.add(new Island(CHRISTMAS_ISLAND,50));
   }


   @Override
   public int func_215728_a(IExtendedNoiseRandom<?> context, IArea layer, int x, int z) {
      int side1 = layer.getValue(x+1,z);
      int side2 = layer.getValue(x-1,z);
      int side3 = layer.getValue(x,z+1);
      int side4 = layer.getValue(x,z-1);
      int side = layer.getValue(x,z);

      if(WNLayerUtil.isOcean(side) && WNLayerUtil.isOcean(side1) && WNLayerUtil.isOcean(side2) && WNLayerUtil.isOcean(side3) && WNLayerUtil.isOcean(side4)){
         for(Island island : islands){
            if(context.random(island.rarity)==0){
               if(!CommonConfig.blacklistedBiomes.contains(Registry.BIOME.getByValue(island.getBiome()))) {
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
