package com.matez.wildnature.common.registry.items;

import com.matez.wildnature.common.items.SilverCrossbowItem;
import com.matez.wildnature.common.items.weapons.SilverAxeItem;
import com.matez.wildnature.common.items.weapons.SilverPickaxeItem;
import com.matez.wildnature.common.items.weapons.SilverShovelItem;
import com.matez.wildnature.common.items.weapons.SilverSwordItem;
import com.matez.wildnature.init.WN;
import com.matez.wildnature.client.tabs.WNTabs;
import com.matez.wildnature.common.items.dye.*;
import com.matez.wildnature.util.lists.WNItems;
import com.matez.wildnature.common.items.tier.WNItemTier;
import net.minecraft.item.*;

public class GemRegistry {

    Item[] item;

    public GemRegistry(){
        item = new Item[]{
                //DECO GEMS
                WNItems.AMBER_INGOT = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("amber_ingot")),

                //GEMS
                WNItems.TIN_RAW = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("tin_raw")),
                WNItems.TIN_INGOT = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("tin_ingot")),
                WNItems.COPPER_INGOT = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("copper_ingot")),
                WNItems.BRONZE_INGOT = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("bronze_ingot")),
                WNItems.STEEL_INGOT = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("steel_ingot")),
                WNItems.SILVER_INGOT = new DyeableItem(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("silver_ingot")),
                WNItems.SAPPHIRE_RAW = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("sapphire_raw")),
                WNItems.SAPPHIRE_INGOT = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("sapphire_ingot")),
                WNItems.RUBY_RAW = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("ruby_raw")),
                WNItems.RUBY_INGOT = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("ruby_ingot")),
                WNItems.MALACHITE_RAW = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("malachite_raw")),
                WNItems.MALACHITE_INGOT = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("malachite_ingot")),
                WNItems.AMETHYST_RAW = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("amethyst_raw")),
                WNItems.AMETHYST_SHARD = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("amethyst_shard")),
                WNItems.AMETHYST_INGOT = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("amethyst_ingot")),


                //TOOLS
                WNItems.BRONZE_SWORD = new SwordItem(WNItemTier.BRONZE, 2, -2.1F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("bronze_sword")),
                WNItems.BRONZE_PICKAXE = new PickaxeItem(WNItemTier.BRONZE, 0, -2.5F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("bronze_pickaxe")),
                WNItems.BRONZE_AXE = new AxeItem(WNItemTier.BRONZE, 5, -2.6F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("bronze_axe")),
                WNItems.BRONZE_SHOVEL = new ShovelItem(WNItemTier.BRONZE, 1.2F, -2.8F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("bronze_shovel")),
                WNItems.BRONZE_HOE = new HoeItem(WNItemTier.BRONZE,  -0.7F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("bronze_hoe")),

                WNItems.STEEL_SWORD = new SwordItem(WNItemTier.STEEL, 2, -2.7F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("steel_sword")),
                WNItems.STEEL_PICKAXE = new PickaxeItem(WNItemTier.STEEL, 0, -3.1F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("steel_pickaxe")),
                WNItems.STEEL_AXE = new AxeItem(WNItemTier.STEEL, 4, -3.3F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("steel_axe")),
                WNItems.STEEL_SHOVEL = new ShovelItem(WNItemTier.STEEL, 0f, -3.2F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("steel_shovel")),
                WNItems.STEEL_HOE = new HoeItem(WNItemTier.STEEL,  -1.5F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("steel_hoe")),

                WNItems.SILVER_SWORD = new SilverSwordItem(WNItemTier.SILVER, 2, -1.8F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("silver_sword")),
                WNItems.SILVER_PICKAXE = new SilverPickaxeItem(WNItemTier.SILVER, 0, -2.8F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("silver_pickaxe")),
                WNItems.SILVER_AXE = new SilverAxeItem(WNItemTier.SILVER, 4.8f, -3F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("silver_axe")),
                WNItems.SILVER_SHOVEL = new SilverShovelItem(WNItemTier.SILVER, 0.8F, -3F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("silver_shovel")),
                WNItems.SILVER_CROSSBOW = new SilverCrossbowItem((new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("silver_crossbow")),

                WNItems.SAPPHIRE_SWORD = new SwordItem(WNItemTier.SAPPHIRE, 3, -2.4F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("sapphire_sword")),
                WNItems.SAPPHIRE_PICKAXE = new PickaxeItem(WNItemTier.SAPPHIRE, 1, -2.8F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("sapphire_pickaxe")),
                WNItems.SAPPHIRE_AXE = new AxeItem(WNItemTier.SAPPHIRE, 5, -3F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("sapphire_axe")),
                WNItems.SAPPHIRE_SHOVEL = new ShovelItem(WNItemTier.SAPPHIRE, 1.5F, -3F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("sapphire_shovel")),

                WNItems.RUBY_SWORD = new SwordItem(WNItemTier.RUBY, 3, -2.4F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("ruby_sword")),
                WNItems.RUBY_PICKAXE = new PickaxeItem(WNItemTier.RUBY, 1, -2.8F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("ruby_pickaxe")),
                WNItems.RUBY_AXE = new AxeItem(WNItemTier.RUBY, 5, -3F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("ruby_axe")),
                WNItems.RUBY_SHOVEL = new ShovelItem(WNItemTier.RUBY, 0F, -3F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("ruby_shovel")),

                WNItems.MALACHITE_SWORD = new SwordItem(WNItemTier.MALACHITE, 3, -2.1F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("malachite_sword")),
                WNItems.MALACHITE_PICKAXE = new PickaxeItem(WNItemTier.MALACHITE, 0, -2.6F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("malachite_pickaxe")),
                WNItems.MALACHITE_AXE = new AxeItem(WNItemTier.MALACHITE, 5, -2.8F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("malachite_axe")),
                WNItems.MALACHITE_SHOVEL = new ShovelItem(WNItemTier.MALACHITE, 0F, -3F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("malachite_shovel")),


                WNItems.AMETHYST_SWORD = new SwordItem(WNItemTier.AMETHYST, 4, -2.4F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("amethyst_sword")),
                WNItems.AMETHYST_PICKAXE = new PickaxeItem(WNItemTier.AMETHYST, 0, -2.8F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("amethyst_pickaxe")),
                WNItems.AMETHYST_AXE = new AxeItem(WNItemTier.AMETHYST, 6, -3F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("amethyst_axe")),
                WNItems.AMETHYST_SHOVEL = new ShovelItem(WNItemTier.AMETHYST, 0F, -3F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("amethyst_shovel")),
                WNItems.AMETHYST_HOE = new HoeItem(WNItemTier.AMETHYST,  0F, (new Item.Properties()).group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("amethyst_hoe")),

                //MISC
                WNItems.HANDLE_LEATHER = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("handle_leather")),
                WNItems.HANDLE_GOLD = new Item(new Item.Properties().group(WNTabs.EQUIPMENT)).setRegistryName(WN.RegistryEvents.location("handle_gold")),

        };
    }

    public Item[] getItems() {
        return item;
    }
}
