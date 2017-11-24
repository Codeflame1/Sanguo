package com.example.asus.sanguo;


public class SpinnerSelect {
    public SpinnerSelect(){
    }

    static int getJobSelect(String string) {
        switch (string){
            case "saber":
                return 0;
            case "archer":
                return 1;
            case "lancer":
                return 2;
            case "rider":
                return 3;
            case "caster":
                return 4;
            case "assassin":
                return 5;
            case "berserker":
                return 6;
            case "ruler":
                return 7;
            default:
                return 7;
        }
    }

    static int getImageSelect(String string) {
        switch (string){
            case "zhaoyun":
                return 0;
            case "huangyueying":
                return 1;
            case "sunshangxiang":
                return 2;
            case "caiwenji":
                return 3;
            case "diaochan":
                return 4;
            case "zhenfu":
                return 5;
            case "caocao":
                return 6;
            case "lvbu":
                return 7;
            case "zhugeliang":
                return 8;
            case "zhouyu":
                return 9;
            default:
                return 0;
        }
    }

    static int getSex(String string) {
        switch (string){
            case "男":
                return 0;
            case "女":
                return 1;
            default:
                return 1;
        }
    }

    static int getLevel(String string) {
        switch (string){
            case "E":
                return 0;
            case "D":
                return 1;
            case "C":
                return 2;
            case "B":
                return 3;
            case "A":
                return 4;
            case "A+":
                return 5;
            case "A++":
                return 6;
            case "A+++":
                return 7;
            case "EX":
                return 8;
            default:
                return 0;
        }
    }

    static int getType(String string) {
        switch (string){
            case "固有技能":
                return 0;
            case "职阶技能":
                return 1;
            case "宝具":
                return 2;
            default:
                return 0;
        }
    }

}
