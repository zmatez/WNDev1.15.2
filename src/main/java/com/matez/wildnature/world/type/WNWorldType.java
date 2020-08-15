package com.matez.wildnature.world.type;

import com.matez.wildnature.world.gen.biomes.layer.WNBiomeLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.CreateWorldScreen;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.layer.*;
import net.minecraftforge.common.extensions.IForgeWorldType;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

import java.util.function.LongFunction;

public class WNWorldType extends WorldType implements IForgeWorldType {

    public WNWorldType(String name) {
        super(name);
    }

    @Override
    public WorldType getWorldType() {
        return this;
    }

    public double getHorizon(World world)
    {
        return 63D;
    }

    @Override
    public float getCloudHeight() {
        return 128F;
    }

    @Override
    public boolean hasCustomOptions() {
        return true;
    }

    @Override
    public void onCustomizeButton(Minecraft mc, CreateWorldScreen gui) {

    }

    @Override
    public <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> getBiomeLayer(IAreaFactory<T> parentLayer,
                                                                                                   OverworldGenSettings chunkSettings, LongFunction<C> contextFactory)
    {
        parentLayer = (new WNBiomeLayer(getWorldType(), chunkSettings)).apply(contextFactory.apply(200L), parentLayer);
        parentLayer = AddBambooForestLayer.INSTANCE.apply(contextFactory.apply(1001L), parentLayer);
        parentLayer = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, parentLayer, 2, contextFactory);
        parentLayer = EdgeBiomeLayer.INSTANCE.apply(contextFactory.apply(1000L), parentLayer);
        return parentLayer;
    }


}
