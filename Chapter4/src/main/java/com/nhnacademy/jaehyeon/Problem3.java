package com.nhnacademy.jaehyeon;

public class Problem3 {

    public static int diceNumber() {
        return (int) (Math.random() * 6) + 1;
    }

    public static void main(String[] args) {
        playDiceGame();
    }


    public static void playDiceGame() {
        int count = 0;
        while (true) {
            count++;
            int sum = diceNumber() + diceNumber();
            verifySumRange(sum);

            if (sum == 2) {
                break;
            }
        }
        System.out.println("뱀눈이 나올때까지 걸린 횟수 : " + count);
    }

    public static void verifySumRange(int sum) {
        if (2 > sum || sum > 12) {
            throw new IllegalArgumentException("숫자가 잘못 되었습니다.");
        }
    }


}

