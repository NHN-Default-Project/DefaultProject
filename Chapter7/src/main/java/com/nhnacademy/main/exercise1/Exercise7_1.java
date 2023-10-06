package com.nhnacademy.main.exercise1;

import java.util.*;

/*
 * https://math.hws.edu/javanotes/c7/exercises.html
 * Write a subroutine that creates an ArrayList containing several different random integers in the range from 1 up to some specified maximum.
 * The number of integers and the maximum allowed value for the integers should be parameters to the subroutine. Write a main() routine to test your subroutine.
 */
public class Exercise7_1 {
    private static final int INT_NUM = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("n을 최댓값으로 하는 30개 원소를 가진 random 배열을 생성합니다.");
                System.out.println("n값을 입력해주세요.");
                int max = scanner.nextInt();
                if (max <= 0) {
                    System.out.println("음수값이 입력되었습니다. 다시 입력해주세요!");
                    continue;
                }
                    for (int element : list(INT_NUM, max)) {
                        System.out.println(element);
                    }
                break;
            } catch (InputMismatchException e) {
                System.out.println("정수값을 입력해주세요!");
            } catch (NoSuchElementException e) {
                System.out.println("입력이 부족합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("Scanner가 이미 닫혀 있습니다. ");
            }
            scanner.nextLine();
        }
        scanner.close();
    }

    public static List<Integer> list(int intNumber, int max) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < intNumber; i++) {
            list.add(getRandomNumber(max));
        }

        return list;
    }

    public static int getRandomNumber(int max) {
        return (int) (Math.random() * max) + 1;
    }
}

