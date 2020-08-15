package com.matez.wildnature.other;

public class Patron {

    public Patron(String uuid){
        setUuid(uuid);
    }

    private String uuid;
    private int id,type;
    //1 - leader; 2 - team; 3 - dev; 4 - patron
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getUuid() {
        return uuid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "("+uuid+","+id+","+type+")";
    }
}
