package com.nhnacademy.yunhwa.exercise8_2;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise8_2 {

    public static void main(String[] args) {
        final BigInteger THREE = new BigInteger("3");
        final BigInteger TWO = new BigInteger("2");
        final BigInteger ONE = new BigInteger("1");
        final BigInteger ZERO = new BigInteger("0");

        int termCount = 1;

        Scanner sc = new Scanner(System.in);
        BigInteger n = BigInteger.ZERO; // 초기화

        while (true) {
            try {
                System.out.print("N에서 시작하는 '3N+1' 수열을 만들기 위한 양의 정수 N 값을 입력해주세요 : ");
                String numStr = sc.nextLine().trim();
                n = new BigInteger(numStr); // 할당

                // 양의 정수가 아니라면
                if (n.signum() != 1) {
                    System.out.println("양의 정수가 아닌 값이 입력되었습니다. 입력을 다시 해주시기 바랍니다.");
                } else { // 양의 정수가 만들어졌다면
                    break; // 탈출
                }
            } catch (NumberFormatException e) {
                System.out.println("정수로 변환할 수 없는 값이 입력되었습니다. 다시 입력해주세요");
            }
        }

        // 양의 정수가 맞다면
        while (!n.equals(ONE)) {
            System.out.println(termCount + " 번째 항의 값 : " + n);

            if (n.remainder(TWO).equals(ZERO)) { // n 이 짝수 (n.testBit(0) == false)
                n = n.divide(TWO);
            } else { // n 이 홀수 (n.testBit(0) == true)
                n = n.multiply(THREE).add(ONE);
            }
            termCount++;
        }
        System.out.println(termCount + " 번째 항의 값 : " + n);
        System.out.println("총 항의 개수 : " + termCount + " 개");
    }

}
