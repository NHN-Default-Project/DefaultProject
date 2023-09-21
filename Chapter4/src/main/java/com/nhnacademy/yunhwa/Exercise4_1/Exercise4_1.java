package com.nhnacademy.yunhwa.Exercise4_1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise4_1 {
    // 문자열을 대문자로 표시한다는 것의 의미 : 문자열의 각 단어의 첫 글자를 대문자로 변경(아직 대문자가 아닌 경우)
    // Now is the time to act! -> Now Is The Time To Act!
    // printCapitalized 서브루틴 작성
    // 인쇄할 문자열은 서브루틴에 대한 파라미터여야 함.
    // 사용자로부터 한 줄의 입력을 받아서 서브루틴을 적용하는 main() 루틴 사용하여 위의 서브루틴 테스트 하기.

    // 문자열에서 다른 문자가 바로 앞에 나오지 않는 경우 해당 문자는 단어의 첫 번째 문자
    // boolean return value 의 Character.isLetter(char) 활용해서 파라미터가 문자인지 판별하는데 사용할 수 있음.
    // char return value의 Character.toUpperCase(char) 활용해서 특정 문자를 파라미터로 입력받아 해당 문자를 대문자로 변환해 반환
    // 문자가 아니라면 파라미터를 복사해서 그냥 리턴

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            System.out.println("대문자로 표시하고자 하는 문자열을 한 줄 입력해주세요");
            System.out.print(" : ");

            String input = sc.nextLine().trim();

            printCapitalized(input);
        } catch ( NoSuchElementException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printCapitalized(String line) {
        StringBuilder sb = new StringBuilder(line);
        char[] charsOfLine = line.toCharArray();

        for (int i = 0; i < charsOfLine.length; i++) {

            if(Character.isLetter(charsOfLine[i])) {
                if (i == 0 || charsOfLine[i-1] == ' ') {
                    // 현재 위치가 대문자로 바꿔야할 위치
                    sb.replace(i, i+1, String.valueOf(Character.toUpperCase(charsOfLine[i])));
                }
            }
        }

        System.out.println(sb.toString());
        
    }

}
