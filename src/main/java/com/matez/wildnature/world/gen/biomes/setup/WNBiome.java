package com.matez.wildnature.world.gen.biomes.setup;

import com.matez.wildnature.world.gen.feature.FeatureRegistry;
import com.matez.wildnature.world.gen.feature.configs.BlockWeightListConfig;
import com.matez.wildnature.world.gen.feature.configs.TreeWeightListConfig;
import com.matez.wildnature.world.gen.feature.features.PlantFeature;
import com.matez.wildnature.world.gen.feature.features.TreeFeature;
import com.matez.wildnature.Main;
import com.matez.wildnature.other.BlockWeighList;
import com.matez.wildnature.other.TreeWeighList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class WNBiome extends Biome {
    public WNBiomeBuilder wnBiomeBuilder;

    public BlockWeighList plants = new BlockWeighList();
    public int plantRate = 1;
    public TreeWeighList trees = new TreeWeighList();
    public int treeRate = 6;
    public float treeExtraChance = 0.1F;
    public int treeExtra = 1;


    private static Builder analyseBuilder(Builder builder){
        WNBiomeBuilder wnbuilder = (WNBiomeBuilder)builder;
        if(wnbuilder.getFog()==null){
            wnbuilder.fog(new WNBiomeBuilder.Fog(1,-1,-1));
        }
        if(wnbuilder.getTopography()==null){
            wnbuilder.topography(wnbuilder.getUnknownTopography());
        }
        if(wnbuilder.getClimate()==null){
            wnbuilder.climate(wnbuilder.getUnknownClimate());
        }
        return wnbuilder;
    }

    public static WNBiomeBuilder getWNBuilder(Builder builder){
        WNBiomeBuilder wnbuilder = (WNBiomeBuilder)builder;
        if(wnbuilder.getFog()==null){
            wnbuilder.fog(new WNBiomeBuilder.Fog(1,-1,-1));
        }
        if(wnbuilder.getTopography()==null){
            wnbuilder.topography(wnbuilder.getUnknownTopography());
        }
        if(wnbuilder.getClimate()==null){
            wnbuilder.climate(wnbuilder.getUnknownClimate());
        }
        return wnbuilder;
    }



    public WNBiome(String name, WNBiomeBuilder biomeBuilder) {
        super(biomeBuilder.getBiomeBuilder());
        wnBiomeBuilder = biomeBuilder;
        setRegistryName(Main.RegistryEvents.location(name));
        WNBiomes.registerBiomes.add(this);
        WNBiomes.biomesString.add(getRegistryName().getPath());
    }

    public void applyPlants(){
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FeatureRegistry.PLANT_FEATURE.withConfiguration(new BlockWeightListConfig(plants)).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(plantRate))));
    }

    public void applyTrees(){
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FeatureRegistry.TREE_FEATURE.withConfiguration(new TreeWeightListConfig(trees)).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(treeRate,treeExtraChance,treeExtra))));
    }


    //0.15F -> 0C  0.35F -> 20C   0.75F -> 50C
    public int getCelsiusTemperature(float temp){
        return (int)(temp*100)-15;
    }

    /*
    -1.0 - -50
    -0.90 - -45
    -0.80 - -40
    -0.70 - -35
    -0.60 - -30
    -0.50 - -25
    -0.40 - -20
    -0.30 - -15
    -0.20 - -10
    -0.10 - -5
    0.0 - 5
    0.10 - 10
    0.20 - 15
    0.30 - 20
    0.40 - 25
    0.50 - 30
    0.60 - 35
    0.70 - 40
    0.80 - 50
    0.90 - 60
    1.0 - 70
     */

    public int customColor(double noise, double modifier, int color1, int color2){
        return noise < modifier ? color1 : color2;
    }

    public int customColor3x(double noise, double modFrom, double modTo, int color1, int color2, int color3){
        if(noise<modFrom){
            return color1;
        }else if(noise>modTo){
            return color2;
        }else{
            return color3;
        }
    }

    @Override
    public int getGrassColor(double x, double z) {
        return this.getGrassColor(new BlockPos(x,0,z));
    }

    public int getGrassColor(BlockPos pos) {
        return super.getGrassColor(pos.getX(), pos.getZ());
    }

    @Override
    public int getFoliageColor() {
        return this.getFoliageColor(new BlockPos(0,0,0));
    }

    public int getFoliageColor(BlockPos pos) {
        return super.getFoliageColor();
    }
}
