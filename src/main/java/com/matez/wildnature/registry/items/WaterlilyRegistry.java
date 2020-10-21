package com.matez.wildnature.registry.items;

import com.matez.wildnature.itemGroup.WNTabs;
import com.matez.wildnature.items.*;
import com.matez.wildnature.items.recipes.cooking.CookingToolType;
import com.matez.wildnature.items.tier.WNItemTier;
import com.matez.wildnature.lists.WNItems;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.WallOrFloorItem;

import static com.matez.wildnature.Main.RegistryEvents.location;
import static com.matez.wildnature.Main.*;

public class WaterlilyRegistry {

    public Item[] items;

    public WaterlilyRegistry(){
        items = new Item[]{
                WNItems.GREEN_WATERLILY = new WaterlilyItem(getBlockByID("wildnature:green_waterlily"),new Item.Properties().group(WNTabs.UNDERWATER)).setRegistryName(location("green_waterlily")),
                WNItems.RED_WATERLILY = new WaterlilyItem(getBlockByID("wildnature:red_waterlily"),new Item.Properties().group(WNTabs.UNDERWATER)).setRegistryName(location("red_waterlily")),
                WNItems.DUCKWEED = new WaterlilyItem(getBlockByID("wildnature:duckweed"),new Item.Properties().group(WNTabs.UNDERWATER)).setRegistryName(location("duckweed")),
                WNItems.WATER_POPPY = new WaterlilyItem(getBlockByID("wildnature:water_poppy"),new Item.Properties().group(WNTabs.UNDERWATER)).setRegistryName(location("water_poppy")),
                WNItems.WATER_LILY_WHITE = new WaterlilyItem(getBlockByID("wildnature:water_lily_white"),new Item.Properties().group(WNTabs.UNDERWATER)).setRegistryName(location("water_lily_white")),
                WNItems.WATER_LILY_YELLOW = new WaterlilyItem(getBlockByID("wildnature:water_lily_yellow"),new Item.Properties().group(WNTabs.UNDERWATER)).setRegistryName(location("water_lily_yellow")),
                WNItems.LOTUS_PINK = new WaterlilyItem(getBlockByID("wildnature:lotus_pink"),new Item.Properties().group(WNTabs.UNDERWATER)).setRegistryName(location("lotus_pink")),
                WNItems.LOTUS_LIGHT_PINK = new WaterlilyItem(getBlockByID("wildnature:lotus_light_pink"),new Item.Properties().group(WNTabs.UNDERWATER)).setRegistryName(location("lotus_light_pink")),
                WNItems.LOTUS_WHITE = new WaterlilyItem(getBlockByID("wildnature:lotus_white"),new Item.Properties().group(WNTabs.UNDERWATER)).setRegistryName(location("lotus_white")),
                WNItems.WATER_HYACINTH = new WaterlilyItem(getBlockByID("wildnature:water_hyacinth"),new Item.Properties().group(WNTabs.UNDERWATER)).setRegistryName(location("water_hyacinth")),
                WNItems.POND_WEED = new WaterlilyItem(getBlockByID("wildnature:pond_weed"),new Item.Properties().group(WNTabs.UNDERWATER)).setRegistryName(location("pond_weed")),
                WNItems.PARROTS_FEATHER_PLANT = new WaterlilyItem(getBlockByID("wildnature:parrots_feather_plant"),new Item.Properties().group(WNTabs.UNDERWATER)).setRegistryName(location("parrots_feather_plant")),
                WNItems.MAGMA_PAD = new LavalilyItem(getBlockByID("wildnature:magma_pad"),new Item.Properties().group(WNTabs.CAVES)).setRegistryName(location("magma_pad"))
        };
    }

    public Item[] getItems() {
        return items;
    }
}
