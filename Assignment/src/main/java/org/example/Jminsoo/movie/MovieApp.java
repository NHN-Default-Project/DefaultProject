package org.example.Jminsoo.movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieApp {
    List<Movie> movieList;

    Map<String, List<String>> engNameIdMap;
    Map<String, List<String>> korNameIdMap;
    private final String path;

    public MovieApp(String path) {
        this.path = path;
        this.movieList = MovieCSVParser.parser(this.path);
        engNameIdMap = new HashMap<>();
        korNameIdMap = new HashMap<>();
        makeEngNameIdMap();
        makeKorNameIdMap();
    }

    public void findKorName(String name) {
        long beforeTime = System.currentTimeMillis();

        try {
            List<String> idList = this.korNameIdMap.get(name);
            if (idList == null || name.isEmpty()) {
                return;
            }
            for (String id : idList) {
                for (Movie movie : this.movieList) {
                    if (movie.isCorrectMovieData(id)) {
                        System.out.println(movie);
                        break;
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("타이틀 제목을 제대로 입력해주세요!");
        }
        long afterTime = System.currentTimeMillis();
        System.out.printf("실행시간 : %d ms %n", afterTime - beforeTime);
    }

    public void findEngName(String name) {
        long beforeTime = System.currentTimeMillis();

        try {
            List<String> idList = this.engNameIdMap.get(name);
            if (idList == null || name.isEmpty()) {
                return;
            }
            for (String id : idList) {
                for (Movie movie : this.movieList) {
                    if (movie.isCorrectMovieData(id)) {
                        System.out.println(movie);
                        break;
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("타이틀 제목을 제대로 입력해주세요!");
        }
        long afterTime = System.currentTimeMillis();
        System.out.printf("실행시간 : %d ms %n", afterTime - beforeTime);
    }

    private void makeEngNameIdMap() {
        for (Movie movie : this.movieList) {
            List<String> idValue = this.engNameIdMap.getOrDefault(movie.getEngTitle(), new ArrayList<>());
            idValue.add(movie.getMovieID());
            this.engNameIdMap.put(movie.getEngTitle(), idValue);
        }
    }

    private void makeKorNameIdMap() {
        List<String> idValue;
        for (Movie movie : this.movieList) {
            idValue = korNameIdMap.getOrDefault(movie.getKorTitle(), new ArrayList<>());
            idValue.add(movie.getMovieID());
            this.korNameIdMap.put(movie.getKorTitle(), idValue);
        }
    }

}
