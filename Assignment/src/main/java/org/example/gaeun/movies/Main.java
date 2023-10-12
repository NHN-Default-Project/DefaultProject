package org.example.gaeun.movies;

public class Main {
    public static void main(String[] args) {
        String path = "/Users/kaeun/DefaultProject/Assignment/src/main/java/org/example/gaeun/movies/Movies.csv";
        CSVParser csvFile = new CSVParser(path);
        MovieList movieList = new MovieList();
        csvFile.loadFile(movieList);
        System.out.println(movieList.searchTitle("Youth").toString());
        System.out.println(movieList.searchKorTitle("예스터데이").toString());
        movieList.checkMovie();
        movieList.sortByKoreanTitle();

    }
}
