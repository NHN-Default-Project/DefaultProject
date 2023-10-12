package org.example.gaeun.design_programs;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {12, 24, 32, 54, 60};
        GcdAllAll gcdAllAll = new GcdAllAll();
        MaxAll maxAll = new MaxAll();

        for(int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + " ");
        }
        System.out.println();
        System.out.printf("다음 배열에서 나올 수 있는 최대공약수는 ");
        Combination combination = new Combination(array, 3);
        combination.tmpListToArray();
        System.out.println(maxAll.all(gcdAllAll.all(combination.getTwoArray())) + "입니다");
    }
}
