package com.matez.wildnature.common.blocks;

import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BananaLeavesBlock extends LeavesBase {
    public BananaLeavesBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random);

        if(Utilities.rint(0, CommonConfig.leafFruitChance.get())==0){
            if(Utilities.isBlockNear(worldIn,pos.down(), WNBlocks.PALM_LOG,WNBlocks.PALM_WOOD) && worldIn.getBlockState(pos.down()).getBlock()== Blocks.AIR){
                Direction logDir = null;
                for (Direction d : Direction.Plane.HORIZONTAL){
                    if(worldIn.getBlockState(pos.down().offset(d)).getBlock()==WNBlocks.PALM_LOG || worldIn.getBlockState(pos.down().offset(d)).getBlock()==WNBlocks.PALM_WOOD){
                        logDir = d;
                        break;
                    }
                }

                if(logDir!=null){
                    worldIn.setBlockState(pos.down(),WNBlocks.BANANA_FRUIT.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING,logDir),2);
                }
            }
        }

    }



}
