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
        }
        return 0;
    }
    static int getBigFrame(String string){
        switch (string){
            case "saber":
                return R.mipmap.saberbig;
            case "archer":
                return R.mipmap.archerbig;
            case "lancer":
                return R.mipmap.lancerbig;
            case "rider":
                return R.mipmap.riderbig;
            case "caster":
                return R.mipmap.casterbig;
            case "assassin":
                return R.mipmap.assassinbig;
            case "berserker":
                return R.mipmap.berserkerbig;
            case "ruler":
                return R.mipmap.rulerbig;
        }
        return 0;
    }
    static int getSmallFrame(String string){
        switch (string){
            case "saber":
                return R.mipmap.saber;
            case "archer":
                return R.mipmap.archer;
            case "lancer":
                return R.mipmap.lancer;
            case "rider":
                return R.mipmap.rider;
            case "caster":
                return R.mipmap.caster;
            case "assassin":
                return R.mipmap.assassin;
            case "berserker":
                return R.mipmap.berserker;
            case "ruler":
                return R.mipmap.ruler;
        }
        return 0;
    }
}
