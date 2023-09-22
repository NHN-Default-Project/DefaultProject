package com.nhnacademy.yunhwa.Exercise4_3;

public class Dice {

    private int totalEyesNum; // 주사위 총 눈 수 (몇 면체인지)
//    private int[] diceNums; // 주사위의 모든 눈들 (1부터 주사위 총 눈 수까지 모두) (주사위라는 물체가 존재하기 위한 요소)
    private int currentEye; // 한 번 던진 후, 현재 면의 눈 (1부터 주사위 총 눈 수까지 중 택1)

    // 생성자 : 몇 면체인지 파라미터로 들어오면, 필드에 대입해주고, 주사위의 모든 눈들도 세팅해주기
    public Dice(int totalEyesNum) {

        this.totalEyesNum = totalEyesNum;

//        diceNums = new int[totalEyesNum];
//        for (int i = 0; i < diceNums.length; i++) {
//            diceNums[i] = i + 1;
//        }
    }

    // 주사위 한 번 던지는 행위
    public void rollDice() {
        this.currentEye = (int) (Math.random() * totalEyesNum) + 1;
    }

    // 몇 면체인지 리턴해주는 게터
    public int getTotalEyesNum() {
        return this.totalEyesNum;
    }
    
    // 현재 눈 리턴해주는 게터
    public int getCurrentEye() {
        return this.currentEye;
    }

}
