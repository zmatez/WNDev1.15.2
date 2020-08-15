package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FruitableLeaves extends LeavesBase {
    public static IntegerProperty STAGE = IntegerProperty.create("stage", 0, 6);
    private final ArrayList<StageFruit> stageFruits;
    private boolean hasFlowers = false;

    public FruitableLeaves(Properties properties, Item.Properties builder, ResourceLocation regName, ArrayList<StageFruit> stageFruits) {
        super(properties, builder, regName);
        this.stageFruits=stageFruits;

        this.setDefaultState(this.getDefaultState().with(getStage(),0));
    }

    public FruitableLeaves(Properties properties, Item.Properties builder, ResourceLocation regName, ArrayList<StageFruit> stageFruits,boolean hasFlowers) {
        super(properties, builder, regName);
        this.stageFruits=stageFruits;
        this.hasFlowers = hasFlowers;

        this.setDefaultState(this.getDefaultState().with(getStage(),0));

    }

    public int getMaxStages(){
        return 6;//0-6
    }

    public IntegerProperty getStage(){
        return STAGE;
    }

    public int getCurrentStage(BlockState state){
        return state.get(getStage());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(STAGE);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        int stage = state.get(getStage());
        if(this.hasFlowers){
            return stage==0 || stage==1;
        }
        return stage==0;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random);

        if(Utilities.rint(0,CommonConfig.leafFruitChance.get())==0){
            updateFruit(state,worldIn,pos);
        }

    }


    private void updateFruit(BlockState state, World world, BlockPos pos){
        int c = getCurrentStage(state);
        if(hasFlowers){
            if(c==0){
                world.setBlockState(pos,state.with(getStage(),1));
                return;
            }
        }

        if(c==0 || (hasFlowers && c==1)) {
            world.setBlockState(pos, state.with(getStage(), Utilities.rint(0, getMaxStages())));
        }


    }

    @Override
    public ActionResultType onBlockActivated(BlockState p_220051_1_, World p_220051_2_, BlockPos p_220051_3_, PlayerEntity p_220051_4_, Hand p_220051_5_, BlockRayTraceResult p_220051_6_) {
        int c = getCurrentStage(p_220051_1_);
        ItemPortion p = getFruitFromStage(c);
        if(p!=null && Main.getItemByID(p.item.toString())!= Items.AIR){
            p_220051_2_.setBlockState(p_220051_3_,p_220051_1_.with(getStage(),0));
            spawnAsEntity(p_220051_2_,p_220051_3_,new ItemStack(Main.getItemByID(p.item.toString()), Utilities.rint(p.min,p.max)));

            p_220051_2_.playSound((PlayerEntity)null, p_220051_3_, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + p_220051_2_.rand.nextFloat() * 0.4F);
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> list = super.getDrops(state, builder);
        int c = getCurrentStage(state);
        ItemPortion p = getFruitFromStage(c);
        if(p!=null && Main.getItemByID(p.item.toString())!= Items.AIR){
            list.add(new ItemStack(Main.getItemByID(p.item.toString()), Utilities.rint(p.min,p.max)));
        }


        return list;
    }

    private ItemPortion getFruitFromStage(int stage){
        int x = 0;
        while(x<this.stageFruits.size()){
            if(stageFruits.get(x).stage==stage){
                return stageFruits.get(x).portion;
            }
            x++;
        }
        return null;
    }

    public static class StageFruit{
        public final int stage;
        public final ItemPortion portion;
        public StageFruit(int stage, ItemPortion portion){
            this.stage=stage;
            this.portion=portion;
        }
    }

    public static class ItemPortion{
        public final ResourceLocation item;
        public final int max,min;
        public ItemPortion(String item, int min, int max){
            this.item=new ResourceLocation(item);
            this.min=min;
            this.max=max;
        }
    }


}
