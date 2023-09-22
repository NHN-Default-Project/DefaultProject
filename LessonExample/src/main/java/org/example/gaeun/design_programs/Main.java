package org.example.gaeun.design_programs;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        GcdAllAll gcdAllAll = new GcdAllAll();
        MaxAll maxAll = new MaxAll();
        System.out.println(maxAll.all(gcdAllAll.all(Combination.combination(array, 2))));
    }
}
