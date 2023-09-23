package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UpgradeDictionary implements Dictionary2 {
    File file;
    private HashMap<String, List<String>> dictionary;
    @Override
    public void load(String path) {
        FileLeadWithExtension fileLeadWithExtension = new FileLeadWithExtension(path);
        dictionary = fileLeadWithExtension.loadFileToMap();
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
    public List<String> findAllEngByKorOrderByHomonymCountDescAndKorDesc() {
        List<String> keySet = new ArrayList<>(dictionary.keySet());
        for(List<String> list : dictionary.values()) {
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            Collections.reverse(list);
        }
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return dictionary.get(o1).get(0).compareTo(dictionary.get(o2).get(0));
            }
        });
        System.out.println(dictionary);
        return dictionary.get(0);
    }

}
