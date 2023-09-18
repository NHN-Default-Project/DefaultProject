package com.nhnacademy.gaeun.exercise07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> lines = Files
                    .readAllLines(Paths.get("/Users/kaeun/study/23.09.12(tue)/Chapter2/Exercise7/testdata.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int grade = 0;
        for (int i = 1; i < lines.size(); i++) {
            grade += Integer.parseInt(lines.get(i));
        }
        try {
            Path path = Paths.get("/Users/kaeun/study/23.09.12(tue)/Chapter2/Exercise7/testdata.txt");
            Files.write(path, String.valueOf(grade).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
