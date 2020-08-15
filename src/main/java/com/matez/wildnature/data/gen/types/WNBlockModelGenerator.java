package com.matez.wildnature.data.gen.types;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class WNBlockModelGenerator extends BlockModelProvider {

    public WNBlockModelGenerator(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    public String getName() {
        return "WildNature Block Models";
    }

    @Override
    protected void registerModels() {

    }
}
