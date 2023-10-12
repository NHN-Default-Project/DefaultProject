package org.example.yunhwa;

public class Math {

    public static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }

    public static int max(int a, int b) {
        if (a >= b) return a;
        else return b;
    }

    public static int factorial(int number) {

        switch (number) {
            case 0:
                return 1;
            default:
                return number * factorial(number - 1);
        }

    }
}
