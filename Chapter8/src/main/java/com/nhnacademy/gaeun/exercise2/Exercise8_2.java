package com.nhnacademy.gaeun.exercise2;

import java.math.BigInteger;
import java.util.Scanner;

/*
* https://math.hws.edu/javanotes/c8/exercises.html
* java.math.BigInteger 클래스의 사용
* 기존의 int type은 32비트로 제한되어 있어 너무 큰 정수는 저장할 수 없다는 단점이 있다.
* java.math.BigInteger 클래스를 사용하여 큰 정수를 처리하고 3N+1 시퀀스를 계산하는 프로그램 작성
* 동작: 사용자가 입력한 숫자를 받아 3N + 1 시퀀스 계산을 출력
* 에러 처리: 유효하지 않는 숫자 입력
* 종료: 사용자가 빈 줄을 입력
 */
public class Exercise8_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while(true) {
            try {
                System.out.println("Input BigInteger");
                System.out.println("If you wish to exit, please press enter");
                String inputNum = scanner.nextLine();
                if(inputNum.equals("")) {
                    break;
                }
                BigInteger bigInteger = new BigInteger(inputNum);
                if(bigInteger.compareTo(new BigInteger("0"))==-1 || bigInteger.compareTo(new BigInteger("0"))==-0) {
                    throw new IllegalArgumentException();
                }
                while(!bigInteger.equals(new BigInteger("1"))) {
                    bigInteger = collatz(bigInteger);
                    count++;
                }

                System.out.println("collatz: " + count);
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("유효하지 않은 숫자입니다!");
            } catch (IllegalArgumentException e) {
                System.out.println("0보다 큰 숫자를 입력해주세요!");
            }
        }
        scanner.close();
    }
    public static BigInteger collatz(BigInteger value) {
        if(!value.testBit(0)) {
            return value.divide(new BigInteger("2"));
        } else {
            return value.multiply(new BigInteger("3")).add(new BigInteger("1"));
        }
    }
}
