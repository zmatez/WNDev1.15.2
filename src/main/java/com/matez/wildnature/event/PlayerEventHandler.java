package com.matez.wildnature.event;

import com.google.gson.*;
import com.matez.wildnature.other.Patron;
import com.matez.wildnature.proxy.ClientProxy;
import com.matez.wildnature.world.gen.provider.WNWorldType;
import com.matez.wildnature.Main;
import com.matez.wildnature.commands.WNCommand;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.other.Motd;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.text.SimpleDateFormat;
import java.util.*;

public class PlayerEventHandler {
    public static HashMap<String, Boolean> playersCape = new HashMap();
    public static ArrayList<PlayerEntity> gotMessageAboutYourself = new ArrayList<>();
    public static ArrayList<PlayerEntity> gotMessageAboutYourself2 = new ArrayList<>();
    public static ArrayList<PlayerEntity> gotMessageAboutYourself3 = new ArrayList<>();
    public static boolean patron;

    public PlayerEventHandler() {
    }

    @SubscribeEvent
    public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        new Thread(new Runnable() {
            public void run() {
                joined(event);
            }
        }).start();

    }

    private void joined(PlayerEvent.PlayerLoggedInEvent event){
        boolean showInfo = false;
        boolean canSend = false;
        if (event.getEntity() instanceof PlayerEntity && CommonConfig.messageOnJoin.get()) {
            canSend=true;
            if(!gotMessageAboutYourself.contains(event.getPlayer())) {
                gotMessageAboutYourself.add(event.getPlayer());
                StringTextComponent s = null;
                if(!event.getPlayer().getEntityWorld().isRemote) {
                    StringTextComponent sg = null;
                    if (event.getEntity().getEntityWorld().getWorldType().getClass() == WNWorldType.class) {
                        s = new StringTextComponent(TextFormatting.AQUA + "Using " + TextFormatting.YELLOW + "WildNature World Generator" + TextFormatting.AQUA + ". Version " + TextFormatting.YELLOW + Main.version + TextFormatting.AQUA + ".");
                        s.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.DARK_AQUA + "WildNature World Generator" + TextFormatting.GRAY + " is needed to generate really smooth world.\nWithout it, sub-biomes wouldn't generate.")));
                        s.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://wildnaturemod.com"));
                    } else {
                        s = new StringTextComponent(TextFormatting.RED + "Using WildNature " + TextFormatting.YELLOW + Main.version + TextFormatting.RED + " without " + TextFormatting.YELLOW + "WildNature World Generator" + TextFormatting.RED + ".");
                        s.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.DARK_RED + "WildNature World Generator" + TextFormatting.GRAY + " is needed to generate really smooth world.\nWithout it, sub-biomes wouldn't generate.")));
                        s.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://wildnaturemod.com"));
                    }


                    showInfo=true;

                    Main.sendChatMessage((PlayerEntity) event.getEntity(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s));
                    if(sg!=null){
                        Main.sendChatMessage((PlayerEntity) event.getEntity(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sg));
                    }
                }

            }

        }

        if(!gotMessageAboutYourself2.contains(event.getPlayer())) {
            gotMessageAboutYourself2.add(event.getPlayer());
            Patron patron = isPatron((PlayerEntity) event.getEntity());
            if (patron != null) {
                if (isServer(event.getEntity())) {
                    Main.LOGGER.info("Running on server");
                }
                if (patron.getType() == 4) {
                    this.patron = true;
                    if (isServer(event.getEntity())) {
                        StringTextComponent s2 = new StringTextComponent(TextFormatting.AQUA + "Joined " + TextFormatting.GREEN + "" + ((PlayerEntity) (event.getEntity())).getDisplayName().getString() + TextFormatting.AQUA + ", the WildNature patron. Hi!");
                        s2.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GREEN + "" + ((PlayerEntity) (event.getEntity())).getDisplayName().getString() + TextFormatting.DARK_AQUA + " is supporting " + TextFormatting.GREEN + "WildNature mod" + TextFormatting.DARK_AQUA + ".\nThanks to it, this mod is getting to be better." + TextFormatting.DARK_PURPLE + "\nClick to open.")));
                        s2.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://bit.ly/matez-patreon"));
                        Main.sendServerChatMessage(event.getEntity().getServer(), (PlayerEntity) event.getEntity(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s2));
                    }
                    StringTextComponent s2 = new StringTextComponent(TextFormatting.AQUA + "Hello, " + TextFormatting.GREEN + "" + ((PlayerEntity) (event.getEntity())).getDisplayName().getString() + TextFormatting.AQUA + ", the WildNature patron.");
                    s2.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GREEN + "" + ((PlayerEntity) (event.getEntity())).getDisplayName().getString() + TextFormatting.DARK_AQUA + " is supporting " + TextFormatting.GREEN + "WildNature mod" + TextFormatting.DARK_AQUA + ".\nThanks to it, this mod is getting to be better." + TextFormatting.DARK_PURPLE + "\nClick to open.")));
                    s2.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://bit.ly/matez-patreon"));
                    Main.sendChatMessage((PlayerEntity) event.getEntity(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s2));

                } else {
                    String textClient = "";//$PLAYER$ = player
                    String textServer = "";//$PLAYER$ = player
                    String hoverClient = "";//$PLAYER$ = player
                    String hoverServer = "";//$PLAYER$ = player

                    if (patron.getType() == 1) {
                        textClient = TextFormatting.AQUA + "Hello, " + TextFormatting.RED + "$PLAYER$" + TextFormatting.AQUA + ", the WildNature main developer.";
                        textServer = TextFormatting.AQUA + "Joined " + TextFormatting.RED + "$PLAYER$" + TextFormatting.AQUA + ", the WildNature main developer.";
                        hoverClient = TextFormatting.RED + "$PLAYER$" + TextFormatting.DARK_AQUA + " is the WildNature main developer.";
                        hoverServer = hoverClient;
                    } else if (patron.getType() == 2) {
                        textClient = TextFormatting.AQUA + "Hello, " + TextFormatting.GOLD + "$PLAYER$" + TextFormatting.AQUA + ", the WildNature developer.";
                        textServer = TextFormatting.AQUA + "Joined " + TextFormatting.GOLD + "$PLAYER$" + TextFormatting.AQUA + ", the WildNature developer.";
                        hoverClient = TextFormatting.GOLD + "$PLAYER$" + TextFormatting.DARK_AQUA + " is the WildNature developer.";
                        hoverServer = hoverClient;
                    } else if (patron.getType() == 3) {
                        textClient = TextFormatting.AQUA + "Hello, " + TextFormatting.LIGHT_PURPLE + "$PLAYER$" + TextFormatting.AQUA + ", I see you're developing something!";
                        textServer = TextFormatting.AQUA + "Joined " + TextFormatting.LIGHT_PURPLE + "$PLAYER$" + TextFormatting.AQUA + ", guy that is developing something with WildNature mod installed.";
                        hoverClient = TextFormatting.LIGHT_PURPLE + "$PLAYER$" + TextFormatting.DARK_AQUA + " is running Minecraft from the IDE.";
                        hoverServer = hoverClient;
                    }

                    textClient = textClient.replace("$PLAYER$", ((PlayerEntity) (event.getEntity())).getDisplayName().getString()) + TextFormatting.AQUA;
                    textServer = textServer.replace("$PLAYER$", ((PlayerEntity) (event.getEntity())).getDisplayName().getString()) + TextFormatting.AQUA;
                    hoverClient = hoverClient.replace("$PLAYER$", ((PlayerEntity) (event.getEntity())).getDisplayName().getString()) + TextFormatting.AQUA;
                    hoverServer = hoverServer.replace("$PLAYER$", ((PlayerEntity) (event.getEntity())).getDisplayName().getString()) + TextFormatting.AQUA;
                    if (isServer(event.getEntity())) {
                        StringTextComponent s2 = new StringTextComponent(textServer);
                        s2.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(hoverServer)));
                        s2.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://wildnaturemod.com"));
                        Main.sendServerChatMessage(event.getEntity().getServer(), (PlayerEntity) event.getEntity(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s2));
                    }
                    StringTextComponent s2 = new StringTextComponent(textClient);
                    s2.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(hoverClient)));
                    s2.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://wildnaturemod.com"));
                    Main.sendChatMessage((PlayerEntity) event.getEntity(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s2));


                }
            }



            if(!gotMessageAboutYourself3.contains(event.getPlayer()) && canSend) {
                gotMessageAboutYourself3.add(event.getPlayer());
                Motd motd = readMOTD(event.getPlayer());
                if(motd==null){
                    Main.LOGGER.warn("WildNature MOTD Unavailable");
                }else {
                    ITextComponent comp = null;
                    try {
                        comp = TextComponentUtils.updateForEntity(null, ITextComponent.Serializer.fromJson(motd.getText()), event.getPlayer(), 0);
                        ITextComponent t = null;
                        if (motd.getPrefix()) {
                            t = new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(comp);
                        } else {
                            t = new StringTextComponent("").appendSibling(comp);
                        }
                        if (t != null) {
                            Main.LOGGER.info("Sent WN MOTD");
                            Main.sendChatMessage((PlayerEntity) event.getEntity(), t);
                            try {
                                if (CommonConfig.effectOnJoin.get()) {
                                    Minecraft.getInstance().getIntegratedServer().getCommandManager().handleCommand(event.getPlayer().getCommandSource().withPermissionLevel(2), motd.getCommand());
                                }
                            } catch (Exception e) {
                                Main.LOGGER.warn("Cannot show MOTD");
                            }
                        }
                    } catch (Exception e) {
                        Main.LOGGER.warn("Cannot show MOTD");
                    }
                }

            }

            if(showInfo){
                if(Main.loadedNewVersion) {
                    StringTextComponent sx = new StringTextComponent(TextFormatting.GREEN+ "Loaded new WildNature version" + TextFormatting.GRAY+" - " + TextFormatting.GOLD+ Main.version);
                    Main.sendChatMessage((PlayerEntity)event.getEntity(),new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sx));
                    Main.sendChatMessage((PlayerEntity) event.getEntity(), WNCommand.infoComponent(event.getPlayer(), false));
                    StringTextComponent sd = new StringTextComponent(TextFormatting.AQUA+"Want a modded server? Visit server.pro!" + TextFormatting.GREEN + " Click here");
                    sd.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GREEN+"Click to open"+TextFormatting.DARK_AQUA+"\nPowerful game server hosting for serious gamers.\nFTP access, fully customizable, responsive control panel, free plan. \nUp and running in 55 seconds.")));
                    sd.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://bit.ly/wildnature-server-pro"));
                    Main.sendChatMessage((PlayerEntity) event.getEntity(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sd));
                }
            }

        }

    }

    @SubscribeEvent
    public void onPlayerExit(PlayerEvent.PlayerLoggedOutEvent event){
        gotMessageAboutYourself.remove(event.getPlayer());
        gotMessageAboutYourself2.remove(event.getPlayer());
        gotMessageAboutYourself3.remove(event.getPlayer());
    }

    public static boolean isServer(Entity entity){
        //Main.LOGGER.info("---------------------------------------- CHECKING SERVER -----------------------------------------------");
        return entity.getEntityWorld().getServer()!=null;
    }

    public static Patron isPatron(PlayerEntity entity){
        ArrayList<Patron> patrons = readPatrons();
        if(patrons==null){
            Main.LOGGER.warn("WildNature Patrons Unavailable");
        }else {
            for (int i = 0; i < patrons.size(); i++) {
                if (PlayerEntity.getUUID(entity.getGameProfile()).toString().equals(patrons.get(i).getUuid())) {
                    int type = patrons.get(i).getType();
                    if (type == 4) {
                        Main.LOGGER.info(TextFormatting.GOLD + entity.getDisplayName().getString() + "" + TextFormatting.AQUA + " is a WildNature patron.");
                    } else if (type == 1 || type == 2) {
                        Main.LOGGER.info(TextFormatting.RED + entity.getDisplayName().getString() + "" + TextFormatting.AQUA + " is a WildNature developer.");
                    }
                    return patrons.get(i);
                }
            }
        }
        return null;
    }

    public static ArrayList<Patron> readPatrons(){
        String s = Main.readFromURL("https://wildnaturemod.com/data/wildnature-uuids.json");
        if(s==null){
            return null;
        }

        return parsePatrons(s);
    }

    public static Motd readMOTD(PlayerEntity entity){
        String s = Main.readFromURL("https://wildnaturemod.com/data/wildnature-motd.json");
        if(s==null){
            return null;
        }

        return parseMOTD(s,entity);
    }

    public static Motd parseMOTD(String json, PlayerEntity entity) {
        Gson gson = new Gson();
        Motd motd = gson.fromJson(json,Motd.class);
        if(motd==null){
            return null;
        }
        //Main.LOGGER.info("motd " + motd.getText() + " " + motd.getDate());
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        String currdate = formatter.format(date);
        if(motd.getDate().isEmpty() || currdate.equals(motd.getDate())){
            if(motd.getType()==-1 || (isPatron(entity)!=null && isPatron(entity).getType()==motd.getType())){
                return motd;
            }
            Main.LOGGER.info("Patron type isn't like that");
        }else {
            Main.LOGGER.info("Motd isn't today");
        }
        return null;
    }

    private static ArrayList<Patron> parsePatrons(String json){
        Gson gson = new Gson();
        Patron[] array = gson.fromJson(json, Patron[].class);
        //Main.LOGGER.info("PATRONS: " + Arrays.asList(array));
        return new ArrayList<>(Arrays.asList(array));
    }

    private static Boolean hasCape(String uuid) {
        Boolean hashMapResult = (Boolean)playersCape.get(uuid);
        return hashMapResult == null ? false : hashMapResult;
    }


    public static ResourceLocation getCapeResourceLocation(AbstractClientPlayerEntity acpe) {
        String playerUUID = acpe.getUniqueID().toString().replace("-", "");
        ResourceLocation resourceLocation = new ResourceLocation("wildnature", "capes/" + playerUUID);
        return hasCape(playerUUID) ? resourceLocation : null;
    }



}