package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class SaltOreBlock extends BlockBase {
    public static final EnumProperty<SaltVariant> SALT_VARIANT = EnumProperty.create("type", SaltVariant.class);;
    public SaltOreBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    public SaltOreBlock(Properties properties, Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
        super(properties, builder, drop, min, max, exp, regName);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(SALT_VARIANT);
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        if(state.get(SALT_VARIANT)==SaltVariant.STONE){
            return 1;
        }else{
            return 0;
        }
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state) {
        if(state.get(SALT_VARIANT)==SaltVariant.STONE){
            return ToolType.PICKAXE;
        }else{
            return ToolType.SHOVEL;
        }
    }

    @Override
    public float getBlockHardness(BlockState state, IBlockReader p_176195_2_, BlockPos p_176195_3_) {
        if(state.get(SALT_VARIANT)==SaltVariant.STONE){
            return 1.5F;
        }else{
            return 0.5F;
        }
    }

    @Override
    public float getExplosionResistance(BlockState state, IWorldReader world, BlockPos pos, @Nullable Entity exploder, Explosion explosion) {
        if(state.get(SALT_VARIANT)==SaltVariant.STONE){
            return 1.5F;
        }else{
            return 0.5F;
        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> list = new ArrayList<>();
        list.add(new ItemStack(WNItems.SALT, Utilities.rint(2,5)));

        return list;
    }

    @Override
    public SoundType getSoundType(BlockState state, IWorldReader world, BlockPos pos, @Nullable Entity entity) {
        if(state.get(SALT_VARIANT)==SaltVariant.STONE){
            return SoundType.STONE;
        }else{
            return SoundType.SAND;
        }
    }

    public enum SaltVariant implements IStringSerializable {
        STONE("stone"),
        SAND("sand");

        private final String name;


        private SaltVariant(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}

