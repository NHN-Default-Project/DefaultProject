package org.example.jaehyeon.movie;

import lombok.Builder;

@Builder
public class Movie {
    private String movieID;
    private String title;
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

    public String getMovieID() {
        return this.movieID;
    }

    public String getTitle() {
        return this.title;
    }

    public String getKoreanTitle() {
        return this.koreanTitle;
    }

    public String getPlot() {
        return plot;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public String getGradeID() {
        return gradeID;
    }

    public String getGradeInKoreaID() {
        return gradeInKoreaID;
    }

    public String getPoster() {
        return poster;
    }

    public String getReleaseDateInKorea() {
        return releaseDateInKorea;
    }

    public String getBoxOfficeWWGross() {
        return boxOfficeWWGross;
    }

    public String getBoxOfficeUSGross() {
        return boxOfficeUSGross;
    }

    public String getBudget() {
        return budget;
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



