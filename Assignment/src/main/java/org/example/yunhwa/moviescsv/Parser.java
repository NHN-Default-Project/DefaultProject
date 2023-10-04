package org.example.yunhwa.moviescsv;

import java.util.List;

public interface Parser {
    public List<Movie> parse(String path);
}
