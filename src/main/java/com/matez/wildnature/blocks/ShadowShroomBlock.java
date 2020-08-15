package com.matez.wildnature.blocks;

import com.matez.wildnature.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;

import java.util.Random;

public class ShadowShroomBlock extends CaveShroomBase {
    public ShadowShroomBlock(Properties properties, Item.Properties builder, ResourceLocation regName, boolean reversed) {
        super(properties, builder, regName, reversed);
    }

    @Override
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
        if(Utilities.rint(0,2,random)==0){
            for(int i = 0; i<6; i++) {
                world.addParticle(ParticleTypes.WITCH, pos.getX() + 0.5, pos.getY() + 0.3, pos.getZ() + 0.5, 0, 0, 0);
            }
            if(Utilities.rint(0,7)==0 || world.getBiome(pos)== Biomes.SWAMP || world.getBiome(pos)== Biomes.SWAMP_HILLS )
            world.playSound(null,pos, SoundEvents.ENTITY_WITCH_AMBIENT, SoundCategory.AMBIENT,0.6f,0.7f);
        }
    }
}
