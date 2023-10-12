package org.example.parkminsu.movie;

import java.util.Comparator;

public class EngTitleComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
