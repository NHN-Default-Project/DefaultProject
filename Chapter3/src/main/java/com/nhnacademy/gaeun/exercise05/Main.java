package com.nhnacademy.gaeun.exercise05;

import java.nio.file.Path;
import java.util.Scanner;

import textio.TextIO;

public class Main {
    public static void main(String[] args) {
        double money = 0;
        Scanner scanner = new Scanner(Path.of("/Users/kaeun/LeeGaeun/Chapter3/Exercise5/sales.dat"));

        while(TextIO.eof() == false) {
            TextIO.getWord();
            try {
                money += Double.parseDouble(TextIO.getWord());
            }catch {
                throw new ArithmeticException();
            }
            
        }
    }
}
