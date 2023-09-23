package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CsvDictionary implements Dictionary1 {
    private HashMap<String, List<String>> dictionary;
    File file;

    CsvDictionary() {
        dictionary = new HashMap<>();
    }

    @Override
    public void load(String path) { //파일을 한 줄 씩 읽어와서 dictionary에 저장
        file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                storeWords(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾지 못했습니다!");
        }
    }

    public void storeWords(String loadOneLine) {//가져온 문자열을 한국어, 영어로 나누어 저장
        String kor = loadOneLine.substring(0, loadOneLine.indexOf(","));
        String eng = loadOneLine.substring(loadOneLine.indexOf(",") + 1);

        //한글 단어가 있는지 검사
        if (dictionary.containsKey(kor)) {
            dictionary.get(kor).add(eng);
        } else {
            List<String> engMeans = new ArrayList<>();
            engMeans.add(eng);
            dictionary.put(kor, engMeans);
        }
        System.out.println("store in Map: " + dictionary);
    }

    @Override
    public List<String> findEngByKor(String kor) {
        if (dictionary.containsKey(kor)) {
            return dictionary.get(kor);
        } else {
            System.out.printf("%s에 해당하는 값이 사전에 존재하지 않습니다. ");
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
