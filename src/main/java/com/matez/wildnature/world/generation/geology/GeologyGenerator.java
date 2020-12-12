package com.matez.wildnature.world.generation.geology;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.geology.generators.BasicGenerator;
import com.matez.wildnature.world.generation.geology.generators.BedrockGenerator;
import com.matez.wildnature.world.generation.geology.generators.RandomGenerator;
import com.matez.wildnature.world.generation.geology.generators.SurfaceGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.IChunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeologyGenerator {

    private long seed;
    private Random random;
    private ArrayList<BlockState> strata;
    private List<GeoLayerConfig> soilWeight;
    private List<GeoLayerConfig> sediWeight;
    private List<GeoLayerConfig> carboWeight;

    public GeologyGenerator(long seed){
        this.seed = seed;
        this.random = new Random(seed);
        this.strata = new ArrayList<>();
        this.soilWeight = new ArrayList<>();
        this.sediWeight = new ArrayList<>();
        this.carboWeight = new ArrayList<>();
    }

    public void generateTile(GeoGeneratorConfig config, int dx, int dy, int dz){

        initWeightedLists(config);

        if(config.type == GeoGeneratorConfig.Type.basic){
            new BasicGenerator(config, sediWeight, carboWeight, strata).apply(random, dx, dy, dz);
        }
        if(config.type == GeoGeneratorConfig.Type.random){
            new RandomGenerator(config, sediWeight, carboWeight, strata).apply(random, dx, dy, dz);
        }

        new BedrockGenerator().apply((int) config.noise.Get(dx,dz, 2, 4), strata);
        new SurfaceGenerator().apply(dy, random, strata);

    }

    //Decorating a single Tile
    public void applyTile(IChunk chunk, BlockPos.Mutable blockPos, int dy){

        int sealevel = 63;
        if(dy < sealevel){
            for(int iy = dy; iy < sealevel; ++iy){
                blockPos.setY(iy);
                chunk.setBlockState(blockPos, Blocks.WATER.getDefaultState(), false);
            }
        }

        //fallback
        if(strata.size() < dy){
            WN.LOGGER.debug("strata iteration issues");
            for (int fallback = strata.size(); fallback <= dy; ++fallback){
                strata.add(Blocks.STONE.getDefaultState());
            }
        }

        for(int iy = 0; iy < dy; ++iy){
            blockPos.setY(iy);
            chunk.setBlockState(blockPos, strata.get(iy), false);
        }

        clear();

    }

    private void initWeightedLists(GeoGeneratorConfig config){
        //Create SOIL weighted selection
        for(GeoLayerConfig layerConfig : config.soil){
            for(int i = 0; i < layerConfig.weight; i++) {
                soilWeight.add(layerConfig);
            }
        }

        //Create SEDIMENTARY weighted selection
        for(GeoLayerConfig layerConfig : config.sedimentary){
            for(int i = 0; i < layerConfig.weight; i++) {
                sediWeight.add(layerConfig);
            }
        }

        //Create CARBONATE weighted selection
        for(GeoLayerConfig layerConfig : config.carbonate){
            for(int i = 0; i < layerConfig.weight; i++) {
                carboWeight.add(layerConfig);
            }
        }
    }

    private void clear(){
        strata.clear();
        soilWeight.clear();
        sediWeight.clear();
        carboWeight.clear();
    }

}
