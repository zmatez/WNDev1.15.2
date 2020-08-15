package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class JellyBlock extends BlockBase implements IWaterLoggable, IRenderLayer {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.5D, 0.5D, 0.5D, 15.5D, 16D, 15.5D);

    public JellyBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return SHAPE;
    }

    @Override
    public RenderType getRenderLayer() {
        return RenderType.getTranslucent();
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isSideInvisible(BlockState p_200122_1_, BlockState p_200122_2_, Direction p_200122_3_) {
        return p_200122_2_.getBlock() instanceof JellyBlock || super.isSideInvisible(p_200122_1_, p_200122_2_, p_200122_3_);
    }

    public void onFallenUpon(World p_180658_1_, BlockPos p_180658_2_, Entity p_180658_3_, float fall) {
        if (p_180658_3_.isSuppressingBounce()) {
            super.onFallenUpon(p_180658_1_, p_180658_2_, p_180658_3_, fall);
        } else {
            if(fall >= 20){
                p_180658_3_.setPosition(p_180658_3_.getPosition().getX(),p_180658_3_.getPosition().getY()-1,p_180658_3_.getPosition().getZ());
            }else {
                p_180658_3_.onLivingFall(fall, 0.0F);
            }
        }

    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if(entity.isSneaking()){
            if(entity.getPosition().getX()==pos.getX() && entity.getPosition().getZ()==pos.getZ()){

            }else {
                entity.setMotionMultiplier(state, new Vec3d(1, 0, 1));
            }
        }else {
            if(entity.getPosition().getY()<pos.getY() && entity.getPosition().getX()==pos.getX() && entity.getPosition().getZ()==pos.getZ()){
                double multiplier = 1.1d;
                if(this== WNBlocks.JELLY_BLUE_BLOCK){
                    multiplier=1d;
                }else if(this== WNBlocks.JELLY_ORANGE_BLOCK){
                    multiplier=0d;
                }else if(this== WNBlocks.JELLY_PINK_BLOCK){
                    multiplier=-1.1d;
                }else if(this== WNBlocks.JELLY_RED_BLOCK){
                    multiplier=-2d;
                }else if(this== WNBlocks.JELLY_WHITE_BLOCK){
                    multiplier=1.1d;
                }

                double lvt_4_1_ = Math.abs(entity.getMotion().y);
                double lvt_6_1_ = multiplier + lvt_4_1_;
                entity.setMotion(entity.getMotion().mul(lvt_6_1_, 0.0D, lvt_6_1_));
                entity.setMotion(entity.getMotion().getX(),5.0D,entity.getMotion().getZ());
            }else if(entity.getPosition().getY()>=pos.getY() && entity.getPosition().getX()==pos.getX() && entity.getPosition().getZ()==pos.getZ()){
            }
            else {
                if(entity.getPosition().getX()!=pos.getX() || entity.getPosition().getZ()!=pos.getZ()) {
                    entity.setMotion(entity.getMotion().mul(0.95, 1D, 0.95));

                }
            }
        }

        if(entity instanceof BoatEntity){
            entity.setMotion(entity.getMotion().getX(),1.0D,entity.getMotion().getZ());

        }

    }

    public void onLanded(IBlockReader p_176216_1_, Entity p_176216_2_) {
        if (p_176216_2_.isSneaking()) {
            super.onLanded(p_176216_1_, p_176216_2_);
        } else {
            Vec3d lvt_3_1_ = p_176216_2_.getMotion();
            if (lvt_3_1_.y < 0.0D) {
                double lvt_4_1_ = p_176216_2_ instanceof LivingEntity ? 1.0D : 0.8D;
                p_176216_2_.setMotion(lvt_3_1_.x, -lvt_3_1_.y * lvt_4_1_, lvt_3_1_.z);
            }
        }

    }

    public void onEntityWalk(World p_176199_1_, BlockPos p_176199_2_, Entity p_176199_3_) {
        double multiplier = 1.1d;
        if(this== WNBlocks.JELLY_BLUE_BLOCK){
            multiplier=1d;
        }else if(this== WNBlocks.JELLY_ORANGE_BLOCK){
            multiplier=0d;
        }else if(this== WNBlocks.JELLY_PINK_BLOCK){
            multiplier=-1.1d;
        }else if(this== WNBlocks.JELLY_RED_BLOCK){
            multiplier=-2d;
        }else if(this== WNBlocks.JELLY_WHITE_BLOCK){
            multiplier=1.1d;
        }

        double lvt_4_1_ = Math.abs(p_176199_3_.getMotion().y);
        if (lvt_4_1_ < 0.1D && !p_176199_3_.isSneaking()) {
            double lvt_6_1_ = multiplier + lvt_4_1_;
            p_176199_3_.setMotion(p_176199_3_.getMotion().mul(lvt_6_1_, 1.0D, lvt_6_1_));
        }

        super.onEntityWalk(p_176199_1_, p_176199_2_, p_176199_3_);
    }

    @Override
    public boolean isLadder(BlockState state, net.minecraft.world.IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        return true;
    }


    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(WATERLOGGED);
    }

    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }

        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();

        IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
        BlockState blockstate1 = this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
        return blockstate1;
    }
}
