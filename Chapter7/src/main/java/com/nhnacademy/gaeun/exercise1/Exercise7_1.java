package com.nhnacademy.gaeun.exercise1;

import java.util.*;

/*
* https://math.hws.edu/javanotes/c7/exercises.html
* exercise7_1
* 서브루틴 작성: 1~지정된 최대값까지의 임의의 정수를 포함하는 ArrayList생성
* 매개변수: 입력받을 정수의 수, 최댓값
*/
public class Exercise7_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("n의 최대값을 갖는 랜덤 ArrayList를 반환해드립니다.");
        System.out.println("원하시는 정수의 개수와 최대값을 입력해주세요. ex: 10 100");
        while(true) {
            try {
                int intNum = scanner.nextInt();
                int maxVal = scanner.nextInt();

                System.out.println(makeArrayList(intNum, maxVal));
                break;
            } catch(InputMismatchException ime) {
                System.out.println("정수값을 입력해주세요!");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("정수값을 입력해주세요!");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static List makeArrayList(int intNum, int maxVal) {
        Random random = new Random();
        List randomValues = new ArrayList(intNum);
        for(int i = 0; i < intNum; i++) {
            randomValues.add(random.nextInt(maxVal) + 1);
        }
        return randomValues;
    }
}
