package com.matez.wildnature.blocks;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class ChandelierBase extends BlockBase implements IRenderLayer {
    int type = 0;
    public ChandelierBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
        if(regName.toString().contains("wood")){
            type=1;
        }else if(regName.toString().contains("crystal")){
            type=2;
        }
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.up()).isSolid();
    }

    @Override
    public BlockState updatePostPlacement(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
        if(isValidPosition(p_196271_1_,p_196271_4_,p_196271_5_)){
            return p_196271_1_;
        }else{
            return Blocks.AIR.getDefaultState();
        }
    }

    @Override
    public boolean isTransparent(BlockState p_220074_1_) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double d0 = (double) pos.getX();
        double d1 = (double) pos.getY();
        double d2 = (double) pos.getZ();
        if (Utilities.rint(0, 5, rand) == 0) {
            worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
        //worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
}
