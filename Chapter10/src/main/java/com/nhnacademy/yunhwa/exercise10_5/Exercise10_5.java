package com.nhnacademy.yunhwa.exercise10_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/* 10 - 5
* 스트림 API 활용 연습 예제
* for, while 문 사용 x
* */
public class Exercise10_5 {
    private static ScoreInfo[] scoreData = new ScoreInfo[] {
            new ScoreInfo("Smith","John",70),
            new ScoreInfo("Doe","Mary",85),
            new ScoreInfo("Page","Alice",82),
            new ScoreInfo("Cooper","Jill",97),
            new ScoreInfo("Flintstone","Fred",66),
            new ScoreInfo("Rubble","Barney",80),
            new ScoreInfo("Smith","Judy",48),
            new ScoreInfo("Dean","James",90),
            new ScoreInfo("Russ","Joe",55),
            new ScoreInfo("Wolfe","Bill",73),
            new ScoreInfo("Dart","Mary",54),
            new ScoreInfo("Rogers","Chris",78),
            new ScoreInfo("Toole","Pat",51),
            new ScoreInfo("Khan","Omar",93),
            new ScoreInfo("Smith","Ann",95)
    };

    public static void main(String[] args) {
        System.out.printf("== 학생 수 : %d%n%n", Arrays.stream(scoreData).count());

        System.out.printf("== 모든 학생의 평균 점수 : %.2f%n%n", (Arrays.stream(scoreData)
                .mapToInt(info -> info.score)
                .average().getAsDouble()));

        System.out.printf("== A 를 받은 학생의 수 (90 점 이상) : %d%n%n", Arrays.stream(scoreData)
                .filter(info -> info.score >= 90)
                .count());

        List<String> namesUnder70 = Arrays.stream(scoreData)
                .filter(info -> info.score < 70)
                .map(info -> info.lastName + info.firstName)
                .collect(Collectors.toList());

        System.out.println("== 점수가 70점 미만인 학생의 이름 리스트 (이름 + 성) ==");
        System.out.println(namesUnder70);

        System.out.println("\n== 성 순으로 정렬한 학생의 이름과 점수 리스트 ==");
        Arrays.stream(scoreData)
                .sorted(Comparator.comparing(ScoreInfo::getLastName))
                .map(info -> "이름 : " + String.format("%-10s", info.lastName) + " 점수 : " + info.score)
                .forEach(System.out::println);

        System.out.println("\n== 점수 순으로 정렬한 학생의 이름과 점수 리스트 ==");
        Arrays.stream(scoreData)
                .sorted(Comparator.comparing(ScoreInfo::getScore))
                .map(info -> "이름 : " + String.format("%-13s", info.lastName) + " 점수 : " + info.score)
                .forEach(System.out::println);
    }
}
