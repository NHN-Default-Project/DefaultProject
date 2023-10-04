package org.example.jaehyeon.movie;

import lombok.Builder;
import lombok.Getter;


@Builder
public class Movie {

    @Getter
    private String movieID;
    @Getter
    private String title;
    @Getter
    private String koreanTitle;
    private String plot;
    private String releaseYear;
    private String runningTime;
    private String gradeID;
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
        this.title = title;
        this.koreanTitle = koreanTitle;
        this.plot = plot;
        this.releaseYear = releaseYear;
        this.runningTime = runningTime;
        this.gradeID = grandID;
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
                ", Title='" + this.title + '\'' +
                ", KoreanTitle='" + this.koreanTitle + '\'' +
                ", plot='" + this.plot + '\'' +
                ", ReleaseYear='" + this.releaseYear + '\'' +
                ", RunningTime='" + this.runningTime + '\'' +
                ", GradeID='" + this.gradeID + '\'' +
                ", GradeInKoreaID='" + this.gradeInKoreaID + '\'' +
                ", Poster='" + this.poster + '\'' +
                ", ReleaseDateInKorea='" + this.releaseDateInKorea + '\'' +
                ", BoxOfficeWWGross='" + this.boxOfficeWWGross + '\'' +
                ", BoxOfficeUSGross='" + this.boxOfficeUSGross + '\'' +
                ", Budget='" + this.budget + '\'' +
                '}';
    }


}



