package com.matez.wildnature.world.generation.geology.generators;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.world.generation.geology.GeoGeneratorConfig;
import com.matez.wildnature.world.generation.geology.GeoLayerConfig;
import net.minecraft.block.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicGenerator {

    private final GeoGeneratorConfig config;
    private final ArrayList<BlockState> strata;
    private final List<GeoLayerConfig> sediWeight;
    private final List<GeoLayerConfig> carboWeight;

    public BasicGenerator(GeoGeneratorConfig config, List<GeoLayerConfig> sediWeight, List<GeoLayerConfig> carboWeight, ArrayList<BlockState> strata){
        this.config = config;
        this.strata = strata;
        this.sediWeight = sediWeight;
        this.carboWeight = carboWeight;
    }

    public void apply(Random random, int dx, int dy, int dz){

        int sediLayers = dy / config.sedimentary.size();
        float index = config.noise.index(dx, dy);

        //iterate Tile.
        int i = 0;
        while (i < dy) {

            GeoLayerConfig layer;
            if(i > sediLayers) {
                layer = sediWeight.get(NoiseUtil.round(index * (sediWeight.size()-1)));
            }else{
                layer = carboWeight.get(NoiseUtil.round(index * (carboWeight.size()-1)));
            }

            BlockState state = layer.block.getDefaultState();
            int depth = NoiseUtil.round(layer.depth + (config.noise.GetNoise(dx, dz) * layer.offset));

            for(int di = 0; di < depth; di++){
                strata.add(state);
                i++;
            }

        }

    }

}
