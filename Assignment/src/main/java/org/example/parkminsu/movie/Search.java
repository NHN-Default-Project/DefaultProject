package org.example.parkminsu.movie;

import java.util.List;

public class Search {
    // 실행과정
    /* 1. 중앙의 인덱스 값이 들어감
     * 2. 정렬된 리스트의 왼쪽 오른쪽 값 비교?
     * 3. 한국어 제목 따로 영어 제목 따로 해야하는건가
     *
     * */

    public Movie korSearch(List<Movie> movieList, int idx, String searchMovieName) {
        int check = movieList.get(idx).getKoreaTitle().compareTo(searchMovieName);
        KorTitleComparator korTitleComparator = new KorTitleComparator();
        if (searchMovieName.equals(movieList.get(idx / 2).getKoreaTitle())) {
            return movieList.get(idx / 2);
        }
        System.out.println(check);
        return movieList.get(idx);
    }
}
