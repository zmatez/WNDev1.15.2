package com.matez.wildnature.world.generation.carver;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.carver.carvers.WNCaveCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.event.RegistryEvent;

public class CarverRegistry {

    public static WorldCarver<ProbabilityConfig> CAVE_CARVER;

    private static WorldCarver<?>[] carvers = new WorldCarver<?>[]{
            CAVE_CARVER = new WNCaveCarver(ProbabilityConfig::deserialize, 256)
    };

    public static void registerAll(final RegistryEvent.Register<WorldCarver<?>> event) {
        WN.LOGGER.info("Registering " + carvers.length + " world carvers...");
        int regEntry = event.getRegistry().getKeys().size();
        event.getRegistry().registerAll(
                carvers
        );
        int regExit = event.getRegistry().getKeys().size();
        WN.LOGGER.info("Registered " + (regExit - regEntry) + " world carvers.");
    }

}
