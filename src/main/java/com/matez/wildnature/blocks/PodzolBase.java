package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.storage.loot.LootContext;

import javax.annotation.Nullable;
import java.util.List;

public class PodzolBase extends BlockBase {
    public Item item;
    private String dirt;

    public PodzolBase(Properties properties, Item.Properties builder, ResourceLocation regName, String dirt) {
        super(properties,builder,regName);
    }

    public Item getItem() {
        return item;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);

        //System.out.println("biome: " + BiomeColors.getGrassColor(worldIn, pos) + " foliage: " + GrassColors.get(0.5,0.5));
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

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && !silkTouch){
            list.add(new ItemStack(Item.getItemFromBlock(Main.getBlockByID(dirt)), 1));
        }

        return list;
    }
}
