package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class FloweringDesertBush extends FloweringBushBase {
    public FloweringDesertBush(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        if(this== WNBlocks.SMALL_CACTI && super.isValidGround(state,worldIn,pos)){
            return true;
        }
        Block block = state.getBlock();
        return block.isIn(BlockTags.SAND);
    }

}
