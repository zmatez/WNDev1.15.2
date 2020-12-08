package com.matez.wildnature.common.registry.items;

import com.matez.wildnature.client.tabs.WNTabs;
import com.matez.wildnature.common.items.*;
import com.matez.wildnature.common.items.recipes.cooking.CookingToolType;
import com.matez.wildnature.common.items.tier.WNItemTier;
import com.matez.wildnature.util.lists.WNItems;
import net.minecraft.item.*;

import static com.matez.wildnature.init.WN.*;
import static com.matez.wildnature.init.WN.RegistryEvents.location;

public class ItemRegistry {

    public Item[] items;

    public ItemRegistry(){
        items = new Item[]{
                //PLATES JUGS ETC
                WNItems.CUP = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("cup")),
                WNItems.JUG = new JugItem(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("jug")),
                WNItems.GLASS = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("glass")),
                WNItems.JAR = new JarItem(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("jar")),
                WNItems.GLASS_CUP = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("glass_cup")),
                WNItems.WINE_BOTTLE = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("wine_bottle")),
                WNItems.WOODEN_MUG = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("wooden_mug")),
                WNItems.PLATE = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("plate")),
                WNItems.MAPLE_BOWL = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("maple_bowl")),
                WNItems.DEEP_BOWL = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("deep_bowl")),
                //HAMMERS
                WNItems.WOODEN_HAMMER = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("wooden_hammer")),
                WNItems.STONE_HAMMER = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("stone_hammer")),
                WNItems.IRON_HAMMER = new Item(new Item.Properties().group(WNTabs.FOOD)).setRegistryName(location("iron_hammer")),
                //COOKING TOOLS
                WNItems.CHEF_KNIFE = new KnifeItem(WNItemTier.KITCHEN_TOOLS,1,5,new Item.Properties().group(WNTabs.FOOD).maxStackSize(1)).setRegistryName(location("chef_knife")),
                WNItems.FRYING_PAN = new CookingItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1), CookingToolType.FRYING_PAN).setRegistryName(location("frying_pan")),
                WNItems.POT_EMPTY = new PotEmptyItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1)).setRegistryName(location("pot_empty")),
                WNItems.POT_WATER = new CookingItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1), CookingToolType.POT).setRegistryName(location("pot_water")),
                WNItems.CAKE_PAN = new CookingItem(new Item.Properties().group(WNTabs.FOOD).maxStackSize(1), CookingToolType.CAKE_PAN).setRegistryName(location("cake_pan")),
                //XMAS
                WNItems.GIFT_1 = new GiftItem(getBlockByID("wildnature:present_1"),new Item.Properties().group(WNTabs.EQUIPMENT), GiftItem.GiftColor.CYAN_RED).setRegistryName(location("gift_1")),
                WNItems.GIFT_2 = new GiftItem(getBlockByID("wildnature:present_2"),new Item.Properties().group(WNTabs.EQUIPMENT), GiftItem.GiftColor.RED_YELLOW).setRegistryName(location("gift_2")),
                WNItems.GIFT_3 = new GiftItem(getBlockByID("wildnature:present_3"),new Item.Properties().group(WNTabs.EQUIPMENT), GiftItem.GiftColor.BLUE_PINK).setRegistryName(location("gift_3")),
                WNItems.XMAS_PAPER_1 = new WrappingPaperItem(new Item.Properties().group(WNTabs.EQUIPMENT), GiftItem.GiftColor.CYAN_RED).setRegistryName(location("xmas_paper_1")),
                WNItems.XMAS_PAPER_2 = new WrappingPaperItem(new Item.Properties().group(WNTabs.EQUIPMENT), GiftItem.GiftColor.RED_YELLOW).setRegistryName(location("xmas_paper_2")),
                WNItems.XMAS_PAPER_3 = new WrappingPaperItem(new Item.Properties().group(WNTabs.EQUIPMENT), GiftItem.GiftColor.BLUE_PINK).setRegistryName(location("xmas_paper_3")),
                //BACKPACKS
                WNItems.POUCH = new PouchItem(new Item.Properties().group(WNTabs.EQUIPMENT).maxStackSize(1)).setRegistryName(location("pouch")),
                WNItems.BACKPACK_SMALL = new BackpackSmallItem(new Item.Properties().group(WNTabs.EQUIPMENT).maxStackSize(1)).setRegistryName(location("backpack_small")),
                WNItems.BACKPACK_MEDIUM = new BackpackMediumItem(new Item.Properties().group(WNTabs.EQUIPMENT).maxStackSize(1)).setRegistryName(location("backpack_medium")),
                WNItems.BACKPACK_BIG = new BackpackBigItem(new Item.Properties().group(WNTabs.EQUIPMENT).maxStackSize(1)).setRegistryName(location("backpack_big")),
                //TOOLS
                WNItems.CHISEL = new Item(new Item.Properties().group(WNTabs.EQUIPMENT).maxStackSize(1)).setRegistryName(location("chisel")),
                //OTHER
                WNItems.DUNGEON_TORCH = new WallOrFloorItem(getBlockByID("wildnature:dungeon_torch"), getBlockByID("wildnature:dungeon_torch_wall"), (new Item.Properties()).group(WNTabs.FURNITURE)).setRegistryName("wildnature:dungeon_torch"),
                WNItems.CRYSTAL_TORCH = new WallOrFloorItem(getBlockByID("wildnature:crystal_torch"), getBlockByID("wildnature:crystal_torch_wall"), (new Item.Properties()).group(WNTabs.FURNITURE)).setRegistryName("wildnature:crystal_torch"),
                WNItems.DUNGEON_REDSTONE_TORCH = new WallOrFloorItem(getBlockByID("wildnature:dungeon_redstone_torch"), getBlockByID("wildnature:dungeon_redstone_torch_wall"), (new Item.Properties()).group(ItemGroup.REDSTONE)).setRegistryName("wildnature:dungeon_redstone_torch"),
                WNItems.RS_PISTON1 = new BlockNamedItem(getBlockByID("wildnature:rs_piston1"),new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(location("rs_piston1")),
                WNItems.GEYSER_ESSENCE = new GeyserEssenceItem(new Item.Properties().group(WNTabs.SURFACE)).setRegistryName(location("geyser_essence")),
                //JELLY BALLS
                WNItems.JELLY_BALL_BLUE = new Item(new Item.Properties().group(WNTabs.UNDERWATER).maxStackSize(16)).setRegistryName(location("jelly_ball_blue")),
                WNItems.JELLY_BALL_ORANGE = new Item(new Item.Properties().group(WNTabs.UNDERWATER).maxStackSize(16)).setRegistryName(location("jelly_ball_orange")),
                WNItems.JELLY_BALL_PINK = new Item(new Item.Properties().group(WNTabs.UNDERWATER).maxStackSize(16)).setRegistryName(location("jelly_ball_pink")),
                WNItems.JELLY_BALL_RED = new Item(new Item.Properties().group(WNTabs.UNDERWATER).maxStackSize(16)).setRegistryName(location("jelly_ball_red")),
                WNItems.JELLY_BALL_WHITE = new Item(new Item.Properties().group(WNTabs.UNDERWATER).maxStackSize(16)).setRegistryName(location("jelly_ball_white")),
                //CAVE DUSTS
                WNItems.GLOWSHROOM_DUST = new Item(new Item.Properties().group(WNTabs.CAVES)).setRegistryName(location("glowshroom_dust")),
                WNItems.ICESHROOM_DUST = new Item(new Item.Properties().group(WNTabs.CAVES)).setRegistryName(location("iceshroom_dust"))
        };
    }

    public Item[] getItems() {
        return items;
    }
}
