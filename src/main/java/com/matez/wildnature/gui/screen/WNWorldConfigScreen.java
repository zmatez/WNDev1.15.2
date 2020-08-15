package com.matez.wildnature.gui.screen;


import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.customizable.WNConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.CreateWorldScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WNWorldConfigScreen extends Screen {

    public static final String player = Minecraft.getInstance().getName();
    public CreateWorldScreen parent;
    public CompoundNBT chunkProviderSettings;

    public WNWorldConfigScreen(CreateWorldScreen parentIn, CompoundNBT nbt) {
        super(new TranslationTextComponent("gui.wildnature_world_config_screen"));
        parent=parentIn;
        chunkProviderSettings =nbt;
    }

    @Override
    protected void init() {

        /*bExit = this.addButton(new Button(10, height-30, 110, 20, I18n.format("menu.wildnature.team"), (p_213094_1_) -> {

        }));*/



    }

    private void refresh(){
        this.init(Minecraft.getInstance(),width,height);
    }


    @Override
    public void tick() {
        super.tick();

    }



    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        this.renderBackground();

        this.fillGradient(0, 0, this.width-200, this.height, -1072689136, -804253680);
        this.drawString(this.font, "World Configuration", 10, 5, 16777215);
        this.drawString(this.font, "In progress. Feature will be available in 2.1.8", 50, 20, 16777215);


        super.render(p_render_1_, p_render_2_, p_render_3_);

    }

}
