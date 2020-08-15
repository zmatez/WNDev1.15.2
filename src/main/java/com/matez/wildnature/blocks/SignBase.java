package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WoodType;

public class SignBase extends StandingSignBlock implements IRenderLayer {

    public SignBase(Properties properties) {
        super(properties, WoodType.OAK);
        WNBlocks.SIGNBLOCKS.add(this);

    }


}
