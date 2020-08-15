package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
import net.minecraft.client.resources.I18n;
import net.minecraft.command.CommandSource;
import net.minecraft.command.impl.TeleportCommand;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;

public class RandomTeleportCommand {

    public static int rtp(CommandSource cs, ServerPlayerEntity entity, int max){
        BlockPos oldPos = entity.getPosition();
        BlockPos pos = null;
        int maxLoop = 1000;
        int i =0;
        while(maxLoop>i){
            int distanceX = Utilities.rint(-max/2,max/2);
            int distanceZ = Utilities.rint(-max/2,max/2);
            BlockPos p = new BlockPos(entity.getPosition().getX()+distanceX,entity.getPosition().getY(),entity.getPosition().getZ()+distanceZ);
            if(Utilities.getDistance(p,entity.getPosition())<=max){
                pos=p;
                break;
            }else{
                i++;
            }
        }
        if(pos!=null) {
            BlockPos tp = BiomeArgument.getTopBlock(entity.getEntityWorld(), pos.getX(), pos.getZ());
            StringTextComponent s = new StringTextComponent(TextFormatting.AQUA + "Teleporting to " + TextFormatting.YELLOW + pos.getX() + " " + pos.getY() + " " + pos.getZ() + TextFormatting.AQUA + " - " + TextFormatting.GOLD + (int) Utilities.getDistance(entity.getPosition(), tp) + TextFormatting.AQUA + " blocks away.");
            Main.sendChatMessage(entity, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s));
            entity.teleport(entity.getServerWorld(), pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, entity.getPitchYaw().x, entity.getPitchYaw().y);
            StringTextComponent s2 = new StringTextComponent(TextFormatting.GREEN + "Teleported. Click here to ");
            StringTextComponent stp = new StringTextComponent(TextFormatting.AQUA + "go back");
            stp.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GREEN + "Click here to back to " + TextFormatting.GOLD + oldPos.getX() + " " + oldPos.getY() + " " + oldPos.getZ())));
            stp.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + entity.getName().getString() + " " + oldPos.getX() + " " + oldPos.getY() + " " + oldPos.getZ()));
            Main.sendChatMessage(entity, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s2.appendSibling(stp)));

            return 1;
        }else{
            StringTextComponent s = new StringTextComponent(TextFormatting.RED + "Unable to random teleport. Try again");
            Main.sendChatMessage(entity,new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s));

            return 0;
        }
    }
}
