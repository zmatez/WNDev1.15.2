package com.matez.wildnature.world.generation.structures.utils;

import net.minecraft.block.Block;

public class BlockReplacement {
    private Block from, to;
    public BlockReplacement(Block from, Block to){
        this.from = from;
        this.to = to;
    }

    public Block getFrom() {
        return from;
    }

    public Block getTo() {
        return to;
    }

    public Block process(Block block){
        if(block == from){
            return to;
        }
        return block;
    }
}
