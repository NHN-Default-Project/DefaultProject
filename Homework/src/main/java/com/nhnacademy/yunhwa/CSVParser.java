package com.nhnacademy.yunhwa;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CSVParser implements Parser {
    @Override
    public Map<String, List<String>> parse(String path) {
        Map<String, List<String>> parsedDatas = new HashMap<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(path), StandardCharsets.UTF_8);) {
            // 2. csv 파일인 경우
            // 대상 csv 파일의 경로 파라미터로 들어온 값 path 로 설정

            // csv 파일에서 읽어들인 1행분의 데이터
            String line = "";

            while ((line = br.readLine()) != null) {
                // csv 파일의 1행을 저장하는 리스트 변수
                String[] lineContentsArr = line.split(",");
                if (parsedDatas.containsKey(lineContentsArr[0])) {
                    parsedDatas.get(lineContentsArr[0]).add(lineContentsArr[1]);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(lineContentsArr[1]);
                    parsedDatas.put(lineContentsArr[0], list);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return parsedDatas;
    }
}