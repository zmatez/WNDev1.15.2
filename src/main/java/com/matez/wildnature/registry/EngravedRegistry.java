package com.matez.wildnature.registry;

import com.matez.wildnature.blocks.BlockBase;
import com.matez.wildnature.blocks.SlabBase;
import com.matez.wildnature.blocks.StairsBase;
import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import static com.matez.wildnature.Main.RegistryEvents.location;
import static com.matez.wildnature.Main.WILDNATURE_BUILDING_GROUP;

public class EngravedRegistry {

    Block[] engraved;

    public EngravedRegistry() {
        engraved = new Block[]{
                WNBlocks.STONE_ROOF = new BlockBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("stone_roof")),


                WNBlocks.GRANITE_ROOF = new BlockBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("granite_roof")),
                WNBlocks.DIORITE_ROOF = new BlockBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("diorite_roof")),
                WNBlocks.ANDESITE_ROOF = new BlockBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("andesite_roof")),
                WNBlocks.BASALT_ROOF = new BlockBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("basalt_roof")),
                WNBlocks.CONGLOMERATE_ROOF = new BlockBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("conglomerate_roof")),
                WNBlocks.GNEISS_ROOF = new BlockBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("gneiss_roof")),
                WNBlocks.LIMESTONE_ROOF = new BlockBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("limestone_roof")),
                WNBlocks.MARBLE_ROOF = new BlockBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("marble_roof")),
                WNBlocks.PEGMATITE_ROOF = new BlockBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("pegmatite_roof")),
                WNBlocks.SLATE_ROOF = new BlockBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("slate_roof")),


                //BlocksList.BASALT_ROOF_2 = new BlockBase(Block.Properties.create(Material.ROCK), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("basalt_roof_2")),
                //BlocksList.CONGLOMERATE_ROOF_2 = new BlockBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("conglomerate_roof_2")),
                //BlocksList.GNEISS_ROOF_2 = new BlockBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("gneiss_roof_2")),
                //BlocksList.LIMESTONE_ROOF_2 = new BlockBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("limestone_roof_2")),
                //BlocksList.MARBLE_ROOF_2 = new BlockBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("marble_roof_2")),
                //BlocksList.PEGMATITE_ROOF_2 = new BlockBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("pegmatite_roof_2")),
                //BlocksList.SLATE_ROOF_2= new BlockBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("slate_roof_2")),

                WNBlocks.STONE_ROOF_SLAB = new SlabBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("stone_roof_slab")),


                WNBlocks.GRANITE_ROOF_SLAB = new SlabBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("granite_roof_slab")),
                WNBlocks.DIORITE_ROOF_SLAB = new SlabBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("diorite_roof_slab")),
                WNBlocks.ANDESITE_ROOF_SLAB = new SlabBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("andesite_roof_slab")),
                WNBlocks.BASALT_ROOF_SLAB = new SlabBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("basalt_roof_slab")),
                WNBlocks.CONGLOMERATE_ROOF_SLAB = new SlabBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("conglomerate_roof_slab")),
                WNBlocks.GNEISS_ROOF_SLAB = new SlabBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("gneiss_roof_slab")),
                WNBlocks.LIMESTONE_ROOF_SLAB = new SlabBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("limestone_roof_slab")),
                WNBlocks.MARBLE_ROOF_SLAB = new SlabBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("marble_roof_slab")),
                WNBlocks.PEGMATITE_ROOF_SLAB = new SlabBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("pegmatite_roof_slab")),
                WNBlocks.SLATE_ROOF_SLAB = new SlabBase(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("slate_roof_slab")),


                //BlocksList.BASALT_ROOF_2_SLAB = new SlabBase(Block.Properties.create(Material.ROCK), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("basalt_roof_2_slab")),
                //BlocksList.CONGLOMERATE_ROOF_2_SLAB = new SlabBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("conglomerate_roof_2_slab")),
                //BlocksList.GNEISS_ROOF_2_SLAB = new SlabBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("gneiss_roof_2_slab")),
                //BlocksList.LIMESTONE_ROOF_2_SLAB = new SlabBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("limestone_roof_2_slab")),
                //BlocksList.MARBLE_ROOF_2_SLAB = new SlabBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("marble_roof_2_slab")),
                //BlocksList.PEGMATITE_ROOF_2_SLAB = new SlabBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("pegmatite_roof_2_slab")),
                //BlocksList.SLATE_ROOF_2_SLAB= new SlabBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("slate_roof_2_slab")),

                WNBlocks.STONE_ROOF_STAIRS = new StairsBase(WNBlocks.BASALT_ROCK.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("stone_roof_stairs")),


                WNBlocks.GRANITE_ROOF_STAIRS = new StairsBase(WNBlocks.BASALT_ROCK.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("granite_roof_stairs")),
                WNBlocks.DIORITE_ROOF_STAIRS = new StairsBase(WNBlocks.BASALT_ROCK.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("diorite_roof_stairs")),
                WNBlocks.ANDESITE_ROOF_STAIRS = new StairsBase(WNBlocks.BASALT_ROCK.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("andesite_roof_stairs")),
                WNBlocks.BASALT_ROOF_STAIRS = new StairsBase(WNBlocks.BASALT_ROCK.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("basalt_roof_stairs")),
                WNBlocks.CONGLOMERATE_ROOF_STAIRS = new StairsBase(WNBlocks.CONGLOMERATE_ROCK.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("conglomerate_roof_stairs")),
                WNBlocks.GNEISS_ROOF_STAIRS = new StairsBase(WNBlocks.GNEISS_ROCK.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("gneiss_roof_stairs")),
                WNBlocks.LIMESTONE_ROOF_STAIRS = new StairsBase(WNBlocks.LIMESTONE_ROCK.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("limestone_roof_stairs")),
                WNBlocks.MARBLE_ROOF_STAIRS = new StairsBase(WNBlocks.MARBLE_ROCK.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("marble_roof_stairs")),
                WNBlocks.PEGMATITE_ROOF_STAIRS = new StairsBase(WNBlocks.PEGMATITE_ROCK.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("pegmatite_roof_stairs")),
                WNBlocks.SLATE_ROOF_STAIRS = new StairsBase(WNBlocks.SLATE_ROCK.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(1.3F, 4.5F), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("slate_roof_stairs")),

                //BlocksList.BASALT_ROOF_2_STAIRS = new StairsBase(BlocksList.BASALT_ROCK.getDefaultState(),Block.Properties.create(Material.ROCK), new Item.Properties().group(WILDNATURE_BUILDING_GROUP), location("basalt_roof_2_stairs")),
                //BlocksList.CONGLOMERATE_ROOF_2_STAIRS = new StairsBase(BlocksList.CONGLOMERATE_ROCK.getDefaultState(),Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("conglomerate_roof_2_stairs")),
                //BlocksList.GNEISS_ROOF_2_STAIRS = new StairsBase(BlocksList.GNEISS_ROCK.getDefaultState(),Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("gneiss_roof_2_stairs")),
                //BlocksList.LIMESTONE_ROOF_2_STAIRS = new StairsBase(BlocksList.LIMESTONE_ROCK.getDefaultState(),Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("limestone_roof_2_stairs")),
                //BlocksList.MARBLE_ROOF_2_STAIRS = new StairsBase(BlocksList.MARBLE_ROCK.getDefaultState(),Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("marble_roof_2_stairs")),
                //BlocksList.PEGMATITE_ROOF_2_STAIRS = new StairsBase(BlocksList.PEGMATITE_ROCK.getDefaultState(),Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("pegmatite_roof_2_stairs")),
                //BlocksList.SLATE_ROOF_2_STAIRS= new StairsBase(BlocksList.SLATE_ROCK.getDefaultState(),Block.Properties.create(Material.ROCK),new Item.Properties().group(WILDNATURE_BUILDING_GROUP),location("slate_roof_2_stairs")),

        };
    }

    public Block[] getEngraved() {
        return engraved;
    }
}
