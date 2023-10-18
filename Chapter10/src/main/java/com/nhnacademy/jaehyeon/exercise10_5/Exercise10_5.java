package com.nhnacademy.jaehyeon.exercise10_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise10_5 {

    public static void main(String[] args) {
        System.out.println("학생 수: " + studentNumber());
        System.out.println("학생들의 평균 점수: " + calculateStudentAverageScore());
        System.out.println("A학점을 받은 학생 수: " + scoreLessThan70());
        System.out.println("score가 70미만인 학생들 리스트 생성: ");
        printScoreLessThan70Student();
        System.out.println("lastName을 기준으로 정렬");
        printSortFirstName();
        System.out.println("score을 기준으로 정렬");
        printSortScore();
    }

    private static ScoreInfo[] scoreData = new ScoreInfo[] {
            new ScoreInfo("Smith", "John", 70),
            new ScoreInfo("Doe", "Mary", 85),
            new ScoreInfo("Page", "Alice", 82),
            new ScoreInfo("Cooper", "Jill", 97),
            new ScoreInfo("Flintstone", "Fred", 66),
            new ScoreInfo("Rubble", "Barney", 80),
            new ScoreInfo("Smith", "Judy", 48),
            new ScoreInfo("Dean", "James", 90),
            new ScoreInfo("Russ", "Joe", 55),
            new ScoreInfo("Wolfe", "Bill", 73),
            new ScoreInfo("Dart", "Mary", 54),
            new ScoreInfo("Rogers", "Chris", 78),
            new ScoreInfo("Toole", "Pat", 51),
            new ScoreInfo("Khan", "Omar", 93),
            new ScoreInfo("Smith", "Ann", 95)
    };

    public static long studentNumber() {
        return Arrays.stream(scoreData).count();
    }

    public static double calculateStudentAverageScore() {
        return Arrays.stream(scoreData)
                .mapToDouble(ScoreInfo::getScore)
                .average()
                .orElse(0.0);
    }

    public static List<String> scoreLessThan70() {
        return Arrays.stream(scoreData)
                .filter(scoreInfo -> scoreInfo.getScore() >= 70)
                .map(scoreInfo -> scoreInfo.getFirstName() + scoreInfo.getLastName())
                .collect(Collectors.toList());
    }

    public static void printScoreLessThan70Student() {
        scoreLessThan70().stream()
                .forEach(System.out::println);
    }

    public static void printSortFirstName() {
        Arrays.stream(scoreData)
                .sorted(Comparator.comparingInt(o -> o.getFirstName().charAt(0)))
                .forEach(System.out::println);
    }

    public static void printSortScore() {
        Arrays.stream(scoreData)
                .sorted(Comparator.comparingInt(value -> value.getScore()))
                .forEach(System.out::println);
    }


}
