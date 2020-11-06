package com.matez.wildnature.client.gui.screen.world;


import com.matez.wildnature.client.gui.screen.ScreenUtils;
import com.matez.wildnature.init.WN;
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

        int[] proportionalSize = ScreenUtils.getByResolution(width,height,20,20,16,9);

        screenX1 = proportionalSize[0];
        screenX2 = proportionalSize[2];
        screenY1 = proportionalSize[1];
        screenY2 = proportionalSize[3];

    }

    @Override
    public void tick() {
        if (world == null) {
            if (Minecraft.getInstance().world != null) {
                world = Minecraft.getInstance().world;
            } else if (WN.runningWorld != null) {
                world = WN.runningWorld;
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
