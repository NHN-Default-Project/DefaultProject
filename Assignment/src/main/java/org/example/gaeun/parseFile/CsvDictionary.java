package org.example.gaeun.parseFile;

import java.util.*;

public class CsvDictionary implements Dictionary1 {
    public HashMap<String, List<String>> getDictionary() {
        return dictionary;
    }

    private HashMap<String, List<String>> dictionary;
    CsvFile csvFile = new CsvFile();


    @Override
    public void load(String path) { //파일을 한 줄 씩 읽어와서 dictionary에 저장
        dictionary = csvFile.loadFile(path);
    }

    @Override
    public List<String> findEngByKor(String kor) {
        if (dictionary.containsKey(kor)) {
            return dictionary.get(kor);
        } else {
            System.out.printf("%s에 해당하는 값이 사전에 존재하지 않습니다. ", kor);
            System.out.println();
            return Collections.emptyList();
        }
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
