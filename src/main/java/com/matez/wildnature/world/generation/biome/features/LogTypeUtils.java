package com.matez.wildnature.world.generation.biome.features;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.biome.setup.WNBiome;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.Random;

public class LogTypeUtils {
    public static Block getFenceFromBiome(Biome biome, Random random){
        ArrayList<Block> blockArrayList = new ArrayList<>();
        if(biome instanceof WNBiome){
            WNBiome wnBiome = (WNBiome) biome;
            for (LogType logType : wnBiome.getLogTypes()) {
                Block log = logType.getLog().getBlock();
                Block fence = WN.getBlockByID(log.getRegistryName().toString().replace("log","fence"));
                if(fence != Blocks.AIR){
                    blockArrayList.add(fence);
                }
            }
            if(blockArrayList.isEmpty()){
                return Blocks.OAK_FENCE;
            }

            return blockArrayList.get(Utilities.rint(0,blockArrayList.size()-1, random));
        }else{
            return Blocks.OAK_FENCE;
        }
    }
}
