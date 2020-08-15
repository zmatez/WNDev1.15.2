package com.matez.wildnature.data.gen.types;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;

public class WNItemModelGenerator extends ItemModelProvider {

    public WNItemModelGenerator(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    public String getName() {
        return "WildNature Item Models";
    }

    @Override
    protected void registerModels() {

    }
}
