package com.nhnacademy.main.exercise10_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 10 - 4
* 자바의 java.util.function 패키지의 Predicate<T> 활용해보는 문제
* 자바의 Collection 에 정의된 Predicate<T> 가 활용되는 메서드 중
* 4개의 유사한 메서드를 직접 작성해보자
* 클래스 명 : Predicates
* 스트림 API 사용 x
* */
public class Exercise10_4 {

    @Test
    @DisplayName("remove Test")
    void removeTest() { // 짝수인 것들 제거
        List<Integer> integerList = IntStream.range(1, 101).boxed().collect(Collectors.toList());
        Predicates.remove(integerList, x -> x % 2 == 0);
        List<Integer> intStreamList = IntStream.range(1, 101)
                .boxed()
                .filter(x -> x % 2 == 1).collect(Collectors.toList());
        Assertions.assertTrue(integerList.equals(intStreamList));
    }

    @Test
    @DisplayName("collect Test")
    void collectTest() { // 10 의 배수인 것들만 수집
        List<Integer> integerList = IntStream.range(1, 101).boxed().collect(Collectors.toList());
        Assertions.assertTrue(Predicates.collect(integerList, x -> x % 10 == 0)
                .equals(IntStream.range(1, 101)
                        .boxed()
                        .filter(x -> x % 10 == 0)
                        .collect(Collectors.toList())));
    }

    @Test
    @DisplayName("retain Test")
    void retainTest() { // 5의 배수가 아닌 것들 제거 == 5의 배수인 것들만 남기기
        List<Integer> integerList = IntStream.range(1, 101).boxed().collect(Collectors.toList());
        Predicates.retain(integerList, x -> x % 5 == 0);
        Assertions.assertTrue(integerList
                .equals(IntStream.range(1, 101)
                        .boxed()
                        .filter(x -> x % 5 == 0)
                        .collect(Collectors.toList())));
    }

    @Test
    @DisplayName("find Test")
    void findTest() { // 20의 배수들 중 가장 첫 번째 항목의 인덱스 (0부터 인덱스 시작) = 19
        ArrayList<Integer> arrList = new ArrayList<>(IntStream.range(1, 101).boxed().collect(Collectors.toList()));
        Assertions.assertTrue(Predicates.find(arrList, x -> x % 20 == 0) == 19);
    }


}
