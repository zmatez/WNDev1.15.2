package com.matez.wildnature.blocks;

import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class PricklyPearBlock extends DesertBush implements IGrowable {
    public PricklyPearBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    public static final long MORNING_START = 0;
    public static final long MORNING_END = 1000;
    public static final long DAYTIME_START = 1000;
    public static final long DAYTIME_END = 10000;
    public static final long SUNSET_START = 10000;
    public static final long SUNSET_END = 13000;
    public static final long NIGHT_START = 13000;
    public static final long NIGHT_END = 0;

    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 2);
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D), Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D), Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D), Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D)};
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> container) {
        container.add(AGE);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE_BY_AGE[state.get(AGE)];
    }

    @Override
    public boolean ticksRandomly(BlockState p_149653_1_) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(!world.isRemote) {
            if (state.get(AGE)==1 || state.get(AGE)==2) {
                world.setBlockState(pos,state.with(AGE,getAgeByTime(getTimeByLong(world.getDayTime()))));
            } else {
                if (Utilities.chance(ConfigSettings.floweringChance)) {
                    world.setBlockState(pos, state.with(AGE,1));
                }
            }
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(state.getBlock() instanceof FloweringBushBase && state.get(AGE)!=0 && CommonConfig.flowerDisappearsOnWalk.get() && !(entityIn instanceof ItemEntity)){
            worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(AGE,1));
        }
        if(Utilities.rint(0,4)==0 && entityIn instanceof LivingEntity){
            ((LivingEntity)entityIn).attackEntityFrom(DamageSource.CACTUS,(float)(0.5f));
        }
    }

    private PricklyPearTime getTimeByLong(long currentTime){
        if(Utilities.dBetween(MORNING_START,MORNING_END,currentTime)){
            return PricklyPearTime.MORNING;
        } else if(Utilities.dBetween(DAYTIME_START,DAYTIME_END,currentTime)){
            return PricklyPearTime.DAYTIME;
        } else if(Utilities.dBetween(SUNSET_START,SUNSET_END,currentTime)){
            return PricklyPearTime.SUNSET;
        } else{
            return PricklyPearTime.NIGHT;
        }
    }

    private int getAgeByTime(PricklyPearTime time){
        if(time== PricklyPearTime.MORNING){
            return 1;
        }else if(time== PricklyPearTime.DAYTIME){
            return 2;
        }else if(time== PricklyPearTime.SUNSET){
            return 1;
        }else{
            return 1;
        }
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        if(Utilities.rint(0, CommonConfig.flowerBloomChance.get())==0){
            if(state.get(AGE)==0) {
                worldIn.setBlockState(pos, state.with(AGE, 1));
            }else{
                ItemStack stack = new ItemStack(this, 1);
                spawnAsEntity(worldIn,pos,stack);
            }
        }
    }


    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {

        if(!worldIn.isRemote) {
            if(placer instanceof PlayerEntity && ((PlayerEntity)placer).isCreative()){
                worldIn.setBlockState(pos,state.with(AGE,1));
            }
            if (worldIn.getBlockState(pos).get(AGE)!=0) {
                worldIn.setBlockState(pos,state.with(AGE,getAgeByTime(getTimeByLong(worldIn.getDayTime()))));
            }
        }
    }

    public static enum PricklyPearTime{
        MORNING,
        DAYTIME,
        SUNSET,
        NIGHT
    }
}
