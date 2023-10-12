package org.example.gaeun.movies;

import lombok.Builder;
import lombok.Getter;

import java.util.Comparator;

@Builder
public class Movie implements Comparable {

    @Getter
    private String movieID;
    @Getter
    private String title;
    @Getter
    private String koreanTitle;
    private String plot;
    private String releaseYear;
    private String runningTime;
    private String grandID;
    private String gradeInKoreaID;
    private String poster;
    private String releaseDateInKorea;
    private String boxOfficeWWGross;
    private String boxOfficeUSGross;
    private String budget;
    public Movie() {

    }

    public Movie(String movieID, String title, String koreanTitle, String plot, String releaseYear, String runningTime, String grandID, String gradeInKoreaID, String poster, String releaseDateInKorea, String boxOfficeWWGross, String boxOfficeUSGross, String budget) {
        this.movieID = movieID;
        this.title = title.replaceAll("\\\"","");
        this.koreanTitle = koreanTitle.replaceAll("\\\"","");
        this.plot = plot;
        this.releaseYear = releaseYear;
        this.runningTime = runningTime;
        this.grandID = grandID;
        this.gradeInKoreaID = gradeInKoreaID;
        this.poster = poster;
        this.releaseDateInKorea = releaseDateInKorea;
        this.boxOfficeWWGross = boxOfficeWWGross;
        this.boxOfficeUSGross = boxOfficeUSGross;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieID='" + this.movieID + '\'' +
                ", title='" + this.title + '\'' +
                ", koreanTitle='" + this.koreanTitle + '\'' +
                ", plot='" + this.plot + '\'' +
                ", releaseYear='" + this.releaseYear + '\'' +
                ", runningTime='" + this.runningTime + '\'' +
                ", grandID='" + this.grandID + '\'' +
                ", gradeInKoreaID='" + this.gradeInKoreaID + '\'' +
                ", poster='" + this.poster + '\'' +
                ", releaseDateInKorea='" + this.releaseDateInKorea + '\'' +
                ", boxOfficeWWGross='" + this.boxOfficeWWGross + '\'' +
                ", boxOfficeUSGross='" + this.boxOfficeUSGross + '\'' +
                ", budget='" + this.budget + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public Comparator<Movie> compareTitle() {
        return Comparator.comparing(Movie::getTitle);
    }

    @Override
    public boolean equals(Object otherMovie) {
        Movie movie = (Movie) otherMovie;
        if(this.getMovieID() == movie.getMovieID()) {
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Integer.parseInt(getMovieID());
    }

}