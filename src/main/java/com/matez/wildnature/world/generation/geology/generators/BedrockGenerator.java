package com.matez.wildnature.world.generation.geology.generators;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import java.util.ArrayList;

public class BedrockGenerator {

    public void apply(int iy, ArrayList<BlockState> strata){

        for(int i = 0; i <= iy; i++){
            strata.set(i, Blocks.BEDROCK.getDefaultState());
        }

    }

}
