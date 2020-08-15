package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.other.WeightedList;
import com.matez.wildnature.world.gen.feature.FeatureRegistry;
import com.matez.wildnature.world.gen.feature.configs.BlockFeatureConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Random;
import java.util.function.Function;

public class WNVegeFeature extends Feature<NoFeatureConfig> {
    public static WeightedList<BushEntry> entries = new WeightedList<>();
    public WNVegeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49915_1_) {
        super(p_i49915_1_);
        setRegistryName("wildnature","vege_feature");
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if(!worldIn.getDimension().isSurfaceWorld()){
            return false;
        }
        if(Utilities.rint(0,CommonConfig.vegeCropChance.get())!=0){
            return false;
        }
        WeightedList<BushEntry> available = new WeightedList<>();

        entries.forEach(e -> {
            if(e.canSpawnHere(pos,worldIn)){
                available.add(e,entries.getRarityFor(e));
            }
        });

        //biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new shrub1(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:bush_raspberry").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:bush_raspberry")).with(FruitableLeaves.STAGE, Utilities.rint(0,1))), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(2,64,0,100)));

        if(!available.isEmpty()) {
            BushEntry b = (BushEntry) Utilities.getWeightedEntry(available, rand);
            assert b != null;
            try {
                if(!CommonConfig.vegeGrassSpawn.get()) {
                    if (b.needsFarmland()) {
                        FeatureRegistry.WILD_FARM_FEATURE.place(worldIn, generator, rand, pos, new BlockFeatureConfig(b.getBush()));
                    } else {
                        FeatureRegistry.BUSH_FEATURE.place(worldIn, generator, rand, pos, new BlockFeatureConfig(b.getBush()));

                    }
                }else{
                    FeatureRegistry.BUSH_FEATURE.place(worldIn, generator, rand, pos, new BlockFeatureConfig(b.getBush()));
                }
                //Main.LOGGER.debug("Spawned " + b.getBush().getBlock().getNameTextComponent().toString() + " at " + pos.toString());

                //Main.LOGGER.debug("Spawned at " + pos.toString());

            }catch (Exception e){
                //Main.LOGGER.debug("Cannot spawn " + b.getBush().getBlock().getNameTextComponent().toString() + " " + e.getLocalizedMessage());
            }

            return true;
        }
        return false;
    }

    public static void init(){
        new BushEntry(WNBlocks.BROCCOLI_PLANT.getDefaultState(), Biome.TempCategory.WARM,3, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.CABBAGE_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.CAULIFLOWER_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.CELERY_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.CHIVES_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.CUCUMBER_PLANT.getDefaultState(), Biome.TempCategory.WARM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.GARLIC_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.GINGER_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.GREEN_PEPPER_PLANT.getDefaultState(), Biome.TempCategory.WARM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.HORSE_RADISH_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,5,false, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.LEEK_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.LETTUCE_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.ONION_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.PEANUT_PLANT.getDefaultState(), Biome.TempCategory.WARM,3, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.PEA_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.RED_ONION_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.RED_PEPPER_PLANT.getDefaultState(), Biome.TempCategory.WARM,3, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.RHUBARB_PLANT.getDefaultState(), Biome.TempCategory.WARM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.RICE_PLANT.getDefaultState(), Biome.TempCategory.WARM,5,false, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.WET);
        new BushEntry(WNBlocks.TOMATO_PLANT.getDefaultState(), Biome.TempCategory.WARM,5, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.TURNIP_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,4, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.GREEN_BEANS_BUSH.getDefaultState(), Biome.TempCategory.MEDIUM,4,false, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.GREEN_BEANS_BUSH.getDefaultState(), Biome.TempCategory.WARM,2,false, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.EGGPLANT_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,3, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.EGGPLANT_PLANT.getDefaultState(), Biome.TempCategory.WARM,3, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.CORN_BUSH.getDefaultState(), Biome.TempCategory.MEDIUM,4,false, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.CORN_BUSH.getDefaultState(), Biome.TempCategory.WARM,2,false, BiomeDictionary.Type.PLAINS);

        new BushEntry(WNBlocks.PINEAPPLE_PLANT.getDefaultState(), Biome.TempCategory.WARM,4,false, BiomeDictionary.Type.JUNGLE);


        new BushEntry(WNBlocks.BASIL_PLANT.getDefaultState(), Biome.TempCategory.WARM,1, BiomeDictionary.Type.JUNGLE);
        new BushEntry(WNBlocks.MARJORAM_PLANT.getDefaultState(), Biome.TempCategory.WARM,1, BiomeDictionary.Type.JUNGLE);
        new BushEntry(WNBlocks.PARSLEY_PLANT.getDefaultState(), Biome.TempCategory.WARM,1, BiomeDictionary.Type.JUNGLE);
        new BushEntry(WNBlocks.SAGE_PLANT.getDefaultState(), Biome.TempCategory.WARM,1, BiomeDictionary.Type.JUNGLE);
        new BushEntry(WNBlocks.TURMERIC_PLANT.getDefaultState(), Biome.TempCategory.WARM,1, BiomeDictionary.Type.JUNGLE);
        new BushEntry(WNBlocks.CURRY_PLANT.getDefaultState(), Biome.TempCategory.WARM,1, BiomeDictionary.Type.JUNGLE);
        new BushEntry(WNBlocks.ROSEMARY_PLANT.getDefaultState(), Biome.TempCategory.WARM,1, BiomeDictionary.Type.JUNGLE);


        new BushEntry(WNBlocks.BLACK_TEA_PLANT.getDefaultState(), Biome.TempCategory.WARM,3,false, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.GREEN_TEA_PLANT.getDefaultState(), Biome.TempCategory.WARM,2,false, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.MELISSA_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,3,false, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.MINT_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,4,false, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.WHITE_TEA.getDefaultState(), Biome.TempCategory.WARM,1,false, BiomeDictionary.Type.PLAINS);

        new BushEntry(WNBlocks.BLACK_PEPPER_PLANT.getDefaultState(), Biome.TempCategory.WARM,2, BiomeDictionary.Type.JUNGLE);

        new BushEntry(WNBlocks.COTTON_PLANT.getDefaultState(), Biome.TempCategory.MEDIUM,3,false, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.COTTON_PLANT.getDefaultState(), Biome.TempCategory.COLD,2,false, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.COTTON_PLANT.getDefaultState(), Biome.TempCategory.WARM,2,false, BiomeDictionary.Type.PLAINS);
    }

    public static class BushEntry{
        private BlockState bush;
        private Biome.TempCategory category;
        private BiomeDictionary.Type[] types;
        private int rarity;
        private boolean needsFarmland = true;
        public BushEntry(BlockState bush, Biome.TempCategory tempCategory, int rarity, BiomeDictionary.Type... types){
            this.bush=bush;
            this.category=tempCategory;
            this.types=types;
            this.rarity=rarity;
            entries.add(this,rarity);
        }

        public BushEntry(BlockState bush, Biome.TempCategory tempCategory, int rarity, boolean needsFarmland, BiomeDictionary.Type... types){
            this.bush=bush;
            this.category=tempCategory;
            this.types=types;
            this.rarity=rarity;
            this.needsFarmland=needsFarmland;
            entries.add(this,rarity);
        }

        public int getRarity() {
            return rarity;
        }

        public BlockState getBush() {
            return bush;
        }

        public boolean needsFarmland() {
            return needsFarmland;
        }

        public Biome.TempCategory getCategory() {
            return category;
        }

        public BiomeDictionary.Type[] getTypes() {
            return types;
        }

        public boolean canSpawnHere(BlockPos pos, IWorld world){
            Biome b = world.getBiome(pos);
            if(getTempCategory(b)==category){
                for(BiomeDictionary.Type t : types){
                    if(BiomeDictionary.getTypes(b).contains(t)){
                        return true;
                    }
                }
            }
            return false;
        }

        public Biome.TempCategory getTempCategory(Biome b) {
            if (b.getCategory() == Biome.Category.OCEAN) {
                return Biome.TempCategory.OCEAN;
            } else if ((double)b.getDefaultTemperature() < 0.2D) {
                return Biome.TempCategory.COLD;
            } else {
                return (double)b.getDefaultTemperature() < 0.5D ? Biome.TempCategory.MEDIUM : Biome.TempCategory.WARM;
            }
        }
    }

}