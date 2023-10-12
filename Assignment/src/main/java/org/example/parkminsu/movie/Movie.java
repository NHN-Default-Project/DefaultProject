package org.example.parkminsu.movie;

public class Movie {
    private String movieId;
    private String title;
    private String koreaTitle;
    private String plot;
    private String releaseYear;
    private String runningTime;
    private String gradeId;
    private String gradeInKoreaId;
    private String poster;
    private String releaseDateInKorea;
    private String boxOfficeWWGross;
    private String boxOfficeUsGross;
    private String budget;

    public Movie(String movieId, String title, String koreaTitle, String plot, String releaseYear, String runningTime, String gradeId, String gradeInKoreaId, String poster, String releaseDateInKorea, String boxOfficeWWGross, String boxOfficeUsGross, String budget) {
        this.movieId = movieId;
        this.title = title;
        this.koreaTitle = koreaTitle;
        this.plot = plot;
        this.releaseYear = releaseYear;
        this.runningTime = runningTime;
        this.gradeId = gradeId;
        this.gradeInKoreaId = gradeInKoreaId;
        this.poster = poster;
        this.releaseDateInKorea = releaseDateInKorea;
        this.boxOfficeWWGross = boxOfficeWWGross;
        this.boxOfficeUsGross = boxOfficeUsGross;
        this.budget = budget;
    }


    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
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

    public String getGradeId() {
        return gradeId;
    }

    public String getGradeInKoreaId() {
        return gradeInKoreaId;
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

    public String getBoxOfficeUsGross() {
        return boxOfficeUsGross;
    }

    public String getBudget() {
        return budget;
    }

    public String getKoreaTitle() {
        return koreaTitle;
    }

    @Override
    public String toString() {
        return
                movieId + ", "
                        + title + ", "
                        + koreaTitle + ", "
                        + plot + ", "
                        + releaseYear + ", "
                        + runningTime + ", "
                        + gradeId + ", "
                        + gradeInKoreaId + ", "
                        + poster + ", "
                        + releaseDateInKorea + ", "
                        + boxOfficeWWGross + ", "
                        + boxOfficeUsGross + ", "
                        + budget + "\n";
    }


}
