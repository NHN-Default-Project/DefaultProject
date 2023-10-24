package com.nhnacademy.yunhwa.exercise10_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class ConsoleUserInterface { // 유저와 접한 부분을 가지고 있는 클래스

    public void beforeInputPrintInformation() {
        System.out.println();
        System.out.println("==============================================================");
        System.out.println("0 이상의 정수 집합 2개를 만들고 두 개의 합집합, 교집합, 차집합을 구하려고 합니다.");
        System.out.println("0 이상의 정수 집합 2개와 연산자를 아래의 형식에 맞게 입력해주세요 \n");
        System.out.println("------------------------------------------------------------");
        System.out.println("      [입 력 형 식 : 쉼표는 필수, 공백은 선택적]                  \n");
        System.out.println(" 집합 입력 형식 :  [1,2,3]   or   [17, 42, 9, 53, 108]        \n");
        System.out.println(" 전체 입력 형식 :  [1, 2, 3] * [3,  5,  7]                    \n");
        System.out.println("------------------------------------------------------------");
        System.out.println("위의 전체 입력 형식에 맞게 입력해주세요 [ 연산자 : + - * ]");
    }

    public String userInput(BufferedReader br) throws IOException {
        return br.readLine();
    }

    public boolean isUserWantToBeContinued(BufferedReader br) throws IOException {
        System.out.println("계속 입력하시겠습니까? NO 입력하시면 종료 아니면 TO BE CONTINUED ");
        String continueFlag = br.readLine().trim().toLowerCase();
        if (continueFlag.equals("no")) {
            return false;
        }
        return true;
    }
}