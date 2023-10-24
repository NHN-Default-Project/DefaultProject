package com.nhnacademy.Jminsoo.exercise4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Exercise10_4 {
    @Test
    void removeTest() {
        List<String> testList = new ArrayList<>();
        testList.add("가");
        testList.add("가");
        testList.add("나");
        testList.add("다");

        List<String> correctList = new ArrayList<>();
        correctList.add("나");
        correctList.add("다");

        Predicate<String> predicate = value -> value.equals("가");
        Predicates.remove(testList, predicate);

        Assertions.assertEquals(testList, correctList);

    }

    @Test
    void retainTest() {
        List<String> testList = new ArrayList<>();
        testList.add("가");
        testList.add("가");
        testList.add("나");
        testList.add("다");

        List<String> correctList = new ArrayList<>();
        correctList.add("가");
        correctList.add("가");

        Predicate<String> predicate = value -> value.equals("가");
        Predicates.retain(testList, predicate);

        Assertions.assertEquals(testList, correctList);

    }

    @Test
    void collectTest() {
        List<String> testList = new ArrayList<>();
        testList.add("가");
        testList.add("가");
        testList.add("나");
        testList.add("다");

        List<String> correctList = new ArrayList<>();
        correctList.add("가");
        correctList.add("가");

        Predicate<String> predicate = value -> value.equals("가");
        List<String> result = Predicates.collect(testList, predicate);

        Assertions.assertEquals(result, correctList);

    }

    @Test
    void findTest() {
        List<String> testList = new ArrayList<>();
        testList.add("가");
        testList.add("가");
        testList.add("나");
        testList.add("다");

        Predicate<String> predicate = value -> value.equals("가");
        int result = Predicates.find(testList, predicate);
        Assertions.assertEquals(result, 2);
    }
}
