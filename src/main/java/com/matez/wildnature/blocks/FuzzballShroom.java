package com.matez.wildnature.blocks;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.registry.ParticleRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class FuzzballShroom extends MushroomBase {
    public static final BooleanProperty BROKEN = BooleanProperty.create("broken");

    public FuzzballShroom(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
        setDefaultState(getDefaultState().with(BROKEN,false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BROKEN);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(!worldIn.isRemote) {
            if (!state.get(BROKEN)) {
                worldIn.setBlockState(pos, state.with(BROKEN, true));
                steamParticle(pos,state,(ServerWorld)worldIn,new Random());
            }
        }
    }

    public void steamParticle(BlockPos oldPos, BlockState state, ServerWorld world, Random random){
        double X = oldPos.getX();
        double Y = oldPos.getY()+0.6;
        double Z = oldPos.getZ();

        double res = 0.1;
        for(int i = 0; i < Utilities.rint(100,300,random); i++) {
            double speedX = Utilities.rdoub(-res,res);
            double speedY = Utilities.rdoub(0.03,0.06);
            double speedZ = Utilities.rdoub(-res,res);
            SteamGeneratorBlock.spawnParticle(world, ParticleRegistry.FUZZBALL_EXPLOSION,X+0.5, Y+0.05, Z+0.5, 1,speedX,speedY,speedZ,0.05);

        }

        world.playSound(null,oldPos.getX(), oldPos.getY(), oldPos.getZ(), SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.4F, (float) Utilities.rdoub(1.1D, 1.5D));

    }
}
