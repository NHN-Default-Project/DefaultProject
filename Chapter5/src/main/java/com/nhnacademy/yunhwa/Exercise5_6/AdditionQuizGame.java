package com.nhnacademy.yunhwa.Exercise5_6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AdditionQuizGame {
    private List<AdditionQuestion> questions;
    private int questionsCount;
    private int[] userAnswers;


    public AdditionQuizGame(int questionsCount) {
        this.userAnswers = new int[questionsCount];
        this.questions = new ArrayList<>(questionsCount);
        this.questionsCount = questionsCount;
        for (int i = 0; i < this.questionsCount; i++) {
            this.questions.add(new AdditionQuestion());
        }
    }

    public int getQuestionsCount() {
        return this.questionsCount;
    }

    public void askAllQuestions() {
        System.out.println("\n----------퀴즈를 시작합니다!-----------\n");
        System.out.println("주어지는 질문 " + getQuestionsCount() + "개를 잘 보고 답해주세요.\n");
        System.out.println("---------------------------------------\n");
        for (int i = 0; i < getQuestionsCount(); i++) {
            System.out.println(questions.get(i).getQuestion());
        }
        System.out.println();
    }

    // 질문에 다 답변하는 메서드
    public void answerAllQuestions(Scanner scanner) {

        try (scanner) {
            System.out.println("------------답변을 시작합니다------------\n");
            for (int i = 0; i < getQuestionsCount(); i++) {

                System.out.println(questions.get(i).getQuestion());
                System.out.print(" = ");
                userAnswers[i] = scanner.nextInt();

                // 사용자의 답이 정답인지 아닌지 판별
                if (userAnswers[i] == questions.get(i).getCorrectAnswer()) {
                    System.out.println("두둥, 정답입니다! 아시다시피, 답은 " + userAnswers[i] + "입니다.\n");
                } else {
                    System.out.println("틀렸습니다.. 정답은 " + questions.get(i).getCorrectAnswer() + " 였습니다.");
                    System.out.println("조금 더 분발해주세요!\n");
                }
            }
            System.out.println("------------답변이 끝났습니다------------");
        } catch (InputMismatchException e) {
            System.out.println("인풋 값이 잘못 들어왔습니다. 정수형 타입에 맞게 기입해주세요.");
        }

    }

    // 사용자 답변들 받아서 각 문제당 10점으로 계산하여 점수 리턴하는 메서드
    public int gradeQuiz() {
        int score = 0;

        for (int i = 0; i < userAnswers.length; i++) {
            if (userAnswers[i] == questions.get(i).getCorrectAnswer()) {
                score += 10;
            }
        }

        return score;
    }

    public void printScore(int score) {
        System.out.println("\n---------퀴즈 결과, 총점 " + score + " 입니다--------\n");
    }
}
