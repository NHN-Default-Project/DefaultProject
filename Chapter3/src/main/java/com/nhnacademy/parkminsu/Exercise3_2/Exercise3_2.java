package com.nhnacademy.parkminsu.Exercise3_2;

import com.nhnacademy.parkminsu.Exercise3_6.DivisiorCollection;

public class Exercise3_2 {
    public static void main(String[] args) {
        DivisiorCollection divisiorCollection = new DivisiorCollection(1, 10000);
        int num = 1;
        if (num != 1) {
            System.exit(2);
        }

        divisiorCollection.execution(num);
    }

}