package com.nhnacademy.gaeun.exercise08;

import java.util.Random;

public class QuizGame {
    Random random = new Random();
    int[] firstNums = new int[10];
    int[] secondNums = new int[10];
    int[] userAnswers = new int[10];
    static final int ROLL_NUM = 100;

    public int[] getFirstNum() {
        return firstNums;
    }

    public int[] getSecondNum() {
        return secondNums;
    }

    public int[] getAnswer() {
        return userAnswers;
    }


    QuizGame() {
        poseQuiz();
    }

    public void poseQuiz() {
        for (int i = 0; i < firstNums.length; i++) { //문제 출제
            this.firstNums[i] = random.nextInt(ROLL_NUM);
            this.secondNums[i] = random.nextInt(ROLL_NUM);
        }
    }

    public String[] administerQuiz() { //퀴즈 목록 관리
        String[] strings = new String[firstNums.length];
        for (int i = 0; i < firstNums.length; i++) {
            strings[i] = "[Quiz " + (i + 1) + "] " + getFirstNum()[i] + " + " + getSecondNum()[i] + " = ";
            userAnswers[i] = getFirstNum()[i] + getSecondNum()[i];
        }
        return strings;
    }

    public int gradQuiz(int[] inputAnswers) {
        int totalPoints = 0;
        for (int i = 0; i < getAnswer().length; i++) {
            if (getAnswer()[i] == inputAnswers[i]) {
                totalPoints += 10;
            }
        }
        return totalPoints;
    }
}