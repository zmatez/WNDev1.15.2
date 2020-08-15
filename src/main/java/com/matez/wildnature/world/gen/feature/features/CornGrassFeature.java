package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.CornPlant;
import com.matez.wildnature.other.Utilities;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class CornGrassFeature extends Feature<NoFeatureConfig> {
    public CornGrassFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49884_1_) {
        super(p_i49884_1_);
        setRegistryName("wildnature","corn_grass_feature");
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if(!worldIn.getDimension().isSurfaceWorld()){
            return false;
        }
        boolean flag = false;

        for(int i = 0; i < 128; ++i) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            if (worldIn.isAirBlock(blockpos) && blockpos.getY() < worldIn.getWorld().getDimension().getHeight() - 2 && Main.getBlockByID("wildnature:corn_bush").getDefaultState().with(CornPlant.STAGE, 0).isValidPosition(worldIn, blockpos)) {
                int stage = Utilities.rint(1,2);
                worldIn.setBlockState(blockpos, Main.getBlockByID("wildnature:corn_bush").getDefaultState().with(CornPlant.STAGE, stage),2);
                worldIn.setBlockState(blockpos.up(), Main.getBlockByID("wildnature:corn_bush").getDefaultState().with(CornPlant.STAGE, stage),2);
                worldIn.setBlockState(blockpos.up(2), Main.getBlockByID("wildnature:corn_bush").getDefaultState().with(CornPlant.STAGE, stage),2);
                worldIn.setBlockState(blockpos.up(3), Main.getBlockByID("wildnature:corn_bush").getDefaultState().with(CornPlant.STAGE, stage),2);
                worldIn.setBlockState(blockpos.up(4), Main.getBlockByID("wildnature:corn_bush").getDefaultState().with(CornPlant.STAGE, 0),2);

                flag = true;
            }
        }

        return flag;
    }
}