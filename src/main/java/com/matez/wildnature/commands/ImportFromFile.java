package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.block.BlockState;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.BlockStateInput;
import net.minecraft.command.arguments.BlockStateParser;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportFromFile {

    private int brokenParts = 0;
    public ImportFromFile(){}

    public int iimport(CommandContext<CommandSource> source, String file, BlockPos coords) throws CommandSyntaxException {
        ServerWorld world = source.getSource().getWorld();
        brokenParts = 0;
        String name = file;
        if(!file.contains(".")){
            name=name+".java";
        }
        StringTextComponent s3 = new StringTextComponent(TextFormatting.AQUA + "Importing "+ TextFormatting.GOLD + name+ TextFormatting.AQUA+"...");
        Main.sendChatMessage(source.getSource().asPlayer(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s3));

        ArrayList<BlockStatePos> list = new ArrayList<>();
        File f = new File(FMLPaths.GAMEDIR.get().resolve("wildnature/export/"+name).toString());
        if(!f.exists()){
            StringTextComponent s4 = new StringTextComponent(TextFormatting.RED + "Unable to find " +TextFormatting.GOLD + name+  TextFormatting.RED+".");
            Main.sendChatMessage(source.getSource().asPlayer(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s4));
            return 0;
        }

        try {
            Scanner s = new Scanner(f);
            while(s.hasNextLine()){
                String line = s.nextLine();
                String linex = line;
                if(line.contains("Block(")){
                    try {
                        String x = linex.substring(linex.indexOf("(") + 1, linex.indexOf(","));
                        linex = linex.replaceFirst(x + ",", "");
                        String y = linex.substring(linex.indexOf("(") + 1, linex.indexOf(","));
                        linex = linex.replaceFirst(y + ",", "");
                        String z = linex.substring(linex.indexOf("(") + 1, linex.indexOf(","));
                        linex = linex.replaceFirst(z + ",", "");
                        String blockstate = linex.substring(linex.indexOf("(") + 1, linex.indexOf(")"));
                        //System.out.println("x = " + x + "   y = " + y + "   z = " + z + "   blockstate = " + blockstate);
                        blockstate = blockstate.substring(1,blockstate.length()-1).replace("\\","");
                        Main.LOGGER.info("Block: " + blockstate);
                        list.add(new BlockStatePos(parse(new StringReader(blockstate)), new BlockPos(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z))));
                    }catch (Exception e){
                        brokenParts++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            brokenParts++;
        }

        if(list.isEmpty()){
            StringTextComponent s4 = new StringTextComponent(TextFormatting.RED + "Unable to decode file.");
            Main.sendChatMessage(source.getSource().asPlayer(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s4));
            return 0;
        }

        if(brokenParts>0){
            StringTextComponent s4 = new StringTextComponent(TextFormatting.RED + "Found " + TextFormatting.GOLD + brokenParts + TextFormatting.RED +" broken parts in this file.");
            Main.sendChatMessage(source.getSource().asPlayer(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s4));
        }

        StringTextComponent s6 = new StringTextComponent(TextFormatting.AQUA + "Generating "+ TextFormatting.GOLD + list.size()+ TextFormatting.AQUA+" blocks at ");
        StringTextComponent s7 = new StringTextComponent(TextFormatting.YELLOW + ""+coords.getX()+" " + coords.getY() + " " + coords.getZ());
        Main.sendChatMessage(source.getSource().asPlayer(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s6).appendSibling(s7));

        for (BlockStatePos statePos : list){
            try {
                BlockPos pos = new BlockPos(coords.getX() + statePos.getPos().getX(), coords.getY() + statePos.getPos().getY(), coords.getZ() + statePos.getPos().getZ());
                statePos.getState().place(world, pos, 2);
            }catch (Exception e){
                Main.LOGGER.warn(e);
            }
        }

        StringTextComponent s4 = new StringTextComponent(TextFormatting.GREEN + "Operation succeed.");
        Main.sendChatMessage(source.getSource().asPlayer(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s4));

        return 1;


    }

    public BlockStateInput parse(StringReader p_parse_1_) {
        try {
            BlockStateParser blockstateparser = (new BlockStateParser(p_parse_1_, true)).parse(true);
            return new BlockStateInput(blockstateparser.getState(), blockstateparser.getProperties().keySet(), blockstateparser.getNbt());
        }catch (Exception e){
            brokenParts++;
            return null;
        }
    }

    private static class BlockStatePos{
        private BlockStateInput state;
        private BlockPos pos;
        public BlockStatePos(BlockStateInput state, BlockPos pos){
            this.state=state;
            this.pos=pos;
        }

        public BlockStateInput getState() {
            return state;
        }

        public BlockPos getPos() {
            return pos;
        }

        public void setPos(BlockPos pos) {
            this.pos = pos;
        }

        public void setState(BlockStateInput state) {
            this.state = state;
        }
    }
}
