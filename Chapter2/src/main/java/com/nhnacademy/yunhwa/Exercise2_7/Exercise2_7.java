package com.nhnacademy.yunhwa.Exercise2_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Exercise2_7 {
    // "testdata.txt" 라는 파일에 다음 정보가 포함되어 있다고 가정
    // 파일의 첫 줄은 학생의 이름
    // 다음 세 줄에는 각각 정수가 포함되어 있음
    // 정수는 세 가지 시험에서의 학생의 점수 각각
    // 파일의 정보를 읽고 학생 이름과 세 가지 시험에 대한 학생의 평균 성적이 포함된 메시지를 표준 출력에 표시하는 프로그램
    // 평균 : 개별 시험 성적을 더한 값 / 시험 횟수
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(Files.newInputStream(Path.of("/Users/yoonhwachoi/Desktop/javaCourse2/ChoiYunhwa/chapter2/textdata.txt")));
            String studentName = sc.nextLine();

            // File file = new File()
            // InputStream is;

            int sum = 0;
            int count = 0;
            while (sc.hasNext()) {
                int score = Integer.parseInt(sc.nextLine());
                sum += score;
                count++;
            }

            double average = Math.round(((double) sum / count) * 100)/ 100.0;

            System.out.println("student name : " + studentName);
            System.out.println("Average of 3 subjects: " + average);

            sc.close();

        } catch (IllegalArgumentException | UnsupportedOperationException | IOException | SecurityException e) {
            System.out.println("예상했던 예외 상황이 발생하였습니다.");
            System.out.println(e.getMessage());

        } catch (Exception e) {
            // 비상 상황
            System.out.println("예상치 못한 예외 상황이 발생하였습니다.");
            System.out.println(e.getMessage());
        }
        
    }
}

