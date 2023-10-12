package org.example.parkminsu.dict;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Dictionary implements Dictionary1 {
    Map<String, List<String>> dictionary;

    @Override
    public void load(String path) {
        String line = "";
        dictionary = new HashMap<>(); // hash : 단방향, 해시는 고정된 길이
        // hash 함수 :
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] strArr = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                List<String> list = dictionary.getOrDefault(strArr[0], new ArrayList<>());

                list.add(strArr[1]);

                dictionary.putIfAbsent(strArr[0], list);

            }
        } catch (IOException e) {
            System.out.println("에러 발생");
        } catch (NullPointerException e) {
            System.out.println("null pointer exception");
        }
    }


    public Map<String, List<String>> getDictionary() {
        return dictionary;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "dictionary=" + dictionary +
                '}';
    }

    @Override
    public List<String> findEngByKor(String kor) {
        return dictionary.get(kor);
    }


    @Override
    public int count() {
//        int cnt = 0;
//        for (int i = 0; i < dictionary.size(); i++) {
//            cnt++;
//        }
        return dictionary.size();
    }

    @Override
    public Collection<String> findAllListKor() {
        return dictionary.keySet();
    }
}
