package com.matez.wildnature.world.generation.structures.nature.woods.jelly;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraftforge.common.IPlantable;

import java.util.Set;

public class jelly_island3 extends SchemFeature {

    @Override
    public boolean canGrowTree(IWorldGenerationReader world, BlockPos pos, IPlantable sapling) {
        return world.hasBlockState(pos, state -> {
            return state.getFluidState().getFluid() == Fluids.WATER;
        });
    }

    @Override
    public Set<BlockPos> setBlocks() {

Block(-1,7,-3,"minecraft:smooth_sandstone");
Block(-2,8,-3,"minecraft:smooth_sandstone");
Block(-1,8,-3,"minecraft:sand");
Block(0,8,-3,"minecraft:coarse_dirt");
Block(-2,9,-3,"minecraft:sand");
Block(-1,9,-3,"minecraft:sand");
Block(0,9,-3,"minecraft:sand");
Block(-2,5,-2,"minecraft:smooth_sandstone");
Block(-1,5,-2,"minecraft:dirt");
Block(-2,6,-2,"minecraft:sand");
Block(-1,6,-2,"minecraft:smooth_sandstone");
Block(-3,7,-2,"minecraft:smooth_sandstone");
Block(-2,7,-2,"minecraft:sand");
Block(-1,7,-2,"minecraft:dirt");
Block(0,7,-2,"minecraft:dirt");
Block(-3,8,-2,"minecraft:coarse_dirt");
Block(-1,8,-2,"minecraft:dirt");
Block(0,8,-2,"minecraft:dirt");
Block(1,8,-2,"minecraft:smooth_sandstone");
Block(-3,9,-2,"wildnature:algae_block[snowy=false]");
Block(-2,9,-2,"minecraft:smooth_sandstone");
Block(-1,9,-2,"wildnature:algae_block[snowy=false]");
Block(0,9,-2,"minecraft:smooth_sandstone");
Block(1,9,-2,"minecraft:sand");
Block(-2,4,-1,"minecraft:smooth_sandstone");
Block(-1,4,-1,"minecraft:coarse_dirt");
Block(-3,5,-1,"minecraft:smooth_sandstone");
Block(-2,5,-1,"minecraft:dirt");
Block(-1,5,-1,"minecraft:dirt");
Block(0,5,-1,"minecraft:smooth_sandstone");
Block(-3,6,-1,"minecraft:sand");
Block(-2,6,-1,"minecraft:dirt");
Block(-1,6,-1,"minecraft:dirt");
Block(0,6,-1,"minecraft:sand");
Block(-3,7,-1,"minecraft:sand");
Block(-2,7,-1,"minecraft:dirt");
Block(-1,7,-1,"minecraft:dirt");
Block(0,7,-1,"minecraft:dirt");
Block(1,7,-1,"minecraft:coarse_dirt");
Block(-4,8,-1,"minecraft:coarse_dirt");
Block(-3,8,-1,"minecraft:dirt");
Block(-2,8,-1,"minecraft:dirt");
Block(-1,8,-1,"minecraft:dirt");
Block(0,8,-1,"minecraft:dirt");
Block(1,8,-1,"minecraft:coarse_dirt");
Block(2,8,-1,"minecraft:dirt");
Block(-4,9,-1,"wildnature:algae_block[snowy=false]");
Block(-3,9,-1,"wildnature:algae_block[snowy=false]");
Block(-2,9,-1,"wildnature:algae_block[snowy=false]");
Block(-1,9,-1,"wildnature:algae_block[snowy=false]");
Block(0,9,-1,"wildnature:algae_block[snowy=false]");
Block(1,9,-1,"minecraft:sand");
Block(2,9,-1,"minecraft:smooth_sandstone");
Block(-2,2,0,"minecraft:smooth_sandstone");
Block(0,2,0,"minecraft:coarse_dirt");
Block(-2,3,0,"minecraft:sand");
Block(-1,3,0,"minecraft:dirt");
Block(0,3,0,"minecraft:coarse_dirt");
Block(-2,4,0,"minecraft:dirt");
Block(-1,4,0,"minecraft:dirt");
Block(0,4,0,"minecraft:smooth_sandstone");
Block(-3,5,0,"minecraft:coarse_dirt");
Block(-2,5,0,"minecraft:dirt");
Block(-1,5,0,"minecraft:dirt");
Block(0,5,0,"minecraft:sand");
Block(-3,6,0,"minecraft:smooth_sandstone");
Block(-2,6,0,"minecraft:dirt");
Block(-1,6,0,"minecraft:dirt");
Block(0,6,0,"minecraft:gravel");
Block(1,6,0,"minecraft:dirt");
Block(-3,7,0,"minecraft:sand");
Block(-2,7,0,"minecraft:dirt");
Block(-1,7,0,"minecraft:dirt");
Block(0,7,0,"minecraft:dirt");
Block(1,7,0,"minecraft:smooth_sandstone");
Block(-4,8,0,"minecraft:coarse_dirt");
Block(-3,8,0,"minecraft:dirt");
Block(-2,8,0,"minecraft:dirt");
Block(-1,8,0,"minecraft:dirt");
Block(0,8,0,"minecraft:dirt");
Block(1,8,0,"minecraft:dirt");
Block(2,8,0,"minecraft:dirt");
Block(-4,9,0,"wildnature:algae_block[snowy=false]");
Block(-3,9,0,"wildnature:algae_block[snowy=false]");
Block(-2,9,0,"wildnature:algae_block[snowy=false]");
Block(-1,9,0,"wildnature:algae_block[snowy=false]");
Block(0,9,0,"wildnature:algae_block[snowy=false]");
Block(1,9,0,"minecraft:smooth_sandstone");
Block(2,9,0,"minecraft:sand");
Block(0,3,1,"minecraft:smooth_sandstone");
Block(-1,4,1,"minecraft:coarse_dirt");
Block(0,4,1,"minecraft:sand");
Block(-2,5,1,"minecraft:dirt");
Block(-1,5,1,"minecraft:dirt");
Block(0,5,1,"minecraft:sand");
Block(-3,6,1,"minecraft:dirt");
Block(-2,6,1,"minecraft:dirt");
Block(-1,6,1,"minecraft:dirt");
Block(0,6,1,"minecraft:gravel");
Block(1,6,1,"minecraft:smooth_sandstone");
Block(-4,7,1,"minecraft:coarse_dirt");
Block(-3,7,1,"minecraft:dirt");
Block(-2,7,1,"minecraft:dirt");
Block(-1,7,1,"minecraft:dirt");
Block(0,7,1,"minecraft:dirt");
Block(1,7,1,"minecraft:sand");
Block(-4,8,1,"minecraft:dirt");
Block(-3,8,1,"minecraft:dirt");
Block(-2,8,1,"minecraft:dirt");
Block(-1,8,1,"minecraft:dirt");
Block(0,8,1,"minecraft:coarse_dirt");
Block(1,8,1,"minecraft:coarse_dirt");
Block(2,8,1,"minecraft:smooth_sandstone");
Block(-4,9,1,"wildnature:algae_block[snowy=false]");
Block(-3,9,1,"wildnature:algae_block[snowy=false]");
Block(-2,9,1,"wildnature:algae_block[snowy=false]");
Block(-1,9,1,"wildnature:algae_block[snowy=false]");
Block(0,9,1,"wildnature:algae_block[snowy=false]");
Block(1,9,1,"minecraft:sand");
Block(2,9,1,"minecraft:sand");
Block(0,4,2,"minecraft:smooth_sandstone");
Block(-1,5,2,"minecraft:smooth_sandstone");
Block(0,5,2,"minecraft:stone");
Block(1,5,2,"minecraft:smooth_sandstone");
Block(-2,6,2,"minecraft:smooth_sandstone");
Block(-1,6,2,"minecraft:gravel");
Block(0,6,2,"minecraft:gravel");
Block(1,6,2,"minecraft:sand");
Block(-3,7,2,"minecraft:smooth_sandstone");
Block(-2,7,2,"minecraft:sand");
Block(-1,7,2,"minecraft:dirt");
Block(0,7,2,"minecraft:dirt");
Block(1,7,2,"minecraft:coarse_dirt");
Block(2,7,2,"minecraft:dirt");
Block(-3,8,2,"minecraft:smooth_sandstone");
Block(-2,8,2,"minecraft:smooth_sandstone");
Block(-1,8,2,"minecraft:dirt");
Block(0,8,2,"minecraft:dirt");
Block(1,8,2,"minecraft:dirt");
Block(2,8,2,"minecraft:dirt");
Block(3,8,2,"minecraft:dirt");
Block(-3,9,2,"minecraft:sand");
Block(-2,9,2,"wildnature:algae_block[snowy=false]");
Block(-1,9,2,"wildnature:algae_block[snowy=false]");
Block(0,9,2,"minecraft:sand");
Block(1,9,2,"minecraft:smooth_sandstone");
Block(2,9,2,"minecraft:sand");
Block(3,9,2,"wildnature:algae_block[snowy=false]");
Block(0,5,3,"minecraft:smooth_sandstone");
Block(-1,6,3,"minecraft:smooth_sandstone");
Block(0,6,3,"minecraft:sand");
Block(-1,7,3,"minecraft:sand");
Block(0,7,3,"minecraft:dirt");
Block(1,7,3,"minecraft:coarse_dirt");
Block(-2,8,3,"minecraft:smooth_sandstone");
Block(-1,8,3,"minecraft:dirt");
Block(0,8,3,"minecraft:dirt");
Block(1,8,3,"minecraft:dirt");
Block(2,8,3,"minecraft:dirt");
Block(-2,9,3,"wildnature:algae_block[snowy=false]");
Block(-1,9,3,"wildnature:algae_block[snowy=false]");
Block(0,9,3,"minecraft:smooth_sandstone");
Block(1,9,3,"wildnature:algae_block[snowy=false]");
Block(2,9,3,"wildnature:algae_block[snowy=false]");
Block(0,7,4,"minecraft:coarse_dirt");
Block(-1,8,4,"minecraft:coarse_dirt");
Block(0,8,4,"minecraft:dirt");
Block(1,8,4,"minecraft:coarse_dirt");
Block(-1,9,4,"wildnature:algae_block[snowy=false]");
Block(0,9,4,"wildnature:algae_block[snowy=false]");
Block(1,9,4,"wildnature:algae_block[snowy=false]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     https://wildnaturemod.com
return super.setBlocks();
    }
}