package com.matez.wildnature.world.gen.chunk;

import com.matez.wildnature.commands.LocatePath;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.undergroundBiomes.setup.URBiome;
import com.matez.wildnature.world.gen.undergroundBiomes.setup.URBiomeManager;
import com.matez.wildnature.world.gen.noise.OpenSimplex2S;
import com.matez.wildnature.world.gen.noise.sponge.module.source.Perlin;
import com.matez.wildnature.world.gen.noise.sponge.module.source.RidgedMulti;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.network.DebugPacketSender;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.jigsaw.JigsawJunction;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraftforge.common.BiomeDictionary;

public abstract class WNNoiseChunkGenerator<T extends GenerationSettings> extends ChunkGenerator<T> {
   private static final float[] field_222561_h = Util.make(new float[13824], (p_222557_0_) -> {
      int a = 24;
      int b = 12;
      for(int i = 0; i < a; ++i) {
         for(int j = 0; j < a; ++j) {
            for(int k = 0; k < a; ++k) {
               p_222557_0_[i * a * a + j * a + k] = (float)func_222554_b(j - b, k - b, i - b);
            }
         }
      }

   });
   private static final BlockState AIR = Blocks.AIR.getDefaultState();
   private final int verticalNoiseGranularity;
   private final int horizontalNoiseGranularity;
   private final int noiseSizeX;
   private final int noiseSizeY;
   private final int noiseSizeZ;
   protected final SharedSeedRandom randomSeed;
   private final OctavesNoiseGenerator field_222568_o;
   private final OctavesNoiseGenerator field_222569_p;
   private final OctavesNoiseGenerator field_222570_q;
   private final INoiseGenerator surfaceDepthNoise;
   protected final BlockState defaultBlock;
   protected final BlockState defaultFluid;
   private final OpenSimplex2S pathNoise;
   private double frequency = CommonConfig.pathFrequency.get();

   private final RidgedMulti ridgedMultiNoise;
   private static RidgedMulti ridgedMultiNoiseCopy;
   private final Perlin perlinNoise, biomeNoise;
   private double latestBiomeNoise = -1;


