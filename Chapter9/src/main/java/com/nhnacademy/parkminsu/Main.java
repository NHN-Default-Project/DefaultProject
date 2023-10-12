package com.nhnacademy.parkminsu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        boolean[] arr = {true, false, true};
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numList.add((int) (Math.random() * 100));
        }
        Iterator<Integer> iterator = numList.listIterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.println(num);
        }
    }
}
