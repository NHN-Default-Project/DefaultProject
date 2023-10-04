package org.example.yunhwa.moviesCsv;

public class MovieIdComparator extends MovieComparator { // id 숫자 오름차순
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getMovieID() - o2.getMovieID();
    } // int
}

class TitleComparator extends MovieComparator { // title 영어 알파벳 오름차순으로
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    } // String

}

class KoreanTitleComparator extends MovieComparator { // KoreanTitle 영어 알파벳 오름차순으로
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getKoreanTitle().compareTo(o2.getKoreanTitle());
    } // String

}

class PlotComparator extends MovieComparator { // Plot 영어 알파벳 오름차순으로
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getPlot().compareTo(o2.getPlot());
    } // String

}

class ReleaseYearComparator extends MovieComparator { // ReleaseYear 연도는 오름차순으로 (옛날에서 최신순)
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getReleaseYear() - o2.getReleaseYear();
    } // int

}

class RunningTimeComparator extends MovieComparator { // RunningTime 영화 총 시간 오름차순으로
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getRunningTime() - o2.getRunningTime();
    } // int

}

class GradeIDComparator extends MovieComparator { // GradeID 등급 오름차순으로
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getGradeID() - o2.getGradeID();
    } // int

}

class GradeInKoreanIDComparator extends MovieComparator { // 한국 GradeID 등급 오름차순으로
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getGradeInKoreanID() - o2.getGradeInKoreanID();
    } // int

}

class PosterComparator extends MovieComparator { // 포스터 문자열 오름차순으로
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getPoster().compareTo(o2.getPoster());
    } // String

}

class ReleaseDateInKoreaComparator extends MovieComparator { // 발매 Date 오름차순으로
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getReleaseDateInKorea().compareTo(o2.getReleaseDateInKorea());
    } // Date 0000-00-00

}

class BoxOfficeWWGrossComparator extends MovieComparator { // 박스 오피스 전세계 매출 총이익 내림차순
    @Override
    public int compare(Movie o1, Movie o2) {
        return Long.valueOf(o2.getBoxOfficeWWGross() - o1.getBoxOfficeWWGross()).intValue();
    } // long

}

class BoxOfficeUSGrossComparator extends MovieComparator { // 박스 오피스 미국 매출 총이익 내림차순
    @Override
    public int compare(Movie o1, Movie o2) {
        return Long.valueOf(o2.getBoxOfficeUSGross() - o1.getBoxOfficeUSGross()).intValue();
    } // long
}

class BudgetComparator extends MovieComparator { // 예산 오름차순
    @Override
    public int compare(Movie o1, Movie o2) {
        return Long.valueOf(o1.getBudget() - o2.getBudget()).intValue();
    } // long

}