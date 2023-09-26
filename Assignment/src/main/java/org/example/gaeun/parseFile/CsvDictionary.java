package org.example.gaeun.parseFile;

import java.util.*;

public class CsvDictionary implements Dictionary1 {


    private Map<String, List<String>> dictionary;
    private CsvFile csvFile;

    public CsvDictionary() {
        csvFile = new CsvFile();
    }

    public Map<String, List<String>> getDictionary() {
        return dictionary;
    }
    @Override
    public void load(String path) { //파일을 한 줄 씩 읽어와서 dictionary에 저장
        dictionary = csvFile.loadFile(path);
    }

    @Override
    public List<String> findEngByKor(String kor) {
        //너무 좋음
        return dictionary.getOrDefault(kor, Collections.emptyList());
    }

    @Override
    public int count() {
        return dictionary.size();
    }

    @Override
    public Set<String> findAllListKor() {
        return dictionary.keySet();
    }
}
