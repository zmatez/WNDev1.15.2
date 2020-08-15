package com.matez.wildnature.blocks;


import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraftforge.common.IPlantable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CornPlant extends BushBlock implements IGrowable, IRenderLayer {
    public static IntegerProperty STAGE = IntegerProperty.create("stage",0,2);

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);
    protected static final VoxelShape SHAPEBIG = Block.makeCuboidShape(0.3D, 0.0D, 0.3D, 13.0D, 16.0D, 13.0D);



    public CornPlant(Block.Properties properties, ResourceLocation regName) {
        super(properties.doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH));
        this.setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
    }

    public String getBush(){
        return "wildnature:corn_bush";
    }

    public String getDrop(){
        return "corn";
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && !silkTouch && Utilities.rint(0,10)==0){
            //list.add(new ItemStack(item, 1));
        }

        return list;
    }

    private boolean b2 = true;
    private int min2=0;
    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return state.get(STAGE)==0 ? SHAPE : SHAPEBIG;
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(getHighestBlock(worldIn,pos).up()).getBlock()==Blocks.AIR && state.get(STAGE)<2;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return worldIn.getBlockState(getHighestBlock(worldIn,pos).up()).getBlock()==Blocks.AIR && state.get(STAGE)<2;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return worldIn.getBlockState(blockpos).canSustainPlant(worldIn, blockpos, Direction.UP, this);
        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        return state.get(STAGE)!=0;
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.setMotionMultiplier(state, new Vec3d(0.98D, (double) 0.999F, 0.98D));
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        if(Utilities.rint(0,3)==0 && state.get(STAGE)<2){
            int all = getAllBlocks(worldIn,pos).size();
            BlockPos high = getHighestBlock(worldIn,pos);
            BlockPos low = getLowestBlock(worldIn,pos);
            Main.LOGGER.debug(all);
            if(!canFlower(worldIn,pos)) {
                if (all == 1) {
                    worldIn.setBlockState(pos, Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 1));
                    if(!(worldIn.getBlockState(low.up(1)).getBlock() instanceof CornPlant)) {
                        worldIn.setBlockState(low.up(1), Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 0));
                    }
                } else if (all == 2) {
                    worldIn.setBlockState(low, Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 1));
                    worldIn.setBlockState(low.up(), Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 1));
                    if(!(worldIn.getBlockState(low.up(2)).getBlock() instanceof CornPlant)) {
                        worldIn.setBlockState(low.up(2), Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 0));
                    }
                } else if (all == 3) {
                    worldIn.setBlockState(low, Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 1));
                    worldIn.setBlockState(low.up(), Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 1));
                    worldIn.setBlockState(low.up(2), Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 1));
                    if(!(worldIn.getBlockState(low.up(3)).getBlock() instanceof CornPlant)) {
                        worldIn.setBlockState(low.up(3), Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 0));
                    }
                } else if (all >= 4) {
                    worldIn.setBlockState(low, Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 1));
                    worldIn.setBlockState(low.up(), Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 1));
                    worldIn.setBlockState(low.up(2), Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 1));
                    worldIn.setBlockState(low.up(3), Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 1));
                    if(!(worldIn.getBlockState(low.up(4)).getBlock() instanceof CornPlant)) {
                        worldIn.setBlockState(low.up(4), Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 0));
                    }
                }
            }else{
                getAllBlocks(worldIn, pos).forEach(blockpos -> {
                    if(worldIn.getBlockState(blockpos).getBlock() instanceof CornPlant && worldIn.getBlockState(blockpos).get(STAGE)==1){
                        worldIn.setBlockState(blockpos, Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 2));
                    }
                });
            }
        }
    }


    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        getAllBlocks(worldIn, pos).forEach(blockpos -> {
            if(worldIn.getBlockState(blockpos).getBlock() instanceof CornPlant && worldIn.getBlockState(blockpos).get(STAGE)==2){
                worldIn.setBlockState(blockpos, Main.getBlockByID(getBush()).getDefaultState().with(CornPlant.STAGE, 1));
                ItemStack stack = new ItemStack(Main.getItemByID("wildnature:"+getDrop()), Utilities.rint(0,1));
                spawnAsEntity(worldIn,pos,stack);
                worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);

            }
        });
        return state.get(STAGE)==2 ? ActionResultType.SUCCESS : ActionResultType.PASS;
    }

    private boolean canFlower(World world, BlockPos pos){
        int i =0;
        for (BlockPos allBlock : getAllBlocks(world, pos)) {
            if(world.getBlockState(allBlock).getBlock() instanceof CornPlant && world.getBlockState(allBlock).get(STAGE)==1){
                i++;
            }
        }

        //Main.LOGGER.debug("a: " + i);
        return i>=4;
    }

    private ArrayList<BlockPos> getAllBlocks(IBlockReader world, BlockPos pos){
        ArrayList<BlockPos> bp = new ArrayList<>();
        for(int i = pos.getY(); i > 0 && i < world.getHeight(); i++){
            BlockPos x = new BlockPos(pos.getX(),i,pos.getZ());
            if((world.getBlockState(new BlockPos(pos.getX(),i,pos.getZ())).getBlock() instanceof CornPlant) && !bp.contains(x)){
                bp.add(x);
            }else{
                break;
            }
        }
        for(int i = pos.getY(); i > 0 && i < world.getHeight(); i--){
            BlockPos x = new BlockPos(pos.getX(),i,pos.getZ());
            if((world.getBlockState(new BlockPos(pos.getX(),i,pos.getZ())).getBlock() instanceof CornPlant) && !bp.contains(x)){
                bp.add(x);
            }else{
                break;
            }
        }

        if(!bp.contains(pos)) {
            bp.add(pos);
        }
        Main.LOGGER.debug(bp.toString());

        return bp;
    }

    private int high = 1;
    private BlockPos getHighestBlock(IBlockReader world, BlockPos pos){
        ArrayList<BlockPos> bp = getAllBlocks(world,pos);
        bp.forEach(blockpos -> {
            if(blockpos.getY()>high && world.getBlockState(blockpos).getBlock() instanceof CornPlant){
                high=blockpos.getY();
            }
        });
        return new BlockPos(pos.getX(),high,pos.getZ());
    }
    private int low = 256;
    private BlockPos getLowestBlock(IBlockReader world, BlockPos pos){
        ArrayList<BlockPos> bp = getAllBlocks(world,pos);
        bp.forEach(blockpos -> {
            if(blockpos.getY()<low && world.getBlockState(blockpos).getBlock() instanceof CornPlant){
                low=blockpos.getY();
            }
        });
        return new BlockPos(pos.getX(),low,pos.getZ());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(STAGE);
    }
}
