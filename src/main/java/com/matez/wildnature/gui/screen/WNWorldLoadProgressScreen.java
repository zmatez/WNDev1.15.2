package com.matez.wildnature.gui.screen;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.chunk.listener.TrackingChunkStatusListener;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public class WNWorldLoadProgressScreen extends Screen {

    private final TrackingChunkStatusListener progress;
    private long field_213041_b = -1L;
    public int color;
    public ArrayList<BlockPoint> blockPoints,coloredPoints;
    public ChunkStatus currentChunkStatus = null;

    public WNWorldLoadProgressScreen(TrackingChunkStatusListener p_i51113_1_) {
        super(new StringTextComponent("WNWorldLoadProgressScreen"));
        this.progress = p_i51113_1_;
        this.blockPoints = new ArrayList<>();
        this.coloredPoints = new ArrayList<>();
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    public void removed() {
        NarratorChatListener.INSTANCE.say(I18n.format("narrator.loading.done", new Object[0]));
    }

    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();

        String lvt_4_1_ = MathHelper.clamp(this.progress.getPercentDone(), 0, 100) + "%";
        long lvt_5_1_ = Util.milliTime();
        if (lvt_5_1_ - this.field_213041_b > 2000L) {
            this.field_213041_b = lvt_5_1_;
            NarratorChatListener.INSTANCE.say((new TranslationTextComponent("narrator.loading", new Object[]{lvt_4_1_})).getString());
        }

        int centerWidth = this.width / 2;
        int centerHeight = this.height / 2;



        renderChunks(this.progress, centerWidth, centerHeight,this.width,this.height);
        drawChunkIndicator(progress, centerWidth, centerHeight + 30, 2, 0);
        FontRenderer var10001 = this.font;
        this.drawCenteredString(var10001, lvt_4_1_, centerWidth, centerHeight - 9 / 2 + 30, 16777215);
        drawLoading(centerWidth,centerHeight-30);

    }

    private int points = 0;
    private String loadText = "Loading world";
    public void drawLoading(int centerWidth, int centerHeight){
        points++;
        String sp = "";
        if(points>=0 && points<30){
            sp = "";
        }else if(points>=30 && points<60){
            sp = ".";
        }else if(points>=60 && points<90){
            sp = "..";
        }else if(points>=90 && points<120){
            sp = "...";
        }else{
            points=0;
        }
        this.drawCenteredString(this.font, loadText+sp, centerWidth, centerHeight - 9 / 2, 16777215);

    }


    @Override
    public void resize(Minecraft p_resize_1_, int p_resize_2_, int p_resize_3_) {
        super.resize(p_resize_1_, p_resize_2_, p_resize_3_);
        coloredPoints.clear();
        drawn=false;
        building=false;
        joining=false;
    }

    @Override
    public void onClose() {
        //super.onClose();
        closing=true;
        if(t!=null){
            t.stop();
        }
    }

    private boolean drawn = false, rendered = false, building = false,joining=false,closing=false;
    private Thread t;
    public void renderChunks(TrackingChunkStatusListener progress, int centerX, int centerY,int maxX,int maxY) {
        if(Main.runningWorld!=null && Main.runningWorld.getDimension()!=null) {
            try {
                BlockPos center = Main.runningWorld.getSpawnPoint();
                int blockSize = 10;
                if(!drawn){
                    loadText="Rendering terrain";
                    points=0;
                    drawBackground(centerX,centerY,maxX,maxY,blockSize,center.getX(),center.getZ());
                    drawn=true;
                }
                if(currentChunkStatus==null || !currentChunkStatus.getName().equals(Objects.requireNonNull(progress.getStatus(Main.runningWorld.getChunkAt(center).getPos().x, Main.runningWorld.getChunkAt(center).getPos().z)).getName())){

                    if(true) {
                        //Main.LOGGER.debug("Drawing background");
                        WNWorldLoadProgressScreen self = this;
                        t = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    //Main.LOGGER.debug("Entries: " + self.blockPoints.size());
                                    int i = 0;
                                    for (BlockPoint blockPoint : self.blockPoints) {
                                        if(blockPoint.isColorProper()){
                                            continue;
                                        }
                                        if(self.closing){
                                            break;
                                        }
                                        //Main.LOGGER.debug("Getting color : " + i + "/"+self.blockPoints.size());
                                        try {
                                            if(Main.runningWorld.isAreaLoaded(new BlockPos(blockPoint.getPosX(),63, blockPoint.getPosZ()),1)) {
                                                blockPoint.setColorProper(true);
                                                self.coloredPoints.add(blockPoint.withColor(getColor(blockPoint.getPosX(), blockPoint.getPosZ())));
                                            }else{
                                                //Main.LOGGER.debug("Area isn't loaded ! ");
                                                //blockPoint.setColorProper(false);
                                                //Main.LOGGER.debug("c: " + Integer.decode("0x"+Utilities.blendColors(new Color(50,45,30),Color.WHITE,0.2F)));
                                                //self.coloredPoints.add(blockPoint.withColor(Utilities.getColorValue(Integer.decode("0x"+Utilities.blendColors(new Color(50,45,30),Color.WHITE,(float)Utilities.rdoub(0.9,1))))));

                                            }

                                        }catch (Exception e){
                                            //Main.LOGGER.debug("Exception color: " + Arrays.toString(e.getStackTrace()));
                                        }
                                        i++;
                                    }

                                    //Main.LOGGER.debug("E: " + self.blockPoints.size() + " / " + self.coloredPoints.size());

                                    if(!building){
                                        loadText="Building terrain";
                                        points=0;
                                        building=true;
                                    }

                                } catch (Exception e) {
                                    //Main.LOGGER.debug("Exception " + Arrays.toString(e.getStackTrace()));
                                }
                            }
                        });


                        t.start();
                        rendered=true;
                    }
                }

                if(MathHelper.clamp(this.progress.getPercentDone(), 0, 100)==100){
                    if(!joining){
                        loadText="Joining world";
                        points=0;
                        joining=true;
                    }
                }

                ArrayList<BlockPoint> cp = new ArrayList<>(coloredPoints);

                for (BlockPoint blockPoint : blockPoints) {
                    BlockPoint p = blockPoint;
                    for (BlockPoint coloredPoint : cp) {
                        if (blockPoint.getPosX() == coloredPoint.getPosX() && blockPoint.getPosZ() == coloredPoint.getPosZ()) {
                            if(coloredPoint.getColor()!=0 || !coloredPoint.isColorProper()){
                                p.setColor(coloredPoint.getColor());
                                break;
                            }else{
                                p.setColor(Utilities.getColorValue(0x554639));
                            }
                        }
                    }
                    if(p.checkColor()){
                        fill(p.getStartX(),p.getStartY(),p.getEndX(),p.getEndY(),p.getColor());
                    }else{
                        //fill(p.getStartX(),p.getStartY(),p.getEndX(),p.getEndY(),Utilities.getColorValue(0xC3AD88));
                    }
                }

                /*for (BlockPoint blockPoint : coloredPoints) {
                    if(blockPoint.checkColor()){
                        fill(blockPoint.getStartX(),blockPoint.getStartY(),blockPoint.getEndX(),blockPoint.getEndY(),blockPoint.getColor());
                    }else{
                        fill(blockPoint.getStartX(),blockPoint.getStartY(),blockPoint.getEndX(),blockPoint.getEndY(),Utilities.getColorValue(0x675640));
                    }
                }*/


            }catch (Exception e){
            }

        }
    }


    public void fillWithColor(int startX, int startY, int endX, int endY, int posX, int posZ){
        getColorV(posX,posZ);
        int c;
        if(color==0){
            c=Utilities.getColorValue(0x313131);
        }else{
            c=color;
        }
        fill(startX,startY,endX,endY,c);
    }

    public void fillWithColor(int startX, int startY, int endX, int endY, int color){
        fill(startX,startY,endX,endY,color);
    }


    public int getHeight(int x, int z, World world){
        for(int i = world.getHeight(); i>1; i--){
            Block b = world.getBlockState(new BlockPos(x,i,z)).getBlock();
            if(b!=null && b!= Blocks.AIR && b!= Blocks.VOID_AIR && b!=Blocks.CAVE_AIR){
                return i;
            }
        }
        return 1;
    }


    public void drawBackground(int centerWidth, int centerHeight, int maxWidth, int maxHeight, int size, int posX, int posZ){
        blockPoints = new ArrayList<>();
        int x =centerWidth;//horiz
        int y =centerHeight;//vert

        int pX = posX;
        int pZ = posZ;

        while(x>0){
            x=x-size;
            pX=pX-1;
            drawVertical(x,y,maxWidth,maxHeight,size,pX,pZ);
        }

        x =centerWidth;//horiz
        y =centerHeight;//vert

        pX = posX;
        pZ = posZ;


        while(x<maxWidth+size){
            x=x+size;
            pX=pX+1;
            drawVertical(x,y,maxWidth,maxHeight,size,pX,pZ);
        }

    }

    private void drawVertical(int centerWidth, int centerHeight, int maxWidth, int maxHeight, int size, int posX, int posZ){
        int x =centerWidth;//horiz
        int y =centerHeight;//vert

        int pX = posX;
        int pZ = posZ;

        //down
        while (y>0){
            y=y-size;
            pZ=pZ-1;
            BlockPoint b = new BlockPoint(x + size, y + size, x - size, y - size, pX, pZ);
            /*boolean contains = false;
            for (BlockPoint blockPoint : blockPoints) {
                if(blockPoint.getPosX()==b.getPosX() && blockPoint.getPosZ()==b.getPosZ()){
                    contains=true;
                }
            }
            if(!contains) {
                blockPoints.add(b);
            }*/
            blockPoints.add(b);
        }
        x =centerWidth;//horiz
        y =centerHeight;//vert

        pX = posX;
        pZ = posZ;

        //up
        while (y<maxHeight+size){
            y=y+size;
            pZ=pZ+1;
            BlockPoint b = new BlockPoint(x + size, y + size, x - size, y - size, pX, pZ);
            /*boolean contains = false;
            for (BlockPoint blockPoint : blockPoints) {
                if(blockPoint.getPosX()==b.getPosX() && blockPoint.getPosZ()==b.getPosZ()){
                    contains=true;
                }
            }
            if(!contains) {
                blockPoints.add(b);
            }*/
            blockPoints.add(b);
        }

    }

    public void getColorV(int posX, int posZ){
        color = Utilities.getColorValue(Main.runningWorld.getBlockState(new BlockPos(posX, getHeight(posX, posZ, Main.runningWorld), posZ)).getBlock().getMaterialColor(null, null, null).colorValue);


    }

    public int getColor(int posX, int posZ){
        //Main.LOGGER.debug("getting color");
        BlockPos blockPos= new BlockPos(posX,getHeight(posX,posZ,Main.runningWorld),posZ);
        Block b = (Main.runningWorld.getBlockState(blockPos).getBlock());
        try{
            return Utilities.getColorValue(Integer.decode("0x"+Utilities.blendColors(Color.decode(b.getMaterialColor(null,null,null).colorValue+""),blockPos.getY()>Main.runningWorld.getSeaLevel() ? Color.WHITE : Color.BLACK,(float)(blockPos.getY()/Main.runningWorld.getHeight())/4+0.8F)));
        }catch (Exception e){
            //Main.LOGGER.debug("Cannot get " + b.getNameTextComponent().toString());
        }
        return 0;
    }


    public static class BlockPoint{
        private int startX, startY, endX, endY, posX, posZ, color;
        private boolean colorProper = false;
        public BlockPoint(int startX, int startY, int endX, int endY, int posX, int posZ){
            this.startX=startX;
            this.startY=startY;
            this.endX=endX;
            this.endY=endY;
            this.posX=posX;
            this.posZ=posZ;
        }

        public int getEndX() {
            return endX;
        }

        public int getEndY() {
            return endY;
        }

        public int getPosX() {
            return posX;
        }

        public int getPosZ() {
            return posZ;
        }

        public int getStartX() {
            return startX;
        }

        public int getStartY() {
            return startY;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public BlockPoint withColor(int color) {
            this.color = color;
            return this;
        }

        public boolean checkColor(){
            return color!=0;
        }

        public boolean isColorProper(){
            return colorProper;
        }

        public void setColorProper(boolean colorProper) {
            this.colorProper = colorProper;
        }
    }

    /*CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        return getColor(center.getX(),center.getZ());
                    }
                });

                fillWithColor(centerX+blockSize,centerY+blockSize,centerX-blockSize,centerY-blockSize,completableFuture.get());*/
    //fillWithColor(centerX+blockSize,centerY+blockSize,centerX-blockSize,centerY-blockSize,center.getX(),center.getZ());

    private static final Object2IntMap<ChunkStatus> COLORS = Util.make(new Object2IntOpenHashMap<>(), (p_213039_0_) -> {
        p_213039_0_.defaultReturnValue(0);
        p_213039_0_.put(ChunkStatus.EMPTY, 5526612);
        p_213039_0_.put(ChunkStatus.STRUCTURE_STARTS, 10066329);
        p_213039_0_.put(ChunkStatus.STRUCTURE_REFERENCES, 6250897);
        p_213039_0_.put(ChunkStatus.BIOMES, 8434258);
        p_213039_0_.put(ChunkStatus.NOISE, 13750737);
        p_213039_0_.put(ChunkStatus.SURFACE, 7497737);
        p_213039_0_.put(ChunkStatus.CARVERS, 7169628);
        p_213039_0_.put(ChunkStatus.LIQUID_CARVERS, 3159410);
        p_213039_0_.put(ChunkStatus.FEATURES, 2213376);
        p_213039_0_.put(ChunkStatus.LIGHT, 13421772);
        p_213039_0_.put(ChunkStatus.SPAWN, 15884384);
        p_213039_0_.put(ChunkStatus.HEIGHTMAPS, 15658734);
        p_213039_0_.put(ChunkStatus.FULL, 16777215);
    });

    public static void drawChunkIndicator(TrackingChunkStatusListener p_213038_0_, int p_213038_1_, int p_213038_2_, int p_213038_3_, int p_213038_4_) {
        int i = p_213038_3_ + p_213038_4_;
        int j = p_213038_0_.getDiameter();
        int k = j * i - p_213038_4_;
        int l = p_213038_0_.func_219523_d();
        int i1 = l * i - p_213038_4_;
        int j1 = p_213038_1_ - i1 / 2;
        int k1 = p_213038_2_ - i1 / 2;
        int l1 = k / 2 + 1;
        int i2 = -16772609;
        if (p_213038_4_ != 0) {
            fill(p_213038_1_ - l1, p_213038_2_ - l1, p_213038_1_ - l1 + 1, p_213038_2_ + l1, -16772609);
            fill(p_213038_1_ + l1 - 1, p_213038_2_ - l1, p_213038_1_ + l1, p_213038_2_ + l1, -16772609);
            fill(p_213038_1_ - l1, p_213038_2_ - l1, p_213038_1_ + l1, p_213038_2_ - l1 + 1, -16772609);
            fill(p_213038_1_ - l1, p_213038_2_ + l1 - 1, p_213038_1_ + l1, p_213038_2_ + l1, -16772609);
        }

        for(int j2 = 0; j2 < l; ++j2) {
            for(int k2 = 0; k2 < l; ++k2) {
                ChunkStatus chunkstatus = p_213038_0_.getStatus(j2, k2);
                int l2 = j1 + j2 * i;
                int i3 = k1 + k2 * i;
                fill(l2, i3, l2 + p_213038_3_, i3 + p_213038_3_, COLORS.getInt(chunkstatus) | -16777216);
            }
        }

    }
}