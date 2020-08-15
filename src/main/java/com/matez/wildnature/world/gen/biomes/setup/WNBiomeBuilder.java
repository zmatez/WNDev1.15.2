package com.matez.wildnature.world.gen.biomes.setup;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WNBiomeBuilder extends Biome.Builder {
    @Nullable
    private ConfiguredSurfaceBuilder<?> surfaceBuilder;
    @Nullable
    private Biome.RainType precipitation;
    @Nullable
    private Biome.Category category;
    @Nullable
    private Topography topography;
    @Nullable
    private Climate climate;
    @Nullable
    private Float depth;
    @Nullable
    private Float scale;
    @Nullable
    private Float heightVariation;
    @Nullable
    private Float temperature;
    @Nullable
    private Float downfall;
    @Nullable
    private Integer waterColor;
    @Nullable
    private Integer waterFogColor;
    @Nullable
    private Fog fog;
    @Nullable
    private String parent;

    public Biome.Builder getBiomeBuilder(){
        return new Biome.Builder()
                .surfaceBuilder(surfaceBuilder)
                .precipitation(precipitation)
                .category(category)
                .depth(depth)
                .scale(scale)
                .temperature(temperature)
                .downfall(downfall)
                .waterColor(waterColor)
                .waterFogColor(waterFogColor)
                .parent(parent);

    }

    public <SC extends ISurfaceBuilderConfig> WNBiomeBuilder surfaceBuilder(SurfaceBuilder<SC> p_222351_1_, SC p_222351_2_) {
        this.surfaceBuilder = new ConfiguredSurfaceBuilder<>(p_222351_1_, p_222351_2_);
        return this;
    }

    public WNBiomeBuilder surfaceBuilder(ConfiguredSurfaceBuilder<?> surfaceBuilderIn) {
        this.surfaceBuilder = surfaceBuilderIn;
        return this;
    }

    public WNBiomeBuilder precipitation(Biome.RainType precipitationIn) {
        this.precipitation = precipitationIn;
        return this;
    }

    //category - Forest, Plains, Hills
    public WNBiomeBuilder category(Biome.Category biomeCategory) {
        this.category = biomeCategory;
        return this;
    }

    //topography - lowlands, mountains, lake district, sea district, basin(kotliny)
    public WNBiomeBuilder topography(Topography biometopography) {
        this.topography = biometopography;
        return this;
    }

    //climate - Polar, Subpolar, Temperate
    public WNBiomeBuilder climate(Climate biomeClimate) {
        this.climate = biomeClimate;
        return this;
    }

    public WNBiomeBuilder depth(float depthIn) {
        this.depth = depthIn;
        return this;
    }

    public WNBiomeBuilder scale(float scaleIn) {
        this.scale = scaleIn;
        return this;
    }

    //1 - max smooth, -1 - max hills
    public WNBiomeBuilder heightVariation(float heightVariation) {
        this.heightVariation = heightVariation;
        return this;
    }

    public WNBiomeBuilder temperature(float temperatureIn) {
        this.temperature = temperatureIn;
        return this;
    }

    public WNBiomeBuilder downfall(float downfallIn) {
        this.downfall = downfallIn;
        return this;
    }

    public WNBiomeBuilder waterColor(int waterColorIn) {
        this.waterColor = waterColorIn;
        return this;
    }

    public WNBiomeBuilder waterFogColor(int waterFogColorIn) {
        this.waterFogColor = waterFogColorIn;
        return this;
    }


    public WNBiomeBuilder fog(Fog fog) {
        this.fog=fog;
        return this;
    }

    public WNBiomeBuilder parent(@Nullable String parentIn) {
        this.parent = parentIn;
        return this;
    }

    public String toString() {
        return "WNBiomeBuilder{\nsurfaceBuilder=" + this.surfaceBuilder + ",\nprecipitation=" + this.precipitation + ",\nbiomeCategory=" + this.category + ",\ntopography=" + this.topography +",\nclimate=" + this.climate +",\ndepth=" + this.depth + ",\nscale=" + this.scale + ",\ntemperature=" + this.temperature + ",\ndownfall=" + this.downfall + ",\nwaterColor=" + this.waterColor + ",\nwaterFogColor=" + this.waterFogColor + ",\nparent='" + this.parent + '\'' + "\n" + '}';
    }


    @Nullable
    public Float getHeightVariation() {
        return heightVariation;
    }

    @Nullable
    public Float getScale() {
        return scale;
    }

    @Nullable
    public Float getDepth() {
        return depth;
    }

    public static class Fog{
        private int fogStatus;
        private int color;
        private double density;
        private int defaultColor = 0xffffff;
        private float defaultDensity = 0.1F;

        /**
         *
         * @param fogStatus 0 - no fog 1 - morning fog 2 - foggy biome
         * @param color fog color
         * @param density fog density(default - )
         */
        public Fog(int fogStatus, int color, float density){
            this.fogStatus = fogStatus;
            this.color=color;
            this.density=density;

            if(color==-1){
                this.color=defaultColor;
            }
            if(density==-1){
                this.density=defaultDensity;
            }
        }
    }

    public static enum Climate {
        NONE("none"),
        //strefa okołobiegunowa:
        POLAR("polar"),
        SUBPOLAR("subpolar"),
        //strefa umiarkowana chłodna:
        CONTINENTAL_COOL("cool_continental"),
        OCEANIC_COOL("cool_oceanic"),
        //strefa umiarkowana ciepła:
        CONTINENTAL_WARM("warm_continental"),
        OCEANIC_WARM("warm_oceanic"),
        //strefa podzwrotnikowa:
        DRY_SUBTROPICAL("dry_subtropical"),
        MOIST_SUBTROPICAL("moist_subtropical"),
        //strefa zwrotnikowa i równikowa
        DRY_TROPICAL("dry_tropical"),
        MOIST_TROPICAL("moist_tropical");


        private static final Map<String, Climate> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(Climate::getName, (name) -> {
            return name;
        }));
        private final String name;

        private Climate(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public static enum Topography {
        NONE("none"),
        LOWLANDS("lowlands"),
        HIGHLANDS("highlands"),
        LOW_MOUNTAINS("low_mountains"),
        HIGH_MOUNTAINS("high_mountains"),
        LAKE_DISTRICT("lake_district"),
        SEA_DISTRICT("sea_district"),
        BASIN("basin");








        private static final Map<String, Topography> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(Topography::getName, (name) -> {
            return name;
        }));
        private final String name;

        private Topography(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    @Nullable
    public Climate getClimate() {
        return climate;
    }

    @Nullable
    public Topography getTopography() {
        return topography;
    }

    @Nullable
    public Fog getFog() {
        return fog;
    }

    public Climate getUnknownClimate(){
        return Climate.CONTINENTAL_COOL;
    }

    public Topography getUnknownTopography(){
        return Topography.LOWLANDS;
    }
}
