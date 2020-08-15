package com.matez.wildnature.blocks;

import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class FloweringLeaves extends LeavesBase{
    public static final BooleanProperty FLOWERING = BooleanProperty.create("flowering");
    private boolean canDegrade = false;
    public FloweringLeaves(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
        setDefaultState(this.getDefaultState().with(FLOWERING,false));
    }

    public FloweringLeaves(Properties properties, Item.Properties builder, ResourceLocation regName, boolean canDegrade) {
        super(properties, builder, regName);
        setDefaultState(this.getDefaultState().with(FLOWERING,false));
        this.canDegrade=canDegrade;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(FLOWERING);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return !state.get(FLOWERING) || canDegrade;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if(Utilities.chance(ConfigSettings.floweringChance)){
            if(canDegrade){
                if(worldIn.getBlockState(pos).get(FLOWERING)){
                    worldIn.setBlockState(pos, state.with(FLOWERING, true));
                }else{
                    worldIn.setBlockState(pos, state.with(FLOWERING, false));
                }
            }else {
                worldIn.setBlockState(pos, state.with(FLOWERING, true));
            }
        }
    }
}
