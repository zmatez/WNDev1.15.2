package com.matez.wildnature.world.generation.layer;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.config.CommonConfig;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.*;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;

import java.util.function.LongFunction;

public class WNLayerUtil extends LayerUtil {
    protected static final int WARM_OCEAN = Registry.BIOME.getId(Biomes.WARM_OCEAN);
    protected static final int LUKEWARM_OCEAN = Registry.BIOME.getId(Biomes.LUKEWARM_OCEAN);
    protected static final int OCEAN = Registry.BIOME.getId(Biomes.OCEAN);
    protected static final int COLD_OCEAN = Registry.BIOME.getId(Biomes.COLD_OCEAN);
    protected static final int FROZEN_OCEAN = Registry.BIOME.getId(Biomes.FROZEN_OCEAN);
    protected static final int DEEP_WARM_OCEAN = Registry.BIOME.getId(Biomes.DEEP_WARM_OCEAN);
    protected static final int DEEP_LUKEWARM_OCEAN = Registry.BIOME.getId(Biomes.DEEP_LUKEWARM_OCEAN);
    protected static final int DEEP_OCEAN = Registry.BIOME.getId(Biomes.DEEP_OCEAN);
    protected static final int DEEP_COLD_OCEAN = Registry.BIOME.getId(Biomes.DEEP_COLD_OCEAN);
    protected static final int DEEP_FROZEN_OCEAN = Registry.BIOME.getId(Biomes.DEEP_FROZEN_OCEAN);

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> repeat(long seed, IAreaTransformer1 parent, IAreaFactory<T> p_202829_3_, int count, LongFunction<C> contextFactory) {
        IAreaFactory<T> iareafactory = p_202829_3_;

        for(int i = 0; i < count; ++i) {
            iareafactory = parent.apply(contextFactory.apply(seed + (long)i), iareafactory);
        }

        return iareafactory;
    }
    
    // Creates the biome factory with a custom biome layer (no vanilla biomes)
    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> createBiomeFactory(LongFunction<C> context, IAreaFactory<T> landFactory)
    {
    	IAreaFactory<T> biomeFactory = WNWeightedBiomeLayer.INSTANCE.apply(context.apply(200L), landFactory);
    	biomeFactory = AddBambooForestLayer.INSTANCE.apply(context.apply(1001L), biomeFactory);
    	biomeFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, biomeFactory, 2, context);
    	biomeFactory = WNEdgeBiomeLayer.INSTANCE.apply(context.apply(1000L), biomeFactory);
    	
