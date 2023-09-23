package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileLeadWithExtension { //파일의 확장자에 따른 파일 읽어서 HashMap생성
    File file;
    private HashMap<String, List<String>> dictionary;
    private String ext;

    FileLeadWithExtension(String path) { //생성자
        dictionary = new HashMap<>();
        file = new File(path);
        String name = file.getName();
        ext = name.substring(name.indexOf(".") + 1); //확장자 저장
    }

    public HashMap<String, List<String>> loadFileToMap() {
        switch (ext) {
            case "csv":
                loadCSV();
                return dictionary;
            case "json":
                loadJSON();
                return dictionary;
            default:
                return dictionary;
        }

    }

    public void loadCSV() { //파일을 한 줄 씩 읽어와서 dictionary에 저장
        try {
            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine()) {
                storeWordsCSV(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾지 못했습니다!");
        }
    }

    public void storeWordsCSV(String loadOneLine) {//가져온 문자열을 한국어, 영어로 나누어 저장
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

    public void loadJSON() {
        try {
            Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine()) {
                storeWordsJSON(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾지 못했습니다!");
        }
    }

    public void storeWordsJSON(String loadOneLine) {
        loadOneLine = loadOneLine.trim();
        if (loadOneLine.equals("[") || loadOneLine.equals("]") || loadOneLine.equals("},") || loadOneLine.equals("{") || loadOneLine.equals("}")) {
            return;
        }
        System.out.println(loadOneLine);
        String kor = loadOneLine.substring(1, loadOneLine.indexOf(":")-1);
        String eng = loadOneLine.substring(loadOneLine.indexOf(":") + 3, loadOneLine.length()-1);

        if (dictionary.containsKey(kor)) {
            dictionary.get(kor).add(eng);
        } else {
            List<String> engMeans = new ArrayList<>();
            engMeans.add(eng);
            dictionary.put(kor, engMeans);
        }
        System.out.println("store in Map: " + dictionary);
    }
}
