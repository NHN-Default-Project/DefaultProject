package com.nhnacademy.main.excercise1;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Character가 제공하는 메서드들을 활용하는 문제
 */
public class Excercise4_1 {
    public static void main(String[] args) {


        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();
            printCapitalized(str);
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("잘못된 값이 입력되었습니다.");
            throw new RuntimeException(e);
        }


    }

    private static void printCapitalized(String str) {
        StringBuilder result = new StringBuilder();
        String[] strArray = str.split(" ");

        for (String word : strArray) {
            if (Character.isLetter(word.charAt(0))) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1)).append(" ");
            }
        }

        result.deleteCharAt(str.length());

        System.out.println(result.toString());

    }
}
