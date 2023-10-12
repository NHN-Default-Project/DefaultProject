package org.example.parkminsu.dict;


import java.io.IOException;
import java.util.*;

public class Dic2 implements Dictionary2 {
    Map<String, List<String>> dictionary;

    @Override
    public void load(Parser parser, String path) {

        try {

            dictionary = parser.parse(path);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @Override
    public List<String> findEngByKor(String kor) {
        return dictionary.get(kor);
    }

    @Override
    public int count() {
        int cnt = 0;
        for (int i = 0; i < dictionary.size(); i++) {
            cnt++;
        }
        return cnt;
    }

    @Override
    public List<String> findAllEngByKorOrderByHomonymCountDescAndKorDesc() {
        Map<String, Integer> mapEx = new HashMap<>();
        for (Map.Entry<String, List<String>> pair : this.dictionary.entrySet()) {
            mapEx.put(pair.getKey(), pair.getValue().size());
        }
        List<String> resultList = new ArrayList<>();


        List<String> listKeySet = new ArrayList<>(mapEx.keySet());
        Collections.reverse(listKeySet);

        listKeySet.sort((value1, value2) -> (mapEx.get(value2).compareTo(mapEx.get(value1))));

        for (String ex : listKeySet) {
            resultList.addAll(findEngByKor(ex));
        }
        this.dictionary.keySet()
                .stream()
                .map((x) -> dictionary.get(x))
                .forEach(System.out::println);

        return resultList;
    }
}
