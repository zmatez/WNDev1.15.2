package com.matez.wildnature.common.blocks;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.client.render.IRenderLayer;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;

public class WallSignBase extends WallSignBlock implements IRenderLayer {

    public WallSignBase(Properties properties) {
        super(properties, WoodType.OAK);
        WNBlocks.SIGNBLOCKS.add(this);
    }
}
