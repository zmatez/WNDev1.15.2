package com.matez.wildnature.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.TickPriority;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;

public class MagmaPadBlock extends LavalilyBase {
    public static BooleanProperty CRACK = BooleanProperty.create("crack");

    public MagmaPadBlock(Properties properties, ResourceLocation regName) {
        super(properties, regName);
        setDefaultState(this.getDefaultState().with(CRACK,false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(CRACK);
    }


    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, worldIn, pos, entity);
        if(entity instanceof LivingEntity && (!(entity instanceof PlayerEntity) || !(((PlayerEntity)entity).isCreative())) && !state.get(CRACK)) {
            worldIn.setBlockState(pos, worldIn.getBlockState(pos).with(CRACK, true));

            if(worldIn.getDifficulty()!= Difficulty.PEACEFUL){
                int time = 60;
                if(worldIn.getDifficulty()==Difficulty.EASY){
                    time = 80;
                }else if(worldIn.getDifficulty()==Difficulty.NORMAL){
                    time = 40;
                }else{
                    time = 10;
                }
                worldIn.getPendingBlockTicks().scheduleTick(pos, this, time, TickPriority.NORMAL);

            }
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.tick(state, worldIn, pos, random);
        if(worldIn.getBlockState(pos).get(CRACK)){
            Predicate<LivingEntity> predicate = new Predicate<LivingEntity>() {
                @Override
                public boolean test(LivingEntity entity) {
                    return (entity.getPosition().getY()>=pos.getY() && entity.getPosition().getY()<pos.getY()+4 && entity.getPosition().getX()==pos.getX() && entity.getPosition().getZ()==pos.getZ());
                }
            };
            ArrayList<LivingEntity> entities = new ArrayList<>(worldIn.getEntitiesWithinAABB(LivingEntity.class,new AxisAlignedBB(pos),predicate));
            if(!entities.isEmpty()) {
                worldIn.destroyBlock(pos, false);
            }else{
                worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(CRACK,false));
            }
        }
    }
}
