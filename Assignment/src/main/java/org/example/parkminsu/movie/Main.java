package org.example.parkminsu.movie;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        Parser parser = new Parser();
        Sort sort = new Sort();
        List<Movie> movieList = parser.parser(fileReader.load("/Users/minsu/Desktop/DefaultProject/Assignment/src/main/java/org/example/parkminsu/movie/Moviefile.csv"));

    }

    public static void excution() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("찾을 영화 이름: ");
        String str = scanner.nextLine();

    }
}
