package org.example.gaeun.movies;

import java.io.*;

public class CSVParser implements Parser {
    private File file;

    public CSVParser(String path) {
        this.file = new File(path);
    }

    public void loadFile(MovieList movieList) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String oneLineRead;
            br.readLine();
            while ((oneLineRead = br.readLine()) != null) {
                //한 줄을 읽어와서 oneLinList에 저장
                String[] input = oneLineRead.split(";");
                if (input.length < 13) {
                    oneLineRead += br.readLine();
                    input = oneLineRead.split(";");
                }
                movieList.addMovie(new Movie.MovieBuilder()
                        .movieID(input[0])
                        .title(input[1])
                        .koreanTitle(input[2])
                        .plot(input[3])
                        .releaseYear(input[4])
                        .runningTime(input[5])
                        .grandID(input[6])
                        .gradeInKoreaID(input[7])
                        .poster(input[8])
                        .releaseDateInKorea(input[9])
                        .boxOfficeWWGross(input[10])
                        .boxOfficeUSGross(input[11])
                        .budget(input[12])
                        .build());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
