package com.example.asus.sanguo;


public class ImageGet {
    public ImageGet(){

    }
    static int getImage(String string){
        switch (string){
            case "1":
                return R.mipmap.ic_launcher;
            case "2":
                return R.mipmap.zhaoyun;
            default:
                return R.mipmap.back;
        }
    }
}
