package com.matez.wildnature.client.render;

import net.minecraft.client.renderer.RenderType;

public interface IRenderLayer {
    /**
     * Gets the render layer this block will render on. SOLID for solid blocks, CUTOUT or CUTOUT_MIPPED for on-off
     * transparency (glass, reeds), TRANSLUCENT for fully blended transparency (stained glass)
     */
    default RenderType getRenderLayer(){
        return RenderType.getCutout();
    }
}
