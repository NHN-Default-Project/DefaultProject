package org.example.parkminsu.movie;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    List<Movie> dataList;

    public Parser() {
        this.dataList = new ArrayList<>();
    }

    public List<Movie> parser(List<String> fileData) {
        for (int i = 0; i < fileData.size(); i++) {
            String[] str = fileData.get(i).split(";"); // 파일 데이터 스플릿

            Movie movie = new Movie(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9], str[10], str[11], str[12]);
            this.dataList.add(movie);
        }
        return this.dataList;
    }

    public List<Movie> getDataList() {
        return dataList;
    }

}
