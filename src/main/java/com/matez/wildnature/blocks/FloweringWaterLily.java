package com.matez.wildnature.blocks;

import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class FloweringWaterLily extends WaterLilyBase implements IGrowable {

    public static final BooleanProperty FLOWERING = BooleanProperty.create("flowering");
    public FloweringWaterLily(Properties properties, ResourceLocation regName) {
        super(properties.sound(SoundType.PLANT),regName);
        setDefaultState(this.getDefaultState().with(FLOWERING,false));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FLOWERING);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return !state.get(FLOWERING);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if(Utilities.chance(ConfigSettings.floweringChance)){
            worldIn.setBlockState(pos,state.with(FLOWERING,true));
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(state.getBlock() instanceof FloweringWaterLily && state.get(FLOWERING) && CommonConfig.flowerDisappearsOnWalk.get() && !(entityIn instanceof ItemEntity)){
            worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(FLOWERING,false));
            worldIn.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS,0.3F,(float) Utilities.rdoub(0.7,1.3),false);
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
            if(!state.get(FLOWERING)) {
                worldIn.setBlockState(pos, state.with(FLOWERING, true));
            }else{
                ItemStack stack = new ItemStack(this, 1);
                spawnAsEntity(worldIn,pos,stack);
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if(placer instanceof PlayerEntity && ((PlayerEntity)placer).isCreative()){
            worldIn.setBlockState(pos,state.with(FLOWERING,true));
        }
    }


}
