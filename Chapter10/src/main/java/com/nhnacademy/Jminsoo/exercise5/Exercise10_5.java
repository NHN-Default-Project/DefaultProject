package com.nhnacademy.Jminsoo.exercise5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stream기능을 연습하는 문제
 * 학생 수 프린트
 * 학생의 평균 점수 출력
 * Collect() 스트림을 사용하여 70점 미만인 List<String>만들기
 * 위의 작업에서 만든 List의 이름 인쇄
 * First name의 오름차순 출력
 * 점수 순 출력
 */
public class Exercise10_5 {
    public static void main(String[] args) {
        ScoreInfo[] scoreData = new ScoreInfo[]{
                new ScoreInfo("Smith", "John", 70),
                new ScoreInfo("Doe", "Mary", 85),
                new ScoreInfo("페이지", "앨리스", 82),
                new ScoreInfo("쿠퍼", "질", 97),
                new ScoreInfo("플린트스톤", "프레드", 66),
                new ScoreInfo("러블", "바니", 80),
                new ScoreInfo(" Smith", "Judy", 48),
                new ScoreInfo("Dean", "James", 90),
                new ScoreInfo("Russ", "Joe", 55),
                new ScoreInfo("Wolfe", "Bill", 73),
                new ScoreInfo("다트", "메리", 54),
                new ScoreInfo("로저스", "크리스", 78),
                new ScoreInfo("툴", "팻", 51),
                new ScoreInfo("칸", "오마르", 93),
                new ScoreInfo("스미스", "앤", 95)
        };

        printElementCount(scoreData);
        printAverageScore(scoreData);
        printCountScoreUpperA(scoreData);
        printListOfScore(makeListOfScoreLower70(scoreData));
        printSortByLastName(scoreData);
        printSortByScore(scoreData);
    }

    //1번 문제
    public static void printElementCount(ScoreInfo[] array) {
        System.out.println(Arrays
                .stream(array)
                .count());
    }

    //2번 문제
    public static void printAverageScore(ScoreInfo[] array) {
        System.out.printf("%.2f%n", Arrays
                .stream(array)
                .mapToInt(ScoreInfo::getScore)
                .average()
                .orElse(0));
    }

    //3번 문제
    public static void printCountScoreUpperA(ScoreInfo[] array) {
        System.out.println(Arrays
                .stream(array)
                .mapToInt(ScoreInfo::getScore)
                .filter(score -> score >= 90)
                .count());
    }

    //4번문제
    public static List<String> makeListOfScoreLower70(ScoreInfo[] array) {
        return Arrays
                .stream(array)
                .filter(info -> info.getScore() < 70)
                .map(info -> String.format(info.getLastName() + " " + info.getFirstName()))
                .collect(Collectors.toList());
    }

    //5번 문제
    public static void printListOfScore(List<String> list) {
        list.stream()
                .forEach(System.out::println);
    }

    public static void printSortByLastName(ScoreInfo[] array) {
        Arrays.stream(array)
                .sorted(Comparator.comparing(ScoreInfo::getLastName))
                .map(info -> info.getFirstName() + "의 성적 : " + info.getScore())
                .forEach(System.out::println);
    }

    public static void printSortByScore(ScoreInfo[] array) {
        Arrays.stream(array)
                .sorted(Comparator.comparing(ScoreInfo::getScore))
                .map(info -> info.getLastName() + "의 성적 : " + info.getScore())
                .forEach(System.out::println);
    }

}
