package com.matez.wildnature.util.other.debug;

public class TimeDebug {
    private long startTime, endTime;
    private boolean ended = false;

    public void start(){
        startTime = System.currentTimeMillis();
    }

    public void end(){
        ended = true;
        endTime = System.currentTimeMillis();
    }

    public int getMillis(){
        if(!ended){
            return -1;
        }
        return (int) (endTime - startTime);
    }
}
