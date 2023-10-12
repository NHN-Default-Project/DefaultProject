package org.example.Jminsoo.movie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MovieApp movieApp = new MovieApp("/Users/minsoo/NHN/DefaultProject/Assignment/src/main/java/org/example/Jminsoo/movie/source/movies.csv");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("어떤 언어로 찾겠습니까? (영어 : 1, 한글 : 2 종료 : 0)");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                System.out.print("영어 제목을 입력해주세요 : ");
                input = scanner.nextLine();
                movieApp.findEngName(input);
            } else if (input.equals("2")) {
                System.out.print("한글 제목을 입력해주세요 : ");
                input = scanner.nextLine();
                movieApp.findKorName(input);
            } else if (input.equals("0")) {
                break;
            }
        }
    }
}
