package org.example.yunhwa.moviesCsv;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVParser csvParser = new CSVParser();
        List<Movie> movieList = csvParser.parse("/Users/yoonhwachoi/Desktop/DefaultProject/Assignment/src/main/java/org/example/yunhwa/moviesCsv/Movies.csv");

//        Collections.sort(movieList, new MovieIdComparator()); // 1 ~ 오름차순
//        Collections.sort(movieList, new TitleComparator()); // 숫자 -> a -> z
//        Collections.sort(movieList, new KoreanTitleComparator()); // 한글 오름차순
//        Collections.sort(movieList, new PlotComparator()); // 영어 -> 한글 오름차순
//        Collections.sort(movieList, new ReleaseYearComparator()); // 연도 오름차순
//        Collections.sort(movieList, new RunningTimeComparator()); // 러닝 타임 오름차순
//        Collections.sort(movieList, new GradeIDComparator()); // 등급 오름차순
//        Collections.sort(movieList, new GradeInKoreanIDComparator()); // 한국 등급 오름차순
//        Collections.sort(movieList, new PosterComparator()); // 포스터 파일 이름 오름차순
//        Collections.sort(movieList, new ReleaseDateInKoreaComparator()); // 날짜 오름차순
//        Collections.sort(movieList, new BoxOfficeWWGrossComparator()); // 매출총이익 내림차순
//        Collections.sort(movieList, new BoxOfficeUSGrossComparator()); // 미국 매출총이익 내림차순
//        Collections.sort(movieList, new BudgetComparator()); // 예산 오름차순

        try {
            Field[] fields = (new Movie()).getClass().getDeclaredFields();
            for (Movie movie : movieList) {

                System.out.println("------------------------------------------------------------------------------------------------------");
                for (Field field : fields) {
                    field.setAccessible(true);
                    System.out.print(field.getName() + " : ");
                    System.out.println(field.get(movie));
                }
                System.out.println("------------------------------------------------------------------------------------------------------");
            }

            long startTime = System.nanoTime();
            Movie movie1 = findMovieByKoreanTitle("해피 고 럭키", movieList);
            long endTime = System.nanoTime();
            double processingTime = (endTime - startTime) / 1000000000.0;
            System.out.printf("한국 제목 (%s) 으로 영화 찾기 처리 시간 : %f %n", movie1.getKoreanTitle(), processingTime);

            System.out.println("------------------------------------------------------------------------------------------------------");
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.print(field.getName() + " : ");
                System.out.println(field.get(movie1));
            }
            System.out.println("------------------------------------------------------------------------------------------------------");


            startTime = System.nanoTime();
            Movie movie2 = findMovieByTitle("Mirai no Mirai", movieList);
            endTime = System.nanoTime();
            processingTime = (endTime - startTime) / 1000000000.0;
            System.out.printf("영어 제목 (%s) 으로 영화 찾기 처리 시간 : %f %n", movie2.getTitle(), processingTime);

            System.out.println("------------------------------------------------------------------------------------------------------");
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.print(field.getName() + " : ");
                System.out.println(field.get(movie2));
            }
            System.out.println("------------------------------------------------------------------------------------------------------");

        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Movie findMovieByTitle(String title, List<Movie> movieList) {
        Collections.sort(movieList, new TitleComparator()); // 숫자 -> a -> z

        int low = 0;
        int high = movieList.size() - 1;

        while (!(low > high)) {
            int middle = (low + high) / 2;

            if (movieList.get(middle).getTitle().compareTo(title) > 0) {
                high = middle - 1;
            } else if (movieList.get(middle).getTitle().compareTo(title) < 0) {
                low = middle + 1;
            } else {
                return movieList.get(middle);
            }
        }
        throw new IllegalArgumentException("찾지 못하는 영어 제목(Title) 값이 들어왔습니다. 다른 영어 제목으로 다시 검색해주세요.");
    }

    public static Movie findMovieByKoreanTitle(String koreanTitle, List<Movie> movieList) {
        Collections.sort(movieList, new KoreanTitleComparator()); // KoreanTitle 영어 알파벳 오름차순으로

        int low = 0;
        int high = movieList.size() - 1;

        while (!(low > high)) {
            int middle = (low + high) / 2;

            if (movieList.get(middle).getKoreanTitle().compareTo(koreanTitle) > 0) {
                high = middle - 1;
            } else if (movieList.get(middle).getKoreanTitle().compareTo(koreanTitle) < 0) {
                low = middle + 1;
            } else {
                return movieList.get(middle);
            }
        }
        throw new IllegalArgumentException("찾지 못하는 한글 제목(KoreanTitle) 값이 들어왔습니다. 다른 영어 제목으로 다시 검색해주세요.");
    }
}
