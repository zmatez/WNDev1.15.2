package com.matez.wildnature.common.blocks;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.util.other.Utilities;
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

public class DesertBush extends BushBase {
    public DesertBush(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        if(this== WNBlocks.SMALL_CACTI && super.isValidGround(state,worldIn,pos)){
            return true;
        }
        Block block = state.getBlock();
        return block.isIn(BlockTags.SAND);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(state.getBlock()==WNBlocks.SMALL_CACTI && entityIn instanceof LivingEntity){
            if(Utilities.rint(0,7)==0){
                ((LivingEntity)entityIn).attackEntityFrom(DamageSource.CACTUS,(float)(0.5f));
            }
        }
    }

}
