package com.nhnacademy.parkminsu.exercise9_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise9_1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Fomula fomula = bigInteger -> bigInteger;
            String str = inputData(br);
            BigInteger bigInteger = new BigInteger(inputData(br));
            calFactorial(fomula.apply(Factorial.calculate(bigInteger)));
            System.out.println(fomula.apply(Fibonacci.calculate(bigInteger)));

            while (true) {


                break;
            }
            while (true) {
                if (calFibonacci(br)) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String inputData(BufferedReader bufferedReader) throws IOException {
        String str = "";

        str = bufferedReader.readLine();

        return str;
    }

    public static boolean calFactorial(BigInteger bigInteger) {
        try {
            System.out.printf("\nfactorial(n)을 게산합니다.\nn값을 입력해주세요.\n");
            //BigInteger facNum = new BigInteger(br.readLine());
            System.out.println(bigInteger);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean calFibonacci(BufferedReader br) throws IOException {
        try {
            System.out.printf("\nfibonacci(n)을 게산합니다.\nn값을 입력해주세요.\n");
            BigInteger fiboNum = new BigInteger(br.readLine());
            System.out.printf("fibonacci(%s)의 값은 %s입니다.\n", fiboNum, Fibonacci.calculate(fiboNum));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
