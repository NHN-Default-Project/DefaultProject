package com.nhnacademy.yunhwa.Exercise3_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise3_4 {
    // 입력 텍스트의 한 줄을 읽고 이를 단어로 나누는 프로그램
    // 단어는 한 줄에 하나씩 출력
    // 단어는 일련의 문자들로 정의
    // 문자가 아닌 입력의 모든 문자는 삭제

    // ex ) He said, "That's not a good idea."
    // He
    // said
    // That's
    // not
    // a
    // good
    // idea

    // 문자'문자 -> 단어의 일부로 간주
    //  (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')  : 문자가 문자인지 테스트할 때 사용
    //  Character.isLetter(ch) 호출이 더 나은 방법 : 문자라면 true/ 문자가 아니라면 false 리턴

    public static void main(String[] args) {
        System.out.println("영어 알파벳과 특수문자로 이루어진 문장 한 줄을 입력해주세요");
        System.out.print(": ");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        List<String> tokenizedLetters = tokenizerByLetter(line);

        for (String token : tokenizedLetters) {
            for (int i = 0; i < token.length(); i++) {
                System.out.print(token.charAt(i));
            } 
            System.out.println();
            
        }

        sc.close();
        
    }

    public static boolean isLetter(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }

    public static List<String> tokenizerByLetter(String line) {
        List<String> tokenizedLetters = new ArrayList<>();
        char[] lineCharArr = line.toCharArray();

        List<Character> word = new ArrayList<>();

        for (int i = 0; i < lineCharArr.length; i++) {
            if (isLetter(lineCharArr[i])) {
                word.add(lineCharArr[i]);
            } else if (lineCharArr[i] == '\'') {
                if (i - 1 >= 0 && i + 1 < lineCharArr.length) {
                    if (isLetter(lineCharArr[i-1]) && isLetter(lineCharArr[i+1])) {
                        word.add(lineCharArr[i]);
                    }
                }
            }
            else {
                if (!word.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (char c : word) {
                        sb.append(c);
                    }
                    tokenizedLetters.add(sb.toString());
                    word.clear();
                }
            }
        }

        return tokenizedLetters;
    }
}
