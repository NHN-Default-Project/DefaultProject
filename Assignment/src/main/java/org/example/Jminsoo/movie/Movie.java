package org.example.Jminsoo.movie;

/**
 * DB에서 값을 읽어오는 클래스
 */
public class Movie {
    //MovieID;Title;KoreanTitle;Plot;ReleaseYear;RunningTime;GradeID;GradeInKoreaID;Poster;ReleaseDateInKorea;BoxOfficeWWGross;BoxOfficeUSGross;Budget
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

    public boolean isCorrectMovieData(String movieID) {
        if (movieID.equals(this.movieID)) {
            return true;
        } else {
            return false;
        }
    }


    public String getEngTitle() {
        return this.title;
    }

    public String getKorTitle() {
        return this.koreanTitle;
    }

    public String getMovieID() {
//        if (title.equals(this.title) || title.equals(this.koreanTitle)) {
//            return this.movieID;
//        }
//        throw new IllegalArgumentException("값이 없습니다!");
        return this.movieID;
    }

    @Override
    public String toString() {
        return "movieID=" + movieID +
                "\ntitle=" + title +
                "\nkoreanTitle=" + koreanTitle +
                "\nplot=" + plot +
                "\nreleaseYear=" + releaseYear +
                "\nrunningTime=" + runningTime +
                "\ngradeID=" + gradeID +
                "\ngradeInKoreaID=" + gradeInKoreaID +
                "\nposter=" + poster +
                "\nreleaseDateInKorea=" + releaseDateInKorea +
                "\nboxOfficeWWGross=" + boxOfficeWWGross +
                "\nboxOfficeUSGross=" + boxOfficeUSGross +
                "\nbudget=" + budget;
    }

    public static final class MovieBuilder {
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


        private MovieBuilder() {
        }

        public static MovieBuilder aMovie() {
            return new MovieBuilder();
        }

        public MovieBuilder withMovieID(String movieID) {
            this.movieID = movieID;
            return this;
        }

        public MovieBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder withKoreanTitle(String koreanTitle) {
            this.koreanTitle = koreanTitle;
            return this;
        }

        public MovieBuilder withPlot(String plot) {
            this.plot = plot;
            return this;
        }

        public MovieBuilder withReleaseYear(String releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public MovieBuilder withRunningTime(String runningTime) {
            this.runningTime = runningTime;
            return this;
        }

        public MovieBuilder withGradeID(String gradeID) {
            this.gradeID = gradeID;
            return this;
        }

        public MovieBuilder withGradeInKoreaID(String gradeInKoreaID) {
            this.gradeInKoreaID = gradeInKoreaID;
            return this;
        }

        public MovieBuilder withPoster(String poster) {
            this.poster = poster;
            return this;
        }

        public MovieBuilder withReleaseDateInKorea(String releaseDateInKorea) {
            this.releaseDateInKorea = releaseDateInKorea;
            return this;
        }

        public MovieBuilder withBoxOfficeWWGross(String boxOfficeWWGross) {
            this.boxOfficeWWGross = boxOfficeWWGross;
            return this;
        }

        public MovieBuilder withBoxOfficeUSGross(String boxOfficeUSGross) {
            this.boxOfficeUSGross = boxOfficeUSGross;
            return this;
        }

        public MovieBuilder withBudget(String budget) {
            this.budget = budget;
            return this;
        }

        public Movie build() {
            Movie movie = new Movie();
            movie.boxOfficeWWGross = this.boxOfficeWWGross;
            movie.runningTime = this.runningTime;
            movie.poster = this.poster;
            movie.releaseDateInKorea = this.releaseDateInKorea;
            movie.boxOfficeUSGross = this.boxOfficeUSGross;
            movie.gradeID = this.gradeID;
            movie.budget = this.budget;
            movie.koreanTitle = this.koreanTitle;
            movie.releaseYear = this.releaseYear;
            movie.gradeInKoreaID = this.gradeInKoreaID;
            movie.movieID = this.movieID;
            movie.plot = this.plot;
            movie.title = this.title;
            return movie;
        }
    }
}
