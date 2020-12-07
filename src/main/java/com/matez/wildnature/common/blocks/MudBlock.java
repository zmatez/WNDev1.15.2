package com.matez.wildnature.common.blocks;

import com.matez.wildnature.common.damage.WNDamageSource;
import com.matez.wildnature.util.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class MudBlock extends BlockBase {


    public MudBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties.doesNotBlockMovement(), builder, regName);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn){
        if(entityIn.getHeight() + entityIn.getPosition().getY() < pos.getY() + 1){
            if(Utilities.rint(0,8)==0){
                entityIn.attackEntityFrom(WNDamageSource.MUD, (float) (0.5F));
            }
        }
        entityIn.setMotionMultiplier(state, new Vec3d(0.25D, (double)0.05F, 0.25D));
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.2f;
    }
}
