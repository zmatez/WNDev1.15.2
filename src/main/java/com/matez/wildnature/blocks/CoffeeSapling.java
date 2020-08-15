package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.item.Item;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class CoffeeSapling extends BushBase implements IGrowable {
    protected static final VoxelShape SHAPE = makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public CoffeeSapling(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);

    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return SHAPE.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if(Utilities.chance(ConfigSettings.floweringChance)){
            if(worldIn.isAirBlock(pos.up())){
                worldIn.setBlockState(pos, Main.getBlockByID("wildnature:coffee_bush").getDefaultState().with(CoffeeBush.STAGE,0).with(CoffeeBush.HALF, DoubleBlockHalf.LOWER));
                worldIn.setBlockState(pos.up(), Main.getBlockByID("wildnature:coffee_bush").getDefaultState().with(CoffeeBush.STAGE,0).with(CoffeeBush.HALF, DoubleBlockHalf.LOWER));
                worldIn.notifyNeighbors(pos,Main.getBlockByID("wildnature:coffee_bush").getDefaultState().getBlock());
                worldIn.notifyNeighbors(pos.up(),Main.getBlockByID("wildnature:coffee_bush").getDefaultState().getBlock());
            }
        }
    }


    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).getBlock()==Blocks.AIR;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return worldIn.getBlockState(pos.up()).getBlock()==Blocks.AIR;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        if(worldIn.isAirBlock(pos.up()) && Utilities.rint(0,4)==0){
            worldIn.setBlockState(pos, Main.getBlockByID("wildnature:coffee_bush").getDefaultState().with(CoffeeBush.STAGE,0).with(CoffeeBush.HALF, DoubleBlockHalf.LOWER));
            worldIn.setBlockState(pos.up(), Main.getBlockByID("wildnature:coffee_bush").getDefaultState().with(CoffeeBush.STAGE,0).with(CoffeeBush.HALF, DoubleBlockHalf.UPPER));
            worldIn.notifyNeighbors(pos,Main.getBlockByID("wildnature:coffee_bush").getDefaultState().getBlock());
            worldIn.notifyNeighbors(pos.up(),Main.getBlockByID("wildnature:coffee_bush").getDefaultState().getBlock());
        }
    }
}
