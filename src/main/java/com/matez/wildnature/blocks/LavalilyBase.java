package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.storage.loot.LootContext;

import java.util.ArrayList;
import java.util.List;

public class LavalilyBase extends WaterLilyBase {
    public LavalilyBase(Properties properties, ResourceLocation regName) {
        super(properties, regName);
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        IFluidState ifluidstate = worldIn.getFluidState(pos);
        return ifluidstate.getFluid() == Fluids.LAVA || state.getMaterial() == Material.LAVA;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> l = new ArrayList<>();
        l.add(new ItemStack(Items.FIRE_CHARGE, Utilities.rint(0,1)));

        if(Utilities.rint(0,4)==0) {
            l.add(new ItemStack(this.asItem(), 1));
        }
        return l;
    }
}
