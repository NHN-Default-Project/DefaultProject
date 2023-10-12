package com.nhnacademy.main.exercise8_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise8_2 {
    /**
     * 3.2.2 문제 확장판
     * 사용자로부터 양의 정수를 입력받아 BigInteger n으로 만들어주고
     * n을 수열의 첫 항으로 하고
     * 수열의 항이 1이 될 때까지
     * 다음 항의 값들은 홀수 일 경우 3n+1, 짝수 일 경우 n/2 해서
     * 완성된 수열과 수열의 항의 개수를 출력해주는 프로그램
     * */

    public static final BigInteger THREE = BigInteger.valueOf(3L);

    // 예제 수행 프로그램 main 메서드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BigInteger> bigIntegerList;

        BigInteger n = makeBigInteger(sc);
        bigIntegerList = makeSequence(n);
        printSequence(bigIntegerList);
        printNumberOfTerms(bigIntegerList);

        sc.close();
    }




    // 사용자로부터 양의 정수를 입력받는 메서드
    public static BigInteger makeBigInteger(Scanner sc) {
        BigInteger n;

        while (true) {
            try {
                System.out.print("N에서 시작하는 '3N+1' 수열을 만들기 위한 양의 정수 N 값을 입력해주세요 : ");
                String numStr = sc.nextLine().trim();
                n = new BigInteger(numStr); // 할당

                checkValidPositiveInteger(n);
                // 위에서 Exception 이 발생 안했다면
                break; // 탈출
            } catch (NumberFormatException e) {
                System.out.println("정수로 변환할 수 없는 값이 입력되었습니다. 다시 입력해주세요");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return n;
    }



    // 양의 정수가 맞는지 체크하는 내부 메서드 (아닐 때만 예외 던져짐)
    private static void checkValidPositiveInteger(BigInteger bigInteger) throws IllegalArgumentException {
        if (bigInteger.signum() == 0) {
            throw new IllegalArgumentException("0 이 입력되었습니다. 양의 정수로 입력을 다시 입력해주세요");
        } else if (bigInteger.signum() < 0) {
            throw new IllegalArgumentException("음의 정수가 음력되었습니다. 양의 정수로 다시 입력해주세요");
        }
    }



    // 수열의 첫 항이 n으로 시작해서 요구하는 수열을 만들어주는 메서드
    public static List<BigInteger> makeSequence(BigInteger n) {
        List<BigInteger> bigIntegerList = new ArrayList<>();
        // 양의 정수인 것들만 여기에 들어옴

        while (!n.equals(BigInteger.ONE)) { // 1이 아닐 때까지
            bigIntegerList.add(n); // 현재 값 추가
            n = calculationATermOfSequence(n); // 다음 값 계산
        }
        return bigIntegerList;
    }


    // 수열의 항의 값 하나 게산하는 내부 메서드 ( 홀수일 때 3n+1, 짝수일 때 n/2 )
    private static BigInteger calculationATermOfSequence(BigInteger bigInteger) {
        if (! bigInteger.testBit(0)) { // 짝수
            return bigInteger.divide(BigInteger.TWO);
        } else { // 홀수
            return bigInteger.multiply(THREE).add(BigInteger.ONE);
        }
    }


    // 수열을 출력하는 메서드
    public static void printSequence(List<BigInteger> bigIntegerList) {
        for (int i = 0; i < bigIntegerList.size(); i++) {
            System.out.printf("%d 번째 항의 값 : %f", (i + 1), bigIntegerList.get(i));
        }
    }


    // 수열의 항의 개수를 출력하는 메서드
    public static void printNumberOfTerms(List<BigInteger> bigIntegerList) {
        System.out.printf("총 항의 개수 : %d 개", bigIntegerList.size());
    }
}
