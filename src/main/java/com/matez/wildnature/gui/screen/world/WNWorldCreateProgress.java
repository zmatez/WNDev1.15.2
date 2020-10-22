package com.matez.wildnature.gui.screen.world;


import com.matez.wildnature.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.listener.TrackingChunkStatusListener;

public class WNWorldCreateProgress extends Screen {
    private final TrackingChunkStatusListener trackingProgress;
    private int centerWidth, centerHeight;
    private int screenX1, screenY1, screenX2, screenY2;
    private int sampleSize = 64;
    private int worldSize = 256;
    private final int[][][] blockData = new int[sampleSize][worldSize][sampleSize];
    private BlockPos playerPosition = new BlockPos(0, 0, 0);
    private World world;
    private PlayerEntity entity;

    public WNWorldCreateProgress(TrackingChunkStatusListener trackingProgress) {
        super(new StringTextComponent("World Loading Progress"));
        this.trackingProgress = trackingProgress;
    }

    public void removed() {
        NarratorChatListener.INSTANCE.say(I18n.format("narrator.loading.done"));
    }

    public void fill(int x1, int y1, int x2, int y2) {
        fill(x1, y1, x2, y2, -1072689136);
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    @Override
    protected void init() {
        this.centerWidth = this.width / 2;
        this.centerHeight = this.height / 2;

        int marginWidth = 20;
        int marginHeight = 20;
        int widthProportion = 16;
        int heightProportion = 9;

        int proportion = 0;
        if(width > height){
            for(int i = 0; i < height; i+=heightProportion){
                if(i > height - marginHeight * 2){
                    marginHeight = (height - i) / 2;
                    break;
                }
                proportion++;
            }
            marginWidth = (width - (widthProportion * proportion)) / 2;
        }else{
            for(int i = 0; i < width; i+=widthProportion){
                if(i > width - marginWidth * 2){
                    marginWidth = (width - i) / 2;
                    break;
                }
                proportion++;
            }
            marginHeight = (height - (heightProportion * proportion)) / 2;
        }

        screenX1 = marginWidth;
        screenX2 = width - marginWidth;
        screenY1 = marginHeight;
        screenY2 = height - marginHeight;
    }

    @Override
    public void tick() {
        if (world == null) {
            if (Minecraft.getInstance().world != null) {
                world = Minecraft.getInstance().world;
            } else if (Main.runningWorld != null) {
                world = Main.runningWorld;
            }
        }
        if (entity == null) {

        }
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        renderUIScreen();
        renderMapScreen();
    }

    private void renderUIScreen() {
        this.renderBackground();
        fill(screenX1, screenY1, screenX2, screenY2);
    }

    private void renderMapScreen() {

    }


}
