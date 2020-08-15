package com.matez.wildnature.world.gen.structures.nature.woods.glowing_cave_oak;

import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class GlowingCaveOakSpawner extends SchemFeature {
    private boolean icy = false;
    private ArrayList<SchemFeature> normalCaveOaks = new ArrayList<SchemFeature>();
    private ArrayList<SchemFeature> icyCaveOaks = new ArrayList<SchemFeature>();

    public GlowingCaveOakSpawner(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49920_1_, boolean doBlockNofityOnPlace, boolean icy) {
        super();
        this.icy = icy;
        normalCaveOaks.add(new glowing_cave_oak_1().setCustomLog(WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_LEAVES)));
        normalCaveOaks.add(new glowing_cave_oak_2().setCustomLog(WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_LEAVES)));
        normalCaveOaks.add(new glowing_cave_oak_3().setCustomLog(WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_LEAVES)));
        normalCaveOaks.add(new glowing_cave_oak_4().setCustomLog(WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_LEAVES)));

        icyCaveOaks.add(new glowing_cave_oak_1().setCustomLog(WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_ICY_LEAVES)));
        icyCaveOaks.add(new glowing_cave_oak_2().setCustomLog(WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_ICY_LEAVES)));
        icyCaveOaks.add(new glowing_cave_oak_3().setCustomLog(WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_ICY_LEAVES)));
        icyCaveOaks.add(new glowing_cave_oak_4().setCustomLog(WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState()).setCustomLeaf(SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_ICY_LEAVES)));
    }

    public void setIcy(boolean icy) {
        this.icy = icy;
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos position, NoFeatureConfig config) {
        for (int i = position.getY(); i < position.getY() + 15; i++) {
            if (!worldIn.hasBlockState(position, new Predicate<BlockState>() {
                @Override
                public boolean test(BlockState state) {
                    return state.isAir();
                }
            })) {
                return false;
            }
        }

        if (icy) {
            int index = Utilities.rint(0, icyCaveOaks.size() - 1, rand);
            return icyCaveOaks.get(index).place((IWorld) worldIn, generator, rand, position, new NoFeatureConfig());
        } else {
            int index = Utilities.rint(0, normalCaveOaks.size() - 1, rand);
            return normalCaveOaks.get(index).place((IWorld) worldIn, generator, rand, position, new NoFeatureConfig());
        }
    }
}
