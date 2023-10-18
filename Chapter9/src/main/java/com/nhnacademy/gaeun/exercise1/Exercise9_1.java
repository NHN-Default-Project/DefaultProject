package com.nhnacademy.gaeun.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.function.Predicate;
/*
* https://math.hws.edu/javanotes/c9/exercises.html
* Write recursive functions to compute factorial(N) and fibonacci(N)
* for a given non-negative integer N, and write a main() routine to test your functions.
* Consider using the BigInteger class
 */

public class Exercise9_1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while(true) {
                if (isSetFactorialVal(br)) {
                    break;
                }
            }
            System.out.println("===================================");
            while(true) {
                if(isSetFibonacciVal(br)) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isSetFactorialVal(BufferedReader br) throws IOException {
        try {
            System.out.printf("\nfactorial(n)을 게산합니다.\nn값을 입력해주세요.\n");
            BigInteger facNum = new BigInteger(br.readLine());
            System.out.printf("factorial(%s)의 값은 %s입니다.\n", facNum, Factorial.calculate(facNum));
            System.out.printf("factorial(%s)의 값은 %s입니다.\n", facNum, Fomula.factorial(facNum));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (NegativeNumberException e) {

        }
        return true;
    }

    public static boolean isSetFibonacciVal(BufferedReader br) throws IOException {
        try{
            System.out.printf("\nfibonacci(n)을 게산합니다.\nn값을 입력해주세요.\n");
            BigInteger fiboNum = new BigInteger(br.readLine());
            System.out.printf("fibonacci(%s)의 값은 %s입니다.\n", fiboNum, Fibonacci.calculate(fiboNum));
            System.out.printf("fibonacci(%s)의 값은 %s입니다.\n", fiboNum, Fomula.fibonacci(fiboNum));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (NegativeNumberException e) {

        }
        return true;
    }

}
