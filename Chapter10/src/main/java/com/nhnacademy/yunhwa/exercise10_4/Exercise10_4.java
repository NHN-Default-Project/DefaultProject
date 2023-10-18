package com.nhnacademy.yunhwa.exercise10_4;

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
    public static void main(String[] args) {
        predicatesTest();
    }

    public static void predicatesTest() {
        System.out.println("\n1 부터 100 까지의 숫자가 담긴 리스트로 간단하게 테스트 해보겠습니다.\n");

        List<Integer> integerList1 = IntStream.range(1, 101).boxed().collect(Collectors.toList());
        System.out.println("짝수인 것들 제거한 결과");
        Predicates.remove(integerList1, x -> x % 2 == 0);
        System.out.println(integerList1);
        System.out.println();

        integerList1 = IntStream.range(1, 101).boxed().collect(Collectors.toList());
        System.out.println("10의 배수인 것들 수집해서 리턴된 새로운 리스트");
        System.out.println(Predicates.collect(integerList1, x -> x % 10 == 0));
        System.out.println();


        System.out.println("5의 배수가 아닌 것들 제거한 결과");
        Predicates.retain(integerList1, x -> x % 5 == 0);
        System.out.println(integerList1);
        System.out.println("참고 : 5의 배수만 collect 한 결과와 동일하나, retain 은 기존의 콜렉션 내용을 변경함.");
        System.out.println();

        ArrayList<Integer> arrlist = new ArrayList<>(IntStream.range(1, 101).boxed().collect(Collectors.toList()));
        System.out.print("20의 배수들 중 가장 첫 번째 항목의 인덱스 (0부터 인덱스 시작) : ");
        System.out.println(Predicates.find(arrlist, x -> x % 20 == 0));
    }
}
