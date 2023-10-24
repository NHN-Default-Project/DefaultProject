package com.nhnacademy.main.exercise10_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise10_5 {

    private static final ScoreInfo[] scoreData = new ScoreInfo[] {
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

    public static void main(String[] args) {
        System.out.printf("== 학생 수 : %d%n%n", studentNumber());
        System.out.printf("== 모든 학생의 평균 점수 : %.2f%n%n", calculateStudentAverageScore());
        System.out.printf("== A 를 받은 학생의 수 (90 점 이상) : %d%n%n", receivedAGradeCount());

        System.out.println("== 점수가 70점 미만인 학생의 이름 리스트 (이름 + 성) ==");
        printScoreLessThan70Student();

        System.out.println("\n== 성 순으로 정렬한 학생의 이름과 점수 리스트 ==");
        printSortFirstName();

        System.out.println("\n== 점수 순으로 정렬한 학생의 이름과 점수 리스트 ==");
        printSortScore();
    }

    private static long studentNumber() {
        return Arrays.stream(scoreData).count();
    }

    private static double calculateStudentAverageScore() {
        return Arrays.stream(scoreData)
                .mapToDouble(ScoreInfo::getScore)
                .average()
                .orElse(0.0);
    }

    private static long receivedAGradeCount() {
        return Arrays.stream(scoreData)
                .filter(scoreInfo -> scoreInfo.getScore() >= 90)
                .count();
    }

    private static List<String> scoreLessThan70() {
        return Arrays.stream(scoreData)
                .filter(scoreInfo -> scoreInfo.getScore() >= 70)
                .map(scoreInfo -> scoreInfo.getFirstName() + scoreInfo.getLastName())
                .collect(Collectors.toList());
    }

    private static void printScoreLessThan70Student() {
        scoreLessThan70().stream()
                .forEach(System.out::println);
    }

    private static void printSortFirstName() {
        Arrays.stream(scoreData)
                .sorted(Comparator.comparing(ScoreInfo::getLastName))
                .map(info -> "이름 : " + String.format("%-10s", info.getLastName()) + " 점수 : " + info.getScore())
                .forEach(System.out::println);
    }

    private static void printSortScore() {
        Arrays.stream(scoreData)
                .sorted(Comparator.comparing(ScoreInfo::getScore))
                .map(info -> "이름 : " + String.format("%-13s", info.getLastName()) + " 점수 : " + info.getScore())
                .forEach(System.out::println);
    }

}
