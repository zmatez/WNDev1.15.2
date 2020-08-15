package com.matez.wildnature.other;

public class Motd {

    public Motd(String text,String command, int type, String date, boolean prefix){
        this.text=text;
        this.command=command;
        this.type=type;
        this.date=date;
        this.prefix=prefix;
    }

    private String text,command, date;
    private int type;
    private boolean prefix;

    public void setType(int type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPrefix(boolean prefix) {
        this.prefix = prefix;
    }

    public int getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public boolean getPrefix(){
        return prefix;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
