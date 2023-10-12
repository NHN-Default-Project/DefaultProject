package org.example.gaeun.design_programs;

public class GcdAllAll implements All<Integer[]> {
    @Override
    public Integer[] all(Integer[][] array) {
        Integer[] gcdAll = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                gcdAll[i] = getGCD(array[i][0], array[i][1]);
                System.out.println(gcdAll[i]);
            }
        }
        return gcdAll;
    }

    public static int getGCD(int num1, int num2) {
        if(num1 < num2) {
            int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }
}
