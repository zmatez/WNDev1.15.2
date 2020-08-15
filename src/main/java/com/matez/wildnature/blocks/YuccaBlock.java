package com.matez.wildnature.blocks;

import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class YuccaBlock extends DoubleBushBaseFlowering {
    public YuccaBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    public void setBlock(IWorld world, BlockPos pos, boolean flowering){
        if(!flowering){
            world.setBlockState(pos,this.getDefaultState().with(FLOWERING,false).with(HALF, DoubleBlockHalf.LOWER),2);
            if(world.getBlockState(pos.up()).getBlock() instanceof YuccaBlock) {
                world.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 2);

            }
        }else{
            world.setBlockState(pos,this.getDefaultState().with(FLOWERING,true).with(HALF, DoubleBlockHalf.LOWER),2);
            world.setBlockState(pos.up(),this.getDefaultState().with(FLOWERING,true).with(HALF, DoubleBlockHalf.UPPER),2);

        }
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        setBlock(worldIn,pos,state.get(FLOWERING));
    }

    @Override
    public void placeAt(IWorld p_196390_1_, BlockPos p_196390_2_, int p_196390_3_) {
        setBlock(p_196390_1_,p_196390_2_,false);
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        super.grow(worldIn, rand, pos, state);
        if(worldIn.getBlockState(pos).get(FLOWERING)){
            setBlock(worldIn,pos,true);
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if(Utilities.chance(ConfigSettings.floweringChance)){
            setBlock(worldIn,pos,true);
            worldIn.notifyBlockUpdate(pos,state,worldIn.getBlockState(pos),2);
        }
    }
}
