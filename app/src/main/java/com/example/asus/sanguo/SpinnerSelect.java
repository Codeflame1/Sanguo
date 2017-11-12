package com.example.asus.sanguo;

/**
 * Created by ASUS on 2017-11-12.
 */

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
            case "1":
                return 0;
            case "2":
                return 1;
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

}
