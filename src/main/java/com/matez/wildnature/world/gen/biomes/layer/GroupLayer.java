package com.matez.wildnature.world.gen.biomes.layer;

import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.biomes.setup.BiomeGroups;
import com.matez.wildnature.blocks.config.ConfigSettings;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum GroupLayer implements IAreaTransformer2, IDimOffset1Transformer {
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger();

    public int apply(INoiseRandom noise, IArea area1, IArea area2, int int1, int int2) {
        int i = area1.getValue(this.func_215721_a(int1 + 1), this.func_215722_b(int2 + 1));
        int j = area2.getValue(this.func_215721_a(int1 + 1), this.func_215722_b(int2 + 1));

        int k = (j - 2) % ConfigSettings.biomeGroupChance;

        if (noise.random(ConfigSettings.biomeGroupSpawningSize) == 0 || k == 0) {
            int l = i;
            int x = 0;
            while(x< BiomeGroups.groups.size()){
                BiomeGroups.BiomeGroup group = BiomeGroups.groups.get(x);//grupa biomów
                if(group.getDefault()!=null && Registry.BIOME.getId(group.getDefault())==i){//czy domyślny biom jest wybrany, wygenerowany
                    Biome b = group.randomBiome();
                    if(!CommonConfig.blacklistedBiomes.contains(b)) {
                        l = Registry.BIOME.getId(b);//zamień domyślny biom na inny z grupy
                    }
                    break;
                }else if(group.randomBiome()!=null && Registry.BIOME.getId(group.randomBiome())==i){
                    Biome b = group.randomBiome();
                    if(!CommonConfig.blacklistedBiomes.contains(b)) {
                        l = Registry.BIOME.getId(b);//zamień jakiś biom na inny z grupy
                    }
                    break;
                }
                x++;
            }

            //System.out.println("GENERATING: " + group.getName() + " = " + Registry.BIOME.getByValue(l).getRegistryName());


            if (l != i) {
                return l;
            }
        }

        return i;
    }
}