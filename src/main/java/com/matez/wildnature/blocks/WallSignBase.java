package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;

public class WallSignBase extends WallSignBlock implements IRenderLayer {

    public WallSignBase(Properties properties) {
        super(properties, WoodType.OAK);
        WNBlocks.SIGNBLOCKS.add(this);
    }
}
