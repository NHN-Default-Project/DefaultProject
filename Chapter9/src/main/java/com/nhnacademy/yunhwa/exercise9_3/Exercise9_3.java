package com.nhnacademy.yunhwa.exercise9_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.StringTokenizer;

public class Exercise9_3 {
    public static void main(String[] args) {

        int[] sizeAndRandomMax = setLinkedListSizeAndRandomMax();
        int size = sizeAndRandomMax[0];
        int randomMax = sizeAndRandomMax[1];

        LinkedList linkedList = makeRandomIntLinkedList(size, randomMax);
        System.out.println("--------원래 LinkedList--------");
        linkedList.printList();
        LinkedList reversedLinkedList = linkedList.reverseList();
        System.out.println("--------순서 정반대로 복사한 LinkedList--------");
        reversedLinkedList.printList();

    }

    public static int[] setLinkedListSizeAndRandomMax() {

        int size = 0;
        int randomMax = 0;

        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.print("만들려고 하는 LinkedList 의 크기, 랜덤값의 최댓값을 공백으로 구분하여 입력해주세요 : ");

                br.mark(10000000);
                String s = br.readLine();
                String[] split = s.split(" ");
                if (split.length != 2) {
                    throw new InputMismatchException();
                }
                size = Integer.parseInt(split[0]);
                randomMax = Integer.parseInt(split[1]);

                break;

            } catch (InputMismatchException e) {
                System.out.println("2개의 int 값이 아닌, 잘못된 값이 입력되었습니다. 다시 입력해주세요");
                try {
                    br.reset();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (IOException e) {
                System.out.println("IOException 발생! Input 과 OutPut 에 문제가 있습니다. 다시 시도해주세요");
                try {
                    br.reset();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (NoSuchElementException e) {
                System.out.println("null 이거나 이상한 값이 들어온 것 같습니다. 다시 시도해주세요");
            } catch (NumberFormatException e) {
                System.out.println("int 형으로 변환할 수 없는 값이 들어왔습니다. 다시 입력해주세요");
            }
        }

        return new int[]{size, randomMax};
    }

    public static LinkedList makeRandomIntLinkedList(int size, int randomMax) {
        LinkedList linkedList = new LinkedList();
        Random random = new Random();
        int randomInt;

        for (int i = 0; i < size; i++) {
            randomInt = random.nextInt(randomMax);
            linkedList.insertNode(randomInt);
        }

        return linkedList;
    }
}
