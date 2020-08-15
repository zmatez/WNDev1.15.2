package com.matez.wildnature.world.gen.biomes.layer;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;
import net.minecraftforge.common.BiomeManager;

public enum FuzzedBiomeMagnifier implements IAreaTransformer1 {
   INSTANCE;

   private int seed;
   boolean seedSet = false;

   public int func_215728_a(IExtendedNoiseRandom<?> noise, IArea area, int x, int z) {
      if(!seedSet){
         seed = noise.random(1);
         seedSet=true;
      }
      int y = 0;
      int i = x - 2;
      int j = y - 2;
      int k = z - 2;
      int l = i >> 2;
      int i1 = j >> 2;
      int j1 = k >> 2;
      double d0 = (double)(i & 3) / 4.0D;
      double d1 = (double)(j & 3) / 4.0D;
      double d2 = (double)(k & 3) / 4.0D;
      double[] adouble = new double[8];

      for(int k1 = 0; k1 < 8; ++k1) {
         boolean flag = (k1 & 4) == 0;
         boolean flag1 = (k1 & 2) == 0;
         boolean flag2 = (k1 & 1) == 0;
         int l1 = flag ? l : l + 1;
         int i2 = flag1 ? i1 : i1 + 1;
         int j2 = flag2 ? j1 : j1 + 1;
         double d3 = flag ? d0 : d0 - 1.0D;
         double d4 = flag1 ? d1 : d1 - 1.0D;
         double d5 = flag2 ? d2 : d2 - 1.0D;
         adouble[k1] = func_226845_a_(seed, l1, i2, j2, d3, d4, d5);
      }

      int k2 = 0;
      double d6 = adouble[0];

      for(int l2 = 1; l2 < 8; ++l2) {
         if (d6 > adouble[l2]) {
            k2 = l2;
            d6 = adouble[l2];
         }
      }

      int finalX = (k2 & 4) == 0 ? l : l + 1;
      int finalY = (k2 & 2) == 0 ? i1 : i1 + 1;
      int finalZ = (k2 & 1) == 0 ? j1 : j1 + 1;
      return area.getValue(finalX, finalZ);
   }

   private static double func_226845_a_(int seed, int p_226845_2_, int p_226845_3_, int p_226845_4_, double p_226845_5_, double p_226845_7_, double p_226845_9_) {
      long lvt_11_1_ = mix(seed, (long)p_226845_2_);
      lvt_11_1_ = mix(lvt_11_1_, (long)p_226845_3_);
      lvt_11_1_ = mix(lvt_11_1_, (long)p_226845_4_);
      lvt_11_1_ = mix(lvt_11_1_, (long)p_226845_2_);
      lvt_11_1_ = mix(lvt_11_1_, (long)p_226845_3_);
      lvt_11_1_ = mix(lvt_11_1_, (long)p_226845_4_);
      double d0 = func_226844_a_(lvt_11_1_);
      lvt_11_1_ = mix(lvt_11_1_, seed);
      double d1 = func_226844_a_(lvt_11_1_);
      lvt_11_1_ = mix(lvt_11_1_, seed);
      double d2 = func_226844_a_(lvt_11_1_);
      return func_226843_a_(p_226845_9_ + d2) + func_226843_a_(p_226845_7_ + d1) + func_226843_a_(p_226845_5_ + d0);
   }

   private static double func_226844_a_(long p_226844_0_) {
      double d0 = (double)((int)Math.floorMod(p_226844_0_ >> 24, 1024L)) / 1024.0D;
      return (d0 - 0.5D) * 0.9D;
   }

   private static double func_226843_a_(double p_226843_0_) {
      return p_226843_0_ * p_226843_0_;
   }

   public int func_215721_a(int p_215721_1_) {
      return p_215721_1_ >> 2;
   }

   public int func_215722_b(int p_215722_1_) {
      return p_215722_1_ >> 2;
   }

   public static long mix(long p_226162_0_, long p_226162_2_) {
      p_226162_0_ = p_226162_0_ * (p_226162_0_ * 6364136223846793005L + 1442695040888963407L);
      p_226162_0_ = p_226162_0_ + p_226162_2_;
      return p_226162_0_;
   }

}