package com.nhnacademy.parkminsu.Exercise4_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz {
    private Map<Integer, List<Question>> problemList;
    private Map<Integer, Integer> answerList;
    private final int questionNum = 10;
    private final int createNumRange = 10;

    public Quiz() {

        this.problemList = new HashMap<>();
        this.answerList = new HashMap<>();
    }

    public int randomNumCreate() {
        return (int) (Math.random() * this.createNumRange);
    }

    public List<Question> addQuestion(int firstNum, int secondNum) {
        List<Question> questionNumList = new ArrayList<>();
        questionNumList.add(new Question(firstNum, secondNum));
        return questionNumList;
    }

    public void createQuestion() {
        int firstNum;
        int secondNum;
        for (int i = 1; i <= this.questionNum; i++) {
            firstNum = randomNumCreate();
            secondNum = randomNumCreate();
            problemList.put(i, addQuestion(firstNum, secondNum));
            answerList.put(i, firstNum + secondNum);
        }
    }

    public Map<Integer, Integer> getAnswerList() {
        return answerList;
    }

    public Map<Integer, List<Question>> getProblemList() {
        return problemList;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public int getCreateNumRange() {
        return createNumRange;
    }

    public static class Question {
        private final int firstNum;
        private final int secondNum;

        Question(int firstNum, int secondNum) {
            this.firstNum = firstNum;
            this.secondNum = secondNum;

        }

        public int getFirstNum() {
            return firstNum;
        }

        public int getSecondNum() {
            return secondNum;
        }

        @Override
        public String toString() {
            return "firstNum=" + firstNum +
                    ", secondNum=" + secondNum + "\n";
        }
    }
}
