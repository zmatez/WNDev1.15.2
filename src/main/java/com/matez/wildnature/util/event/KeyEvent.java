package com.matez.wildnature.util.event;

import com.matez.wildnature.init.WN;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeyEvent {

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event){
        if(event.getKey()==340 && (event.getAction()==2 || event.getAction()==1)){
            WN.canShowAdvancedTooltip=true;
        }else{
            WN.canShowAdvancedTooltip=false;
        }
    }
}
