package com.matez.wildnature.gui.screen;


import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WNWorldCustomize extends Screen {

    private static final ResourceLocation MINECRAFT_TITLE_TEXTURES = new ResourceLocation("textures/gui/title/minecraft.png");
    public static final String player = Minecraft.getInstance().getName();
    private currentCard current = currentCard.INFO;
    private Button bInfo;

    public WNWorldCustomize() {
        super(new TranslationTextComponent("gui.wildnature_screen"));
    }

    @Override
    protected void init() {

        bInfo = this.addButton(new Button(10, 85, 110, 20, I18n.format("menu.wildnature.info"), (p_213094_1_) -> {
            current= currentCard.INFO;

        }));




    }


    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        this.renderBackground();

        this.fillGradient(130, 65, this.width, this.height, -1072689136, -804253680);

        this.drawString(this.font, "WildNature Manager", 15, 75, 16777215);


        this.minecraft.getTextureManager().bindTexture(MINECRAFT_TITLE_TEXTURES);
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        int j = this.width / 2 - 137;
        this.blit(j + 0, 30, 0, 0, 155, 44);
        this.blit(j + 155, 30, 0, 45, 155, 44);
        super.render(p_render_1_, p_render_2_, p_render_3_);

    }

    private enum currentCard{
        INFO,
        USER,
        PATREON,
        FEEDBACK,
        TEAM

    }
}
