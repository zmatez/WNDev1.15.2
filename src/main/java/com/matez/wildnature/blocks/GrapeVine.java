package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class GrapeVine extends VineBase implements IGrowable {
    public static final BooleanProperty FLOWERING = BooleanProperty.create("flowering");
    public VineType type;
    public GrapeVine(Properties properties, Item.Properties builder, ResourceLocation regName, VineType type) {
        super(properties, builder, regName);
        this.type=type;
    }
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(FLOWERING);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.randomTick(state,worldIn,pos,random);
        if(Utilities.chance(ConfigSettings.floweringChance) && state.getBlock() instanceof GrapeVine){
            try {
                worldIn.setBlockState(pos, worldIn.getBlockState(pos).with(FLOWERING, true));
            }catch (Exception e){}
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

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity p_220051_4_, Hand p_220051_5_, BlockRayTraceResult p_220051_6_) {
        if(state.get(FLOWERING)){
            if(type==VineType.PURPLE){
                spawnAsEntity(world,pos,new ItemStack(WNItems.GRAPES_PURPLE,1));
            }else if(type==VineType.YELLOW){
                spawnAsEntity(world,pos,new ItemStack(WNItems.GRAPES_YELLOW,1));
            }
            world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + world.rand.nextFloat() * 0.4F);

            world.setBlockState(pos,state.with(FLOWERING,false),2);
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }

    public enum VineType implements IStringSerializable {
        YELLOW("yellow"),
        PURPLE("purple");


        private final String name;


        private VineType(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }


    }



}
