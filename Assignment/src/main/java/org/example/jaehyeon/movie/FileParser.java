package org.example.jaehyeon.movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileParser {
    private File file;

    public FileParser(File file) {
        this.file = file;
    }

    public List<Movie> makeMovieList() {
        List<Movie> movieList = new ArrayList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            while ((line = br.readLine()) != null) {
                String[] list = line.split(";");
                for (String s : list) {
                    s.replaceAll("\"", "");
                }
                if (list.length < 13) {
                    line += br.readLine();
                    list = line.split(";");
                }
                movieList.add(makeMovie(list));
            }
        } catch (FileNotFoundException e) {
            //ToDo
        } catch (IOException e) {
            //ToDo
        }
        return movieList;
    }

    private Movie makeMovie(String[] movie) {
        return new Movie.MovieBuilder()
                .movieID(movie[0])
                .title(movie[1])
                .koreanTitle(movie[2])
                .plot(movie[3])
                .releaseYear(movie[4])
                .runningTime(movie[5])
                .gradeID(movie[6])
                .gradeInKoreaID(movie[7])
                .poster(movie[8])
                .releaseDateInKorea(movie[9])
                .boxOfficeWWGross(movie[10])
                .boxOfficeUSGross(movie[11])
                .budget(movie[12]).build();
    }
}
