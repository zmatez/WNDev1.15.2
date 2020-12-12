package com.matez.wildnature.world.generation.geology.generators;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.Random;

public class SurfaceGenerator {

    public void apply(int iy, Random random, ArrayList<BlockState> strata){

        //This is a temp fix for keeping the vanilla surface generator working.
        //Intend to replace that with the weightedSoil list.

        int depth = 1 + random.nextInt(2);

        for(int i = iy-depth; i < iy; i++){
            strata.set(i, Blocks.STONE.getDefaultState());
        }

    }

}
