package net.matez.pokeUniverseBiomeBuilder;

import java.awt.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;

public class Block {
    public static ArrayList<Block> blocks = new ArrayList<>();
    private String id;
    private Color color;
    public Block(String id, Color color){
        this.id=id;
        this.color=color;
        blocks.add(this);
    }

    public String getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static Color getRandomColor(String id){
        try {
            for (Block block : blocks) {
                if (block.getId().equals(id)) {
                    return block.getColor();
                }
            }
            Random m = new Random(stringToSeed(id));
            return new Color((float) rdoub(0.0, 1.0, m), (float) rdoub(0.0, 1.0, m), (float) rdoub(0.0, 1.0, m));
        }catch (ConcurrentModificationException e){
            return Color.RED;
        }
    }

    private static double rdoub(double min, double max, Random r) {

        if(min==max){
            return min;
        }

        if (min >= max) {
            return max;
        }

        return min + (max - min) * r.nextDouble();
    }

    private static long stringToSeed(String s) {
        if (s == null) {
            return 0;
        }
        long hash = 0;
        for (char c : s.toCharArray()) {
            hash = 31L*hash + c;
        }
        return hash;
    }
}
