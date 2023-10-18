package com.nhnacademy.Jminsoo.exercise4;

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

        System.out.println("삭제 전 리스트 요소");
        testList.stream()
                .forEach(System.out::println);
        Predicate<String> predicate = value -> value.equals("가");
        Predicates.remove(testList, predicate);

        System.out.println("\"가\"삭제 후 리스트 요소");
        testList.stream()
                .forEach(System.out::println);
    }

    @Test
    void retainTest() {
        List<String> testList = new ArrayList<>();
        testList.add("가");
        testList.add("가");
        testList.add("나");
        testList.add("다");

        System.out.println("삭제 전 리스트 요소");
        testList.stream()
                .forEach(System.out::println);
        Predicate<String> predicate = value -> value.equals("가");
        Predicates.retain(testList, predicate);

        System.out.println("\"가\"제외 삭제 후 리스트 요소");
        testList.stream()
                .forEach(System.out::println);
    }

    @Test
    void collectTest() {
        List<String> testList = new ArrayList<>();
        testList.add("가");
        testList.add("가");
        testList.add("나");
        testList.add("다");

        System.out.println("삭제 전 리스트 요소");
        testList.stream()
                .forEach(System.out::println);
        Predicate<String> predicate = value -> value.equals("가");
        List<String> result = Predicates.collect(testList, predicate);

        System.out.println("\"가\"가만 가져오기!");
        result.stream()
                .forEach(System.out::println);
    }

    @Test
    void findTest() {
        List<String> testList = new ArrayList<>();
        testList.add("가");
        testList.add("가");
        testList.add("나");
        testList.add("다");

        System.out.println("삭제 전 리스트 요소");
        testList.stream()
                .forEach(System.out::println);
        Predicate<String> predicate = value -> value.equals("가");
        int result = Predicates.find(testList, predicate);

        System.out.println("\"가\"제외 삭제 후 리스트 개수");
        System.out.println(result);
    }
}
