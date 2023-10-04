package org.example.jaehyeon.design_program;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class Gcd {
    private final int[] numbers;
    private int gcd;

    public Gcd(int[] numbers) {
        preConditionNumber(numbers);
        this.numbers = numbers;
        getNumbersGcd();
    }

    public int getGcd() {
        return gcd;
    }

    private void getNumbersGcd() {
        int num = this.numbers[0];
        for (int i = 1; i < this.numbers.length; i++) {
            num = calculateGcd(num, this.numbers[i]);
        }
        this.gcd = num;
    }

    private int calculateGcd(int a, int b) {
        if (a < b) {
            int swap = b;
            b = a;
            a = swap;
        }
        if (b == 0) {
            return a;
        }
        return calculateGcd(b, a % b);

    }

    private void preConditionNumber(int[] numbers) {
        for (int number : numbers) {
            if (number <= 0) {
                throw new IllegalArgumentException("0보다 큰 숫자만 있어야 합니다");
            }
        }
    }


}
