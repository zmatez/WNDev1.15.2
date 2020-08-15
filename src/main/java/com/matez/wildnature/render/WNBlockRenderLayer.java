package com.matez.wildnature.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderTypeLookup;

import java.util.ArrayList;

public class WNBlockRenderLayer {
    public static void setProperRenderLayer(Block block){
        if(block instanceof IRenderLayer){
            RenderTypeLookup.setRenderLayer(block,((IRenderLayer)block).getRenderLayer());
        }
    }

}
