package com.nhnacademy.Jminsoo.exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10_2 {
    public static void main(String[] args) {
        TreeSets treeSets = new TreeSets();

        System.out.println("입출력 공백 입력 시 종료");
        System.out.println("-------------------");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String input = br.readLine();
                if (input.isEmpty()) {
                    break;
                } else {
                    treeSets.stringToSet(input);
                    treeSets.calculate();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
