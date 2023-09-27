package org.example.jaehyeon.movie;

import java.text.Collator;
import java.util.*;

public class MovieList {
    private final List<Movie> movieList;

    public MovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public void checkFile() {
        for (Movie movie : movieList) {
            System.out.println(movie);
        }
    }

    public void sortKoreaTitle() {
        this.movieList.sort(Comparator.comparing(Movie::getKoreanTitle));
    }

    public void sortKorea() {
        Comparator<Movie> koreanNameComparator = Comparator.comparing(Movie::getKoreanTitle,
                Collator.getInstance(new Locale("ko", "KR")));
        this.movieList.sort(koreanNameComparator);
    }

    public void sortEnglishTitle() {
        this.movieList.sort(Comparator.comparing(Movie::getTitle));
    }

    public Movie findTitleMovie(String title) {
        sortEnglishTitle();
        int findNumber = searchTitleMovie(title);
        System.out.println(findNumber);

        if (findNumber == -1) {
            return new Movie();
        }
        return this.movieList.get(findNumber);
    }

    public Movie findKoreaTitleMovie(String title) {
        sortEnglishTitle();
        int findNumber = searchKoreaTitleMovie(title);
        System.out.println(findNumber);

        if (findNumber == -1) {
            return new Movie();
        }
        return this.movieList.get(findNumber);
    }

    public int searchKoreaTitleMovie(String title) {
        int left = 0;
        int right = this.movieList.size() - 1;
        while (left <= right) {
            int minIndex = left + (right - left) / 2;
            Movie midValue = this.movieList.get(minIndex);
            if (Objects.equals(midValue.getKoreanTitle(), title)) {
                return minIndex;
            } else if (midValue.getTitle().compareTo(title) < 0) {
                left = minIndex + 1;
            } else {
                right = minIndex - 1;
            }
        }

//        throw new NoSuchElementException()

        return -1;
    }

    public int searchTitleMovie(String title) {
        int left = 0;
        int right = this.movieList.size() - 1;
        while (left <= right) {
            int midIndex = left + (right - left) / 2;
            Movie midValue = this.movieList.get(midIndex);

            if (Objects.equals(midValue.getTitle(), title)) {
                return midIndex;
            } else if (midValue.getTitle().compareTo(title) < 0) {
                left = midIndex + 1;
            } else {
                right = midIndex - 1;
            }
        }
        return -1;
    }

}
