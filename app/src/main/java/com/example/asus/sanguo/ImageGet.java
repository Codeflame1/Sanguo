package com.example.asus.sanguo;


public class ImageGet {
    public ImageGet(){

    }
    static int getImage(String string){
        switch (string){
            case "zhaoyun":
                return R.mipmap.zhaoyun;
            case "huangyueying":
                return R.mipmap.huangyueying;
            case "sunshangxiang":
                return R.mipmap.sunshangxiang;
            case "caiwenji":
                return R.mipmap.caiwenji;
            case "diaochan":
                return R.mipmap.diaochan;
            case "zhenfu":
                return R.mipmap.zhenfu;
            case "caocao":
                return R.mipmap.caocao;
            case "lvbu":
                return R.mipmap.lvbu;
            case "zhugeliang":
                return R.mipmap.zhugeliang;
            case "zhouyu":
                return R.mipmap.zhouyu;
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

    static int getLevelImage(String string){
        switch (string){
            case "E":
                return R.mipmap.levele;
            case "D":
                return R.mipmap.leveld;
            case "C":
                return R.mipmap.levelc;
            case "B":
                return R.mipmap.levelb;
            case "A":
                return R.mipmap.levela;
            case "A+":
                return R.mipmap.levela;
            case "A++":
                return R.mipmap.levela;
            case "A+++":
                return R.mipmap.levela;
            case "EX":
                return R.mipmap.levelex;
        }
        return 0;
    }
}
