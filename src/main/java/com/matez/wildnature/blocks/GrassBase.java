package com.matez.wildnature.blocks;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameter;
import net.minecraft.world.storage.loot.LootParameters;

public class GrassBase extends GrassBlock implements IRenderLayer {
    private Item item;
    private String dirt;
    public GrassBase(Properties properties, Item.Properties builder, ResourceLocation regName,String dirt) {
        super(properties);
        this.dirt=dirt;
        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
        BlockState plant = plantable.getPlant(world, pos.offset(facing));
        net.minecraftforge.common.PlantType type = plantable.getPlantType(world, pos.offset(facing));
        try {
            if (plant.getBlock() instanceof BushBlock && Utilities.isValidGroundFor(plant,Blocks.GRASS_BLOCK.getDefaultState(), world, pos)) {
                return true;
            }
            if (plant.getBlock() instanceof CropBase && Utilities.isValidGroundFor(plant,Blocks.GRASS_BLOCK.getDefaultState(), world, pos)) {
                return true;
            }
        }catch (Exception e){
        }

        if(plant.getBlock() instanceof WildBlueberryPlant || plant.getBlock() instanceof WildRosePlant || plant.getBlock() instanceof WildStrawberryPlant || plant.getBlock() instanceof CurrantPlant ||
                plant.getBlock() instanceof QuincePlant || plant.getBlock() instanceof BlackberryPlant || plant.getBlock() instanceof BlackLilacPlant || plant.getBlock() instanceof CranberryPlant)

            if (plant.getBlock() == Blocks.CACTUS)
                return this.getBlock() == Blocks.CACTUS || this.getBlock() == Blocks.SAND || this.getBlock() == Blocks.RED_SAND;

        if (plant.getBlock() == Blocks.SUGAR_CANE && this == Blocks.SUGAR_CANE)
            return true;

        if (plantable instanceof BushBlock && (!(plantable instanceof CropsBlock) || plantable instanceof QuincePlant || plantable instanceof WildStrawberryPlant || plantable instanceof CurrantPlant))
            return true;

        switch (type) {
            case Desert: return this.getBlock() == Blocks.SAND || this.getBlock() == Blocks.TERRACOTTA || this.getBlock() instanceof GlazedTerracottaBlock;
            case Nether: return this.getBlock() == Blocks.SOUL_SAND;
            case Crop:   return this.getBlock() == Blocks.FARMLAND;
            case Cave:   return Block.hasSolidSide(state, world, pos, Direction.UP);
            case Plains: return this.getBlock() == Blocks.GRASS_BLOCK || isDirt(this) || this.getBlock() instanceof FarmlandBlock;
            case Water:  return state.getMaterial() == Material.WATER; //&& state.getValue(BlockLiquidWrapper)
            case Beach:
                boolean isBeach = this.getBlock() == Blocks.GRASS_BLOCK || isDirt(this) || this.getBlock() == Blocks.SAND;
                boolean hasWater = (world.getBlockState(pos.east()).getMaterial() == Material.WATER ||
                        world.getBlockState(pos.west()).getMaterial() == Material.WATER ||
                        world.getBlockState(pos.north()).getMaterial() == Material.WATER ||
                        world.getBlockState(pos.south()).getMaterial() == Material.WATER);
                return isBeach && hasWater;
        }



        return false;
    }

    public static boolean isDirt(Block blockIn) {
        return net.minecraftforge.common.Tags.Blocks.DIRT.contains(blockIn);
    }


    /**
     * Whether this IGrowable can grow
     */
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return !this.getDefaultState().isValidPosition(context.getWorld(), context.getPos()) ? Block.nudgeEntitiesWithNewState(this.getDefaultState(), Registry.BLOCK.getOrDefault(new ResourceLocation(dirt)).getDefaultState(), context.getWorld(), context.getPos()) : super.getStateForPlacement(context);
    }

    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).isAir();
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

    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if (!worldIn.isRemote) {
            Block dirtBlock = Main.getBlockByID(dirt);
            if(dirtBlock==Blocks.COBBLESTONE){
                dirtBlock=Blocks.STONE;
            }
            if (!worldIn.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            if (!func_220257_b(state, worldIn, pos)) {
                worldIn.setBlockState(pos, dirtBlock.getDefaultState());
            } else {
                if (worldIn.getLight(pos.up()) >= 9) {
                    BlockState blockstate = this.getDefaultState();

                    for(int i = 0; i < 4; ++i) {
                        BlockPos blockpos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                        if (worldIn.getBlockState(blockpos).getBlock() == dirtBlock && func_220256_c(blockstate, worldIn, blockpos)) {
                            worldIn.setBlockState(blockpos, blockstate.with(SNOWY, Boolean.valueOf(worldIn.getBlockState(blockpos.up()).getBlock() == Blocks.SNOW)));
                        }
                    }
                }

            }
        }
    }

    public static boolean func_220257_b(BlockState p_220257_0_, IWorldReader p_220257_1_, BlockPos p_220257_2_) {
        BlockPos blockpos = p_220257_2_.up();
        BlockState blockstate = p_220257_1_.getBlockState(blockpos);
        if (blockstate.getBlock() == Blocks.SNOW && blockstate.get(SnowBlock.LAYERS) == 1) {
            return true;
        } else {
            int i = LightEngine.func_215613_a(p_220257_1_, p_220257_0_, p_220257_2_, blockstate, blockpos, Direction.UP, blockstate.getOpacity(p_220257_1_, blockpos));
            return i < p_220257_1_.getMaxLightLevel();
        }
    }

    public static boolean func_220256_c(BlockState p_220256_0_, IWorldReader p_220256_1_, BlockPos p_220256_2_) {
        BlockPos blockpos = p_220256_2_.up();
        return func_220257_b(p_220256_0_, p_220256_1_, p_220256_2_) && !p_220256_1_.getFluidState(blockpos).isTagged(FluidTags.WATER);
    }
}