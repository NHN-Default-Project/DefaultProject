package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class JsonFile implements FileObject {
    private HashMap<String, List<String>> dictionary;
    File file;

    JsonFile() {
        dictionary = new HashMap<>();
    }

    @Override
    public HashMap<String, List<String>> loadFile(String path) {
        file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String loadOneLine = scanner.nextLine().trim();
                if (loadOneLine.equals("[") || loadOneLine.equals("]") || loadOneLine.equals("},") || loadOneLine.equals("{") || loadOneLine.equals("}")) {
                    continue;
                }
                String kor = loadOneLine.substring(1, loadOneLine.indexOf(":") - 1);
                String eng = loadOneLine.substring(loadOneLine.indexOf(":") + 3, loadOneLine.length() - 1);

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
