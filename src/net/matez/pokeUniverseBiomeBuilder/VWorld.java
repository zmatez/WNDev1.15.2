package net.matez.pokeUniverseBiomeBuilder;

import java.util.ArrayList;

public class VWorld {
    public int width,height;
    public ArrayList<BlockPosArray> blocks = new ArrayList<>();
    public VWorld(int width, int height){
        this.width=width;
        this.height=height;
    }

    public void setBlock(Block b, int x, int y){
        if(x>width || y>height){
            return;
        }
        for (BlockPosArray block : blocks) {
            if(block.getX()==x && block.getY()==y){
                block.getBlock().setId(b.getId());
                block.getBlock().setColor(b.getColor());
                return;
            }
        }
        blocks.add(new BlockPosArray(b,x,y));

    }

    public Block getBlock(int x, int y){
        for (BlockPosArray block : blocks) {
            if(block.getX()==x && block.getY()==y){
                return block.getBlock();
            }
        }

        return null;
    }

    public static class BlockPosArray{
        private Block block;
        private int x, y;
        public BlockPosArray(Block block, int x, int y){
            this.block=block;
            this.x=x;
            this.y=y;
        }

        public Block getBlock() {
            return block;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