   public WNNoiseChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, int p_i49931_3_, int p_i49931_4_, int p_i49931_5_, T p_i49931_6_, boolean usePerlin) {
      super(worldIn, biomeProviderIn, p_i49931_6_);
      this.verticalNoiseGranularity = p_i49931_4_;
      this.horizontalNoiseGranularity = p_i49931_3_;
      this.defaultBlock = p_i49931_6_.getDefaultBlock();
      this.defaultFluid = p_i49931_6_.getDefaultFluid();
      this.noiseSizeX = 16 / this.horizontalNoiseGranularity;
      this.noiseSizeY = p_i49931_5_ / this.verticalNoiseGranularity;
      this.noiseSizeZ = 16 / this.horizontalNoiseGranularity;
      this.randomSeed = new SharedSeedRandom(this.seed);
      this.field_222568_o = new OctavesNoiseGenerator(this.randomSeed, 16,0);
      this.field_222569_p = new OctavesNoiseGenerator(this.randomSeed, 16,0);
      this.field_222570_q = new OctavesNoiseGenerator(this.randomSeed, 8,0);
      this.surfaceDepthNoise = (INoiseGenerator)(usePerlin ? new PerlinNoiseGenerator(this.randomSeed, 4,0) : new OctavesNoiseGenerator(this.randomSeed, 4,0));
      this.pathNoise =new OpenSimplex2S(worldIn.getSeed());
      this.ridgedMultiNoise =new RidgedMulti();
      ridgedMultiNoise.setSeed((int)worldIn.getSeed());
      ridgedMultiNoise.setFrequency(0.005);
      ridgedMultiNoise.setOctaveCount(1);
      ridgedMultiNoise.setLacunarity(0.0);
      ridgedMultiNoiseCopy = ridgedMultiNoise;
      this.perlinNoise = new Perlin();
      perlinNoise.setSeed((int)worldIn.getSeed());
      perlinNoise.setFrequency(0.1);
      perlinNoise.setOctaveCount(2);
      perlinNoise.setLacunarity(0.0);
      perlinNoise.setPersistence(-0.4);
      this.biomeNoise = new Perlin();
      biomeNoise.setSeed((int)worldIn.getSeed());
      biomeNoise.setFrequency(0.002);
      biomeNoise.setOctaveCount(2);
      biomeNoise.setLacunarity(0.0);
      biomeNoise.setPersistence(0.0);
   }

   public static RidgedMulti getCaveNoise(){
      return ridgedMultiNoiseCopy;
   }

   private double calcNoiseColumn(int p_222552_1_, int p_222552_2_, int p_222552_3_, double coordScale, double heightScale, double p_222552_8_, double p_222552_10_) {
      double d0 = 0.0D;
      double d1 = 0.0D;
      double mainNoiseRegion = 0.0D;
      double d3 = 1.0D;
      double scaleXZ = 0.01;
      double scaleY = 1;

      for(int i = 0; i < 16; ++i) {
         double d4 = OctavesNoiseGenerator.maintainPrecision((double)p_222552_1_ * coordScale * d3);
         double d5 = OctavesNoiseGenerator.maintainPrecision((double)p_222552_2_ * heightScale * d3);
         double d6 = OctavesNoiseGenerator.maintainPrecision((double)p_222552_3_ * coordScale * d3);
         double d7 = heightScale * d3;
         d0 += this.field_222568_o.getOctave(i).func_215456_a(d4, d5, d6, d7, (double)p_222552_2_ * d7) / d3;
         d1 += this.field_222569_p.getOctave(i).func_215456_a(d4, d5, d6, d7, (double)p_222552_2_ * d7) / d3;
         if (i < 8) {
            mainNoiseRegion += this.field_222570_q.getOctave(i).func_215456_a(OctavesNoiseGenerator.maintainPrecision((double)p_222552_1_ * scaleXZ * d3), OctavesNoiseGenerator.maintainPrecision((double)p_222552_2_ * scaleY * d3), OctavesNoiseGenerator.maintainPrecision((double)p_222552_3_ * scaleXZ * d3), p_222552_10_ * d3, (double)p_222552_2_ * p_222552_10_ * d3) / d3;
         }

         d3 /= 2.0D;
      }

      return MathHelper.clampedLerp(d0 / 512.0D, d1 / 512.0D, (mainNoiseRegion / 10.0D + 1.0D) / 2.0D);
   }

   protected double[] func_222547_b(int p_222547_1_, int p_222547_2_) {
      double[] adouble = new double[this.noiseSizeY + 1];
      this.fillNoiseColumn(adouble, p_222547_1_, p_222547_2_);
      return adouble;
   }

   protected void func_222546_a(double[] p_222546_1_, int p_222546_2_, int p_222546_3_, double p_222546_4_, double p_222546_6_, double p_222546_8_, double p_222546_10_, int p_222546_12_, int p_222546_13_) {
      double[] adouble = this.getBiomeNoiseColumn(p_222546_2_, p_222546_3_);
      double d0 = adouble[0];
      double d1 = adouble[1];
      double d2 = this.func_222551_g();
      double d3 = this.func_222553_h();

      for(int i = 0; i < this.func_222550_i(); ++i) {
         double d4 = this.calcNoiseColumn(p_222546_2_, i, p_222546_3_, p_222546_4_, p_222546_6_, p_222546_8_, p_222546_10_);
         d4 = d4 - this.func_222545_a(d0, d1, i);
         if ((double)i > d2) {
            d4 = MathHelper.clampedLerp(d4, (double)p_222546_13_, ((double)i - d2) / (double)p_222546_12_);
         } else if ((double)i < d3) {
            d4 = MathHelper.clampedLerp(d4, -30.0D, (d3 - (double)i) / (d3 - 1.0D));
         }

         p_222546_1_[i] = d4;
      }

   }

   protected abstract double[] getBiomeNoiseColumn(int p_222549_1_, int p_222549_2_);

   protected abstract double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_);

   protected double func_222551_g() {
      return (double)(this.func_222550_i() - 4);
   }

   protected double func_222553_h() {
      return 0.0D;
   }

   public int func_222529_a(int p_222529_1_, int p_222529_2_, Heightmap.Type p_222529_3_) {
      int i = Math.floorDiv(p_222529_1_, this.horizontalNoiseGranularity);
      int j = Math.floorDiv(p_222529_2_, this.horizontalNoiseGranularity);
      int k = Math.floorMod(p_222529_1_, this.horizontalNoiseGranularity);
      int l = Math.floorMod(p_222529_2_, this.horizontalNoiseGranularity);
      double d0 = (double)k / (double)this.horizontalNoiseGranularity;
      double d1 = (double)l / (double)this.horizontalNoiseGranularity;
      double[][] adouble = new double[][]{this.func_222547_b(i, j), this.func_222547_b(i, j + 1), this.func_222547_b(i + 1, j), this.func_222547_b(i + 1, j + 1)};
      int i1 = this.getSeaLevel();

      for(int j1 = this.noiseSizeY - 1; j1 >= 0; --j1) {
         double d2 = adouble[0][j1];
         double d3 = adouble[1][j1];
         double d4 = adouble[2][j1];
         double d5 = adouble[3][j1];
         double d6 = adouble[0][j1 + 1];
         double d7 = adouble[1][j1 + 1];
         double d8 = adouble[2][j1 + 1];
         double d9 = adouble[3][j1 + 1];

         for(int k1 = this.verticalNoiseGranularity - 1; k1 >= 0; --k1) {
            double d10 = (double)k1 / (double)this.verticalNoiseGranularity;
            double d11 = MathHelper.lerp3(d10, d0, d1, d2, d6, d4, d8, d3, d7, d5, d9);
            int l1 = j1 * this.verticalNoiseGranularity + k1;
            if (d11 > 0.0D || l1 < i1) {
               BlockState blockstate;
               if (d11 > 0.0D) {
                  blockstate = this.defaultBlock;
               } else {
                  blockstate = this.defaultFluid;
               }

               if (p_222529_3_.getHeightLimitPredicate().test(blockstate)) {
                  return l1 + 1;
               }
            }
         }
      }

      return 0;
   }

   protected abstract void fillNoiseColumn(double[] p_222548_1_, int p_222548_2_, int p_222548_3_);
   public static double maxNoise = 0;
   public int func_222550_i() {
      return this.noiseSizeY + 1;
   }
   public Random random = new Random(seed);

   public void generateSurface(WorldGenRegion worldGenRegion, IChunk chunkIn) {
      ChunkPos chunkpos = chunkIn.getPos();
      int i = chunkpos.x;
      int j = chunkpos.z;
      SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
      sharedseedrandom.setBaseChunkSeed(i, j);
      ChunkPos chunkpos1 = chunkIn.getPos();
      int xChunkPos = chunkpos1.getXStart();
      int zChunkPos = chunkpos1.getZStart();
      double d0 = 0.0625D;
      BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();


      for(int relativeX = 0; relativeX < 16; ++relativeX) {
         for(int relativeZ = 0; relativeZ < 16; ++relativeZ) {
            int x = xChunkPos + relativeX;
            int z = zChunkPos + relativeZ;
            int startHeight = chunkIn.getTopBlockY(Heightmap.Type.WORLD_SURFACE_WG, relativeX, relativeZ) + 1;
            double d1 = this.surfaceDepthNoise.noiseAt((double)x * 0.0625D, (double)z * 0.0625D, 0.0625D, (double)startHeight * 0.0625D) * 15.0D;

            Biome biome = worldGenRegion.getBiome(blockpos$mutable.setPos(xChunkPos + relativeX, startHeight, zChunkPos + relativeZ));
            biome.buildSurface(sharedseedrandom, chunkIn, x, z, startHeight, d1, this.getSettings().getDefaultBlock(), this.getSettings().getDefaultFluid(), this.getSeaLevel(), this.world.getSeed());

            if(CommonConfig.generatePaths.get()) {
               double[] noises = getPathNoise(x,z,0.005, 0.01, 0.001,50,1);
               double vnoise = noises[0];
               double cnoise = noises[1];


               if (vnoise != 1) {
                  if (BiomeDictionary.getTypes(biome).contains(BiomeDictionary.Type.FOREST) && BiomeDictionary.getTypes(biome).contains(BiomeDictionary.Type.DENSE)) {
                     int pathY = startHeight;
                     //double amountToPushTerrainDownBy = 1 - vnoise / threshold;
                     Block theme = biome.getSurfaceBuilderConfig().getTop().getBlock();

                     BlockState b = chunkIn.getBlockState(new BlockPos(x, startHeight - 1, z));
                     Block toPlace = null;
                     if (b.getBlock() == WNBlocks.MOLD_GRASS_BLOCK) {
                        toPlace = WNBlocks.MOLD_GRASS_PATH;
                     } else if (b.getBlock() == WNBlocks.BROWN_GRASS_BLOCK) {
                        toPlace = WNBlocks.BROWN_GRASS_PATH;
                     } else if (b.getBlock() == WNBlocks.DRIED_GRASS_BLOCK) {
                        toPlace = WNBlocks.DRIED_GRASS_PATH;
                     } else if (b.getBlock() == WNBlocks.DESERT_GRASS_BLOCK) {
                        toPlace = WNBlocks.DESERT_GRASS_PATH;
                     } else if (b.getBlock() == WNBlocks.TROPICAL_GRASS_BLOCK) {
                        toPlace = WNBlocks.TROPICAL_GRASS_PATH;
                     } else if (b.getBlock() == WNBlocks.BROWN_PODZOL) {
                        toPlace = WNBlocks.BROWN_GRASS_PATH;
                     } else if (b.getBlock() == Blocks.GRASS_BLOCK) {
                        toPlace = Blocks.GRASS_PATH;
                     } else if (b.getBlock() == Blocks.PODZOL) {
                        if (theme == WNBlocks.MOLD_GRASS_BLOCK) {
                           toPlace = WNBlocks.MOLD_GRASS_PATH;
                        } else if (theme == WNBlocks.BROWN_GRASS_BLOCK) {
                           toPlace = WNBlocks.BROWN_GRASS_PATH;
                        } else if (theme == WNBlocks.DRIED_GRASS_BLOCK) {
                           toPlace = WNBlocks.DRIED_GRASS_PATH;
                        } else if (theme == WNBlocks.DESERT_GRASS_BLOCK) {
                           toPlace = WNBlocks.DESERT_GRASS_PATH;
                        } else if (theme == WNBlocks.TROPICAL_GRASS_BLOCK) {
                           toPlace = WNBlocks.TROPICAL_GRASS_PATH;
                        } else if (theme == WNBlocks.BROWN_PODZOL) {
                           toPlace = WNBlocks.BROWN_GRASS_PATH;
                        } else {
                           toPlace = Blocks.GRASS_PATH;
                        }
                     } else if (b.getBlock() == Blocks.COARSE_DIRT) {
                        if (theme == WNBlocks.MOLD_GRASS_BLOCK) {
                           toPlace = WNBlocks.MOLD_GRASS_PATH;
                        } else if (theme == WNBlocks.BROWN_GRASS_BLOCK) {
                           toPlace = WNBlocks.BROWN_GRASS_PATH;
                        } else if (theme == WNBlocks.DRIED_GRASS_BLOCK) {
                           toPlace = WNBlocks.DRIED_GRASS_PATH;
                        } else if (theme == WNBlocks.DESERT_GRASS_BLOCK) {
                           toPlace = WNBlocks.DESERT_GRASS_PATH;
                        } else if (theme == WNBlocks.TROPICAL_GRASS_BLOCK) {
                           toPlace = WNBlocks.TROPICAL_GRASS_PATH;
                        } else if (theme == WNBlocks.BROWN_PODZOL) {
                           toPlace = WNBlocks.BROWN_GRASS_PATH;
                        } else {
                           toPlace = Blocks.GRASS_PATH;
                        }
                     }

                     if (toPlace != null) {
                        if (Utilities.rint(0, 5) != 0) {
                           chunkIn.setBlockState(new BlockPos(x, pathY - 1, z), toPlace.getDefaultState(), false);
                        }
                        if (Utilities.rint(0, 15) == 0) {
                           chunkIn.setBlockState(new BlockPos(x, pathY - 1, z), Blocks.GRAVEL.getDefaultState(), false);
                        }
                        if (Utilities.rint(0, 30) == 0) {
                           LocatePath.paths.add(new BlockPos(x, pathY, z));
                        }
                     }

                  }
               }
            }

            //underwaterRivers
            if(CommonConfig.generateUndergroundRivers.get()) {
               URBiome riverBiome = URBiomeManager.getBiomeAt(chunkIn,new BlockPos(x,1,z),world.getSeed());

               double vnoise = ridgedMultiNoise.getValue(x, 1, z);
               if (vnoise >= 0.60 && vnoise <= 2) {
                  BlockPos pos = new BlockPos(x, 13, z);
                  int height = riverBiome.getNoiseHeight(vnoise, 0.60,  0.625,1, 10,17,0.63,random,seed,pos);
                  if(height==10 || height==9){
                     double pnoise = perlinNoise.getValue(x, 1, z);
                     if(pnoise>=0.3){
                        height=height+1;
                        if(pnoise>=0.38){
                           height=height+1;
                        }
                     }else if(pnoise<0.16){
                        height=height-1;
                     }
                  }
                  int startPointY = -(int) height / 2;//pos.y - startPointY -> block being set
                  for (int a = pos.getY() - startPointY; a > pos.getY() - height; a--) {
                     if (a > 10) {
                        chunkIn.setBlockState(new BlockPos(pos.getX(), a, pos.getZ()), Blocks.CAVE_AIR.getDefaultState(), false);
                     } else {
                        chunkIn.setBlockState(new BlockPos(pos.getX(), a, pos.getZ()), Blocks.WATER.getDefaultState(), false);

                     }

                  }
               }

               if (vnoise >= 0.58 && vnoise <= 2) {
                  BlockPos pos = new BlockPos(x, 13, z);
                  if((riverBiome.getElevationBlock(seed,random,pos).getBlock()!=Blocks.STONE || riverBiome.getUnderwaterBlock(seed,random,pos).getBlock()!=Blocks.STONE)) {

                     int height = riverBiome.getNoiseHeight(vnoise, 0.59, 0.635, 1, 13,17,0.64,random,seed,pos);
                     int startPointY = -(int) height / 2;//pos.y - startPointY -> block being set
                     for (int a = pos.getY() - startPointY; a > pos.getY() - height; a--) {
                        riverBiome.elevate(pos,a,chunkIn,random,seed);
                     }
                  }
               }
            }
         }
      }

      this.makeBedrock(chunkIn, sharedseedrandom);
   }

   /**
    *
    * @param x x
    * @param z z
    * @param freq frequency, def 0.005
    * @param threshold def 0.01
    * @param noiseMultiplier def 50
    * @return noise, centerNoise
    */
   private double[] getPathNoise(int x, int z, double freq, double threshold, double centerThreshold, double noiseMultiplier, double centerNoiseMultiplier){
      OpenSimplex2S.Values2D1 results = new OpenSimplex2S.Values2D1();
      pathNoise.noise2(x* freq, z* freq, results);

      double slope = Math.sqrt(results.dx*results.dx + results.dy*results.dy);
      double estDistanceToZero = Math.abs(results.value / slope);
      double vnoise = 1;
      if (estDistanceToZero < threshold) {
         vnoise = -(estDistanceToZero*noiseMultiplier);
      };
      double cnoise = 1;
      if (estDistanceToZero < centerThreshold) {
         cnoise = -(estDistanceToZero*centerNoiseMultiplier);
      };
      return new double[]{vnoise,cnoise};
   }

   private int getMaxHeightNearPathBlock(int x, int y, int z, IChunk chunk){
      int highest = 0;
      int terrainPosDiffCheck = 4;
      for(int i = 0; i < 4; i++){
         int xChange = 0;
         int zChange = 0;

         if(i ==0){
            xChange = terrainPosDiffCheck;
         }else if(i == 1){
            xChange = -terrainPosDiffCheck;
         }else if(i == 2){
            zChange = terrainPosDiffCheck;
         }else {
            zChange = -terrainPosDiffCheck;
         }
         int rx = x + xChange;
         int rz = z + zChange;

         if(ridgedMultiNoise.getValue(rx, 1, rz) >= 0.62 && ridgedMultiNoise.getValue(rx, 1, rz) <= 0.65) {

            if (rx >= chunk.getPos().getXStart() && rz >= chunk.getPos().getZStart() && rx < chunk.getPos().getXStart() + 16 && rx < chunk.getPos().getZStart() + 16) {
               for (int ty = (highest == 0 ? y : highest); ty > 0 && ty <= 256; ty++) {
                  if (chunk.getBlockState(new BlockPos(rx, ty, rz)).isSolid()) {
                     if (ty > highest) {
                        highest = ty;
                        break;
                     }
                  }
               }
            }
         }
      }
      return highest == 0 ? y : highest;
   }

   private int getMinHeightNearPathBlock(int x, int y, int z, IChunk chunk){
      int lowest = 256;
      int terrainPosDiffCheck = 4;
      for(int i = 0; i < 4; i++){
         int xChange = 0;
         int zChange = 0;

         if(i ==0){
            xChange = terrainPosDiffCheck;
         }else if(i == 1){
            xChange = -terrainPosDiffCheck;
         }else if(i == 2){
            zChange = terrainPosDiffCheck;
         }else {
            zChange = -terrainPosDiffCheck;
         }
         int rx = x + xChange;
         int rz = z + zChange;
         if(ridgedMultiNoise.getValue(rx, 1, rz) >= 0.62 && ridgedMultiNoise.getValue(rx, 1, rz) <= 0.65) {

            if (rx >= chunk.getPos().getXStart() && rz >= chunk.getPos().getZStart() && rx < chunk.getPos().getXStart() + 16 && rx < chunk.getPos().getZStart() + 16) {
               for (int ty = (lowest == 256 ? y : lowest); ty > 0 && ty <= 256; ty--) {
                  if (chunk.getBlockState(new BlockPos(rx, ty, rz)).isSolid() && chunk.getBlockState(new BlockPos(rx, ty + 1, rz)).isAir()) {
                     if (ty < lowest) {
                        lowest = ty;
                        break;
                     }
                  }
               }
            }
         }
      }
      return lowest == 256 ? y : lowest;
   }

   /**
    *
    * @param noise actual noise, example: 29.23141283 (?%)
    * @param minNoise minimal noise, example: 28.0 (its 0%)
    * @param maxNoise maximal noise, example: 29.999999 (its 100%)
    * @param minHeight min height example: 1
    * @param maxHeight max height example: 6
    * @return
    */
   private int calculateHeight(double noise, double minNoise, double maxNoise, int minHeight, int maxHeight){
      double maxNoiseCalc = maxNoise-minNoise;//1.999999
      double noiseCalc = noise-minNoise;//1.23141283
      double noisePercent = noiseCalc/maxNoiseCalc;//0.61(%)

      int maxHeightCalc = maxHeight-minHeight;//5
      double height = maxHeightCalc*noisePercent;//3.05

      return (int)Math.round(height)+minHeight;//4.05 - returns 4
   }

   /**
    *
    * @param noise actual noise, example: 29.23141283 (?%)
    * @param minNoise minimal noise, example: 28.0 (its 0%)
    * @param maxNoise maximal noise, example: 29.999999 (its 100%)
    * @param minHeight min height example: 1
    * @param maxHeight max height example: 6
    * @return
    */
   private int calculateHeightByCenter(double noise, double minNoise, double maxNoise, int minHeight, int maxHeight){
      double noiseCenter = ((maxNoise-minNoise)/2)+minNoise;//28.99999995
      double noisePercent = 0;

      if(noiseCenter>noise) {
         noisePercent = calculatePercent(noise, minNoise, noiseCenter);
      }else if(noiseCenter<noise){
         noisePercent = calculatePercent(noise, maxHeight, noiseCenter);
      }else{
         noisePercent = 1;
      }

      int maxHeightCalc = maxHeight-minHeight;//5
      double height = maxHeightCalc*noisePercent;//3.05

      return (int)Math.round(height)+minHeight;//4.05 - returns 4
   }

   private double calculatePercent(double noise, double minNoise, double maxNoise) {
      double maxNoiseCalc = maxNoise - minNoise;//1.999999
      double noiseCalc = noise - minNoise;//1.23141283
      return noiseCalc / maxNoiseCalc;//0.61(%)
   }

   protected void makeBedrock(IChunk chunkIn, Random rand) {
      BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
      int i = chunkIn.getPos().getXStart();
      int j = chunkIn.getPos().getZStart();
      T t = this.getSettings();
      int k = t.getBedrockFloorHeight();
      int l = t.getBedrockRoofHeight();

      for(BlockPos blockpos : BlockPos.getAllInBoxMutable(i, 0, j, i + 15, 0, j + 15)) {
         if (l > 0) {
            for(int i1 = l; i1 >= l - 4; --i1) {
               if (i1 >= l - rand.nextInt(5)) {
                  chunkIn.setBlockState(blockpos$mutableblockpos.setPos(blockpos.getX(), i1, blockpos.getZ()), Blocks.BEDROCK.getDefaultState(), false);
               }
            }
         }

         if (k < 256) {
            for(int j1 = k + 4; j1 >= k; --j1) {
               if (j1 <= k + rand.nextInt(5)) {
                  chunkIn.setBlockState(blockpos$mutableblockpos.setPos(blockpos.getX(), j1, blockpos.getZ()), Blocks.BEDROCK.getDefaultState(), false);
               }
            }
         }
      }

   }

   public void makeBase(IWorld worldIn, IChunk chunkIn) {
      int i = this.getSeaLevel();
      ObjectList<AbstractVillagePiece> objectlist = new ObjectArrayList<>(10);
      ObjectList<JigsawJunction> objectlist1 = new ObjectArrayList<>(32);
      ChunkPos chunkpos = chunkIn.getPos();
      int j = chunkpos.x;
      int k = chunkpos.z;
      int l = j << 4;
      int i1 = k << 4;

      for(Structure<?> structure : Feature.ILLAGER_STRUCTURES) {
         String s = structure.getStructureName();
         LongIterator longiterator = chunkIn.getStructureReferences(s).iterator();

         while(longiterator.hasNext()) {
            long j1 = longiterator.nextLong();
            ChunkPos chunkpos1 = new ChunkPos(j1);
            IChunk ichunk = worldIn.getChunk(chunkpos1.x, chunkpos1.z);
            StructureStart structurestart = ichunk.getStructureStart(s);
            if (structurestart != null && structurestart.isValid()) {
               for(StructurePiece structurepiece : structurestart.getComponents()) {
                  if (structurepiece.func_214810_a(chunkpos, 12) && structurepiece instanceof AbstractVillagePiece) {
                     AbstractVillagePiece abstractvillagepiece = (AbstractVillagePiece)structurepiece;
                     JigsawPattern.PlacementBehaviour jigsawpattern$placementbehaviour = abstractvillagepiece.getJigsawPiece().getPlacementBehaviour();
                     if (jigsawpattern$placementbehaviour == JigsawPattern.PlacementBehaviour.RIGID) {
                        objectlist.add(abstractvillagepiece);
                     }

                     for(JigsawJunction jigsawjunction : abstractvillagepiece.getJunctions()) {
                        int k1 = jigsawjunction.getSourceX();
                        int l1 = jigsawjunction.getSourceZ();
                        if (k1 > l - 12 && l1 > i1 - 12 && k1 < l + 15 + 12 && l1 < i1 + 15 + 12) {
                           objectlist1.add(jigsawjunction);
                        }
                     }
                  }
               }
            }
         }
      }

      double[][][] adouble = new double[2][this.noiseSizeZ + 1][this.noiseSizeY + 1];

      for(int j5 = 0; j5 < this.noiseSizeZ + 1; ++j5) {
         adouble[0][j5] = new double[this.noiseSizeY + 1];
         this.fillNoiseColumn(adouble[0][j5], j * this.noiseSizeX, k * this.noiseSizeZ + j5);
         adouble[1][j5] = new double[this.noiseSizeY + 1];
      }

      ChunkPrimer chunkprimer = (ChunkPrimer)chunkIn;
      Heightmap heightmap = chunkprimer.getHeightmap(Heightmap.Type.OCEAN_FLOOR_WG);
      Heightmap heightmap1 = chunkprimer.getHeightmap(Heightmap.Type.WORLD_SURFACE_WG);
      BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
      ObjectListIterator<AbstractVillagePiece> objectlistiterator = objectlist.iterator();
      ObjectListIterator<JigsawJunction> objectlistiterator1 = objectlist1.iterator();

      for(int k5 = 0; k5 < this.noiseSizeX; ++k5) {
         for(int l5 = 0; l5 < this.noiseSizeZ + 1; ++l5) {
            this.fillNoiseColumn(adouble[1][l5], j * this.noiseSizeX + k5 + 1, k * this.noiseSizeZ + l5);
         }

         for(int i6 = 0; i6 < this.noiseSizeZ; ++i6) {
            ChunkSection chunksection = chunkprimer.getSection(15);
            chunksection.lock();

            for(int j6 = this.noiseSizeY - 1; j6 >= 0; --j6) {
               double d16 = adouble[0][i6][j6];
               double d17 = adouble[0][i6 + 1][j6];
               double d18 = adouble[1][i6][j6];
               double d0 = adouble[1][i6 + 1][j6];
               double d1 = adouble[0][i6][j6 + 1];
               double d2 = adouble[0][i6 + 1][j6 + 1];
               double d3 = adouble[1][i6][j6 + 1];
               double d4 = adouble[1][i6 + 1][j6 + 1];

               for(int i2 = this.verticalNoiseGranularity - 1; i2 >= 0; --i2) {
                  int j2 = j6 * this.verticalNoiseGranularity + i2;
                  int k2 = j2 & 15;
                  int l2 = j2 >> 4;
                  if (chunksection.getYLocation() >> 4 != l2) {
                     chunksection.unlock();
                     chunksection = chunkprimer.getSection(l2);
                     chunksection.lock();
                  }

                  double d5 = (double)i2 / (double)this.verticalNoiseGranularity;
                  double d6 = MathHelper.lerp(d5, d16, d1);
                  double d7 = MathHelper.lerp(d5, d18, d3);
                  double d8 = MathHelper.lerp(d5, d17, d2);
                  double d9 = MathHelper.lerp(d5, d0, d4);

                  for(int i3 = 0; i3 < this.horizontalNoiseGranularity; ++i3) {
                     int j3 = l + k5 * this.horizontalNoiseGranularity + i3;
                     int k3 = j3 & 15;
                     double d10 = (double)i3 / (double)this.horizontalNoiseGranularity;
                     double d11 = MathHelper.lerp(d10, d6, d7);
                     double d12 = MathHelper.lerp(d10, d8, d9);

                     for(int l3 = 0; l3 < this.horizontalNoiseGranularity; ++l3) {
                        int i4 = i1 + i6 * this.horizontalNoiseGranularity + l3;
                        int j4 = i4 & 15;
                        double d13 = (double)l3 / (double)this.horizontalNoiseGranularity;
                        double d14 = MathHelper.lerp(d13, d11, d12);
                        double d15 = MathHelper.clamp(d14 / 200.0D, -1.0D, 1.0D);

                        int k4;
                        int l4;
                        int i5;
                        for(d15 = d15 / 2.0D - d15 * d15 * d15 / 24.0D; objectlistiterator.hasNext(); d15 += func_222556_a(k4, l4, i5) * 0.8D) {
                           AbstractVillagePiece abstractvillagepiece1 = objectlistiterator.next();
                           MutableBoundingBox mutableboundingbox = abstractvillagepiece1.getBoundingBox();
                           k4 = Math.max(0, Math.max(mutableboundingbox.minX - j3, j3 - mutableboundingbox.maxX));
                           l4 = j2 - (mutableboundingbox.minY + abstractvillagepiece1.getGroundLevelDelta());
                           i5 = Math.max(0, Math.max(mutableboundingbox.minZ - i4, i4 - mutableboundingbox.maxZ));
                        }

                        objectlistiterator.back(objectlist.size());

                        while(objectlistiterator1.hasNext()) {
                           JigsawJunction jigsawjunction1 = objectlistiterator1.next();
                           int k6 = j3 - jigsawjunction1.getSourceX();
                           k4 = j2 - jigsawjunction1.getSourceGroundY();
                           l4 = i4 - jigsawjunction1.getSourceZ();
                           d15 += func_222556_a(k6, k4, l4) * 0.4D;
                        }

                        objectlistiterator1.back(objectlist1.size());
                        BlockState blockstate;
                        if (d15 > 0.0D) {
                           blockstate = this.defaultBlock;
                        } else if (j2 < i) {
                           blockstate = this.defaultFluid;
                        } else {
                           blockstate = AIR;
                        }

                        if (blockstate != AIR) {
                           if (blockstate.getLightValue() != 0) {
                              blockpos$mutableblockpos.setPos(j3, j2, i4);
                              chunkprimer.addLightPosition(blockpos$mutableblockpos);
                           }

                           chunksection.setBlockState(k3, k2, j4, blockstate, false);
                           heightmap.update(k3, j2, j4, blockstate);
                           heightmap1.update(k3, j2, j4, blockstate);
                        }
                     }
                  }
               }
            }

            chunksection.unlock();
         }

         double[][] adouble1 = adouble[0];
         adouble[0] = adouble[1];
         adouble[1] = adouble1;
      }

   }

   private static double func_222556_a(int p_222556_0_, int p_222556_1_, int p_222556_2_) {
      int i = p_222556_0_ + 12;
      int j = p_222556_1_ + 12;
      int k = p_222556_2_ + 12;
      if (i >= 0 && i < 24) {
         if (j >= 0 && j < 24) {
            return k >= 0 && k < 24 ? (double)field_222561_h[k * 24 * 24 + i * 24 + j] : 0.0D;
         } else {
            return 0.0D;
         }
      } else {
         return 0.0D;
      }
   }

   private static double func_222554_b(int p_222554_0_, int p_222554_1_, int p_222554_2_) {
      double d0 = (double)(p_222554_0_ * p_222554_0_ + p_222554_2_ * p_222554_2_);
      double d1 = (double)p_222554_1_ + 0.5D;
      double d2 = d1 * d1;
      double d3 = Math.pow(Math.E, -(d2 / 16.0D + d0 / 16.0D));
      double d4 = -d1 * MathHelper.fastInvSqrt(d2 / 2.0D + d0 / 2.0D) / 2.0D;
      return d4 * d3;
   }

   public void generateStructureStarts(IWorld worldIn, IChunk chunkIn) {
      int i = 8;
      int j = chunkIn.getPos().x;
      int k = chunkIn.getPos().z;
      int l = j << 4;
      int i1 = k << 4;

      for(int j1 = j - 8; j1 <= j + 8; ++j1) {
         for(int k1 = k - 8; k1 <= k + 8; ++k1) {
            long l1 = ChunkPos.asLong(j1, k1);

            for(Map.Entry<String, StructureStart> entry : worldIn.getChunk(j1, k1).getStructureStarts().entrySet()) {
               StructureStart structurestart = entry.getValue();
               if (structurestart != StructureStart.DUMMY && structurestart.getBoundingBox().intersectsWith(l, i1, l + 15, i1 + 15)) {
                  chunkIn.addStructureReference(entry.getKey(), l1);
                  DebugPacketSender.sendStructureStart(worldIn, structurestart);
               }
            }
         }
      }

   }
}