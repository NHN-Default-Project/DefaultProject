package org.example;

import java.io.File;
import java.util.*;

public class UpgradeDictionary implements Dictionary2 {
    File file;

    public HashMap<String, List<String>> getDictionary() {
        return dictionary;
    }

    private HashMap<String, List<String>> dictionary;
    CsvFile csvFile = new CsvFile();
    JsonFile jsonFile = new JsonFile();
    String ext = "";
    @Override
    public void load(String path) {
        file = new File(path);
        String name = file.getName();
        ext = name.substring(name.indexOf(".") + 1); //확장자 저장
        switch (ext) {
            case "csv":
                dictionary = csvFile.loadFile(path);
                return;
            case "json":
                dictionary = jsonFile.loadFile(path);
                return;
            default:
                System.out.println("해당되는 확장자 파일을 찾을 수 없습니다.");
        }
    }

    @Override
    public List<String> findEngByKor(String kor) {
        if (dictionary.containsKey(kor)) {
            return dictionary.get(kor);
        } else {
            System.out.printf("%s에 해당하는 값이 사전에 존재하지 않습니다. ",kor);
            System.out.println();
            return Collections.emptyList();
        }
    }

    @Override
    public int count() {
        return dictionary.size();
    }

    @Override
    public List<String> findAllEngByKorOrderByHomonymCountDescAndKorDesc() {
        List<String> keySet = new ArrayList<>(dictionary.keySet());
        List<String> valueSet = new ArrayList<>();
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int compareValue = Integer.compare(dictionary.get(o1).size(), dictionary.get(o2).size());
                if(compareValue == 0) {
                    compareValue = o1.compareTo(o2);
                }
                return compareValue;
            }
        });
        Collections.reverse(keySet); //동음이의어 순으로 내림차순
        for(String key : keySet) {
            for(int i = 0; i < dictionary.get(key).size(); i++) {
                valueSet.add(dictionary.get(key).get(i));
            }
        }
        return valueSet;
    }

}
