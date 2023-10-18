package com.nhnacademy.jaehyeon.exercise10_3;

public class Exercise10_3 {
    public static void main(String[] args) {
        HaspMapCustom haspMapCustom = new HaspMapCustom();
        haspMapCustom.put("재현", "jaehyeon");
        haspMapCustom.put("빛이 있으라", "fiat_lux");
        haspMapCustom.put("꽃", "flower");
        System.out.println(haspMapCustom.get("재현"));
        System.out.println(haspMapCustom.get("빛이 있으라"));
        System.out.println(haspMapCustom.get("꽃"));
        System.out.println(haspMapCustom.get("w"));
        System.out.println(haspMapCustom.size());
        haspMapCustom.remove("꽃");
    }
}
