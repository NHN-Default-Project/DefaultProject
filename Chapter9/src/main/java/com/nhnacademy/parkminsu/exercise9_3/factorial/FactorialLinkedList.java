package com.nhnacademy.parkminsu.exercise9_3.factorial;

import java.util.LinkedList;
import java.util.List;

public class FactorialLinkedList {

    public FactorialLinkedList() {
    }

    public List<Integer> createLinkedList(int listSize) {
        List<Integer> list = new LinkedList<>();
        addDataToList(list, listSize);
        return list;
    }

    private void addDataToList(List<Integer> list, int listSize) {
        if (listSize == 0) {
            return;
        }
        listSize--;
        addDataToList(list, listSize);
        int num = RandomNumberFactorial.createRandomNumber(10, 100);
        list.add(num);
    }


}
