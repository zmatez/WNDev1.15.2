package com.matez.wildnature.other;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Wait {
    private Timer t;
    public Wait(int msWait, ActionListener listener){
        t = new Timer(msWait,listener);
        t.setRepeats(false);
    }

    public Wait(int msWait, boolean start, ActionListener listener){
        t = new Timer(msWait,listener);
        t.setRepeats(false);
        if(start){
            t.start();
        }
    }
    public void start(){
        t.start();
    }
}
