package com.matez.wildnature.world.gen.carvers;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class WNCaveCarver extends WorldCarver<ProbabilityConfig> {
    public WNCaveCarver(Function<Dynamic<?>, ? extends ProbabilityConfig> p_i49929_1_, int p_i49929_2_) {
        super(p_i49929_1_, p_i49929_2_);
        setRegistryName("wildnature", "cave_carver");
    }

    @Override
    public boolean func_225555_a_(IChunk chunkIn, Function<BlockPos, Biome> biomePos, Random rand, int seaLevel, int chunkX, int chunkZ, int unk1, int unk2, BitSet carvingMask, ProbabilityConfig config) {
        int i = (this.func_222704_c() * 2 - 1) * 16;
        int j = rand.nextInt(rand.nextInt(rand.nextInt(this.func_222724_a()) + 1) + 1);

        for (int k = 0; k < j; ++k) {
            double carveX = chunkX * 16 + rand.nextInt(16);
            double carveY = this.generateCaveStartY(rand);
            double carveZ = chunkZ * 16 + rand.nextInt(16);
            int l = 1;
            if (rand.nextInt(4) == 0) {
                double d3 = 0.5D;
                float f1 = 1.0F + rand.nextFloat() * 6.0F;
                this.func_222723_a(chunkIn, biomePos, rand.nextLong(), seaLevel, unk1, unk2, carveX, carveY, carveZ, f1, 0.5D, carvingMask);
                l += rand.nextInt(4);
            }

            for (int k1 = 0; k1 < l; ++k1) {
                float f = rand.nextFloat() * ((float) Math.PI * 2F);
                float f3 = (rand.nextFloat() - 0.5F) / 4.0F;
                float carveRadius = this.generateCaveRadius(rand);
                int i1 = i - rand.nextInt(i / 4);
                int j1 = 0;
                this.carveTunnel(chunkIn, biomePos, rand.nextLong(), seaLevel, unk1, unk2, carveX, carveY, carveZ, carveRadius, f, f3, 0, i1, this.func_222725_b(), carvingMask);
            }
        }

        return true;
    }

    public boolean shouldCarve(Random rand, int chunkX, int chunkZ, ProbabilityConfig config) {
        return rand.nextFloat() <= config.probability;
    }

    protected int func_222724_a() {
        return 15;
    }

    protected float generateCaveRadius(Random rand) {
        float f = rand.nextFloat() * 4.0F + rand.nextFloat();
        if (rand.nextInt(10) == 0) {
            f *= rand.nextFloat() * rand.nextFloat() * 5.0F + 1.0F;
        }

        return f;
    }

    protected double func_222725_b() {
        return 1.0D;
    }

    protected int generateCaveStartY(Random p_222726_1_) {
        return p_222726_1_.nextInt(p_222726_1_.nextInt(120) + 8);
    }

    protected void func_222723_a(IChunk chunk,Function<BlockPos, Biome> biomeFunc, long p_222723_2_, int p_222723_4_, int p_222723_5_, int p_222723_6_, double p_222723_7_, double p_222723_9_, double p_222723_11_, float p_222723_13_, double p_222723_14_, BitSet p_222723_16_) {
        double d0 = 1.5D + (double) (MathHelper.sin(((float) Math.PI / 2F)) * p_222723_13_);
        double d1 = d0 * p_222723_14_;
        this.func_227208_a_(chunk, biomeFunc,p_222723_2_, p_222723_4_, p_222723_5_, p_222723_6_, p_222723_7_ + 1.0D, p_222723_9_, p_222723_11_, d0, d1, p_222723_16_);
    }

    protected void carveTunnel(IChunk p_227206_1_, Function<BlockPos, Biome> p_227206_2_, long p_227206_3_, int p_227206_5_, int p_227206_6_, int p_227206_7_, double p_227206_8_, double p_227206_10_, double p_227206_12_, float p_227206_14_, float p_227206_15_, float p_227206_16_, int p_227206_17_, int p_227206_18_, double p_227206_19_, BitSet p_227206_21_) {
        Random lvt_22_1_ = new Random(p_227206_3_);
        int lvt_23_1_ = lvt_22_1_.nextInt(p_227206_18_ / 2) + p_227206_18_ / 4;
        boolean lvt_24_1_ = lvt_22_1_.nextInt(6) == 0;
        float lvt_25_1_ = 0.0F;
        float lvt_26_1_ = 0.0F;

        for(int lvt_27_1_ = p_227206_17_; lvt_27_1_ < p_227206_18_; ++lvt_27_1_) {
            double lvt_28_1_ = 1.5D + (double)(MathHelper.sin(3.1415927F * (float)lvt_27_1_ / (float)p_227206_18_) * p_227206_14_);
            double lvt_30_1_ = lvt_28_1_ * p_227206_19_;
            float lvt_32_1_ = MathHelper.cos(p_227206_16_);
            p_227206_8_ += (double)(MathHelper.cos(p_227206_15_) * lvt_32_1_);
            p_227206_10_ += (double)MathHelper.sin(p_227206_16_);
            p_227206_12_ += (double)(MathHelper.sin(p_227206_15_) * lvt_32_1_);
            p_227206_16_ *= lvt_24_1_ ? 0.92F : 0.7F;
            p_227206_16_ += lvt_26_1_ * 0.1F;
            p_227206_15_ += lvt_25_1_ * 0.1F;
            lvt_26_1_ *= 0.9F;
            lvt_25_1_ *= 0.75F;
            lvt_26_1_ += (lvt_22_1_.nextFloat() - lvt_22_1_.nextFloat()) * lvt_22_1_.nextFloat() * 2.0F;
            lvt_25_1_ += (lvt_22_1_.nextFloat() - lvt_22_1_.nextFloat()) * lvt_22_1_.nextFloat() * 4.0F;
            if (lvt_27_1_ == lvt_23_1_ && p_227206_14_ > 1.0F) {
                this.carveTunnel(p_227206_1_, p_227206_2_, lvt_22_1_.nextLong(), p_227206_5_, p_227206_6_, p_227206_7_, p_227206_8_, p_227206_10_, p_227206_12_, lvt_22_1_.nextFloat() * 0.5F + 0.5F, p_227206_15_ - 1.5707964F, p_227206_16_ / 3.0F, lvt_27_1_, p_227206_18_, 1.0D, p_227206_21_);
                this.carveTunnel(p_227206_1_, p_227206_2_, lvt_22_1_.nextLong(), p_227206_5_, p_227206_6_, p_227206_7_, p_227206_8_, p_227206_10_, p_227206_12_, lvt_22_1_.nextFloat() * 0.5F + 0.5F, p_227206_15_ + 1.5707964F, p_227206_16_ / 3.0F, lvt_27_1_, p_227206_18_, 1.0D, p_227206_21_);
                return;
            }

            if (lvt_22_1_.nextInt(4) != 0) {
                if (!this.func_222702_a(p_227206_6_, p_227206_7_, p_227206_8_, p_227206_12_, lvt_27_1_, p_227206_18_, p_227206_14_)) {
                    return;
                }

                this.func_227208_a_(p_227206_1_, p_227206_2_, p_227206_3_, p_227206_5_, p_227206_6_, p_227206_7_, p_227206_8_, p_227206_10_, p_227206_12_, lvt_28_1_, lvt_30_1_, p_227206_21_);
            }
        }

    }

    protected boolean func_222708_a(double p_222708_1_, double p_222708_3_, double p_222708_5_, int p_222708_7_) {
        return p_222708_3_ <= -0.7D || p_222708_1_ * p_222708_1_ + p_222708_3_ * p_222708_3_ + p_222708_5_ * p_222708_5_ >= 1.0D;
    }
}