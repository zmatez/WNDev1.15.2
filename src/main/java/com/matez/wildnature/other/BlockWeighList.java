package com.matez.wildnature.other;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;


import java.util.ArrayList;

public class BlockWeighList {

    protected ArrayList<BlockState> blocks;
    protected ArrayList<Integer> weigh;

    public BlockWeighList(){
        blocks  = new ArrayList<>();
        weigh  = new ArrayList<>();
    }

    public ArrayList<BlockState> getNormalArrayList(){
        ArrayList<BlockState> states = new ArrayList<>();
        int x = 0;
        while(x<this.size()){
            int a = this.getWeighList().get(x);
            int z = 0;
            while(z<a){
                states.add(this.getBlockList().get(x));
                z++;
            }
            x++;
        }


        return states;
    }

    public static BlockWeighList parseFromNormalArrayList(ArrayList<BlockState> states){
        BlockWeighList list = new BlockWeighList();
        for (BlockState state : states) {
            if(list.getBlockList().contains(state)){
                int oldRarity = list.getRarityFor(state);
                list.remove(state);
                list.add(state,oldRarity+1);
            }
        }

        return list;
    }

    public void add(BlockState block, Integer iWeigh){
        blocks.add(block);
        weigh.add(iWeigh);
    }

    public void remove(BlockState block, Integer iWeigh){
        blocks.remove(block);
        weigh.remove(iWeigh);
    }

    public void remove(BlockState block){
        weigh.remove(weigh.get(blocks.indexOf(block)));
        blocks.remove(block);
    }

    public int getRarityFor(BlockState block){
        return (weigh.get(blocks.indexOf(block)));
    }

    public void clear(){
        weigh.clear();
        blocks.clear();
    }

    public Integer size(){

        if(checkIfEquals()){
            return blocks.size();
        }else{
            return -99999;
        }

    }


    public boolean checkIfEquals(){
        if(blocks.size()==weigh.size()){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Integer> getWeighList(){
        return weigh;
    }

    public ArrayList<BlockState> getBlockList(){
        return blocks;
    }

}