package com.matez.wildnature.registry;

import com.matez.wildnature.Main;
import com.matez.wildnature.items.dye.*;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.items.tier.WNItemTier;
import net.minecraft.item.*;

public class GemRegistry {

    Item[] item;

    public GemRegistry(){
        item = new Item[]{
                WNItems.TIN_INGOT = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("tin_ingot")),
                WNItems.COPPER_INGOT = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("copper_ingot")),
                WNItems.STEEL_INGOT = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("steel_ingot")),

                WNItems.BRONZE_INGOT = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("bronze_ingot")),
                WNItems.BRONZE_SWORD = new SwordItem(WNItemTier.BRONZE, 3, -2F, (new Item.Properties()).group(ItemGroup.COMBAT)).setRegistryName(Main.RegistryEvents.location("bronze_sword")),
                WNItems.BRONZE_PICKAXE = new PickaxeItem(WNItemTier.BRONZE, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("bronze_pickaxe")),
                WNItems.BRONZE_AXE = new AxeItem(WNItemTier.BRONZE, 5, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("bronze_axe")),
                WNItems.BRONZE_SHOVEL = new ShovelItem(WNItemTier.BRONZE, 1.5F, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("bronze_shovel")),
                WNItems.BRONZE_HOE = new HoeItem(WNItemTier.BRONZE,  0F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("bronze_hoe")),
                
                WNItems.AMETHYST_SHARD = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("amethyst_shard")),
                WNItems.AMETHYST_CRYSTAL = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("amethyst_crystal")),
                WNItems.AMETHYST_SWORD = new SwordItem(WNItemTier.AMETHYST, 3, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)).setRegistryName(Main.RegistryEvents.location("amethyst_sword")),
                WNItems.AMETHYST_PICKAXE = new PickaxeItem(WNItemTier.AMETHYST, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("amethyst_pickaxe")),
                WNItems.AMETHYST_AXE = new AxeItem(WNItemTier.AMETHYST, 5, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("amethyst_axe")),
                WNItems.AMETHYST_SHOVEL = new ShovelItem(WNItemTier.AMETHYST, 1.5F, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("amethyst_shovel")),
                WNItems.AMETHYST_HOE = new HoeItem(WNItemTier.AMETHYST,  0F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("amethyst_hoe")),

                WNItems.SAPPHIRE_SHARD = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("sapphire_shard")),
                WNItems.SAPPHIRE_CRYSTAL = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("sapphire_crystal")),
                WNItems.SAPPHIRE_SWORD = new SwordItem(WNItemTier.SAPPHIRE, 3, -2F, (new Item.Properties()).group(ItemGroup.COMBAT)).setRegistryName(Main.RegistryEvents.location("sapphire_sword")),
                WNItems.SAPPHIRE_PICKAXE = new PickaxeItem(WNItemTier.SAPPHIRE, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("sapphire_pickaxe")),
                WNItems.SAPPHIRE_AXE = new AxeItem(WNItemTier.SAPPHIRE, 5, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("sapphire_axe")),
                WNItems.SAPPHIRE_SHOVEL = new ShovelItem(WNItemTier.SAPPHIRE, 1.5F, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("sapphire_shovel")),
                WNItems.SAPPHIRE_HOE = new HoeItem(WNItemTier.SAPPHIRE,  0F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("sapphire_hoe")),

                WNItems.MALACHITE_SHARD = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("malachite_shard")),
                WNItems.MALACHITE_CRYSTAL = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("malachite_crystal")),
                WNItems.MALACHITE_SWORD = new SwordItem(WNItemTier.MALACHITE, 3, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT)).setRegistryName(Main.RegistryEvents.location("malachite_sword")),
                WNItems.MALACHITE_PICKAXE = new PickaxeItem(WNItemTier.MALACHITE, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("malachite_pickaxe")),
                WNItems.MALACHITE_AXE = new AxeItem(WNItemTier.MALACHITE, 5, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("malachite_axe")),
                WNItems.MALACHITE_SHOVEL = new ShovelItem(WNItemTier.MALACHITE, 1.5F, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("malachite_shovel")),
                WNItems.MALACHITE_HOE = new HoeItem(WNItemTier.MALACHITE,  0F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("malachite_hoe")),

                WNItems.SILVER_INGOT = new DyeableItem(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("silver_ingot")),
                WNItems.SILVER_SWORD = new DyeableSwordItem(WNItemTier.SILVER, 3, -1.8F, (new Item.Properties()).group(ItemGroup.COMBAT)).setRegistryName(Main.RegistryEvents.location("silver_sword")),
                WNItems.SILVER_PICKAXE = new DyeablePickaxeItem(WNItemTier.SILVER, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("silver_pickaxe")),
                WNItems.SILVER_AXE = new DyeableAxeItem(WNItemTier.SILVER, 5, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("silver_axe")),
                WNItems.SILVER_SHOVEL = new DyeableShovelItem(WNItemTier.SILVER, 1.5F, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("silver_shovel")),
                WNItems.SILVER_HOE = new DyeableHoeItem(WNItemTier.SILVER,  0F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("silver_hoe")),
                
                WNItems.AMBER_SHARD = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("amber_shard")),
                WNItems.AMBER_CRYSTAL = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("amber_crystal")),
                WNItems.AMBER_SWORD = new SwordItem(WNItemTier.AMBER, 3, -1.8F, (new Item.Properties()).group(ItemGroup.COMBAT)).setRegistryName(Main.RegistryEvents.location("amber_sword")),
                WNItems.AMBER_PICKAXE = new PickaxeItem(WNItemTier.AMBER, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("amber_pickaxe")),
                WNItems.AMBER_AXE = new AxeItem(WNItemTier.AMBER, 5, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("amber_axe")),
                WNItems.AMBER_SHOVEL = new ShovelItem(WNItemTier.AMBER, 1.5F, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("amber_shovel")),
                WNItems.AMBER_HOE = new HoeItem(WNItemTier.AMBER,  0F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("amber_hoe")),

                WNItems.RUBY_SHARD = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("ruby_shard")),
                WNItems.RUBY_CRYSTAL = new Item(new Item.Properties().group(Main.WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(Main.RegistryEvents.location("ruby_crystal")),
                WNItems.RUBY_SWORD = new SwordItem(WNItemTier.RUBY, 3, -2.3F, (new Item.Properties()).group(ItemGroup.COMBAT)).setRegistryName(Main.RegistryEvents.location("ruby_sword")),
                WNItems.RUBY_PICKAXE = new PickaxeItem(WNItemTier.RUBY, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("ruby_pickaxe")),
                WNItems.RUBY_AXE = new AxeItem(WNItemTier.RUBY, 5, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("ruby_axe")),
                WNItems.RUBY_SHOVEL = new ShovelItem(WNItemTier.RUBY, 1.5F, -3F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("ruby_shovel")),
                WNItems.RUBY_HOE = new HoeItem(WNItemTier.RUBY,  0F, (new Item.Properties()).group(ItemGroup.TOOLS)).setRegistryName(Main.RegistryEvents.location("ruby_hoe"))

        };
    }

    public Item[] getItem() {
        return item;
    }
}
