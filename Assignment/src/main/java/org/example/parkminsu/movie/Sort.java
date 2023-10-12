package org.example.parkminsu.movie;

import java.util.Collections;
import java.util.List;

public class Sort {
    public void sortKorTitle(List<Movie> movieList) {
        Collections.sort(movieList, new KorTitleComparator());

    }

    public void sortEngTitle(List<Movie> movieList) {
        Collections.sort(movieList, new EngTitleComparator());

    }
}

