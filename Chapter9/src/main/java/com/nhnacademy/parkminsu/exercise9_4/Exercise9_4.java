package com.nhnacademy.parkminsu.exercise9_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9_4 {
    /**
     * List를 만들고 Queue 자료구조를 이용하여 print하는 문제
     * https://math.hws.edu/javanotes/c9/ex4-ans.html
     */
    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        int listSize = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("생성할 노드의 갯수를 입력해주세요");
            listSize = Integer.parseInt(inputData(bufferedReader));
            System.out.println("노드에 들어갈 데이터를 입력해주세요");
            inputDataToList(bufferedReader, binarySortTree, listSize);
            System.out.println("Queue로 출력한 결과: ");
            binarySortTree.print();

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String inputData(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine();
    }

    public static void inputDataToList(BufferedReader br, BinarySortTree binarySortTree, int size) throws IOException {
        if (binarySortTree.size() == size) {
            return;
        }
        binarySortTree.add(inputData(br));
        inputDataToList(br, binarySortTree, size);
    }

}
