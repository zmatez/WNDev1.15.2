package com.matez.wildnature.world.generation.surface;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.world.generation.surface.builders.*;
import com.matez.wildnature.world.generation.surface.configs.CanyonSurfaceBuilderConfig;
import com.matez.wildnature.world.generation.surface.configs.CustomSurfaceBuilderConfig;
import com.matez.wildnature.world.generation.surface.configs.Noise2SurfaceBuilderConfig;
import com.matez.wildnature.world.generation.surface.configs.Noise3SurfaceBuilderConfig;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;

import java.util.Random;

public class WNSurfaceBuilders {
    public static SurfaceBuilderConfig BROWN_CONFIG = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:brown_grass_block").getDefaultState(), WN.getBlockByID("wildnature:brown_dirt").getDefaultState(), WN.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig MOLD_CONFIG = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:mold_grass_block").getDefaultState(), WN.getBlockByID("wildnature:mold_dirt").getDefaultState(), WN.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig TROPICAL_CONFIG = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:tropical_grass_block").getDefaultState(), WN.getBlockByID("wildnature:tropical_dirt").getDefaultState(), WN.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig DRIED_CONFIG = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:dried_grass_block").getDefaultState(), WN.getBlockByID("wildnature:dried_dirt").getDefaultState(), WN.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig DESERT_CONFIG = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:desert_grass_block").getDefaultState(), WN.getBlockByID("wildnature:desert_dirt").getDefaultState(), WN.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig OVERGROWN_STONE_CONFIG = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:overgrown_stone").getDefaultState(), WN.getBlockByID("minecraft:stone").getDefaultState(), WN.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig BROWN_PODZOL_CONFIG = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:brown_podzol").getDefaultState(), WN.getBlockByID("wildnature:brown_dirt").getDefaultState(), WN.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig POLAR_CONFIG = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:brown_grass_block").getDefaultState(), Blocks.SNOW_BLOCK.getDefaultState(), Blocks.PACKED_ICE.getDefaultState());
    public static SurfaceBuilderConfig SNOW_CONFIG = new SurfaceBuilderConfig(Blocks.SNOW.getDefaultState().with(SnowBlock.LAYERS, Utilities.rint(1, 3, new Random())), Blocks.SNOW_BLOCK.getDefaultState(), WN.getBlockByID("minecraft:gravel").getDefaultState());
    public static SurfaceBuilderConfig FARMLANDS_CONFIG = new SurfaceBuilderConfig(WN.getBlockByID("wildnature:mold_grass_block").getDefaultState(), WN.getBlockByID("wildnature:mold_dirt").getDefaultState(), WN.getBlockByID("minecraft:gravel").getDefaultState());
    public static CustomSurfaceBuilderConfig BROWN_PODZOL_GRAVEL = new CustomSurfaceBuilderConfig(new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_CONFIG, 17), new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_PODZOL_CONFIG, 6), new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.GRAVEL_CONFIG, 1));
    public static SurfaceBuilderConfig ALGAE_CONFIG = new SurfaceBuilderConfig(WNBlocks.ALGAE_BLOCK.getDefaultState(), Blocks.GRAVEL.getDefaultState(), WN.getBlockByID("minecraft:gravel").getDefaultState());

    public static SurfaceBuilder<SurfaceBuilderConfig> STREAM_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> CANYON_RIVER_SURFACE_BUILDER;
    public static SurfaceBuilder<CanyonSurfaceBuilderConfig> CANYON_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> CRACKED_SURFACE_BUILDER;
    public static SurfaceBuilder<CustomSurfaceBuilderConfig> CUSTOM_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> DEAD_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> FARMLANDS_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> FLAT_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> GIEWONT_SURFACE_BUILDER;
    public static SurfaceBuilder<CanyonSurfaceBuilderConfig> GRAND_CANYON_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> ICELANDS_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> LUSH_DESERT_SURFACE_BUILDER;
    public static SurfaceBuilder<Noise3SurfaceBuilderConfig> NOISE3_SURFACE_BUILDER;
    public static SurfaceBuilder<Noise2SurfaceBuilderConfig> NOISE_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> NORMAL_PODZOL_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> OUTBACK_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> OVERGROWN_CLIFFS_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> PODZOL_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> POLDER_SURFACE_BUILDER;
    public static SurfaceBuilder<CanyonSurfaceBuilderConfig> RIVER_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> SNOWED_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> SNOWY_MOUNTAIN_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> TINTED_DESERT_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> WETLANDS_SURFACE_BUILDER;
    public static SurfaceBuilder<SurfaceBuilderConfig> CHRISTMAS_SURFACE_BUILDER;

    private static SurfaceBuilder<? extends ISurfaceBuilderConfig>[] surfaceBuilders = new SurfaceBuilder<?>[]{
            STREAM_SURFACE_BUILDER = new StreamSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            CANYON_RIVER_SURFACE_BUILDER = new CanyonRiverSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            CANYON_SURFACE_BUILDER = new CanyonSurfaceBuilder(CanyonSurfaceBuilderConfig::deserialize),
            CRACKED_SURFACE_BUILDER = new CrackedSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            CUSTOM_SURFACE_BUILDER = new CustomSurfaceBuilder(CustomSurfaceBuilderConfig::deserialize),
            DEAD_SURFACE_BUILDER = new DeadSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            FARMLANDS_SURFACE_BUILDER = new FarmlandsSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            FLAT_SURFACE_BUILDER = new FlatSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            GIEWONT_SURFACE_BUILDER = new GiewontSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            GRAND_CANYON_SURFACE_BUILDER = new GrandCanyonSurfaceBuilder(CanyonSurfaceBuilderConfig::deserialize),
            ICELANDS_SURFACE_BUILDER = new IcelandsSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            LUSH_DESERT_SURFACE_BUILDER = new LushDesertSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            NOISE3_SURFACE_BUILDER = new Noise3xSurfaceBuilder(Noise3SurfaceBuilderConfig::deserialize),
            NOISE_SURFACE_BUILDER = new NoiseSurfaceBuilder(Noise2SurfaceBuilderConfig::deserialize),
            NORMAL_PODZOL_SURFACE_BUILDER = new NormalPodzolSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            OUTBACK_SURFACE_BUILDER = new OutbackSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            OVERGROWN_CLIFFS_SURFACE_BUILDER = new OvergrownCliffsSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            PODZOL_SURFACE_BUILDER = new PodzolSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            POLDER_SURFACE_BUILDER = new PolderSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            RIVER_SURFACE_BUILDER = new RiverSurfaceBuilder(CanyonSurfaceBuilderConfig::deserialize),
            SNOWED_SURFACE_BUILDER = new SnowedSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            SNOWY_MOUNTAIN_SURFACE_BUILDER = new SnowyMountainSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            TINTED_DESERT_SURFACE_BUILDER = new TintedDesertSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            WETLANDS_SURFACE_BUILDER = new WetlandsSurfaceBuilder(SurfaceBuilderConfig::deserialize),
            CHRISTMAS_SURFACE_BUILDER = new XMASSurfaceBuilder(SurfaceBuilderConfig::deserialize)
    };

    public static void registerAll(final RegistryEvent.Register<SurfaceBuilder<?>> event) {
        WN.LOGGER.info("Registering " + surfaceBuilders.length + " surface builders...");
        int regEntry = event.getRegistry().getKeys().size();
        event.getRegistry().registerAll(
                surfaceBuilders
        );
        int regExit = event.getRegistry().getKeys().size();
        WN.LOGGER.info("Registered " + (regExit - regEntry) + " surface builders.");
    }
}
