package com.matez.wildnature.gui.tileEntities;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.GravityShroom;
import com.matez.wildnature.blocks.SteamGeneratorBlock;
import com.matez.wildnature.gui.initGuis;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.registry.ParticleRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class GravityShroomTileEntity extends TileEntity implements ITickableTileEntity {
    private Random rand = new Random();
    public GravityShroomTileEntity() {
        super(initGuis.GRAVITY_SHROOM_TILE_ENTITY);
    }


    @Override
    public void tick() {
        if (world != null && pos !=null) {
            if (!world.isRemote && world.isAreaLoaded(pos, 10)) {
                PlayerEntity p = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ());
                if (p != null && !p.isSpectator()) {
                    if (Utilities.getDistance(p.getPosition(), pos) <= 7) {
                        if (world.getBlockState(pos).getBlock() instanceof GravityShroom && !world.getBlockState(pos).get(GravityShroom.GRAVITY)) {
                            world.setBlockState(pos, world.getBlockState(pos).with(GravityShroom.GRAVITY, true));
                        }
                        /*if(!(world.getBlockState(pos.down()).isAir() && world.getBlockState(pos.down(2)).isAir() && world.getBlockState(pos.down(3)).isAir())) {
                            p.setMotion(p.getMotion().getX(),10.0d,p.getMotion().getZ());
                        }*/
                        if(p.getActivePotionEffect(Effects.GLOWING)==null) {
                            p.setGlowing(true);
                        }
                        p.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST,1,252,true,false));

                        steamParticle(p.getPositionVector(), null, (ServerWorld) world, rand);
                    } else {
                        if(p.getActivePotionEffect(Effects.GLOWING)==null) {
                            p.setGlowing(false);
                        }

                        if (world.getBlockState(pos).getBlock() instanceof GravityShroom && world.getBlockState(pos).get(GravityShroom.GRAVITY)) {
                            world.setBlockState(pos, world.getBlockState(pos).with(GravityShroom.GRAVITY, false));
                        }
                    }
                } else {
                    if (world.getBlockState(pos).getBlock() instanceof GravityShroom && world.getBlockState(pos).get(GravityShroom.GRAVITY)) {
                        world.setBlockState(pos, world.getBlockState(pos).with(GravityShroom.GRAVITY, false));
                    }
                }
            }
        }
    }



    public void steamParticle(Vec3d oldPos, BlockState state, ServerWorld world, Random random){
        double X = oldPos.getX();
        double Y = oldPos.getY()+0.6;
        double Z = oldPos.getZ();

        double res = 0.2;
        for(int i = 0; i < Utilities.rint(1,2,random); i++) {
            double speedX = Utilities.rdoub(-res,res);
            double speedY = Utilities.rdoub(0.03,0.06);
            double speedZ = Utilities.rdoub(-res,res);
            SteamGeneratorBlock.spawnParticle(world, ParticleTypes.ENCHANT,X, Y+0.5, Z, 1,speedX,speedY,speedZ,0.1);

        }
    }
}
