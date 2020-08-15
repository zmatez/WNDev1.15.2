package com.matez.wildnature.gui.tileEntities;

import com.matez.wildnature.blocks.SteamGeneratorBlock;
import com.matez.wildnature.gui.initGuis;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.registry.ParticleRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class HydrothermalVentTileEntity extends TileEntity implements ITickableTileEntity {
    private Random rand = new Random();
    public HydrothermalVentTileEntity() {
        super(initGuis.HYDROTHERMAL_VENT_TILE_ENTITY);
    }


    @Override
    public void tick() {
        if(world!=null) {
            if (!world.isRemote) {
                if (world.getFluidState(pos.up()).getFluid() == Fluids.WATER && world.getFluidState(pos.up(5)).getFluid() == Fluids.WATER) {
                    steamParticle(pos, world.getBlockState(pos), (ServerWorld) world, rand);
                }
            }
        }
    }



    public void steamParticle(BlockPos oldPos, BlockState state, ServerWorld world, Random random){
        double X = oldPos.getX();
        double Y = oldPos.getY()+0.6;
        double Z = oldPos.getZ();

        double res = 0.02;
        for(int i = 0; i < Utilities.rint(4,10,random); i++) {
            double speedX = Utilities.rdoub(-res,res);
            double speedYBubble = Utilities.rdoub(0.3,2.2);
            double speedY = Utilities.rdoub(0.03,0.06);
            double speedZ = Utilities.rdoub(-res,res);
            SteamGeneratorBlock.spawnParticle(world, ParticleRegistry.THERMAL_SMOKE,X+0.5, Y+0.5, Z+0.5, 1,speedX,speedY,speedZ,0.05);
            SteamGeneratorBlock.spawnParticle(world, ParticleTypes.BUBBLE,X+0.5, Y+0.5, Z+0.5, 1,speedX,speedYBubble,speedZ,0.1);

        }

        world.playSound(null,oldPos.getX(), oldPos.getY(), oldPos.getZ(), SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.4F, (float) Utilities.rdoub(1.1D, 1.5D));

    }
}
