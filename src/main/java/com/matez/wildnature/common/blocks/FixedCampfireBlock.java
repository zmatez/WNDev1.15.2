package com.matez.wildnature.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.CampfireTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class FixedCampfireBlock extends CampfireBlock {
    public FixedCampfireBlock(Properties propertiesIn) {
        super(propertiesIn);
    }

    @Override
    public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidState) {
        if (!state.get(BlockStateProperties.WATERLOGGED) && fluidState.getFluid() == Fluids.WATER) {
            if (state.get(LIT)) {
                if (worldIn.isRemote()) {
                    for(int i = 0; i < 20; ++i) {
                        spawnSmokeParticles(worldIn.getWorld(), pos, state.get(SIGNAL_FIRE), true);
                    }
                } else {
                    worldIn.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                TileEntity tileentity = worldIn.getTileEntity(pos);

                // Note: added `tileentity.hasWorld()` to prevent worldgen npe
                if (tileentity instanceof CampfireTileEntity && tileentity.hasWorld()) {
                    ((CampfireTileEntity)tileentity).dropAllItems();
                }
            }

            worldIn.setBlockState(pos, state.with(WATERLOGGED, true).with(LIT, false), 3);
            worldIn.getPendingFluidTicks().scheduleTick(pos, fluidState.getFluid(), fluidState.getFluid().getTickRate(worldIn));
            return true;
        } else {
            return false;
        }
    }
}
