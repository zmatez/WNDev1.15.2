package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.BlockStateInput;
import net.minecraft.command.arguments.BlockStateParser;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ExportToFile {
    public ExportToFile(){}

    public int export(CommandContext<CommandSource> source, MutableBoundingBox area, String name, BlockStateInput centerTo, boolean fullJava, boolean tileEntitySave) throws CommandSyntaxException {


        ArrayList<BlockPos> list = new ArrayList<>();
        ServerWorld serverworld = source.getSource().getWorld();
        BlockPos centerBlockPos = null;
        for(BlockPos blockpos : BlockPos.getAllInBoxMutable(area.minX, area.minY, area.minZ, area.maxX, area.maxY, area.maxZ)) {
            if(serverworld.getBlockState(blockpos).getBlock()== Blocks.AIR){

            }else {
                list.add(blockpos.toImmutable());
            }
        }
        StringTextComponent s3 = new StringTextComponent(TextFormatting.AQUA + "Exporting " + TextFormatting.GOLD + list.size() + TextFormatting.AQUA +" blocks to "+ TextFormatting.GOLD + name+".java"+ TextFormatting.AQUA+"...");
        Main.sendChatMessage(source.getSource().asPlayer(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s3));

        boolean invalid = false;
        for(BlockPos blockpos1 : list) {
            if(serverworld.getBlockState(blockpos1)==centerTo.getState()){
                if(centerBlockPos!=null){
                    invalid=true;
                    break;
                }else{
                    centerBlockPos=blockpos1;
                }
            }
        }
        if(invalid){
            StringTextComponent s4 = new StringTextComponent(TextFormatting.RED + "Cannot export " +TextFormatting.GOLD + name+".java"+ TextFormatting.RED+" - " + "There are more than one " +TextFormatting.GOLD +centerTo.getState().getBlock().getRegistryName() + TextFormatting.RED+".");
            Main.sendChatMessage(source.getSource().asPlayer(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s4));
            return 0;
        }

        if(centerBlockPos==null){
            StringTextComponent s4 = new StringTextComponent(TextFormatting.RED + "Cannot export " +TextFormatting.GOLD + name+".java"+ TextFormatting.RED+" - " + "Cannot find " +TextFormatting.GOLD +centerTo.getState().getBlock().getRegistryName() + TextFormatting.RED+".");
            Main.sendChatMessage(source.getSource().asPlayer(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s4));
            return 0;
        }
        String start = "";
        String export = "";
        String signature = "\n\n//   wildnature mod\n" +
                "//           created by matez \n" +
                "//         all rights reserved   \n" +
                "//     https://wildnaturemod.com\n";
        String end = "";

        if(fullJava){
            start=(
                    "import com.matez.wildnature.Main;\n" +
                    "import com.matez.wildnature.world.gen.structures.nature.SchemFeature;\n" +
                    "import com.mojang.datafixers.Dynamic;\n" +
                    "import net.minecraft.util.math.BlockPos;\n" +
                    "import net.minecraft.block.BlockState;\n" +
                    "import net.minecraft.world.gen.feature.NoFeatureConfig;\n" +
                    "\n" +
                    "import java.util.Set;\n" +
                    "import java.util.function.Function;\n" +
                    "\n" +
                    "public class %s% extends SchemFeature {\n" +
                    "    public %s%(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace) {\n" +
                    "        super(config, doBlockNofityOnPlace);\n" +
                    "        Main.treesList.add(this);\n" +
                    "    }\n" +
                    "\n" +
                    "    public %s%(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace, BlockState log, BlockState leaves) {\n" +
                    "        super(config, doBlockNofityOnPlace);\n" +
                    "        Main.treesList.add(this);\n" +
                    "        LOG = log;\n" +
                    "        LEAVES =leaves;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public Set<BlockPos> setBlocks() {\n").replace("%s%",name);
            end = "return super.setBlocks();\n" +
                    "    }\n" +
                    "}";
        }

        for(BlockPos blockPos : list){
            if(blockPos==centerBlockPos){
                continue;
            }
            BlockPos centered = centerBlockPos(blockPos,centerBlockPos);
            export =  export + "\nBlock(" + centered.getX()+","+centered.getY()+","+centered.getZ()+",\""+ parseBlock(serverworld,blockPos,tileEntitySave)+"\");";
        }



        File f = new File(FMLPaths.GAMEDIR.get().resolve("wildnature/export/"+name+".java").toString());

        if(f.exists()){
            StringTextComponent s4 = new StringTextComponent(TextFormatting.RED + "Cannot export " +TextFormatting.GOLD + name+".java"+ TextFormatting.RED+" - " + "File already exist.");
            Main.sendChatMessage(source.getSource().asPlayer(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s4));
            return 0;
        }
        try {
            new File(FMLPaths.GAMEDIR.get().resolve("wildnature/export/").toString()).mkdirs();
            f.createNewFile();
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(FMLPaths.GAMEDIR.get().resolve("wildnature/export/"+name+".java").toString());
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(start);
            printWriter.print(export);
            printWriter.print(signature);
            printWriter.print(end);
            printWriter.close();
        } catch (IOException e) {
            StringTextComponent s4 = new StringTextComponent(TextFormatting.RED + "Cannot export " +TextFormatting.GOLD + name+".java"+ TextFormatting.RED+" - " + e.getLocalizedMessage());
            Main.sendChatMessage(source.getSource().asPlayer(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s4));
            return 0;
        }

        StringTextComponent s4 = new StringTextComponent(TextFormatting.AQUA + "Successfully exported " + TextFormatting.GOLD + list.size() + TextFormatting.AQUA +" blocks to "+ TextFormatting.GOLD + name+".java"+ TextFormatting.AQUA+".");
        Main.sendChatMessage(source.getSource().asPlayer(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s4));
        StringTextComponent s5 = new StringTextComponent(TextFormatting.GREEN + "Click to open file");
        s5.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GOLD+"Click here")));
        s5.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE,f.getPath()));
        Main.sendChatMessage(source.getSource().asPlayer(), new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s5));

        return 1;
    }

    public BlockPos centerBlockPos(BlockPos pos, BlockPos zeroPos){
        //zero pos after conversion have to be x0 y0 z0
        int x = center$1(Math.abs(zeroPos.getX()-pos.getX()),pos.getX(),zeroPos.getX());
        int y = center$1(Math.abs(zeroPos.getY()-pos.getY()),pos.getY(),zeroPos.getY());
        int z = center$1(Math.abs(zeroPos.getZ()-pos.getZ()),pos.getZ(),zeroPos.getZ());



        return new BlockPos(x,y,z);
    }

    private int center$1(int value, int pos, int zeroPos){
        if(zeroPos<=pos){
            return value;
        }else{
            return -value;
        }
    }

    private String parseBlock(ServerWorld world, BlockPos pos, boolean saveTileEntity){
        BlockState state = world.getBlockState(pos);
        String s = BlockStateParser.toString(state);
        if(saveTileEntity) {
            TileEntity e = world.getTileEntity(pos);
            if(e!=null){
                CompoundNBT nbt = e.write(new CompoundNBT());
                s = s + nbt.toString().replace("\"","\\\"");
            }
        }

        return s;
    }
}
