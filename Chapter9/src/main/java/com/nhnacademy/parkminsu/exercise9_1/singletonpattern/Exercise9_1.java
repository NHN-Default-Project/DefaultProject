package com.nhnacademy.parkminsu.exercise9_1.singletonpattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9_1 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = inputData(bufferedReader);
            Factorial factorial = Factorial.getInstance(str);
            Fibonacci fibonacci = Fibonacci.getInstance(str);
            System.out.println(fibonacci.apply(factorial.getNum()));

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    public static String inputData(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine();
    }


}
