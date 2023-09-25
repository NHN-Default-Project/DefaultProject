package org.example.gaeun.parseFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CsvFile implements FileObject {
    private HashMap<String, List<String>> dictionary;
    File file;

    CsvFile() {
        dictionary = new HashMap<>();
    }

    @Override
    public HashMap<String, List<String>> loadFile(String path) {
        file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String loadOneLine = scanner.nextLine();
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
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾지 못했습니다!");
        }
        return dictionary;
    }
}