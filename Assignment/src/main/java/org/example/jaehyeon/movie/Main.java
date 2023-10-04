package org.example.jaehyeon.movie;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("/Users/hyeon/Desktop/DefaultProject/DefaultProject/Assignment/src/test/java/org/example/jaehyeon/dict/Movies.csv");
        FileParser fileParser = new FileParser(file);
        MovieList movieList = new MovieList(fileParser.makeMovieList());

        System.out.println(movieList.findTitleMovie("Frida"));

        movieList.sortKorea();

    }
}
