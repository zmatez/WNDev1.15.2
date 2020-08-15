package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CoffeeBush extends DoubleBushBase implements IGrowable {
    public static final IntegerProperty STAGE = IntegerProperty.create("stage",0,2);

    public CoffeeBush(Properties properties,  ResourceLocation regName) {
        super(properties, null, regName);
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        if(state.get(STAGE)!=2  && Utilities.rint(0,3)==0) {
            worldIn.setBlockState(pos, state.with(STAGE, worldIn.getBlockState(pos).get(STAGE) + 1));
            worldIn.notifyNeighbors(pos, state.getBlock());
        }
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
        super.fillStateContainer(builder);

    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if(Utilities.chance(ConfigSettings.floweringChance) && state.get(STAGE)!=2){
            worldIn.setBlockState(pos,state.with(STAGE,worldIn.getBlockState(pos).get(STAGE)+1));
            worldIn.notifyNeighbors(pos,state.getBlock());
        }
    }


    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if(state.get(HALF)==DoubleBlockHalf.LOWER){
            if(worldIn.getBlockState(pos.up()).getBlock() instanceof CoffeeBush){
                int i = worldIn.getBlockState(pos.up()).get(STAGE);
                if(i>state.get(STAGE)){
                    worldIn.setBlockState(pos,state.with(STAGE,i));
                }
            }
        } else if(state.get(HALF)==DoubleBlockHalf.UPPER){
            if(worldIn.getBlockState(pos.down()).getBlock() instanceof CoffeeBush){
                int i = worldIn.getBlockState(pos.down()).get(STAGE);
                if(i>state.get(STAGE)){
                    worldIn.setBlockState(pos,state.with(STAGE,i));
                }
            }
        }
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.setMotionMultiplier(state, new Vec3d(0.9D, (double)0.95F, 0.9D));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(player.getHeldItem(handIn).getItem()== Items.BONE_MEAL && state.get(STAGE)!=2){
            return ActionResultType.PASS;
        }
        if(state.get(STAGE)==0){
            return ActionResultType.PASS;
        }else{
            if(state.get(STAGE)==1){
                ItemStack stack = new ItemStack(WNItems.COFFEE_BRANCH, Utilities.rint(1,3));
                fruit(state,worldIn,pos);
                spawnAsEntity(worldIn,pos,stack);
                ;
            }else if(state.get(STAGE)==2){
                ItemStack stack = new ItemStack(WNItems.COFFEE_LEAVES, Utilities.rint(1,3));
                fruit(state,worldIn,pos);
                spawnAsEntity(worldIn,pos,stack);
                if(Utilities.rint(0,4)==0) {
                    ItemStack stack2 = new ItemStack(WNItems.COFFEE_BERRY_GREEN, Utilities.rint(1,2));
                    spawnAsEntity(worldIn, pos, stack2);
                }
            }
        }
        return ActionResultType.SUCCESS;
    }

    public void fruit(BlockState state,World worldIn,BlockPos pos){
        if(state.get(HALF)==DoubleBlockHalf.LOWER){
            if(worldIn.getBlockState(pos.up()).getBlock() instanceof CoffeeBush){
                worldIn.setBlockState(pos.up(),state.with(STAGE,0).with(HALF,DoubleBlockHalf.UPPER));
            }

        } else if(state.get(HALF)==DoubleBlockHalf.UPPER){
            if(worldIn.getBlockState(pos.down()).getBlock() instanceof CoffeeBush){
                worldIn.setBlockState(pos.down(),state.with(STAGE,0).with(HALF,DoubleBlockHalf.LOWER));
            }
        }
        worldIn.setBlockState(pos,state.with(STAGE,0));

    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> list = new ArrayList<>();
        if(list.isEmpty()){
            int i = state.get(STAGE);
            if(i==1){
                list.add(new ItemStack(Main.getItemByID("coffee_branch"), 1));
            }else if(i==2){
                list.add(new ItemStack(Main.getItemByID("coffee_leaves"), 1));
                list.add(new ItemStack(Main.getItemByID("coffee_berry_green"), Utilities.rint(0,1)));
            }
        }

        return list;
    }
}
