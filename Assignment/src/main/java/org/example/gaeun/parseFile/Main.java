package org.example.gaeun.parseFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvDictionary csvDictionary = new CsvDictionary();
        csvDictionary.load("Assignment/src/test/resources/test2.csv");

        System.out.println(csvDictionary.getDictionary());
        System.out.println("searching word: " + csvDictionary.findEngByKor("한국"));
        System.out.println("total key size: " + csvDictionary.count());
        System.out.println("key Set is: " + csvDictionary.findAllListKor());

        UpgradeDictionary upgradeDictionary = new UpgradeDictionary();
        String pathTest4 = "Assignment/src/test/resources/test4.json";
        upgradeDictionary.load(getExtensionObj(pathTest4), pathTest4);
        System.out.println(upgradeDictionary.getDictionary());
        System.out.println("searching word: " + upgradeDictionary.findEngByKor("한국"));
        System.out.println("total key size: " + upgradeDictionary.count());
        System.out.println("sorted: " + upgradeDictionary.findAllEngByKorOrderByHomonymCountDescAndKorDesc());
    }

    public static FileObject getExtensionObj(String path) {
        File file = new File(path);
        String name = file.getName();
        String ext = name.substring(name.indexOf(".") + 1); //확장자 저장

        switch (ext) {
            case "csv":
                return new CsvFile();
            case "json":
                return new JsonFile();
            default:
                System.out.println("해당되는 확장자 파일을 찾을 수 없습니다.");
                return new FileObject() {
                    @Override
                    public HashMap<String, List<String>> loadFile(String path) {
                        return null;
                    }
                };
        }
    }
}
