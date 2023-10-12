package com.nhnacademy.parkminsu.exercise9_3.generic;

import com.nhnacademy.parkminsu.exercise9_3.generic.factorial.FactorialLinkedList;
import com.nhnacademy.parkminsu.exercise9_3.generic.funcinterface.RandomNum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        ReversLinkedList<Integer> reversLinkedList = new ReversLinkedList();
        FactorialLinkedList<Integer> factorialLinkedList = new FactorialLinkedList();
        int inputData = 0;
//        Function<Random, Integer> creator = random -> random.nextInt(100); // java에서 제공하는 함수형 인터페이스
        RandomNum<Random, Integer> creator1 = random -> random.nextInt(100); // 만든 함수형 인터페이스
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("만들고 싶은 LinkedList의 size를 입력하세요");
            inputData = inputData(bufferedReader);
            isCheckNegativeNum(inputData);
            isCheckZero(inputData);

//            List<Integer> list = factorialLinkedList.createLinkedList(creator1, inputData); // java에서 제공한 함수형 인터페이스를 매개변수로 받은 메소드
            List<Integer> list = factorialLinkedList.createLinkedListCustomFuncInterface(creator1, inputData); // 만든 함수형 인터페이스를 매개변수로 받은 메소드
            System.out.println(list.toString());

            reversLinkedList.makeReverseLinkedList(reversLinkedList, list);
            System.out.println(reversLinkedList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


    }

    public static int inputData(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static void isCheckNegativeNum(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수를 입력하셨습니다");
        }
    }

    public static void isCheckZero(int num) {
        if (num == 0) {
            throw new NullPointerException("0을 입력해서 null값이 나옵니다.");
        }
    }

}
