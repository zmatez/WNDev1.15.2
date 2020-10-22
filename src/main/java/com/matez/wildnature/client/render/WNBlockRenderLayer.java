package com.matez.wildnature.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderTypeLookup;

public class WNBlockRenderLayer {
    public static void setProperRenderLayer(Block block){
        if(block instanceof IRenderLayer){
            RenderTypeLookup.setRenderLayer(block,((IRenderLayer)block).getRenderLayer());
        }
    }

}
