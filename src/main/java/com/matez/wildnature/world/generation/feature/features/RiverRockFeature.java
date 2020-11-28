package com.matez.wildnature.world.generation.feature.features;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.chunk.generation.WNSimplexChunkGenerator;
import com.matez.wildnature.world.generation.grid.Cell;
import com.matez.wildnature.world.generation.heightmap.modules.RiverGenerator;
import com.matez.wildnature.world.generation.provider.WNGridBiomeProvider;
import com.matez.wildnature.world.generation.provider.WNWorldType;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.CountConfig;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class RiverRockFeature extends Feature<CountConfig> {
    public static ArrayList<RockConfiguration> configurations = new ArrayList<>();
    static {
        configurations.add(new RockConfiguration(Blocks.STONE.getDefaultState(), 
                Blocks.COBBLESTONE.getDefaultState(), 
                Blocks.MOSSY_COBBLESTONE.getDefaultState(), 
                Blocks.COBBLESTONE_SLAB.getDefaultState(), 
                Blocks.MOSSY_COBBLESTONE_SLAB.getDefaultState()));
        configurations.add(new RockConfiguration(Blocks.GRANITE.getDefaultState(), 
                WNBlocks.GRANITE_COBBLE.getDefaultState(), 
                WNBlocks.GRANITE_COBBLE_MOSSY.getDefaultState(),
                Blocks.GRANITE_SLAB.getDefaultState(),
                WNBlocks.GRANITE_SLAB_COBBLE.getDefaultState(),
                WNBlocks.GRANITE_SLAB_COBBLE_MOSSY.getDefaultState()));
        configurations.add(new RockConfiguration(Blocks.DIORITE.getDefaultState(),
                WNBlocks.DIORITE_COBBLE.getDefaultState(),
                WNBlocks.DIORITE_COBBLE_MOSSY.getDefaultState(),
                Blocks.DIORITE_SLAB.getDefaultState(),
                WNBlocks.DIORITE_SLAB_COBBLE.getDefaultState(),
                WNBlocks.DIORITE_SLAB_COBBLE_MOSSY.getDefaultState()));
        configurations.add(new RockConfiguration(Blocks.ANDESITE.getDefaultState(),
                WNBlocks.ANDESITE_COBBLE.getDefaultState(),
                WNBlocks.ANDESITE_COBBLE_MOSSY.getDefaultState(),
                Blocks.ANDESITE_SLAB.getDefaultState(),
                WNBlocks.ANDESITE_SLAB_COBBLE.getDefaultState(),
                WNBlocks.ANDESITE_SLAB_COBBLE_MOSSY.getDefaultState()));

        configurations.add(new RockConfiguration(WNBlocks.MARBLE.getDefaultState(),
                WNBlocks.MARBLE_COBBLE.getDefaultState(),
                WNBlocks.MARBLE_COBBLE_MOSSY.getDefaultState(),
                WNBlocks.MARBLE_SLAB.getDefaultState(),
                WNBlocks.MARBLE_SLAB_COBBLE.getDefaultState(),
                WNBlocks.MARBLE_SLAB_COBBLE_MOSSY.getDefaultState()));

        configurations.add(new RockConfiguration(WNBlocks.GNEISS.getDefaultState(),
                WNBlocks.GNEISS_COBBLE.getDefaultState(),
                WNBlocks.GNEISS_COBBLE_MOSSY.getDefaultState(),
                WNBlocks.GNEISS_SLAB.getDefaultState(),
                WNBlocks.GNEISS_SLAB_COBBLE.getDefaultState(),
                WNBlocks.GNEISS_SLAB_COBBLE_MOSSY.getDefaultState()));
    }
    public RiverRockFeature(Function<Dynamic<?>, ? extends CountConfig> p_i49915_1_) {
        super(p_i49915_1_);
        setRegistryName("wildnature","river_rock_feature");
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, CountConfig config) {
        if(!worldIn.getDimension().isSurfaceWorld()){
            return false;
        }
        if(WNWorldType.generator == null){
            return false;
        }
        WNGridBiomeProvider provider = WNWorldType.generator.getGridProvider();
        if(provider == null){
            return false;
        }

        if(worldIn.getFluidState(pos).getFluid() != Fluids.EMPTY){
            return false;
        }

        int xzDiff = 8;
        int yDiff = 5;
        BlockPos startPos = null;
        Direction riverSideDirection = null;
        for(int i = 0; i < config.count; i++){
            BlockPos blockpos = pos.add(rand.nextInt(xzDiff) - rand.nextInt(xzDiff), rand.nextInt(yDiff) - rand.nextInt(yDiff), rand.nextInt(xzDiff) - rand.nextInt(xzDiff));
            if (worldIn.isAirBlock(blockpos) && worldIn.getBlockState(blockpos.down()).isSolid()){
                for(int j = 0; j < 4; j++){
                    Direction direction = Direction.byHorizontalIndex(j);
                    if(worldIn.getBlockState(blockpos.down().offset(direction,3)).getFluidState().getFluid()==Fluids.WATER){
                        startPos = blockpos.down().offset(direction,2);
                        riverSideDirection = direction;
                        break;
                    }
                }
            }
            if(riverSideDirection != null){
                break;
            }
        }

        int rockMinDistance = 0,rockMaxDistance = 3;
        if(riverSideDirection != null){
            ArrayList<Direction> allowedDirections = new ArrayList<>();
            allowedDirections.add(Direction.NORTH);
            allowedDirections.add(Direction.SOUTH);
            allowedDirections.add(Direction.EAST);
            allowedDirections.add(Direction.WEST);
            allowedDirections.remove(riverSideDirection);
            allowedDirections.remove(riverSideDirection.getOpposite());
            RockConfiguration configuration = configurations.get(Utilities.rint(0,configurations.size()-1,rand));

            BlockPos.Mutable mutable = new BlockPos.Mutable(startPos);
            for(int i = 0; i < 100; i++){
                BlockPos.Mutable blockMutable = new BlockPos.Mutable(mutable);
                for(int j = 0; j < Utilities.rint(0,5,rand); j++){
                    blockMutable.move(allowedDirections.get(Utilities.rint(0,allowedDirections.size()-1)), Utilities.rint(rockMinDistance,rockMaxDistance,rand));
                    BlockState state = configuration.getRandomBlock(rand,false);
                    if(state.getBlock() instanceof SlabBlock){
                        worldIn.setBlockState(blockMutable.up(),state.with(SlabBlock.TYPE, SlabType.BOTTOM),2);
                    }else{
                        worldIn.setBlockState(blockMutable,state,2);
                    }
                }

                mutable.move(riverSideDirection,Utilities.rint(1,3,rand));

                try {
                    if (worldIn.getFluidState(mutable.down()).getFluid() != Fluids.WATER) {
                        break;
                    }
                }catch (RuntimeException e){
                    break;
                }
            }

            return true;
        }

        return false;
    }

    public static class RockConfiguration{
        private BlockState full;
        private BlockState cobble;
        private BlockState mossyCobble;
        private BlockState fullSlab;
        private BlockState cobbleSlab;
        private BlockState mossyCobbleSlab;
        private ArrayList<BlockState> states = new ArrayList<>();
        private ArrayList<BlockState> fullStates = new ArrayList<>();
        
        public RockConfiguration(BlockState full, BlockState cobble, BlockState mossyCobble, BlockState fullSlab, BlockState cobbleSlab, BlockState mossyCobbleSlab){
            this.full = full;
            this.cobble = cobble;
            this.mossyCobble = mossyCobble;
            this.fullSlab = fullSlab;
            this.cobbleSlab = cobbleSlab;
            this.mossyCobbleSlab = mossyCobbleSlab;
            init();
        }

        public RockConfiguration(BlockState full, BlockState cobble, BlockState mossyCobble, BlockState cobbleSlab, BlockState mossyCobbleSlab){
            this.full = full;
            this.cobble = cobble;
            this.mossyCobble = mossyCobble;
            this.cobbleSlab = cobbleSlab;
            this.mossyCobbleSlab = mossyCobbleSlab;
            init();
        }

        public RockConfiguration(BlockState full, BlockState fullSlab){
            this.full = full;
            this.fullSlab = fullSlab;
            init();
        }

        public void init(){
            if(full != null){
                for(int i = 0; i < 4; i++){
                    states.add(full);
                    fullStates.add(full);
                }
            }
            if(cobble != null){
                for(int i = 0; i < 2; i++){
                    states.add(cobble);
                    fullStates.add(cobble);
                }
            }
            if(mossyCobble != null){
                states.add(mossyCobble);
                fullStates.add(mossyCobble);
            }
            if(cobbleSlab != null){
                states.add(cobbleSlab);
            }
            if(mossyCobbleSlab != null){
                states.add(mossyCobbleSlab);
            }
            if(fullSlab != null){
                states.add(fullSlab);
            }
        }
        
        public BlockState getRandomBlock(Random random, boolean onlyFull){
            if(onlyFull){
                return fullStates.get(Utilities.rint(0,fullStates.size()-1,random));
            }
            return states.get(Utilities.rint(0,states.size()-1,random));
        }
    }
}