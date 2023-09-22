package com.nhnacademy.yunhwa.Exercise3_1;


public class Exercise3_1 {
    // 주사위 2개를 몇 번이나 굴려야 둘 다 1이 나올까?
    // 실험을 시뮬레이션 하는 프로그램
    // 주사위가 뱀의 눈으로 나오기 전에 굴린 횟수를 보고

    public static void main(String[] args) {
        int size = 2; // 주사위  2개

        System.out.println("뱀의 눈이 되기까지 시행된 굴린 횟수 : " + makeSnakeEyesCount(size));
        
    }

    public static int getDiceNumber() {
        return (int) (Math.random() * 6) + 1;
    }

    public static int makeSnakeEyesCount(int size) {
        int[] dices = new int[size];

        int rollCount = 0;

        while ( (! (dices[0] == 1 && dices[1] == 1) ) ) {
            dices = new int[size];

            for (int i = 0; i < dices.length; i++) {
                dices[i] = getDiceNumber();
            } 
            
            rollCount++;
        }

        return rollCount;
    }

}