package org.example.Jminsoo.dict.Excercise2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvParser implements Parser {
    @Override
    public Map<String, List<String>> parse(String path) {
        File file = new File(path);
        Map<String, List<String>> result = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            List<String> tempList;

            while ((line = br.readLine()) != null) {
                String[] str = line.split(",");
                tempList = result.getOrDefault(str[0], new ArrayList<>());

                tempList.add(str[1]);
                result.put(str[0], tempList);
            }

        } catch (NullPointerException | IOException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("파일을 읽어들일 수 없습니다!");
        }
        return result;
    }
}
