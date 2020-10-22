package com.matez.wildnature.common.blocks;

import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.client.render.IRenderLayer;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WoodType;

public class SignBase extends StandingSignBlock implements IRenderLayer {

    public SignBase(Properties properties) {
        super(properties, WoodType.OAK);
        WNBlocks.SIGNBLOCKS.add(this);

    }


}
