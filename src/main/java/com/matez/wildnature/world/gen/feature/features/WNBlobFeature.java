package com.matez.wildnature.world.gen.feature.features;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.feature.configs.WNBlobConfig;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Function;

public class WNBlobFeature extends Feature<WNBlobConfig> {
    private ArrayList<BlockPos> filledBlocks = new ArrayList<>();
    public WNBlobFeature(Function<Dynamic<?>, ? extends WNBlobConfig> p_i49915_1_) {
        super(p_i49915_1_);
        setRegistryName("wildnature","blob_feature");
    }

    public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random random, BlockPos pos, WNBlobConfig config) {
        filledBlocks.clear();
        while(true) {
            label50: {
                if (pos.getY() > 3) {
                    if (world.isAirBlock(pos.down())) {
                        break label50;
                    }

                    Block block = world.getBlockState(pos.down()).getBlock();
                    if (!(block instanceof GrassBlock) && !isDirt(block) && !isRock(block)) {
                        break label50;
                    }
                }

                if (pos.getY() <= 3) {
                    return false;
                }

                int lvt_6_2_ = config.startRadius;

                for(int lvt_7_1_ = 0; lvt_6_2_ >= 0 && lvt_7_1_ < 3; ++lvt_7_1_) {
                    int lvt_8_1_ = lvt_6_2_ + random.nextInt(2);
                    int lvt_9_1_ = lvt_6_2_ + random.nextInt(2);
                    int lvt_10_1_ = lvt_6_2_ + random.nextInt(2);
                    float lvt_11_1_ = (float)(lvt_8_1_ + lvt_9_1_ + lvt_10_1_) * 0.333F + 0.5F;
                    Iterator var12 = BlockPos.getAllInBoxMutable(pos.add(-lvt_8_1_, -lvt_9_1_, -lvt_10_1_), pos.add(lvt_8_1_, lvt_9_1_, lvt_10_1_)).iterator();

                    while(var12.hasNext()) {
                        BlockPos blockPos = (BlockPos)var12.next();
                        if (blockPos.distanceSq(pos) <= (double)(lvt_11_1_ * lvt_11_1_)) {
                            if(config.surfaceBlob){
                                boolean canPlace = !config.flatInTerrain || !Utilities.isBlockNear(world, blockPos, Blocks.AIR);
                                if(canPlace) {
                                    if (world.getBlockState(blockPos).isSolid()) {
                                        if (!config.undergroundBlob) {
                                            if (!world.getBlockState(blockPos.up()).isSolid() && !(world.getBlockState(blockPos.up()).getBlock() instanceof FarmlandBlock) && world.getBlockState(blockPos.up()).getBlock() != Blocks.WATER) {
                                                world.setBlockState(blockPos, config.state, 4);
                                                world.setBlockState(blockPos.up(), Blocks.AIR.getDefaultState(), 4);
                                                filledBlocks.add(blockPos);
                                            }
                                        } else {
                                            world.setBlockState(blockPos, config.state, 4);
                                            filledBlocks.add(blockPos);
                                        }
                                    } else {
                                        if (world.getBlockState(blockPos).getBlock() == Blocks.WATER) {
                                            world.setBlockState(blockPos, Blocks.WATER.getDefaultState(), 4);
                                        } else {
                                            world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), 4);
                                        }
                                    }
                                }
                            }else{
                                boolean canPlace = !config.flatInTerrain || !Utilities.isBlockNear(world, blockPos, Blocks.AIR);
                                if(canPlace) {
                                    if (!config.undergroundBlob) {
                                        if (!world.getBlockState(blockPos.up()).isSolid() && !(world.getBlockState(blockPos.up()).getBlock() instanceof FarmlandBlock) && world.getBlockState(blockPos.up()).getBlock() != Blocks.WATER) {
                                            world.setBlockState(blockPos, config.state, 4);
                                            world.setBlockState(blockPos.up(), Blocks.AIR.getDefaultState(), 4);
                                            filledBlocks.add(blockPos);
                                        }
                                    } else {
                                        world.setBlockState(blockPos, config.state, 4);
                                        filledBlocks.add(blockPos);
                                    }
                                }
                            }

                        }
                    }

                    pos = pos.add(-(lvt_6_2_ + 1) + random.nextInt(2 + lvt_6_2_ * 2), 0 - random.nextInt(2), -(lvt_6_2_ + 1) + random.nextInt(2 + lvt_6_2_ * 2));
                }

                return true;
            }

            pos = pos.down();
        }
    }
    public static boolean isRock(Block blockIn) {
        return net.minecraftforge.common.Tags.Blocks.STONE.contains(blockIn);
    }

    public static boolean isDirt(Block blockIn) {
        return net.minecraftforge.common.Tags.Blocks.DIRT.contains(blockIn);
    }

    public ArrayList<BlockPos> getFilledBlocks() {
        return filledBlocks;
    }
}