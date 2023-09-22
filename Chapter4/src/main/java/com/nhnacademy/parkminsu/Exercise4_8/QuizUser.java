package com.nhnacademy.parkminsu.Exercise4_8;

import java.util.HashMap;
import java.util.Map;

public class QuizUser {
    private Map<Integer, Integer> answerList;

    public QuizUser() {
        this.answerList = new HashMap<>();
    }

    public Map<Integer, Integer> getAnswerList() {
        return answerList;
    }

    public void writeAnswer(int questionNum, int answer) {
        this.answerList.put(questionNum, answer);
    }
}
