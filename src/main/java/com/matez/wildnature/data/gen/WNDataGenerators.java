package com.matez.wildnature.data.gen;

import com.matez.wildnature.Main;
import com.matez.wildnature.data.gen.types.WNBlockModelGenerator;
import com.matez.wildnature.data.gen.types.WNBlockstateGenerator;
import com.matez.wildnature.data.gen.types.WNItemModelGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WNDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        Main.wnInfo("Starting data generators");
        DataGenerator generator = event.getGenerator();
        generator.addProvider(new WNBlockstateGenerator(generator, Main.modid, event.getExistingFileHelper()));
        generator.addProvider(new WNBlockModelGenerator(generator, Main.modid, event.getExistingFileHelper()));
        generator.addProvider(new WNItemModelGenerator(generator, Main.modid, event.getExistingFileHelper()));
    }

    public static void generate(){
    }

    private static void register(WNBlockGenerator generator){

    }
}
