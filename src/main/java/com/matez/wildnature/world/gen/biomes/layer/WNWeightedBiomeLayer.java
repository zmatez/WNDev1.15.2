package com.matez.wildnature.world.gen.biomes.layer;

import com.matez.wildnature.world.gen.biomes.setup.EnumBiomes;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;

public enum WNWeightedBiomeLayer implements IAreaTransformer1, IDimOffset0Transformer
{
	INSTANCE;
	
	private static final int DEEP_OCEAN = Registry.BIOME.getId(Biomes.DEEP_OCEAN);
    private static final int MUSHROOM_FIELDS = Registry.BIOME.getId(Biomes.MUSHROOM_FIELDS);

	@Override
	public int func_215728_a(IExtendedNoiseRandom<?> context, IArea landFactory, int x, int z) 
	{
		int landSeaVal = landFactory.getValue(x, z);
		
		if (landSeaVal == DEEP_OCEAN)
        {
            return DEEP_OCEAN;
        }
        else if (landSeaVal == MUSHROOM_FIELDS)
        {
            return landSeaVal;
        }
        else if (landSeaVal == 0)
        {
            return Registry.BIOME.getId(Biomes.OCEAN);
        }
        else
        {
        	return Registry.BIOME.getId(EnumBiomes.ALL.randomBiome(context)); // Returns a random biome from the weighted list
        }
	}
}
