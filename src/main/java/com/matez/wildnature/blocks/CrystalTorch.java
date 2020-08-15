package com.matez.wildnature.blocks;

import com.matez.wildnature.registry.ParticleRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class CrystalTorch extends TorchBase {
    public CrystalTorch(Properties properties, ResourceLocation regName) {
        super(properties, regName);
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
        double lvt_5_1_ = (double)p_180655_3_.getX() + 0.5D;
        double lvt_7_1_ = (double)p_180655_3_.getY() + 0.7D;
        double lvt_9_1_ = (double)p_180655_3_.getZ() + 0.5D;
        //p_180655_2_.addParticle(ParticleTypes.SMOKE, lvt_5_1_, lvt_7_1_, lvt_9_1_, 0.0D, 0.0D, 0.0D);
        p_180655_2_.addParticle(ParticleRegistry.CRYSTAL_SPARK, lvt_5_1_, lvt_7_1_, lvt_9_1_, 0.0D, 0.01D, 0.0D);

    }
}
