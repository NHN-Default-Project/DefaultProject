package com.nhnacademy.parkminsu.exercise9_3;

import com.nhnacademy.parkminsu.exercise9_3.factorial.FactorialLinkedList;
import com.nhnacademy.parkminsu.exercise9_3.funcinterface.RandomNum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Main {
    // TODO 내일 와서 Reverse 부분 고치기
    public static void main(String[] args) {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList();
        FactorialLinkedList<Integer> factorialLinkedList = new FactorialLinkedList();
        int inputData = 0;
        RandomNum<Random, Integer> creator1 = random -> random.nextInt(100); // 만든 함수형 인터페이스
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("만들고 싶은 LinkedList의 size를 입력하세요(1개 이상)");
            inputData = inputData(bufferedReader);// 데이터 입력
            checkNegativeNum(inputData);
            checkListNull(inputData);

            customLinkedList = factorialLinkedList.createLinkedList(creator1, inputData); // 만든 함수형 인터페이스를 매개변수로 받은 메소드
            System.out.println("기존 리스트");
            System.out.println(customLinkedList.toString());

            CustomLinkedList<Integer> reversedList = customLinkedList.reverse();
            System.out.println("역순 리스트");
            System.out.println(reversedList.toString());

        } catch (IOException | NullDataException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int inputData(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static void checkNegativeNum(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수를 입력하셨습니다");
        }
    }

    public static void checkListNull(int num) throws NullDataException {
        if (num == 0) {
            throw new NullDataException("0을 입력해서 null값이 나옵니다.");
        }
    }

}
