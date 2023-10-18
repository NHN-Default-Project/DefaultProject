package com.nhnacademy.parkminsu.exercise9_3.factorial;

import com.nhnacademy.parkminsu.exercise9_3.CustomLinkedList;
import com.nhnacademy.parkminsu.exercise9_3.funcinterface.RandomNum;

import java.util.Random;
import java.util.function.Function;

public class FactorialLinkedList<T> {
    /**
     * 자바에서 제공하는 Functional Interface를 사용한 메소드
     * 랜덤 데이터가 들어간 List 생성
     */
    public CustomLinkedList<T> createLinkedList(Function<Random, T> creator, int listSize) {
        CustomLinkedList<T> list = new CustomLinkedList<>();
        addDataToList(creator, list, listSize);
        return list;
    }

    private void addDataToList(Function<Random, T> creator, CustomLinkedList<T> list, int listSize) {
        if (listSize == 0) {
            return;
        }
        listSize--;
        addDataToList(creator, list, listSize);
        list.add(RandomNumberFactorial.createRandomData(creator));
    }

    /**
     * 직접 만든 Functional Interface를 사용한 메소드
     * 랜덤 데이터가 들어간 List 생성
     */
    public CustomLinkedList<T> createLinkedList(RandomNum<Random, T> creator, int listSize) {
        CustomLinkedList<T> list = new CustomLinkedList<>();
        addDataToList(creator, list, listSize);
        return list;
    }

    private void addDataToList(RandomNum<Random, T> creator, CustomLinkedList<T> list, int listSize) {
        if (listSize == 0) {
            return;
        }
        listSize--;
        addDataToList(creator, list, listSize);
        list.add(RandomNumberFactorial.createRandomData(creator));
    }

}
