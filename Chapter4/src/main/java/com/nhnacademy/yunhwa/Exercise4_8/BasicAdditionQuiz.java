package com.nhnacademy.yunhwa.Exercise4_8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicAdditionQuiz {

    private int maxValidNum;
    private int questionsCount;

    static int[] firstNums;
    static int[] secondNums;
    static int[] userAnswers;

    public BasicAdditionQuiz(int questionsCount, int maxValidNum) {
        this.questionsCount = questionsCount;
        this.maxValidNum = maxValidNum;

        firstNums = new int[questionsCount];
        secondNums = new int[questionsCount];
        userAnswers = new int[questionsCount];

        for (int i = 0; i < questionsCount; i++) {
            firstNums[i] = getRandom();
            secondNums[i] = getRandom();
        }
    }

    public int getMaxValidNum() {
        return this.maxValidNum;
    }

    public int getQuestionsCount() {
        return this.questionsCount;
    }

    public int getRandom() {
        return (int) (maxValidNum * Math.random()) + 1;
    }

    public void askAllQuestions() {
        System.out.println("\n----------퀴즈를 시작합니다!-----------\n");
        System.out.println("주어지는 질문 " + getQuestionsCount() + "개를 잘 보고 답해주세요.\n");
        System.out.println("---------------------------------------\n");
        for (int i = 0; i < firstNums.length; i++) {
            System.out.println("질문 " + (i+1) + " : " + firstNums[i] + " + " + secondNums[i] + " ?");
        }
        System.out.println();
    }

    // 질문에 다 답변하는 메서드
    public void answerAllQuestions() {
        Scanner scanner = new Scanner(System.in);

        try (scanner) {
            System.out.println("------------답변을 시작합니다------------\n");
            for (int i = 0; i < userAnswers.length; i++) {
                
                System.out.print("질문 " + (i + 1) + " : " + firstNums[i] + " + " + secondNums[i] + " = ");
                userAnswers[i] = scanner.nextInt();

                // 사용자의 답이 정답인지 아닌지 판별
                if(isCorrectAnswer(userAnswers[i], firstNums[i], secondNums[i])) {
                    System.out.println("두둥, 정답입니다! 아시다시피, 답은 " + userAnswers[i] + "입니다.\n");
                } else {
                    System.out.println("틀렸습니다.. 정답은 " + getCorrectAnwer(firstNums[i], secondNums[i]) + " 였습니다.");
                    System.out.println("조금 더 분발해주세요!\n");
                }
            }
            System.out.println("------------답변이 끝났습니다------------");
        } catch (InputMismatchException e) {
            System.out.println("인풋 값이 잘못 들어왔습니다. 정수형 타입에 맞게 기입해주세요.");
        }
        
    }

    public boolean isCorrectAnswer(int userAnswer, int firstNum, int secondNum) {
        return userAnswer == getCorrectAnwer(firstNum, secondNum);
    }

    public int getCorrectAnwer(int firstNum, int secondNum) {
        return add(firstNum, secondNum);
    }

    public int add(int a, int b) {
        return a + b;
    }

    // 사용자 답변들 받아서 각 문제당 10점으로 계산하여 점수 리턴하는 메서드
    public int gradeQuiz() {
        int score = 0;

        for (int i = 0; i < userAnswers.length; i++) {
            if (isCorrectAnswer(userAnswers[i], firstNums[i], secondNums[i])) {
                score += 10;
            }
        }

        return score;
    }
    
    public void printScore(int score) {
        System.out.println("\n---------퀴즈 결과, 총점 " + score + " 입니다--------\n");
    }




}
