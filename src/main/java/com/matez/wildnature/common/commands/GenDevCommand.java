package com.matez.wildnature.common.commands;

import com.matez.wildnature.init.WN;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.block.Blocks;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;

public class GenDevCommand {

    public int gen(PlayerEntity entity, CommandContext<CommandSource> context, String function){
        if(TestCommand.checkPlayer(entity)){
            try {
                ServerWorld world = context.getSource().getWorld();
                BlockPos pos = entity.getPosition();
                BlockPos.Mutable mutable = new BlockPos.Mutable(pos);
                Chunk[] chunks = new Chunk[]{
                        world.getChunkAt(mutable),
                        world.getChunkAt(mutable.move(Direction.NORTH,16)),
                        world.getChunkAt(mutable.move(Direction.SOUTH,16)),
                        world.getChunkAt(mutable.move(Direction.EAST,16)),
                        world.getChunkAt(mutable.move(Direction.WEST,16)),
                        world.getChunkAt(mutable.move(Direction.NORTH,16).move(Direction.EAST,16)),
                        world.getChunkAt(mutable.move(Direction.NORTH,16).move(Direction.WEST,16)),
                        world.getChunkAt(mutable.move(Direction.SOUTH,16).move(Direction.EAST,16)),
                        world.getChunkAt(mutable.move(Direction.SOUTH,16).move(Direction.WEST,16)),
                };

                long start = System.currentTimeMillis();
                for (Chunk chunk : chunks) {
                    int[] noise = getNoiseArray(chunk);

                    if(function.equals("test")){
                        testFunction(world,chunk, chunk.getPos(), noise);
                    }
                }
                long end = System.currentTimeMillis();
                StringTextComponent s2 = new StringTextComponent(TextFormatting.GREEN + "Generation successful!");
                WN.sendChatMessage(entity, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s2));
                log(entity,TextFormatting.LIGHT_PURPLE + "Operation took " + TextFormatting.GOLD + ((end - start)) + "ms" + TextFormatting.LIGHT_PURPLE + " per 9 chunks (per 1 - " + TextFormatting.GOLD + ((end - start)/9) + "ms" + TextFormatting.LIGHT_PURPLE + ").");
            }catch (Exception e){
                StringTextComponent s2 = new StringTextComponent(TextFormatting.RED + "Generation failed. " + e.getLocalizedMessage());
                WN.sendChatMessage(entity, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s2));
                e.printStackTrace();
            }
            return 1;
        }

        return 0;
    }

    private int[] getNoiseArray(Chunk chunk){
        ChunkPos pos = chunk.getPos();
        int[] vals = new int[256];
        for (int x = 0; x < 16; x++){
            for (int z = 0; z < 16; z++){
                vals[(x * 16) + z] = chunk.getTopBlockY(Heightmap.Type.WORLD_SURFACE,x,z);
            }
        }
        return vals;
    }

    private void testFunction(ServerWorld world, Chunk chunk, ChunkPos chunkPos, int[] noise){
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                BlockPos pos = new BlockPos(chunkPos.x + x, noise[(x * 16) + z], chunkPos.z + z);
                world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState(), 18);
            }
        }
    }

    private void log(PlayerEntity entity, String text){
        StringTextComponent s = new StringTextComponent(TextFormatting.GRAY + text);
        WN.sendChatMessage(entity, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s));
    }
}
