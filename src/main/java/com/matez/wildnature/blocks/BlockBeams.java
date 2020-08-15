package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.render.IRenderLayer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.state.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import java.util.ArrayList;
import java.util.List;

public class BlockBeams extends Block implements IRenderLayer {
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    public static IntegerProperty TYPE = IntegerProperty.create("type",0,5);//4 = max

    public int getMaxTypes(){return 5;}

    public Item item;


    public BlockBeams(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties);

        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);


        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);


    }


    @Override
    public RenderType getRenderLayer() {
        return RenderType.getCutout();
    }

    @Override
    public boolean isNormalCube(BlockState p_220081_1_, IBlockReader p_220081_2_, BlockPos p_220081_3_) {
        return true;
    }

    public VoxelShape result(List<VoxelShape> shapes){
        VoxelShape result = VoxelShapes.empty();
        int x=0;
        while(x<shapes.size()){
            result = VoxelShapes.combine(result,shapes.get(x), IBooleanFunction.OR);
            x++;
        }
        return result.simplify();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        switch((Direction)state.get(FACING))
        {
            case NORTH: {
                switch (state.get(TYPE)) {
                    case 0: {
                        return Block.makeCuboidShape(4, 0, 0, 12, 16, 4);
                    }
                    case 1: {
                        List<VoxelShape> shapes = new ArrayList<>();
                        shapes.add(makeCuboidShape(4, 0, 0, 12, 16, 4)); // CUBE
                        shapes.add(makeCuboidShape(4, 12, 4, 12, 16, 16)); // CUBE
                        return result(shapes);
                    }
                    case 2: {
                        return Block.makeCuboidShape(4, 12, 0, 12, 16, 16);
                    }
                    case 3: {
                        return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(0, 12, 4, 4, 16, 12),
                                Block.makeCuboidShape(4, 12, 0, 12, 16, 16), IBooleanFunction.OR);
                    }
                    case 4: {
                        return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(12, 12, 4, 16, 16, 12),
                                Block.makeCuboidShape(4, 12, 0, 12, 16, 16), IBooleanFunction.OR);
                    }
                    case 5: {
                        List<VoxelShape> shapes = new ArrayList<>();
                        shapes.add(makeCuboidShape(4, 12, 0, 12, 16, 16)); // CUBE
                        shapes.add(makeCuboidShape(12, 12, 4, 16, 16, 12)); // CUBE
                        shapes.add(makeCuboidShape(0, 12, 4, 4, 16, 12)); // CUBE
                        return result(shapes);
                    }
                    default: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                    }
                }
            }
            case SOUTH: {
                switch (state.get(TYPE)) {
                    case 0: {
                        return Block.makeCuboidShape(4, 0, 12, 12, 16, 16);
                    }
                    case 1: {
                        List<VoxelShape> shapes = new ArrayList<>();
                        shapes.add(makeCuboidShape(4, 0, 12, 12, 16, 16)); // CUBE
                        shapes.add(makeCuboidShape(4, 12, 0, 12, 16, 12)); // CUBE
                        return result(shapes);
                    }
                    case 2: {
                        return Block.makeCuboidShape(4, 12, 0, 12, 16, 16);
                    }
                    case 3: {
                        return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 12, 0, 12, 16, 16),
                                Block.makeCuboidShape(0, 12, 4, 4, 16, 12), IBooleanFunction.OR);
                    }
                    case 4: {
                        return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 12, 0, 12, 16, 16),
                                Block.makeCuboidShape(12, 12, 4, 16, 16, 12), IBooleanFunction.OR);
                    }
                    case 5: {
                        List<VoxelShape> shapes = new ArrayList<>();
                        shapes.add(makeCuboidShape(4, 12, 0, 12, 16, 16)); // CUBE
                        shapes.add(makeCuboidShape(12, 12, 4, 16, 16, 12)); // CUBE
                        shapes.add(makeCuboidShape(0, 12, 4, 4, 16, 12)); // CUBE
                        return result(shapes);
                    }
                    default: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                    }
                }
            }
            case WEST: {
                switch (state.get(TYPE)) {
                    case 0: {
                        return Block.makeCuboidShape(0, 0, 4, 4, 16, 12);
                    }
                    case 1: {
                        List<VoxelShape> shapes = new ArrayList<>();
                        shapes.add(makeCuboidShape(0, 0, 4, 4, 16, 12)); // CUBE
                        shapes.add(makeCuboidShape(4, 12, 4, 16, 16, 12)); // CUBE
                        return result(shapes);
                    }
                    case 2: {
                        return Block.makeCuboidShape(0, 12, 4, 16, 16, 12);
                    }
                    case 3: {
                        return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 12, 0, 12, 16, 4),
                                Block.makeCuboidShape(0, 12, 4, 16, 16, 12), IBooleanFunction.OR);
                    }
                    case 4: {
                        return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 12, 12, 12, 16, 16),
                                Block.makeCuboidShape(0, 12, 4, 16, 16, 12), IBooleanFunction.OR);
                    }
                    case 5: {
                        List<VoxelShape> shapes = new ArrayList<>();
                        shapes.add(makeCuboidShape(4, 12, 12, 12, 16, 16)); // CUBE
                        shapes.add(makeCuboidShape(4, 12, 0, 12, 16, 4)); // CUBE
                        shapes.add(makeCuboidShape(0, 12, 4, 16, 16, 12)); // CUBE
                        return result(shapes);
                    }
                    default: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                    }
                }
            }
            case EAST: {
                switch (state.get(TYPE)) {
                    case 0: {
                        return Block.makeCuboidShape(12, 0, 4, 16, 16, 12);
                    }
                    case 1: {
                        List<VoxelShape> shapes = new ArrayList<>();
                        shapes.add(makeCuboidShape(12, 0, 4, 16, 16, 12)); // CUBE
                        shapes.add(makeCuboidShape(0, 12, 4, 12, 16, 12)); // CUBE
                        return result(shapes);
                    }
                    case 2: {
                        return Block.makeCuboidShape(0, 12, 4, 16, 16, 12);
                    }
                    case 3: {
                        return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 12, 12, 12, 16, 16),
                                Block.makeCuboidShape(0, 12, 4, 16, 16, 12), IBooleanFunction.OR);
                    }
                    case 4: {
                        return VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 12, 0, 12, 16, 4),
                                Block.makeCuboidShape(0, 12, 4, 16, 16, 12), IBooleanFunction.OR);
                    }
                    case 5: {
                        List<VoxelShape> shapes = new ArrayList<>();
                        shapes.add(makeCuboidShape(4, 12, 12, 12, 16, 16)); // CUBE
                        shapes.add(makeCuboidShape(4, 12, 0, 12, 16, 4)); // CUBE
                        shapes.add(makeCuboidShape(0, 12, 4, 16, 16, 12)); // CUBE
                        return result(shapes);
                    }
                    default: {
                        return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
                    }
                }
            }
            default:
                return Block.makeCuboidShape(0, 0, 0, 16, 16, 16);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand, BlockRayTraceResult rayTraceResult) {
        if(entity.getHeldItem(hand).getItem()== WNItems.CHISEL)/*checks if held item is stick for example*/ {
            if(entity.isSneaking()){
                if(this!=WNBlocks.BEAMS){
                    Block b = Main.getBlockByID("wildnature:"+state.getBlock().getRegistryName().getNamespace().replace("_beams",""));
                    if(b!=Blocks.AIR){
                        world.setBlockState(pos,WNBlocks.BEAMS.getDefaultState().with(FACING,state.get(FACING)).with(TYPE,state.get(TYPE)));
                        spawnAsEntity(world,pos,new ItemStack(Item.getItemFromBlock(b)));
                        return ActionResultType.SUCCESS;
                    }
                }
            }else {
                int currentType = state.get(TYPE);//gets current type from clicked block
                int validType = currentType;
                if (currentType >= getMaxTypes()) {
                    validType = 0;//resets validType if currentType is bigger than allowed
                } else {
                    validType++;
                }

                world.setBlockState(pos, state.with(TYPE, validType));//replaces that block with same block but another TYPE property
                return ActionResultType.SUCCESS;
            }
        }else{
            ItemStack s = entity.getHeldItem(hand);
            Block b = Block.getBlockFromItem(s.getItem());
            if(b!=null && b!= Blocks.AIR){
                if(b.getDefaultState().isSolid()){
                    BlockState newBlock = Main.getBlockByID("wildnature:"+b.getRegistryName().getNamespace()+"_beams").getDefaultState();
                    if(newBlock.getBlock()!=Blocks.AIR && newBlock.getBlock() instanceof BlockBeams){
                        world.setBlockState(pos,newBlock.with(FACING,state.get(FACING)).with(TYPE,state.get(TYPE)));
                        s.shrink(1);
                        return ActionResultType.SUCCESS;
                    }
                }
            }
        }
        return ActionResultType.PASS;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING).add(TYPE);
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     * @deprecated call via {@link #( Rotation )} whenever possible. Implementing/overriding is
     * fine.
     */
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     * @deprecated call via {@link #( Mirror )} whenever possible. Implementing/overriding is fine.
     */
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.with(FACING, mirrorIn.mirror(state.get(FACING)));
    }
}