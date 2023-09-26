package org.example.gaeun.parseFile;

import java.io.File;
import java.util.*;

public class UpgradeDictionary implements Dictionary2 {
    File file;
    private HashMap<String, List<String>> dictionary;
    String ext = "";

    public Map<String, List<String>> getDictionary() {
        return dictionary;
    }


    @Override
    public void load(FileObject fileObject, String path) {
        file = new File(path);
        String name = file.getName();
        ext = name.substring(name.indexOf(".") + 1); //확장자 저장
        dictionary = fileObject.loadFile(path);

    }

    @Override
    public List<String> findEngByKor(String kor) {
        if (dictionary.containsKey(kor)) {
            return dictionary.get(kor);
        } else {
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

        keySet.sort((o1, o2) -> {
            int compareValue = Integer.compare(dictionary.get(o1).size(), dictionary.get(o2).size());
            if(compareValue == 0) {
                compareValue = o1.compareTo(o2);
            }
            return compareValue;
        });
        Collections.reverse(keySet); //동음이의어 순으로 내림차순
        for(String value : keySet) {
            valueSet.add(dictionary.get(value).toString());
        }

        return valueSet;
    }

}
