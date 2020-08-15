package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import com.matez.wildnature.event.PlayerEventHandler;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.BlockPosArgument;
import net.minecraft.command.arguments.BlockStateArgument;
import net.minecraft.command.arguments.ItemArgument;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;

public class WNCommand {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("wn").then(Commands.literal("info").executes((context -> {
            return info(context);
        }))).then(Commands.literal("recipe").then(Commands.argument("item", ItemArgument.item()).then(Commands.argument("count",IntegerArgumentType.integer(1)).executes((context -> {
            ServerPlayerEntity player = context.getSource().asPlayer();
            return new RecipeCommand().recipe(player,new ItemStack(ItemArgument.getItem(context,"item").getItem(),IntegerArgumentType.getInteger(context,"count")));
        }))))).then(Commands.literal("biome").then(Commands.literal("locate").requires((perm) -> {
            return perm.hasPermissionLevel(2);
        }).then(Commands.argument("biome",new BiomeArgument()).executes((context -> {
            ServerPlayerEntity player = context.getSource().asPlayer();
            return BiomeArgument.findTeleportBiome(context.getSource(), player, BiomeArgument.getValue(context, "biome"));
        })))).then(Commands.literal("list").then(Commands.argument("page",IntegerArgumentType.integer(1)).executes((context -> {
            return new BiomeListCommand((PlayerEntity)context.getSource().getEntity()).showPage(IntegerArgumentType.getInteger(context,"page"));
        })))).then(Commands.literal("sub").then(Commands.argument("biome",new BiomeArgument()).then(Commands.argument("page",IntegerArgumentType.integer(1)).executes((context -> {
            return new BiomeListCommand((PlayerEntity)context.getSource().getEntity()).showPage(IntegerArgumentType.getInteger(context,"page"));
        })))))).then(Commands.literal("undergroundRiverBiome").then(Commands.literal("locate").requires((perm) -> {
            return perm.hasPermissionLevel(2);
        }).then(Commands.argument("biome",new CaveBiomeArgument()).executes((context -> {
            ServerPlayerEntity player = context.getSource().asPlayer();
            return CaveBiomeArgument.findTeleportURBiome(context.getSource(), player, CaveBiomeArgument.getValue(context, "biome"));
        })))).then(Commands.literal("list").then(Commands.argument("page",IntegerArgumentType.integer(1)).executes((context -> {
            return new CaveBiomeListCommand((PlayerEntity)context.getSource().getEntity()).showPage(IntegerArgumentType.getInteger(context,"page"));
        }))).executes(context -> {
            return new BiomeListCommand((PlayerEntity)context.getSource().getEntity()).showPage(1);
        }))).then(Commands.literal("path").then(Commands.literal("locate").requires((perm) -> {
            return perm.hasPermissionLevel(2);
        }).executes(context -> {
            return LocatePath.findTeleportBiome(context.getSource(),context.getSource().asPlayer());
        }))).then(Commands.literal("randomTp").then(Commands.argument("max radius",IntegerArgumentType.integer(1)).requires((perm)->{
            return perm.hasPermissionLevel(2);
        }).executes(context -> {
            return RandomTeleportCommand.rtp(context.getSource(),context.getSource().asPlayer(),IntegerArgumentType.getInteger(context,"max radius"));
        })))
                .then(Commands.literal("dev").requires((perm) -> {
                    return perm.hasPermissionLevel(2);
                })
                        .then(Commands.literal("export")
                                .then(Commands.argument("pos1",BlockPosArgument.blockPos())
                                        .then(Commands.argument("pos2",BlockPosArgument.blockPos())
                                                .then(Commands.argument("centerToBlock", BlockStateArgument.blockState())
                                                        .then(Commands.argument("name", StringArgumentType.string())
                                                                .then(Commands.argument("fullJava", BoolArgumentType.bool())
                                                                        .executes((context -> {
            return new ExportToFile().export(context, new MutableBoundingBox(BlockPosArgument.getLoadedBlockPos(context, "pos1"), BlockPosArgument.getLoadedBlockPos(context, "pos2")),StringArgumentType.getString(context,"name"),BlockStateArgument.getBlockState(context,"centerToBlock"),BoolArgumentType.getBool(context,"fullJava"),false);
        }))))))).then(Commands.argument("pos1",BlockPosArgument.blockPos())
                                        .then(Commands.argument("pos2",BlockPosArgument.blockPos())
                                                .then(Commands.argument("centerToBlock", BlockStateArgument.blockState())
                                                        .then(Commands.argument("name", StringArgumentType.string())
                                                                .then(Commands.argument("fullJava", BoolArgumentType.bool())
                                                                        .then(Commands.argument("saveTileEntities", BoolArgumentType.bool())
                                                                        .executes((context -> {
                                                                            return new ExportToFile().export(context, new MutableBoundingBox(BlockPosArgument.getLoadedBlockPos(context, "pos1"), BlockPosArgument.getLoadedBlockPos(context, "pos2")),StringArgumentType.getString(context,"name"),BlockStateArgument.getBlockState(context,"centerToBlock"),BoolArgumentType.getBool(context,"fullJava"),BoolArgumentType.getBool(context,"saveTileEntities"));
                                                                        }))))))))).then(Commands.literal("test").requires((perm) -> {
                            return perm.hasPermissionLevel(2);

                        }).executes((context -> {
                            ServerPlayerEntity player = context.getSource().asPlayer();
                            return new TestCommand().test(player,context);
                        }))).then(Commands.literal("craft").executes((context -> {
                            return new CraftingCreator().craft(context);
                        })))
                        .then(Commands.literal("import")
                                .then(Commands.argument("file",StringArgumentType.string())
                                        .then(Commands.argument("coords",BlockPosArgument.blockPos())
                                                .executes((context -> {
                                                    return new ImportFromFile().iimport(context,StringArgumentType.getString(context,"file"),BlockPosArgument.getBlockPos(context,"coords"));
                                                })))))
                        .then(Commands.literal("files").then(Commands.argument("page",IntegerArgumentType.integer(1)).executes((context -> {
                            return new GetFiles((PlayerEntity)context.getSource().getEntity()).showPage(IntegerArgumentType.getInteger(context,"page"));
                        }))))));
    }



    private static int info(CommandContext<CommandSource> context){
        boolean console = false;
        PlayerEntity entity = null;
        try {
            entity=context.getSource().asPlayer();
        } catch (CommandSyntaxException e) {
            console=true;
        }

        ITextComponent s = infoComponent(entity,console);

        if(console){
            System.out.println(s.getUnformattedComponentText());
        }else{
            Main.sendChatMessage(entity,s);
        }



        return 1;
    }

    public static ITextComponent infoComponent(PlayerEntity entity, boolean console){
        StringTextComponent s1 = new StringTextComponent(TextFormatting.GOLD+""+TextFormatting.BOLD+TextFormatting.STRIKETHROUGH+"------------" +TextFormatting.GREEN+" WildNature "+ TextFormatting.GOLD+""+TextFormatting.BOLD+TextFormatting.STRIKETHROUGH+"------------\n");
        StringTextComponent s2 = new StringTextComponent(TextFormatting.AQUA+""+TextFormatting.BOLD+"-> "+TextFormatting.YELLOW+"Version: " + TextFormatting.LIGHT_PURPLE+Main.version+"\n");
        String generator = "";
        String patron = "";
        String language = "";
        if(console){
            generator= TextFormatting.DARK_PURPLE+"unknown";
            patron= TextFormatting.DARK_PURPLE+"unknown";
        }else{
            generator= TextFormatting.LIGHT_PURPLE+entity.getEntityWorld().getWorldType().getClass().getSimpleName();
            patron = TextFormatting.LIGHT_PURPLE+""+(PlayerEventHandler.isPatron(entity)!=null)+"";
            if(patron.contains("false")){
                patron = TextFormatting.LIGHT_PURPLE+"Become a Patron! Click.";
            }
            if(Main.instance.getSupportedLanguages().contains(Minecraft.getInstance().getLanguageManager().getCurrentLanguage().getCode())){
                if(Minecraft.getInstance().getLanguageManager().getCurrentLanguage().getCode().equals("en_us")){
                    language = TextFormatting.LIGHT_PURPLE + "default";
                }else {
                    language = TextFormatting.LIGHT_PURPLE + Minecraft.getInstance().getLanguageManager().getCurrentLanguage().getCode() + TextFormatting.DARK_PURPLE + " by " + TextFormatting.LIGHT_PURPLE + new TranslationTextComponent("lang.credits").getFormattedText();
                }
            }else{
                language = TextFormatting.DARK_PURPLE+"Not supported. [HOVER FOR INFO]";
            }
        }
        StringTextComponent s3 = new StringTextComponent(TextFormatting.AQUA+""+TextFormatting.BOLD+"-> "+TextFormatting.YELLOW+"Generator: " + generator+"\n");
        StringTextComponent s4 = new StringTextComponent(TextFormatting.AQUA+""+TextFormatting.BOLD+"-> "+TextFormatting.YELLOW+"Patron: " + patron+"\n");
        StringTextComponent s5 = new StringTextComponent(TextFormatting.AQUA+""+TextFormatting.BOLD+"-> "+TextFormatting.YELLOW+"Language: " + language+"\n");
        StringTextComponent s6 = new StringTextComponent(TextFormatting.AQUA+""+TextFormatting.BOLD+"-> "+TextFormatting.GREEN+"Official Page & wiki: " + TextFormatting.AQUA+"www.wildnaturemod.com"+"\n");
        StringTextComponent s7 = new StringTextComponent(TextFormatting.AQUA+""+TextFormatting.BOLD+"-> "+TextFormatting.YELLOW+"CurseForge: " + TextFormatting.DARK_AQUA+"bit.ly/wildnature-mod"+"\n");
        StringTextComponent s8 = new StringTextComponent(TextFormatting.AQUA+""+TextFormatting.BOLD+"-> "+TextFormatting.YELLOW+"Discord: " + TextFormatting.DARK_AQUA+"bit.ly/wildnature-discord"+"\n");
        StringTextComponent s9 = new StringTextComponent(TextFormatting.AQUA+""+TextFormatting.BOLD+"-> "+TextFormatting.YELLOW+"GitHub: " + TextFormatting.DARK_AQUA+"github.com/zmatez/wildnature"+"\n");
        StringTextComponent s10 = new StringTextComponent(TextFormatting.AQUA+""+TextFormatting.BOLD+"-> "+TextFormatting.YELLOW+"Patreon: " + TextFormatting.DARK_AQUA+"patreon.com/wildnature"+TextFormatting.LIGHT_PURPLE+"  [capes]"+"\n");
        StringTextComponent s11 = new StringTextComponent(TextFormatting.GOLD+""+TextFormatting.BOLD+TextFormatting.STRIKETHROUGH+"---------------------------------");


        //s1.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,"bit.ly/wildnature-mod"));
        s4.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,"https://patreon.com/matez"));
        s5.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new StringTextComponent(TextFormatting.DARK_AQUA+"If you want to create own language file, visit our GitHub,\ndownload english language file, translate it and open\nnew thread with completed translations.")));
        HoverEvent click = new HoverEvent(HoverEvent.Action.SHOW_TEXT,new StringTextComponent(TextFormatting.GREEN+"Click to open"));
        s6.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,"https://wildnaturemod.com"));
        s6.getStyle().setHoverEvent(click);
        s7.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,"http://bit.ly/wildnature-mod"));
        s7.getStyle().setHoverEvent(click);
        s8.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,"http://bit.ly/wildnature-discord"));
        s8.getStyle().setHoverEvent(click);
        s9.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,"http://bit.ly/wildnature-github"));
        s9.getStyle().setHoverEvent(click);
        s10.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,"https://wildnaturemod.com/donate/"));
        s10.getStyle().setHoverEvent(click);

        return new StringTextComponent("").appendSibling(s1).appendSibling(s2).appendSibling(s3).appendSibling(s4).appendSibling(s5).appendSibling(s6).appendSibling(s7).appendSibling(s8).appendSibling(s9).appendSibling(s10).appendSibling(s11);

    }

}
