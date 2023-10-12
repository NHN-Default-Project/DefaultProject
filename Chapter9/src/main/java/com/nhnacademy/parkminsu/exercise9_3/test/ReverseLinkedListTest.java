package com.nhnacademy.parkminsu.exercise9_3.test;


import com.nhnacademy.parkminsu.exercise9_3.generic.ReversLinkedList;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedListTest {
    @Test
    void addTest() {
        ReversLinkedList reversLiinkedList = new ReversLinkedList();
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(2);
        list.add(3);
        reversLiinkedList.makeReverseLinkedList(reversLiinkedList, list);

        System.out.println(reversLiinkedList.toString());
    }

}
