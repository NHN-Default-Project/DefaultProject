package com.nhnacademy.jminsoo.exercise1;

import java.util.NoSuchElementException;
import java.util.Scanner;

//각 문자열의 첫 글자를 대문자로 변경하는 것을 의미한다.
//대문자로 표시된 문자열 버전을 표준 출력으로 print할 printCapitalized 서브루틴을 작성하라.
//사용자로부터 입력을 받는다. 
public class Exercise4_1 {
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
            result.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1)).append(" ");
        }

        result.deleteCharAt(str.length());

        System.out.println(result.toString());

    }

}
