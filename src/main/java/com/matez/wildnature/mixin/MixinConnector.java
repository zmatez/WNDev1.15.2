package com.matez.wildnature.mixin;

import com.matez.wildnature.Main;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;
public class MixinConnector implements IMixinConnector {

    @Override
    public void connect() {
        Main.LOGGER.debug("Connecting Mixin...");
        Mixins.addConfiguration("wildnature.mixins.json");
        Main.LOGGER.info("Mixin Connected!");
    }
}