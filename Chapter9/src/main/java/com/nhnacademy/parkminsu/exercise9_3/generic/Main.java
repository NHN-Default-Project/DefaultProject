package com.nhnacademy.parkminsu.exercise9_3.generic;

import com.nhnacademy.parkminsu.exercise9_3.generic.factorial.FactorialLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        ReversLinkedList<Integer> reversLinkedList = new ReversLinkedList();
        FactorialLinkedList<Integer> factorialLinkedList = new FactorialLinkedList();
        int inputData = 0;
        Function<Random, Integer> creator = random -> random.nextInt(100);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("만들고 싶은 LinkedList의 size를 입력하세요");
            inputData = inputData(bufferedReader);

            List<Integer> list = factorialLinkedList.createLinkedList(creator, inputData);
            System.out.println(list.toString());

            reversLinkedList.makeReverseLinkedList(reversLinkedList, list);
            System.out.println(reversLinkedList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }


    }

    public static int inputData(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }


}
