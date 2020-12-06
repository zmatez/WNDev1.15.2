package com.matez.wildnature.common.registry;

import com.matez.wildnature.client.tabs.WNTabs;
import com.matez.wildnature.common.blocks.dungeondecoration.*;
import com.matez.wildnature.init.WN;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.WallOrFloorItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DungeonDecoRegistry {

    //Deferred Registries Method.
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WN.modid);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WN.modid);

    public static final RegistryObject<BaseBlock> stone_bricks_baseblock = BLOCKS.register("stone_bricks_baseblock", () -> new BaseBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Item> stone_bricks_baseblock_item = ITEMS.register("stone_bricks_baseblock", () -> new BlockItem(stone_bricks_baseblock.get(), new Item.Properties().group(WNTabs.ROCK_BUILDING)));

    public static final RegistryObject<MachicolationsBlock> stone_bricks_machicolations = BLOCKS.register("stone_bricks_machicolations", () -> new MachicolationsBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Item> stone_bricks_machicolations_item = ITEMS.register("stone_bricks_machicolations", () -> new BlockItem(stone_bricks_machicolations.get(), new Item.Properties().group(WNTabs.ROCK_BUILDING)));

    public static final RegistryObject<ArrowSlitBlock> stone_bricks_arrowslit = BLOCKS.register("stone_bricks_arrowslit", () -> new ArrowSlitBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Item> stone_bricks_arrowslit_item = ITEMS.register("stone_bricks_arrowslit", () -> new BlockItem(stone_bricks_arrowslit.get(), new Item.Properties().group(WNTabs.ROCK_BUILDING)));

    public static final RegistryObject<PillarBlock> stone_bricks_pillar = BLOCKS.register("stone_bricks_pillar", () -> new PillarBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<PillarFacingBlock> stone_bricks_pillar_facing = BLOCKS.register("stone_bricks_pillar_facing", () -> new PillarFacingBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Item> stone_bricks_pillar_item = ITEMS.register("stone_bricks_pillar", () -> new WallOrFloorItem(stone_bricks_pillar.get(), stone_bricks_pillar_facing.get(), (new Item.Properties()).group(WNTabs.ROCK_BUILDING)));

    public static final RegistryObject<PillarBlock> stone_bricks_thin_pillar = BLOCKS.register("stone_bricks_thin_pillar", () -> new PillarBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<PillarFacingBlock> stone_bricks_thin_pillar_facing = BLOCKS.register("stone_bricks_thin_pillar_facing", () -> new PillarFacingBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Item> stone_bricks_thin_pillar_item = ITEMS.register("stone_bricks_thin_pillar", () -> new WallOrFloorItem(stone_bricks_thin_pillar.get(), stone_bricks_thin_pillar_facing.get(), (new Item.Properties()).group(WNTabs.ROCK_BUILDING)));

    public static void init()
    {
        WN.LOGGER.info("WN: DungeonDecoRegistry registering.");
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
