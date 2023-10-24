package com.nhnacademy.parkminsu.exercise10_5;

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

    public static void main(String[] args) {
        //학생 수를 출력하세요 (scoreData.length를 사용하지 않습니다).
        //모든 학생의 평균 점수를 출력하세요.
        //A 학점을 받은 학생 수를 출력하세요 (점수가 90 이상인 학생).
        //collect() 스트림 연산을 사용하여 점수가 70 미만인 학생의 이름을 포함하는 List<String>를 생성하세요. 이름은 이름 다음에 성으로 구성되어야 합니다.
        //이전 작업에서 생성된 List에서 이름을 출력하세요.
        //성(last name)을 기준으로 정렬된 학생들의 이름과 점수를 출력하세요.
        //점수를 기준으로 정렬된 학생들의 이름과 점수를 출력하세요.
        System.out.println("1. 학생의 수: " + countStudent(scoreData));
        System.out.println("2. 모든 학생의 평균: " + averageOfAllStudent(scoreData));
        System.out.println("3. A 학점을 받은 학생(90점 이상): " + studentsReceivedScoreGradeA(scoreData));
        List<String> studnelist = createListOfReceivedLessThanCertainScore(scoreData, 70); // 70점 미만인 학생 성적
        System.out.println("4. 70점 미만인 학생의 목록: " + studnelist.toString());

        List<String> lastNameToList = sortedLastNameToList(scoreData);
        System.out.println("5. 성(last name)으로 정렬된 학생" + lastNameToList.toString());

        List<String> scoreToList = sortedScoreToList(scoreData);
        System.out.println("6. 점수를 기준으로 정렬된 학생: " + scoreToList.toString());
    }

    public static long countStudent(ScoreInfo[] scoreInfos) {
        return Arrays.stream(scoreInfos).count();
    }

    public static double averageOfAllStudent(ScoreInfo[] scoreInfos) {
        return Arrays.stream(scoreInfos)
                .mapToInt(ScoreInfo::getScore)
                .average().orElse(0);
    }

    public static long studentsReceivedScoreGradeA(ScoreInfo[] scoreInfos) {
        return Arrays.stream(scoreInfos)
                .mapToInt(ScoreInfo::getScore)
                .filter(score -> score >= 90)
                .count();
    }

    public static List<String> createListOfReceivedLessThanCertainScore(ScoreInfo[] scoreInfos, int score) {
        return Arrays.stream(scoreInfos)
                .filter(scoreInfo -> scoreInfo.getScore() < score)
                .map(scoreInfo -> scoreInfo.getLastName() + " " + scoreInfo.getFirstName())
                .collect(Collectors.toList());
    }

    public static List<String> sortedLastNameToList(ScoreInfo[] scoreInfos) {
        return Arrays.stream(scoreInfos)
                .sorted(Comparator.comparing(scoreInfo -> scoreInfo.getLastName()))
                .map(scoreInfo -> scoreInfo.toString())
                .collect(Collectors.toList());
    }

    public static List<String> sortedScoreToList(ScoreInfo[] scoreInfos) {
        return Arrays.stream(scoreData)
                .sorted(Comparator.comparing(scoreInfo -> scoreInfo.getScore()))
                .map(scoreInfo -> scoreInfo.toString()).collect(Collectors.toList());
    }

}
