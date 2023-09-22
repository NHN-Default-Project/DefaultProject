package com.nhnacademy.parkminsu.Exercise2_7;

import java.nio.file.Path;
import java.util.Scanner;

public class Exercise2_7 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Path.of("/Users/minsu/Desktop/JavaFxProgram/testdata.txt"))) {
            int score = 0;
            int cnt = 0;
            while (scanner.hasNextLine()) {
                if (scanner.hasNextInt()) {
                    int num = scanner.nextInt();
                    if (num <= 100 && num >= 0) {
                        score += num;
                        cnt++;
                    }
                }

            }
            System.out.println(score / cnt);
        } catch (Exception e) {
            System.out.println("에러");
        }

    }
}
