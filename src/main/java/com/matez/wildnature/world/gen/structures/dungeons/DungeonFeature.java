package com.matez.wildnature.world.gen.structures.dungeons;

import com.matez.wildnature.blocks.BranchBase;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.command.arguments.BlockStateArgument;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.*;
import java.util.function.Function;

public class DungeonFeature extends Feature<NoFeatureConfig> {
   public DungeonFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51438_1_) {
      super(p_i51438_1_);
   }

   private boolean virtualPlace = true;
   private BlockPos startBlockPos;
   private int rotation = 1;
   private IWorld world;
   private ArrayList<SchemFeature.BlockStatePos> blocks = new ArrayList<>();

   private int underground = 1; //diamond block pos minus that number
    private int flags = 19;
    //Diamond Blocks is a center of structure so "pos" equals the position of it

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        startBlockPos=pos;
        rotation= Utilities.rint(1,4,rand);
        world=worldIn;
        //prepareTerrainForSpawn();
        virtualPlace=false;
        //setBlocks();
        return true;
   }

   public void prepareTerrainForSpawn(){
       virtualPlace=true;
       setBlocks();
       int platformHeight = startBlockPos.down(underground).getY();
       int maxSize = 0;//1, 2, 3
       int minSize = 0;//-1, -2, -3
       ArrayList<SchemFeature.BlockStatePos> platform = new ArrayList<>();//platform blocks
       ArrayList<BlockState> platformBlocks = new ArrayList<>();//for most common blocks, then unused
       ArrayList<BlockPos> holes = new ArrayList<>();//platform blocks


       //add platform blocks
       for (SchemFeature.BlockStatePos block : blocks) {
           if(block.getPos().getY()==platformHeight){
               platform.add(block);
               platformBlocks.add(block.getState());
               if(!world.getBlockState(block.getPos().down()).isSolid()){
                   holes.add(block.getPos().down());
               }
           }

           if(block.getPos().getY()>maxSize){
               maxSize=block.getPos().getY();
           }
           if(block.getPos().getY()<minSize){
               minSize=block.getPos().getY();
           }
       }

       BlockState platformBlock = mostCommon(platformBlocks);
       ArrayList<BlockPos> holesCopy = holes;//platform blocks

       //if air under platform blocks set platformBlock a.k.a fill all holes
       while (!holesCopy.isEmpty()){
           holes = holesCopy;
           for (BlockPos pos : holes) {
               world.setBlockState(pos,platformBlock,flags);
               holesCopy.remove(pos);
               if(!world.getBlockState(pos.down()).isSolid() && pos.getY()>1){
                   holesCopy.add(pos.down());
               }
           }
       }





   }

   public void setBlocks(){

   }

    public void Block(int x, int y, int z, BlockState state){
        BlockPos pos = startBlockPos;
        int sx = startBlockPos.getX();
        int sy = startBlockPos.getY()-1;
        int sz = startBlockPos.getZ();
        if(rotation>=1 && rotation<=4){
            if(rotation==1){
                pos = new BlockPos(x+sx,y+sy,z+sz);//north
            }else if(rotation==2){
                pos = new BlockPos(-x+sx,y+sy,-z+sz);//south
            }else if (rotation==3){
                pos = new BlockPos(z+sx,y+sy,x+sz);
            }else{
                pos = new BlockPos(-z+sx,y+sy,-x+sz);
            }
        }else{
            throw new IllegalArgumentException("Unknown rotation for structure at " + startBlockPos.toString() + " :\nrotation = " + rotation + " (1-4)\n   Please report it to author!");

        }

        //world.setBlockState(pos, state, 2);
        //setBlockState(world,pos,state);

        blocks.add(new SchemFeature.BlockStatePos(state,pos.down(underground)));
        if(!virtualPlace) {
            if(state.getBlock()==Blocks.STRUCTURE_VOID){
                state=Blocks.AIR.getDefaultState();
            }
            world.setBlockState(pos.down(underground), state, 19);
        }
    }



    public void Block(int x, int y, int z, String s){
        try {
            BlockState bs = BlockStateArgument.blockState().parse(new StringReader(s)).getState();
            Block(x,y,z,bs);

            return;
        } catch (CommandSyntaxException e) {

        }
    }

    public static <T> T mostCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }



}