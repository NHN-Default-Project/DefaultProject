package com.nhnacademy.Jminsoo.exercise2.backup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10_2 {
    public static void main(String[] args) {
        TreeSetApp treeSetApp = new TreeSetApp();

        System.out.println("입출력 공백 입력 시 종료");
        System.out.println("-------------------");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String input = br.readLine();
                if (input.isEmpty()) {
                    break;
                } else {
                    treeSetApp.readUserInputForSet(input);
                    treeSetApp.calculate();
                }
            } catch (IOException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
