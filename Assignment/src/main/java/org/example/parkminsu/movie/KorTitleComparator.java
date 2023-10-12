package org.example.parkminsu.movie;

import java.util.Comparator;

public class KorTitleComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getKoreaTitle().compareTo(o2.getKoreaTitle());
    }
}
