package com.matez.wildnature.event;

import com.matez.wildnature.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeySipkeEvent {

    public static int currentIndex = 0;
    public static int max = 3;


    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event){
        //Main.LOGGER.debug(event.getKey() + " a" + event.getAction());
        PlayerEntity p = Minecraft.getInstance().player;
        if(event.getKey()==39 && (event.getAction()==1) && p!=null && p.isCreative()) {
            Main.LOGGER.debug("Click");
            currentIndex++;
            if (currentIndex > max) {
                currentIndex = 0;
            }


            if (p != null && getPaint() != PaintType.NONE) {
                p.sendStatusMessage(new StringTextComponent(TextFormatting.GRAY + "You have choosen ").appendSibling(getPaint().translation).appendSibling(new StringTextComponent(TextFormatting.GRAY + " color.")), true);
            }

        }
    }

    public static PaintType getPaint(){
        if(currentIndex==0){
            return PaintType.LINSEED_OIL;
        }else if(currentIndex==1){
            return PaintType.SWEDISH_RED;
        }else if(currentIndex==2){
            return PaintType.MIDNIGHT_BLUE;
        }else if(currentIndex==3){
            return PaintType.MONUMENT_GREEN;
        }
        return PaintType.NONE;
    }

    public enum PaintType implements IStringSerializable {
        NONE("none",new StringTextComponent("")),
        LINSEED_OIL("linseed_oil",new StringTextComponent(TextFormatting.YELLOW+"Linseed Oil")),
        SWEDISH_RED("swedish_red",new StringTextComponent(TextFormatting.RED+"Swedish Red")),
        MIDNIGHT_BLUE("midnight_blue",new StringTextComponent(TextFormatting.DARK_AQUA+"Midnight Blue")),
        MONUMENT_GREEN("monument_green",new StringTextComponent(TextFormatting.DARK_GREEN+"Monument Green"));

        private final String name;
        private final StringTextComponent translation;

        private PaintType(String name,StringTextComponent translation) {
            this.name = name;
            this.translation=translation;
        }

        public String toString() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }
    }


}
