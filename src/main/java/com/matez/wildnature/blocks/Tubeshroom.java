package com.matez.wildnature.blocks;

import com.matez.wildnature.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class Tubeshroom extends UnderwaterCaveShroomBase {
    public Tubeshroom(Properties properties, Item.Properties builder, ResourceLocation regName, boolean reversed) {
        super(properties, builder, regName, reversed);
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (Utilities.rint(0, 3, rand) == 0) {
            worldIn.addParticle(ParticleTypes.BUBBLE_COLUMN_UP, pos.getX() + 0.5 + Utilities.rdoub(-0.1, 0.1), pos.getY() + 0.2 + Utilities.rdoub(-0.1, 0.1), pos.getZ() + 0.5 + Utilities.rdoub(-0.1, 0.1), +Utilities.rdoub(-0.1, 0.1), +Utilities.rdoub(0.1, 0.5), +Utilities.rdoub(-0.1, 0.1));
        }
    }
}
