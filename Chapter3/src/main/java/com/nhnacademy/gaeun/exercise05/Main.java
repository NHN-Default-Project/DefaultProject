package com.nhnacademy.gaeun.exercise05;

import com.nhnacademy.parkminsu.textio.TextIO;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        double money = 0;
        Scanner scanner = new Scanner(Path.of("/Users/kaeun/LeeGaeun/Chapter3/Exercise5/sales.dat"));

        while (TextIO.eof() == false) {
            TextIO.getWord();
            try {
                money += Double.parseDouble(TextIO.getWord());
            } catch (ArithmeticException e) {
                throw new ArithmeticException();
            } finally {
                scanner.close();
            }

        }
    }
}
