package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.IShearable;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BushBase extends BushBlock implements IShearable, IRenderLayer {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    private Item item;

    public BushBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties.doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH));
        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);

        WNBlocks.PLANTS.add(this);
        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }

    public BushBase(Properties properties, Item.Properties builder, ResourceLocation regName, boolean newProperties) {
        super(properties);
        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);

        WNBlocks.PLANTS.add(this);
        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }

    private String drop;
    private int min = 1;
    private int max = 1;
    private int exp = 0;

    public BushBase(Properties properties, @Nullable Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
        super(properties.doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH));

        this.setRegistryName(regName);
        if(builder!=null) {
            item = new BlockItem(this, builder).setRegistryName(regName);

        }

        this.drop=drop;
        this.min=min;
        this.max=max;
        this.exp = exp;

        WNBlocks.PLANTS.add(this);
        WNBlocks.BLOCKS.add(this);
        if(builder!=null) {
            WNBlocks.ITEMBLOCKS.add(item);
        }

    }

    public Item getItem() {
        return item;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        if(drop!=null){
            List<ItemStack> list = new ArrayList<>();
            list.add(new ItemStack(Main.getItemByID(drop), Utilities.rint(min,max)));

            return list;
        }else {
            boolean silkTouch = false;
            List<ItemStack> list = super.getDrops(state, builder);
            if(list.isEmpty() && !silkTouch && Utilities.rint(0, CommonConfig.flowerDropChance.get())==0){
                list.add(new ItemStack(item, 1));
            }

            return list;
        }
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity entity) {
        if(entity.inventory.getCurrentItem().getItem()== Items.SHEARS && !entity.abilities.isCreativeMode){
            spawnAsEntity(world,pos,new ItemStack(Item.getItemFromBlock(state.getBlock())));
            world.playSound((double)pos.getX(),(double)pos.getY(),(double)pos.getZ(),this.getSoundType(state,world,pos,entity).getBreakSound(), SoundCategory.BLOCKS,this.getSoundType(state,world,pos,entity).pitch,this.getSoundType(state,world,pos,entity).volume,false);
            super.onBlockHarvested(world,pos,state,entity);
        }else{
            super.onBlockHarvested(world,pos,state,entity);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return worldIn.getBlockState(blockpos).canSustainPlant(worldIn, blockpos, Direction.UP, this);
        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block instanceof SnowyDirtBlock || block instanceof FarmlandBlock  || block instanceof PodzolBase;
    }

    /**
     * Get the OffsetType for this Block. Determines if the model is rendered slightly offset.
     */
    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }

    @OnlyIn(Dist.CLIENT)
    public long getPositionRandom(BlockState state, BlockPos pos) {
        return MathHelper.getCoordinateRandom(pos.getX(), pos.getY(), pos.getZ());
    }
}
