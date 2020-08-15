package com.matez.wildnature.blocks;

import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class DoubleBushBaseFlowering extends TallFlowerBlock implements IRenderLayer {
    private Item item;
    public static final BooleanProperty FLOWERING = FloweringBushBase.FLOWERING;
    private static Properties Properties(Properties properties){

        return properties.doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH);

    }

    public DoubleBushBaseFlowering(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(Properties(properties));

        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);
        setDefaultState(this.getDefaultState().with(FLOWERING,false));

        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }

    public Item getItem() {
        return item;
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return !state.get(FLOWERING);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FLOWERING);
        super.fillStateContainer(builder);

    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && !silkTouch && state.get(HALF)== DoubleBlockHalf.LOWER){
            list.add(new ItemStack(item, 1));
        }

        return list;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if(Utilities.chance(ConfigSettings.floweringChance)){
            worldIn.setBlockState(pos,state.with(FLOWERING,true));
            worldIn.notifyBlockUpdate(pos,state,worldIn.getBlockState(pos),2);
        }
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged( state,  worldIn,  pos,  blockIn,  fromPos,  isMoving);
        if(fromPos.getZ() == pos.getZ() && fromPos.getX() == pos.getX() && (fromPos.getY() == pos.getY() || fromPos.getY() == pos.getY()-1 || fromPos.getY() == pos.getY()+1)) {
            if (worldIn.getBlockState(fromPos).getBlock() instanceof DoubleBushBaseFlowering) {
                if (worldIn.getBlockState(pos.down()).getBlock() instanceof DoubleBushBaseFlowering) {
                    worldIn.setBlockState(pos, state.with(FLOWERING, worldIn.getBlockState(fromPos).get(FLOWERING)));
                } else if (worldIn.getBlockState(pos.up()).getBlock() instanceof DoubleBushBaseFlowering) {
                    worldIn.setBlockState(pos, state.with(FLOWERING, worldIn.getBlockState(fromPos).get(FLOWERING)));
                }
            }
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(state.getBlock() instanceof DoubleBushBaseFlowering && state.get(FLOWERING) && !(entityIn instanceof ItemEntity)){
            worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(FLOWERING,false));
            worldIn.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS,0.3F,(float) Utilities.rdoub(0.7,1.3),false);

        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn,pos,state,placer,stack);
        if(placer instanceof PlayerEntity && ((PlayerEntity)placer).isCreative()){
            worldIn.setBlockState(pos,state.with(FLOWERING,true),2);
        }
    }

    public boolean canGrow(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_, boolean p_176473_4_) {
        return true;
    }

    public boolean canUseBonemeal(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_, BlockState p_180670_4_) {
        return true;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        if(Utilities.rint(0, CommonConfig.flowerBloomChance.get())==0){
            if(!state.get(FLOWERING)) {
                worldIn.setBlockState(pos, state.with(FLOWERING, true));
                worldIn.notifyBlockUpdate(pos,state.with(FLOWERING, true),worldIn.getBlockState(pos),2);
            }else{
                ItemStack stack = new ItemStack(this, 1);
                spawnAsEntity(worldIn,pos,stack);
            }
        }
    }


}
