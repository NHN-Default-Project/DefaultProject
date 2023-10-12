package com.nhnacademy.parkminsu.exercise9_3.generic.factorial;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class FactorialLinkedList<T> {

    public FactorialLinkedList() {
    }

    public List<T> createLinkedList(Function<Random, T> creator, int listSize) {
        List<T> list = new LinkedList<>();
        addDataToList(creator, list, listSize);
        return list;
    }

    private void addDataToList(Function<Random, T> creator, List<T> list, int listSize) {
        if (listSize == 0) {
            return;
        }
        listSize--;
        addDataToList(creator, list, listSize);
        list.add(RandomNumberFactorial.createRandomData(creator));
    }


}
