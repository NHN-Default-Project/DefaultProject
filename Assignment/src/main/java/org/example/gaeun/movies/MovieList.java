package org.example.gaeun.movies;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;

public class MovieList {
    private List<Movie> movieList;

    public MovieList() {
        movieList = new ArrayList<>();
    }
    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public void checkMovie() {
        for (Movie movie : movieList) {
            System.out.println(movie.toString());
        }

    }

    public void sortByTitle() {
        movieList.sort(Comparator.comparing(Movie::getTitle));
    }

    public void sortByKoreanTitle() {
        movieList.sort(Comparator.comparing(Movie::getKoreanTitle));
    }

    public void sort(Comparator comparator) {
        movieList.sort(comparator);
    }
//        public void sortByKoreanTitle() {
//        Comparator<Movie> movieComparator = Comparator.comparing(Movie::getKoreanTitle,
//                Collator.getInstance(new Locale("ko", "KR")));
//        Collections.sort(movieLists, movieComparator);
//    }

    public Movie searchTitle(String title) {
        sortByTitle();
        int keyValue = searchTitle(title, 1, movieList.size() - 1);
        System.out.println(keyValue);
        if (keyValue == -1) {
            throw new InputMismatchException();
        }
        return movieList.get(keyValue);
    }

    public int searchTitle(String title, int left, int right) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = title.compareTo(movieList.get(mid).getTitle());

            if (cmp == 0) {
                return mid; // 찾은 경우
            } else if (cmp < 0) {
                right = mid - 1; // 왼쪽 반 배열에서 탐색
            } else {
                left = mid + 1; // 오른쪽 반 배열에서 탐색
            }
        }
        return -1; //실패
    }

    public Movie searchKorTitle(String title) {
        sortByKoreanTitle();
        int keyValue = searchKorTitle(title, 1, movieList.size() - 1);
        System.out.println(keyValue);
        if (keyValue == -1) {
            return new Movie();
        }
        return movieList.get(keyValue);
    }

    public int searchKorTitle(String title, int left, int right) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = title.compareTo(movieList.get(mid).getKoreanTitle());

            if (cmp == 0) {
                return mid; // 찾은 경우
            } else if (cmp < 0) {
                right = mid - 1; // 왼쪽 반 배열에서 탐색
            } else {
                left = mid + 1; // 오른쪽 반 배열에서 탐색
            }
        }
        return -1; //실패
    }
}
