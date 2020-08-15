package com.matez.wildnature.data.gen.types;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelFile;

public class WNBlockstateGenerator extends BlockStateProvider
{
    protected final String MODID;

    public WNBlockstateGenerator(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
        this.MODID = modid;
    }

    private String name(Block block) {
        return block.getRegistryName().getPath();
    }

    protected String getModId()
    {
        return this.MODID;
    }


    @Override
    protected void registerStatesAndModels() {
        //baseBlock(ModBlocks.basalt_baseblock.get());
        //stairsBlock((StairsBlock)ModBlocks.basalt_stairs.get(), modLoc("block/rocks/basalt/basalt"), modLoc("block/rocks/basalt/basalt"), modLoc("block/rocks/basalt/basalt"));
        //horizontalFaceShapeBlock(ModBlocks.basalt_cobble_arrowslit.get(), "castle/", 3);


    }

    protected void cubeBlockstate(Block block, ModelFile model) {
        getVariantBuilder(block).partialState().modelForState().modelFile(model);
    }

    protected void allRotationBlock(Block block, ModelFile model) {
        getVariantBuilder(block).partialState().with(BlockStateProperties.FACING, Direction.UP).modelForState().modelFile(model).rotationX(270).uvLock(true).addModel().partialState().with(
                BlockStateProperties.FACING, Direction.DOWN).modelForState().modelFile(model).rotationX(90).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING,
                Direction.NORTH).modelForState().modelFile(model).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).modelForState().modelFile(model).rotationY(
                180).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).modelForState().modelFile(model).rotationY(90).uvLock(true).addModel().partialState().with(
                BlockStateProperties.FACING, Direction.WEST).modelForState().modelFile(model).rotationY(270).uvLock(true).addModel();
    }

}