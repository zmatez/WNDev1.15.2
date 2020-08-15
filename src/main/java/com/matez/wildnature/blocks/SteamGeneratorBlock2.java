package com.matez.wildnature.blocks;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.registry.ParticleRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class SteamGeneratorBlock2 extends SteamGeneratorBlock {
    public SteamGeneratorBlock2(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    @Override
    public void steamParticle(BlockPos oldPos, BlockState state, ServerWorld world, Random random){
        Direction direction = state.get(FACING);
        double X = offset(oldPos,direction,0.6).getX();
        double Y = offset(oldPos,direction,0.6).getY();
        double Z = offset(oldPos,direction,0.6).getZ();


        double dividerY = 0.15;
        double res = 0.08;
        for(int i = 0; i < Utilities.rint(20,60,random); i++) {
            double divider = Utilities.rdoub(0.4,1.1);
            double speedX = -((oldPos.getX()-X)/divider)+ Utilities.rdoub(-res,res);
            double speedY = -((oldPos.getY()-Y)/divider)+ Utilities.rdoub(-0.02,dividerY);
            double speedZ = -((oldPos.getZ()-Z)/divider)+ Utilities.rdoub(-res,res);
            spawnParticle(world,ParticleRegistry.STEAM,X+0.5, Y+0.5, Z+0.5, 1,speedX,speedY,speedZ,0.1);


        }
    }
}
