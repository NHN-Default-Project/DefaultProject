package com.nhnacademy.parkminsu.exercise9_1.singletonpattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9_1 {
    public static void main(String[] args) {
        try {
            String str = "10";
            Factorial factorial = Factorial.getInstance(str);
            Fibonacci fibonacci = Fibonacci.getInstance(str);
            System.out.println(factorial.apply(factorial.getNum()));
            System.out.println(fibonacci.apply(factorial.getNum()));

            str = "20";


//        } catch (IOException e) {
//            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
    }


    public static String inputData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }


}
