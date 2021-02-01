package com.matez.wildnature.world.generation.geology.strata;

import com.matez.wildnature.util.noise.NoiseUtil;
import com.matez.wildnature.world.generation.geology.Classification;
import com.matez.wildnature.world.generation.geology.GeoGeneratorConfig;
import com.matez.wildnature.world.generation.geology.GeoLayerConfig;
import net.minecraft.block.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicGenerator {

    private final Classification classification;
    private final GeoGeneratorConfig config;
    private final ArrayList<BlockState> tile;
    private final List<GeoLayerConfig> strata;
    private final List<GeoLayerConfig> filterStrata;

    public BasicGenerator(Classification classification, GeoGeneratorConfig config, List<GeoLayerConfig> strata, ArrayList<BlockState> tile){
        this.classification = classification;
        this.config = config;
        this.tile = tile;
        this.strata = strata;
        this.filterStrata = new ArrayList<>();
    }

    public void apply(Random random, int dx, int dy, int dz){

        int sediLayers = dy / config.geoLayers.size();
        float index = config.noise.index(dx, dy);

        //iterate Tile.
        int i = 0;
        GeoLayerConfig layer;
        GeoLayerConfig result = null;
        while (i < dy) {

            layer = strata.get(NoiseUtil.round(index * (strata.size() - 1)));

            BlockState state = layer.block.getDefaultState();
            int depth = NoiseUtil.round(layer.depth + (config.noise.GetNoise(dx, dz) * layer.offset));

            for(int di = 0; di < depth; di++){
                tile.add(state);
                i++;
            }

        }

    }

}
