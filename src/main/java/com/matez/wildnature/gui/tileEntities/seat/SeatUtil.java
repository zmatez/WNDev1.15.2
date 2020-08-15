package com.matez.wildnature.gui.tileEntities.seat;

import com.matez.wildnature.blocks.BasicBench;
import com.matez.wildnature.blocks.BasicChair;
import com.matez.wildnature.blocks.BasicStool;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SeatUtil {

    @SubscribeEvent
    public static void onRightClickBlock(RightClickBlock event)
    {
        PlayerEntity player = event.getPlayer();
        Hand hand = event.getHand();
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        Block block = world.getBlockState(pos).getBlock();

        if(player.getHeldItem(hand).isEmpty()) {

            if ((block instanceof BasicChair || block instanceof BasicStool || block instanceof BasicBench) && world.getBlockState(pos.up()).isAir(world, pos.up()) && !SeatEntity.OCCUPIED.containsKey(pos) && !player.isSneaking()) {
                event.setCanceled(true);
                if (event.getSide() == LogicalSide.SERVER) {
                    SeatEntity seat = new SeatEntity(world, pos);
                    world.addEntity(seat);
                    player.startRiding(seat);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onBreak(BreakEvent event)
    {
        if(SeatEntity.OCCUPIED.containsKey(event.getPos()))
        {
            SeatEntity.OCCUPIED.get(event.getPos()).remove();
            SeatEntity.OCCUPIED.remove(event.getPos());
        }
    }

    @SubscribeEvent
    public static void onEntityMount(EntityMountEvent event)
    {
        if(event.isDismounting())
        {
            Entity player = event.getEntityBeingMounted();

            if(player instanceof SeatEntity)
            {
                player.remove();
                SeatEntity.OCCUPIED.remove(player.getPosition());
            }
        }
    }
}