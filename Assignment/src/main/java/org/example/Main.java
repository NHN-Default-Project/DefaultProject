package org.example;

public class Main {
    public static void main(String[] args) {
//        CsvDictionary csvDictionary = new CsvDictionary();
//        csvDictionary.load("Assignment/src/test/resources/test2.csv");
//
//        System.out.println("searching word: " + csvDictionary.findEngByKor("한국"));
//        System.out.println("total key size: " + csvDictionary.count());
//        System.out.println("key Set is: " + csvDictionary.findAllListKor());

        UpgradeDictionary upgradeDictionary = new UpgradeDictionary();
        upgradeDictionary.load("Assignment/src/test/resources/test2.csv");
        upgradeDictionary.load("Assignment/src/test/resources/test3.json");
        System.out.println("sorted: " + upgradeDictionary.findAllEngByKorOrderByHomonymCountDescAndKorDesc());
    }
}
