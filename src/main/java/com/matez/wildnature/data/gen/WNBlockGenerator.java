package com.matez.wildnature.data.gen;

import com.matez.wildnature.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

import java.util.function.Consumer;

public class WNBlockGenerator {
    private Block block;
    private BlockItem blockItem;
    public WNBlockGenerator(Block block, BlockItem blockItem, String modelSource, Consumer<Void> blockstate, Consumer<Void> model){

    }

    public WNBlockGenerator(BlockBase block, String modelSource, Consumer<Void> blockstate, Consumer<Void> model){

    }

}
