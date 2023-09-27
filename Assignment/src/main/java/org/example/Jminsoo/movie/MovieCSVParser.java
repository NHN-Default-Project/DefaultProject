package org.example.Jminsoo.movie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieCSVParser {


    public static List<Movie> parser(String path) {
        List<Movie> movies = new ArrayList<>();

        List<String[]> tempMovieList = new ArrayList<>();
        File file = new File(path);
        List<String> csvField = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            if ((line = br.readLine()) != null) {
                csvField = List.of(line.split(";"));
            }

            while ((line = br.readLine()) != null) {
                String[] str = line.split(";");
                if (str.length < csvField.size()) {
                    line += br.readLine();
                    str = line.split(";");
                }

                for (int i = 0; i < str.length; i++) {
                    if (str[i].length() > 2 && str[i].charAt(0) == '\"' && str[i].charAt(str[i].length() - 1) == '\"') {
                        str[i] = str[i].substring(1, str[i].length() - 1);
                    }
                }

                tempMovieList.add(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String[] tempMovie : tempMovieList) {
            Movie movie = Movie.MovieBuilder.aMovie()
                    .withMovieID(tempMovie[0])
                    .withTitle(tempMovie[1])
                    .withKoreanTitle(tempMovie[2])
                    .withPlot(tempMovie[3])
                    .withReleaseYear(tempMovie[4])
                    .withRunningTime(tempMovie[5])
                    .withGradeID(tempMovie[6])
                    .withGradeInKoreaID(tempMovie[7])
                    .withPoster(tempMovie[8])
                    .withReleaseDateInKorea(tempMovie[9])
                    .withBoxOfficeWWGross(tempMovie[10])
                    .withBoxOfficeUSGross(tempMovie[11])
                    .withBudget(tempMovie[12])
                    .build();
            movies.add(movie);
        }

        return movies;
    }
}
