package com.matez.wildnature.client.gui.screen.world.settings.widgets;

import net.minecraft.client.gui.widget.Widget;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SettingWidget extends Widget {
    public int baseX;
    public int baseY;
    public SettingWidget(int baseX, int baseY, String msg) {
        super(0, 0, msg);
        this.baseX = baseX;
        this.baseY = baseY;
        setPosition(0,0);
    }

    public SettingWidget(int baseX, int baseY, int widthIn, int heightIn, String msg) {
        super(0, 0, widthIn, heightIn, msg);
        this.baseX = baseX;
        this.baseY = baseY;
        setPosition(0,0);
    }

    public void setPosition(int x, int y){
        this.x = baseX + x;
        this.y = baseY + y;
    }
}
