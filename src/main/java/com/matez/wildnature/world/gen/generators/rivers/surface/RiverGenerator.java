package com.matez.wildnature.world.gen.generators.rivers.surface;

import com.matez.wildnature.commands.LocatePath;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.noise.OpenSimplex2S;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraftforge.common.BiomeDictionary;

public class RiverGenerator {
    private BlockState AIR = Blocks.AIR.getDefaultState();
    public RiverGenerator(IWorld worldIn){

    }

    public void generate(int x, int y, int z, Biome biome, IChunk chunkIn){
        generateRiverValley(x,y,z,20,chunkIn);
    }

    private void generateRiverValley(int x, int y, int z, int radius, IChunk chunk){
        for(int circleX=-radius; circleX<=radius; circleX++) {
            for (int circleZ = -radius; circleZ <= radius; circleZ++) {
                if (circleX * circleX + circleZ * circleZ <= radius * radius) {
                    int posX = circleX + x;
                    int posZ = circleZ + z;

                    carve(posX,posZ,y,getHeightForPosition(posX,posZ,x,y,z),AIR, chunk);
                }
            }
        }
    }

    private int getHeightForPosition(int posX, int posZ, int centerX, int centerY, int centerZ){
        int xDelta = centerX - posX;
        int zDelta = centerZ - posZ;

        double xFactor = (double)xDelta / (double)posX;
        double zFactor = (double)zDelta / (double)posZ;

        return (int)Math.round(Math.floor(centerY / (xFactor * zFactor)));
    }

    private void carve(int x, int z, int oldY, int newY, BlockState blockState, IChunk chunk){
        BlockPos.Mutable pos = new BlockPos.Mutable(x,0,z);
        if(oldY != newY){
            if(oldY > newY){
                for(int i = oldY; i > newY; i--){
                    pos.setY(i);
                    chunk.setBlockState(pos,blockState,false);
                }
            }else{
                for(int i = oldY; i < newY; i++){
                    pos.setY(i);
                    chunk.setBlockState(pos,blockState,false);
                }
            }
        }
    }

}
