package com.matez.wildnature.world.generation.geology;

import com.matez.wildnature.init.WN;
import com.matez.wildnature.world.generation.geology.strata.BasicGenerator;
import com.matez.wildnature.world.generation.geology.strata.BedrockGenerator;
import com.matez.wildnature.world.generation.geology.strata.RandomGenerator;
import com.matez.wildnature.world.generation.geology.strata.SurfaceGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.IChunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeologyGenerator {

    private Classification classification;
    private long seed;
    private Random random;
    private ArrayList<BlockState> tile;
    private List<GeoLayerConfig> strata;

    public GeologyGenerator(long seed){
        this.classification = new Classification();
        this.seed = seed;
        this.random = new Random(seed);
        this.tile = new ArrayList<>();
        this.strata = new ArrayList<>();
    }

    public void generateTile(GeoGeneratorConfig config, int dx, int dy, int dz){

        initWeightedList(config);

        if(config.type == GeoGeneratorConfig.Type.basic){
            new BasicGenerator(classification, config, strata, tile).apply(random, dx, dy, dz);
        }if(config.type == GeoGeneratorConfig.Type.random){
            new RandomGenerator(classification, config, strata, tile).apply(random, dx, dy, dz);
        }
        //ToDo: Mountain, fix random, filter types of rock.

        new BedrockGenerator().apply((int) config.noise.Get(dx,dz, 2, 4), tile);
        new SurfaceGenerator().apply(dy, random, tile);

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
        if(tile.size() < dy){
            WN.LOGGER.debug("strata iteration issues");
            for (int fallback = tile.size(); fallback <= dy; ++fallback){
                tile.add(Blocks.STONE.getDefaultState());
            }
        }

        for(int iy = 0; iy < dy; ++iy){
            blockPos.setY(iy);
            chunk.setBlockState(blockPos, tile.get(iy), false);
        }

        clear();

    }

    private void initWeightedList(GeoGeneratorConfig config){
        for(GeoLayerConfig layerConfig : config.geoLayers){
            for(int i = 0; i < layerConfig.weight; i++) {
                strata.add(layerConfig);
            }
        }
    }

    private void clear(){
        tile.clear();
        strata.clear();
    }

}
