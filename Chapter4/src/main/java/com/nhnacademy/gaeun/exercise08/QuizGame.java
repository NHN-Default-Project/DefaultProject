package com.nhnacademy.gaeun.exercise08;

import java.util.Random;

public class QuizGame {
    static Random random = new Random();
    static int[] firstNums = new int[10];
    static int[] secondNums = new int[10];
    static int[] userAnswers = new int[10];

    public static int[] getFirstNum() {
        return firstNums;
    }

    public static int[] getSecondNum() {
        return secondNums;
    }

    public static int[] getAnswer() {
        return userAnswers;
    }

    QuizGame() {
        poseQuiz();
    }

    public void poseQuiz() {
        for (int i = 0; i < firstNums.length; i++) { //문제 출제
            this.firstNums[i] = random.nextInt(100);
            this.secondNums[i] = random.nextInt(100);
        }
    }

    public static String[] administerQuiz() { //퀴즈 목록 관리
        String[] strings = new String[firstNums.length];
        for (int i = 0; i < firstNums.length; i++) {
            strings[i] = "[Quiz " + (i + 1) + "] " + getFirstNum()[i] + " + " + getSecondNum()[i] + " = ";
            userAnswers[i] = getFirstNum()[i] + getSecondNum()[i];
        }
        return strings;
    }

    public static int gradQuiz(int[] inputAnswers) {
        int totalPoints = 0;
        for (int i = 0; i < getAnswer().length; i++) {
            if (getAnswer()[i] == inputAnswers[i]) {
                totalPoints += 10;
            }
        }
        return totalPoints;
    }
}
