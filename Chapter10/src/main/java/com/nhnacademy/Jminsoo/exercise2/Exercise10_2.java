package com.nhnacademy.Jminsoo.exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10_2 {
    public static void main(String[] args) {
        TreeSets treeSets = new TreeSets();

        System.out.println("입출력 공백 입력 시 종료");
        System.out.println("-------------------");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String input = br.readLine();
                if (input.isEmpty()) {
                    break;
                } else {
                    treeSets.readUserInputForMakeSet(input);
                    treeSets.calculate();
                }
            } catch (IOException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
