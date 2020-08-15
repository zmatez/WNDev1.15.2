package com.matez.wildnature.gui.screen;


import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ServerListScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WildNatureScreen extends Screen {

    private static final ResourceLocation MINECRAFT_TITLE_TEXTURES = new ResourceLocation("textures/gui/title/minecraft.png");
    public static final String player = Minecraft.getInstance().getName();
    private currentCard current = currentCard.INFO;
    private Button bInfo,bUser,bPatreon,bFeedback,bTeam,bExit,selectedBtn = new Button(0,0,0,0,I18n.format("menu.wildnature.info"),null);

    public WildNatureScreen() {
        super(new TranslationTextComponent("gui.wildnature_screen"));
    }

    @Override
    protected void init() {

        bInfo = this.addButton(new Button(10, 85, 110, 20, I18n.format("menu.wildnature.info"), (p_213094_1_) -> {
            current=currentCard.INFO;
            selectedBtn=bInfo;
            refresh();

        }));
        bUser = this.addButton(new Button(10, 110, 110, 20, I18n.format("menu.wildnature.user"), (p_213094_1_) -> {
            current=currentCard.USER;
            selectedBtn=bUser;
            refresh();

        }));
        bPatreon = this.addButton(new Button(10, 135, 110, 20, I18n.format("menu.wildnature.patreon"), (p_213094_1_) -> {
            current=currentCard.PATREON;
            selectedBtn=bPatreon;
            refresh();

        }));
        bFeedback = this.addButton(new Button(10, 160, 110, 20, I18n.format("menu.wildnature.feedback"), (p_213094_1_) -> {
            current=currentCard.FEEDBACK;
            selectedBtn=bFeedback;
            refresh();

        }));
        bTeam = this.addButton(new Button(10, 185, 110, 20, I18n.format("menu.wildnature.team"), (p_213094_1_) -> {
            current=currentCard.TEAM;
            selectedBtn=bTeam;
            refresh();

        }));

        bExit = this.addButton(new Button(10, height-30, 110, 20, I18n.format("menu.wildnature.team"), (p_213094_1_) -> {

        }));




    }

    private void refresh(){
        this.init(Minecraft.getInstance(),width,height);
    }


    @Override
    public void tick() {
        super.tick();

        if(current==currentCard.INFO){
            bInfo.active=false;
            bUser.active=true;
            bPatreon.active=true;
            bFeedback.active=true;
            bTeam.active=true;
        }
        if(current==currentCard.USER){
            bInfo.active=true;
            bUser.active=false;
            bPatreon.active=true;
            bFeedback.active=true;
            bTeam.active=true;
        }
        if(current==currentCard.PATREON){
            bInfo.active=true;
            bUser.active=true;
            bPatreon.active=false;
            bFeedback.active=true;
            bTeam.active=true;
        }
        if(current==currentCard.FEEDBACK){
            bInfo.active=true;
            bUser.active=true;
            bPatreon.active=true;
            bFeedback.active=false;
            bTeam.active=true;
        }
        if(current==currentCard.TEAM){
            bInfo.active=true;
            bUser.active=true;
            bPatreon.active=true;
            bFeedback.active=true;
            bTeam.active=false;
        }
    }



    @Override
    public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
        this.renderBackground();

        this.fillGradient(130, 65, this.width, this.height, -1072689136, -804253680);

        this.drawString(this.font, "WildNature Manager", 15, 75, 16777215);
        this.drawString(this.font, selectedBtn.getMessage(), 150, 75, 16777215);


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