    	return biomeFactory;
    }



    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> func_227475_a_(WorldType worldType, OverworldGenSettings settings, LongFunction<C> context) {
        WN.wnInfo("Using WNLayer");

        IAreaFactory<T> terrainFactory = IslandLayer.INSTANCE.apply(context.apply(1L));
        terrainFactory = ZoomLayer.FUZZY.apply(context.apply(2000L), terrainFactory);
        terrainFactory = AddIslandLayer.INSTANCE.apply(context.apply(1L), terrainFactory);
        terrainFactory = ZoomLayer.NORMAL.apply(context.apply(2001L), terrainFactory);
        terrainFactory = AddIslandLayer.INSTANCE.apply(context.apply(2L), terrainFactory);
        terrainFactory = AddIslandLayer.INSTANCE.apply(context.apply(50L), terrainFactory);
        terrainFactory = AddIslandLayer.INSTANCE.apply(context.apply(70L), terrainFactory);
        terrainFactory = RemoveTooMuchOceanLayer.INSTANCE.apply(context.apply(2L), terrainFactory);
        IAreaFactory<T> iareafactory1 = OceanLayer.INSTANCE.apply(context.apply(2L));
        iareafactory1 = repeat(2001L, ZoomLayer.NORMAL, iareafactory1, 6, context);
        terrainFactory = AddSnowLayer.INSTANCE.apply(context.apply(2L), terrainFactory);
        terrainFactory = AddIslandLayer.INSTANCE.apply(context.apply(3L), terrainFactory);
        terrainFactory = EdgeLayer.CoolWarm.INSTANCE.apply(context.apply(2L), terrainFactory);
        terrainFactory = EdgeLayer.HeatIce.INSTANCE.apply(context.apply(2L), terrainFactory);
        terrainFactory = EdgeLayer.Special.INSTANCE.apply(context.apply(3L), terrainFactory);
        terrainFactory = ZoomLayer.NORMAL.apply(context.apply(2002L), terrainFactory);
        terrainFactory = ZoomLayer.NORMAL.apply(context.apply(2003L), terrainFactory);
        terrainFactory = AddIslandLayer.INSTANCE.apply(context.apply(4L), terrainFactory);
        terrainFactory = AddMushroomIslandLayer.INSTANCE.apply(context.apply(5L), terrainFactory);
        terrainFactory = WNIslandLayer.INSTANCE.apply(context.apply(5L), terrainFactory);
        terrainFactory = DeepOceanLayer.INSTANCE.apply(context.apply(4L), terrainFactory);
        terrainFactory = repeat(1000L, ZoomLayer.NORMAL, terrainFactory, 0, context);


        int i = 4;
        int j = i;
        if (settings != null) {
            i = CommonConfig.biomeSize.get();
            j = CommonConfig.riverSize.get();
        }

        if (worldType == WorldType.LARGE_BIOMES) {
            i = 6;
        }

        i = getModdedBiomeSize(worldType, i);


        IAreaFactory<T> riverFactory = repeat(1000L, ZoomLayer.NORMAL, terrainFactory, 0, context);
        riverFactory = StartRiverLayer.INSTANCE.apply((IExtendedNoiseRandom)context.apply(100L), riverFactory);
        IAreaFactory<T> biomeFactory = null;

        if(!CommonConfig.generateOnlyWildNature.get()) {
            biomeFactory = worldType.getBiomeLayer(terrainFactory, settings, context);
        }else {
            biomeFactory = createBiomeFactory(context, riverFactory);
        }

        IAreaFactory<T> lvt_9_1_ = repeat(1000L, ZoomLayer.NORMAL, riverFactory, 2, context);
        biomeFactory = WNGroupLayer.INSTANCE.apply((IExtendedNoiseRandom)context.apply(1000L), biomeFactory, lvt_9_1_);
        biomeFactory = HillsLayer.INSTANCE.apply((IExtendedNoiseRandom)context.apply(1000L), biomeFactory, lvt_9_1_);

        riverFactory = repeat(1000L, ZoomLayer.NORMAL, riverFactory, 2, context);
        riverFactory = repeat(1000L, ZoomLayer.NORMAL, riverFactory, j, context);

        riverFactory = WNRiverLayer.INSTANCE.apply((IExtendedNoiseRandom)context.apply(1L), riverFactory);
        riverFactory = SmoothLayer.INSTANCE.apply((IExtendedNoiseRandom)context.apply(1000L), riverFactory);
        riverFactory = repeat(1000L, ZoomLayer.NORMAL, riverFactory, 3, context);

        biomeFactory = RareBiomeLayer.INSTANCE.apply((IExtendedNoiseRandom)context.apply(1001L), biomeFactory);



        for(int k = 0; k < i - (i>4 ? 4 : 0); ++k) {
            biomeFactory = ZoomLayer.NORMAL.apply((IExtendedNoiseRandom)context.apply((long)(1000 + k)), biomeFactory);
        }

        for(int k = 0; k < (i>4 ? 4 : 4-i); ++k) {
            biomeFactory = ZoomLayer.NORMAL.apply((IExtendedNoiseRandom)context.apply((long)(1000 + k)), biomeFactory);
            if (k == 0) {
                biomeFactory = AddIslandLayer.INSTANCE.apply((IExtendedNoiseRandom)context.apply(3L), biomeFactory);
            }

            if (k == 1 || i == 1) {
                biomeFactory = WNShoreLayer.INSTANCE.apply((IExtendedNoiseRandom)context.apply(1000L), biomeFactory);
            }
        }

        biomeFactory = SmoothLayer.INSTANCE.apply((IExtendedNoiseRandom)context.apply(1000L), biomeFactory);
        biomeFactory = WNMixRiverLayer.INSTANCE.apply((IExtendedNoiseRandom)context.apply(100L), biomeFactory, riverFactory);
        biomeFactory = MixOceansLayer.INSTANCE.apply(context.apply(100L), biomeFactory, iareafactory1);
        return biomeFactory;
    }

    public static Layer func_227474_a_(long seed, WorldType type, OverworldGenSettings settings) {
        int i = 25;
        IAreaFactory<LazyArea> iareafactory = func_227475_a_(type, settings, (p_227473_2_) -> {
            return new LazyAreaLayerContext(25, seed, p_227473_2_);
        });
        return new Layer(iareafactory);
    }

    public static boolean areBiomesSimilar(int p_202826_0_, int p_202826_1_) {
        if (p_202826_0_ == p_202826_1_) {
            return true;
        } else {
            Biome biome = Registry.BIOME.getByValue(p_202826_0_);
            Biome biome1 = Registry.BIOME.getByValue(p_202826_1_);
            if (biome != null && biome1 != null) {
                if (biome != Biomes.WOODED_BADLANDS_PLATEAU && biome != Biomes.BADLANDS_PLATEAU) {
                    if (biome.getCategory() != Biome.Category.NONE && biome1.getCategory() != Biome.Category.NONE && biome.getCategory() == biome1.getCategory()) {
                        return true;
                    } else {
                        return biome == biome1;
                    }
                } else {
                    return biome1 == Biomes.WOODED_BADLANDS_PLATEAU || biome1 == Biomes.BADLANDS_PLATEAU;
                }
            } else {
                return false;
            }
        }
    }


    /* ======================================== FORGE START =====================================*/
    public static int getModdedBiomeSize(WorldType worldType, int original)
    {
        net.minecraftforge.event.terraingen.WorldTypeEvent.BiomeSize event = new net.minecraftforge.event.terraingen.WorldTypeEvent.BiomeSize(worldType, original);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
        return event.getNewSize();
    }
    /* ========================================= FORGE END ======================================*/

    public static boolean isOcean(int biomeIn) {
        return biomeIn == WARM_OCEAN || biomeIn == LUKEWARM_OCEAN || biomeIn == OCEAN || biomeIn == COLD_OCEAN || biomeIn == FROZEN_OCEAN || biomeIn == DEEP_WARM_OCEAN || biomeIn == DEEP_LUKEWARM_OCEAN || biomeIn == DEEP_OCEAN || biomeIn == DEEP_COLD_OCEAN || biomeIn == DEEP_FROZEN_OCEAN;
    }

    public static boolean isShallowOcean(int biomeIn) {
        return biomeIn == WARM_OCEAN || biomeIn == LUKEWARM_OCEAN || biomeIn == OCEAN || biomeIn == COLD_OCEAN || biomeIn == FROZEN_OCEAN;
    }
}
