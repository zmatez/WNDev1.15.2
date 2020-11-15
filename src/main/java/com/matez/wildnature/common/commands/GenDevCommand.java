package com.matez.wildnature.common.commands;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.biome.setup.WNGenSettings;
import com.matez.wildnature.world.generation.processors.TerrainProcessor;
import com.matez.wildnature.world.generation.processors.ThermalErosionProcessor;
import com.matez.wildnature.world.generation.processors.ThermalErosionTestProcessor;
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
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class GenDevCommand {

    public int gen(PlayerEntity entity, CommandContext<CommandSource> context, String function){
        if(TestCommand.checkPlayer(entity)){
            try {
                ServerWorld world = context.getSource().getWorld();
                BlockPos pos = entity.getPosition();
                BlockPos.Mutable mutable = new BlockPos.Mutable(pos);
                ChunkPos cp = world.getChunkAt(pos).getPos();
                Chunk[] chunks = new Chunk[]{
                        world.getChunk(cp.x,cp.z),
                        world.getChunk(cp.x + 1,cp.z),
                        world.getChunk(cp.x - 1,cp.z),
                        world.getChunk(cp.x,cp.z + 1),
                        world.getChunk(cp.x,cp.z - 1),
                        world.getChunk(cp.x + 1,cp.z + 1),
                        world.getChunk(cp.x + 1,cp.z - 1),
                        world.getChunk(cp.x - 1,cp.z - 1),
                        world.getChunk(cp.x - 1,cp.z + 1),

                };

                long start = System.currentTimeMillis();
                boolean valid = true;
                for (Chunk chunk : chunks) {
                    int[] noise = getNoiseArray(chunk);

                    if(function.equals("test")){
                        log(entity,"Test function " + chunk.getPos().x + ", " + chunk.getPos().z + " and "+ chunk.getPos().getXStart() + ", " + chunk.getPos().getZStart());
                        testFunction(world,chunk, chunk.getPos(), noise);
                    }else if(function.equals("erode")){
                        erodeFunction(world,chunk,chunk.getPos(),noise);
                    }else if(function.equals("erodetest")){
                        erodeTestFunction(world,chunk,chunk.getPos(),noise);
                    }else{
                        valid = false;
                    }
                }

                if(!valid){
                    StringTextComponent s2 = new StringTextComponent(TextFormatting.GOLD + "Not found function called " + TextFormatting.GRAY + function);
                    WN.sendChatMessage(entity, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s2));
                    return 0;
                }

                long end = System.currentTimeMillis();
                StringTextComponent s2 = new StringTextComponent(TextFormatting.GREEN + "Generation successful!");
                WN.sendChatMessage(entity, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s2));
                log(entity,TextFormatting.LIGHT_PURPLE + "Operation took " + TextFormatting.GOLD + ((end - start)) + "ms" + TextFormatting.LIGHT_PURPLE + " per 9 chunks (per 1 - " + TextFormatting.GOLD + ((double)(end - start)/(double)chunks.length) + "ms" + TextFormatting.LIGHT_PURPLE + ").");
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
                vals[(x * 16) + z] = chunk.getTopBlockY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,x, z);
            }
        }
        return vals;
    }

    private void testFunction(ServerWorld world, Chunk chunk, ChunkPos chunkPos, int[] noise){
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                BlockPos pos = new BlockPos(chunkPos.getXStart() + x, noise[(x * 16) + z] + 1, chunkPos.getZStart() + z);
                world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState(), 18);
            }
        }
    }

    private TerrainProcessor erosion = new ThermalErosionProcessor();
    private void erodeFunction(ServerWorld world, Chunk chunk, ChunkPos chunkPos, int[] noise){
        erosion.init((ChunkGenerator<WNGenSettings>) world.getChunkProvider().getChunkGenerator(), world.getSeed());
        erosion.process(world,chunk,new Random(world.getSeed()), chunkPos.x, chunkPos.z,0,0,noise);
    }

    private TerrainProcessor erosionTest = new ThermalErosionTestProcessor();
    private void erodeTestFunction(ServerWorld world, Chunk chunk, ChunkPos chunkPos, int[] noise){
        erosionTest.init((ChunkGenerator<WNGenSettings>) world.getChunkProvider().getChunkGenerator(), world.getSeed());
        erosionTest.process(world,chunk,new Random(world.getSeed()), chunkPos.x, chunkPos.z,0,0,noise);
    }

    private void log(PlayerEntity entity, String text){
        StringTextComponent s = new StringTextComponent(TextFormatting.GRAY + text);
        WN.sendChatMessage(entity, new StringTextComponent("").appendSibling(WN.WNPrefix).appendSibling(s));
    }
}
