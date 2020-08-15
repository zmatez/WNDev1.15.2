package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.compatibility.WNLoot;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;

import java.util.List;
import java.util.Random;

public class AlgaeBlock extends GrassBlock implements IRenderLayer {
    private Item item;
    private String dirt;
    public AlgaeBlock(Properties properties, Item.Properties builder, ResourceLocation regName, String dirt) {
        super(properties);
        this.dirt=dirt;
        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }


    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(SNOWY);
    }


    /**
     * Whether this IGrowable can grow
     */
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return !this.getDefaultState().isValidPosition(context.getWorld(), context.getPos()) ? Block.nudgeEntitiesWithNewState(this.getDefaultState(), Registry.BLOCK.getOrDefault(new ResourceLocation(dirt)).getDefaultState(), context.getWorld(), context.getPos()) : super.getStateForPlacement(context);
    }

    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return  worldIn.getBlockState(pos.up()).getFluidState().getFluid()== Fluids.WATER || worldIn.getBlockState(pos.up()).getFluidState().getFluid()== Fluids.FLOWING_WATER;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.up();
        int chance = Utilities.rint(0,15);
        BlockState blockstate = Blocks.GRASS.getDefaultState();
        if(chance<=7){
            blockstate = Main.getBlockByID("minecraft:grass").getDefaultState();
        }
        else if(chance>7 && chance<12){
            blockstate = Main.getBlockByID("wildnature:medium_grass").getDefaultState();
        }else{
            blockstate = Main.getBlockByID("wildnature:small_grass").getDefaultState();
        }

        for(int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;
            int j = 0;

            while(true) {
                if (j >= i / 16) {
                    BlockState blockstate2 = worldIn.getBlockState(blockpos1);
                    if (blockstate2.getBlock() == blockstate.getBlock() && rand.nextInt(10) == 0 && blockstate.getBlock() instanceof IGrowable) {
                        ((IGrowable)blockstate.getBlock()).grow(worldIn, rand, blockpos1, blockstate2);
                    }

                    if (!(worldIn.getBlockState(pos.up()).getFluidState().getFluid()== Fluids.WATER || worldIn.getBlockState(pos.up()).getFluidState().getFluid()== Fluids.FLOWING_WATER)) {
                        break;
                    }

                    BlockState blockstate1;
                    if (rand.nextInt(8) == 0) {
                        List<ConfiguredFeature<?, ?>> lvt_11_1_ = worldIn.getBiome(blockpos1).getFlowers();
                        if (lvt_11_1_.isEmpty()) {
                            continue;
                        }

                        ConfiguredFeature<?, ?> lvt_12_1_ = ((DecoratedFeatureConfig)((ConfiguredFeature)lvt_11_1_.get(0)).config).feature;
                        blockstate1 = ((FlowersFeature)lvt_12_1_.feature).getFlowerToPlace(rand, blockpos1, lvt_12_1_.config);
                    } else {
                        blockstate1 = blockstate;
                    }

                    if (blockstate1.isValidPosition(worldIn, blockpos1)) {
                        worldIn.setBlockState(blockpos1, blockstate1, 3);
                    }
                    break;
                }

                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (worldIn.getBlockState(blockpos1.down()).getBlock() != this || worldIn.getBlockState(blockpos1).isCollisionShapeOpaque(worldIn, blockpos1)) {
                    break;
                }

                ++j;
            }
        }

    }

    @Override
    public boolean isNormalCube(BlockState p_220081_1_, IBlockReader p_220081_2_, BlockPos p_220081_3_) {
        return true;
    }

    /**
     * Gets the render layer this block will render on. SOLID for solid blocks, CUTOUT or CUTOUT_MIPPED for on-off
     * transparency (glass, reeds), TRANSLUCENT for fully blended transparency (stained glass)
     */

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && !silkTouch){
            if(WNLoot.isSilkTouch(builder)){
                list.add(new ItemStack(Item.getItemFromBlock(this), 1));
            }else {
                list.add(new ItemStack(Item.getItemFromBlock(Main.getBlockByID(dirt)), 1));
            }
        }



        return list;
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }
}