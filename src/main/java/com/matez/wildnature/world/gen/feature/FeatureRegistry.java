package com.matez.wildnature.world.gen.feature;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.feature.configs.*;
import com.matez.wildnature.world.gen.feature.features.*;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureRadiusConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.CountConfig;
import net.minecraftforge.event.RegistryEvent;

public class FeatureRegistry {
    public static Feature<NoFeatureConfig> CACTUS_FEATURE;
    public static Feature<NoFeatureConfig> CANDY_CANE_FEATURE;
    public static Feature<NoFeatureConfig> CATTAIL_FEATURE;
    public static Feature<BlockFeatureConfig> CAVE_BUSH_FEATURE;
    public static Feature<BlockFeatureConfig> CAVE_STAR_FEATURE;
    public static Feature<NoFeatureConfig> CAVE_VINE_FEATURE;
    public static Feature<NoFeatureConfig> COBWEB_FEATURE;
    public static Feature<NoFeatureConfig> CORN_FEATURE;
    public static Feature<NoFeatureConfig> CORN_GRASS_FEATURE;
    public static Feature<BlockFeatureConfig> CROP_FEATURE;
    public static Feature<NoFeatureConfig> CRYSTAL_FEATURE;
    public static Feature<NoFeatureConfig> DEAD_BUSH_FEATURE;
    public static Feature<ReverseBushConfig> DOUBLE_CAVE_BUSH_FEATURE;
    public static Feature<BlockFeatureConfig> DOUBLE_GRASS_FEATURE;
    public static Feature<BlockFeatureConfig> DOUBLE_PLANT_FEATURE;
    public static Feature<NoFeatureConfig> GEYSER_FEATURE;
    public static Feature<BlockFeatureConfig> GRASS;
    public static Feature<NoFeatureConfig> GREEN_BEAN_FEATURE;
    public static Feature<BlockFeatureConfig> JELLYSHROOM_FEATURE;
    public static Feature<BlockFeatureConfig> LAVALILY_FEATURE;
    public static Feature<NoFeatureConfig> LAVENDER_FEATURE;
    public static Feature<NoFeatureConfig> MARIGOLD_FEATURE;
    public static Feature<NoFeatureConfig> MELON_FEATURE;
    public static Feature<BlockWeightListConfig> MUSHROOM_FEATURE;
    public static Feature<NoFeatureConfig> PEBBLE_FEATURE;
    public static Feature<BlockWeightListConfig> PLANT_FEATURE;
    public static Feature<NoFeatureConfig> REEDS_FEATURE;
    public static Feature<NoFeatureConfig> RIVER_CANE_FEATURE;
    public static Feature<NoFeatureConfig> SHELL_FEATURE;
    public static Feature<BlockWeightListAndSpawnChanceConfig> SINGLE_PLANT_FEATURE;
    public static Feature<BlockFeatureConfig> SLIME_CAVE_BUSH_FEATURE;
    public static Feature<NoFeatureConfig> STALAGMITE_FEATURE;
    public static Feature<NoFeatureConfig> STREAM_FEATURE;
    public static Feature<StructureWeightListConfig> STRUCTURE_FEATURE;
    public static Feature<FeatureRadiusConfig> SURFACE_BLOB_FEATURE;
    public static Feature<TreeWeightListConfig> TREE_FEATURE;
    public static Feature<BlockFeatureConfig> UNDERWATER_CAVE_BUSH_FEATURE;
    public static Feature<BlockFeatureConfig> WATERLILY_FEATURE;
    public static Feature<WNBlobConfig> BLOB_FEATURE;
    public static Feature<BlockFeatureConfig> BUSH_FEATURE;
    public static Feature<NoFeatureConfig> FRUIT_FEATURE;
    public static Feature<CountConfig> LEAF_FREEZE_FEATURE;
    public static Feature<CountConfig> MOSS_FEATURE;
    public static Feature<WNOreFeatureConfig> ORE_FEATURE;
    public static Feature<BlockFeatureConfig> SCATTERED_PLANT_FEATURE;
    public static Feature<BlockFeatureConfig> TREE_VINES_FEATURE;
    public static Feature<NoFeatureConfig> VEGE_FEATURE;
    public static Feature<BlockFeatureConfig> VINES_FEATURE;
    public static Feature<CountConfig> WATER_FEATURE;
    public static Feature<BlockFeatureConfig> WILD_FARM_FEATURE;
    public static Feature<BlockFeatureConfig> WISTERIA_FEATURE;

