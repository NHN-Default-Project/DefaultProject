package org.example.gaeun.parseFile;

import java.io.File;
import java.util.*;

public class UpgradeDictionary implements Dictionary2 {
    File file;

    public HashMap<String, List<String>> getDictionary() {
        return dictionary;
    }

    private HashMap<String, List<String>> dictionary;
    String ext = "";
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
        return keySet;
    }

}
