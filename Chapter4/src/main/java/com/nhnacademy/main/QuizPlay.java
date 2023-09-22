package com.nhnacademy.main;

import java.util.Scanner;

public class QuizPlay {

    public void playQuiz(){
        Scanner scanner = new Scanner(System.in);

        int questionSize = selectQuestionNumber(scanner);
        Quiz quiz = new Quiz(questionSize);

        int correctNumber = printQuiz(quiz, questionSize, scanner);

        System.out.printf("최종 점수는 %d점 입니다.", calculatorScore(questionSize, correctNumber));
        scanner.close();
    }

    private int selectQuestionNumber(Scanner scanner) {
        String selectNumber;
        while (true) {
            selectNumber = inputNumber(scanner);
            if (!isNumber(selectNumber)) {
                System.out.println("1이상의 값만 입력하세요");
            } else {
                break;
            }
        }
        return Integer.parseInt(selectNumber);
    }

    private String inputNumber(Scanner scanner) {
        System.out.println("문제를 몇개 생성 하시겠습니까?");
        return scanner.nextLine();
    }

    private boolean isNumber(String number) {
        return 1 <= Integer.parseInt(number);
    }

    private int printQuiz(Quiz quiz, int size, Scanner scanner) {

        int[] answerNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            int firstNumber = quiz.getFirstNumbers()[i];
            int secondNumber = quiz.getSecondNumbers()[i];

            System.out.printf("%d + %d = ", firstNumber, secondNumber);
            answerNumbers[i] = firstNumber + secondNumber;
            quiz.getUserAnswers()[i] = scanner.nextInt();
        }

        return checkAnswer(quiz, answerNumbers);
    }

    private int checkAnswer(Quiz quiz, int[] answer) {
        int countCorrect = 0;
        for (int i = 0; i < answer.length; i++) {
            if (quiz.getUserAnswers()[i] == answer[i]) {
                countCorrect++;
            }
        }

        return countCorrect;
    }

    private int calculatorScore(int size, int correctNumber) {
        return (100 / size) * correctNumber;
    }

}



