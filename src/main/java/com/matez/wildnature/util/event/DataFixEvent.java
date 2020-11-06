package com.matez.wildnature.util.event;

public class DataFixEvent {
    /*@SubscribeEvent
    public void fixBlocks(RegistryEvent.MissingMappings<Block> event) {
        Main.LOGGER.info("---> Remapping blocks");
        int remapped = 0;
        int errors = 0;
        int ignored = 0;
        List<RegistryEvent.MissingMappings.Mapping<Block>> list = event.getAllMappings();
        LinkedHashMap<ResourceLocation, ResourceLocation> renameMap = Main.dataFixer.getBlockRemap();

        for (RegistryEvent.MissingMappings.Mapping<Block> mapping : list) {
            ResourceLocation oldLoc = mapping.key;
            ResourceLocation newLoc = renameMap.get(oldLoc);

            if (newLoc != null) {
                Block block = ForgeRegistries.BLOCKS.getValue(newLoc);

                if (block != null && block != Blocks.AIR) {
                    mapping.remap(block);
                    Main.LOGGER.debug("Re-mapped block '{}' => '{}'", oldLoc.toString(), newLoc.toString());
                    remapped++;
                }else{
                    Main.LOGGER.error("Couldn't re-map block '{}' !=> '{}': new mapping isn't registered ", oldLoc.toString(), newLoc.toString());
                    errors++;
                }
            }else{
                if(oldLoc.getNamespace().equals("wildnature")){
                    Main.LOGGER.debug("Ignoring mapping for block id '{}'", oldLoc.toString());
                    mapping.ignore();
                    ignored++;
                }
            }
        }

        Main.LOGGER.info("---> Remapped " + remapped + " with " + errors + " errors. Ignored " + ignored + " mappings.");
    }*/

    /*@SubscribeEvent
    public void fixItems(RegistryEvent.MissingMappings<Item> event) {
        Main.LOGGER.info("---> Remapping items");
        int remapped = 0;
        int errors = 0;
        List<RegistryEvent.MissingMappings.Mapping<Item>> list = event.getAllMappings();
        LinkedHashMap<ResourceLocation, ResourceLocation> renameMap = Main.dataFixer.getItemRemap();

        for (RegistryEvent.MissingMappings.Mapping<Item> mapping : list) {
            ResourceLocation oldLoc = mapping.key;
            ResourceLocation newLoc = renameMap.get(oldLoc);

            if (newLoc != null) {
                Item item = ForgeRegistries.ITEMS.getValue(newLoc);

                if (item != null && item != Items.AIR) {
                    mapping.remap(item);
                    Main.LOGGER.debug("Re-mapped item '{}' => '{}'", oldLoc.toString(), newLoc.toString());
                    remapped++;
                }else{
                    Main.LOGGER.error("Couldn't re-map item '{}' !=> '{}': new mapping isn't registered ", oldLoc.toString(), newLoc.toString());
                    errors++;
                }
            }
        }
        Main.LOGGER.info("---> Remapped " + remapped + " with " + errors + " errors.");
    }*/
}
