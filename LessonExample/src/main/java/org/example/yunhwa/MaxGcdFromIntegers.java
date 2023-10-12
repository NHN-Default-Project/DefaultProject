package org.example.yunhwa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxGcdFromIntegers {

    // int[][] 를 받아 gcd all all 에 넣어서 int[]를 리턴해준다
    // int[] 를 받아 max all 에 넣어서 max 값을 리턴해준다

    public static void main(String[] args) {
        try {

            // int[] 입력받는다
            int[] intArr = inputAndMakeIntArray();
            Integer[] integerArr = new Integer[intArr.length];
            for (int i = 0; i < intArr.length; i++) {
                integerArr[i] = Integer.valueOf(intArr[i]);
            }

            // int[] 를 combination 작업 해서 한 쌍씩을 담아 int[][]을 리턴해준다
            Combination combination = new Combination(integerArr);
            List<List<Integer>> combis = combination.combination(2);
            System.out.println(combis); // 이차원 배열 체크용 출력문 //

            // int[][] 를 받아 gcd all all 에 넣어서 int[]를 리턴해준다



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }





    // 사용자 입력으로 배열을 받아서 int[] 리턴해주는 메서드
    public static int[] inputAndMakeIntArray() {
        try (Scanner sc = new Scanner(System.in);) {

            System.out.print("1 2 3 4 5 이런 식으로 배열에 넣을 값들 공백으로 구분하여 입력해주세요\n : ");
            // 1 2 3 4 5 이런 식으로 배열 값 입력받기
            String[] tmpStringArr = sc.nextLine().trim().split(" ");
            int[] intArr = new int[tmpStringArr.length];

            for (int i = 0; i < tmpStringArr.length; i++) {
                intArr[i] = Integer.parseInt(tmpStringArr[i]);
            }
            // int[] 생성 완료!!

            return intArr;
        }
    }






    // gcd all : combiArr[i] 가 들어오면 gcd 계산 해서 int 리턴
//    public static int gcdAll(int[] array) {
//
//
//    }

    // gcd all all : gcd all 호출해서 배열에 넣어서 gcd들이 담긴 int[] 리턴


    // max all : int[] 받아서 max 값 계산해서 int 리턴






//    public static T all(T[] array, lambda (T x, T y) -> T apply(x,y)) {
//
//    }


//    Function<T[], T> gcdAll = (T[] tArr) -> gcd(T[]);
//    Function<T[], T> maxAll = (T[] tArr) -> max(T[]);




}