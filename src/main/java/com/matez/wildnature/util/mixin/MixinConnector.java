package com.matez.wildnature.util.mixin;

import com.matez.wildnature.init.Main;
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