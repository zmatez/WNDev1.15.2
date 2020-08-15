package com.matez.wildnature.blocks;

import com.matez.wildnature.gui.tileEntities.GravityShroomTileEntity;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.registry.ParticleRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class GravityShroom extends MushroomBase {
    public static final BooleanProperty GRAVITY = BooleanProperty.create("gravity");

    public GravityShroom(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
        setDefaultState(getDefaultState().with(GRAVITY,false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(GRAVITY);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new GravityShroomTileEntity();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return state.get(GRAVITY) ? 12 : 0;
    }

    public void steamParticle(BlockPos oldPos, BlockState state, ServerWorld world, Random random){
        double X = oldPos.getX();
        double Y = oldPos.getY()+0.6;
        double Z = oldPos.getZ();

        double res = 0.02;
        for(int i = 0; i < Utilities.rint(20,50,random); i++) {
            double speedX = Utilities.rdoub(-res,res);
            double speedY = Utilities.rdoub(0.03,0.06);
            double speedZ = Utilities.rdoub(-res,res);
            SteamGeneratorBlock.spawnParticle(world, ParticleRegistry.FUZZBALL_EXPLOSION,X+0.5, Y+0.5, Z+0.5, 1,speedX,speedY,speedZ,0.05);

        }

        world.playSound(null,oldPos.getX(), oldPos.getY(), oldPos.getZ(), SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.4F, (float) Utilities.rdoub(1.1D, 1.5D));

    }
}
