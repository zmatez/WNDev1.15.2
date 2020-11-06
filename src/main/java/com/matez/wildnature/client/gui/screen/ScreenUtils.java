package com.matez.wildnature.client.gui.screen;

public class ScreenUtils {

    public static int[] getByResolution(int width, int height, int marginWidth, int marginHeight, int propX, int propZ){
        int proportion = 0;
        if(width > height){
            for(int i = 0; i < height; i+=propX){
                if(i > height - marginHeight * 2){
                    marginHeight = (height - i) / 2;
                    break;
                }
                proportion++;
            }
            marginWidth = (width - (propZ * proportion)) / 2;
        }else{
            for(int i = 0; i < width; i+=propZ){
                if(i > width - marginWidth * 2){
                    marginWidth = (width - i) / 2;
                    break;
                }
                proportion++;
            }
            marginHeight = (height - (propX * proportion)) / 2;
        }

        int screenX1 = marginWidth;
        int screenX2 = width - marginWidth;
        int screenY1 = marginHeight;
        int screenY2 = height - marginHeight;
        return new int[]{screenX1, screenY1, screenX2, screenY2};
    }

    public static int getWidthByResolution(int width, int height, int propX, int propZ){
        if(width > height){
            int properWidth = 0;
            for(int i = 0; i < width; i+=propX){
                if(i > height){
                    properWidth = i;
                    break;
                }
            }
            return properWidth;
        }
        return width;
    }

}
