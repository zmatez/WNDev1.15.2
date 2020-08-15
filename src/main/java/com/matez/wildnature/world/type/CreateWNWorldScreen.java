package com.matez.wildnature.world.type;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CreateWNWorldScreen extends Screen {
    protected CreateWNWorldScreen() {
        super(new TranslationTextComponent("wnWorld.custom.name"));
    }
}
