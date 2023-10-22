package com.nhnacademy.parkminsu.exercise10_4;

import com.nhnacademy.parkminsu.exercise10_4.exception.NegativeNumException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise10_4 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("List의 size 값을 입력하세요.");
            int listSize = Integer.parseInt(br.readLine());

            System.out.println("생성할 정수의 범위");
            System.out.println("최솟값 입력하세요");
            int min = Integer.parseInt(br.readLine());
            System.out.println("최댓값 입력하세요");
            int max = Integer.parseInt(br.readLine());
            RandomIntegerValueFactorial randomIntegerValueFactorial = new RandomIntegerValueFactorial(min, max);

            Function<Random, Integer> randomInt = random -> randomIntegerValueFactorial.createRandomValue();

            predicateRemoveMethodTest(br, randomInt, listSize);
            predicateRetainTest(br, randomInt, listSize);
            predicateCollectTest(br, randomInt, listSize);
            predicateFindTest(br, randomInt, listSize);
        } catch (IOException | NegativeNumException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }


    //테스트 코드
    public static ListRandomOfValue<Integer> createListRandomOfValue(Function<Random, Integer> randomInt, int listSize) throws NegativeNumException {
        ListRandomOfValue<Integer> listRandomOfValue = new ListRandomOfValue(listSize);
        listRandomOfValue.generateListOfRandomValues(randomInt, listSize);
        return listRandomOfValue;
    }

    public static Predicate<Integer> declarationPredicate(int predicateInputNum) {
        return num -> num == predicateInputNum;
    }

    public static void predicateRemoveMethodTest(BufferedReader br, Function<Random, Integer> randomInt, int listSize) throws IOException, NegativeNumException {
        ListRandomOfValue<Integer> randomValueList = createListRandomOfValue(randomInt, listSize);
        System.out.println("랜덤으로 생성된 리스트의 값: " + randomValueList.getListOfRandomValues());
        System.out.println("삭제할 값을 입력하시오");
        Predicate<Integer> pred = declarationPredicate(Integer.parseInt(br.readLine()));
        Predicates.remove(randomValueList.getListOfRandomValues(), pred); // 테스트 메소드
        System.out.println("결과 값: " + randomValueList.getListOfRandomValues());
    }

    public static void predicateRetainTest(BufferedReader br, Function<Random, Integer> randomInt, int listSize) throws IOException, NegativeNumException {
        ListRandomOfValue<Integer> randomValueList = createListRandomOfValue(randomInt, listSize);
        System.out.println("랜덤으로 생성된 리스트의 값: " + randomValueList.getListOfRandomValues());
        System.out.println("찾는 값을 입력하세요");
        Predicate<Integer> pred = declarationPredicate(Integer.parseInt(br.readLine()));
        Predicates.retain(randomValueList.getListOfRandomValues(), pred);
        System.out.println("결과 값: " + randomValueList.getListOfRandomValues());
    }

    public static void predicateCollectTest(BufferedReader br, Function<Random, Integer> randomInt, int listSize) throws IOException, NegativeNumException {
        ListRandomOfValue<Integer> randomValueList = createListRandomOfValue(randomInt, listSize);
        System.out.println("랜덤으로 생성된 리스트의 값: " + randomValueList.getListOfRandomValues());
        System.out.println("일치하는 값 입력");
        Predicate<Integer> pred = declarationPredicate(Integer.parseInt(br.readLine()));
        List<Integer> list = Predicates.collect(randomValueList.getListOfRandomValues(), pred);
        System.out.println("결과 값: " + list.toString());
    }

    public static void predicateFindTest(BufferedReader br, Function<Random, Integer> randomInt, int listSize) throws IOException, NegativeNumException {
        ListRandomOfValue<Integer> randomValueList = createListRandomOfValue(randomInt, listSize);
        System.out.println("일치하는 값 입력" + randomValueList.getListOfRandomValues());
        Predicate<Integer> pred = declarationPredicate(Integer.parseInt(br.readLine()));
        int idx = Predicates.find(randomValueList.getListOfRandomValues(), pred);
        if (idx == -1) {
            System.out.println("일치하는 항목이 없습니다!");
        } else {
            System.out.println("일치하는 데이터의 인덱스 값: " + idx);
        }
    }

}