    private static Feature<?>[] features = new Feature<?>[]{
            CACTUS_FEATURE = new CactusFeature(NoFeatureConfig::deserialize),
            CANDY_CANE_FEATURE = new CandyCaneFeature(NoFeatureConfig::deserialize),
            CATTAIL_FEATURE = new CattailFeature(NoFeatureConfig::deserialize),
            CAVE_BUSH_FEATURE = new CaveBushFeature(BlockFeatureConfig::deserialize),
            CAVE_STAR_FEATURE = new CaveStarFeature(BlockFeatureConfig::deserialize),
            CAVE_VINE_FEATURE = new CaveVineFeature(NoFeatureConfig::deserialize),
            COBWEB_FEATURE = new CobwebFeature(NoFeatureConfig::deserialize),
            CORN_FEATURE = new CornFeature(NoFeatureConfig::deserialize),
            CORN_GRASS_FEATURE = new CornGrassFeature(NoFeatureConfig::deserialize),
            CROP_FEATURE = new CropFeature(BlockFeatureConfig::deserialize),
            CRYSTAL_FEATURE = new CrystalFeature(NoFeatureConfig::deserialize),
            DEAD_BUSH_FEATURE = new DeadBushFeature(NoFeatureConfig::deserialize),
            DOUBLE_CAVE_BUSH_FEATURE = new DoubleCaveBushFeature(ReverseBushConfig::deserialize),
            DOUBLE_GRASS_FEATURE = new DoubleGrassFeature(BlockFeatureConfig::deserialize),
            DOUBLE_PLANT_FEATURE = new DoublePlantFeature(BlockFeatureConfig::deserialize),
            GEYSER_FEATURE = new GeyserFeature(NoFeatureConfig::deserialize),
            GRASS = new GrassFeature(BlockFeatureConfig::deserialize),
            GREEN_BEAN_FEATURE = new GreenBeanFeature(NoFeatureConfig::deserialize),
            JELLYSHROOM_FEATURE = new JellyshroomFeature(BlockFeatureConfig::deserialize),
            LAVALILY_FEATURE = new LavalilyFeature(BlockFeatureConfig::deserialize),
            LAVENDER_FEATURE = new LavenderFeature(NoFeatureConfig::deserialize),
            MARIGOLD_FEATURE = new MarigoldFeature(NoFeatureConfig::deserialize),
            MELON_FEATURE = new MelonFeature(NoFeatureConfig::deserialize),
            MUSHROOM_FEATURE = new MushroomFeature(BlockWeightListConfig::deserialize),
            PEBBLE_FEATURE = new PebbleFeature(NoFeatureConfig::deserialize),
            PLANT_FEATURE = new PlantFeature(BlockWeightListConfig::deserialize),
            REEDS_FEATURE = new ReedsFeature(NoFeatureConfig::deserialize),
            RIVER_CANE_FEATURE = new RiverCaneFeature(NoFeatureConfig::deserialize),
            SHELL_FEATURE = new ShellFeature(NoFeatureConfig::deserialize),
            SINGLE_PLANT_FEATURE = new SinglePlantFeature(BlockWeightListAndSpawnChanceConfig::deserialize),
            SLIME_CAVE_BUSH_FEATURE = new SlimeCaveBushFeature(BlockFeatureConfig::deserialize),
            STALAGMITE_FEATURE = new StalagmiteFeature(NoFeatureConfig::deserialize),
            STREAM_FEATURE = new StreamFeature(NoFeatureConfig::deserialize),
            STRUCTURE_FEATURE = new StructureFeature(StructureWeightListConfig::deserialize),
            SURFACE_BLOB_FEATURE = new SurfaceBlobFeature(FeatureRadiusConfig::deserialize),
            TREE_FEATURE = new TreeFeature(TreeWeightListConfig::deserialize),
            UNDERWATER_CAVE_BUSH_FEATURE = new UnderwaterCaveBushFeature(BlockFeatureConfig::deserialize),
            WATERLILY_FEATURE = new WaterlilyFeature(BlockFeatureConfig::deserialize),
            BLOB_FEATURE = new WNBlobFeature(WNBlobConfig::deserialize),
            BUSH_FEATURE = new WNBushFeature(BlockFeatureConfig::deserialize),
            FRUIT_FEATURE = new WNFruitFeature(NoFeatureConfig::deserialize),
            LEAF_FREEZE_FEATURE = new WNLeafFreezeFeature(CountConfig::deserialize),
            MOSS_FEATURE = new WNMossFeature(CountConfig::deserialize),
            ORE_FEATURE = new WNOreFeature(WNOreFeatureConfig::deserialize),
            SCATTERED_PLANT_FEATURE = new WNScatteredPlantFeature(BlockFeatureConfig::deserialize),
            TREE_VINES_FEATURE = new WNTreeVinesFeature(BlockFeatureConfig::deserialize),
            VEGE_FEATURE = new WNVegeFeature(NoFeatureConfig::deserialize),
            VINES_FEATURE = new WNVinesFeature(BlockFeatureConfig::deserialize),
            WATER_FEATURE = new WNWaterFeature(CountConfig::deserialize),
            WILD_FARM_FEATURE = new WNWildFarmFeature(BlockFeatureConfig::deserialize),
            WISTERIA_FEATURE = new WNWisteriaFeature(BlockFeatureConfig::deserialize)
    };

    public static void registerAll(final RegistryEvent.Register<Feature<?>> event) {
        Main.LOGGER.info("Registering " + features.length + " features...");
        int regEntry = event.getRegistry().getKeys().size();
        event.getRegistry().registerAll(
                features
        );
        int regExit = event.getRegistry().getKeys().size();
        Main.LOGGER.info("Registered " + (regExit-regEntry) + " features.");
    }
}
