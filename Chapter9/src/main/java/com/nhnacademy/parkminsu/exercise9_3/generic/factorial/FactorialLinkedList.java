package com.nhnacademy.parkminsu.exercise9_3.generic.factorial;

import com.nhnacademy.parkminsu.exercise9_3.generic.funcinterface.RandomNum;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class FactorialLinkedList<T> {

    public FactorialLinkedList() {
    }

    public List<T> createLinkedListCustomFuncInterface(Function<Random, T> creator, int listSize) {
        List<T> list = new LinkedList<>();
        addDataToListCustomFuncInterface(creator, list, listSize);
        return list;
    }

    private void addDataToListCustomFuncInterface(Function<Random, T> creator, List<T> list, int listSize) {
        if (listSize == 0) {
            return;
        }
        listSize--;
        addDataToListCustomFuncInterface(creator, list, listSize);
        list.add(RandomNumberFactorial.createRandomData(creator));
    }


    public List<T> createLinkedListCustomFuncInterface(RandomNum<Random, T> creator, int listSize) {
        List<T> list = new LinkedList<>();
        addDataToListCustomFuncInterface(creator, list, listSize);
        return list;
    }

    private void addDataToListCustomFuncInterface(RandomNum<Random, T> creator, List<T> list, int listSize) {
        if (listSize == 0) {
            return;
        }
        listSize--;
        addDataToListCustomFuncInterface(creator, list, listSize);
        list.add(RandomNumberFactorial.createRandomDataInCustomFuncInterface(creator));
    }

}
