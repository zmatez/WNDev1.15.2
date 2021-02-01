package com.matez.wildnature.world.generation.geology;

import com.matez.wildnature.util.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.Arrays;
import java.util.List;

public class Classification {

    public static List<Block> soil = Arrays.asList(
            Blocks.DIRT,
            Blocks.SAND,
            Blocks.RED_SAND
    );

    public static List<Block> sedimentary = Arrays.asList(
            Blocks.SANDSTONE,
            Blocks.RED_SANDSTONE,
            WNBlocks.LIMESTONE
    );

    public static List<Block> carbonate = Arrays.asList(
            WNBlocks.MARBLE,
            WNBlocks.GNEISS,
            WNBlocks.SLATE_BLUE,
            WNBlocks.SLATE_PURPLE
    );

    public List<Block> getSoil() {
        return soil;
    }

    public List<Block> getSedimentary() {
        return sedimentary;
    }

    public List<Block> getCarbonate() {
        return carbonate;
    }

}
