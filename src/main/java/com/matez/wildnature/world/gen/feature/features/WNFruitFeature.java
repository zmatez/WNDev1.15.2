package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.blocks.BelladonnaBlock;
import com.matez.wildnature.blocks.BushBerryBase;
import com.matez.wildnature.blocks.CropBase;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.other.WeightedList;
import com.matez.wildnature.world.gen.feature.FeatureRegistry;
import com.matez.wildnature.world.gen.feature.configs.BlockFeatureConfig;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
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

public class WNFruitFeature extends Feature<NoFeatureConfig> {
    public static WeightedList<BushEntry> entries = new WeightedList<>();
    public WNFruitFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49915_1_) {
        super(p_i49915_1_);
        setRegistryName("wildnature","fruit_feature");
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if(!worldIn.getDimension().isSurfaceWorld()){
            return false;
        }

        if(Utilities.rint(0, CommonConfig.fruitBushChance.get())!=0){
            return false;
        }
        WeightedList<BushEntry> available = new WeightedList<>();

        entries.forEach(e -> {
            if(e.canSpawnHere(pos,worldIn)){
                available.add(e,entries.getRarityFor(e));
            }
        });

        if(!available.isEmpty()) {
            BushEntry b = (BushEntry) Utilities.getWeightedEntry(available, rand);
            assert b != null;
            if(!b.isPlant()) {
                new shrub1().setCustomLog(b.getBush()).setCustomLeaf(SchemFeature.notDecayingLeaf(b.getBush().getBlock()).with(BushBerryBase.STAGE,Utilities.rint(0,1,rand))).place(worldIn, generator, rand, pos, config);
            }else {
                if (b.getBush().getBlock() instanceof BelladonnaBlock) {
                    FeatureRegistry.BUSH_FEATURE.place(worldIn, generator, rand, pos, new BlockFeatureConfig(b.getBush()));
                } else {
                    FeatureRegistry.BUSH_FEATURE.place(worldIn, generator, rand, pos, new BlockFeatureConfig(b.getBush().with(((CropBase) b.getBush().getBlock()).getAge(), Utilities.rint(((CropBase) b.getBush().getBlock()).getMaxAge() - 1, ((CropBase) b.getBush().getBlock()).getMaxAge()))));
                }
            }

            return true;
        }
        return false;
    }

    public static void init(){
        new BushEntry(WNBlocks.BUSH_RASPBERRY.getDefaultState(), Biome.TempCategory.WARM,5, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_RASPBERRY.getDefaultState(), Biome.TempCategory.MEDIUM,4, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_BLUEBERRY.getDefaultState(), Biome.TempCategory.WARM,5, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_BLUEBERRY.getDefaultState(), Biome.TempCategory.MEDIUM,4, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_BLUEBERRY.getDefaultState(), Biome.TempCategory.COLD,2, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_LINGONBERRY.getDefaultState(), Biome.TempCategory.COLD,3, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_LINGONBERRY.getDefaultState(), Biome.TempCategory.MEDIUM,1, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_GOOSEBERRY.getDefaultState(), Biome.TempCategory.WARM,5, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_GOOSEBERRY.getDefaultState(), Biome.TempCategory.MEDIUM,3, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_CHOKEBERRY.getDefaultState(), Biome.TempCategory.MEDIUM,6, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_BLACK_CURRANT.getDefaultState(), Biome.TempCategory.MEDIUM,2,true, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_RED_CURRANT.getDefaultState(), Biome.TempCategory.MEDIUM,2,true, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_WHITE_CURRANT.getDefaultState(), Biome.TempCategory.MEDIUM,1,true, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_HAWTHORN.getDefaultState(), Biome.TempCategory.MEDIUM,2, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_HAWTHORN.getDefaultState(), Biome.TempCategory.COLD,5, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_KAMCHATKA.getDefaultState(), Biome.TempCategory.COLD,5, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_WILD_STRAWBERRY.getDefaultState(), Biome.TempCategory.WARM,5,true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.BUSH_QUINCE.getDefaultState(), Biome.TempCategory.MEDIUM,2,true, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.BUSH_BILBERRY.getDefaultState(), Biome.TempCategory.MEDIUM,5, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_BLACK_LILAC.getDefaultState(), Biome.TempCategory.MEDIUM,4,true, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.BUSH_BLACK_LILAC.getDefaultState(), Biome.TempCategory.MEDIUM,4,true, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_BLACKBERRY.getDefaultState(), Biome.TempCategory.MEDIUM,6,true, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_CRANBERRY.getDefaultState(), Biome.TempCategory.MEDIUM,4,true, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.BUSH_CRANBERRY.getDefaultState(), Biome.TempCategory.COLD,4,true, BiomeDictionary.Type.PLAINS);
        new BushEntry(WNBlocks.BUSH_WILD_BLUEBERRY.getDefaultState(), Biome.TempCategory.COLD,2,true, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_WILD_BLUEBERRY.getDefaultState(), Biome.TempCategory.MEDIUM,4,true, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BUSH_WILD_BLUEBERRY.getDefaultState(), Biome.TempCategory.COLD,4,true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE);
        new BushEntry(WNBlocks.BUSH_WILD_BLUEBERRY.getDefaultState(), Biome.TempCategory.MEDIUM,8,true, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE);

        new BushEntry(WNBlocks.BELLADONNA.getDefaultState(), Biome.TempCategory.COLD,3,true, BiomeDictionary.Type.FOREST);
        new BushEntry(WNBlocks.BELLADONNA.getDefaultState(), Biome.TempCategory.MEDIUM,2,true, BiomeDictionary.Type.FOREST);
    }

    public static class BushEntry{
        private BlockState bush;
        private Biome.TempCategory category;
        private BiomeDictionary.Type[] types;
        private int rarity;
        private boolean plant = false;
        public BushEntry(BlockState bush, Biome.TempCategory tempCategory, int rarity, BiomeDictionary.Type... types){
            this.bush=bush;
            this.category=tempCategory;
            this.types=types;
            this.rarity=rarity;
            entries.add(this,rarity);
        }

        public BushEntry(BlockState bush, Biome.TempCategory tempCategory, int rarity, boolean plant, BiomeDictionary.Type... types){
            this.bush=bush;
            this.category=tempCategory;
            this.types=types;
            this.rarity=rarity;
            this.plant=plant;
            entries.add(this,rarity);
        }

        public int getRarity() {
            return rarity;
        }

        public BlockState getBush() {
            return bush;
        }

        public boolean isPlant() {
            return plant;
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