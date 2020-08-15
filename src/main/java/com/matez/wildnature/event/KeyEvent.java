package com.matez.wildnature.event;

import com.matez.wildnature.Main;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeyEvent {

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event){
        if(event.getKey()==340 && (event.getAction()==2 || event.getAction()==1)){
            Main.canShowAdvancedTooltip=true;
        }else{
            Main.canShowAdvancedTooltip=false;
        }
    }
}
