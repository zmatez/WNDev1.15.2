package com.matez.wildnature.client.gui.screen.world.settings.widgets;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.gui.GuiUtils;

public class ExtendedSettingButton extends SettingButton {
    public ExtendedSettingButton(int baseX, int baseY, int width, int height, String text, SettingButton.IPressable onPress) {
        super(baseX, baseY, width, height, text, onPress);
    }

    @Override
    public void renderButton(int mouseX, int mouseY, float partial) {
        if (this.visible) {
            Minecraft mc = Minecraft.getInstance();
            this.isHovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            int k = this.getYImage(this.isHovered);
            GuiUtils.drawContinuousTexturedBox(WIDGETS_LOCATION, this.x, this.y, 0, 46 + k * 20, this.width, this.height, 200, 20, 2, 3, 2, 2, this.getBlitOffset());
            this.renderBg(mc, mouseX, mouseY);

            String buttonText = this.getMessage();
            int strWidth = mc.fontRenderer.getStringWidth(buttonText);
            int ellipsisWidth = mc.fontRenderer.getStringWidth("...");

            if (strWidth > width - 6 && strWidth > ellipsisWidth)
                buttonText = mc.fontRenderer.trimStringToWidth(buttonText, width - 6 - ellipsisWidth).trim() + "...";

            this.drawCenteredString(mc.fontRenderer, buttonText, this.x + this.width / 2, this.y + (this.height - 8) / 2, getFGColor());
        }
    }


}
