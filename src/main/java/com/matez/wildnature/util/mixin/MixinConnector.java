package com.matez.wildnature.util.mixin;

import com.matez.wildnature.init.WN;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;
public class MixinConnector implements IMixinConnector {

    @Override
    public void connect() {
        WN.LOGGER.debug("Connecting Mixin...");
        Mixins.addConfiguration("wildnature.mixins.json");
        WN.LOGGER.info("Mixin Connected!");
    }
}