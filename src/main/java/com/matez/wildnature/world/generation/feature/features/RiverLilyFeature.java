package com.matez.wildnature.world.generation.feature.features;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.util.other.Utilities;
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
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.CountConfig;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class RiverLilyFeature extends Feature<CountConfig> {
    public RiverLilyFeature(Function<Dynamic<?>, ? extends CountConfig> p_i49915_1_) {
        super(p_i49915_1_);
        setRegistryName("wildnature","river_lily_feature");
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

            BlockPos.Mutable mutable = new BlockPos.Mutable(startPos);
            for(int i = 0; i < 100; i++){
                BlockPos.Mutable blockMutable = new BlockPos.Mutable(mutable);
                BlockState state = Utilities.rint(0,2) == 0 ? WNBlocks.GREEN_WATERLILY.getDefaultState() : Blocks.LILY_PAD.getDefaultState();
                for(int j = 0; j < Utilities.rint(0,5,rand); j++){
                    blockMutable.move(allowedDirections.get(Utilities.rint(0,allowedDirections.size()-1)), Utilities.rint(rockMinDistance,rockMaxDistance,rand));
                    worldIn.setBlockState(blockMutable.up(),state,2);
                }

                mutable.move(riverSideDirection,Utilities.rint(1,3,rand));

                try {
                    if(!worldIn.getWorld().chunkExists(mutable.getX()/4,mutable.getZ()/4)){
                        break;
                    }
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

}