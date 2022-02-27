package com.example.myapplication;

public class Emoji {
    private  String emName;
    private int img_id;

    public int getImg_id(){
        return img_id;
    }
    public  void setImg_id(int img_id){
        this.img_id = img_id;
    }
    public String getEmName(){
        return emName;
    }
    public void setEmName(String emName){
        this.emName = emName;
    }
    public Emoji(String emName, int img_id){
        this.emName=emName;
        this.img_id=img_id;
    }
    public Emoji(){

    }
}

