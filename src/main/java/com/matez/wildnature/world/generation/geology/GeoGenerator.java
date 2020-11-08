package com.matez.wildnature.world.generation.geology;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.util.noise.NoiseUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeoGenerator {

    public final List<Block> sedimentary;
    public final List<Block> carbonate;
    public final GeoConfig config;
    public List<StrataLayer> strata;
    public List<BlockState> blockState;

    public GeoGenerator(GeoConfig geoConfig) {
        this.config = geoConfig;
        this.sedimentary = config.getSedimentary();
        this.carbonate = config.getCarbonate();
    }

    //fully wild and random.
    public void generateRandomLayers(Random random, float index) {

        //init the list
        strata = new ArrayList<>();

        //get the layerCount
        int layerCount = config.getLayers(index);

        //add the layers to the strata list
        for (int li = 0; li < layerCount; li++) {

            if(random.nextInt(layerCount) < li) {
                int select = random.nextInt(sedimentary.size());
                BlockState blockState = sedimentary.get(select).getDefaultState();
                int depth = config.getDepth(random.nextFloat());
                strata.add(new StrataLayer(blockState, depth));
            }else{
                int select = random.nextInt(carbonate.size());
                BlockState blockState = carbonate.get(select).getDefaultState();
                int depth = config.getDepth(random.nextFloat());
                strata.add(new StrataLayer(blockState, depth));
            }

        }

    }

    //We use the index noise to give a bit more control over scale, but also flattens the results a bit.
    public void generateIndexLayers(Random random, float index) {

        //init the list
        strata = new ArrayList<>();

        //get the layerCount
        int layerCount = config.getLayers(index);

        //add the layers to the strata list
        for (int li = 0; li < layerCount; li++) {

            if(NoiseUtil.round(index * layerCount) < li) {
                int select = NoiseUtil.round(index * random.nextInt(sedimentary.size()));
                BlockState blockState = sedimentary.get(select).getDefaultState();
                int depth = config.getDepth(index);
                strata.add(new StrataLayer(blockState, depth));
            }else{
                int select = NoiseUtil.round(index * random.nextInt(carbonate.size()));
                BlockState blockState = carbonate.get(select).getDefaultState();
                int depth = config.getDepth(index);
                strata.add(new StrataLayer(blockState, depth));
            }

        }

    }

    //Preset speciffically tuned for mountain terrains
    public void generateMountainLayers(Random random, float index, int dy) {

        //init the list
        strata = new ArrayList<>();

        //get the layerCount
        int layerCount = config.getLayers(index);
        int layerSize = dy / layerCount;

        //Making sure Carbonate rocks have a good change to dominate mountain tops roughly simulating irl strata movement.
        if(dy > 80+NoiseUtil.round(index*70)){
            //add the layers to the strata list
            for(int li = 0; li < layerSize; li++){

                int select = NoiseUtil.round(index * random.nextInt(carbonate.size()));
                BlockState blockState = carbonate.get(select).getDefaultState();
                int depth = layerSize + random.nextInt(config.getDepth(index));
                strata.add(new StrataLayer(blockState, depth));

            }
        }else{
            //add the layers to the strata list
            for(int li = 0; li < layerSize; li++){

                if(NoiseUtil.round(index * layerSize) < li) {

                    int select = random.nextInt(sedimentary.size());
                    BlockState blockState = sedimentary.get(select).getDefaultState();
                    int depth = dy / config.getDepth(index);
                    strata.add(new StrataLayer(blockState, depth));

                }else{

                    int select = NoiseUtil.round(index * random.nextInt(carbonate.size()));
                    BlockState blockState = carbonate.get(select).getDefaultState();
                    int depth = dy / config.getDepth(index);
                    strata.add(new StrataLayer(blockState, depth));

                }


            }
        }

        //fallback
        if(strata.size() < 1) {
            WN.LOGGER.error("Preset error");
            strata.add(new StrataLayer(sedimentary.get(random.nextInt(sedimentary.size())).getDefaultState(), layerSize));
        }

    }

    public int noiseOffset(float index, int dy){
        return NoiseUtil.round(index * dy);
    }

    public void generateStrata(int dy){
        //init the list
        blockState = new ArrayList<>();
        //create a list with BlockStates for the TileColumn
        for (StrataLayer stratum : strata) {

            //returns when we don't need more data to fill the column;
            if(blockState.size() > dy){
                //Akuiria.LOGGER.debug("return list");
                break;
            }

            int depth = stratum.getDepth();
            BlockState state = stratum.getState();

            //adds depth to current list.
            for (int di = 0; di < depth; di++) {
                blockState.add(state);
            }

        }

        //fallback, just adds the latest BlockState until the list equals dy.
        if(blockState.size() <= dy) {
            BlockState fallback = strata.get(strata.size()-1).state;
            for (int ae = blockState.size(); ae <= dy; ae++) {
                blockState.add(fallback);
            }
        }

        /**
        Interesting logger name Matez - Sipke
         */
        //Akuiria.LOGGER.debug("statesize: " + blockState.size() + " dy: " + dy);

    }

    //Helping the garbage collection
    public void clear(){
        strata.clear();
        blockState.clear();
    }

    public static class StrataLayer {

        private final BlockState state;
        private final int depth;

        public StrataLayer(BlockState state, int depth){
            this.state = state;
            this.depth = depth;
        }

        public BlockState getState(){
            return state;
        }

        public int getDepth(){
            return depth;
        }

    }

}