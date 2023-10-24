package com.nhnacademy.gaeun.exercise5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise10_5 {
    private static ScoreInfo[] scoreData = new ScoreInfo[]{
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

    public static double avgScore() {
        return Arrays.stream(scoreData)
                .mapToInt(ScoreInfo::getScore)
                .average().orElse(0);
    }

    public static long AScoreNumber() {
        return Arrays.stream(scoreData)
                .filter(n -> n.getScore() >= 90)
                .count();
    }

    public static List<String> underCScoreList() {
        return Arrays.stream(scoreData)
                .filter(n -> n.getScore() < 70)
                .map(n -> n.getFirstName() + n.getLastName())
                .collect(Collectors.toList());
    }

    public static void printListName(List<String> underCScoreList) {
        underCScoreList.forEach(System.out::println);
    }

    public static void printSortLastName() {
        Arrays.stream(scoreData)
                .sorted(Comparator.comparing(ScoreInfo::getLastName))
                .forEach(System.out::println);
    }

    public static void printSortScore() {
        Arrays.stream(scoreData)
                .sorted(Comparator.comparing(ScoreInfo::getScore))
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        System.out.println("학생 수: " + studentNumber());
        System.out.println("학생들의 평균 점수: " + avgScore());
        System.out.println("A학점을 받은 학생 수: " + AScoreNumber());
        System.out.println("score가 70미만인 학생들 리스트 생성: ");
        printListName(underCScoreList());
        System.out.println("lastName을 기준으로 정렬");
        printSortLastName();
        System.out.println("score을 기준으로 정렬");
        printSortScore();
    }

}
