package org.example.yunhwa.moviesCsv;

import java.util.Date;

public class Movie {
    private int MovieID;
    private String Title;
    private String KoreanTitle;
    private String Plot;
    private int ReleaseYear;
    private int RunningTime;
    private int GradeID;
    private int GradeInKoreanID;
    private String Poster;
    private Date ReleaseDateInKorea;
    private long BoxOfficeWWGross;
    private long BoxOfficeUSGross;
    private long Budget;

    public Movie() {

    }


    public int getMovieID() {
        return MovieID;
    }

    public void setMovieID(int movieID) {
        MovieID = movieID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getKoreanTitle() {
        return KoreanTitle;
    }

    public void setKoreanTitle(String koreanTitle) {
        KoreanTitle = koreanTitle;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        ReleaseYear = releaseYear;
    }

    public int getRunningTime() {
        return RunningTime;
    }

    public void setRunningTime(int runningTime) {
        RunningTime = runningTime;
    }

    public int getGradeID() {
        return GradeID;
    }

    public void setGradeID(int gradeID) {
        GradeID = gradeID;
    }

    public int getGradeInKoreanID() {
        return GradeInKoreanID;
    }

    public void setGradeInKoreanID(int gradeInKoreanID) {
        GradeInKoreanID = gradeInKoreanID;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public Date getReleaseDateInKorea() {
        return ReleaseDateInKorea;
    }

    public void setReleaseDateInKorea(Date releaseDateInKorea) {
        ReleaseDateInKorea = releaseDateInKorea;
    }

    public long getBoxOfficeWWGross() {
        return BoxOfficeWWGross;
    }

    public void setBoxOfficeWWGross(long boxOfficeWWGross) {
        BoxOfficeWWGross = boxOfficeWWGross;
    }

    public long getBoxOfficeUSGross() {
        return BoxOfficeUSGross;
    }

    public void setBoxOfficeUSGross(long boxOfficeUSGross) {
        BoxOfficeUSGross = boxOfficeUSGross;
    }

    public long getBudget() {
        return Budget;
    }

    public void setBudget(long budget) {
        Budget = budget;
    }
}
