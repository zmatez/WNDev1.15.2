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

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);

    public MudBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
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

    public VoxelShape getCollisionShape(BlockState p_220071_1_, IBlockReader p_220071_2_, BlockPos p_220071_3_, ISelectionContext p_220071_4_) {
        return SHAPE;
    }
}
