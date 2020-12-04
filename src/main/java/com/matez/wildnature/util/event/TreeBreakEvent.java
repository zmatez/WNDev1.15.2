package com.matez.wildnature.util.event;

import com.matez.wildnature.init.WN;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TreeBreakEvent {

    @SubscribeEvent
    public void treeEvent(BlockEvent.BreakEvent event){
        /*PlayerEntity entity = event.getPlayer();
        World world = entity.getEntityWorld();
        BlockPos pos = event.getPos();
        BlockState brokenBlock = event.getState();
        WN.LOGGER.debug("Break " + brokenBlock.getBlock().getRegistryName());
        if(brokenBlock.getBlock().isIn(BlockTags.LOGS)){
            WN.LOGGER.debug("Break yes");
            if(canBreakLeaves(world,brokenBlock.getBlock(),pos)){
                breakLeaves(world,pos);
            }
        }*/
    }

    private static boolean canBreakLeaves(World world, Block centerBlock, BlockPos nearPos){
        return isLogLeafNear(true, world,centerBlock,nearPos) && isLogLeafNear(false, world,centerBlock,nearPos);
    }

    private static void breakLeaves(World world, BlockPos nearPos){
        WN.LOGGER.debug("Breaking " + nearPos);
    }

    private static boolean isLogLeafNear(boolean horizontal, World world, Block centerBlock, BlockPos center){
        if(horizontal){
            Block[] blocks = getBlocksNear(world,center);
            Block[] blocksNorth = getBlocksNear(world,center.north(2));
            Block[] blocksSouth = getBlocksNear(world,center.south(2));
            Block[] blocksEast = getBlocksNear(world,center.east(2));
            Block[] blocksWest = getBlocksNear(world,center.west(2));

            return  isVerticalLeaf(world,centerBlock,blocks) &&
                    !isVerticalLeaf(world,centerBlock,blocksNorth) &&
                    !isVerticalLeaf(world,centerBlock,blocksSouth) &&
                    !isVerticalLeaf(world,centerBlock,blocksEast) &&
                    !isVerticalLeaf(world,centerBlock,blocksWest);
        }else{
            Block[] blocks = getBlocksNear(world,center);
            Block[] blocksUp = getBlocksNear(world,center.up(2));
            Block[] blocksDown = getBlocksNear(world,center.down(2));

            return  isHorizontalLeaf(world,centerBlock,blocks) &&
                    !isHorizontalLeaf(world,centerBlock,blocksUp) &&
                    !isHorizontalLeaf(world,centerBlock,blocksDown);
        }
    }

    private static Block[] getBlocksNear(World world, BlockPos center){
        Block[] blocks = new Block[6];
        blocks[0] = world.getBlockState(center.north()).getBlock();
        blocks[1] = world.getBlockState(center.south()).getBlock();
        blocks[2] = world.getBlockState(center.east()).getBlock();
        blocks[3] = world.getBlockState(center.west()).getBlock();
        blocks[4] = world.getBlockState(center.down()).getBlock();
        blocks[5] = world.getBlockState(center.up()).getBlock();
        return blocks;
    }

    private static boolean isVerticalLeaf(World world, Block current, Block[] blocks){
        return current.isIn(BlockTags.LOGS) && blocks[0].isIn(BlockTags.LEAVES) && blocks[1].isIn(BlockTags.LEAVES) && blocks[2].isIn(BlockTags.LEAVES) && blocks[3].isIn(BlockTags.LEAVES);
    }

    private static boolean isHorizontalLeaf(World world, Block current, Block[] blocks){
        return current.isIn(BlockTags.LOGS) && blocks[4].isIn(BlockTags.LEAVES) && blocks[5].isIn(BlockTags.LEAVES) && ((blocks[0].isIn(BlockTags.LEAVES) && blocks[1].isIn(BlockTags.LEAVES)) || (blocks[2].isIn(BlockTags.LEAVES) && blocks[3].isIn(BlockTags.LEAVES)));
    }
}
