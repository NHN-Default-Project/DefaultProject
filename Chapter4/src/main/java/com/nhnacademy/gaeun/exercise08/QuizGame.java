package com.nhnacademy.gaeun.exercise08;

import java.util.Random;

public class QuizGame {
    static Random random = new Random();
    static int[] firstNum = new int[10];
    static int[] secondNum = new int[10];
    static int[] answer = new int[10];

    public static int[] getFirstNum() {
        return firstNum;
    }

    public static int[] getSecondNum() {
        return secondNum;
    }

    public static int[] getanswer() {
        return answer;
    }

    QuizGame() {
        poseQuiz();
    }

    public static void poseQuiz() {
        for (int i = 0; i < firstNum.length; i++) { //문제 출제
            firstNum[i] = random.nextInt(100);
            secondNum[i] = random.nextInt(100);
        }
    }

    public static String[] administerQuiz() { //퀴즈 목록 관리
        String[] strings = new String[firstNum.length];
        for (int i = 0; i < firstNum.length; i++) {
            strings[i] = "[Quiz " + (i + 1) + "] " + getFirstNum()[i] + " + " + getSecondNum()[i] + " = ";
            answer[i] = getFirstNum()[i] + getSecondNum()[i];
        }
        return strings;
    }

    public static int gradQuiz(int[] inputAnswers) {
        int totalPoints = 0;
        for (int i = 0; i < getanswer().length; i++) {
            if (getanswer()[i] == inputAnswers[i]) {
                totalPoints += 10;
            }
        }
        return totalPoints;
    }
}
