package com.matez.wildnature.common.blocks;

import com.matez.wildnature.client.render.IRenderLayer;
import com.matez.wildnature.util.lists.WNItems;
import com.matez.wildnature.util.other.Utilities;
import com.matez.wildnature.common.registry.particles.ParticleRegistry;
import com.matez.wildnature.client.sounds.SoundRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.TickPriority;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class GeyserBlock extends BlockBase implements IRenderLayer, IWaterLoggable {
    public static final IntegerProperty STEAM = IntegerProperty.create("steam",0,25);
    public static final BooleanProperty RUNNING = BooleanProperty.create("running");
    public static final IntegerProperty LOAD = IntegerProperty.create("load",0,5);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public GeyserBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties.notSolid(), builder, regName);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return Stream.of(
                Block.makeCuboidShape(10, 2, 6, 13, 5, 10),
                Block.makeCuboidShape(1, 0, 1, 15, 2, 15),
                Block.makeCuboidShape(3, 2, 3, 13, 5, 6),
                Block.makeCuboidShape(3, 2, 10, 13, 5, 13),
                Block.makeCuboidShape(3, 2, 6, 6, 5, 10)
        ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return this.getShape(state,worldIn,pos,context);
    }

    @Override
    public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return this.getShape(state,worldIn,pos,null);
    }

    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return this.getShape(state,worldIn,pos,null);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if(!state.get(RUNNING)){
            if(state.get(LOAD)<5 && Utilities.rint(0,4)==0){
                worldIn.setBlockState(pos,state.with(LOAD,state.get(LOAD)+1));
            }

            int load = worldIn.getBlockState(pos).get(LOAD);

            if(load>=2){
                if(load==2 && Utilities.rint(0,99)==0){
                    boom(worldIn,pos,state);
                }
                if(load==3 && Utilities.rint(0,49)==0){
                    boom(worldIn,pos,state);
                }
                if(load==4 && Utilities.rint(0,19)==0){
                    boom(worldIn,pos,state);
                }
                if(load==5 && Utilities.rint(0,4)==0){
                    boom(worldIn,pos,state);
                }
            }

        }
    }
    private void boom(World worldIn, BlockPos pos, BlockState state){
        worldIn.setBlockState(pos,state.with(RUNNING,true).with(STEAM,25));
        worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1, TickPriority.NORMAL);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
        return this.getDefaultState().with(RUNNING,false).with(LOAD,0).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if(!worldIn.isRemote()) {
            if (state.get(RUNNING)) {
                steam(state, (ServerWorld)worldIn, pos, random);
            }
        }
    }

    @Override
    public RenderType getRenderLayer() {
        return RenderType.getCutoutMipped();
    }

    public void steam(BlockState state, ServerWorld worldIn, BlockPos pos, Random random){
        if(state.get(STEAM)>0) {
            if(state.get(STEAM)==25){
                worldIn.playSound(null,pos.getX(),pos.getY(),pos.getZ(), SoundRegistry.STEAM_GENERATOR, SoundCategory.BLOCKS,1f,0.7F);
            }
            worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(RUNNING,true).with(STEAM,state.get(STEAM)-1));

            steamParticle(pos, state, worldIn, random);

            worldIn.getPendingBlockTicks().scheduleTick(pos, this, 2, TickPriority.NORMAL);
        }else{
            worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(RUNNING,false).with(LOAD,0));

        }
    }

    public void steamParticle(BlockPos oldPos, BlockState state, ServerWorld world, Random random){
        double X = oldPos.getX();
        double Y = oldPos.getY()+0.6;
        double Z = oldPos.getZ();

        double res = 0.08;
        for(int i = 0; i < Utilities.rint(4*state.get(LOAD),10*state.get(LOAD),random); i++) {
            double speedX = Utilities.rdoub(-res,res);
            double speedY = Utilities.rdoub(0.3,1.2);
            double speedZ = Utilities.rdoub(-res,res);
            SteamGeneratorBlock.spawnParticle(world,ParticleRegistry.STEAM,X+0.5, Y+0.5, Z+0.5, 1,speedX,speedY,speedZ);

        }
    }


    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double x = (double) pos.getX() + 0.5D;
        double y = (double) pos.getY() + 1.2D;
        double z = (double) pos.getZ() + 0.5D;
        for(int i = 0; i < Utilities.rint(0,2*stateIn.get(LOAD),rand); i++) {
            worldIn.addParticle(ParticleRegistry.GEYSER, x, y, z, (float) Utilities.rdoub(-0.05,0.05), (float) Utilities.rdoub(0.07,0.13), (float) Utilities.rdoub(-0.05,0.05));
            if(stateIn.get(LOAD)>=4){
                worldIn.addParticle(ParticleTypes.BUBBLE_POP, x, y, z, (float) Utilities.rdoub(-0.3,0.3), (float) Utilities.rdoub(0.5,2.5), (float) Utilities.rdoub(-0.3,0.3));
            }
        }
        if(stateIn.get(LOAD)!=0) {
            worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.4F, (float) Utilities.rdoub(1.1D, 1.5D), false);
        }
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STEAM,LOAD,RUNNING,WATERLOGGED);
    }


    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> l = new ArrayList<>();
        if(state.get(LOAD)>=4){
            l.add(new ItemStack(WNItems.GEYSER_ESSENCE));
        }
        if(state.get(RUNNING)){
            l.add(Utilities.rint(1,2),new ItemStack(WNItems.GEYSER_ESSENCE));
        }

        return l;
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
}
