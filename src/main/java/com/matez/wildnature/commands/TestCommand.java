package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import com.matez.wildnature.event.PlayerEventHandler;
import com.matez.wildnature.other.Utilities;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

public class TestCommand {


    public int test(PlayerEntity entity, CommandContext<CommandSource> context){
        if(checkPlayer(entity)){
            try {
                //Minecraft.getInstance().getSoundHandler().play(SimpleSound.music(Main.getSoundByID("wildnature:ambient/denseforest_day_0")));

                StringTextComponent s2 = new StringTextComponent(TextFormatting.GREEN + "Execution successful!");
                Main.sendChatMessage(entity, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s2));
            }catch (Exception e){
                StringTextComponent s2 = new StringTextComponent(TextFormatting.RED + "Execution failed. " + e.getLocalizedMessage());
                Main.sendChatMessage(entity, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s2));
                System.out.println(e.getStackTrace());
            }
            return 1;
        }

        return 0;
    }

    private boolean checkPlayer(PlayerEntity entity){
        int x = 0;
        try{
            x = PlayerEventHandler.isPatron(entity).getType();
        }catch (NullPointerException e){
            x=-1;
        }
        if(x==1||x==2||x==3){
            StringTextComponent s2 = new StringTextComponent(TextFormatting.AQUA + "Running the dev command... ");
            Main.sendChatMessage(entity, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s2));
            return true;
        }else {
            StringTextComponent s2 = new StringTextComponent(TextFormatting.AQUA + "This is a developer command. It's useless for you :)");
            Main.sendChatMessage(entity, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s2));
            return false;
        }
    }

}
